/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soperacije.intervencija;

import domen.Intervencija;
import soperacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Emilija
 */
public class DodajIntervencijuOperacija extends ApstraktnaGenerickaOperacija{
    
    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param==null||!(param instanceof Intervencija)){
           throw new Exception("Sistem ne moze da sacuva intervenciju");
       }
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
      broker.add((Intervencija)objekat);
        
    }
    
}
