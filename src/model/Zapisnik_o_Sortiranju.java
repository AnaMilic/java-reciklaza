/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.DomenskiObjekat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ana
 */
public class Zapisnik_o_Sortiranju extends DomenskiObjekat{

    private int zapisnikID;
    private String mesto;
    private Date datum;
    private String napomena;
    private String imePrezime;
    private Radnik radnik;
    private boolean imePrezimeIzmenjeno=false;

    public Zapisnik_o_Sortiranju() {
    }

    public Zapisnik_o_Sortiranju(int zapisnikID, String mesto, Date datum, String napomena, String imePrezime, Radnik radnik) {
        this.zapisnikID = zapisnikID;
        this.mesto = mesto;
        this.datum = datum;
        this.napomena = napomena;
        this.imePrezime = imePrezime;
        this.radnik = radnik;
    }

    
    public int getZapisnikID() {
        return zapisnikID;
    }

    public void setZapisnikID(int zapisnikID) {
        this.zapisnikID = zapisnikID;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }
    public boolean isImePrezimeIzmenjeno() {
        return imePrezimeIzmenjeno;
    }

    public void setImePrezimeIzmenjeno(boolean imePrezimeIzmenjeno) {
        this.imePrezimeIzmenjeno = imePrezimeIzmenjeno;
    }
    
    @Override
    public String getTableName() {
        return " zapisnik_o_sortiranju zos";
    }

    @Override
    public String getColumnNames() {
        return " zos.zapisnikid, zos.mesto, zos.datum, zos.napomena, r.imeprezime, r.radnikid,r.jmbg.get_jmbgBroj() as JMBG, r.imeprezime, r.telefon ";
    }

    @Override
    public String columnForOrderBy() {
        return " zos.zapisnikid ";
    }

    @Override
    public String join1() {
        return " join radnik r on zos.radnikid=r.radnikid ";
    }

    @Override
    public String getColumnValues() {
        SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yy");
        String dat=sdf.format(this.datum.getTime());
        return zapisnikID+", '"+mesto+"','"+dat+"','"+napomena+"',"+radnik.getRadnikID();
    }

    @Override
    public String getInsertColumnNames() {
        return " zapisnikid, mesto, datum, napomena, radnikid ";
    }

    @Override
    public String getUpdateClause() {
        SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yy");
        String dt=sdf.format(this.datum.getTime());
        String imPr=imePrezimeIzmenjeno?(",zos.imeprezime='"+this.imePrezime+"'"):"";
        return " zos.mesto='"+mesto+"', zos.datum='"+dt+"',zos.napomena='"+napomena+"',zos.radnikid="+radnik.getRadnikID()+imPr;
    }

    @Override
    public String getUpdateWhereClause() {
        return " zos.zapisnikid="+zapisnikID;
    }

    @Override
    public String getDeleteWhereClause() {
        return " zos.zapisnikid="+zapisnikID;
    }

    @Override
    public List<DomenskiObjekat> getListOfObjects(ResultSet rs) throws SQLException {
        List<DomenskiObjekat> listaZapisnika=new ArrayList<>();
        while(rs.next()){
            int id=rs.getInt("ZapisnikID");
            String mestoZap=rs.getString("mesto");
            Date datZap=rs.getDate("datum");
            String napZap=rs.getString("napomena");
            
            int radID=rs.getInt("radnikid");
            long jmbg=rs.getLong("jmbg");
            String imPr=rs.getString("imeprezime");
            String tel=rs.getString("telefon");
            Radnik rad=new Radnik(radID, jmbg, imPr, tel);
            
            
            Zapisnik_o_Sortiranju zap=new Zapisnik_o_Sortiranju(id, mestoZap, datZap, napZap,imPr, rad);
            listaZapisnika.add(zap); 
        }
        return listaZapisnika;
    }


    @Override
    public String getNameOfIDColumn() {
        return " zos.zapisnikid ";
    }

    @Override
    public int getMaxIdFromRS(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
