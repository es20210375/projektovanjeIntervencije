/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import domen.StatusKartona;
import domen.StavkaKartona;
import forme.DetaljiIzabranogKartonaForma;
import java.text.SimpleDateFormat;
import java.util.Date;
import komunikacija.Komunikacija;

/**
 *
 * @author Emilija
 */
public class DetaljiIzabranogKartonaController {

    DetaljiIzabranogKartonaForma dikf;
    StavkaKartona stavka;

    public DetaljiIzabranogKartonaController(DetaljiIzabranogKartonaForma dikf) {
        this.dikf = dikf;
    }

    public void otvoriFormu(StavkaKartona sk) {
        stavka = sk;
        dikf.setVisible(true);
        pripremiFormu();
    }

    private void pripremiFormu() {

        Date danas = new Date();

        long razlikaOtvaranje = danas.getTime() - stavka.getKarton().getDatumOtvaranja().getTime();
        long brojDanaOtvaranje = razlikaOtvaranje / (1000 * 60 * 60 * 24);

        long razlikaIntervencija = danas.getTime() - stavka.getDatumIntervencije().getTime();
        long brojDanaIntervencija = razlikaIntervencija / (1000 * 60 * 60 * 24);

        if (brojDanaIntervencija > 366 || brojDanaOtvaranje > 730) {
            stavka.getKarton().setStatusKartona(StatusKartona.ARHIVIRAN);

            if (stavka.getKarton().getDatumArhiviranja() == null) {
                stavka.getKarton().setDatumArhiviranja(danas);
            }

            Komunikacija.getInstance().izmeniKarton(stavka.getKarton());
        }

        dikf.getjTextFieldDijagnoza().setText(stavka.getDijagnoza());

        if (stavka.isAnestezija()) {
            dikf.getjTextFieldAnestezija().setText("DA");
        } else {
            dikf.getjTextFieldAnestezija().setText("NE");
        }

        if (stavka.isDodatnaDokumentacija()) {
            dikf.getjTextFieldDDokumentacija().setText("DA");
        } else {
            dikf.getjTextFieldDDokumentacija().setText("NE");
        }

        if (stavka.getKarton().getDatumArhiviranja() == null) {
            dikf.getjTextFieldDatumArhiviranja().setText("/");
        } else {
            SimpleDateFormat datum = new SimpleDateFormat("dd.MM.yyyy");
            dikf.getjTextFieldDatumArhiviranja().setText(
                    datum.format(stavka.getKarton().getDatumArhiviranja()));
        }

        dikf.getjTextFieldTerapija().setText(stavka.getTerapija());
        dikf.getjTextFieldIntervencija().setText(stavka.getIntervencija().getNaziv());
        dikf.getjTextFieldNaznake().setText(stavka.getNaznaka());
        dikf.getjTextFieldStatus().setText(stavka.getKarton().getStatusKartona() + " ");
    }

}
