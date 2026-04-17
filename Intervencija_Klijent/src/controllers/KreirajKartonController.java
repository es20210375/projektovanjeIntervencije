/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;


import domen.Intervencija;
import domen.Karton;
import domen.MedicinskiRadnik;
import domen.Pacijent;
import domen.StatusKartona;
import forme.KreirajKartonForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
       kkf.getjTableIntervencije().setModel(mti);
    }

    private void addActionLiseners() {
        kkf.sacuvajActionLisener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    sacuvaj(e);
                } catch (ParseException ex) {
                    Logger.getLogger(KreirajKartonController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            private void sacuvaj(ActionEvent e) throws ParseException {
                MedicinskiRadnik mr=(MedicinskiRadnik) kkf.getjComboBoxMradnik().getSelectedItem();
                Pacijent p=(Pacijent) kkf.getjComboBoxPacijent().getSelectedItem();
                StatusKartona sk=(StatusKartona) kkf.getjComboBoxStatus().getSelectedItem();
                String datum=kkf.getjTextFieldDatumOtvaranja().getText();
                Date datum1=(new SimpleDateFormat("dd.MM.yyyy")).parse(datum);
                Karton k=new Karton(-1,datum1,sk,null,mr,p);
                k.setStavkaKartona(new ArrayList());
                Komunikacija.getInstance().dodajKarton(k);
                
            }
        });
    }

    public KreirajKartonForma getKkf() {
        return kkf;
    }

    public void setKkf(KreirajKartonForma kkf) {
        this.kkf = kkf;
    }
    
    
}
