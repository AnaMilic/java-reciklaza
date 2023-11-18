/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabele;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.StavkaPrijemnice;

/**
 *
 * @author Ana
 */
public class TabelaStavkePrijemnice extends AbstractTableModel{
    private final String [] kolone={"REDNI BROJ","ARTIKAL","KOLICINA"};
    private List<StavkaPrijemnice> listaStavki;

    public TabelaStavkePrijemnice() {
        listaStavki=new ArrayList<>();
    }

    public TabelaStavkePrijemnice(List<StavkaPrijemnice> listaStavki) {
        this.listaStavki = listaStavki;
    }

    
    
    @Override
    public int getRowCount() {
        return listaStavki.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaPrijemnice sp=this.listaStavki.get(rowIndex);
        switch(columnIndex){
            case 0:
                return sp.getRedniBroj();
            case 1:
                return sp.getArtikal();
            case 2:
                return sp.getKolicina();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    public void setList(List<StavkaPrijemnice> lista){
        this.listaStavki=lista;
        fireTableDataChanged();
    }
    public StavkaPrijemnice getSelectedObject(int index){
        return this.listaStavki.get(index);
    }
}
