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
public class Jedinica_Mere extends DomenskiObjekat{

    private int sifraJediniceMere;
    private String nazivJediniceMere;
    private String skracenica;

    public Jedinica_Mere() {
    }

    public Jedinica_Mere(int sifraJediniceMere, String nazivJediniceMere, String skracenica) {
        this.sifraJediniceMere = sifraJediniceMere;
        this.nazivJediniceMere = nazivJediniceMere;
        this.skracenica = skracenica;
    }
    
    public int getSifraJediniceMere() {
        return sifraJediniceMere;
    }

    public void setSifraJediniceMere(int sifraJediniceMere) {
        this.sifraJediniceMere = sifraJediniceMere;
    }

    public String getNazivJediniceMere() {
        return nazivJediniceMere;
    }

    public void setNazivJediniceMere(String nazivJediniceMere) {
        this.nazivJediniceMere = nazivJediniceMere;
    }

    public String getSkracenica() {
        return skracenica;
    }

    public void setSkracenica(String skracenica) {
        this.skracenica = skracenica;
    }

    @Override
    public String getTableName() {
        return "JEDINICA_MERE j";
    }

    @Override
    public String getColumnNames() {
        return "j.sifrajedinicemere, j.nazivjedinicemere.get_nazivjm() as NAZIV_JM, j.nazivjedinicemere.get_skracenica() as SKRACENICA";
    }

    @Override
    public String columnForOrderBy() {
        return "j.sifrajedinicemere";
    }

    @Override
    public String join1() {
        return "";
    }

    @Override
    public String getColumnValues() {
        return sifraJediniceMere+", JM('"+nazivJediniceMere+"','"+skracenica+"')";
    }

    @Override
    public String getInsertColumnNames() {
        return " j.sifrajedinicemere,j.nazivjedinicemere ";
    }

    @Override
    public String getUpdateClause() {
        return " j.nazivjedinicemere.nazivjm='"+nazivJediniceMere+"', j.nazivjedinicemere.skracenica='"+skracenica+"'";
    }
    @Override
    public String getUpdateWhereClause() {
        return " j.sifrajedinicemere="+sifraJediniceMere;
    }

    @Override
    public String getDeleteWhereClause() {
        return " j.sifrajedinicemere="+sifraJediniceMere;
    }

    @Override
    public List<DomenskiObjekat> getListOfObjects(ResultSet rs) throws SQLException {
        List<DomenskiObjekat> listaJM=new ArrayList<>();
        while(rs.next()){
            int sifraJM=rs.getInt("sifrajedinicemere");
            String nazivJM=rs.getString("NAZIV_JM");
            String skr=rs.getString("SKRACENICA");
            
            Jedinica_Mere jm=new Jedinica_Mere(sifraJM, nazivJM, skr);
            listaJM.add(jm);
        }
        return listaJM;
    }
    
    @Override
    public String getNameOfIDColumn() {
        return " j.sifrajedinicemere ";
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
        return nazivJediniceMere;
    }


}
