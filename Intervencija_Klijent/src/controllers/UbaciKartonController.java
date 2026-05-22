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
import forme.UbaciKartonForma;
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
public class UbaciKartonController {

    UbaciKartonForma kkf;
    List<StavkaKartona> listaStavki = new ArrayList<>();
    Karton k;
    StavkaKartona stavka;

    public UbaciKartonController(UbaciKartonForma kkf) {
        this.kkf = kkf;
    }

    public void otvoriFormu() {

        pripremiFormu();
        kkf.setVisible(true);
        addActionLiseners();
    }

    public void pripremiFormu() {

        List<Pacijent> listaPacijenata = Komunikacija.getInstance().ucitajPacijente();
        kkf.getjComboBoxPacijent().removeAllItems();
        for (Pacijent pacijent : listaPacijenata) {
            kkf.getjComboBoxPacijent().addItem(pacijent);
        }
        kkf.getjComboBoxPacijent().setSelectedIndex(-1);
        List<MedicinskiRadnik> listaRadnika = Komunikacija.getInstance().ucitajMedicinskeRadnike();
        kkf.getjComboBoxMradnik().removeAllItems();
        for (MedicinskiRadnik medicinskiRadnik : listaRadnika) {
            kkf.getjComboBoxMradnik().addItem(medicinskiRadnik);
        }
        kkf.getjComboBoxMradnik().setSelectedIndex(-1);
        List<Intervencija> listaIntervencija = Komunikacija.getInstance().ucitajIntervencije();
        ModelTabeleIntervencija mti = new ModelTabeleIntervencija(listaIntervencija);
        kkf.getjTableIntervencije().setModel(mti);
        ModelTabeleStavke mts = new ModelTabeleStavke(listaStavki);
        kkf.getjTableStavke().setModel(mts);

        kkf.getjButtonSacuvaj().setVisible(true);

    }

    private void addActionLiseners() {
        kkf.sacuvajActionLisener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    sacuvaj(e);
                } catch (ParseException ex) {
                    Logger.getLogger(UbaciKartonController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            private void sacuvaj(ActionEvent e) throws ParseException {
                Karton k = null;

                try {

                    MedicinskiRadnik mr
                            = (MedicinskiRadnik) kkf.getjComboBoxMradnik().getSelectedItem();

                    Pacijent p
                            = (Pacijent) kkf.getjComboBoxPacijent().getSelectedItem();

                    StatusKartona status
                            = (StatusKartona) kkf.getjComboBoxStatus().getSelectedItem();

                    String datumString
                            = kkf.getjTextFieldDatumOtvaranja().getText().trim();

                    if (mr == null
                            || p == null
                            || status == null
                            || datumString.isEmpty()
                            || listaStavki.isEmpty()) {

                        k = null;

                    } else {

                        Date datum
                                = new SimpleDateFormat("dd.MM.yyyy")
                                        .parse(datumString);

                        k = new Karton(
                                -1,
                                datum,
                                status,
                                null,
                                mr,
                                p
                        );

                        for (StavkaKartona sk : listaStavki) {
                            sk.setKarton(k);
                        }

                        k.setStavkaKartona(listaStavki);
                    }

                } catch (Exception ex) {

                    k = null;
                }

                Komunikacija.getInstance().sacuvajKarton(k);

            }
        });

        kkf.dodajStavkuActionLisener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    int red = kkf.getjTableIntervencije().getSelectedRow();

                    if (red == -1) {
                        JOptionPane.showMessageDialog(kkf, "Izaberi intervenciju!");
                        return;
                    }

                    ModelTabeleIntervencija mti
                            = (ModelTabeleIntervencija) kkf.getjTableIntervencije().getModel();

                    Intervencija i = mti.getLista().get(red);

                    String dijagnoza = kkf.getjTextFieldDijagnoza().getText();
                    String korisceniMaterijal = kkf.getjTextFieldKorMaterijal().getText();
                    String terapija = kkf.getjTextFieldTerapija().getText();
                    String naznaka = kkf.getjTextFieldNaznaka().getText();

                    Date datumIntervencije
                            = new SimpleDateFormat("dd.MM.yyyy")
                                    .parse(kkf.getjTextFieldDatumIntervencije().getText());

                    boolean dodatnaDokumentacija = i.isSnimakZuba();
                    boolean anestezija = !naznaka.contains("kontraindikacije za lokalnu anesteziju");

                    StavkaKartona sk = new StavkaKartona(
                            -1,
                            dijagnoza,
                            korisceniMaterijal,
                            terapija,
                            naznaka,
                            dodatnaDokumentacija,
                            anestezija,
                            datumIntervencije,
                            i,
                            null
                    );

                    listaStavki.add(sk);

                    ModelTabeleStavke mts
                            = (ModelTabeleStavke) kkf.getjTableStavke().getModel();

                    mts.osvezi(listaStavki);
                    isprazniPolja();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        kkf.ukloniStavkuActionLisener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = kkf.getjTableStavke().getSelectedRow();

                if (red == -1) {
                    JOptionPane.showMessageDialog(kkf, "Izaberi stavku za brisanje!");
                    return;
                }

                listaStavki.remove(red);

                ModelTabeleStavke mts
                        = (ModelTabeleStavke) kkf.getjTableStavke().getModel();

                mts.osvezi(listaStavki);
            }
        });

    }

    /*public void setStavkaZaIzmenu(StavkaKartona stavka) {
    this.stavkaZaIzmenu = stavka;
    this.kartonZaIzmenu = stavka.getKarton();
    }*/

    public UbaciKartonForma getKkf() {
        return kkf;
    }

    public void setKkf(UbaciKartonForma kkf) {
        this.kkf = kkf;
    }

    private void isprazniPolja() {
        kkf.getjTextFieldDatumIntervencije().setText(" ");
        kkf.getjTextFieldDijagnoza().setText(" ");
        kkf.getjTextFieldKorMaterijal().setText(" ");
        kkf.getjTextFieldNaznaka().setText(" ");
        kkf.getjTextFieldTerapija().setText(" ");

    }
}
