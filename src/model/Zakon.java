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
public class Zakon extends DomenskiObjekat{

    private int zakonID;
    private String nazivZakona;
    private String napomena;

    public Zakon() {
    }

    public Zakon(int zakonID, String nazivZakona, String napomena) {
        this.zakonID = zakonID;
        this.nazivZakona = nazivZakona;
        this.napomena = napomena;
    }
    
    public int getZakonID() {
        return zakonID;
    }

    public void setZakonID(int zakonID) {
        this.zakonID = zakonID;
    }

    public String getNazivZakona() {
        return nazivZakona;
    }

    public void setNazivZakona(String nazivZakona) {
        this.nazivZakona = nazivZakona;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }
    
    @Override
    public String getTableName() {
        return " ZAKON ";
    }

    @Override
    public String getColumnNames() {
        return " ZakonID, NazivZakona, Napomena ";
    }

    @Override
    public String columnForOrderBy() {
        return " zakonid ";
    }

    @Override
    public String join1() {
        return "";
    }

    @Override
    public String getColumnValues() {
        return zakonID + " ,'"+nazivZakona+"', '"+napomena+"'";
    }

    @Override
    public String getInsertColumnNames() {
        return " zakonid, nazivzakona, napomena ";
    }

    @Override
    public String getUpdateClause() {
        return "nazivzakona='"+nazivZakona+"', napomena='"+napomena+"'";
    }

    @Override
    public String getUpdateWhereClause() {
        return " zakonid="+zakonID;
    }

    @Override
    public String getDeleteWhereClause() {
        return " zakonid="+zakonID;
    }

    @Override
    public List<DomenskiObjekat> getListOfObjects(ResultSet rs) throws SQLException {
        List<DomenskiObjekat> listaZakona=new ArrayList<>();
        while(rs.next()){
            int id=rs.getInt("ZAKONID");
            String naziv=rs.getString("NAZIVZAKONA");
            String napom=rs.getString("NAPOMENA");
            Zakon z=new Zakon(id, naziv, napom);
            listaZakona.add(z);
        }
        return listaZakona;
    }

    @Override
    public String getNameOfIDColumn() {
        return " zakonID ";
    }

    @Override
    public int getMaxIdFromRS(ResultSet rs) throws SQLException {
        int id=0;
        while(rs.next()){
            id=rs.getInt("max");
        }
        return id;
    }

    @Override
    public String toString() {
        return nazivZakona ;
    }
 
}
