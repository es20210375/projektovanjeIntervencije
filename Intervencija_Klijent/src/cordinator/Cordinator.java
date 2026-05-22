/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cordinator;

import controllers.DetaljiIzabranogKartonaController;
import controllers.DodajIntervencijuController;
import controllers.DodajKvalifikacijuController;
import controllers.GlavnaFormaController;
import controllers.LoginController;
import domen.MedicinskiRadnik;
import controllers.DodajPacijentaController;

import controllers.UbaciKartonController;
import controllers.DetaljiIzabranogPacijentaController;
import controllers.UcitajOsiguranjeController;
import controllers.UcitajPacijenteController;
import domen.Karton;
import domen.Pacijent;
import domen.StavkaKartona;
import forme.DetaljiIzabranogKartonaForma;
import forme.DetaljiIzabranogPacijentaForma;
import forme.DodajIntervencijuForma;
import forme.DodajKvalifikacijuForma;
import forme.DodajPacijentaForma;
import forme.LoginForma;
import forme.GlavnaForma;

import forme.IzmeniPacijentaForma;
import forme.UbaciKartonForma;
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
    private UbaciKartonController kreirajKartonController;
    private DetaljiIzabranogPacijentaController ucitajKartonOdredjenogController;
    private DodajIntervencijuController dodajIntervencijuController;
    private DetaljiIzabranogKartonaController detaljiIzabranogKartonaController;
    
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

    public UcitajPacijenteController getUcitajPacijenteController() {
        return ucitajPacijenteController;
    }

    public void isprazniFormu() {
        dodajPacijentaController.isprazniFormu();
    }
    

    public void otvoriFormuKreirajKarton() {
        kreirajKartonController=new UbaciKartonController(new UbaciKartonForma());
        kreirajKartonController.otvoriFormu();
    }

    public UbaciKartonController getKreirajKartonController() {
        return kreirajKartonController;
    }

    public void setKreirajKartonController(UbaciKartonController kreirajKartonController) {
        this.kreirajKartonController = kreirajKartonController;
    }

    public GlavnaFormaController getGlavnaFormaController() {
        return glavnaFormaController;
    }

    public void setGlavnaFormaController(GlavnaFormaController glavnaFormaController) {
        this.glavnaFormaController = glavnaFormaController;
    }

    public void otvoriFormuDetaljiIzabranog(Pacijent p) {
        ucitajKartonOdredjenogController=new DetaljiIzabranogPacijentaController(new DetaljiIzabranogPacijentaForma(p));
        ucitajKartonOdredjenogController.otvoriFormu(p);
    }

    public void otvoriDodajIntervencijuForma() {
       dodajIntervencijuController=new DodajIntervencijuController(new DodajIntervencijuForma());
       dodajIntervencijuController.otvoriFormu();
    }

    public DodajIntervencijuController getDodajIntervencijuController() {
        return dodajIntervencijuController;
    }

    public void setDodajIntervencijuController(DodajIntervencijuController dodajIntervencijuController) {
        this.dodajIntervencijuController = dodajIntervencijuController;
    }

    public void otvoriFormuIzabraneStavke(Karton k) {
        detaljiIzabranogKartonaController=new DetaljiIzabranogKartonaController(new DetaljiIzabranogKartonaForma(k));
        detaljiIzabranogKartonaController.otvoriFormu(k);
    }

    

    public LoginController getLoginController() {
        return loginController;
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

    public DodajPacijentaForma getDpf() {
        return dpf;
    }

    public void setDpf(DodajPacijentaForma dpf) {
        this.dpf = dpf;
    }

    public DetaljiIzabranogPacijentaController getUcitajKartonOdredjenogController() {
        return ucitajKartonOdredjenogController;
    }

    public void setUcitajKartonOdredjenogController(DetaljiIzabranogPacijentaController ucitajKartonOdredjenogController) {
        this.ucitajKartonOdredjenogController = ucitajKartonOdredjenogController;
    }
    
    
    
    
}
