/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import cordinator.Cordinator;
import domen.Intervencija;
import domen.Karton;
import domen.MedicinskiRadnik;
import domen.Pacijent;
import domen.StatusKartona;
import domen.StavkaKartona;
import forme.DetaljiIzabranogKartonaForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author Emilija
 */
public class DetaljiIzabranogKartonaController {

    DetaljiIzabranogKartonaForma dikf;
    Karton karton;

    public DetaljiIzabranogKartonaController(DetaljiIzabranogKartonaForma dikf) {
        this.dikf = dikf;
        actionLiseners();
    }

    public void otvoriFormu(Karton k) {
        this.karton = k;
        dikf.setVisible(true);
        proveriArhiviranje();
        pripremiFormu();

    }

    private void pripremiFormu() {
        List<Intervencija> listaInter = Komunikacija.getInstance().ucitajIntervencije();
        ModelTabeleIntervencija mti = new ModelTabeleIntervencija(listaInter);
        dikf.getjTableIntervencija().setModel(mti);

        List<Pacijent> listaPacijenata = Komunikacija.getInstance().ucitajPacijente();
        dikf.getjComboBoxPacijent().removeAllItems();
        for (Pacijent p : listaPacijenata) {
            dikf.getjComboBoxPacijent().addItem(p);
        }

        List<MedicinskiRadnik> listaRadnika = Komunikacija.getInstance().ucitajMedicinskeRadnike();
        dikf.getjComboBoxMedicinskiRadnik().removeAllItems();
        for (MedicinskiRadnik mr : listaRadnika) {
            dikf.getjComboBoxMedicinskiRadnik().addItem(mr);
        }

        dikf.getjComboBoxPacijent().setSelectedItem(karton.getPacijent());
        dikf.getjComboBoxMedicinskiRadnik().setSelectedItem(karton.getMedicinskiRadnik());
        dikf.getjComboBoxStatusKartona().setSelectedItem(karton.getStatusKartona());

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        dikf.getjTextFieldDatumOtvaranja().setText(sdf.format(karton.getDatumOtvaranja()));

        if (karton.getDatumArhiviranja() != null) {
            dikf.getjTextFieldDatumArhiviranja().setText(sdf.format(karton.getDatumArhiviranja()));
        } else {
            dikf.getjTextFieldDatumArhiviranja().setText("/");
        }

        ModelTabeleStavke mts = new ModelTabeleStavke(karton.getStavkaKartona());
        dikf.getjTableStavke().setModel(mts);

        ocistiPoljaZaStavku();
        dikf.getjTextFieldDatumOtvaranja().setEditable(false);
        dikf.getjTextFieldDatumArhiviranja().setEditable(false);
        dikf.getjTextFieldDijagnoza().setEditable(false);
        dikf.getjTextFieldKorisceniMaterijal().setEditable(false);
        dikf.getjTextFieldTerapija().setEditable(false);
        dikf.getjTextFieldNaznake().setEditable(false);
        dikf.getjTextFieldAnestezija().setEditable(false);
        dikf.getjTextFieldDDokumentacija().setEditable(false);
        dikf.getjTextFieldIntervencija().setEditable(false);
        dikf.getjTextFieldDatumIntervencije().setEditable(false);
        dikf.getjComboBoxPacijent().setEnabled(false);
        dikf.getjComboBoxMedicinskiRadnik().setEnabled(false);
        dikf.getjComboBoxStatusKartona().setEnabled(false);
        dikf.getjButtonIzmeniIzabranuStavku().setVisible(false);
        dikf.getjButtonSacuvaj().setVisible(false);
        dikf.getjButtonDodajStavku().setVisible(false);
        dikf.getjButtonIzbrisiStavku().setVisible(false);
       

    }

    private void proveriArhiviranje() {
        Date danas = new Date();
        boolean izmena = false;

        long danaOdOtvaranja
                = (danas.getTime() - karton.getDatumOtvaranja().getTime())
                / (1000 * 60 * 60 * 24);

        if (danaOdOtvaranja > 730) {
            karton.setStatusKartona(StatusKartona.ARHIVIRAN);
            izmena = true;
        }

        Date poslednja = null;

        for (StavkaKartona sk : karton.getStavkaKartona()) {

            if (poslednja == null
                    || sk.getDatumIntervencije().after(poslednja)) {

                poslednja = sk.getDatumIntervencije();
            }
        }

        if (poslednja != null) {

            long danaOdIntervencije
                    = (danas.getTime() - poslednja.getTime())
                    / (1000 * 60 * 60 * 24);

            if (danaOdIntervencije > 366) {
                karton.setStatusKartona(StatusKartona.ARHIVIRAN);
                izmena = true;
            }
        }

        if (izmena) {

            karton.setDatumArhiviranja(danas);

            Komunikacija.getInstance().izmeniKarton(karton);
        }
    }

    private void actionLiseners() {
        dikf.detaljiStavkeActionLisener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = dikf.getjTableStavke().getSelectedRow();

                if (red == -1) {
                    return;
                }

                ModelTabeleStavke mts
                        = (ModelTabeleStavke) dikf.getjTableStavke().getModel();

                StavkaKartona sk = mts.getLista().get(red);

                prikaziStavku(sk);
            }

        });
        dikf.omoguciIzmenuActionLisener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
       
        dikf.getjTextFieldDijagnoza().setEditable(true);
        dikf.getjTextFieldKorisceniMaterijal().setEditable(true);
        dikf.getjTextFieldTerapija().setEditable(true);
        dikf.getjTextFieldNaznake().setEditable(true);
        dikf.getjTextFieldIntervencija().setEditable(false);
        dikf.getjButtonIzmeniIzabranuStavku().setVisible(true);
        dikf.getjButtonSacuvaj().setVisible(true);
        dikf.getjButtonDodajStavku().setVisible(true);
        dikf.getjButtonIzbrisiStavku().setVisible(true);
        dikf.getjTextFieldDatumIntervencije().setEditable(true);
            }
        });
        dikf.izmeniIzabranuStavkuActionLisener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 try {
            int red = dikf.getjTableStavke().getSelectedRow();

            if (red == -1) {
                return;
            }

            ModelTabeleStavke mts =
                    (ModelTabeleStavke) dikf.getjTableStavke().getModel();

            StavkaKartona sk = mts.getLista().get(red);

            sk.setDijagnoza(dikf.getjTextFieldDijagnoza().getText());
            sk.setKorisceniMaterijal(dikf.getjTextFieldKorisceniMaterijal().getText());
            sk.setTerapija(dikf.getjTextFieldTerapija().getText());
            sk.setNaznaka(dikf.getjTextFieldNaznake().getText());

            boolean anestezija = !dikf.getjTextFieldNaznake()
                    .getText()
                    .contains("kontraindikacije za lokalnu anesteziju");

            sk.setAnestezija(anestezija);

            mts.fireTableDataChanged();

            prikaziStavku(sk);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
       
        
            }
        });
        
        
        
        dikf.sacuvajIzmeneActionLisener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            try {

            Pacijent p = (Pacijent) dikf.getjComboBoxPacijent().getSelectedItem();
            MedicinskiRadnik mr = (MedicinskiRadnik) dikf.getjComboBoxMedicinskiRadnik().getSelectedItem();
            StatusKartona status = (StatusKartona) dikf.getjComboBoxStatusKartona().getSelectedItem();

            karton.setPacijent(p);
            karton.setMedicinskiRadnik(mr);
            karton.setStatusKartona(status);

            for (StavkaKartona sk : karton.getStavkaKartona()) {
                sk.setKarton(karton);
            }

            Karton izmena=Komunikacija.getInstance().izmeniKartonIStavku(karton);
            if(izmena!=null){
            JOptionPane.showMessageDialog(dikf,"Sistem je zapamtio karton","Uspeh",JOptionPane.INFORMATION_MESSAGE);
           Cordinator.getInstance().getGlavnaFormaController().pripremiFormu();
           
        }else{
              JOptionPane.showMessageDialog(dikf,"Sistem ne moze da zapamti karton","Greska",JOptionPane.ERROR_MESSAGE);
              
        }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(dikf,"Sistem ne moze da zapamti karton","Greska",JOptionPane.ERROR_MESSAGE);
        }
            
            }
        });
        dikf.dodajStavkuActionLisener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
        try {
            int redIntervencija = dikf.getjTableIntervencija().getSelectedRow();

            if (redIntervencija == -1) {
                return;
            }

            ModelTabeleIntervencija mti =
                    (ModelTabeleIntervencija) dikf.getjTableIntervencija().getModel();

            Intervencija i = mti.getLista().get(redIntervencija);

            String dijagnoza = dikf.getjTextFieldDijagnoza().getText();
            String korisceniMaterijal = dikf.getjTextFieldKorisceniMaterijal().getText();
            String terapija = dikf.getjTextFieldTerapija().getText();
            String naznaka = dikf.getjTextFieldNaznake().getText();

            Date datumIntervencije =
                    new SimpleDateFormat("dd.MM.yyyy")
                            .parse(dikf.getjTextFieldDatumIntervencije().getText());

            boolean dodatnaDokumentacija = i.isSnimakZuba();
            boolean anestezija =
                    !naznaka.contains("kontraindikacije za lokalnu anesteziju");

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
                    karton
            );

            karton.getStavkaKartona().add(sk);

            ModelTabeleStavke mts =
                    (ModelTabeleStavke) dikf.getjTableStavke().getModel();

            mts.osvezi(karton.getStavkaKartona());

            ocistiPoljaZaStavku();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    
            }
        });
        dikf.izbrisiStavkuActionLisener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            int red = dikf.getjTableStavke().getSelectedRow();

        if (red == -1) {
            return;
        }

        karton.getStavkaKartona().remove(red);

        ModelTabeleStavke mts =
                (ModelTabeleStavke) dikf.getjTableStavke().getModel();

        mts.osvezi(karton.getStavkaKartona());

        ocistiPoljaZaStavku();
        
            }    
        });
        dikf.IsprazniZaUnosActionLisener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            ocistiPoljaZaStavku();
            }
        });
    }

    private void ocistiPoljaZaStavku() {
        dikf.getjTextFieldDijagnoza().setText(" ");
        dikf.getjTextFieldKorisceniMaterijal().setText(" ");
        dikf.getjTextFieldTerapija().setText(" ");
        dikf.getjTextFieldNaznake().setText(" ");
        dikf.getjTextFieldAnestezija().setText(" ");
        dikf.getjTextFieldDDokumentacija().setText(" ");
        dikf.getjTextFieldIntervencija().setText(" ");
        dikf.getjTextFieldDatumIntervencije().setText(" ");
    }
   private void prikaziStavku(StavkaKartona sk) {
                dikf.getjTextFieldDijagnoza().setText(sk.getDijagnoza());
                dikf.getjTextFieldKorisceniMaterijal().setText(sk.getKorisceniMaterijal());
                dikf.getjTextFieldTerapija().setText(sk.getTerapija());
                dikf.getjTextFieldNaznake().setText(sk.getNaznaka());
                dikf.getjTextFieldIntervencija().setText(sk.getIntervencija().getNaziv());

                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                dikf.getjTextFieldDatumIntervencije().setText(sdf.format(sk.getDatumIntervencije()));

                if (sk.isAnestezija()) {
                    dikf.getjTextFieldAnestezija().setText("DA");
                } else {
                    dikf.getjTextFieldAnestezija().setText("NE");
                }

                if (sk.isDodatnaDokumentacija()) {
                    dikf.getjTextFieldDDokumentacija().setText("DA");
                } else {
                    dikf.getjTextFieldDDokumentacija().setText("NE");
                }
            }
}
