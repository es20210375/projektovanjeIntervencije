/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.MedicinskiRadnik;
import domen.Osiguranje;
import domen.Pacijent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import soperacije.login.LogInOperacija;
import soperacije.osiguranje.UcitajOsiguranjeOperacija;
import soperacije.pacijent.DodajPacijentaOperacija;

/**
 *
 * @author Emilija
 */
public class Controller {
    private static  Controller instance;
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
            
            
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public List<Osiguranje> ucitajOsiguranje() throws Exception {
        UcitajOsiguranjeOperacija uoo=new UcitajOsiguranjeOperacija();
        uoo.izvrsi(null, null);
        return uoo.getLista();
    }

    
    
    
}
