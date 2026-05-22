/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import domen.Pacijent;
import forme.UcitajPacijenteForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author Emilija
 */
public class UcitajPacijenteController {
    UcitajPacijenteForma upf;
    ButtonGroup bg;
    
    public UcitajPacijenteController(UcitajPacijenteForma upf) {
        this.upf = upf;
        addActionLisener();
        
    }

    public void otvoriFormu() {
         bg = new ButtonGroup();
         bg.add(upf.getjRadioButtonDA());
         bg.add(upf.getjRadioButtonNE());
        pripremiFormu();
       upf.setVisible(true);
    }

    public void pripremiFormu() {
     List<Pacijent>lista=Komunikacija.getInstance().ucitajPacijente();
     ModelTabelePacijenti mtp=new ModelTabelePacijenti(lista);
     upf.getjTablePacijent().setModel(mtp);
    }

    public UcitajPacijenteForma getUpf() {
        return upf;
    }
    private void addActionLisener() {
     
              upf.getjButtonFiltriraj().addActionListener(e -> filtriraj());

    upf.getjButtonResetuj().addActionListener(e -> {
        pripremiFormu();
        bg.clearSelection();
        upf.getjTextFieldImePrezime().setText("");
    });

     
    }

    /*private void filtrirajPoOsiguranju() {
      
     List<Pacijent>filtriraj=new ArrayList<>();
       
        if (upf.getjRadioButtonDA().isSelected()) {
            filtriraj=Komunikacija.getInstance().vratipacijenteKriterijumStatusaDA();
        } else if (upf.getjRadioButtonNE().isSelected()) {
            filtriraj=Komunikacija.getInstance().vratiPacijenteKriterijumStatusNe();
        }
    
    prikaziRezultat(filtriraj);
    bg.clearSelection();
    }*/

    private void prikaziRezultat(List<Pacijent> lista) {
        if (lista.isEmpty()) {
        JOptionPane.showMessageDialog(upf,
                "Sistem ne moze da nadje pacijente po zadatim kriterijumima",
                "Greska",
                JOptionPane.ERROR_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(upf,
                "Sistem je nasao pacijente po zadatim kriterijumima",
                "Uspeh",
                JOptionPane.INFORMATION_MESSAGE);
    }

    ModelTabelePacijenti mtp = new ModelTabelePacijenti(lista);
    upf.getjTablePacijent().setModel(mtp);
        
    }

    /*private void filtrirajPoImenu() {
    List<Pacijent> filtrirani = new ArrayList<>();

    String tekst = upf.getjTextFieldImePrezime().getText().trim();
    String[] delovi = tekst.split(" ");

    
        String ime = delovi[0];
        

         if (delovi.length == 1 && upf.getjRadioButtonDA().isSelected()) {
        filtrirani = Komunikacija.getInstance().vratiPacijenteKriterijumImeOsiguranjeDa(ime);

    } else if (delovi.length == 1 && upf.getjRadioButtonNE().isSelected()) {
        filtrirani = Komunikacija.getInstance().vratiPacijenteKriterijumImeOsiguranjeNe(ime);

    }
    else if (delovi.length == 1) {
            filtrirani=Komunikacija.getInstance().VratiPacijenteKriterijumIme(ime);
        }

       
        else if (delovi.length == 2) {
         filtrirani=Komunikacija.getInstance().vratiPacijenteKriterijumImePrezime(tekst);
         }
        

    prikaziRezultat(filtrirani);
    
    
    }*/
    private void filtriraj() {
    List<Pacijent> filtrirani = new ArrayList<>();

    String tekst = upf.getjTextFieldImePrezime().getText().trim();

    if (!tekst.isEmpty()) {
        String[] delovi = tekst.split(" ");
        String ime = delovi[0];

        if (delovi.length == 1 && upf.getjRadioButtonDA().isSelected()) {
            filtrirani = Komunikacija.getInstance().vratiPacijenteKriterijumImeOsiguranjeDa(ime);

        } else if (delovi.length == 1 && upf.getjRadioButtonNE().isSelected()) {
            filtrirani = Komunikacija.getInstance().vratiPacijenteKriterijumImeOsiguranjeNe(ime);

        } else if (delovi.length == 1) {
            filtrirani = Komunikacija.getInstance().VratiPacijenteKriterijumIme(ime);

        } else if (delovi.length == 2) {
            filtrirani = Komunikacija.getInstance().vratiPacijenteKriterijumImePrezime(tekst);
        }

    } else {
        if (upf.getjRadioButtonDA().isSelected()) {
            filtrirani = Komunikacija.getInstance().vratipacijenteKriterijumStatusaDA();

        } else if (upf.getjRadioButtonNE().isSelected()) {
            filtrirani = Komunikacija.getInstance().vratiPacijenteKriterijumStatusNe();
        }
    }

    prikaziRezultat(filtrirani);
}
}

