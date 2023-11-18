/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabele;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Jedinica_Mere;

/**
 *
 * @author Ana
 */
public class TabelaJedinicaMere extends AbstractTableModel{
    private final String [] kolone={"SIFRA JEDINICE MERE","NAZIV JEDINICE MERE","SKRACENICA"};
    private List<Jedinica_Mere> listaJM;

    public TabelaJedinicaMere(List<Jedinica_Mere> listaJM) {
        this.listaJM = listaJM;
    }

    
    
    @Override
    public int getRowCount() {
        return listaJM.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Jedinica_Mere jm=this.listaJM.get(rowIndex);
        switch(columnIndex){
            case 0:
                return jm.getSifraJediniceMere();
            case 1:
                return jm.getNazivJediniceMere();
            case 2:
                return jm.getSkracenica();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    public void setList(List<Jedinica_Mere> lista){
        this.listaJM=lista;
        fireTableDataChanged();
    }
    public Jedinica_Mere getSelectedObject(int index){
        return this.listaJM.get(index);
    }
}
