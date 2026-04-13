/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import domen.Pacijent;
import forme.UcitajPacijenteForma;
import java.util.List;
import komunikacija.Komunikacija;

/**
 *
 * @author Emilija
 */
public class UcitajPacijenteController {
    UcitajPacijenteForma upf;

    public UcitajPacijenteController(UcitajPacijenteForma upf) {
        this.upf = upf;
    }

    public void otvoriFormu() {
        pripremiFormu();
       upf.setVisible(true);
    }

    private void pripremiFormu() {
     List<Pacijent>lista=Komunikacija.getInstance().ucitajPacijente();
     ModelTabelePacijenti mtp=new ModelTabelePacijenti(lista);
     upf.getjTablePacijent().setModel(mtp);
    }
    
    
}
