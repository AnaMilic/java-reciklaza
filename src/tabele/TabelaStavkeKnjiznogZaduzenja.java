/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabele;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.StavkaKnjiznogZaduzenja;

/**
 *
 * @author Ana
 */
public class TabelaStavkeKnjiznogZaduzenja extends AbstractTableModel{
    private final String [] kolone={"REDNI BROJ","SADRZAJ","ARTIKAL"};
    private List<StavkaKnjiznogZaduzenja> listaStavkiKZ;

    public TabelaStavkeKnjiznogZaduzenja(List<StavkaKnjiznogZaduzenja> listaStavkiKZ) {
        this.listaStavkiKZ = listaStavkiKZ;
    }

    
    @Override
    public int getRowCount() {
        return listaStavkiKZ.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaKnjiznogZaduzenja skz=this.listaStavkiKZ.get(rowIndex);
        switch(columnIndex){
            case 0:
                return skz.getRedniBroj();
            case 1:
                return skz.getSadrzaj();
            case 2:
                return skz.getArtikal();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    public void setList(List<StavkaKnjiznogZaduzenja> lista){
        this.listaStavkiKZ=lista;
        fireTableDataChanged();
    }
    public StavkaKnjiznogZaduzenja getSelectedObject(int index){
        return this.listaStavkiKZ.get(index);
    }
    
}
