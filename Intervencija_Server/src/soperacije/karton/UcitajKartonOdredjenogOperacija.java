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
public class UcitajKartonOdredjenogOperacija extends ApstraktnaGenerickaOperacija{
    List<Karton>lista;
    @Override
    protected void preduslovi(Object param) throws Exception {
       
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
        int id=(int)objekat;
        String uslov = " karton JOIN pacijent pacijent ON karton.idPacijent = pacijent.idPacijent "
        + "JOIN medicinskiRadnik medicinskiRadnik ON karton.idMedicinskiRadnik = medicinskiRadnik.idMedicinskiRadnik "
        + "JOIN osiguranje osiguranje ON pacijent.idOsiguranje = osiguranje.idOsiguranja "
                + "WHERE pacijent.idPacijent="+id;
       lista=broker.getAll(new Karton(),uslov);
    }

    public List<Karton> getLista() {
        return lista;
    }

    public void setLista(List<Karton> lista) {
        this.lista = lista;
    }
    
}
