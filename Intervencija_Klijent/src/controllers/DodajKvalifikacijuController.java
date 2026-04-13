/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import domen.Kvalifikacija;
import domen.Osiguranje;
import domen.Pacijent;
import forme.DodajKvalifikacijuForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import komunikacija.Komunikacija;

/**
 *
 * @author Emilija
 */
public class DodajKvalifikacijuController {
    DodajKvalifikacijuForma dkf;

    public DodajKvalifikacijuController(DodajKvalifikacijuForma dkf) {
        this.dkf = dkf;
    }

    public void otvoriFormu() {
        dkf.setVisible(true);
        addActionLisener();
    }

    private void addActionLisener() {
        dkf.dodajAddActionLisener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
              dodaj(e);
         }

         private void dodaj(ActionEvent e) {
            String naziv=dkf.getjTextFieldNaziv().getText().trim();
            Kvalifikacija kv=new Kvalifikacija(-1,naziv);
            Komunikacija.getInstance().dodajLvalifikaciju(kv);
              
                      
            
            
         }
     });
    }

    public DodajKvalifikacijuForma getDkf() {
        return dkf;
    }

    public void setDkf(DodajKvalifikacijuForma dkf) {
        this.dkf = dkf;
    }

    public void zatvoriFormuDodajKvalifikaciju() {
     dkf.dispose();
    }
    
    
}
