/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soperacije.login;

import domen.MedicinskiRadnik;
import java.util.List;
import soperacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Emilija
 */
public class LogInOperacija extends ApstraktnaGenerickaOperacija{
    MedicinskiRadnik mr;
    @Override
    protected void preduslovi(Object param) throws Exception {
      
    }

    @Override
    public void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
        List<MedicinskiRadnik>mr=broker.getAll((MedicinskiRadnik)objekat, null);
        System.out.println("Klasa LoginOperacija: "+mr);
        if(mr.contains((MedicinskiRadnik)objekat)){
            for (MedicinskiRadnik medicinskiRadnik : mr) {
                if(medicinskiRadnik.equals((MedicinskiRadnik)objekat)){
                    this.mr=medicinskiRadnik;
                    return;
                }
            }
        }else{
            mr=null;
        }
        
        
        
    }

    public MedicinskiRadnik getMr() {
        return mr;
    }

    public void setMr(MedicinskiRadnik mr) {
        this.mr = mr;
    }
    
}
