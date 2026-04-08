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
public class StavkaKartona implements ApstraktniDomenskiObjekat{
    private int idStavkaKartona;
    private String dijagnoza;
    private String korisceniMaterijal;
    private String terapija;
    private String naznaka;
    private boolean dodatnaDokumentacija;
    private boolean anestezija;
    Date datumIntervencije;
    Intervencija intervencija;
    Karton karton;

    public StavkaKartona() {
    }

    public StavkaKartona(int idStavkaKartona, String dijagnoza, String korisceniMaterijal, String terapija, String naznaka, boolean dodatnaDokumentacija, boolean anestezija, Date datumIntervencije, Intervencija intervencija, Karton karton) {
        this.idStavkaKartona = idStavkaKartona;
        this.dijagnoza = dijagnoza;
        this.korisceniMaterijal = korisceniMaterijal;
        this.terapija = terapija;
        this.naznaka = naznaka;
        this.dodatnaDokumentacija = dodatnaDokumentacija;
        this.anestezija = anestezija;
        this.datumIntervencije = datumIntervencije;
        this.intervencija = intervencija;
        this.karton = karton;
    }

    public Karton getKarton() {
        return karton;
    }

    public void setKarton(Karton karton) {
        this.karton = karton;
    }

    

    public int getIdStavkaKartona() {
        return idStavkaKartona;
    }

    public void setIdStavkaKartona(int idStavkaKartona) {
        this.idStavkaKartona = idStavkaKartona;
    }

    public String getDijagnoza() {
        return dijagnoza;
    }

    public void setDijagnoza(String dijagnoza) {
        this.dijagnoza = dijagnoza;
    }

    public String getKorisceniMaterijal() {
        return korisceniMaterijal;
    }

    public void setKorisceniMaterijal(String korisceniMaterijal) {
        this.korisceniMaterijal = korisceniMaterijal;
    }

    public String getTerapija() {
        return terapija;
    }

    public void setTerapija(String terapija) {
        this.terapija = terapija;
    }

    public String getNaznaka() {
        return naznaka;
    }

    public void setNaznaka(String naznaka) {
        this.naznaka = naznaka;
    }

    public boolean isDodatnaDokumentacija() {
        return dodatnaDokumentacija;
    }

    public void setDodatnaDokumentacija(boolean dodatnaDokumentacija) {
        this.dodatnaDokumentacija = dodatnaDokumentacija;
    }

    public boolean isAnestezija() {
        return anestezija;
    }

    public void setAnestezija(boolean anestezija) {
        this.anestezija = anestezija;
    }

    public Date getDatumIntervencije() {
        return datumIntervencije;
    }

    public void setDatumIntervencije(Date datumIntervencije) {
        this.datumIntervencije = datumIntervencije;
    }

    public Intervencija getIntervencija() {
        return intervencija;
    }

    public void setIntervencija(Intervencija intervencija) {
        this.intervencija = intervencija;
    }

    @Override
    public String toString() {
        return "StavkaKartona{" + "dijagnoza=" + dijagnoza + ", korisceniMaterijal=" + korisceniMaterijal + ", terapija=" + terapija + ", naznaka=" + naznaka + ", dodatnaDokumentacija=" + dodatnaDokumentacija + ", anestezija=" + anestezija + ", datumIntervencije=" + datumIntervencije + ", intervencija=" + intervencija + ", karton=" + karton + '}';
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
        final StavkaKartona other = (StavkaKartona) obj;
        if (!Objects.equals(this.dijagnoza, other.dijagnoza)) {
            return false;
        }
        if (!Objects.equals(this.korisceniMaterijal, other.korisceniMaterijal)) {
            return false;
        }
        return Objects.equals(this.terapija, other.terapija);
    }

    @Override
    public String vratiNazivTabele() {
       return "stavkaKartona";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();

    while (rs.next()) {
        int id = rs.getInt("stavkaKartona.idStavkeKartona");

        String dijagnoza = rs.getString("stavkaKartona.dijagnoza");
        String materijal = rs.getString("stavkaKartona.korisceniMaterijal");
        String terapija = rs.getString("stavkaKartona.terapija");
        String naznaka = rs.getString("stavkaKartona.naznaka");

        boolean dodatna = rs.getBoolean("stavkaKartona.dodatnaDokumentacija");
        boolean anestezija = rs.getBoolean("stavkaKartona.anestezija");

        Date datum = new Date(rs.getDate("stavkaKartona.datumIntervencije").getTime());

        // Intervencija FULL
        int idIntervencija = rs.getInt("intervencija.idIntervencija");
        String naziv = rs.getString("intervencija.naziv");
        String opis = rs.getString("intervencija.opis");
        boolean snimak = rs.getBoolean("intervencija.snimakZuba");

        Intervencija i = new Intervencija(idIntervencija, naziv, opis, snimak);

        // Karton FULL
        int idKarton = rs.getInt("karton.idKarton");
        Date datumOtvaranja = new Date(rs.getDate("karton.datumOtvaranja").getTime());
        Date datumArhiviranja = new Date(rs.getDate("karton.datumArhiviranja").getTime());
        StatusKartona status = StatusKartona.valueOf(rs.getString("karton.statusKartona"));

        // MR
        int idMR = rs.getInt("medicinskiRadnik.idMedicinskiRadnik");
        String imeMR = rs.getString("medicinskiRadnik.ime");
        String prezimeMR = rs.getString("medicinskiRadnik.prezime");
        String email = rs.getString("medicinskiRadnik.email");
        String lozinka = rs.getString("medicinskiRadnik.lozinka");
        boolean iskustvo = rs.getBoolean("medicinskiRadnik.iskustvo");

        MedicinskiRadnik mr = new MedicinskiRadnik(idMR, imeMR, prezimeMR, iskustvo, email, lozinka);

        // Pacijent
        int idP = rs.getInt("pacijent.idPacijent");
        String imeP = rs.getString("pacijent.ime");
        String prezimeP = rs.getString("pacijent.prezime");
        String kontakt = rs.getString("pacijent.kontaktInformacije");
        Date datumRodjenja = new Date(rs.getDate("pacijent.datumRodjenja").getTime());

        int idOsiguranje = rs.getInt("osiguranje.idOsiguranje");
        String statusOs = rs.getString("osiguranje.statusOsiguranja");

        Osiguranje o = new Osiguranje(idOsiguranje, statusOs);
        Pacijent p = new Pacijent(idP, imeP, prezimeP, kontakt, datumRodjenja, o);

        Karton k = new Karton(idKarton, datumOtvaranja, status, datumArhiviranja, mr, p);

        StavkaKartona sk = new StavkaKartona(id, dijagnoza, materijal, terapija, naznaka,
                dodatna, anestezija, datum, i, k);

        lista.add(sk);
    }
    return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "idKarton,dijagnoza,korisceniMaterijal,terapija,dodatnaDokumentacija,naznaka,anestezija,datumIntervencije,idIntervencija,";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return karton.getIdKarton()+",'"+dijagnoza+"','"+korisceniMaterijal+"','"+terapija+"',"+dodatnaDokumentacija+",'"+naznaka+"',"+anestezija+",'"+datumIntervencije+"',"+intervencija.getIdIntervencija();
    }

    @Override
    public String vratiPrimarniKljuc() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRs(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
       return "idKarton="+karton.getIdKarton()+" dijagnoza='"+dijagnoza+"' korisceniMaterijal='"+korisceniMaterijal+"' terapija='"+terapija+"' dodatnaDokumentacija="+dodatnaDokumentacija+" naznaka='"+naznaka+"' anestezija="+anestezija+" datumIntervencije='"+datumIntervencije+"' idIntervencija="+intervencija.getIdIntervencija();
    }
    
    
}
