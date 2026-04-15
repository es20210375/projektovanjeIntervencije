/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;


import domen.Intervencija;
import domen.MedicinskiRadnik;
import domen.Pacijent;
import forme.KreirajKartonForma;
import java.util.List;
import komunikacija.Komunikacija;

/**
 *
 * @author Emilija
 */
public class KreirajKartonController {
    KreirajKartonForma kkf;

    public KreirajKartonController(KreirajKartonForma kkf) {
        this.kkf = kkf;
    }

    public void otvoriFormu() {
         pripremiFormu();
         kkf.setVisible(true);
         addActionLiseners();
    }

    private void pripremiFormu() {
       List<Pacijent>listaPacijenata=Komunikacija.getInstance().ucitajPacijente();
       kkf.getjComboBoxPacijent().removeAllItems();
        for (Pacijent pacijent : listaPacijenata) {
            kkf.getjComboBoxPacijent().addItem(pacijent);
        }
        kkf.getjComboBoxPacijent().setSelectedIndex(-1);
        List<MedicinskiRadnik>listaRadnika=Komunikacija.getInstance().ucitajMedicinskeRadnike();
        kkf.getjComboBoxMradnik().removeAllItems();
        for (MedicinskiRadnik medicinskiRadnik:listaRadnika) {
            kkf.getjComboBoxMradnik().addItem(medicinskiRadnik);
        }
       kkf.getjComboBoxMradnik().setSelectedIndex(-1);
       List<Intervencija>listaIntervencija=Komunikacija.getInstance().ucitajIntervencije();
       ModelTabeleIntervencija mti=new ModelTabeleIntervencija(listaIntervencija);
       kkf.getjTable1().setModel(mti);
    }

    private void addActionLiseners() {
        
    }
    
    
}
