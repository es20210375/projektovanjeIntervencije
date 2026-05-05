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
public class VratiStavkuKartonaOdredjenogOperacija extends ApstraktnaGenerickaOperacija {

    List<StavkaKartona> stavka;

    @Override
    protected void preduslovi(Object param) throws Exception {

    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
        int id = (int) objekat;
        String uslov
                = " stavkaKartona "
                + "JOIN intervencija ON stavkaKartona.idIntervencija = intervencija.idIntervencija "
                + "JOIN karton ON stavkaKartona.idKarton = karton.idKarton "
                + "JOIN medicinskiRadnik ON karton.idMedicinskiRadnik = medicinskiRadnik.idMedicinskiRadnik "
                + "JOIN pacijent ON karton.idPacijent = pacijent.idPacijent "
                + "JOIN osiguranje ON pacijent.idOsiguranje = osiguranje.idOsiguranja "
                + "WHERE karton.idKarton=" + id;
        stavka = broker.getAll(new StavkaKartona(), uslov);
    }

    public List<StavkaKartona> getStavka() {
        return stavka;
    }

    public void setStavka(List<StavkaKartona> stavka) {
        this.stavka = stavka;
    }

}
