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
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ana
 */
public class StavkaZapisnika extends DomenskiObjekat{

    private Zapisnik_o_Sortiranju zapisnik;
    private int redniBroj;
    private double kolicina;
    private double cena;
    private Artikal artikal;

    public StavkaZapisnika() {
    }

    public StavkaZapisnika(Zapisnik_o_Sortiranju zapisnik, int redniBroj, double kolicina, double cena, Artikal artikal) {
        this.zapisnik = zapisnik;
        this.redniBroj = redniBroj;
        this.kolicina = kolicina;
        this.cena = cena;
        this.artikal = artikal;
    }
    
    public Zapisnik_o_Sortiranju getZapisnik() {
        return zapisnik;
    }

    public void setZapisnik(Zapisnik_o_Sortiranju zapisnik) {
        this.zapisnik = zapisnik;
    }

    public int getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(int redniBroj) {
        this.redniBroj = redniBroj;
    }

    public double getKolicina() {
        return kolicina;
    }

    public void setKolicina(double kolicina) {
        this.kolicina = kolicina;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Artikal getArtikal() {
        return artikal;
    }

    public void setArtikal(Artikal artikal) {
        this.artikal = artikal;
    }
    @Override
    public String getTableName() {
        return " stavka_zapisnika sz ";
    }

    @Override
    public String getColumnNames() {
        return " zos.zapisnikid, zos.mesto, zos.datum, zos.napomena, zos.imeprezime, zos.radnikid, sz.rednibroj,sz.kolicina,sz.cena,a.sifraartikla,a.nazivartikla,a.sifrajedinicemere,a.trenutnacena ";
    }

    @Override
    public String columnForOrderBy() {
        return " sz.zapisnikid, sz.rednibroj";
    }

    @Override
    public String join1() {
        return " join zapisnik_o_sortiranju zos on sz.zapisnikid=zos.zapisnikid join artikal a on sz.sifraartikla=a.sifraartikla where zos.zapisnikid="+zapisnik.getZapisnikID();
    }

    @Override
    public String getColumnValues() {
        return zapisnik.getZapisnikID()+","+redniBroj+","+kolicina+","+cena+","+artikal.getSifraArtikla();
    }

    @Override
    public String getInsertColumnNames() {
        return " zapisnikid, rednibroj, kolicina, cena, sifraartikla ";
    }

    @Override
    public String getUpdateClause() {
        return " sz.kolicina="+kolicina+", sz.cena="+cena+", sz.sifraartikla="+artikal.getSifraArtikla();
    }


    @Override
    public String getUpdateWhereClause() {
        return " sz.zapisnikid="+zapisnik.getZapisnikID()+" and sz.rednibroj="+redniBroj;
    }

    @Override
    public String getDeleteWhereClause() {
        return " sz.zapisnikid="+zapisnik.getZapisnikID()+" and sz.rednibroj="+redniBroj; 
    }

    @Override
    public List<DomenskiObjekat> getListOfObjects(ResultSet rs) throws SQLException {
        List<DomenskiObjekat> listaStavki= new ArrayList<>();
        while(rs.next()){
            StavkaZapisnika st=new StavkaZapisnika();
            
            int zapid=rs.getInt("zapisnikid");
            String mes=rs.getString("mesto");
            Date dat=rs.getDate("datum");
            String nap=rs.getString("napomena");
            Zapisnik_o_Sortiranju z=new Zapisnik_o_Sortiranju();
            z.setDatum(dat);
            z.setMesto(mes);
            z.setZapisnikID(zapid);
            z.setNapomena(nap);
            
            int redBr=rs.getInt("rednibroj");
            double kol=rs.getDouble("kolicina");
            double c=rs.getDouble("cena");
            
            int sifArt=rs.getInt("sifraartikla");
            String naz=rs.getString("nazivartikla");
            Artikal a=new Artikal();
            a.setSifraArtikla(sifArt);
            a.setNazivArtikla(naz);
            
            st.setCena(c);
            st.setKolicina(kol);
            st.setArtikal(a);
            st.setRedniBroj(redBr);
            st.setZapisnik(z);
            
            listaStavki.add(st);
        }
        return listaStavki;
    }

    @Override
    public String getNameOfIDColumn() {
        return " sz.zapisnikid, sz.rednibroj ";
    }

    @Override
    public int getMaxIdFromRS(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
