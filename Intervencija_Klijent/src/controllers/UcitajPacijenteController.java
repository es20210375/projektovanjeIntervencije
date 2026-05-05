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
     upf.izbrisiAddActionLisener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
              izbrisi(e);
         }

         private void izbrisi(ActionEvent e) {
           int izabraniRed=upf.getjTablePacijent().getSelectedRow();
           if(izabraniRed==-1){
               JOptionPane.showMessageDialog(upf, "Morate da izaberete red iz tabele", "GRESKA",JOptionPane.ERROR_MESSAGE);
               return;
           }else{
               ModelTabelePacijenti mtp=(ModelTabelePacijenti) upf.getjTablePacijent().getModel();
               Pacijent p=mtp.getLista().get(izabraniRed);
               Komunikacija.getInstance().izbrisiPacijenta(p);
           }
              pripremiFormu();
            
            
         }
     });
             upf.getjRadioButtonDA().addActionListener(e -> filtrirajPoOsiguranju());
             upf.getjRadioButtonNE().addActionListener(e -> filtrirajPoOsiguranju());
             upf.getjButtonFiltriraj().addActionListener(e -> filtrirajPoImenu());
             upf.getjButtonResetuj().addActionListener(e -> {
    pripremiFormu();
});
     
    }

    private void filtrirajPoOsiguranju() {
      
     List<Pacijent>filtriraj=new ArrayList<>();
    
        if (upf.getjRadioButtonDA().isSelected()) {
            filtriraj=Komunikacija.getInstance().vratipacijenteKriterijumStatusaDA();
        } else if (upf.getjRadioButtonNE().isSelected()) {
            filtriraj=Komunikacija.getInstance().vratiPacijenteKriterijumStatusNe();
        }
    
    prikaziRezultat(filtriraj);
    bg.clearSelection();
    }

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

    private void filtrirajPoImenu() {
    List<Pacijent> filtrirani = new ArrayList<>();

    String tekst = upf.getjTextFieldImePrezime().getText().trim();
    String[] delovi = tekst.split(" ");

    
        String ime = delovi[0];
        

        
        if (delovi.length == 1) {
            filtrirani=Komunikacija.getInstance().VratiPacijenteKriterijumIme(ime);
        }

       
        else if (delovi.length == 2) {
         filtrirani=Komunikacija.getInstance().vratiPacijenteKriterijumImePrezime(tekst);
         }

    prikaziRezultat(filtrirani);
    
    
    }}

