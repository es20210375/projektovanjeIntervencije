/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import domen.Pacijent;
import domen.StavkaKartona;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Emilija
 */
public class ModelTabeleStavke extends AbstractTableModel{
    List<StavkaKartona>lista=new ArrayList<>();
    String[]kolone={"Dijagnoza","Korisceni materijal","Terapija","Dodatna dokumentacija","Naznaka","Anestezija","Datum intervencije","Naziv intervencije"};
    
    public ModelTabeleStavke(List<StavkaKartona> lista) {
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
        StavkaKartona p=lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getDijagnoza();
            case 1:
                return p.getKorisceniMaterijal();
            case 2:
                return p.getTerapija();
            case 3:
              if(p.getIntervencija().isSnimakZuba()){
                  return "DA";
              }else{
                  return "NE";
              }
            case 4:
                return p.getNaznaka();
            case 5:
                if(p.getNaznaka().contains("kontraindikacije za lokalnu anesteziju")){
                    return "NE";
                }else{
                    return "DA";
                }
            case 6:
                SimpleDateFormat datum=new SimpleDateFormat("dd.MM.yyyy");
                
                return datum.format(p.getDatumIntervencije());
            case 7:
                return p.getIntervencija().getNaziv();
            default:
                throw new AssertionError();
        }
        
    }

    public List<StavkaKartona> getLista() {
        return lista;
    }

    void osvezi(List<StavkaKartona> listaStavki) {
        this.lista = lista;
       fireTableDataChanged();
    }
    
}
