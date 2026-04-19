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
public class Intervencija implements ApstraktniDomenskiObjekat{
   private int idIntervencija;
   private String naziv;
   private String opis;
   private boolean snimakZuba;

    public Intervencija() {
    }

    public Intervencija(int idIntervencija, String naziv, String opis, boolean snimakZuba) {
        this.idIntervencija = idIntervencija;
        this.naziv = naziv;
        this.opis = opis;
        this.snimakZuba = snimakZuba;
    }

    public int getIdIntervencija() {
        return idIntervencija;
    }

    public void setIdIntervencija(int idIntervencija) {
        this.idIntervencija = idIntervencija;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public boolean isSnimakZuba() {
        return snimakZuba;
    }

    public void setSnimakZuba(boolean snimakZuba) {
        this.snimakZuba = snimakZuba;
    }

    @Override
    public String toString() {
        return "Intervencija{" + "naziv=" + naziv + ", opis=" + opis + ", snimakZuba=" + snimakZuba + '}';
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
        final Intervencija other = (Intervencija) obj;
        return Objects.equals(this.naziv, other.naziv);
    }

    @Override
    public String vratiNazivTabele() {
       return "intervencija";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat>lista=new ArrayList<>();
      while(rs.next()){
          int id=rs.getInt("intervencija.idIntervencija");
          String naziv=rs.getString("intervencija.naziv");
          String opis=rs.getString("intervencija.opis");
          
          boolean snimakZuba=rs.getBoolean("intervencija.snimakZuba");
          Intervencija i=new Intervencija(id, naziv, opis, snimakZuba);
          lista.add(i);
      }
      return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
         return "naziv,opis,snimakZuba";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        //'naziv','opis',snimakzuba;
       return "'" + naziv + "','" + opis + "'," + (snimakZuba ? 1 : 0);
    }

    @Override
    public String vratiPrimarniKljuc() {
      return "intervencija.idIntervencija="+idIntervencija;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRs(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
    return "naziv='" + naziv + "', opis='" + opis + "', snimakZuba=" + (snimakZuba ? 1 : 0);
    }

    @Override
    public void postaviGenerisaniKljuc(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
}
