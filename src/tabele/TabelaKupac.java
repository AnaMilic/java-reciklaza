/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabele;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Kupac;

/**
 *
 * @author Ana
 */
public class TabelaKupac extends AbstractTableModel{
    private final String [] kolone={"MATICNI BROJ KUPCA","PIB KUPCA","NAZIV KUPCA","MESTO KUPCA","ADRESA KUPCA","TELEFON","ZIRO RACUN"};
    private List<Kupac> listaKupaca;

    public TabelaKupac(List<Kupac> listaKupaca) {
        this.listaKupaca = listaKupaca;
    }

    
    
    @Override
    public int getRowCount() {
        return listaKupaca.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Kupac k=this.listaKupaca.get(rowIndex);
        switch(columnIndex){
            case 0:
                return k.getMaticniBrojKupca();
            case 1:
                return k.getPibKupca();
            case 2:
                return k.getNazivKupca();
            case 3:
                return k.getMestoKupca();
            case 4:
                return k.getAdresaKupca();
            case 5:
                return k.getTelefon();
            case 6:
                return k.getZiroRacun();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    public void setList(List<Kupac> lista){
        this.listaKupaca=lista;
        fireTableDataChanged();
    }
    public Kupac getSelectedObject(int index){
        return this.listaKupaca.get(index);
    }
    
}
