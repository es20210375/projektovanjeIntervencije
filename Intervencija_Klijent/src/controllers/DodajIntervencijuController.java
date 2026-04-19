/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import domen.Intervencija;
import forme.DodajIntervencijuForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import komunikacija.Komunikacija;

/**
 *
 * @author Emilija
 */
public class DodajIntervencijuController {
    DodajIntervencijuForma dif;

    public DodajIntervencijuController(DodajIntervencijuForma dif) {
        this.dif = dif;
        addActionLiseners();
    }

    public void otvoriFormu() {
        dif.setVisible(true);
    }

    private void addActionLiseners() {
        dif.dodajAddActionLisener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean snimakZuba=false;
                String naziv=dif.getjTextFieldNaziv().getText();
                String opis=dif.getjTextFieldOpis().getText();
                String snimakZubaS=dif.getjTextFieldSnimakZuba().getText();
                if(snimakZubaS.equals("DA")){
                    snimakZuba=true;
                }else{
                    snimakZuba=false;
                }
                Intervencija inter=new Intervencija(-1,naziv,opis,snimakZuba);
                Komunikacija.getInstance().dodajIntervenciju(inter);
            }
        });
    }

    public DodajIntervencijuForma getDif() {
        return dif;
    }

    public void setDif(DodajIntervencijuForma dif) {
        this.dif = dif;
    }
    
}
