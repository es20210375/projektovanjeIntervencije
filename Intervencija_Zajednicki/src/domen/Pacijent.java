/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Emilija
 */
public class Pacijent implements ApstraktniDomenskiObjekat{
    private int idPacijent;
    private String ime;
    private String prezime;
    private String kontaktInformacije;
    Date datumRodjenja;
    private Osiguranje osiguranje;

    public Pacijent() {
    }

    public Pacijent(int idPacijent, String ime, String prezime, String kontaktInformacije, Date datumRodjenja, Osiguranje osiguranje) {
        this.idPacijent = idPacijent;
        this.ime = ime;
        this.prezime = prezime;
        this.kontaktInformacije = kontaktInformacije;
        this.datumRodjenja = datumRodjenja;
        this.osiguranje = osiguranje;
    }

    public int getIdPacijent() {
        return idPacijent;
    }

    public void setIdPacijent(int idPacijent) {
        this.idPacijent = idPacijent;
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

    public String getKontaktInformacije() {
        return kontaktInformacije;
    }

    public void setKontaktInformacije(String kontaktInformacije) {
        this.kontaktInformacije = kontaktInformacije;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public Osiguranje getOsiguranje() {
        return osiguranje;
    }

    public void setOsiguranje(Osiguranje osiguranje) {
        this.osiguranje = osiguranje;
    }

    @Override
    public String toString() {
        return "Pacijent{" + "ime=" + ime + ", prezime=" + prezime + ", kontaktInformacije=" + kontaktInformacije + ", datumRodjenja=" + datumRodjenja + ", osiguranje=" + osiguranje + '}';
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
        final Pacijent other = (Pacijent) obj;
        if (!Objects.equals(this.kontaktInformacije, other.kontaktInformacije)) {
            return false;
        }
        return Objects.equals(this.datumRodjenja, other.datumRodjenja);
    }

    @Override
    public String vratiNazivTabele() {
        return "pacijent";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
       List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();

    while (rs.next()) {
        int id = rs.getInt("pacijent.idPacijent");
        String ime = rs.getString("pacijent.ime");
        String prezime = rs.getString("pacijent.prezime");
        String kontakt = rs.getString("pacijent.kontaktInformacije");

        java.sql.Date sqlDatum = rs.getDate("pacijent.datumRodjenja");
        Date datumRodjenja = new Date(sqlDatum.getTime());

        int idOsiguranje = rs.getInt("osiguranje.idOsiguranje");
        String status = rs.getString("osiguranje.statusOsiguranja");

        Osiguranje o = new Osiguranje(idOsiguranje, status);
        Pacijent p = new Pacijent(id, ime, prezime, kontakt, datumRodjenja, o);

        lista.add(p);
    }
    return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
       return "ime,prezime,kontaktInformacije,datumRodjenja,idOsiguranje";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
      java.sql.Date sqlDatum = new java.sql.Date(datumRodjenja.getTime());
       return "'" + ime + "','" + prezime + "','" + kontaktInformacije + "','" + sqlDatum + "'," 
           + osiguranje.getIdOsiguranje();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "pacijent.idPacijent="+idPacijent;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRs(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
       java.sql.Date sqlDatum = new java.sql.Date(datumRodjenja.getTime());

    return "ime='" + ime + "', " +
           "prezime='" + prezime + "', " +
           "kontaktInformacije='" + kontaktInformacije + "', " +
           "datumRodjenja='" + sqlDatum + "', " +
           "idOsiguranje=" + osiguranje.getIdOsiguranje();
    }
    
    
    
    
    
}
