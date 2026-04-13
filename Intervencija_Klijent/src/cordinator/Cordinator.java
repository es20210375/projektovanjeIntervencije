/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cordinator;

import controllers.DodajKvalifikacijuController;
import controllers.GlavnaFormaController;
import controllers.LoginController;
import domen.MedicinskiRadnik;
import controllers.DodajPacijentaController;
import controllers.UcitajOsiguranjeController;
import controllers.UcitajPacijenteController;
import forme.DodajKvalifikacijuForma;
import forme.DodajPacijentaForma;
import forme.LoginForma;
import forme.GlavnaForma;
import forme.UcitajPacijenteForma;

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
    private DodajKvalifikacijuController dodajKvalifikacijuController;
    private UcitajPacijenteController ucitajPacijenteController;
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

    public void otvoriKvalifikacijaFormu() {
        dodajKvalifikacijuController=new DodajKvalifikacijuController(new DodajKvalifikacijuForma());
        dodajKvalifikacijuController.otvoriFormu();
    }

    public DodajKvalifikacijuController getDodajKvalifikacijuController() {
        return dodajKvalifikacijuController;
    }

    public void setDodajKvalifikacijuController(DodajKvalifikacijuController dodajKvalifikacijuController) {
        this.dodajKvalifikacijuController = dodajKvalifikacijuController;
    }

    public void zatvoriFormuDodajKvalifikaciju() {
        dodajKvalifikacijuController.zatvoriFormuDodajKvalifikaciju();
    }

    public void otvoriFormuUcitajPacijente() {
        ucitajPacijenteController=new UcitajPacijenteController(new UcitajPacijenteForma());
        ucitajPacijenteController.otvoriFormu();
    }
    
    
    
}
