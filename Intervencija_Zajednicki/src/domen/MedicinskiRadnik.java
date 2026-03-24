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
public class MedicinskiRadnik implements ApstraktniDomenskiObjekat{
    private int idMedicinskiRadnik;
    private String ime;
    private String prezime;
    private boolean iskustvo;
    private String email;
    private String lozinka;

    public MedicinskiRadnik() {
    }

    public MedicinskiRadnik(int idMedicinskiRadnik, String ime, String prezime, boolean iskustvo, String email, String lozinka) {
        this.idMedicinskiRadnik = idMedicinskiRadnik;
        this.ime = ime;
        this.prezime = prezime;
        this.iskustvo = iskustvo;
        this.email = email;
        this.lozinka = lozinka;
    }

    public int getIdMedicinskiRadnik() {
        return idMedicinskiRadnik;
    }

    public void setIdMedicinskiRadnik(int idMedicinskiRadnik) {
        this.idMedicinskiRadnik = idMedicinskiRadnik;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public boolean isIskustvo() {
        return iskustvo;
    }

    public void setIskustvo(boolean iskustvo) {
        this.iskustvo = iskustvo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    @Override
    public String toString() {
        return "MedicinskiRadnik{" + "ime=" + ime + ", prezime=" + prezime + ", email=" + email + '}';
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
        final MedicinskiRadnik other = (MedicinskiRadnik) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return Objects.equals(this.lozinka, other.lozinka);
    }

    @Override
    public String vratiNazivTabele() {
        return "medicinskiRadnik";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
      List<ApstraktniDomenskiObjekat>lista=new ArrayList<>();
      while(rs.next()){
          int id=rs.getInt("medicinskiRadnik.idMedicinskiRadnik");
          String ime=rs.getString("medicinskiRadnik.ime");
          String prezime=rs.getString("medicinskiRadnik.prezime");
          String lozinka=rs.getString("medicinskiRadnik.lozinka");
          String email=rs.getString("medicinskiRadnik.email");
          boolean iskustvo1=rs.getBoolean("medicinskiRadnik.iskustvo");
          MedicinskiRadnik m=new MedicinskiRadnik(id, ime, prezime, iskustvo1, email, lozinka);
          lista.add(m);
      }
      return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "ime,prezime,iskustvo,lozinka,email";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'"+ime+"','"+prezime+"',"+iskustvo+",'"+lozinka+"','"+email+"'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "medicinskiRadnik.idMedicinskiRadnik="+idMedicinskiRadnik;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRs(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
         return "ime='"+ime+"' prezime='"+prezime+"' iskustvo="+iskustvo+" lozinka='"+lozinka+"' email='"+email+"'";
    }
    
    
    
    
}
