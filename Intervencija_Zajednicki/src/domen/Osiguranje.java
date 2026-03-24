/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Emilija
 */
public class Osiguranje implements ApstraktniDomenskiObjekat{
    private int idOsiguranje;
    private String statusOsiguranja;

    public Osiguranje() {
    }

    public Osiguranje(int idOsiguranje, String statusOsiguranja) {
        this.idOsiguranje = idOsiguranje;
        this.statusOsiguranja = statusOsiguranja;
    }

   

    public int getIdOsiguranje() {
        return idOsiguranje;
    }

    public void setIdOsiguranje(int idOsiguranje) {
        this.idOsiguranje = idOsiguranje;
    }

    public String getStatusOsiguranja() {
        return statusOsiguranja;
    }

    public void setStatusOsiguranja(String statusOsiguranja) {
        this.statusOsiguranja = statusOsiguranja;
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
        final Osiguranje other = (Osiguranje) obj;
        if (this.idOsiguranje != other.idOsiguranje) {
            return false;
        }
        return this.statusOsiguranja == other.statusOsiguranja;
    }

    @Override
    public String toString() {
        return "Osiguranje{" + "statusOsiguranja=" + statusOsiguranja + '}';
    }

    @Override
    public String vratiNazivTabele() {
        return "osiguranje";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
     List<ApstraktniDomenskiObjekat>lista=new ArrayList<>();
      while(rs.next()){
          int id=rs.getInt("osiguranje.idOsiguranje");
          String statusOsiguranja1=rs.getString("osiguranje.statusOsiguranja");
          Osiguranje o=new Osiguranje(id, statusOsiguranja1);
          lista.add(o);
      }
      return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "statusOsiguranja";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'"+statusOsiguranja+"'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "osiguranje.idOsiguranje="+idOsiguranje;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRs(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
      return "statusOsiguranja='"+statusOsiguranja+"'";
    }
    
}
