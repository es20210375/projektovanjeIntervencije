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
import soperacije.intervencija.UbaciIntervencijuOperacija;
import soperacije.intervencija.VratiListuSviIntervencijeOperacija;
import soperacije.karton.UbaciKartonOperacija;
import soperacije.karton.IzmeniKartonOperacija;
import soperacije.karton.IzmeniKartonSaStavkamaOperacija;
import soperacije.karton.PretraziKartonOperacija;
import soperacije.karton.VratiListuSviKartoniOperacija;
import soperacije.karton.VratiListuKartonKriterijumIntervencijaOperacija;
import soperacije.karton.VratiListuKartonKriterijumKartonOpertacija;
import soperacije.karton.VratiListuKartonKriterijumMedicinskiRadnikImeOperacija;
import soperacije.karton.VratiListuKartonKriterijumMedicinskiRadnikImePrezimeOperacija;
import soperacije.karton.VratiListuKartonKriterijumPacijentImeOperacija;
import soperacije.karton.VratiListuKartonKriterijumPacijentImePrezimeOperacija;
import soperacije.kvalifikacija.UbaciKvalifikacijuOperacija;
import soperacije.login.LogInOperacija;
import soperacije.medicinskiradnik.VratiListuSviMedicinskiRadnikOperacija;
import soperacije.osiguranje.VratiListuSviOsiguranjeOperacija;
import soperacije.pacijent.UbaciPacijentaOperacija;
import soperacije.pacijent.OzbrisiPacijentaOperacija;
import soperacije.pacijent.PromeniPacijentaOperacija;
import soperacije.pacijent.PretraziPacijentaOperacija;
import soperacije.pacijent.VratiListuSviPacijentiOperacija;
import soperacije.pacijent.VratiPacijenteKriterijumImeOperacija;
import soperacije.pacijent.VratiPacijenteKriterijumImeOsiguranjeDaOperacija;
import soperacije.pacijent.VratiPacijenteKriterijumImeOsiguranjeNeOperacija;
import soperacije.pacijent.VratiPacijenteKriterijumImePrezimeOperacija;
import soperacije.pacijent.VratiPacijenteKriterijumStatusDaOperacija;
import soperacije.pacijent.VratiPacijenteKriterijumStatusNeOperacija;


/**
 *
 * @author Emilija
 */
public class Controller {
    private static  Controller instance;
    
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

    public void ubaciPacijenta(Pacijent p) throws Exception{
        
            UbaciPacijentaOperacija dpo=new UbaciPacijentaOperacija();
            dpo.izvrsi(p, null);
            
       
        
    }

    public List<Osiguranje> vratiListuSviOsiguranje() throws Exception {
        VratiListuSviOsiguranjeOperacija uoo=new VratiListuSviOsiguranjeOperacija();
        uoo.izvrsi(null, null);
        return uoo.getLista();
    }

    public void dodajKvalifikaciju(Kvalifikacija kv) throws Exception {
       UbaciKvalifikacijuOperacija dko=new UbaciKvalifikacijuOperacija();
       dko.izvrsi(kv, null);
    }

    public List<Pacijent> ucitajPacijente() throws Exception {
       VratiListuSviPacijentiOperacija upo=new VratiListuSviPacijentiOperacija();
       upo.izvrsi(null, null);
       if (upo.getLista() == null) {
        return new ArrayList<>();
    }
       return upo.getLista();
    }

    public void izbrisiPacijenta(Pacijent p) throws Exception {
        OzbrisiPacijentaOperacija ipo=new OzbrisiPacijentaOperacija();
        ipo.izvrsi(p, null);
        
    }


    

    

    public void izmeniPacijenta(Pacijent p) throws Exception {
        PromeniPacijentaOperacija iop=new PromeniPacijentaOperacija();
        iop.izvrsi(p, null);
    }

    public List<MedicinskiRadnik> ucitajMedicinskeRadnike() throws Exception {
        VratiListuSviMedicinskiRadnikOperacija umro=new VratiListuSviMedicinskiRadnikOperacija();
        umro.izvrsi(null, null);
        return umro.getLista();
        
    }

    public List<Intervencija> ucitajIntervencije() throws Exception {
       VratiListuSviIntervencijeOperacija uio=new VratiListuSviIntervencijeOperacija();
       uio.izvrsi(null, null);
       return uio.getLista();
    }

    public List<Karton> ucitajKartone() throws Exception {
       VratiListuSviKartoniOperacija uko=new VratiListuSviKartoniOperacija();
       uko.izvrsi(null, null);
       return uko.getLista();
    }

    public Karton dodajKarton(Karton k) throws Exception {
        UbaciKartonOperacija dko=new UbaciKartonOperacija();
        System.out.println("controller.Controller.dodajKarton()"+k);
        
        dko.izvrsi(k, null);
        return dko.getK();
    }

    

    public void dodajIntervenciju(Intervencija inter) throws Exception {
        UbaciIntervencijuOperacija dio=new UbaciIntervencijuOperacija();
        System.out.println("controller.Controller.dodajIntervenciju()" + inter);
        
        dio.izvrsi(inter, null);
    }

   

    public List<ObradaKlijentskihZahteva> getOkz() {
        return okz;
    }

    public void setOkz(List<ObradaKlijentskihZahteva> okz) {
        this.okz = okz;
    }

    

   

    

    

    public void izmeniKarton(Karton k) throws Exception {
        IzmeniKartonOperacija iko=new IzmeniKartonOperacija();
        System.out.println("controller.Controller.izmeniKarton()"+k);
      iko.izvrsi(k,null);
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

    

    public List<Pacijent> vratiPacijenteSaKriterijumomStatusDa() throws Exception {
         VratiPacijenteKriterijumStatusDaOperacija vpk=new VratiPacijenteKriterijumStatusDaOperacija();
         vpk.izvrsi(null, null);
         return vpk.getLista();
    }

    public List<Pacijent> vratiPacijenteSaKriterijumomStatusNe() throws Exception {
        VratiPacijenteKriterijumStatusNeOperacija vpksn=new VratiPacijenteKriterijumStatusNeOperacija();
        vpksn.izvrsi(null, null);
        return vpksn.getLista();
    }

    

    public List<Pacijent> vratiPacijenteKriterijumIme(String ime) throws Exception {
        VratiPacijenteKriterijumImeOperacija vpki=new VratiPacijenteKriterijumImeOperacija();
        vpki.izvrsi(ime, null);
        return vpki.getLista();
    }

    public List<Pacijent> vratiPacijenteKriterijumImePrezime(String tekst) throws Exception {
        VratiPacijenteKriterijumImePrezimeOperacija vpkip=new VratiPacijenteKriterijumImePrezimeOperacija();
        vpkip.izvrsi(tekst, null);
        return vpkip.getLista();
    }

    public List<Karton> vratiKartoneKriterijumKarton(int godina) throws Exception {
        VratiListuKartonKriterijumKartonOpertacija vlkkko=new VratiListuKartonKriterijumKartonOpertacija();
        vlkkko.izvrsi(godina, null);
        return vlkkko.getLista();
    }

    public List<Karton> vratiKartoneKriterijumPacijentIme(String ime) throws Exception {
        VratiListuKartonKriterijumPacijentImeOperacija vlkkio=new VratiListuKartonKriterijumPacijentImeOperacija();
        vlkkio.izvrsi(ime, null);
        return vlkkio.getLista();
    }

    public List<Karton> vratiKartoneKriterijumPacijentImePrezime(String tekst) throws Exception {
        VratiListuKartonKriterijumPacijentImePrezimeOperacija vpkipo=new VratiListuKartonKriterijumPacijentImePrezimeOperacija();
        vpkipo.izvrsi(tekst, null);
        return vpkipo.getLista();
    }

    public List<Karton> vratiKartoneKriterijumMedicinskiRadnikIme(String ime) throws Exception {
        VratiListuKartonKriterijumMedicinskiRadnikImeOperacija vlkkmr=new VratiListuKartonKriterijumMedicinskiRadnikImeOperacija();
        vlkkmr.izvrsi(ime, null);
        return vlkkmr.getLista();
    
    }

    public List<Karton> vratiKartoneKriterijumMedicinskiRadnikImePrezime(String tekst) throws Exception {
        VratiListuKartonKriterijumMedicinskiRadnikImePrezimeOperacija vlkkimo=new VratiListuKartonKriterijumMedicinskiRadnikImePrezimeOperacija();
        vlkkimo.izvrsi(tekst, null);
        return vlkkimo.getLista();
    
    
    }

    public List<Karton> vratiKartoneKriterijumIntervencija(String tekst) throws Exception {
        VratiListuKartonKriterijumIntervencijaOperacija vlkio=new VratiListuKartonKriterijumIntervencijaOperacija();
        vlkio.izvrsi(tekst, null);
        return vlkio.getLista();
    
    }

    public Karton pretraziKarton(int id) throws Exception {
        PretraziKartonOperacija pko=new PretraziKartonOperacija();
        pko.izvrsi(id, null);
        System.out.println("controller.Controller.pretraziKarton()"+pko.getK());
        return pko.getK();
    }

    public Pacijent pretraziPacijenta(int idp) throws Exception {
        PretraziPacijentaOperacija ppo=new PretraziPacijentaOperacija();
        ppo.izvrsi(idp, null);
        return ppo.getPac();
    }

    public List<Pacijent> vratiPacijenteKriterijumImeOsiguranjeDa(String ime) throws Exception {
         VratiPacijenteKriterijumImeOsiguranjeDaOperacija vpkiod=new VratiPacijenteKriterijumImeOsiguranjeDaOperacija();
         vpkiod.izvrsi(ime, null);
         return vpkiod.getPac();
    }

    public List<Pacijent> vratiPacijenteKriterijumImeOsiguranjeNe(String ime) throws Exception {
    VratiPacijenteKriterijumImeOsiguranjeNeOperacija vpkion=new VratiPacijenteKriterijumImeOsiguranjeNeOperacija();
    vpkion.izvrsi(ime, null);
    return vpkion.getPac();
    }

    public Karton sacuvajKarton(Karton k) throws Exception {
        UbaciKartonOperacija sko=new UbaciKartonOperacija();
        sko.izvrsi(k, null);
        return sko.getK();
    }

    public Karton izmeniKartonSaStavkama(Karton karton) throws Exception {
     IzmeniKartonSaStavkamaOperacija ikss=new IzmeniKartonSaStavkamaOperacija();
     ikss.izvrsi(karton, null);
     return ikss.getK();
    }

    

    
}
