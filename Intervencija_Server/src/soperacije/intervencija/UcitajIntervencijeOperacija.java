/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soperacije.intervencija;

import domen.Intervencija;
import java.util.List;
import soperacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Emilija
 */
public class UcitajIntervencijeOperacija extends ApstraktnaGenerickaOperacija{
   List<Intervencija>lista;
    @Override
    protected void preduslovi(Object param) throws Exception {
        
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
        lista=broker.getAll(new Intervencija(), null);
        
    }

    public List<Intervencija> getLista() {
        return lista;
    }

    public void setLista(List<Intervencija> lista) {
        this.lista = lista;
    }
    
}
