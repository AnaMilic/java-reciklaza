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
public class StavkaKnjiznogZaduzenja extends DomenskiObjekat{

    private Dobavljac maticniBrojDobavljaca;
    private Kupac maticniBrojKupca;
    private Knjizno_Zaduzenje brojZaduzenja;
    private int redniBroj;
    private String sadrzaj;
    private Artikal artikal;

    public StavkaKnjiznogZaduzenja() {
    }

    public StavkaKnjiznogZaduzenja(Dobavljac maticniBrojDobavljaca, Kupac maticniBrojKupca, Knjizno_Zaduzenje brojZaduzenja, int redniBroj, String sadrzaj, Artikal artikal) {
        this.maticniBrojDobavljaca = maticniBrojDobavljaca;
        this.maticniBrojKupca = maticniBrojKupca;
        this.brojZaduzenja = brojZaduzenja;
        this.redniBroj = redniBroj;
        this.sadrzaj = sadrzaj;
        this.artikal = artikal;
    }

    

    public Knjizno_Zaduzenje getBrojZaduzenja() {
        return brojZaduzenja;
    }

    public Dobavljac getMaticniBrojDobavljaca() {
        return maticniBrojDobavljaca;
    }

    public Kupac getMaticniBrojKupca() {
        return maticniBrojKupca;
    }

    

    public void setBrojZaduzenja(Knjizno_Zaduzenje brojZaduzenja) {
        this.brojZaduzenja = brojZaduzenja;
    }

    public void setMaticniBrojDobavljaca(Dobavljac maticniBrojDobavljaca) {
        this.maticniBrojDobavljaca = maticniBrojDobavljaca;
    }

    public void setMaticniBrojKupca(Kupac maticniBrojKupca) {
        this.maticniBrojKupca = maticniBrojKupca;
    }

    public int getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(int redniBroj) {
        this.redniBroj = redniBroj;
    }

    public String getSadrzaj() {
        return sadrzaj;
    }

    public void setSadrzaj(String sadrzaj) {
        this.sadrzaj = sadrzaj;
    }

    public Artikal getArtikal() {
        return artikal;
    }

    public void setArtikal(Artikal artikal) {
        this.artikal = artikal;
    }
    
    
    @Override
    public String getTableName() {
       return " Stavka_Knjiznog_Zaduzenja skz ";
    }

    @Override
    public String getColumnNames() {
        return " kz.maticnibrojdobavljaca, kz.maticnibrojkupca,kz.brojzaduzenja,kz.datumizdavanja,kz.mestoizdavanja,kz.napomena,kz.nazivdobavljaca,kz.radnikid,skz.rednibroj,skz.sadrzaj,a.sifraartikla,a.nazivartikla,a.sifrajedinicemere,a.trenutnacena ";
    }

    @Override
    public String columnForOrderBy() {
        return " skz.brojzaduzenja, skz.rednibroj ";
    }

    @Override
    public String join1() {
        return " join knjizno_zaduzenje kz on kz.maticnibrojdobavljaca=skz.maticnibrojdobavljaca and kz.maticnibrojkupca=skz.maticnibrojkupca and kz.brojzaduzenja=skz.brojzaduzenja join artikal a on skz.sifraartikla=a.sifraartikla where kz.brojzaduzenja="+brojZaduzenja.getBrojZaduzenja();
    }

    @Override
    public String getColumnValues() {
        return maticniBrojDobavljaca.getMaticniBrojDobavljaca()+","+maticniBrojKupca.getMaticniBrojKupca()+","+brojZaduzenja.getBrojZaduzenja()+","+redniBroj+",'"+sadrzaj+"',"+artikal.getSifraArtikla();
    }

    @Override
    public String getInsertColumnNames() {
        return " maticnibrojdobavljaca, maticnibrojkupca, brojzaduzenja, rednibroj, sadrzaj, sifraartikla ";
    }

    @Override
    public String getUpdateClause() {
        return " skz.sadrzaj='"+sadrzaj+"', skz.sifraartikla="+artikal.getSifraArtikla();
    }

    @Override
    public String getUpdateWhereClause() {
        return " skz.maticnibrojdobavljaca="+maticniBrojDobavljaca.getMaticniBrojDobavljaca()+" and skz.maticnibrojkupca="+maticniBrojKupca.getMaticniBrojKupca()+" and skz.brojzaduzenja="+brojZaduzenja.getBrojZaduzenja()+" and skz.rednibroj="+redniBroj;
    }

    @Override
    public String getDeleteWhereClause() {
        return " skz.maticnibrojdobavljaca="+maticniBrojDobavljaca.getMaticniBrojDobavljaca()+" and skz.maticnibrojkupca="+maticniBrojKupca.getMaticniBrojKupca()+" and skz.brojzaduzenja="+brojZaduzenja.getBrojZaduzenja()+" and skz.rednibroj="+redniBroj;
    }

    @Override
    public List<DomenskiObjekat> getListOfObjects(ResultSet rs) throws SQLException {
        List<DomenskiObjekat> listaStavki=new ArrayList<>();
        while(rs.next()){
            int mbd=rs.getInt("maticnibrojdobavljaca");
            String naz=rs.getString("nazivdobavljaca");
            Dobavljac d=new Dobavljac();
            d.setMaticniBrojDobavljaca(mbd);
            d.setNazivDobavljaca(naz);
            
            int mbk=rs.getInt("maticnibrojkupca");
            Kupac k=new Kupac();
            k.setMaticniBrojKupca(mbk);
            
            int brz=rs.getInt("brojzaduzenja");
            Date dat=rs.getDate("datumizdavanja");
            String mesto=rs.getString("mestoizdavanja");
            String napomena=rs.getString("napomena");
            
            int radnikid=rs.getInt("radnikid");
            Radnik r=new Radnik();
            r.setRadnikID(radnikid);
            
            Knjizno_Zaduzenje kz=new Knjizno_Zaduzenje(d, k, brz, dat, mesto, napomena, naz, r);
            
            int rb=rs.getInt("rednibroj");
            String sad=rs.getString("sadrzaj");
            
            int sifArt=rs.getInt("sifraartikla");
            String naziv=rs.getString("nazivartikla");
            Artikal a=new Artikal();
            a.setSifraArtikla(sifArt);
            a.setNazivArtikla(naziv);
            
            StavkaKnjiznogZaduzenja st=new StavkaKnjiznogZaduzenja(d, k, kz, rb, sad, a);
            listaStavki.add(st);
            
        }
        return listaStavki;
    }

    @Override
    public String getNameOfIDColumn() {
        return " skz.maticnibrojdobavljaca and skz.maticnibrojkupca and skz.brojzaduzenja and skz.rednibroj ";
    }

    @Override
    public int getMaxIdFromRS(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
