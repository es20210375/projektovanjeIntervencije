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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
