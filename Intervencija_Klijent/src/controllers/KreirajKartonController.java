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
import domen.StavkaKartona;
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

    public void pripremiFormu() {
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
       kkf.getjTextFieldAnestezija().setEnabled(false);
       kkf.getjTextFieldDodatnaDokumentacija().setEnabled(false);
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
                int red=kkf.getjTableIntervencije().getSelectedRow();
                ModelTabeleIntervencija mti=(ModelTabeleIntervencija) kkf.getjTableIntervencije().getModel();
                Intervencija i=mti.getLista().get(red);
                MedicinskiRadnik mr=(MedicinskiRadnik) kkf.getjComboBoxMradnik().getSelectedItem();
                Pacijent p=(Pacijent) kkf.getjComboBoxPacijent().getSelectedItem();
                StatusKartona sk=(StatusKartona) kkf.getjComboBoxStatus().getSelectedItem();
                String datum=kkf.getjTextFieldDatumOtvaranja().getText();
                Date datum1=(new SimpleDateFormat("dd.MM.yyyy")).parse(datum);
                Karton k=new Karton(-1,datum1,sk,null,mr,p);
                k=Komunikacija.getInstance().dodajKarton(k);
                String dijagnoza=kkf.getjTextFieldDijagnoza().getText();
                String korisceniMaterijal=kkf.getjTextFieldKorMaterijal().getText();
                String terapija=kkf.getjTextFieldTerapija().getText();
                String naznaka=kkf.getjTextFieldNaznaka().getText();
                String datumIn=kkf.getjTextFieldDatumIntervencije().getText();
                Date datumIntervencije=(new SimpleDateFormat("dd.MM.yyyy")).parse(datumIn);
                boolean dodatnaDokumentacija=false;
                boolean anestezija=true;
                if(i.isSnimakZuba()){
                    kkf.getjTextFieldDodatnaDokumentacija().setText("DA");
                    
                    dodatnaDokumentacija=true;
                   
                }
                if(naznaka.contains("kontraindikacije za lokalnu anesteziju")){
                    kkf.getjTextFieldAnestezija().setText("NE");
                   
                    anestezija=false;
                }
                StavkaKartona stakvak=new StavkaKartona(-1,dijagnoza,korisceniMaterijal,terapija,naznaka,dodatnaDokumentacija,anestezija,datumIntervencije,i,k);
                k.getStavkaKartona().add(stakvak);
                Komunikacija.getInstance().dodajStavkuKartona(stakvak);
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
