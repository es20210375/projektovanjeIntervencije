/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soperacije.kvalifikacija;

import domen.Kvalifikacija;
import domen.Pacijent;
import soperacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Emilija
 */
public class DodajKvalifikacijuOperacija extends ApstraktnaGenerickaOperacija{

    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param==null||!(param instanceof Kvalifikacija)){
           throw new Exception("Sistem ne moze da zapamti kvalifikaciju");
       }
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
        System.out.println("Klasa DodajPacijentaOperacija: "+(Kvalifikacija)objekat);
        broker.add((Kvalifikacija)objekat);
    }
    
}
