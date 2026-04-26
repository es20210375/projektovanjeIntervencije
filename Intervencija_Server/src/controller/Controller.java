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
import domen.StavkaKartona;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import niti.ObradaKlijentskihZahteva;
import soperacije.intervencija.DodajIntervencijuOperacija;
import soperacije.intervencija.UcitajIntervencijeOperacija;
import soperacije.karton.DodajKartonOperacija;
import soperacije.karton.IzmeniKartonOperacija;
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
import soperacije.stavkaKartona.DodajStavkuKartona;
import soperacije.stavkaKartona.IzmeniStavkuKartonaOperacija;
import soperacije.stavkaKartona.UcitajStavkeKartonaOperacija;

/**
 *
 * @author Emilija
 */
public class Controller {
    private static  Controller instance;
    List<Pacijent>listaPacijenata=new ArrayList<>();
    Pacijent pacijent;
    List<Karton>listaKartona=new ArrayList<>();
    List<ObradaKlijentskihZahteva>okz=new ArrayList();
    List<Intervencija>listaIntervencija=new ArrayList<>();
    List<StavkaKartona>listaStavki=new ArrayList<>();
    Intervencija inter;
    StavkaKartona st;
    Karton k;
    
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
       if (upo.getLista() == null) {
        return new ArrayList<>();
    }
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

    public Karton dodajKarton(Karton k) throws Exception {
        DodajKartonOperacija dko=new DodajKartonOperacija();
        System.out.println("controller.Controller.dodajKarton()"+k);
        dodajUListuKartona(k);
        dko.izvrsi(k, null);
        return dko.getK();
    }

    public List<Karton> ucitajKartonOdredjenog(int id) throws Exception {
        UcitajKartonOdredjenogOperacija ukoo=new UcitajKartonOdredjenogOperacija();
        ukoo.izvrsi(id, null);
        return ukoo.getLista();
    }

    public void dodajIntervenciju(Intervencija inter) throws Exception {
        DodajIntervencijuOperacija dio=new DodajIntervencijuOperacija();
        System.out.println("controller.Controller.dodajIntervenciju()" + inter);
        dodajUListuIntervencija(inter);
        dio.izvrsi(inter, null);
    }

    public List<StavkaKartona> ucitajStavkeKartona() throws Exception {
        UcitajStavkeKartonaOperacija usko=new UcitajStavkeKartonaOperacija();
        usko.izvrsi(null, null);
        return usko.getLista();
    }

    public void dodajStavkuKartona(StavkaKartona s) throws Exception {
        DodajStavkuKartona dsk=new DodajStavkuKartona();
        System.out.println("controller.Controller.dodajStavkuKartona()"+s);
        dodajUListuStavki(s);
        dsk.izvrsi(s, null);
    }

    public List<ObradaKlijentskihZahteva> getOkz() {
        return okz;
    }

    public void setOkz(List<ObradaKlijentskihZahteva> okz) {
        this.okz = okz;
    }

    public void kreirajKarton() throws Exception {
        try{
         k=new Karton();
         inter=new Intervencija();
         st=new StavkaKartona();
        }catch(Exception e){
            throw  new Exception("Sistem ne moze da kreira karton");
        }
           
        
       
    }

    private void dodajUListuKartona(Karton k) {
    for (Karton kar : listaKartona) {
            if(kar==null){
                kar=k;
                listaKartona.add(kar);
            }
        }
            System.out.println("Klasa Controller listaKartonaLOKALNO: "+listaKartona);
    }

    private void dodajUListuIntervencija(Intervencija inter) {
      for (Intervencija in : listaIntervencija) {
            if(in==null){
                in=inter;
                listaIntervencija.add(in);
            }
        }
            System.out.println("Klasa Controller listaIntervencijaLOKALNO: "+listaIntervencija);
    }
    

    private void dodajUListuStavki(StavkaKartona s) {
         for (StavkaKartona stav : listaStavki) {
            if(stav==null){
                stav=s;
                listaStavki.add(stav);
            }
        }
            System.out.println("Klasa Controller listaStavkiLOKALNO: "+listaStavki);
    }

    public void izmeniKarton(Karton k) throws Exception {
        IzmeniKartonOperacija iko=new IzmeniKartonOperacija();
        System.out.println("controller.Controller.izmeniKarton()"+k);
      iko.izvrsi(k,null);
    }

    public void izmeniStavku(StavkaKartona s) throws Exception {
        IzmeniStavkuKartonaOperacija isko=new IzmeniStavkuKartonaOperacija();
        System.out.println("controller.Controller.izmeniStavku()"+s);
        isko.izvrsi(s,null);
    }

    public boolean odjavi(MedicinskiRadnik odjava) {
        for (int i = 0; i < okz.size(); i++) {
            if(okz.get(i).getPrijavljeni() != null && okz.get(i).getPrijavljeni().equals(odjava)){
                System.out.println("controller.Controller.odjavi()"+i);
                okz.remove(i);
                return true;
            }
        }
        return false;
    }

    

    
}
