/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import domen.Karton;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Emilija
 */
public class ModelTabeleKartonOdredjenogPacijenta extends AbstractTableModel{
    List<Karton>lista=new ArrayList<>();
    String[]kolone={"Pacijent","Medicinski radnik","Datum otvaranja","Datum arhiviranja","Status"};
    
    public ModelTabeleKartonOdredjenogPacijenta(List<Karton> lista) {
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
                if(k.getDatumArhiviranja()==null){
                    return " ";
                }else{
                    SimpleDateFormat datum1=new SimpleDateFormat("dd.MM.yyyy");
                    return datum1.format(k.getDatumArhiviranja());
                }
            case 4:
                return k.getStatusKartona();
            default:
                throw new AssertionError();
        }
        
    }

    public List<Karton> getLista() {
        return lista;
    }

}
