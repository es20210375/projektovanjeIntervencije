/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import cordinator.Cordinator;
import domen.Intervencija;
import domen.Karton;
import domen.Kvalifikacija;
import domen.MedicinskiRadnik;
import domen.Osiguranje;
import domen.Pacijent;
import domen.StavkaKartona;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.text.html.HTML.Tag.P;

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
       MedicinskiRadnik mr = new MedicinskiRadnik(-1, null, null, true, email, password);

    Zahtev z = new Zahtev(Operacije.LOGIN, mr);
    posiljalac.posalji(z);

    Odgovor odg = (Odgovor) primalac.primi();

    if (odg.getOdgovor() instanceof String) {
        JOptionPane.showMessageDialog(
                Cordinator.getInstance().getLoginController().getLf(),
                odg.getOdgovor().toString(),
                "GRESKA",
                JOptionPane.ERROR_MESSAGE
        );

        Cordinator.getInstance().getLoginController().getLf().dispose();
        return null;

    } else if (odg.getOdgovor() == null) {
        JOptionPane.showMessageDialog(
                Cordinator.getInstance().getLoginController().getLf(),
                "Korisnicko ime i sifra nisu ispravni",
                "GRESKA",
                JOptionPane.ERROR_MESSAGE
        );
        return null;

    } else {
        mr = (MedicinskiRadnik) odg.getOdgovor();

        JOptionPane.showMessageDialog(
                Cordinator.getInstance().getLoginController().getLf(),
                "Korisnicko ime i sifra su ispravni",
                "USPEH",
                JOptionPane.INFORMATION_MESSAGE
        );

        Cordinator.getInstance().setMr(mr);
        Cordinator.getInstance().otvoriGlavnuFormu();
        Cordinator.getInstance().getLoginController().getLf().dispose();

        return mr;
    }
    }

    public void dodajPacijenta(Pacijent pac) {
        Zahtev z=new Zahtev(Operacije.DODAJ_PACIJENTA, pac);
        posiljalac.posalji(z);
        Odgovor odg=(Odgovor) primalac.primi();
       // System.out.println(odg);
        if(odg.getOdgovor()==null){
            JOptionPane.showMessageDialog(Cordinator.getInstance().getDodajPacijentaController().getDp(),"Sistem je zapamtio pacijenta","Uspeh",JOptionPane.INFORMATION_MESSAGE);
        }else{
              JOptionPane.showMessageDialog(Cordinator.getInstance().getDodajPacijentaController().getDp(),"Sistem ne moze da zapamti pacijenta","Greska",JOptionPane.ERROR_MESSAGE);
        }
        Cordinator.getInstance().isprazniFormu();
       // Cordinator.getInstance().ugasiFormu();
    }

    public List<Osiguranje> ucitajOsiguranje() {
        
        Zahtev z=new Zahtev(Operacije.UCITAJ_OSIGURANJE, null);
        posiljalac.posalji(z);
        Odgovor odg=(Odgovor) primalac.primi();
        return (List<Osiguranje>) odg.getOdgovor();
    }

    public void dodajLvalifikaciju(Kvalifikacija kv) {
        Zahtev z=new Zahtev(Operacije.DODAJ_KVALIFIKACIJU,kv);
        posiljalac.posalji(z);
        Odgovor odg=(Odgovor) primalac.primi();
        if(odg.getOdgovor()==null){
            JOptionPane.showMessageDialog(Cordinator.getInstance().getDodajKvalifikacijuController().getDkf(),"Sistem je zapamtio kvalifikaciju","Uspeh",JOptionPane.INFORMATION_MESSAGE);
        }else{
              JOptionPane.showMessageDialog(Cordinator.getInstance().getDodajKvalifikacijuController().getDkf(),"Sistem ne moze da zapamti kvalifikaciju","Greska",JOptionPane.ERROR_MESSAGE);
        }
       
    }

    public List<Pacijent> ucitajPacijente() {
       
       Zahtev z=new Zahtev(Operacije.UCITAJ_PACIJENTE,null);
       posiljalac.posalji(z);
       Odgovor odg=(Odgovor) primalac.primi();
        System.out.println("Klasa komunikacija ucitaj pacijente: "+(List<Pacijent>) odg.getOdgovor());
        
       return (List<Pacijent>) odg.getOdgovor();
        
    }

    public void izbrisiPacijenta(Pacijent p) {
        Zahtev z=new Zahtev(Operacije.IZBRISI_PACIJENTA, p);
        posiljalac.posalji(z);
        Odgovor odg=(Odgovor) primalac.primi();
        if(odg.getOdgovor()==null){
            JOptionPane.showMessageDialog(Cordinator.getInstance().getUcitajPacijenteController().getUpf(),"Sistem je obrisao pacijenta","Uspeh",JOptionPane.INFORMATION_MESSAGE);
        }else{
              JOptionPane.showMessageDialog(Cordinator.getInstance().getUcitajPacijenteController().getUpf(),"Sistem ne moze da obrise pacijenta","Greska",JOptionPane.ERROR_MESSAGE);
        }
        
    }

   

    public void kreirajPacijenta() {
        Zahtev z=new Zahtev(Operacije.KREIRAJ_PACIJENTA,null);
        posiljalac.posalji(z);
        Odgovor odg=(Odgovor) primalac.primi();
        if(odg.getOdgovor()==null){
            JOptionPane.showMessageDialog(Cordinator.getInstance().getDodajPacijentaController().getDp(),"Sistem je kreirao pacijenta","Uspeh",JOptionPane.INFORMATION_MESSAGE);
           
        }else{
              JOptionPane.showMessageDialog(Cordinator.getInstance().getDodajPacijentaController().getDp(),"Sistem ne moze da kreira pacijenta","Greska",JOptionPane.ERROR_MESSAGE);
              
        }
    }

    public void izmeniPacijenta(Pacijent pac) {
        Zahtev z=new Zahtev(Operacije.IZMENI_PACIJENTA, pac);
        posiljalac.posalji(z);
        Odgovor odg=(Odgovor) primalac.primi();
        if(odg.getOdgovor()==null){
            JOptionPane.showMessageDialog(Cordinator.getInstance().getIzmeniPacijentaController().getIpf(),"Sistem je zapamtio pacijenta","Uspeh",JOptionPane.INFORMATION_MESSAGE);
            
        }else{
              JOptionPane.showMessageDialog(Cordinator.getInstance().getIzmeniPacijentaController().getIpf(),"Sistem ne moze da zapamti pacijenta","Greska",JOptionPane.ERROR_MESSAGE);
              
        }
    }

    public List<MedicinskiRadnik> ucitajMedicinskeRadnike() {
        Zahtev z=new Zahtev(Operacije.UCITAJ_MEDICINSKE_RADNIKE, null);
        posiljalac.posalji(z);
        Odgovor odg=(Odgovor) primalac.primi();
        return (List<MedicinskiRadnik>) odg.getOdgovor();
        
    }

    public List<Intervencija> ucitajIntervencije() {
       Zahtev z=new Zahtev(Operacije.UCITAJ_INTERVENCIJE, null);
        posiljalac.posalji(z);
        Odgovor odg=(Odgovor) primalac.primi();
        return (List<Intervencija>) odg.getOdgovor();
    }

    public List<Karton> ucitajKartone() {
        Zahtev z=new Zahtev(Operacije.UCITAJ_KARTONE, null);
        posiljalac.posalji(z);
        Odgovor odg=(Odgovor) primalac.primi();
        return (List<Karton>) odg.getOdgovor();
    }

    public Karton dodajKarton(Karton k) {
        Zahtev z=new Zahtev(Operacije.DODAJ_KARTON, k);
        posiljalac.posalji(z);
        Odgovor odg=(Odgovor) primalac.primi();
       
        return (Karton) odg.getOdgovor();
    }

    public List<Karton> ucitajKartonZaPacijenta(int idPacijent) {
        Zahtev z=new Zahtev(Operacije.UCITAJ_ODREDJENI_KARTON, idPacijent);
        posiljalac.posalji(z);
        Odgovor odg=(Odgovor) primalac.primi();
        return (List<Karton>) odg.getOdgovor();
    }

    public void dodajIntervenciju(Intervencija inter) {
        Zahtev z=new Zahtev(Operacije.DODAJ_INTERVENCIJU, inter);
        posiljalac.posalji(z);
        Odgovor odg=(Odgovor) primalac.primi();
        if(odg.getOdgovor()==null){
            JOptionPane.showMessageDialog(Cordinator.getInstance().getDodajIntervencijuController().getDif(),"Sistem je zapamtio intervenciju","Uspeh",JOptionPane.INFORMATION_MESSAGE);
           Cordinator.getInstance().getKreirajKartonController().pripremiFormu();
           
        }else{
              JOptionPane.showMessageDialog(Cordinator.getInstance().getDodajIntervencijuController().getDif(),"Sistem ne moze da zapamti intervenciju","Greska",JOptionPane.ERROR_MESSAGE);
              
        }
    }

    public List<StavkaKartona> ucitajStavkeKartona() {
        Zahtev z=new Zahtev(Operacije.UCITAJ_STAVKE_KARTONA, null);
        posiljalac.posalji(z);
        Odgovor odg=(Odgovor) primalac.primi();
        return (List<StavkaKartona>) odg.getOdgovor();
    }

    public void dodajStavkuKartona(StavkaKartona stakvak) {
        Zahtev z=new Zahtev(Operacije.DODAJ_STAVKU_KARTONA, stakvak);
        posiljalac.posalji(z);
        Odgovor odg=(Odgovor) primalac.primi();
        if(odg.getOdgovor()==null){
            JOptionPane.showMessageDialog(Cordinator.getInstance().getKreirajKartonController().getKkf(),"Sistem je zapamtio karton","Uspeh",JOptionPane.INFORMATION_MESSAGE);
           Cordinator.getInstance().getGlavnaFormaController().pripremiFormu();
           
        }else{
              JOptionPane.showMessageDialog(Cordinator.getInstance().getKreirajKartonController().getKkf(),"Sistem ne moze da zapamti karton","Greska",JOptionPane.ERROR_MESSAGE);
              
        }
        
    }

    public void kreirajKarton() {
        Zahtev z=new Zahtev(Operacije.KREIRAJ_KARTON, null);
        posiljalac.posalji(z);
        Odgovor odg=(Odgovor) primalac.primi();
        if(odg.getOdgovor()==null){
            JOptionPane.showMessageDialog(Cordinator.getInstance().getKreirajKartonController().getKkf(),"Sistem je kreirao karton","Uspeh",JOptionPane.INFORMATION_MESSAGE);
           
           
        }else{
              JOptionPane.showMessageDialog(Cordinator.getInstance().getKreirajKartonController().getKkf(),"Sistem ne moze da kreira karton","Greska",JOptionPane.ERROR_MESSAGE);
              
        }
    }

    public void izmeniKarton(Karton k) {
        Zahtev z=new Zahtev(Operacije.IZMENI_KARTON, k);
        posiljalac.posalji(z);
       Odgovor odg=(Odgovor) primalac.primi();
    }

    public void izmeniStavkuKartona(StavkaKartona stakvak) {
       Zahtev z=new Zahtev(Operacije.IZMENI_STAVKU,stakvak);
       posiljalac.posalji(z);
       Odgovor odg=(Odgovor) primalac.primi();
        if(odg.getOdgovor()==null){
            JOptionPane.showMessageDialog(Cordinator.getInstance().getIzmeniKartonController().getIkf(),"Sistem je zapamtio karton","Uspeh",JOptionPane.INFORMATION_MESSAGE);
           Cordinator.getInstance().getGlavnaFormaController().pripremiFormu();
           
        }else{
              JOptionPane.showMessageDialog(Cordinator.getInstance().getIzmeniKartonController().getIkf(),"Sistem ne moze da zapamti karton","Greska",JOptionPane.ERROR_MESSAGE);
              
        }
    }

    public void odjavi(MedicinskiRadnik mr) {
        Zahtev z=new Zahtev(Operacije.LOGOUT, mr);
        posiljalac.posalji(z);
        Odgovor odg=(Odgovor) primalac.primi();
        System.out.println("komunikacija.Komunikacija.odjavi()"+odg.getOdgovor());
        if((boolean)odg.getOdgovor()!=false){
            Cordinator.getInstance().getGlavnaFormaController().ugasiFormu();
        }else{
            System.out.println("komunikacija.Komunikacija.odjavi()+ NEMOGUCA ODJAVA"+mr);
        }
    }

    public List<StavkaKartona> vratiStavkuKartona(int idKarton) {
        Zahtev z=new Zahtev(Operacije.VRATI_STAVKU_ODREDJENOG_KARTONA,idKarton);
        posiljalac.posalji(z);
        Odgovor odg=(Odgovor) primalac.primi();
        return (List<StavkaKartona>) odg.getOdgovor();
    }

    public List<Pacijent> vratipacijenteKriterijumStatusaDA() {
         Zahtev z=new Zahtev(Operacije.VRATI_PACIJENTE_SA_DA, null);
         posiljalac.posalji(z);
         Odgovor odg=(Odgovor) primalac.primi();
         return (List<Pacijent>) odg.getOdgovor();
         
    }

    public List<Pacijent> vratiPacijenteKriterijumStatusNe() {
        Zahtev z=new Zahtev(Operacije.VRATI_PACIJENTE_SA_NE, null);
         posiljalac.posalji(z);
         Odgovor odg=(Odgovor) primalac.primi();
         return (List<Pacijent>) odg.getOdgovor();
    }

    public List<Pacijent> VratiPacijenteKriterijumIme(String ime) {
         Zahtev z=new Zahtev(Operacije.VRATI_PACIJENTE_IME, ime);
         posiljalac.posalji(z);
         Odgovor odg=(Odgovor) primalac.primi();
         return (List<Pacijent>) odg.getOdgovor();
    }

    public List<Pacijent> vratiPacijenteKriterijumImePrezime(String tekst) {
        Zahtev z=new Zahtev(Operacije.VRATI_PACIJENTE_IME_PREZIME, tekst);
         posiljalac.posalji(z);
         Odgovor odg=(Odgovor) primalac.primi();
         return (List<Pacijent>) odg.getOdgovor();
    }

    public List<Karton> vratiListuKartonKriterijumKarton(int unetaGodina) {
        Zahtev z=new Zahtev(Operacije.VRATI_KARTONE_KRITERIJUM_KARTON,unetaGodina);
         posiljalac.posalji(z);
         Odgovor odg=(Odgovor) primalac.primi();
         System.out.println("komunikacija.Komunikacija.vratiListuKartonKriterijumKarton()"+(List<Karton>) odg.getOdgovor());
         return (List<Karton>) odg.getOdgovor();
    }

    public List<Karton> vratiListuKartonaKriterijumPacijentIme(String ime) {
        Zahtev z=new Zahtev(Operacije.VRATI_KARTONE_KRITERIJUM_PACIJENT_IME,ime);
         posiljalac.posalji(z);
         Odgovor odg=(Odgovor) primalac.primi();
         System.out.println("komunikacija.Komunikacija.vratiListuKartonKriterijumKarton()"+(List<Karton>) odg.getOdgovor());
         return (List<Karton>) odg.getOdgovor();
    }

    public List<Karton> vratiListuKartonKriterijumPacijentImePrezime(String tekst) {
        Zahtev z=new Zahtev(Operacije.VRATI_KARTONE_KRITERIJUM_PACIJENT_IME_PREZIME,tekst);
         posiljalac.posalji(z);
         Odgovor odg=(Odgovor) primalac.primi();
         System.out.println("komunikacija.Komunikacija.vratiListuKartonKriterijumKarton()"+(List<Karton>) odg.getOdgovor());
         return (List<Karton>) odg.getOdgovor();
    }

    public List<Karton> vratiListuKartonaKriterijumMedicinskiRadnikIme(String ime) {
        Zahtev z=new Zahtev(Operacije.VRATI_KARTONE_KRITERIJUM_MEDICINSKI_RADNIK_IME,ime);
         posiljalac.posalji(z);
         Odgovor odg=(Odgovor) primalac.primi();
         System.out.println("komunikacija.Komunikacija.vratiListuKartonKriterijumKarton()"+(List<Karton>) odg.getOdgovor());
         return (List<Karton>) odg.getOdgovor();
    }

    public List<Karton> vratiListuKartonKriterijumMedicinskiRadnikImePrezime(String tekst) {
        Zahtev z=new Zahtev(Operacije.VRATI_KARTONE_KRITERIJUM_MEDICINSKI_RADNIK_IME_PREZIME,tekst);
         posiljalac.posalji(z);
         Odgovor odg=(Odgovor) primalac.primi();
         System.out.println("komunikacija.Komunikacija.vratiListuKartonKriterijumKarton()"+(List<Karton>) odg.getOdgovor());
         return (List<Karton>) odg.getOdgovor();
    }

    public List<Karton> vratiListuKartonKriterijumIntervencija(String tekst) {
        Zahtev z=new Zahtev(Operacije.VRATI_KARTONE_KRITERIJUM_INTERVENCIJA,tekst);
         posiljalac.posalji(z);
         Odgovor odg=(Odgovor) primalac.primi();
         System.out.println("komunikacija.Komunikacija.vratiListuKartonKriterijumKarton()"+(List<Karton>) odg.getOdgovor());
         return (List<Karton>) odg.getOdgovor();
    }

    

    

   
    
}
