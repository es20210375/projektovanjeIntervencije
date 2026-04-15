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
public class IzbrisiPacijentaOperacija extends ApstraktnaGenerickaOperacija{

    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param==null||!(param instanceof Pacijent)){
           throw new Exception("Sistem ne moze da obrise pacijenta");
       }
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
        broker.delete((Pacijent)objekat);
        System.out.println("Klasa IzbrisiPacijentaOperacija: "+(Pacijent)objekat);
    }
    
}
