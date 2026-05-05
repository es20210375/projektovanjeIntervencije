/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soperacije.pacijent;

import domen.Pacijent;
import java.util.List;
import soperacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Emilija
 */
public class VratiPacijenteKriterijumImeOperacija extends ApstraktnaGenerickaOperacija{
    List<Pacijent>lista;
    @Override
    protected void preduslovi(Object param) throws Exception {
       
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
        String ime=(String)objekat;
        String uslov=" pacijent JOIN osiguranje osiguranje ON pacijent.idOsiguranje=osiguranje.idOsiguranja\n" +
" WHERE pacijent.ime LIKE '"+ime+"'";
         lista=broker.getAll(new Pacijent(),uslov);
    }

    public List<Pacijent> getLista() {
        return lista;
    }

    public void setLista(List<Pacijent> lista) {
        this.lista = lista;
    }
    
}
