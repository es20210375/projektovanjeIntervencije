/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import controller.Controller;
import domen.MedicinskiRadnik;
import domen.Osiguranje;
import domen.Pacijent;
import java.net.Socket;
import java.util.List;
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
            
                Zahtev zahtev=(Zahtev) primalac.primi();
                Odgovor odgovor=new Odgovor();
                switch (zahtev.getOperacija()) {
                    case LOGIN:
                        try{
                        MedicinskiRadnik mr=(MedicinskiRadnik) zahtev.getParametar();
                        mr=Controller.getInstance().logIn(mr);
                        odgovor.setOdgovor(mr);
                        }
                        catch(Exception e){
                            odgovor.setOdgovor(e);
                        }
                        break;
                    case DODAJ_PACIJENTA:
                        try{
                           Pacijent p=(Pacijent) zahtev.getParametar();
                        Controller.getInstance().dodajPacijenta(p);
                        odgovor.setOdgovor(null); 
                            System.out.println();
                        }catch(Exception e){
                            e.printStackTrace();
                            odgovor.setOdgovor(e);
                        }
                        
                        break;
                    case UCITAJ_OSIGURANJE:
                        try{
                        List<Osiguranje>lista=Controller.getInstance().ucitajOsiguranje();
                        odgovor.setOdgovor(lista);
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                        break;
                    default:
                        System.out.println("Greska, izabrana operacija ne postoji");
                }
                posiljalac.posalji(odgovor);
            
        }
    }
    
    
    
    
    
    
    
    
    
    
    
}
