/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soperacije.stavkaKartona;


import domen.StavkaKartona;
import soperacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Emilija
 */
public class DodajStavkuKartona extends ApstraktnaGenerickaOperacija{

    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param==null||!(param instanceof StavkaKartona)){
           throw new Exception("Sistem ne moze da sacuva stavku kartona");
       }
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
        broker.add((StavkaKartona)objekat);
    }
    
}
