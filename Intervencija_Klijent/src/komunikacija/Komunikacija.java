/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import cordinator.Cordinator;
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
        System.out.println(odg);
        if(odg.getOdgovor()==null){
            JOptionPane.showMessageDialog(Cordinator.getInstance().getDodajPacijentaController().getDp(),"Sistem je zapamtio pacijenta","Uspeh",JOptionPane.INFORMATION_MESSAGE);
        }else{
              JOptionPane.showMessageDialog(Cordinator.getInstance().getDodajPacijentaController().getDp(),"Sistem ne moze da zapamti pacijenta","Greska",JOptionPane.ERROR_MESSAGE);
        }
        Cordinator.getInstance().ugasiFormu();
    }

    public List<Osiguranje> ucitajOsiguranje() {
        List<Osiguranje>lista=new ArrayList<>();
        Zahtev z=new Zahtev(Operacije.UCITAJ_OSIGURANJE, null);
        posiljalac.posalji(z);
        Odgovor odg=(Odgovor) primalac.primi();
        return (List<Osiguranje>) odg.getOdgovor();
    }

   
    
}
