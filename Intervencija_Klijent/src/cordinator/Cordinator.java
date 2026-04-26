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
import controllers.IzmeniKartonController;
import controllers.IzmeniPacijentaController;
import controllers.KreirajKartonController;
import controllers.UcitajKartonOdredjenogController;
import controllers.UcitajOsiguranjeController;
import controllers.UcitajPacijenteController;
import domen.Pacijent;
import domen.StavkaKartona;
import forme.DetaljiIzabranogKartonaForma;
import forme.DetaljiIzabranogPacijentaForma;
import forme.DodajIntervencijuForma;
import forme.DodajKvalifikacijuForma;
import forme.DodajPacijentaForma;
import forme.LoginForma;
import forme.GlavnaForma;
import forme.IzmeniKartonForma;
import forme.IzmeniPacijentaForma;
import forme.KreirajKartonForma;
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
    private IzmeniPacijentaController izmeniPacijentaController;
    private KreirajKartonController kreirajKartonController;
    private UcitajKartonOdredjenogController ucitajKartonOdredjenogController;
    private DodajIntervencijuController dodajIntervencijuController;
    private DetaljiIzabranogKartonaController detaljiIzabranogKartonaController;
    private IzmeniKartonController izmeniKartonController;
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
    public void otvoriIzmeniPacijentaFormu(Pacijent p){
        izmeniPacijentaController=new IzmeniPacijentaController(new IzmeniPacijentaForma(p),p);
        izmeniPacijentaController.otvoriFormu();
    }

    public IzmeniPacijentaController getIzmeniPacijentaController() {
        return izmeniPacijentaController;
    }

    public void setIzmeniPacijentaController(IzmeniPacijentaController izmeniPacijentaController) {
        this.izmeniPacijentaController = izmeniPacijentaController;
    }

    public void otvoriFormuKreirajKarton() {
        kreirajKartonController=new KreirajKartonController(new KreirajKartonForma());
        kreirajKartonController.otvoriFormu();
    }

    public KreirajKartonController getKreirajKartonController() {
        return kreirajKartonController;
    }

    public void setKreirajKartonController(KreirajKartonController kreirajKartonController) {
        this.kreirajKartonController = kreirajKartonController;
    }

    public GlavnaFormaController getGlavnaFormaController() {
        return glavnaFormaController;
    }

    public void setGlavnaFormaController(GlavnaFormaController glavnaFormaController) {
        this.glavnaFormaController = glavnaFormaController;
    }

    public void otvoriFormuDetaljiIzabranog(Pacijent p) {
        ucitajKartonOdredjenogController=new UcitajKartonOdredjenogController(new DetaljiIzabranogPacijentaForma(p));
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

    public void otvoriFormuIzabraneStavke(StavkaKartona sk) {
        detaljiIzabranogKartonaController=new DetaljiIzabranogKartonaController(new DetaljiIzabranogKartonaForma(sk));
        detaljiIzabranogKartonaController.otvoriFormu(sk);
    }

    public void otvoriFormuIzmeniKarton(StavkaKartona sk) {
       izmeniKartonController =new IzmeniKartonController(new IzmeniKartonForma(sk));
       izmeniKartonController.otvoriFormu(sk);
    }

    public IzmeniKartonController getIzmeniKartonController() {
        return izmeniKartonController;
    }

    public void setIzmeniKartonController(IzmeniKartonController izmeniKartonController) {
        this.izmeniKartonController = izmeniKartonController;
    }

    public LoginController getLoginController() {
        return loginController;
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }
    
    
    
    
}
