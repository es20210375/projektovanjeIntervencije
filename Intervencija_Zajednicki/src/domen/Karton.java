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
public class Karton implements ApstraktniDomenskiObjekat {

    private int idKarton;
    Date datumOtvaranja;
    StatusKartona statusKartona;
    Date datumArhiviranja;
    MedicinskiRadnik medicinskiRadnik;
    Pacijent pacijent;
    List<StavkaKartona> stavkaKartona = new ArrayList<>();

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
        return "Karton{" + "datumOtvaranja=" + datumOtvaranja + ", statusKartona=" + statusKartona + ", datumArhiviranja=" + datumArhiviranja + ", medicinskiRadnik=" + medicinskiRadnik + ", pacijent=" + pacijent + '}';
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
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
    List<Karton> kartoni = new ArrayList<>();

    while (rs.next()) {

        int idKarton = rs.getInt("karton.idKarton");

        Karton k = null;

        for (Karton postojeci : kartoni) {
            if (postojeci.getIdKarton() == idKarton) {
                k = postojeci;
                break;
            }
        }

        if (k == null) {

            Date datumOtvaranja = new Date(rs.getDate("karton.datumOtvaranja").getTime());

            java.sql.Date sqlDatumArhiviranja = rs.getDate("karton.datumArhiviranja");
            Date datumArhiviranja = null;

            if (sqlDatumArhiviranja != null) {
                datumArhiviranja = new Date(sqlDatumArhiviranja.getTime());
            }

            StatusKartona status = StatusKartona.valueOf(rs.getString("karton.statusKartona"));

            MedicinskiRadnik mr = new MedicinskiRadnik(
                    rs.getInt("medicinskiRadnik.idMedicinskiRadnik"),
                    rs.getString("medicinskiRadnik.ime"),
                    rs.getString("medicinskiRadnik.prezime"),
                    rs.getBoolean("medicinskiRadnik.iskustvo"),
                    rs.getString("medicinskiRadnik.email"),
                    rs.getString("medicinskiRadnik.lozinka")
            );

            Osiguranje o = new Osiguranje(
                    rs.getInt("osiguranje.idOsiguranja"),
                    rs.getString("osiguranje.statusOsiguranja")
            );

            Pacijent p = new Pacijent(
                    rs.getInt("pacijent.idPacijent"),
                    rs.getString("pacijent.ime"),
                    rs.getString("pacijent.prezime"),
                    rs.getString("pacijent.kontaktInformacije"),
                    new Date(rs.getDate("pacijent.datumRodjenja").getTime()),
                    o
            );

            k = new Karton(idKarton, datumOtvaranja, status, datumArhiviranja, mr, p);
            k.setStavkaKartona(new ArrayList<>());

            kartoni.add(k);
            lista.add(k);
        }

        int idStavka = rs.getInt("stavkaKartona.idStavkeKartona");

        if (!rs.wasNull()) {

            boolean postoji = false;

            for (StavkaKartona postojeca : k.getStavkaKartona()) {
                if (postojeca.getIdStavkaKartona() == idStavka) {
                    postoji = true;
                    break;
                }
            }

            if (!postoji) {

                StavkaKartona sk = new StavkaKartona();
                sk.setIdStavkaKartona(idStavka);
                sk.setKarton(k);

                sk.setDijagnoza(rs.getString("stavkaKartona.dijagnoza"));
                sk.setTerapija(rs.getString("stavkaKartona.terapija"));
                sk.setKorisceniMaterijal(rs.getString("stavkaKartona.korisceniMaterijal"));
                sk.setNaznaka(rs.getString("stavkaKartona.naznaka"));
                sk.setDodatnaDokumentacija(rs.getBoolean("stavkaKartona.dodatnaDokumentacija"));
                sk.setAnestezija(rs.getBoolean("stavkaKartona.anestezija"));

                java.sql.Date sqlDatum = rs.getDate("stavkaKartona.datumIntervencije");

                if (sqlDatum != null) {
                    sk.setDatumIntervencije(new Date(sqlDatum.getTime()));
                }

                Intervencija i = new Intervencija(
                        rs.getInt("intervencija.idIntervencija"),
                        rs.getString("intervencija.naziv"),
                        rs.getString("intervencija.opis"),
                        rs.getBoolean("intervencija.snimakZuba")
                );

                sk.setIntervencija(i);

                k.getStavkaKartona().add(sk);
            }
        }
    }

    return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "datumOtvaranja,statusKartona,datumArhiviranja,idMedicinskiRadnik,idPacijent";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        java.sql.Date sqlDatumOtvaranja = new java.sql.Date(datumOtvaranja.getTime());

        String datumArh = "null";
        if (datumArhiviranja != null) {
            datumArh = "'" + new java.sql.Date(datumArhiviranja.getTime()) + "'";
        }

        return "'" + sqlDatumOtvaranja + "','" + statusKartona + "'," + datumArh + ","
                + medicinskiRadnik.getIdMedicinskiRadnik() + "," + pacijent.getIdPacijent();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "karton.idKarton=" + idKarton;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRs(ResultSet rs) throws Exception {
         Karton k = null;
    List<StavkaKartona> stavke = new ArrayList<>();

    while (rs.next()) {

        if (k == null) {
            int idKarton = rs.getInt("karton.idKarton");

            Date datumOtvaranja = new Date(rs.getDate("karton.datumOtvaranja").getTime());

            java.sql.Date sqlDatumArhiviranja = rs.getDate("karton.datumArhiviranja");
            Date datumArhiviranja = null;
            if (sqlDatumArhiviranja != null) {
                datumArhiviranja = new Date(sqlDatumArhiviranja.getTime());
            }

            StatusKartona status = StatusKartona.valueOf(rs.getString("karton.statusKartona"));

            MedicinskiRadnik mr = new MedicinskiRadnik(
                    rs.getInt("medicinskiRadnik.idMedicinskiRadnik"),
                    rs.getString("medicinskiRadnik.ime"),
                    rs.getString("medicinskiRadnik.prezime"),
                    rs.getBoolean("medicinskiRadnik.iskustvo"),
                    rs.getString("medicinskiRadnik.email"),
                    rs.getString("medicinskiRadnik.lozinka")
            );

            Osiguranje o = new Osiguranje(
                    rs.getInt("osiguranje.idOsiguranja"),
                    rs.getString("osiguranje.statusOsiguranja")
            );

            Pacijent p = new Pacijent(
                    rs.getInt("pacijent.idPacijent"),
                    rs.getString("pacijent.ime"),
                    rs.getString("pacijent.prezime"),
                    rs.getString("pacijent.kontaktInformacije"),
                    new Date(rs.getDate("pacijent.datumRodjenja").getTime()),
                    o
            );

            k = new Karton(idKarton, datumOtvaranja, status, datumArhiviranja, mr, p);
        }

        int idStavka = rs.getInt("stavkaKartona.idStavkeKartona");

        if (!rs.wasNull()) {

            boolean postoji = false;

            for (StavkaKartona postojeca : stavke) {
                if (postojeca.getIdStavkaKartona() == idStavka) {
                    postoji = true;
                    break;
                }
            }

            if (!postoji) {

                StavkaKartona sk = new StavkaKartona();
                sk.setKarton(k);
                sk.setIdStavkaKartona(idStavka);

                sk.setDijagnoza(rs.getString("stavkaKartona.dijagnoza"));
                sk.setTerapija(rs.getString("stavkaKartona.terapija"));
                sk.setKorisceniMaterijal(rs.getString("stavkaKartona.korisceniMaterijal"));
                sk.setNaznaka(rs.getString("stavkaKartona.naznaka"));
                sk.setDodatnaDokumentacija(rs.getBoolean("stavkaKartona.dodatnaDokumentacija"));
                sk.setAnestezija(rs.getBoolean("stavkaKartona.anestezija"));

                java.sql.Date sqlDatum = rs.getDate("stavkaKartona.datumIntervencije");
                if (sqlDatum != null) {
                    sk.setDatumIntervencije(new Date(sqlDatum.getTime()));
                }

                Intervencija i = new Intervencija(
                        rs.getInt("intervencija.idIntervencija"),
                        rs.getString("intervencija.naziv"),
                        rs.getString("intervencija.opis"),
                        rs.getBoolean("intervencija.snimakZuba")
                );

                sk.setIntervencija(i);

                stavke.add(sk);
            }
        }
    }

    if (k != null) {
        k.setStavkaKartona(stavke);
    }

    return k;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        java.sql.Date sqlDatumOtvaranja = new java.sql.Date(datumOtvaranja.getTime());

        String datumArh = "null";
        if (datumArhiviranja != null) {
            datumArh = "'" + new java.sql.Date(datumArhiviranja.getTime()) + "'";
        }

        return "datumOtvaranja='" + sqlDatumOtvaranja + "', "
                + "statusKartona='" + statusKartona + "', "
                + "datumArhiviranja=" + datumArh + ", "
                + "idMedicinskiRadnik=" + medicinskiRadnik.getIdMedicinskiRadnik() + ", "
                + "idPacijent=" + pacijent.getIdPacijent();
    }

    @Override
    public void postaviGenerisaniKljuc(int id) {
        this.idKarton = id;
    }
    

}
