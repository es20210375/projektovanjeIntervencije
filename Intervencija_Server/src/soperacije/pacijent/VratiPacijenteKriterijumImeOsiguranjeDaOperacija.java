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
public class VratiPacijenteKriterijumImeOsiguranjeDaOperacija extends ApstraktnaGenerickaOperacija{
    List<Pacijent> pac;
    @Override
    protected void preduslovi(Object param) throws Exception {
        
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
        String ime=(String)objekat;
        String uslov=" pacijent JOIN osiguranje osiguranje ON pacijent.idOsiguranje=osiguranje.idOsiguranja\n" +
" WHERE pacijent.ime LIKE '"+ime+"' AND osiguranje.statusOsiguranja LIKE 'DA' ";
         pac=broker.getAll(new Pacijent(),uslov);
    }

    public List<Pacijent> getPac() {
        return pac;
    }

    public void setPac(List<Pacijent> pac) {
        this.pac = pac;
    }

   
    
}
