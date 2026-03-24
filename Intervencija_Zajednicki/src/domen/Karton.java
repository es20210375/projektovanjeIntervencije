/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Emilija
 */
public class Karton implements ApstraktniDomenskiObjekat{
  private int idKarton;
  Date datumOtvaranja; 
  StatusKartona statusKartona;
  Date datumArhiviranja;
  MedicinskiRadnik medicinskiRadnik;
  Pacijent pacijent;
  List<StavkaKartona>stavkaKartona=new ArrayList<>();

    public Karton() {
    }

    public Karton(int idKarton, Date datumOtvaranja, StatusKartona statusKartona, Date datumArhiviranja, MedicinskiRadnik medicinskiRadnik, Pacijent pacijent) {
        this.idKarton = idKarton;
        this.datumOtvaranja = datumOtvaranja;
        this.statusKartona = statusKartona;
        this.datumArhiviranja = datumArhiviranja;
        this.medicinskiRadnik = medicinskiRadnik;
        this.pacijent = pacijent;
    }

    public int getIdKarton() {
        return idKarton;
    }

    public void setIdKarton(int idKarton) {
        this.idKarton = idKarton;
    }

    public Date getDatumOtvaranja() {
        return datumOtvaranja;
    }

    public void setDatumOtvaranja(Date datumOtvaranja) {
        this.datumOtvaranja = datumOtvaranja;
    }

    public StatusKartona getStatusKartona() {
        return statusKartona;
    }

    public void setStatusKartona(StatusKartona statusKartona) {
        this.statusKartona = statusKartona;
    }

    public Date getDatumArhiviranja() {
        return datumArhiviranja;
    }

    public void setDatumArhiviranja(Date datumArhiviranja) {
        this.datumArhiviranja = datumArhiviranja;
    }

    public MedicinskiRadnik getMedicinskiRadnik() {
        return medicinskiRadnik;
    }

    public void setMedicinskiRadnik(MedicinskiRadnik medicinskiRadnik) {
        this.medicinskiRadnik = medicinskiRadnik;
    }

    public Pacijent getPacijent() {
        return pacijent;
    }

    public void setPacijent(Pacijent pacijent) {
        this.pacijent = pacijent;
    }

    public List<StavkaKartona> getStavkaKartona() {
        return stavkaKartona;
    }

    public void setStavkaKartona(List<StavkaKartona> stavkaKartona) {
        this.stavkaKartona = stavkaKartona;
    }

    @Override
    public String toString() {
        return "Karton{" + "datumOtvaranja=" + datumOtvaranja + ", statusKartona=" + statusKartona + ", datumArhiviranja=" + datumArhiviranja + ", medicinskiRadnik=" + medicinskiRadnik + ", pacijent=" + pacijent + ", stavkaKartona=" + stavkaKartona + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Karton other = (Karton) obj;
        if (!Objects.equals(this.datumOtvaranja, other.datumOtvaranja)) {
            return false;
        }
        if (this.statusKartona != other.statusKartona) {
            return false;
        }
        if (!Objects.equals(this.datumArhiviranja, other.datumArhiviranja)) {
            return false;
        }
        if (!Objects.equals(this.medicinskiRadnik, other.medicinskiRadnik)) {
            return false;
        }
        return Objects.equals(this.pacijent, other.pacijent);
    }

    @Override
    public String vratiNazivTabele() {
      return "karton";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
       return "datumOtvaranja,statusKartona,datumArhiviranja,idMedicinskiRadnik,idPacijent";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
       return "'"+datumOtvaranja+"','"+statusKartona+",'"+datumArhiviranja+"',"+medicinskiRadnik.getIdMedicinskiRadnik()+","+pacijent.getIdPacijent();
    }

    @Override
    public String vratiPrimarniKljuc() {
       return "karton.idKarton="+idKarton;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRs(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "datumOtvaranja='"+datumOtvaranja+"' statusKartova='"+statusKartona+"' datumArhiviranja='"+datumArhiviranja+"' idMedicinskiRadnik="+medicinskiRadnik.getIdMedicinskiRadnik()+" idPacijent="+pacijent.getIdPacijent();
    }
  
}
