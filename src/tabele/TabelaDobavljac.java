/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabele;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Dobavljac;

/**
 *
 * @author Ana
 */
public class TabelaDobavljac extends AbstractTableModel{
    private final String [] kolone={"MATICNI BROJ DOBAVLJACA","PIB DOBAVLJACA","NAZIV DOBAVLJACA","MESTO DOBAVLJACA","ADRESA DOBAVLJACA","TEKUCI RACUN"};
    private List<Dobavljac> listaDobavljaca;

    public TabelaDobavljac(List<Dobavljac> listaKupaca) {
        this.listaDobavljaca = listaKupaca;
    }

    
    
    @Override
    public int getRowCount() {
        return listaDobavljaca.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Dobavljac d=this.listaDobavljaca.get(rowIndex);
        switch(columnIndex){
            case 0:
                return d.getMaticniBrojDobavljaca();
            case 1:
                return d.getPibDobavljaca();
            case 2:
                return d.getNazivDobavljaca();
            case 3:
                return d.getMestoDobavljaca();
            case 4:
                return d.getAdresaDobavljaca();
            case 5:
                return d.getTekuciRacun();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    public void setList(List<Dobavljac> lista){
        this.listaDobavljaca=lista;
        fireTableDataChanged();
    }
    public Dobavljac getSelectedObject(int index){
        return this.listaDobavljaca.get(index);
    }
}
