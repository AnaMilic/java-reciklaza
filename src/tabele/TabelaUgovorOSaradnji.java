/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabele;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Ugovor_o_Saradnji;

/**
 *
 * @author Ana
 */
public class TabelaUgovorOSaradnji extends AbstractTableModel{
    private final String[] kolone={"UGOVOR ID","DATUM ZAKLJUCIVANJA","DOBAVLJAC","KUPAC"};
    private List<Ugovor_o_Saradnji> listaUgovora;

    public TabelaUgovorOSaradnji(List<Ugovor_o_Saradnji> listaUgovora) {
        this.listaUgovora = listaUgovora;
    }

    
    @Override
    public int getRowCount() {
        return listaUgovora.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ugovor_o_Saradnji u=this.listaUgovora.get(rowIndex);
        switch(columnIndex){
            case 0:
                return u.getUgovorID();
            case 1:
                return u.getDatumZakljucivanja();
            case 2:
                return u.getDobavljac();
            case 3:
                return u.getKupac();
            default:
                return "";
        }
       
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    public void setList(List<Ugovor_o_Saradnji> lista){
        this.listaUgovora=lista;
        fireTableDataChanged();
    }
    public Ugovor_o_Saradnji getSelectedObject(int index){
        return this.listaUgovora.get(index);
    }
}
