/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import domen.Intervencija;
import domen.Pacijent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Emilija
 */
public class ModelTabeleIntervencija extends AbstractTableModel{
    List<Intervencija>lista=new ArrayList<>();
    String[]kolone={"Naziv","Opis","Snimak zuba"};
    
    public ModelTabeleIntervencija(List<Intervencija> lista) {
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
        Intervencija i=lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return i.getNaziv();
            case 1:
                return i.getOpis();
            case 2:
                if(i.isSnimakZuba()){
                    return "DA";
                }else{
                return "NE";
                }
            default:
                throw new AssertionError();
        }
        
    }

    public List<Intervencija> getLista() {
        return lista;
    }
}
