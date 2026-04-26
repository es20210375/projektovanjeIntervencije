/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package komunikacija;

import java.io.Serializable;

/**
 *
 * @author Emilija
 */
public enum Operacije  implements Serializable{
    LOGIN,
    DODAJ_PACIJENTA, 
    UCITAJ_OSIGURANJE,
    DODAJ_KVALIFIKACIJU, 
    UCITAJ_PACIJENTE,
    IZBRISI_PACIJENTA, 
    KREIRAJ_PACIJENTA,
    IZMENI_PACIJENTA, 
    UCITAJ_MEDICINSKE_RADNIKE, 
    UCITAJ_INTERVENCIJE,
    UCITAJ_KARTONE,
    DODAJ_KARTON, 
    UCITAJ_ODREDJENI_KARTON,
    DODAJ_INTERVENCIJU, 
    UCITAJ_STAVKE_KARTONA, 
    DODAJ_STAVKU_KARTONA,
    KREIRAJ_KARTON, 
    IZMENI_KARTON,
    IZMENI_STAVKU,
    LOGOUT,
}
