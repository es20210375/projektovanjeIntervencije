/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import cordinator.Cordinator;
import domen.Karton;
import forme.GlavnaForma;
import java.util.List;
import komunikacija.Komunikacija;

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
         pripremiFormu();
    }

    private void addActionLiseners() {
       
    }

    public void pripremiFormu() {
        List<Karton>lista=Komunikacija.getInstance().ucitajKartone();
        ModelTabeleKartoni mtk=new ModelTabeleKartoni(lista);
        gf.getjTableKartoni().setModel(mtk);
        
    }

    public GlavnaForma getGf() {
        return gf;
    }

    
    
    
}
