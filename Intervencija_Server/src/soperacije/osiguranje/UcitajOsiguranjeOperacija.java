/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soperacije.osiguranje;

import domen.Osiguranje;
import java.util.List;
import soperacije.ApstraktnaGenerickaOperacija;




/**
 *
 * @author Emilija
 */
public class UcitajOsiguranjeOperacija extends ApstraktnaGenerickaOperacija {
    List<Osiguranje>lista;
    @Override
    protected void preduslovi(Object param) throws Exception {
        
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
      lista=broker.getAll(new Osiguranje(), null);
       System.out.println("Klasa UcitajOsiguranjeOperacija: "+lista);
       
    }

    public List<Osiguranje> getLista() {
        return lista;
    }

    public void setLista(List<Osiguranje> lista) {
        this.lista = lista;
    }

   
    
}
