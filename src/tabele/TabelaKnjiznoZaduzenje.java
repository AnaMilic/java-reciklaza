/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabele;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Knjizno_Zaduzenje;

/**
 *
 * @author Ana
 */
public class TabelaKnjiznoZaduzenje extends AbstractTableModel{
    private final String [] kolone={"MATICNI BROJ DOBAVLJACA","MATICNI BROJ KUPCA","BROJ ZADUZENJA","DATUM IZDAVANJA","MESTO IZDAVANJA","NAPOMENA","NAZIV DOBAVLJACA","RADNIK"};
    private List<Knjizno_Zaduzenje> listaZaduzenja;

    public TabelaKnjiznoZaduzenje(List<Knjizno_Zaduzenje> listaZaduzenja) {
        this.listaZaduzenja = listaZaduzenja;
    }

    
    
    @Override
    public int getRowCount() {
        return listaZaduzenja.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Knjizno_Zaduzenje k=this.listaZaduzenja.get(rowIndex);
        switch(columnIndex){
            case 0:
                return k.getDobavljac().getMaticniBrojDobavljaca();
            case 1:
                return k.getKupac().getMaticniBrojKupca();
            case 2:
                return k.getBrojZaduzenja();
            case 3:
                return k.getDatumIzdavanja();
            case 4:
                return k.getMestoIzdavanja();
            case 5:
                return k.getNapomena();
            case 6:
                return k.getNazivDobavljaca();
            case 7:
                return k.getRadnik();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    public void setList(List<Knjizno_Zaduzenje> lista){
        this.listaZaduzenja=lista;
        fireTableDataChanged();
    }
    public Knjizno_Zaduzenje getSelectedObject(int index){
        return this.listaZaduzenja.get(index);
    }
}
