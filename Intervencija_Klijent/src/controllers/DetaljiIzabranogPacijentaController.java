/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import cordinator.Cordinator;
import domen.Karton;
import domen.Osiguranje;
import domen.Pacijent;
import forme.DetaljiIzabranogPacijentaForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.Komunikacija;

/**
 *
 * @author Emilija
 */
public class DetaljiIzabranogPacijentaController {
    Pacijent p;
    DetaljiIzabranogPacijentaForma dipf;

    public DetaljiIzabranogPacijentaController(DetaljiIzabranogPacijentaForma dipf) {
        this.dipf = dipf;
        actionLiseners();
    }

    public void otvoriFormu(Pacijent p) {
        pripremiFormu(p);
        dipf.setVisible(true);
        this.p=p;
    }

    private void pripremiFormu(Pacijent p) {
        SimpleDateFormat datum = new SimpleDateFormat("dd.MM.yyyy");

        dipf.getjTextFieldDatumRodjenja().setText(datum.format(p.getDatumRodjenja()));
        dipf.getjTextFieldKontaktInformacije().setText(p.getKontaktInformacije());
        dipf.getjTextFieldIme().setText(p.getIme());
        dipf.getjTextFieldPrezime().setText(p.getPrezime());
        List<Osiguranje> lista = Komunikacija.getInstance().ucitajOsiguranje();
        dipf.getjComboBoxOsiguranje().removeAllItems();
        for (Osiguranje o : lista) {
           dipf.getjComboBoxOsiguranje().addItem(o);
         }
        dipf.getjComboBoxOsiguranje().setSelectedItem(p.getOsiguranje());
        dipf.getjTextFieldDatumRodjenja().setEnabled(false);
        dipf.getjTextFieldKontaktInformacije().setEditable(false);
        dipf.getjTextFieldIme().setEditable(false);
        dipf.getjTextFieldPrezime().setEditable(false);
        dipf.getjComboBoxOsiguranje().setEnabled(false);
        dipf.getjButtonIzbrisi().setVisible(false);
        dipf.getjButtonIzmeni().setVisible(false);
        
    }

    private void actionLiseners() {
       dipf.omoguciIzmenuActionLisener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               dipf.getjTextFieldDatumRodjenja().setEnabled(true);
        dipf.getjTextFieldKontaktInformacije().setEditable(true);
        dipf.getjTextFieldIme().setEditable(true);
        dipf.getjTextFieldPrezime().setEditable(true);
        dipf.getjComboBoxOsiguranje().setEnabled(true);
        dipf.getjButtonIzbrisi().setVisible(true);
        dipf.getjButtonIzmeni().setVisible(true);
        dipf.getjButtonOmoguciIzmenu().setEnabled(false);
           }
       });
       dipf.izmeniActionLisener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               try {
                   int id=p.getIdPacijent();
                   String ime=dipf.getjTextFieldIme().getText().trim();
                   String prezime=dipf.getjTextFieldPrezime().getText().trim();
                   String kontakt=dipf.getjTextFieldKontaktInformacije().getText().trim();
                   String datumString=dipf.getjTextFieldDatumRodjenja().getText().trim();
                   Date datum=(new SimpleDateFormat("dd.MM.yyyy")).parse(datumString);
                   Osiguranje osiguranje=(Osiguranje) dipf.getjComboBoxOsiguranje().getSelectedItem();
                   Pacijent pac=new Pacijent(id,ime,prezime,kontakt,datum,osiguranje);
                   Komunikacija.getInstance().izmeniPacijenta(pac);
                   Cordinator.getInstance().getUcitajPacijenteController().pripremiFormu();
               } catch (ParseException ex) {
                   Logger.getLogger(DetaljiIzabranogPacijentaController.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       });
       dipf.izbrisiActionLisener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               Komunikacija.getInstance().izbrisiPacijenta(p);
               Cordinator.getInstance().getUcitajPacijenteController().pripremiFormu();
               dipf.dispose();
           }
       });
    }

    public DetaljiIzabranogPacijentaForma getDipf() {
        return dipf;
    }

    public void setDipf(DetaljiIzabranogPacijentaForma dipf) {
        this.dipf = dipf;
    }
    

}
