/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import controller.Controller;
import domen.MedicinskiRadnik;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.OutputKeys;
import komunikacija.Odgovor;
import komunikacija.Posiljalac;
import komunikacija.Primalac;
import komunikacija.Zahtev;

/**
 *
 * @author Emilija
 */
public class ObradaKlijentskihZahteva extends Thread {
    Socket socket;
    Posiljalac posiljalac;
    Primalac primalac;

    public ObradaKlijentskihZahteva(Socket socket) {
        this.socket=socket;
        posiljalac=new Posiljalac(socket);
        primalac=new Primalac(socket);
    }

    @Override
    public void run() {
        while(true){
            try {
                Zahtev zahtev=(Zahtev) primalac.primi();
                Odgovor odgovor=new Odgovor();
                switch (zahtev.getOperacija()) {
                    case LOGIN:
                        MedicinskiRadnik mr=(MedicinskiRadnik) zahtev.getParametar();
                        mr=Controller.getInstance().logIn(mr);
                        odgovor.setOdgovor(mr);
                        break;
                    default:
                        System.out.println("Greska, izabrana operacija ne postoji");
                }
                posiljalac.posalji(odgovor);
            } catch (Exception ex) {
                Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
}
