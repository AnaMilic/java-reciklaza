/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabele;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import model.Cena_Artikla;

/**
 *
 * @author Ana
 */
public class TabelaCenaArtikla extends AbstractTableModel{

    private final String [] kolone={"ARTIKAL","DATUM OD","CENA"};
    private List<Cena_Artikla> listaCena;

    public TabelaCenaArtikla(List<Cena_Artikla> listaCena) {
        this.listaCena = listaCena;
    }
    
    
    @Override
    public int getRowCount() {
        return listaCena.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cena_Artikla ca=this.listaCena.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return ca.getArtikal().getSifraArtikla();
            case 1:
                return ca.getDatumOd();
            case 2:
                return ca.getIznosCene();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    public void setList(List<Cena_Artikla> lista){
        this.listaCena=lista;
        fireTableDataChanged();
    }
    public Cena_Artikla getSelectedObject(int index){
        return this.listaCena.get(index);
    }
      
}
