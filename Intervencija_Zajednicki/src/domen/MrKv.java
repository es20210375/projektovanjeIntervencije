/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Emilija
 */
public class MrKv implements ApstraktniDomenskiObjekat{
    MedicinskiRadnik medicinskiRadnik;
    Kvalifikacija kvalifikacija;
    Date vremeZavrsetkaStudija;

    public MrKv() {
    }

    public MrKv(MedicinskiRadnik medicinskiRadnik, Kvalifikacija kvalifikacija, Date vremeZavrsetkaStudija) {
        this.medicinskiRadnik = medicinskiRadnik;
        this.kvalifikacija = kvalifikacija;
        this.vremeZavrsetkaStudija = vremeZavrsetkaStudija;
    }
    

    public MedicinskiRadnik getMedicinskiRadnik() {
        return medicinskiRadnik;
    }

    public void setMedicinskiRadnik(MedicinskiRadnik medicinskiRadnik) {
        this.medicinskiRadnik = medicinskiRadnik;
    }

    public Kvalifikacija getKvalifikacija() {
        return kvalifikacija;
    }

    public void setKvalifikacija(Kvalifikacija kvalifikacija) {
        this.kvalifikacija = kvalifikacija;
    }

    public Date getVremeZavrsetkaStudija() {
        return vremeZavrsetkaStudija;
    }

    public void setVremeZavrsetkaStudija(Date vremeZavrsetkaStudija) {
        this.vremeZavrsetkaStudija = vremeZavrsetkaStudija;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MrKv other = (MrKv) obj;
        if (!Objects.equals(this.medicinskiRadnik, other.medicinskiRadnik)) {
            return false;
        }
        if (!Objects.equals(this.kvalifikacija, other.kvalifikacija)) {
            return false;
        }
        return Objects.equals(this.vremeZavrsetkaStudija, other.vremeZavrsetkaStudija);
    }

    @Override
    public String toString() {
        return "MrKv{" + "medicinskiRadnik=" + medicinskiRadnik + ", kvalifikacija=" + kvalifikacija + ", vremeZavrsetkaStudija=" + vremeZavrsetkaStudija + '}';
    }

    @Override
    public String vratiNazivTabele() {
       return "MrKv";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
       return "vremeZavrsetkaStudija";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'"+vremeZavrsetkaStudija+"'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "MrKv.idMedicinskiRadnik="+medicinskiRadnik.getIdMedicinskiRadnik()+" AND MrKv.idKvalifikacija="+kvalifikacija.getIdKvalifikacija();
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRs(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
       return "vremeZavrsetkaStudija='"+vremeZavrsetkaStudija+"'";
    }
    
}
