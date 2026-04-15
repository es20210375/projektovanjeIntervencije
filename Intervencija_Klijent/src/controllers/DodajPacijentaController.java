/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import domen.Osiguranje;
import domen.Pacijent;
import forme.DodajPacijentaForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.Komunikacija;

/**
 *
 * @author Emilija
 */
public class DodajPacijentaController {
    private DodajPacijentaForma dp;
    private UcitajOsiguranjeController ucitajOsiguranjeController;

    public DodajPacijentaForma getDp() {
        return dp;
    }

    public void setDp(DodajPacijentaForma dp) {
        this.dp = dp;
    }

    public DodajPacijentaController(DodajPacijentaForma dmr) {
        this.dp = dmr;
        addActionLisener();
    }

    public void otvoriFormu() {
       
        ucitajOsiguranjeController=new UcitajOsiguranjeController(dp);
       ucitajOsiguranjeController.pripremiFormu();
        dp.setVisible(true);
        
    }

    private void addActionLisener() {
     dp.dodajAddActionLisener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
              dodaj(e);
             
              
         }

         private void dodaj(ActionEvent e) {
             try {
                 String ime=dp.getjTextFieldIme().getText().trim();
                 String prezime=dp.getjTextFieldPrezime().getText().trim();
                 String kontakt=dp.getjTextFieldInformacije().getText().trim();
                 String datumString=dp.getjTextFieldDatum().getText().trim();
                 Date datum=(new SimpleDateFormat("dd.MM.yyyy")).parse(datumString);
                 Osiguranje osiguranje=(Osiguranje) dp.getjComboBoxOsiguranje().getSelectedItem();
              /*if(osiguranje.equals("")){
                  osiguranje=null;
              }*/
              Pacijent pac=new Pacijent(-1,ime,prezime,kontakt,datum,osiguranje);
                 System.out.println("Klasa dodajPacijentaController: "+pac);
                 Komunikacija.getInstance().dodajPacijenta(pac);
             } catch (ParseException ex) {
                 ex.printStackTrace();
             }
              
                      
            
            
         }

     });
     dp.kreirajActionLisener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             try {
                 String ime=dp.getjTextFieldIme().getText().trim();
                 String prezime=dp.getjTextFieldPrezime().getText().trim();
                 String kontakt=dp.getjTextFieldInformacije().getText().trim();
                 String datumString=dp.getjTextFieldDatum().getText().trim();
                 Date datum=(new SimpleDateFormat("dd.MM.yyyy")).parse(datumString);
                 Osiguranje osiguranje=(Osiguranje) dp.getjComboBoxOsiguranje().getSelectedItem();
              Pacijent pac=new Pacijent(-1,ime,prezime,kontakt,datum,osiguranje);
               
                 Komunikacija.getInstance().kreirajPacijenta(pac);
             } catch (ParseException ex) {
                 ex.printStackTrace();
             }
            
         }
     });
    }
   
    public void ugasiFormu() {
        dp.dispose();
    }

    public void isprazniFormu() {
        dp.getjTextFieldIme().setText("");
    dp.getjTextFieldPrezime().setText("");
    dp.getjTextFieldInformacije().setText("");
    dp.getjTextFieldDatum().setText("");

    dp.getjComboBoxOsiguranje().setSelectedIndex(-1);
    }
    
    
}
