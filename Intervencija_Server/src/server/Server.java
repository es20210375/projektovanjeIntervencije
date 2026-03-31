/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import niti.ObradaKlijentskihZahteva;

/**
 *
 * @author Emilija
 */
public class Server extends Thread{
    ServerSocket serverskiSoket;
    boolean kraj=false;

    @Override
    public void run() {
          try {
            serverskiSoket=new ServerSocket(9000);
            while(!kraj){
                Socket socket=serverskiSoket.accept();
                System.out.println("Klijent je uspesno povezan");
                ObradaKlijentskihZahteva okz=new ObradaKlijentskihZahteva(socket);
                okz.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
     
    
    
    public void prekiniServer(){
        try {
            kraj=true;
            serverskiSoket.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}
