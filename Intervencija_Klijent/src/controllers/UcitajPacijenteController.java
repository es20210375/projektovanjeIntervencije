/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import domen.Pacijent;
import forme.UcitajPacijenteForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author Emilija
 */
public class UcitajPacijenteController {
    UcitajPacijenteForma upf;
    
    public UcitajPacijenteController(UcitajPacijenteForma upf) {
        this.upf = upf;
        addActionLisener();
        
    }

    public void otvoriFormu() {
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
    }
    
    
}
