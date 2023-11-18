/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabele;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Prijemnica;

/**
 *
 * @author Ana
 */
public class TabelaPrijemnica extends AbstractTableModel{
    private final String[] kolone={"BROJ PRIJEMNICE","DATUM IZDAVANJA","NACIN OTPREME","MESTO IZDAVANJA","DOBAVLJAC","KUPAC","RADNIK - PRIMIO ROBU","UKUPAN IZNOS"};
    private List<Prijemnica> listaPrijemnica;

    public TabelaPrijemnica(List<Prijemnica> listaPrijemnica) {
        this.listaPrijemnica = listaPrijemnica;
    }
    
    @Override
    public int getRowCount() {
        return listaPrijemnica.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Prijemnica p=this.listaPrijemnica.get(rowIndex);
        switch(columnIndex){
            case 0:
                return p.getBrojPrijemnice();
            case 1:
                return p.getDatumIzdavanja();
            case 2:
                return p.getNacinOtpreme();
            case 3:
                return p.getMestoIzdavanja();
            case 4:
                return p.getDobavljac();
            case 5:
                return p.getKupac();
            case 6:
                return p.getRadnik();
            case 7:
                return p.getIznosUkupno();
            default:
                return "";
        }
       
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    public void setList(List<Prijemnica> lista){
        this.listaPrijemnica=lista;
        fireTableDataChanged();
    }
    public Prijemnica getSelectedObject(int index){
        return this.listaPrijemnica.get(index);
    }
}
