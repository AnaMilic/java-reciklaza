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
public class StavkaPrijemnice extends DomenskiObjekat{

    private Prijemnica prijemnica;
    private int redniBroj;
    private double kolicina;
    private Artikal artikal;

    public StavkaPrijemnice() {
    }

    public StavkaPrijemnice(Prijemnica prijemnica, int redniBroj, double kolicina, Artikal artikal) {
        this.prijemnica = prijemnica;
        this.redniBroj = redniBroj;
        this.kolicina = kolicina;
        this.artikal = artikal;
    }
    
    public Prijemnica getPrijemnica() {
        return prijemnica;
    }

    public void setPrijemnica(Prijemnica prijemnica) {
        this.prijemnica = prijemnica;
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

    public Artikal getArtikal() {
        return artikal;
    }

    public void setArtikal(Artikal artikal) {
        this.artikal = artikal;
    }
    
    
    @Override
    public String getTableName() {
        return " stavka_prijemnice sp ";
    }

    @Override
    public String getColumnNames() {
        return " p.brojprijemnice, p.datumizdavanja, p.nacinotpreme, p.mestoizdavanjarobe, p.maticnibrojdobavljaca, p.maticnibrojkupca, p.radnikid, p.iznosukupno, sp.rednibroj, sp.kolicina, a.sifraartikla, a.nazivartikla, a.sifrajedinicemere,a.trenutnacena ";
    }

    @Override
    public String columnForOrderBy() {
        return " sp.brojprijemnice, sp.rednibroj ";
    }

    @Override
    public String join1() {
        return " join prijemnica p on p.brojprijemnice=sp.brojprijemnice join artikal a on a.sifraartikla=sp.sifraartikla where p.brojprijemnice="+prijemnica.getBrojPrijemnice();
    }


    @Override
    public String getColumnValues() {
        return prijemnica.getBrojPrijemnice()+","+redniBroj+","+kolicina+","+artikal.getSifraArtikla();
    }

    @Override
    public String getInsertColumnNames() {
        return " brojprijemnice, rednibroj, kolicina, sifraartikla ";
    }

    @Override
    public String getUpdateClause() {
        return " sp.kolicina="+kolicina+", sp.sifraartikla="+artikal.getSifraArtikla();
    }

    @Override
    public String getUpdateWhereClause() {
        return " sp.brojprijemnice="+prijemnica.getBrojPrijemnice()+" and sp.rednibroj="+redniBroj;
    }

    @Override
    public String getDeleteWhereClause() {
        return " sp.brojprijemnice="+prijemnica.getBrojPrijemnice()+" and sp.rednibroj="+redniBroj;
    }

    @Override
    public List<DomenskiObjekat> getListOfObjects(ResultSet rs) throws SQLException {
        List<DomenskiObjekat> listaStavki=new ArrayList<>();
        while(rs.next()){
            
            int brPr=rs.getInt("brojprijemnice");
            Date dat=rs.getDate("datumizdavanja");
            String nac=rs.getString("nacinotpreme");
            String mesto=rs.getString("mestoizdavanjarobe");
            double izUk=rs.getDouble("iznosukupno");
            
            int matBrD=rs.getInt("maticnibrojdobavljaca");
            Dobavljac d=new Dobavljac();
            d.setMaticniBrojDobavljaca(matBrD);
            
            int matBrK=rs.getInt("maticnibrojkupca");
            Kupac k=new Kupac();
            k.setMaticniBrojKupca(matBrK);
            
            int radID=rs.getInt("radnikid");
            Radnik r=new Radnik();
            r.setRadnikID(radID);
            
            Prijemnica prij=new Prijemnica(brPr, dat, nac, mesto, d, k, r, izUk);
            
            int rb=rs.getInt("rednibroj");
            double kol=rs.getDouble("kolicina");
            
            int sifArt=rs.getInt("sifraartikla");
            String naz=rs.getString("nazivartikla");
            Artikal a=new Artikal();
            a.setSifraArtikla(sifArt);
            a.setNazivArtikla(naz);
            
            StavkaPrijemnice stavPrij=new StavkaPrijemnice(prij, rb, kol, a);
            listaStavki.add(stavPrij);
        }
        return listaStavki;
    }


    @Override
    public String getNameOfIDColumn() {
        return " sp.brojprijemnice, sp.rednibroj ";
    }

    @Override
    public int getMaxIdFromRS(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
