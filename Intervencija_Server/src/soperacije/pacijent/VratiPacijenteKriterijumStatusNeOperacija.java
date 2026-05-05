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
public class VratiPacijenteKriterijumStatusNeOperacija extends ApstraktnaGenerickaOperacija{
   List<Pacijent>lista;
    @Override
    protected void preduslovi(Object param) throws Exception {
        
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
        lista=broker.getAll(new Pacijent()," pacijent JOIN osiguranje osiguranje ON pacijent.idOsiguranje=osiguranje.idOsiguranja\n" +
           "WHERE osiguranje.statusOsiguranja LIKE 'NE'" );
    }

    public List<Pacijent> getLista() {
        return lista;
    }

    public void setLista(List<Pacijent> lista) {
        this.lista = lista;
    }
    
}
