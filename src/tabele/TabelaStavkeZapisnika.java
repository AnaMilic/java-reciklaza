/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabele;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.StavkaZapisnika;

/**
 *
 * @author Ana
 */
public class TabelaStavkeZapisnika extends AbstractTableModel{
    private final String [] kolone={"REDNI BROJ","KOLICINA","CENA","ARTIKAL"};
    private List<StavkaZapisnika> listaStavki;

    public TabelaStavkeZapisnika(List<StavkaZapisnika> listaStavki) {
        this.listaStavki = listaStavki;
    }

    public TabelaStavkeZapisnika() {
        listaStavki=new ArrayList<>();
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
        StavkaZapisnika sz=this.listaStavki.get(rowIndex);
        switch(columnIndex){
            case 0:
                return sz.getRedniBroj();
            case 1:
                return sz.getKolicina();
            case 2:
                return sz.getCena();
            case 3:
                return sz.getArtikal();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    public void setList(List<StavkaZapisnika> lista){
        this.listaStavki=lista;
        fireTableDataChanged();
    }
    public StavkaZapisnika getSelectedObject(int index){
        return this.listaStavki.get(index);
    }
}
