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
        lista=broker.getAll(new Karton()," JOIN pacijent ON karton.idPacijent = pacijent.idPacijent\n" +
"JOIN medicinskiRadnik ON karton.idMedicinskiRadnik = medicinskiRadnik.idMedicinskiRadnik\n" +
"JOIN osiguranje ON pacijent.idOsiguranje = osiguranje.idOsiguranja GROUP BY pacijent.idpacijent;");
    }

    public List<Karton> getLista() {
        return lista;
    }

    public void setLista(List<Karton> lista) {
        this.lista = lista;
    }
    
}
