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
public class Kupac extends DomenskiObjekat{

    private int maticniBrojKupca;
    private int pibKupca;
    private String nazivKupca;
    private String mestoKupca;
    private String adresaKupca;
    private String telefon;
    private long ziroRacun;

    public Kupac() {
    }

    public Kupac(int maticniBrojKupca, int pibKupca, String nazivKupca, String mestoKupca, String adresaKupca, String telefon, long ziroRacun) {
        this.maticniBrojKupca = maticniBrojKupca;
        this.pibKupca = pibKupca;
        this.nazivKupca = nazivKupca;
        this.mestoKupca = mestoKupca;
        this.adresaKupca = adresaKupca;
        this.telefon = telefon;
        this.ziroRacun = ziroRacun;
    }
    public int getMaticniBrojKupca() {
        return maticniBrojKupca;
    }

    public void setMaticniBrojKupca(int maticniBrojKupca) {
        this.maticniBrojKupca = maticniBrojKupca;
    }

    public int getPibKupca() {
        return pibKupca;
    }

    public void setPibKupca(int pibKupca) {
        this.pibKupca = pibKupca;
    }

    public String getNazivKupca() {
        return nazivKupca;
    }

    public void setNazivKupca(String nazivKupca) {
        this.nazivKupca = nazivKupca;
    }

    public String getMestoKupca() {
        return mestoKupca;
    }

    public void setMestoKupca(String mestoKupca) {
        this.mestoKupca = mestoKupca;
    }

    public String getAdresaKupca() {
        return adresaKupca;
    }

    public void setAdresaKupca(String adresaKupca) {
        this.adresaKupca = adresaKupca;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public long getZiroRacun() {
        return ziroRacun;
    }

    public void setZiroRacun(long ziroRacun) {
        this.ziroRacun = ziroRacun;
    }
    
    @Override
    public String getTableName() {
        return " Kupac ";
    }

    @Override
    public String getColumnNames() {
        return " maticnibrojkupca, pibkupca, nazivkupca, mestokupca, adreskupca, telefon, ziroracun ";
    }

    @Override
    public String columnForOrderBy() {
        return " NazivKupca ";
    }

    @Override
    public String join1() {
        return "";
    }

    @Override
    public String getColumnValues() {
        return maticniBrojKupca+ ","+pibKupca+",'"+nazivKupca+"','"+mestoKupca+"','"+adresaKupca+"','"+telefon+"',"+ziroRacun;
    }

    @Override
    public String getInsertColumnNames() {
        return " maticnibrojkupca, pibkupca, nazivkupca, mestokupca, adreskupca, telefon, ziroracun ";
    }

    @Override
    public String getUpdateClause() {
        return " maticnibrojkupca="+maticniBrojKupca+", pibkupca="+pibKupca+",nazivkupca='"+nazivKupca+"', mestokupca='"+mestoKupca+"',adreskupca='"+adresaKupca+"',telefon='"+telefon+"',ziroracun="+ziroRacun;
    }

    @Override
    public String getUpdateWhereClause() {
        return " maticnibrojkupca="+maticniBrojKupca;
    }

    @Override
    public String getDeleteWhereClause() {
        return " maticnibrojkupca="+maticniBrojKupca;
    }

    @Override
    public List<DomenskiObjekat> getListOfObjects(ResultSet rs) throws SQLException {
        List<DomenskiObjekat> listaKupca=new ArrayList<>();
        while(rs.next()){
            int mb=rs.getInt("maticnibrojKupca");
            int pib=rs.getInt("pibKupca");
            String naziv=rs.getString("nazivKupca");
            String mesto=rs.getString("mestoKupca");
            String adresa=rs.getString("adresKupca");
            String tel=rs.getString("telefon");
            long zirRac=rs.getLong("ziroracun");
            Kupac k=new Kupac(mb, pib, naziv, mesto, adresa, tel, zirRac);
            listaKupca.add(k);
        }
        return listaKupca;
    }


    @Override
    public String getNameOfIDColumn() {
        return " maticnibrojkupca ";
    }

    @Override
    public int getMaxIdFromRS(ResultSet rs) throws SQLException {
        int id=0;
        while(rs.next()){
            id++;
        }
        return id;
    }

    @Override
    public String toString() {
        return nazivKupca;
    }
    
    
}
