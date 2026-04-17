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
       MedicinskiRadnik mr=new MedicinskiRadnik(-1, null, null, true, email, password);
       Zahtev z=new Zahtev(Operacije.LOGIN, mr);
       posiljalac.posalji(z);
       Odgovor odg=(Odgovor) primalac.primi();
       mr=(MedicinskiRadnik) odg.getOdgovor();
       return mr;
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
       // Cordinator.getInstance().zatvoriFormuDodajKvalifikaciju();
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

    public void dodajKarton(Karton k) {
        Zahtev z=new Zahtev(Operacije.DODAJ_KARTON, k);
        posiljalac.posalji(z);
        Odgovor odg=(Odgovor) primalac.primi();
        if(odg.getOdgovor()==null){
            JOptionPane.showMessageDialog(Cordinator.getInstance().getKreirajKartonController().getKkf(),"Sistem je zapamtio karton","Uspeh",JOptionPane.INFORMATION_MESSAGE);
           Cordinator.getInstance().getGlavnaFormaController().pripremiFormu();
           
        }else{
              JOptionPane.showMessageDialog(Cordinator.getInstance().getKreirajKartonController().getKkf(),"Sistem ne moze da zapamti karton","Greska",JOptionPane.ERROR_MESSAGE);
              
        }
        
    }

    public List<Karton> ucitajKartonZaPacijenta(int idPacijent) {
        Zahtev z=new Zahtev(Operacije.UCITAJ_ODREDJENI_KARTON, idPacijent);
        posiljalac.posalji(z);
        Odgovor odg=(Odgovor) primalac.primi();
        return (List<Karton>) odg.getOdgovor();
    }

    

   
    
}
