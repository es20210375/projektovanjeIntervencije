/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soperacije.karton;

import domen.Karton;
import soperacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Emilija
 */
public class DodajKartonOperacija extends ApstraktnaGenerickaOperacija{
    Karton k;
    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param==null||!(param instanceof Karton)){
           throw new Exception("Sistem ne moze da sacuva karton");
       }
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
         k = (Karton) broker.addAndReturn((Karton) objekat);
        System.out.println("soperacije.karton.DodajKartonOperacija.izvrsiOperaciju()"+(Karton)objekat);
    }

    public Karton getK() {
        return k;
    }

    public void setK(Karton k) {
        this.k = k;
    }
    
}
