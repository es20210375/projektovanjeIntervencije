/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import domen.Karton;
import domen.Pacijent;
import forme.DetaljiIzabranogPacijentaForma;
import java.util.List;
import komunikacija.Komunikacija;

/**
 *
 * @author Emilija
 */
public class UcitajKartonOdredjenogController {
    DetaljiIzabranogPacijentaForma dipf;

    public UcitajKartonOdredjenogController(DetaljiIzabranogPacijentaForma dipf) {
        this.dipf = dipf;
    }

    public void otvoriFormu(Pacijent p) {
        pripremiFormu(p);
        dipf.setVisible(true);
    }

    private void pripremiFormu(Pacijent p) {
        List<Karton>lista=Komunikacija.getInstance().ucitajKartonZaPacijenta(p.getIdPacijent());
        ModelTabeleKartonOdredjenogPacijenta mtkop=new ModelTabeleKartonOdredjenogPacijenta(lista);
        dipf.getjTablePacijentDetalji().setModel(mtkop);
        dipf.getjTextFieldIme().setText(p.getIme());
        dipf.getjTextFieldPrezime().setText(p.getPrezime());
    }
    
    
}
