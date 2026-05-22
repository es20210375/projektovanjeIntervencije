/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import domen.Karton;
import domen.MedicinskiRadnik;
import domen.Pacijent;
import domen.StatusKartona;
import domen.StavkaKartona;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Emilija
 */
public class DetaljiIzabranogKartonaForma extends javax.swing.JFrame {

    /**
     * Creates new form DetaljiIzabranogKartonaForma
     */
    public DetaljiIzabranogKartonaForma(Karton k) {
        initComponents();
    }

    public JButton getjButtonDetaljiZaIzabranuStavku() {
        return jButtonDetaljiZaIzabranuStavku;
    }

    public void setjButtonDetaljiZaIzabranuStavku(JButton jButtonDetaljiZaIzabranuStavku) {
        this.jButtonDetaljiZaIzabranuStavku = jButtonDetaljiZaIzabranuStavku;
    }

    public JButton getjButtonIzmeniIzabranuStavku() {
        return jButtonIzmeniIzabranuStavku;
    }

    public void setjButtonIzmeniIzabranuStavku(JButton jButtonIzmeniIzabranuStavku) {
        this.jButtonIzmeniIzabranuStavku = jButtonIzmeniIzabranuStavku;
    }

    public JButton getjButtonOmoguciIzmene() {
        return jButtonOmoguciIzmene;
    }

    public void setjButtonOmoguciIzmene(JButton jButtonOmoguciIzmene) {
        this.jButtonOmoguciIzmene = jButtonOmoguciIzmene;
    }

    public JButton getjButtonSacuvaj() {
        return jButtonSacuvaj;
    }

    public void setjButtonSacuvaj(JButton jButtonSacuvaj) {
        this.jButtonSacuvaj = jButtonSacuvaj;
    }

    public JButton getjButtonDodajStavku() {
        return jButtonDodajStavku;
    }

    public void setjButtonDodajStavku(JButton jButtonDodajStavku) {
        this.jButtonDodajStavku = jButtonDodajStavku;
    }

    public JButton getjButtonIzbrisiStavku() {
        return jButtonIzbrisiStavku;
    }

    public void setjButtonIzbrisiStavku(JButton jButtonIzbrisiStavku) {
        this.jButtonIzbrisiStavku = jButtonIzbrisiStavku;
    }
    
     

    

    public JComboBox<MedicinskiRadnik> getjComboBoxMedicinskiRadnik() {
        return jComboBoxMedicinskiRadnik;
    }

    public void setjComboBoxMedicinskiRadnik(JComboBox<MedicinskiRadnik> jComboBoxMedicinskiRadnik) {
        this.jComboBoxMedicinskiRadnik = jComboBoxMedicinskiRadnik;
    }

    public JComboBox<Pacijent> getjComboBoxPacijent() {
        return jComboBoxPacijent;
    }

    public void setjComboBoxPacijent(JComboBox<Pacijent> jComboBoxPacijent) {
        this.jComboBoxPacijent = jComboBoxPacijent;
    }

    public JComboBox<StatusKartona> getjComboBoxStatusKartona() {
        return jComboBoxStatusKartona;
    }

    public void setjComboBoxStatusKartona(JComboBox<StatusKartona> jComboBoxStatusKartona) {
        this.jComboBoxStatusKartona = jComboBoxStatusKartona;
    }

    public JTable getjTableIntervencija() {
        return jTableIntervencija;
    }

    public void setjTableIntervencija(JTable jTableIntervencija) {
        this.jTableIntervencija = jTableIntervencija;
    }

    public JTable getjTableStavke() {
        return jTableStavke;
    }

    public void setjTableStavke(JTable jTableStavke) {
        this.jTableStavke = jTableStavke;
    }

    public JTextField getjTextFieldDatumIntervencije() {
        return jTextFieldDatumIntervencije;
    }

    public void setjTextFieldDatumIntervencije(JTextField jTextFieldDatumIntervencije) {
        this.jTextFieldDatumIntervencije = jTextFieldDatumIntervencije;
    }

    public JTextField getjTextFieldDatumOtvaranja() {
        return jTextFieldDatumOtvaranja;
    }

    public void setjTextFieldDatumOtvaranja(JTextField jTextFieldDatumOtvaranja) {
        this.jTextFieldDatumOtvaranja = jTextFieldDatumOtvaranja;
    }

    public JTextField getjTextFieldKorisceniMaterijal() {
        return jTextFieldKorisceniMaterijal;
    }

    public void setjTextFieldKorisceniMaterijal(JTextField jTextFieldKorisceniMaterijal) {
        this.jTextFieldKorisceniMaterijal = jTextFieldKorisceniMaterijal;
    }

    
    
    public JTextField getjTextFieldAnestezija() {
        return jTextFieldAnestezija;
    }

    public void setjTextFieldAnestezija(JTextField jTextFieldAnestezija) {
        this.jTextFieldAnestezija = jTextFieldAnestezija;
    }

    public JTextField getjTextFieldDDokumentacija() {
        return jTextFieldDDokumentacija;
    }

    public void setjTextFieldDDokumentacija(JTextField jTextFieldDDokumentacija) {
        this.jTextFieldDDokumentacija = jTextFieldDDokumentacija;
    }

    public JTextField getjTextFieldDatumArhiviranja() {
        return jTextFieldDatumArhiviranja;
    }

    public void setjTextFieldDatumArhiviranja(JTextField jTextFieldDatumArhiviranja) {
        this.jTextFieldDatumArhiviranja = jTextFieldDatumArhiviranja;
    }

    public JTextField getjTextFieldDijagnoza() {
        return jTextFieldDijagnoza;
    }

    public void setjTextFieldDijagnoza(JTextField jTextFieldDijagnoza) {
        this.jTextFieldDijagnoza = jTextFieldDijagnoza;
    }

    public JTextField getjTextFieldIntervencija() {
        return jTextFieldIntervencija;
    }

    public void setjTextFieldIntervencija(JTextField jTextFieldIntervencija) {
        this.jTextFieldIntervencija = jTextFieldIntervencija;
    }

    public JTextField getjTextFieldNaznake() {
        return jTextFieldNaznake;
    }

    public void setjTextFieldNaznake(JTextField jTextFieldNaznake) {
        this.jTextFieldNaznake = jTextFieldNaznake;
    }

    public JTextField getjTextFieldTerapija() {
        return jTextFieldTerapija;
    }

    public void setjTextFieldTerapija(JTextField jTextFieldTerapija) {
        this.jTextFieldTerapija = jTextFieldTerapija;
    }

    public JButton getjButtonIsprazniPoljaZaUnos() {
        return jButtonIsprazniPoljaZaUnos;
    }

    public void setjButtonIsprazniPoljaZaUnos(JButton jButtonIsprazniPoljaZaUnos) {
        this.jButtonIsprazniPoljaZaUnos = jButtonIsprazniPoljaZaUnos;
    }
     
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldDatumArhiviranja = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldDijagnoza = new javax.swing.JTextField();
        jTextFieldTerapija = new javax.swing.JTextField();
        jTextFieldNaznake = new javax.swing.JTextField();
        jTextFieldAnestezija = new javax.swing.JTextField();
        jTextFieldIntervencija = new javax.swing.JTextField();
        jTextFieldDDokumentacija = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxStatusKartona = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxPacijent = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jComboBoxMedicinskiRadnik = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableIntervencija = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldDatumOtvaranja = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableStavke = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldKorisceniMaterijal = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldDatumIntervencije = new javax.swing.JTextField();
        jButtonDetaljiZaIzabranuStavku = new javax.swing.JButton();
        jButtonIzmeniIzabranuStavku = new javax.swing.JButton();
        jButtonOmoguciIzmene = new javax.swing.JButton();
        jButtonSacuvaj = new javax.swing.JButton();
        jButtonDodajStavku = new javax.swing.JButton();
        jButtonIzbrisiStavku = new javax.swing.JButton();
        jButtonIsprazniPoljaZaUnos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Datum arhiviranja (dd.MM.yyyy) : ");

        jLabel2.setText("Dijagnoza :");

        jLabel3.setText("Terapija : ");

        jLabel4.setText("Naznake : ");

        jLabel5.setText("Anestezija : ");

        jLabel6.setText("Intervencija : ");

        jLabel7.setText("Dodatna dokumentacija : ");

        jLabel8.setText("Status :");

        jComboBoxStatusKartona.setModel(new DefaultComboBoxModel(StatusKartona.values()));

        jLabel9.setText("Pacijent : ");

        jLabel10.setText("Medicinski radnik : ");

        jTableIntervencija.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableIntervencija);

        jLabel11.setText("Intervencija : ");

        jLabel12.setText("Datum otvaranja (dd.MM.yyyy) : ");

        jTableStavke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTableStavke);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Stavke kartona :");

        jLabel14.setText("Korisceni materijal : ");

        jLabel15.setText("Datum intervencije (dd.MM.yyyy) : ");

        jButtonDetaljiZaIzabranuStavku.setText("Detalji za izabranu stavku");

        jButtonIzmeniIzabranuStavku.setText("Izmeni izabranu stavku");

        jButtonOmoguciIzmene.setText("Omoguci izmene");

        jButtonSacuvaj.setText("Sacuvaj");

        jButtonDodajStavku.setText("Dodaj stavku");

        jButtonIzbrisiStavku.setText("Izbrisi stavku");

        jButtonIsprazniPoljaZaUnos.setText("Isprazni polja za unos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxPacijent, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxMedicinskiRadnik, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxStatusKartona, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldDatumOtvaranja, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldDatumArhiviranja))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                                        .addGap(54, 54, 54)
                                        .addComponent(jTextFieldKorisceniMaterijal)
                                        .addGap(42, 42, 42)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldDatumIntervencije, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonIsprazniPoljaZaUnos, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonDetaljiZaIzabranuStavku))))
                        .addContainerGap(60, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldDijagnoza, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldTerapija, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldAnestezija, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldIntervencija, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDDokumentacija, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldNaznake, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(117, 117, 117))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonIzmeniIzabranuStavku, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonIzbrisiStavku, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonDodajStavku, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonOmoguciIzmene, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(jComboBoxPacijent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(jComboBoxMedicinskiRadnik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxStatusKartona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jTextFieldDatumOtvaranja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jTextFieldKorisceniMaterijal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jTextFieldDatumArhiviranja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldDijagnoza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldTerapija, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldNaznake, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldAnestezija, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jTextFieldIntervencija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextFieldDDokumentacija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jTextFieldDatumIntervencije, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jButtonOmoguciIzmene)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonSacuvaj)
                                .addGap(33, 33, 33))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonIzmeniIzabranuStavku)
                            .addComponent(jButtonDodajStavku))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonDetaljiZaIzabranuStavku)
                                .addGap(28, 28, 28)
                                .addComponent(jButtonIsprazniPoljaZaUnos)
                                .addGap(52, 52, 52))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButtonIzbrisiStavku)
                                .addContainerGap())))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDetaljiZaIzabranuStavku;
    private javax.swing.JButton jButtonDodajStavku;
    private javax.swing.JButton jButtonIsprazniPoljaZaUnos;
    private javax.swing.JButton jButtonIzbrisiStavku;
    private javax.swing.JButton jButtonIzmeniIzabranuStavku;
    private javax.swing.JButton jButtonOmoguciIzmene;
    private javax.swing.JButton jButtonSacuvaj;
    private javax.swing.JComboBox<MedicinskiRadnik> jComboBoxMedicinskiRadnik;
    private javax.swing.JComboBox<Pacijent> jComboBoxPacijent;
    private javax.swing.JComboBox<StatusKartona> jComboBoxStatusKartona;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableIntervencija;
    private javax.swing.JTable jTableStavke;
    private javax.swing.JTextField jTextFieldAnestezija;
    private javax.swing.JTextField jTextFieldDDokumentacija;
    private javax.swing.JTextField jTextFieldDatumArhiviranja;
    private javax.swing.JTextField jTextFieldDatumIntervencije;
    private javax.swing.JTextField jTextFieldDatumOtvaranja;
    private javax.swing.JTextField jTextFieldDijagnoza;
    private javax.swing.JTextField jTextFieldIntervencija;
    private javax.swing.JTextField jTextFieldKorisceniMaterijal;
    private javax.swing.JTextField jTextFieldNaznake;
    private javax.swing.JTextField jTextFieldTerapija;
    // End of variables declaration//GEN-END:variables

    public void detaljiStavkeActionLisener(ActionListener actionListener) {
    jButtonDetaljiZaIzabranuStavku.addActionListener(actionListener);
    }

    public void omoguciIzmenuActionLisener(ActionListener actionListener) {
    jButtonOmoguciIzmene.addActionListener(actionListener);
    }

    public void izmeniIzabranuStavkuActionLisener(ActionListener actionListener) {
    jButtonIzmeniIzabranuStavku.addActionListener(actionListener);
    }

    


    public void sacuvajIzmeneActionLisener(ActionListener actionListener) {
    jButtonSacuvaj.addActionListener(actionListener);
    }

    public void dodajStavkuActionLisener(ActionListener actionListener) {
        jButtonDodajStavku.addActionListener(actionListener);
    }

    public void izbrisiStavkuActionLisener(ActionListener actionListener) {
        jButtonIzbrisiStavku.addActionListener(actionListener);
    }

    public void IsprazniZaUnosActionLisener(ActionListener actionListener) {
    jButtonIsprazniPoljaZaUnos.addActionListener(actionListener);
    }
}
