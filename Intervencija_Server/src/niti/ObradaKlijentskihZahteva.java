/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import controller.Controller;
import domen.Intervencija;
import domen.Kvalifikacija;
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
                    case DODAJ_KVALIFIKACIJU:
                        try{
                        Kvalifikacija kv=(Kvalifikacija) zahtev.getParametar();
                        Controller.getInstance().dodajKvalifikaciju(kv);
                        odgovor.setOdgovor(null);
                        }catch(Exception e){
                            odgovor.setOdgovor(e);
                        }
                        break;
                    case UCITAJ_PACIJENTE:
                    
                        try {
                            List<Pacijent>lista=Controller.getInstance().ucitajPacijente();
                            odgovor.setOdgovor(lista);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        break;
                    case IZBRISI_PACIJENTA:
                        try{
                        Pacijent p=(Pacijent) zahtev.getParametar();
                        Controller.getInstance().izbrisiPacijenta(p);
                        odgovor.setOdgovor(null);
                        }catch(Exception e){
                           odgovor.setOdgovor(e); 
                        }
                        break;
                    case KREIRAJ_PACIJENTA:
                        try{
                            Pacijent p=(Pacijent) zahtev.getParametar();
                            p=Controller.getInstance().kreirajPacijenta(p);
                            odgovor.setOdgovor(null);
                        }catch(Exception e){
                            odgovor.setOdgovor(e);
                        }
                        break;
                    case IZMENI_PACIJENTA:
                        try{
                         Pacijent p=(Pacijent) zahtev.getParametar();
                          Controller.getInstance().izmeniPacijenta(p);
                          odgovor.setOdgovor(null);
                        }catch(Exception e){
                            odgovor.setOdgovor(e);
                        }
                        break;
                    case UCITAJ_MEDICINSKE_RADNIKE:
                    {
                        try {
                            List<MedicinskiRadnik>lista=Controller.getInstance().ucitajMedicinskeRadnike();
                            odgovor.setOdgovor(lista);
                        } catch (Exception ex) {
                            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }     
                     break;
                    case UCITAJ_INTERVENCIJE:
                    {
                        try {
                            List<Intervencija>lista=Controller.getInstance().ucitajIntervencije();
                            odgovor.setOdgovor(lista);
                        } catch (Exception ex) {
                            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                        break;


                    default:
                        System.out.println("Greska, izabrana operacija ne postoji");
                }
                posiljalac.posalji(odgovor);
            
        }
    }
    
    
    
    
    
    
    
    
    
    
    
}
