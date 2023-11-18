/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabele;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Clan;

/**
 *
 * @author Ana
 */
public class TabelaClanOsnovno extends AbstractTableModel{

    private final String [] kolone={"ZAKON","BROJ CLANA","SADRZAJ"};
    private List<Clan> listaClanova;

    public TabelaClanOsnovno(List<Clan> listaClanova) {
        this.listaClanova = listaClanova;
    }
    
    @Override
    public int getRowCount() {
        return listaClanova.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Clan c=this.listaClanova.get(rowIndex);
        switch(columnIndex){
            case 0:
                return c.getZakon().getNazivZakona();
            case 1:
                return c.getBrojClana();
            case 2:
                return c.getSadrzaj();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    public void setList(List<Clan> lista){
        this.listaClanova=lista;
        fireTableDataChanged();
    }
    public Clan getSelectedObject(int index){
        return this.listaClanova.get(index);
    }
    
}
