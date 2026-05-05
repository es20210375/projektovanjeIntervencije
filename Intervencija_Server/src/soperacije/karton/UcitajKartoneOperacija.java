/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soperacije.karton;

import domen.Karton;
import java.util.List;
import soperacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Emilija
 */
public class UcitajKartoneOperacija extends ApstraktnaGenerickaOperacija{
     List<Karton>lista;
    @Override
    protected void preduslovi(Object param) throws Exception {
        
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
        String uslov = " karton\n" +
"JOIN pacijent pacijent ON karton.idPacijent = pacijent.idPacijent \n" +
"JOIN medicinskiRadnik medicinskiRadnik ON karton.idMedicinskiRadnik = medicinskiRadnik.idMedicinskiRadnik \n" +
"JOIN osiguranje osiguranje ON pacijent.idOsiguranje = osiguranje.idOsiguranja \n" +
"LEFT JOIN stavkaKartona stavkaKartona ON karton.idKarton = stavkaKartona.idKarton \n" +
"LEFT JOIN intervencija intervencija ON stavkaKartona.idIntervencija = intervencija.idIntervencija";

            lista = broker.getAll(new Karton(), uslov);
    }

    public List<Karton> getLista() {
        return lista;
    }

    public void setLista(List<Karton> lista) {
        this.lista = lista;
    }
    
}
