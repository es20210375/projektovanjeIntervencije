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
import forme.IzmeniKartonForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author Emilija
 */
public class IzmeniKartonController {
    IzmeniKartonForma ikf;
    StavkaKartona sk1;
    private Karton kartonZaIzmenu;
    private StavkaKartona stavkaZaIzmenu;

    public IzmeniKartonController(IzmeniKartonForma ikf) {
        this.ikf = ikf;
        addActionLiseners();
        
    }

    public void otvoriFormu(StavkaKartona sk) {
        ikf.setVisible(true);
        this.sk1=sk;
        this.stavkaZaIzmenu = sk;
        this.kartonZaIzmenu = sk.getKarton();
        pripremiFormu();
       
    }

    private void addActionLiseners() {
     ikf.izmeniActionLisener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    izmeni(e);
                } catch (ParseException ex) {
                    Logger.getLogger(KreirajKartonController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            private void izmeni(ActionEvent e) throws ParseException {
                int red = ikf.getjTableIntervencija().getSelectedRow();
                if (red == -1) {
                    JOptionPane.showMessageDialog(ikf, "Morate izabrati intervenciju iz tabele!");
                    return;
                }
                ModelTabeleIntervencija mti = (ModelTabeleIntervencija) ikf.getjTableIntervencija().getModel();
                Intervencija i = mti.getLista().get(red);

                MedicinskiRadnik mr = (MedicinskiRadnik) ikf.getjComboBoxMedicinskiRadnik().getSelectedItem();
                Pacijent p = (Pacijent) ikf.getjComboBoxPacijent().getSelectedItem();
                StatusKartona sk = (StatusKartona) ikf.getjComboBoxStatus().getSelectedItem();

                String datum = ikf.getjTextFieldDatumOtvaranja().getText();
                Date datum1 = (new SimpleDateFormat("dd.MM.yyyy")).parse(datum);

                kartonZaIzmenu.setDatumOtvaranja(datum1);
                kartonZaIzmenu.setStatusKartona(sk);
                kartonZaIzmenu.setMedicinskiRadnik(mr);
                kartonZaIzmenu.setPacijent(p);

                Komunikacija.getInstance().izmeniKarton(kartonZaIzmenu);

                String dijagnoza = ikf.getjTextFieldDijagnoza().getText();
                String korisceniMaterijal = ikf.getjTextFieldMaterijal().getText();
                String terapija = ikf.getjTextFieldTerapija().getText();
                String naznaka = ikf.getjTextFieldNaznaka().getText();

                String datumIn = ikf.getjTextFieldDatumIntervencije().getText();
                Date datumIntervencije = (new SimpleDateFormat("dd.MM.yyyy")).parse(datumIn);

                String dodatnaDokumentacija = ikf.getjTextFieldDodatnaDokumentacija().getText();
                boolean dodatnaDokumentacijab = dodatnaDokumentacija.equalsIgnoreCase("DA");

                String anestezijaS = ikf.getjTextFieldAnestezija().getText();
                boolean anestezija = anestezijaS.equalsIgnoreCase("DA");

                stavkaZaIzmenu.setDijagnoza(dijagnoza);
                stavkaZaIzmenu.setKorisceniMaterijal(korisceniMaterijal);
                stavkaZaIzmenu.setTerapija(terapija);
                stavkaZaIzmenu.setNaznaka(naznaka);
                stavkaZaIzmenu.setDodatnaDokumentacija(dodatnaDokumentacijab);
                stavkaZaIzmenu.setAnestezija(anestezija);
                stavkaZaIzmenu.setDatumIntervencije(datumIntervencije);
                stavkaZaIzmenu.setIntervencija(i);
                stavkaZaIzmenu.setKarton(kartonZaIzmenu);

                Komunikacija.getInstance().izmeniStavkuKartona(stavkaZaIzmenu);
                
              
                
            }
        });    
    }

    private void pripremiFormu() {
        List<Pacijent>listaPacijenata=Komunikacija.getInstance().ucitajPacijente();
          if (listaPacijenata == null) {
             listaPacijenata = new ArrayList<>();
                }
       ikf.getjComboBoxPacijent().removeAllItems();
       
        for (Pacijent pacijent : listaPacijenata) {
            ikf.getjComboBoxPacijent().addItem(pacijent);
        }
        ikf.getjComboBoxPacijent().setSelectedItem(sk1.getKarton().getPacijent());
        ikf.getjComboBoxPacijent().setEnabled(false);
        List<MedicinskiRadnik>listaRadnika=Komunikacija.getInstance().ucitajMedicinskeRadnike();
        ikf.getjComboBoxMedicinskiRadnik().removeAllItems();
        for (MedicinskiRadnik medicinskiRadnik:listaRadnika) {
            ikf.getjComboBoxMedicinskiRadnik().addItem(medicinskiRadnik);
        }
       ikf.getjComboBoxMedicinskiRadnik().setSelectedItem(sk1.getKarton().getMedicinskiRadnik());
       ikf.getjComboBoxMedicinskiRadnik().setEnabled(false);
       if(sk1.isAnestezija()){
           ikf.getjTextFieldAnestezija().setText("DA");
       }else{
           ikf.getjTextFieldAnestezija().setText("NE");
       }
       ikf.getjTextFieldAnestezija().setEnabled(false);
       
       List<Intervencija>listaIntervencija=Komunikacija.getInstance().ucitajIntervencije();
       ModelTabeleIntervencija mti=new ModelTabeleIntervencija(listaIntervencija);
       ikf.getjTableIntervencija().setModel(mti);
       ikf.getjComboBoxStatus().setSelectedItem(sk1.getKarton().getStatusKartona());
       ikf.getjComboBoxStatus().setEnabled(false);
       ikf.getjTextFieldNaznaka().setText(sk1.getNaznaka());
       if(sk1.isDodatnaDokumentacija()){
           ikf.getjTextFieldDodatnaDokumentacija().setText("DA");
       }else{
           ikf.getjTextFieldDodatnaDokumentacija().setText("NE");
       }
       SimpleDateFormat datum=new SimpleDateFormat("dd.MM.yyyy");
       ikf.getjTextFieldDatumOtvaranja().setText(datum.format(sk1.getKarton().getDatumOtvaranja()));
       ikf.getjTextFieldDatumOtvaranja().setEnabled(false);
       ikf.getjTextFieldDatumIntervencije().setText(datum.format(sk1.getDatumIntervencije()));
       ikf.getjTextFieldDijagnoza().setText(sk1.getDijagnoza());
       ikf.getjTextFieldMaterijal().setText(sk1.getKorisceniMaterijal());
       ikf.getjTextFieldTerapija().setText(sk1.getTerapija());
        ikf.getjTextFieldDodatnaDokumentacija().setEnabled(false); 
       
        }

    public IzmeniKartonForma getIkf() {
        return ikf;
    }

    public void setIkf(IzmeniKartonForma ikf) {
        this.ikf = ikf;
    }
    
       
    }

    

