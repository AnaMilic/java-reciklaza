/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabele;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Radnik;

/**
 *
 * @author Ana
 */
public class TabelaRadnik extends AbstractTableModel{
    private final String [] kolone={"RADNIK ID","JMBG","IME I PREZIME","TELEFON"};
    private List<Radnik> listaRadnika;

    public TabelaRadnik(List<Radnik> listaRadnika) {
        this.listaRadnika = listaRadnika;
    }

    
    @Override
    public int getRowCount() {
        return listaRadnika.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Radnik r=this.listaRadnika.get(rowIndex);
        switch(columnIndex){
            case 0:
                return r.getRadnikID();
            case 1:
                return r.getJmbg();
            case 2:
                return r.getImePrezime();
            case 3:
                return r.getTelefon();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    public void setList(List<Radnik> lista){
        this.listaRadnika=lista;
        fireTableDataChanged();
    }
    public Radnik getSelectedObject(int index){
        return this.listaRadnika.get(index);
    }
}
