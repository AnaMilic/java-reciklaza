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
public class Clan extends DomenskiObjekat{

    
    private Zakon zakon;
    private int brojClana;
    private String sadrzaj;
    private String napomena;
    private int tabela=0;

    public Clan() {
    }

    public Clan(Zakon zakon, int brojClana, String sadrzaj, String napomena) {
        this.zakon = zakon;
        this.brojClana = brojClana;
        this.sadrzaj = sadrzaj;
        this.napomena = napomena;
    }

    public Zakon getZakon() {
        return zakon;
    }

    public void setZakon(Zakon zakon) {
        this.zakon = zakon;
    }

    public int getBrojClana() {
        return brojClana;
    }

    public void setBrojClana(int brojClana) {
        this.brojClana = brojClana;
    }

    public String getSadrzaj() {
        return sadrzaj;
    }

    public void setSadrzaj(String sadrzaj) {
        this.sadrzaj = sadrzaj;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public int getTabela() {
        return tabela;
    }

    public void setTabela(int tabela) {
        this.tabela = tabela;
    }
    
    @Override
    public String getTableName() {
        switch(this.tabela){
            case 1:
                return "CLAN_OSNOVNO c";
            case 2:
                return "CLAN_DETALJI c";
            default:
                return "CLAN c";
        }
    }

    @Override
    public String getColumnNames() {
        switch(this.tabela){
            case 1:
                return "z.zakonid,z.nazivzakona,z.napomena, c.brojclana, c.sadrzaj";
            case 2:
                return "z.zakonid,z.nazivzakona,z.napomena, c.brojclana, c.napomena_clan";
            default:
                return "z.zakonid,z.nazivzakona,z.napomena, c.brojclana, c.sadrzaj, c.napomena_clan";
        }
    }

    @Override
    public String columnForOrderBy() {
        return "z.zakonid, c.brojclana";
    }

    @Override
    public String join1() {
        return " join Zakon z on z.ZAKONID=c.ZAKONID where z.zakonid="+zakon.getZakonID();
    }

    
    @Override
    public String getColumnValues() {
        return zakon.getZakonID()+"," + brojClana + ",'" +sadrzaj+"','"+napomena+"'";
    }

    @Override
    public String getInsertColumnNames() {
        return "c.zakonid, c.brojclana, c.sadrzaj, c.napomena_clan";
    }

    @Override
    public String getUpdateClause() {
        return "c.sadrzaj='"+sadrzaj+"', c.napomena_clan='"+napomena+"'";
    }

    
    @Override
    public String getUpdateWhereClause() {
        return "c.zakonid=" + zakon.getZakonID()+" and c.brojclana="+brojClana;
    }

    @Override
    public String getDeleteWhereClause() {
        return "c.zakonid=" + zakon.getZakonID()+" and c.brojclana="+brojClana;
    }

    @Override
    public List<DomenskiObjekat> getListOfObjects(ResultSet rs) throws SQLException {
        List<DomenskiObjekat> listaClanova=new ArrayList<>();
        while(rs.next()){
            Clan c=new Clan();
            
            int zakonID=rs.getInt("ZAKONID");
            String nazivZakona=rs.getString("NAZIVZAKONA");
            String napomenaZakona=rs.getString("NAPOMENA");
            Zakon z=new Zakon(zakonID, nazivZakona, napomenaZakona);
            c.setZakon(z);
            
            int brojCl=rs.getInt("BROJCLANA");
            c.setBrojClana(brojCl);
            
            if(tabela!=1){
                String sadrzajClana=rs.getString("SADRZAJ");
                c.setSadrzaj(sadrzajClana);
            }
            if(tabela!=2){
                String napomenaClana=rs.getString("NAPOMENA_CLAN");
                c.setNapomena(napomenaClana);
            }
            listaClanova.add(c);
        }
        return listaClanova;
    }
    @Override
    public String getNameOfIDColumn() {
        return " c.brojClana ";
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
        return "Clan broj: "+brojClana;
    }
}
