/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import domen.Pacijent;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Emilija
 */
public class ModelTabelePacijenti extends AbstractTableModel {
    List<Pacijent>lista;
    String[]kolone={"Ime","Prezime","Kontakt informacije","Datum rodjenja","Status osiguranja"};
    
    public ModelTabelePacijenti(List<Pacijent> lista) {
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
        Pacijent p=lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getIme();
            case 1:
                return p.getPrezime();
            case 2:
                return p.getKontaktInformacije();
            case 3:
                SimpleDateFormat datum=new SimpleDateFormat("dd.MM.yyyy");
                
                return datum.format(p.getDatumRodjenja());
            case 4:
                return p.getOsiguranje().getStatusOsiguranja();
            default:
                throw new AssertionError();
        }
        
    }

    public List<Pacijent> getLista() {
        return lista;
    }
    
}
