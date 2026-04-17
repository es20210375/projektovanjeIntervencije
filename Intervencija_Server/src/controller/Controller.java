/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.Intervencija;
import domen.Karton;
import domen.Kvalifikacija;
import domen.MedicinskiRadnik;
import domen.Osiguranje;
import domen.Pacijent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import soperacije.intervencija.UcitajIntervencijeOperacija;
import soperacije.karton.DodajKartonOperacija;
import soperacije.karton.UcitajKartonOdredjenogOperacija;
import soperacije.karton.UcitajKartoneOperacija;
import soperacije.kvalifikacija.DodajKvalifikacijuOperacija;
import soperacije.login.LogInOperacija;
import soperacije.medicinskiradnik.UcitajMedicinskeRadnikeOperacija;
import soperacije.osiguranje.UcitajOsiguranjeOperacija;
import soperacije.pacijent.DodajPacijentaOperacija;
import soperacije.pacijent.IzbrisiPacijentaOperacija;
import soperacije.pacijent.IzmeniPacijentaOperacija;
import soperacije.pacijent.UcitajPacijenteOperacija;

/**
 *
 * @author Emilija
 */
public class Controller {
    private static  Controller instance;
    List<Pacijent>listaPacijenata=new ArrayList<>();
    Pacijent pacijent;
    List<Karton>listaKartona=new ArrayList<>();
    public static Controller getInstance(){
        if(instance==null){
            instance=new Controller();
        }return instance;
    }
    private Controller() {
    }

    public MedicinskiRadnik logIn(MedicinskiRadnik mr) throws Exception {
       LogInOperacija lo=new LogInOperacija();
       lo.izvrsiOperaciju(mr, null);
        System.out.println("Klasa controller : "+lo.getMr());
       return lo.getMr();
    }

    public void dodajPacijenta(Pacijent p) {
        try {
            DodajPacijentaOperacija dpo=new DodajPacijentaOperacija();
            dpo.izvrsi(p, null);
            dodajPacijentaUlistu(p);
            
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public List<Osiguranje> ucitajOsiguranje() throws Exception {
        UcitajOsiguranjeOperacija uoo=new UcitajOsiguranjeOperacija();
        uoo.izvrsi(null, null);
        return uoo.getLista();
    }

    public void dodajKvalifikaciju(Kvalifikacija kv) throws Exception {
       DodajKvalifikacijuOperacija dko=new DodajKvalifikacijuOperacija();
       dko.izvrsi(kv, null);
    }

    public List<Pacijent> ucitajPacijente() throws Exception {
       UcitajPacijenteOperacija upo=new UcitajPacijenteOperacija();
       upo.izvrsi(null, null);
       return upo.getLista();
    }

    public void izbrisiPacijenta(Pacijent p) throws Exception {
        IzbrisiPacijentaOperacija ipo=new IzbrisiPacijentaOperacija();
        ipo.izvrsi(p, null);
        
    }


    private void dodajPacijentaUlistu(Pacijent p) {
        for (Pacijent pac : listaPacijenata) {
            if(pac==null){
                pac=p;
                listaPacijenata.add(pac);
            }
        }
            System.out.println("Klasa Controller listaPacijenataLOKALNO: "+listaPacijenata);
    }

    public Pacijent kreirajPacijenta() throws Exception {
        try{
         pacijent=new Pacijent();
               listaPacijenata.add(pacijent);
        }catch(Exception e){
            throw  new Exception("Sistem ne moze da kreira pacijenta");
        }
               return null;
        
    }

    public void izmeniPacijenta(Pacijent p) throws Exception {
        IzmeniPacijentaOperacija iop=new IzmeniPacijentaOperacija();
        iop.izvrsi(p, null);
    }

    public List<MedicinskiRadnik> ucitajMedicinskeRadnike() throws Exception {
        UcitajMedicinskeRadnikeOperacija umro=new UcitajMedicinskeRadnikeOperacija();
        umro.izvrsi(null, null);
        return umro.getLista();
        
    }

    public List<Intervencija> ucitajIntervencije() throws Exception {
       UcitajIntervencijeOperacija uio=new UcitajIntervencijeOperacija();
       uio.izvrsi(null, null);
       return uio.getLista();
    }

    public List<Karton> ucitajKartone() throws Exception {
       UcitajKartoneOperacija uko=new UcitajKartoneOperacija();
       uko.izvrsi(null, null);
       return uko.getLista();
    }

    public void dodajKarton(Karton k) throws Exception {
        DodajKartonOperacija dko=new DodajKartonOperacija();
        System.out.println("controller.Controller.dodajKarton()"+k);
        dko.izvrsi(k, null);
    }

    public List<Karton> ucitajKartonOdredjenog(int id) throws Exception {
        UcitajKartonOdredjenogOperacija ukoo=new UcitajKartonOdredjenogOperacija();
        ukoo.izvrsi(id, null);
        return ukoo.getLista();
    }

    
    
    
}
