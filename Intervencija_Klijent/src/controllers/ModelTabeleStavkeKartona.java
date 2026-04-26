/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;


import domen.Karton;
import domen.StavkaKartona;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Emilija
 */
public class ModelTabeleStavkeKartona extends AbstractTableModel {
List<StavkaKartona>lista=new ArrayList<>();
    String[]kolone={"Pacijent","Medicinski radnik","Datum otvaranja","Naziv intervencije"};
    
    public ModelTabeleStavkeKartona(List<StavkaKartona> lista) {
        this.lista = lista;
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaKartona k=lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return k.getKarton().getPacijent().getIme()+" "+k.getKarton().getPacijent().getPrezime();
            case 1:
                return k.getKarton().getMedicinskiRadnik().getIme()+" "+k.getKarton().getMedicinskiRadnik().getPrezime();
            case 2:
                SimpleDateFormat datum=new SimpleDateFormat("dd.MM.yyyy");
                return datum.format(k.getKarton().getDatumOtvaranja());
            
            case 3:
                return k.getIntervencija().getNaziv();
            default:
                throw new AssertionError();
        }
        
    }

    public List<StavkaKartona> getLista() {
        return lista;
    }
}
