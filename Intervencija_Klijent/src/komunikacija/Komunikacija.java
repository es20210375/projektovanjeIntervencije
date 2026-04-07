/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import domen.MedicinskiRadnik;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emilija
 */
public class Komunikacija {
    private Socket socket;
    private static Komunikacija instance;
    private Posiljalac posiljalac;
    private Primalac primalac;
    private Komunikacija() {
    }
    public static Komunikacija getInstance(){
        if(instance==null){
            instance=new Komunikacija();
        }return instance;
    }
    public void komunikacija(){
        try {
            socket=new Socket("localhost",9000);
            posiljalac=new Posiljalac(socket);
            primalac=new Primalac(socket);
        } catch (IOException ex) {
            System.out.println("Server nije povezan");
            ex.printStackTrace();
            
        }
        
    }

    public MedicinskiRadnik logIn(String email, String password) {
       MedicinskiRadnik mr=new MedicinskiRadnik(-1, null, null, true, email, password);
       Zahtev z=new Zahtev(Operacije.LOGIN, mr);
       posiljalac.posalji(z);
       Odgovor odg=(Odgovor) primalac.primi();
       mr=(MedicinskiRadnik) odg.getOdgovor();
       return mr;
    }

   
    
}
