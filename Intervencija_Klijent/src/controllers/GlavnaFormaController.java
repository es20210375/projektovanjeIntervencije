/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import cordinator.Cordinator;
import domen.Karton;
import domen.MedicinskiRadnik;
import domen.StavkaKartona;
import forme.GlavnaForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author Emilija
 */
public class GlavnaFormaController {

    private final GlavnaForma gf;
    List<StavkaKartona> sveStavke;
    ButtonGroup bg;
    List<Karton> listaKartona;

    public GlavnaFormaController(GlavnaForma gf) {
        this.gf = gf;
        addActionLiseners();
    }

    public void otvoriFormu() {

        gf.setVisible(true);
        gf.getjLabelUlogovani().setText(Cordinator.getInstance().getMr().getIme() + " " + Cordinator.getInstance().getMr().getPrezime());
        bg = new ButtonGroup();
        bg.add(gf.getjRadioButtonPacijent());
        bg.add(gf.getjRadioButtonMedicinskiRadnik());
        bg.add(gf.getjRadioButtonIntervencija());
        bg.add(gf.getjRadioButtonGodinaOtvaranja());
        pripremiFormu();
    }

    private void addActionLiseners() {

        gf.getjButtonFiltriraj().addActionListener(e -> filtriraj());

        gf.getjButtonResetuj().addActionListener(e -> {
            gf.getjTextFieldPretrazi().setText("");
            pripremiFormu();

        });
        gf.odjavaAddActionLisener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                odjava(e);
            }

            private void odjava(ActionEvent e) {
                MedicinskiRadnik mr = Cordinator.getInstance().getMr();
                System.out.println(".odjava()" + mr);
                Komunikacija.getInstance().odjavi(mr);
            }
        });

    }

    public void pripremiFormu() {

        listaKartona = Komunikacija.getInstance().ucitajKartone();
        for (Karton k : listaKartona) {
            List<StavkaKartona> stavke = Komunikacija.getInstance().vratiStavkuKartona(k.getIdKarton());
            k.setStavkaKartona(stavke);
        }
        ModelTabeleKartoni mtsk = new ModelTabeleKartoni(listaKartona);
        gf.getjTableKartoni().setModel(mtsk);

    }

    public GlavnaForma getGf() {
        return gf;
    }

    private void filtriraj() {

        String tekst = gf.getjTextFieldPretrazi().getText().trim();
        String[] delovi = tekst.split(" ");
        String ime = delovi[0];
        if (tekst.isEmpty()) {
            gf.getjTableKartoni().setModel(
                    new ModelTabeleKartoni(listaKartona)
            );
            return;
        }

        List<Karton> filtrirana = new ArrayList<>();

        if (gf.getjRadioButtonPacijent().isSelected()) {
            if (delovi.length == 1) {

                filtrirana = Komunikacija.getInstance().vratiListuKartonaKriterijumPacijentIme(ime);
            } else if (delovi.length == 2) {
                filtrirana = Komunikacija.getInstance().vratiListuKartonKriterijumPacijentImePrezime(tekst);
            }

        } else if (gf.getjRadioButtonMedicinskiRadnik().isSelected()) {
            if (delovi.length == 1) {

                filtrirana = Komunikacija.getInstance().vratiListuKartonaKriterijumMedicinskiRadnikIme(ime);
            } else if (delovi.length == 2) {
                filtrirana = Komunikacija.getInstance().vratiListuKartonKriterijumMedicinskiRadnikImePrezime(tekst);
            }

        } else if (gf.getjRadioButtonIntervencija().isSelected()) {

            filtrirana = Komunikacija.getInstance().vratiListuKartonKriterijumIntervencija(tekst);
        } else if (gf.getjRadioButtonGodinaOtvaranja().isSelected()) {

            try {
                int unetaGodina = Integer.parseInt(tekst);
                filtrirana = Komunikacija.getInstance().vratiListuKartonKriterijumKarton(unetaGodina);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(gf,
                        "Morate uneti godinu (npr. 2023)",
                        "Greska",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        if (filtrirana.isEmpty()) {
            JOptionPane.showMessageDialog(gf,
                    "Sistem ne moze da nadje kartone po zadatim kriterijumima",
                    "Greska",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(gf,
                    "Sistem je nasao kartone po zadatim kriterijumima",
                    "Uspeh",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        for (Karton k : filtrirana) {
            List<StavkaKartona> stavke = Komunikacija.getInstance().vratiStavkuKartona(k.getIdKarton());
            k.setStavkaKartona(stavke);
        }
        gf.getjTableKartoni().setModel(
                new ModelTabeleKartoni(filtrirana)
        );
        bg.clearSelection();
    }

    public void osveziTabelu() {
        ModelTabeleKartoni mt
                = (ModelTabeleKartoni) gf.getjTableKartoni().getModel();

        mt.fireTableDataChanged();
    }

    public void ugasiFormu() {
        gf.dispose();
    }

}
