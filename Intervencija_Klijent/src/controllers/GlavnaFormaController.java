/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import cordinator.Cordinator;
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
    List<StavkaKartona>sveStavke;
    ButtonGroup bg;
    public GlavnaFormaController(GlavnaForma gf) {
        this.gf = gf;
        addActionLiseners();
    }

    public void otvoriFormu() {
        
         gf.setVisible(true);
         gf.getjLabelUlogovani().setText(Cordinator.getInstance().getMr().getIme()+" "+Cordinator.getInstance().getMr().getPrezime());
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
                MedicinskiRadnik mr=Cordinator.getInstance().getMr();
                System.out.println(".odjava()"+ mr);
                Komunikacija.getInstance().odjavi(mr);
            }
        });

        
    }

    public void pripremiFormu() {
        sveStavke=Komunikacija.getInstance().ucitajStavkeKartona();
        ModelTabeleStavkeKartona mtsk=new ModelTabeleStavkeKartona(sveStavke);
        gf.getjTableKartoni().setModel(mtsk);
        
    }

    public GlavnaForma getGf() {
        return gf;
    }

    private void filtriraj() {
        
        String tekst = gf.getjTextFieldPretrazi().getText().trim().toLowerCase();

        if (tekst.isEmpty()) {
            gf.getjTableKartoni().setModel(
                    new ModelTabeleStavkeKartona(sveStavke)
            );
            return;
        }

        List<StavkaKartona> filtrirana = new ArrayList<>();

        for (StavkaKartona sk : sveStavke) {

            
            if (gf.getjRadioButtonPacijent().isSelected()) {

                String ime = sk.getKarton().getPacijent().getIme().toLowerCase();
                String prezime = sk.getKarton().getPacijent().getPrezime().toLowerCase();

                if (poklapanje(ime, prezime, tekst)) {
                    filtrirana.add(sk);
                }
            }

           
            else if (gf.getjRadioButtonMedicinskiRadnik().isSelected()) {

                String ime = sk.getKarton().getMedicinskiRadnik().getIme().toLowerCase();
                String prezime = sk.getKarton().getMedicinskiRadnik().getPrezime().toLowerCase();

                if (poklapanje(ime, prezime, tekst)) {
                    filtrirana.add(sk);
                }
            }

            
            else if (gf.getjRadioButtonIntervencija().isSelected()) {

                 String naziv = normalizuj(sk.getIntervencija().getNaziv().toLowerCase());
                 String unos = normalizuj(tekst);

                   String[] delovi = unos.split(" ");

                   boolean poklapaSe = true;

                       for (String deo : delovi) {
                         if (!naziv.contains(deo)) {
                           poklapaSe = false;
                                   break;
                                     }
                              }

                         if (poklapaSe) {
                              filtrirana.add(sk);
                                 }
            }
            else if (gf.getjRadioButtonGodinaOtvaranja().isSelected()) {

                    try {
                     int unetaGodina = Integer.parseInt(tekst);

                     Date datumOtvaranja = sk.getKarton().getDatumOtvaranja();

                          if (datumOtvaranja != null) {
                        Calendar cal = Calendar.getInstance();
                       cal.setTime(datumOtvaranja);

                           int godina = cal.get(Calendar.YEAR);

                             if (godina == unetaGodina) {
                                 filtrirana.add(sk);
                                    }
                            }

                         } catch (NumberFormatException e) {
                                   JOptionPane.showMessageDialog(gf,
                                "Morate uneti godinu (npr. 2023)",
                                               "Greska",
                                       JOptionPane.ERROR_MESSAGE);
                                       return;
                                   }
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
        gf.getjTableKartoni().setModel(
                new ModelTabeleStavkeKartona(filtrirana)
        );
       bg.clearSelection();
    }

    private boolean poklapanje(String ime, String prezime, String unos) {
        
        String[] delovi = unos.split(" ");

        
        if (delovi.length == 2) {
            return ime.equals(delovi[0]) && prezime.equals(delovi[1]);
        }

       
        return ime.equals(unos) || prezime.equals(unos);
    }
    
    private String normalizuj(String tekst) {
    String n = Normalizer.normalize(tekst, Normalizer.Form.NFD);
    return n.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
}

    public void osveziTabelu() {
         ModelTabeleStavkeKartona mt =
        (ModelTabeleStavkeKartona) gf.getjTableKartoni().getModel();

        mt.fireTableDataChanged();
    }

    public void ugasiFormu() {
       gf.dispose();
    }
    
    
    
    
    }

    
    
    

