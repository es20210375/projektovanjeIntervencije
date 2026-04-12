/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cordinator;

import controllers.GlavnaFormaController;
import controllers.LoginController;
import domen.MedicinskiRadnik;
import controllers.DodajPacijentaController;
import controllers.UcitajOsiguranjeController;
import forme.DodajPacijentaForma;
import forme.LoginForma;
import forme.GlavnaForma;

/**
 *
 * @author Emilija
 */
public class Cordinator {
    private static Cordinator instacne;
    private LoginController loginController;
    private GlavnaFormaController glavnaFormaController;
    private MedicinskiRadnik mr;
    private DodajPacijentaController dodajPacijentaController;
    private DodajPacijentaForma dpf=new DodajPacijentaForma();
    public static Cordinator getInstance(){
        if(instacne==null){
            instacne=new Cordinator();
        }return instacne;
    }
    private Cordinator() {
    }

    public void otvoriLogInFormu() {
        loginController=new LoginController(new LoginForma());
        loginController.otvoriFormu();
    }

    public void otvoriGlavnuFormu() {
        glavnaFormaController=new GlavnaFormaController(new GlavnaForma());
        glavnaFormaController.otvoriFormu();
        
    }

    public MedicinskiRadnik getMr() {
        return mr;
    }

    public void setMr(MedicinskiRadnik mr) {
        this.mr = mr;
    }

    public void otvoriFormu() {
       dodajPacijentaController=new DodajPacijentaController(dpf);
       dodajPacijentaController.otvoriFormu();
       
    }

    public DodajPacijentaController getDodajPacijentaController() {
        return dodajPacijentaController;
    }

    public void setDodajPacijentaController(DodajPacijentaController dodajPacijentaController) {
        this.dodajPacijentaController = dodajPacijentaController;
    }

    public void ugasiFormu() {
        dodajPacijentaController.ugasiFormu();
    }
    
    
    
}
