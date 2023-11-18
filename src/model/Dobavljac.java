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
public class Dobavljac extends DomenskiObjekat{

    private int maticniBrojDobavljaca;
    private int pibDobavljaca;
    private String nazivDobavljaca;
    private String mestoDobavljaca;
    private String adresaDobavljaca;
    private long tekuciRacun;

    public Dobavljac() {
    }

    public Dobavljac(int maticniBrojDobavljaca, int pibDobavljaca, String nazivDobavljaca, String mestoDobavljaca, String adresaDobavljaca, long tekuciRacun) {
        this.maticniBrojDobavljaca = maticniBrojDobavljaca;
        this.pibDobavljaca = pibDobavljaca;
        this.nazivDobavljaca = nazivDobavljaca;
        this.mestoDobavljaca = mestoDobavljaca;
        this.adresaDobavljaca = adresaDobavljaca;
        this.tekuciRacun = tekuciRacun;
    }
    public int getMaticniBrojDobavljaca() {
        return maticniBrojDobavljaca;
    }

    public void setMaticniBrojDobavljaca(int maticniBrojDobavljaca) {
        this.maticniBrojDobavljaca = maticniBrojDobavljaca;
    }

    public int getPibDobavljaca() {
        return pibDobavljaca;
    }

    public void setPibDobavljaca(int pibDobavljaca) {
        this.pibDobavljaca = pibDobavljaca;
    }

    public String getNazivDobavljaca() {
        return nazivDobavljaca;
    }

    public void setNazivDobavljaca(String nazivDobavljaca) {
        this.nazivDobavljaca = nazivDobavljaca;
    }

    public String getMestoDobavljaca() {
        return mestoDobavljaca;
    }

    public void setMestoDobavljaca(String mestoDobavljaca) {
        this.mestoDobavljaca = mestoDobavljaca;
    }

    public String getAdresaDobavljaca() {
        return adresaDobavljaca;
    }

    public void setAdresaDobavljaca(String adresaDobavljaca) {
        this.adresaDobavljaca = adresaDobavljaca;
    }

    public long getTekuciRacun() {
        return tekuciRacun;
    }

    public void setTekuciRacun(long tekuciRacun) {
        this.tekuciRacun = tekuciRacun;
    }
    
    @Override
    public String getTableName() {
        return " Dobavljac ";
    }

    @Override
    public String getColumnNames() {
        return " maticnibrojdobavljaca, pibdobavljaca, nazivdobavljaca, mestodobavljaca, adresadobavljaca, tekuciracun ";
    }

    @Override
    public String columnForOrderBy() {
        return " NazivDobavljaca ";
    }

    @Override
    public String join1() {
        return "";
    }

    
    @Override
    public String getColumnValues() {
        return maticniBrojDobavljaca+","+pibDobavljaca+",'"+nazivDobavljaca+"','"+mestoDobavljaca+"','"+adresaDobavljaca+"',"+tekuciRacun;
    }

    @Override
    public String getInsertColumnNames() {
        return " maticnibrojdobavljaca, pibdobavljaca, nazivdobavljaca, mestodobavljaca, adresadobavljaca, tekuciracun ";
    }

    @Override
    public String getUpdateClause() {
        return " maticnibrojdobavljaca="+maticniBrojDobavljaca+", pibdobavljaca="+pibDobavljaca+",nazivdobavljaca='"+nazivDobavljaca+"', mestodobavljaca='"+mestoDobavljaca+"',adresadobavljaca='"+adresaDobavljaca+"', tekuciracun="+tekuciRacun;
    }

    

    @Override
    public String getUpdateWhereClause() {
        return " maticnibrojdobavljaca="+maticniBrojDobavljaca;
    }

    @Override
    public String getDeleteWhereClause() {
        return " maticnibrojdobavljaca="+maticniBrojDobavljaca;
    }

    @Override
    public List<DomenskiObjekat> getListOfObjects(ResultSet rs) throws SQLException {
        List<DomenskiObjekat> listaDobavljaca=new ArrayList<>();
        while(rs.next()){
            int mb=rs.getInt("maticnibrojdobavljaca");
            int pib=rs.getInt("pibdobavljaca");
            String naziv=rs.getString("nazivdobavljaca");
            String mesto=rs.getString("mestodobavljaca");
            String adresa=rs.getString("adresadobavljaca");
            long tekRac=rs.getLong("tekuciracun");
            Dobavljac d=new Dobavljac(mb, pib, naziv, mesto, adresa, tekRac);
            listaDobavljaca.add(d);
        }
        return listaDobavljaca;
    }

    

    @Override
    public String getNameOfIDColumn() {
        return " maticni broj dobavljaca ";
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
        return nazivDobavljaca;
    }

}
