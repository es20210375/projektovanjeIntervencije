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
      List<Pacijent> svi = Komunikacija.getInstance().ucitajPacijente();
    List<Pacijent> filtrirani = new ArrayList<>();

    for (Pacijent p : svi) {
        if (upf.getjRadioButtonDA().isSelected()) {
            if (p.getOsiguranje().getStatusOsiguranja().equalsIgnoreCase("DA")) {
                filtrirani.add(p);
            }
        } else if (upf.getjRadioButtonNE().isSelected()) {
            if (p.getOsiguranje().getStatusOsiguranja().equalsIgnoreCase("NE")) {
                filtrirani.add(p);
            }
        }
    }
    prikaziRezultat(filtrirani);
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
         List<Pacijent> svi = Komunikacija.getInstance().ucitajPacijente();
    List<Pacijent> filtrirani = new ArrayList<>();

    String tekst = upf.getjTextFieldImePrezime().getText().trim().toLowerCase();
    String[] delovi = tekst.split(" ");

    for (Pacijent p : svi) {
        String ime = p.getIme().toLowerCase();
        String prezime = p.getPrezime().toLowerCase();

        
        if (delovi.length == 1) {
            if (ime.equals(delovi[0]) || prezime.equals(delovi[0])) {
                filtrirani.add(p);
            }
        }

       
        else if (delovi.length == 2) {
            if (ime.equals(delovi[0]) && prezime.equals(delovi[1])) {
                filtrirani.add(p);
            }
        }
    }

    prikaziRezultat(filtrirani);
    }
    
    
}
