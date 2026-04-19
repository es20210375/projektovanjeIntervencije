/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soperacije.stavkaKartona;

import domen.StavkaKartona;
import java.util.List;
import soperacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Emilija
 */
public class UcitajStavkeKartonaOperacija extends ApstraktnaGenerickaOperacija{
    List<StavkaKartona>lista;
    @Override
    protected void preduslovi(Object param) throws Exception {
       
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
        String uslov=" stavkakartona JOIN karton karton ON stavkakartona.idKarton=karton.idKarton\n" +
" JOIN intervencija intervencija ON stavkakartona.idIntervencija=intervencija.idIntervencija \n" +
" JOIN pacijent pacijent ON karton.idPacijent=pacijent.idPacijent JOIN medicinskiRadnik medicinskiRadnik\n" +
" ON  karton.idMedicinskiRadnik=medicinskiRadnik.idMedicinskiRadnik JOIN osiguranje osiguranje \n" +
"ON pacijent.idOsiguranje = osiguranje.idOsiguranja";
       lista=broker.getAll(new StavkaKartona(),uslov);
    }

    public List<StavkaKartona> getLista() {
        return lista;
    }

    public void setLista(List<StavkaKartona> lista) {
        this.lista = lista;
    }
    
}
