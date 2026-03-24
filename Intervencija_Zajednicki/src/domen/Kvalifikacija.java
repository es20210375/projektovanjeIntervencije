/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Emilija
 */
public class Kvalifikacija implements ApstraktniDomenskiObjekat{
    private int idKvalifikacija;
    private String naziv;

    public Kvalifikacija() {
    }

    public Kvalifikacija(int idKvalifikacija, String naziv) {
        this.idKvalifikacija = idKvalifikacija;
        this.naziv = naziv;
    }

    public int getIdKvalifikacija() {
        return idKvalifikacija;
    }

    public void setIdKvalifikacija(int idKvalifikacija) {
        this.idKvalifikacija = idKvalifikacija;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return "Kvalifikacija{" + "naziv=" + naziv + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Kvalifikacija other = (Kvalifikacija) obj;
        return Objects.equals(this.naziv, other.naziv);
    }

    @Override
    public String vratiNazivTabele() {
        return "kvalifikacija";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat>lista=new ArrayList<>();
      while(rs.next()){
          int id=rs.getInt("kvalifikacija.idKvalifikacija");
          String naziv1=rs.getString("kvalifikacija.naziv");
         Kvalifikacija kv=new Kvalifikacija(id, naziv1);
          lista.add(kv);
      }
      return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
       return "naziv";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'"+naziv+"'";
    }

    @Override
    public String vratiPrimarniKljuc() {
       return "kvalifikacija.idKvalifikacija="+idKvalifikacija;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRs(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "naziv='"+naziv+"'";
    }
    
}
