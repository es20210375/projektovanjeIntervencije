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
import komunikacija.Komunikacija;

/**
 *
 * @author Emilija
 */
public class ModelTabeleKartoni extends AbstractTableModel {
    List<Karton>lista=new ArrayList<>();
    
    String[]kolone={"Pacijent","Medicinski radnik","Datum otvaranja","Naziv intervencije"};
    
    public ModelTabeleKartoni(List<Karton> lista) {
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
        Karton k=lista.get(rowIndex);
        
        
        
        switch (columnIndex) {
            case 0:
                return k.getPacijent().getIme()+" "+k.getPacijent().getPrezime();
            case 1:
                return k.getMedicinskiRadnik().getIme()+" "+k.getMedicinskiRadnik().getPrezime();
            case 2:
                SimpleDateFormat datum=new SimpleDateFormat("dd.MM.yyyy");
                return datum.format(k.getDatumOtvaranja());
            
            case 3:
                if (!k.getStavkaKartona().isEmpty()) {
                return k.getStavkaKartona().get(0).getIntervencija().getNaziv();
            }
            return "/";
            default:
                throw new AssertionError();
        }
        
    }

    public List<Karton> getLista() {
        return lista;
    }
}
