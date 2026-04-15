/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soperacije.medicinskiradnik;

import domen.MedicinskiRadnik;
import java.util.List;
import soperacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Emilija
 */
public class UcitajMedicinskeRadnikeOperacija extends ApstraktnaGenerickaOperacija{
    List<MedicinskiRadnik>lista;
    @Override
    protected void preduslovi(Object param) throws Exception {
       
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
        lista=broker.getAll(new MedicinskiRadnik(), null);
        System.out.println("Klasa UcitajMedicinskeRadnikeOperacija: "+lista);
    }

    public List<MedicinskiRadnik> getLista() {
        return lista;
    }

    
    
}
