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
public class DodajPacijentaOperacija extends ApstraktnaGenerickaOperacija{
    
    @Override
    protected void preduslovi(Object param) throws Exception {
       if(param==null||!(param instanceof Pacijent)){
           throw new Exception("Sistem ne moze da kreira pacijenta");
       }
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
        System.out.println("Klasa DodajPacijentaOperacija: "+(Pacijent)objekat);
       broker.add((Pacijent)objekat);
    }
    
}
