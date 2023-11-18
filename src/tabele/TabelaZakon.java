/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabele;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Zakon;

/**
 *
 * @author Ana
 */
public class TabelaZakon extends AbstractTableModel{
    private final String [] kolone={"ZAKON ID","NAZIV ZAKONA","NAPOMENA"};
    private List<Zakon> listaZakona;

    public TabelaZakon(List<Zakon> listaZakona) {
        this.listaZakona = listaZakona;
    }
    
    
    @Override
    public int getRowCount() {
        return listaZakona.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Zakon z=this.listaZakona.get(rowIndex);
        switch(columnIndex){
            case 0:
                return z.getZakonID();
            case 1:
                return z.getNazivZakona();
            case 2:
                return z.getNapomena();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    public void setList(List<Zakon> lista){
        this.listaZakona=lista;
        fireTableDataChanged();
    }
    public Zakon getSelectedObject(int index){
        return this.listaZakona.get(index);
    }
    
}
