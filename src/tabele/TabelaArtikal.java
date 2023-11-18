/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabele;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Artikal;

/**
 *
 * @author Ana
 */
public class TabelaArtikal extends AbstractTableModel{

    private final String[] kolone={"SIFRA ARTIKLA","NAZIV ARTIKLA","JEDINICA MERE","TRENUTNA CENA"};
    private List<Artikal> listaArt;

    public TabelaArtikal(List<Artikal> listaArt) {
        this.listaArt = listaArt;
    }
    
    
    @Override
    public int getRowCount() {
        return listaArt.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Artikal a=this.listaArt.get(rowIndex);
        switch(columnIndex){
            case 0:
                return a.getSifraArtikla();
            case 1:
                return a.getNazivArtikla();
            case 2:
                return a.getJm().getNazivJediniceMere();
            case 3:
                return a.getTrenutnaCena();
            default:
                return "";
        }
       
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    public void setList(List<Artikal> lista){
        this.listaArt=lista;
        fireTableDataChanged();
    }
    public Artikal getSelectedObject(int index){
        return this.listaArt.get(index);
    }
}
