/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import controller.Controller;
import domen.Intervencija;
import domen.Karton;
import domen.Kvalifikacija;
import domen.MedicinskiRadnik;
import domen.Osiguranje;
import domen.Pacijent;
import domen.StavkaKartona;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.OutputKeys;
import komunikacija.Odgovor;
import komunikacija.Posiljalac;
import komunikacija.Primalac;
import komunikacija.Zahtev;

/**
 *
 * @author Emilija
 */
public class ObradaKlijentskihZahteva extends Thread {

    Socket socket;
    Posiljalac posiljalac;
    Primalac primalac;
    MedicinskiRadnik prijavljeni;
    boolean kraj = false;

    public ObradaKlijentskihZahteva(Socket socket) {
        this.socket = socket;
        posiljalac = new Posiljalac(socket);
        primalac = new Primalac(socket);
    }

    @Override
    public void run() {
        while (!kraj) {

            Zahtev zahtev = (Zahtev) primalac.primi();
            Odgovor odgovor = new Odgovor();
            switch (zahtev.getOperacija()) {
                case LOGIN:
                         try {
                    MedicinskiRadnik mr = (MedicinskiRadnik) zahtev.getParametar();

                    boolean vecPrijavljen = false;

                    for (ObradaKlijentskihZahteva o : Controller.getInstance().getOkz()) {
                        if (o.getPrijavljeni() != null) {
                            vecPrijavljen = true;
                            break;
                        }
                    }

                    if (vecPrijavljen) {
                        odgovor.setOdgovor("Moze biti prijavljen samo jedan radnik");
                        posiljalac.posalji(odgovor);

                        socket.close();
                        kraj = true;
                        return;
                    } else {
                        mr = Controller.getInstance().logIn(mr);
                        this.prijavljeni = mr;
                        odgovor.setOdgovor(mr);
                    }

                } catch (Exception e) {
                    odgovor.setOdgovor(null);
                }
                break;
                case DODAJ_PACIJENTA:
                        try {
                    Pacijent p = (Pacijent) zahtev.getParametar();
                    Controller.getInstance().dodajPacijenta(p);
                    odgovor.setOdgovor(null);
                    System.out.println();
                } catch (Exception e) {
                    e.printStackTrace();
                    odgovor.setOdgovor(e);
                }

                break;
                case UCITAJ_OSIGURANJE:
                        try {
                    List<Osiguranje> lista1 = Controller.getInstance().ucitajOsiguranje();
                    odgovor.setOdgovor(lista1);
                } catch (Exception e) {
                    odgovor.setOdgovor(new ArrayList<>());
                    e.printStackTrace();
                }
                break;
                case DODAJ_KVALIFIKACIJU:
                        try {
                    Kvalifikacija kv = (Kvalifikacija) zahtev.getParametar();
                    Controller.getInstance().dodajKvalifikaciju(kv);
                    odgovor.setOdgovor(null);
                } catch (Exception e) {
                    odgovor.setOdgovor(e);
                }
                break;
                case UCITAJ_PACIJENTE:
                    
                        try {
                    List<Pacijent> lista2 = Controller.getInstance().ucitajPacijente();
                    odgovor.setOdgovor(lista2);
                } catch (Exception ex) {
                    odgovor.setOdgovor(ex);
                    ex.printStackTrace();
                }
                break;
                case IZBRISI_PACIJENTA:
                        try {
                    Pacijent p = (Pacijent) zahtev.getParametar();
                    Controller.getInstance().izbrisiPacijenta(p);
                    odgovor.setOdgovor(null);
                } catch (Exception e) {
                    odgovor.setOdgovor(e);
                }
                break;
                case KREIRAJ_PACIJENTA:
                        try {

                    Controller.getInstance().kreirajPacijenta();
                    odgovor.setOdgovor(null);
                } catch (Exception e) {
                    odgovor.setOdgovor(e);
                }
                break;
                case IZMENI_PACIJENTA:
                        try {
                    Pacijent p = (Pacijent) zahtev.getParametar();
                    Controller.getInstance().izmeniPacijenta(p);
                    odgovor.setOdgovor(null);
                } catch (Exception e) {
                    odgovor.setOdgovor(e);
                }
                break;
                case UCITAJ_MEDICINSKE_RADNIKE: {
                    try {
                        List<MedicinskiRadnik> lista3 = Controller.getInstance().ucitajMedicinskeRadnike();
                        odgovor.setOdgovor(lista3);
                    } catch (Exception ex) {
                        odgovor.setOdgovor(new ArrayList<>());
                        Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case UCITAJ_INTERVENCIJE: {
                    try {
                        List<Intervencija> lista4 = Controller.getInstance().ucitajIntervencije();
                        odgovor.setOdgovor(lista4);
                    } catch (Exception ex) {
                        odgovor.setOdgovor(new ArrayList<>());
                        Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                break;
                case UCITAJ_KARTONE: {
                    try {
                        List<Karton> lista5 = Controller.getInstance().ucitajKartone();
                        odgovor.setOdgovor(lista5);
                    } catch (Exception ex) {
                        odgovor.setOdgovor(new ArrayList<>());
                        Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case DODAJ_KARTON:
                        try {
                    Karton k = (Karton) zahtev.getParametar();
                    k = Controller.getInstance().dodajKarton(k);
                    odgovor.setOdgovor(k);
                } catch (Exception e) {
                    odgovor.setOdgovor(e);
                }
                break;
                case UCITAJ_ODREDJENI_KARTON:
                        try {
                    int id = (int) zahtev.getParametar();
                    List<Karton> lista6 = Controller.getInstance().ucitajKartonOdredjenog(id);
                    odgovor.setOdgovor(lista6);
                } catch (Exception ex) {
                    odgovor.setOdgovor(new ArrayList<>());
                    Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;
                case DODAJ_INTERVENCIJU:
                        try {
                    Intervencija inter = (Intervencija) zahtev.getParametar();
                    Controller.getInstance().dodajIntervenciju(inter);
                    odgovor.setOdgovor(null);
                } catch (Exception e) {
                    odgovor.setOdgovor(e);
                }
                break;
                case UCITAJ_STAVKE_KARTONA:
                    
                        try {
                    List<StavkaKartona> lista7 = Controller.getInstance().ucitajStavkeKartona();
                    odgovor.setOdgovor(lista7);
                } catch (Exception ex) {
                    odgovor.setOdgovor(new ArrayList<>());
                    Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
                case DODAJ_STAVKU_KARTONA:
                        try {
                    StavkaKartona s = (StavkaKartona) zahtev.getParametar();
                    Controller.getInstance().dodajStavkuKartona(s);
                    odgovor.setOdgovor(null);
                } catch (Exception e) {
                    odgovor.setOdgovor(e);
                }
                break;
                case KREIRAJ_KARTON:
                    
                        try {
                    Controller.getInstance().kreirajKarton();
                    odgovor.setOdgovor(null);
                } catch (Exception ex) {
                    odgovor.setOdgovor(ex);
                }

                break;
                case IZMENI_KARTON:
                    Karton k = (Karton) zahtev.getParametar();

                    try {
                        Controller.getInstance().izmeniKarton(k);
                        odgovor.setOdgovor(null);
                    } catch (Exception ex) {
                        Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    break;
                case IZMENI_STAVKU:
                    StavkaKartona s = (StavkaKartona) zahtev.getParametar();

                    try {
                        Controller.getInstance().izmeniStavku(s);
                        odgovor.setOdgovor(null);
                    } catch (Exception ex) {
                        odgovor.setOdgovor(ex);
                        Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    break;
                case LOGOUT:
                    MedicinskiRadnik odjava = (MedicinskiRadnik) zahtev.getParametar();
                    System.out.println("niti.ObradaKlijentskihZahteva.run()" + odjava);
                    boolean uspeh = Controller.getInstance().odjavi(odjava);

                    odgovor.setOdgovor(uspeh);
                    posiljalac.posalji(odgovor);
                    System.out.println(Controller.getInstance().getOkz().size());

                    try {
                        socket.close();
                    } catch (IOException ex) {
                        Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    return;

                default:
                    System.out.println("Greska, izabrana operacija ne postoji");
            }
            posiljalac.posalji(odgovor);

        }
    }

    public MedicinskiRadnik getPrijavljeni() {
        return prijavljeni;
    }

    public void setPrijavljeni(MedicinskiRadnik prijavljeni) {
        this.prijavljeni = prijavljeni;
    }

}
