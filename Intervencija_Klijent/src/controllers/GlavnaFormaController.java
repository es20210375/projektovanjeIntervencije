/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import cordinator.Cordinator;
import forme.GlavnaForma;

/**
 *
 * @author Emilija
 */
public class GlavnaFormaController {
    private final GlavnaForma gf;

    public GlavnaFormaController(GlavnaForma gf) {
        this.gf = gf;
        addActionLiseners();
    }

    public void otvoriFormu() {
         gf.setVisible(true);
         gf.getjLabelUlogovani().setText(Cordinator.getInstance().getMr().getIme()+" "+Cordinator.getInstance().getMr().getPrezime());
    }

    private void addActionLiseners() {
       
    }
    
    
}
