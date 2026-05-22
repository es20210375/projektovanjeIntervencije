/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soperacije.karton;

import domen.Karton;
import domen.StavkaKartona;
import java.util.List;
import soperacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Emilija
 */
public class IzmeniKartonSaStavkamaOperacija extends ApstraktnaGenerickaOperacija{
    Karton k;
    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param==null||!(param instanceof Karton)){
           throw new Exception("Sistem ne moze da sacuva stavku kartona");
       }
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
       k = (Karton) objekat;

    
    broker.edit(k);

    
    
    String uslov = " karton "
            + "JOIN pacijent pacijent ON karton.idPacijent = pacijent.idPacijent "
            + "JOIN medicinskiRadnik medicinskiRadnik ON karton.idMedicinskiRadnik = medicinskiRadnik.idMedicinskiRadnik "
            + "JOIN osiguranje osiguranje ON pacijent.idOsiguranje = osiguranje.idOsiguranja "
            + "LEFT JOIN stavkaKartona stavkaKartona ON karton.idKarton = stavkaKartona.idKarton "
            + "LEFT JOIN intervencija intervencija ON stavkaKartona.idIntervencija = intervencija.idIntervencija "
            + "WHERE karton.idKarton = " + k.getIdKarton();

    List<Karton> listaKartona =
            broker.getAll(new Karton(), uslov);

    Karton kartonIzBaze = listaKartona.get(0);

    List<StavkaKartona> stareStavke =
            kartonIzBaze.getStavkaKartona();

    List<StavkaKartona> noveStavke =
            k.getStavkaKartona();

    
    
    
    
    
    for (StavkaKartona nova : noveStavke) {

        nova.setKarton(k);

        boolean postojiUBazi = false;

        for (StavkaKartona stara : stareStavke) {

            if (nova.getIdStavkaKartona()
                    == stara.getIdStavkaKartona()) {

                postojiUBazi = true;
                break;
            }
        }

        
        
        if (!postojiUBazi || nova.getIdStavkaKartona() == -1) {

            broker.add(nova);

        } else {

            broker.edit(nova);
        }
    }

    
    
    
    
    for (StavkaKartona stara : stareStavke) {

        boolean postojiUNovojListi = false;

        for (StavkaKartona nova : noveStavke) {

            if (stara.getIdStavkaKartona()
                    == nova.getIdStavkaKartona()) {

                postojiUNovojListi = true;
                break;
            }
        }

        
        
        if (!postojiUNovojListi) {

            broker.delete(stara);
        }
    }
    }

    public Karton getK() {
        return k;
    }

    public void setK(Karton k) {
        this.k = k;
    }
    
    
}
