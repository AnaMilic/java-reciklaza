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
public class Artikal extends DomenskiObjekat{
    
    private int sifraArtikla;
    private String nazivArtikla;
    private Jedinica_Mere jm;
    private double trenutnaCena;
    private boolean cenaIzmenjena=false;

    public Artikal() {
    }

    public Artikal(int sifraArtikla, String nazivArtikla, Jedinica_Mere jm, double trenutnaCena) {
        this.sifraArtikla = sifraArtikla;
        this.nazivArtikla = nazivArtikla;
        this.jm = jm;
        this.trenutnaCena = trenutnaCena;
    }

    public int getSifraArtikla() {
        return sifraArtikla;
    }

    public void setSifraArtikla(int sifraArtikla) {
        this.sifraArtikla = sifraArtikla;
    }

    public String getNazivArtikla() {
        return nazivArtikla;
    }

    public void setNazivArtikla(String nazivArtikla) {
        this.nazivArtikla = nazivArtikla;
    }

    public Jedinica_Mere getJm() {
        return jm;
    }

    public void setJm(Jedinica_Mere jm) {
        this.jm = jm;
    }

    public double getTrenutnaCena() {
        return trenutnaCena;
    }

    public void setTrenutnaCena(double trenutnaCena) {
        this.trenutnaCena = trenutnaCena;
    }

    public boolean isCenaIzmenjena() {
        return cenaIzmenjena;
    }

    public void setCenaIzmenjena(boolean cenaIzmenjena) {
        this.cenaIzmenjena = cenaIzmenjena;
    }

    @Override
    public String getTableName() {
        return " Artikal a ";
    }

    @Override
    public String getColumnNames() {
        return " a.sifraartikla, a.nazivartikla, jm.sifrajedinicemere, jm.nazivjedinicemere.get_nazivjm() as NAZIV_JM,jm.nazivjedinicemere.get_skracenica() AS SKRACENICA, a.trenutnacena ";
    }

    @Override
    public String columnForOrderBy() {
        return " a.sifraartikla ";
    }

    @Override
    public String join1() {
        return " join JEDINICA_MERE jm on a.sifrajedinicemere=jm.sifrajedinicemere ";
    }

    @Override
    public String getColumnValues() {
        return "'"+nazivArtikla+"',"+jm.getSifraJediniceMere()+","+trenutnaCena+"";
    }

    @Override
    public String getInsertColumnNames() {
        return " sifraartikla, nazivartikla, sifrajedinicemere, trenutnacena ";
    }

    @Override
    public String getUpdateClause() {
        /*String cena="";
        if(cenaIzmenjena==true){
            cena=", a.trenutnacena=" +this.trenutnaCena;
        }*/
        String cena=cenaIzmenjena?(",a.trenutnacena="+this.trenutnaCena):"";
        return " a.nazivartikla='"+nazivArtikla+"', a.sifrajedinicemere="+jm.getSifraJediniceMere()+cena;
    }

    @Override
    public String getUpdateWhereClause() {
        return " a.sifraartikla="+sifraArtikla;
    }

    @Override
    public String getDeleteWhereClause() {
        return " a.sifraartikla="+sifraArtikla;
    }

    @Override
    public List<DomenskiObjekat> getListOfObjects(ResultSet rs) throws SQLException {
        List<DomenskiObjekat> listaArtikala=new ArrayList<>();
        while(rs.next()){
            int sifArt=rs.getInt("sifraartikla");
            String nazivArt=rs.getString("nazivartikla");
            double trCena=rs.getDouble("trenutnacena");
            
            int sifraJm=rs.getInt("sifrajedinicemere");
            String nazivJM=rs.getString("NAZIV_JM");
            String skrJM=rs.getString("SKRACENICA");
            Jedinica_Mere jm=new Jedinica_Mere(sifraJm, nazivJM, skrJM);
            
            Artikal a=new Artikal(sifArt, nazivArt, jm, trCena);
            listaArtikala.add(a);
        }
        return listaArtikala;
    }

    @Override
    public String getNameOfIDColumn() {
        return " a.sifraartikla ";
    }

    @Override
    public int getMaxIdFromRS(ResultSet rs) throws SQLException{
        int id=0;
        while(rs.next()){
            id=rs.getInt("max");
        }
        return id;
    }

    @Override
    public String toString() {
        return "Sifra artikla:" + sifraArtikla + ", Naziv artikla:" + nazivArtikla;
    }

}
