/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soperacije.pacijent;

import domen.Pacijent;
import soperacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Emilija
 */
public class PretraziPacijentaOperacija extends ApstraktnaGenerickaOperacija{
    Pacijent pac;
    @Override
    protected void preduslovi(Object param) throws Exception {
       
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
        int id=(int) objekat;
        String upit=" pacijent JOIN osiguranje osiguranje ON pacijent.idOsiguranje=osiguranje.idOsiguranja WHERE pacijent.idPacijent="+id;
        pac=(Pacijent) broker.getById(new Pacijent(), upit);
    }

    public Pacijent getPac() {
        return pac;
    }

    public void setPac(Pacijent pac) {
        this.pac = pac;
    }
    
}
