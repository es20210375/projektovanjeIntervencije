/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import cordinator.Cordinator;
import domen.Osiguranje;
import domen.Pacijent;
import forme.IzmeniPacijentaForma;
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
public class IzmeniPacijentaController {
    IzmeniPacijentaForma ipf;
    Pacijent p;
    public IzmeniPacijentaController(IzmeniPacijentaForma ipf,Pacijent p) {
        this.ipf = ipf;
        this.p=p;
        addActionLiseners();
    }

   

    private void addActionLiseners() {
         ipf.IzmeniAddActionLisener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 try {
                     izmeni(e);
                 } catch (ParseException ex) {
                     Logger.getLogger(IzmeniPacijentaController.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }

             private void izmeni(ActionEvent e) throws ParseException {
                 int id=p.getIdPacijent();
               String ime=ipf.getjTextFieldIme().getText().trim();
                 String prezime=ipf.getjTextFieldPrezime().getText().trim();
                 String kontakt=ipf.getjTextFieldKontakt().getText().trim();
                 String datumString=ipf.getjTextFieldDatum().getText().trim();
                 Date datum=(new SimpleDateFormat("dd.MM.yyyy")).parse(datumString);
                 Osiguranje osiguranje=(Osiguranje) ipf.getjComboBox1().getSelectedItem();
              Pacijent pac=new Pacijent(id,ime,prezime,kontakt,datum,osiguranje);
                 Komunikacija.getInstance().izmeniPacijenta(pac);
                 Cordinator.getInstance().getUcitajPacijenteController().pripremiFormu();
             }
         });
            
    }
    public void otvoriFormu() {
        ipf.setVisible(true);
        pripremiFormu();
    }

    private void pripremiFormu() {
        ipf.getjTextFieldIme().setText(p.getIme());
        ipf.getjTextFieldPrezime().setText(p.getPrezime());
        ipf.getjTextFieldKontakt().setText(p.getKontaktInformacije());
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        ipf.getjTextFieldDatum().setText(sdf.format(p.getDatumRodjenja()));
        List<Osiguranje> lista = Komunikacija.getInstance().ucitajOsiguranje();
        ipf.getjComboBox1().removeAllItems();
        for (Osiguranje o : lista) {
           ipf.getjComboBox1().addItem(o);
         }
        ipf.getjComboBox1().setSelectedItem(p.getOsiguranje());
        
      }

    public IzmeniPacijentaForma getIpf() {
        return ipf;
    }

    
    
}
