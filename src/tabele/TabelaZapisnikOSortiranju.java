/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabele;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Zapisnik_o_Sortiranju;

/**
 *
 * @author Ana
 */
public class TabelaZapisnikOSortiranju extends AbstractTableModel{
    private final String [] kolone={"ZAPISNIK ID","MESTO","DATUM","NAPOMENA","IME I PREZIME","RADNIK ID"};
    private List<Zapisnik_o_Sortiranju> listaZapisnika;

    public TabelaZapisnikOSortiranju(List<Zapisnik_o_Sortiranju> listaZapisnika) {
        this.listaZapisnika = listaZapisnika;
    }

    
    
    @Override
    public int getRowCount() {
        return listaZapisnika.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Zapisnik_o_Sortiranju z=this.listaZapisnika.get(rowIndex);
        switch(columnIndex){
            case 0:
                return z.getZapisnikID();
            case 1:
                return z.getMesto();
            case 2:
                return z.getDatum();
            case 3:
                return z.getNapomena();
            case 4:
                return z.getImePrezime();
            case 5:
                return z.getRadnik().getRadnikID();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    public void setList(List<Zapisnik_o_Sortiranju> lista){
        this.listaZapisnika=lista;
        fireTableDataChanged();
    }
    public Zapisnik_o_Sortiranju getSelectedObject(int index){
        return this.listaZapisnika.get(index);
    }
}
