/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.MedicinskiRadnik;
import soperacije.login.LogInOperacija;

/**
 *
 * @author Emilija
 */
public class Controller {
    private static  Controller instance;
    public static Controller getInstance(){
        if(instance==null){
            instance=new Controller();
        }return instance;
    }
    private Controller() {
    }

    public MedicinskiRadnik logIn(MedicinskiRadnik mr) throws Exception {
       LogInOperacija lo=new LogInOperacija();
       lo.izvrsiOperaciju(mr, null);
        System.out.println("Klasa controller : "+lo.getMr());
       return lo.getMr();
    }

    
    
    
}
