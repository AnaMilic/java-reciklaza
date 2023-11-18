/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.DomenskiObjekat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ana
 */
public class Radnik extends DomenskiObjekat{

    private int radnikID;
    private long jmbg;
    private String imePrezime;
    private String telefon;

    public Radnik() {
    }

    public Radnik(int radnikID, long jmbg, String imePrezime, String telefon) {
        this.radnikID = radnikID;
        this.jmbg = jmbg;
        this.imePrezime = imePrezime;
        this.telefon = telefon;
    }
    public int getRadnikID() {
        return radnikID;
    }

    public void setRadnikID(int radnikID) {
        this.radnikID = radnikID;
    }

    public long getJmbg() {
        return jmbg;
    }

    public void setJmbg(long jmbg) {
        this.jmbg = jmbg;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    
    @Override
    public String getTableName() {
        return " radnik r ";
    }

    @Override
    public String getColumnNames() {
        return " r.radnikid, r.jmbg.get_jmbgBroj() as JMBG, r.imeprezime, r.telefon ";
    }

    @Override
    public String columnForOrderBy() {
        return " r.radnikid ";
    }

    @Override
    public String join1() {
        return "";
    }

    @Override
    public String getColumnValues() {
        return radnikID+",JMBG("+jmbg+"),'"+imePrezime+"','"+telefon+"'";
    }

    @Override
    public String getInsertColumnNames() {
        return " r.radnikid, r.jmbg, r.imeprezime, r.telefon ";
    }

    @Override
    public String getUpdateClause() {
        return " r.radnikid="+radnikID+", r.jmbg.jmbgBroj="+jmbg+", r.imeprezime='"+imePrezime+"',r.telefon='"+telefon+"'";
    }


    @Override
    public String getUpdateWhereClause() {
        return " r.radnikid="+radnikID;
    }

    @Override
    public String getDeleteWhereClause() {
        return " r.radnikid="+radnikID;
    }

    @Override
    public List<DomenskiObjekat> getListOfObjects(ResultSet rs) throws SQLException {
        List<DomenskiObjekat> listaRadnika=new ArrayList<>();
        while(rs.next()){
            int radnikid=rs.getInt("radnikid");
            long jmb=rs.getLong("JMBG");
            String imePrez=rs.getString("IMEPREZIME");
            String tel=rs.getString("TELEFON");
            
            Radnik r=new Radnik(radnikid, jmb, imePrez, tel);
            listaRadnika.add(r);
        }
        return listaRadnika;
    }

    @Override
    public String getNameOfIDColumn() {
        return " r.radnikid ";
    }

    @Override
    public int getMaxIdFromRS(ResultSet rs) throws SQLException {
        int id=0;
        while(rs.next()){
            //id++;
            id=rs.getInt("max");
        }
        return id;
    }

    @Override
    public String toString() {
        return imePrezime ;
    }

}
