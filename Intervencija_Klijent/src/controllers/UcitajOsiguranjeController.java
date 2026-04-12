/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import domen.Osiguranje;
import forme.DodajPacijentaForma;
import java.util.List;
import komunikacija.Komunikacija;

/**
 *
 * @author Emilija
 */
public class UcitajOsiguranjeController {
    DodajPacijentaForma dpf;

    public UcitajOsiguranjeController(DodajPacijentaForma dpf) {
        this.dpf = dpf;
    }

    public void pripremiFormu() {
        List<Osiguranje>lista=Komunikacija.getInstance().ucitajOsiguranje();
        System.out.println("Klasa UcitajOsiguranjeController: "+lista);
        dpf.getjComboBoxOsiguranje().removeAllItems();
        for (Osiguranje osiguranje : lista) {
            dpf.getjComboBoxOsiguranje().addItem(osiguranje);
        }
        dpf.getjComboBoxOsiguranje().setSelectedIndex(-1);
    }
    
    
}
