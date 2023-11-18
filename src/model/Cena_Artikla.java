/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.DomenskiObjekat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ana
 */
public class Cena_Artikla extends DomenskiObjekat{

    private Artikal artikal;
    private Date datumOd;
    private double iznosCene;

    public Cena_Artikla() {
    }

    public Cena_Artikla(Artikal artikal, Date datumOd, double iznosCene) {
        this.artikal = artikal;
        this.datumOd = datumOd;
        this.iznosCene = iznosCene;
    }

    public Artikal getArtikal() {
        return artikal;
    }

    public void setArtikal(Artikal artikal) {
        this.artikal = artikal;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public double getIznosCene() {
        return iznosCene;
    }

    public void setIznosCene(double iznosCene) {
        this.iznosCene = iznosCene;
    }

    @Override
    public String getTableName() {
        return " CENA_ARTIKLA c ";
    }

    @Override
    public String getColumnNames() {
        return " a.sifraartikla,a.nazivartikla,a.sifrajedinicemere,a.trenutnacena ,c.datumod,c.iznoscene ";
    }

    @Override
    public String columnForOrderBy() {
        return " c.sifraartikla,c.datumod ";
    }

    @Override
    public String join1() {
        return " join ARTIKAL a on  c.sifraartikla=a.sifraartikla ";
    }

    
    @Override
    public String getColumnValues() {
        SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yy");
        String datOd=sdf.format(this.datumOd.getTime());
        
        System.out.println(artikal.getSifraArtikla());
        System.out.println(datumOd);
        System.out.println(iznosCene);
        return artikal.getSifraArtikla()+",'"+datOd+"',"+iznosCene;
        
        
    }

    @Override
    public String getInsertColumnNames() {
        return " c.sifraartikla,c.datumod,c.iznoscene ";
    }

    @Override
    public String getUpdateClause() {
        return "c.iznoscene='"+iznosCene+"'";
    }


    @Override
    public String getUpdateWhereClause() {
        SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yy");
        String datOd=sdf.format(this.datumOd.getTime());
        return " c.sifraartikla="+artikal.getSifraArtikla()+" and to_char(c.datumod, 'DD-Mon-YY')='"+datOd+"'";
    }
    
    @Override
    public String getDeleteWhereClause() {
        SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yy");
        String datOd=sdf.format(this.datumOd.getTime());
        return " c.sifraartikla="+artikal.getSifraArtikla()+" and to_char(c.datumod, 'DD-Mon-YY')='"+datOd+"'";
    }

    @Override
    public List<DomenskiObjekat> getListOfObjects(ResultSet rs) throws SQLException {
        List listaCena=new ArrayList();
        while(rs.next()){
            int sifraArt=rs.getInt("sifraartikla");
            Artikal a=new Artikal();
            a.setSifraArtikla(sifraArt);
            
            Date datOd=rs.getDate("datumod");
            double izCene=rs.getDouble("iznoscene");
            
            Cena_Artikla ca=new Cena_Artikla(a, datOd, izCene);
            listaCena.add(ca);
        }
        return listaCena;
    }

    

    @Override
    public String getNameOfIDColumn() {
        return " c.datumod ";
    }

    @Override
    public int getMaxIdFromRS(ResultSet rs) throws SQLException {
        int id=0;
        while(rs.next()){
            
            id++;
        }
        return id;
    }

   
}
