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
public class Knjizno_Zaduzenje extends DomenskiObjekat{

    private Dobavljac dobavljac;
    private Kupac kupac;
    private int brojZaduzenja;
    private Date datumIzdavanja;
    private String mestoIzdavanja;
    private String napomena;
    private String nazivDobavljaca;
    private Radnik radnik;
    private boolean nazivDobIzmenjen=false;

    public Knjizno_Zaduzenje() {
    }

    public Knjizno_Zaduzenje(Dobavljac dobavljac, Kupac kupac, int brojZaduzenja, Date datumIzdavanja, String mestoIzdavanja, String napomena, String nazivDobavljaca, Radnik radnik) {
        this.dobavljac = dobavljac;
        this.kupac = kupac;
        this.brojZaduzenja = brojZaduzenja;
        this.datumIzdavanja = datumIzdavanja;
        this.mestoIzdavanja = mestoIzdavanja;
        this.napomena = napomena;
        this.nazivDobavljaca = nazivDobavljaca;
        this.radnik = radnik;
    }
    public Dobavljac getDobavljac() {
        return dobavljac;
    }

    public void setDobavljac(Dobavljac dobavljac) {
        this.dobavljac = dobavljac;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    public int getBrojZaduzenja() {
        return brojZaduzenja;
    }

    public void setBrojZaduzenja(int brojZaduzenja) {
        this.brojZaduzenja = brojZaduzenja;
    }

    public Date getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(Date datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public String getMestoIzdavanja() {
        return mestoIzdavanja;
    }

    public void setMestoIzdavanja(String mestoIzdavanja) {
        this.mestoIzdavanja = mestoIzdavanja;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public String getNazivDobavljaca() {
        return nazivDobavljaca;
    }

    public void setNazivDobavljaca(String nazivDobavljaca) {
        this.nazivDobavljaca = nazivDobavljaca;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    public boolean isNazivDobIzmenjen() {
        return nazivDobIzmenjen;
    }

    public void setNazivDobIzmenjen(boolean nazivDobIzmenjen) {
        this.nazivDobIzmenjen = nazivDobIzmenjen;
    }
    
    
    @Override
    public String getTableName() {
        return " Knjizno_zaduzenje kz ";
    }

    @Override
    public String getColumnNames() {
        
        return " d.maticnibrojdobavljaca,d.pibdobavljaca, d.nazivdobavljaca, d.mestodobavljaca, d.adresadobavljaca, d.tekuciracun, k.maticnibrojkupca, k.pibkupca, k.nazivkupca, k.mestokupca, k.adreskupca, k.telefon as telefonkupca, ziroracun,kz.brojzaduzenja, kz.datumizdavanja, kz.mestoizdavanja, kz.napomena, d.nazivdobavljaca, r.radnikid,r.jmbg.get_jmbgBroj() as JMBG, r.imeprezime, r.telefon as radniktelefon ";
    }

    @Override
    public String columnForOrderBy() {
        return " kz.datumizdavanja ";
    }

    @Override
    public String join1() {
        return " join dobavljac d on d.maticnibrojdobavljaca=kz.maticnibrojdobavljaca join kupac k on k.maticnibrojkupca=kz.maticnibrojkupca join radnik r on r.radnikid=kz.radnikid ";
    }


    @Override
    public String getColumnValues() {
        SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yy");
        String dIzd=sdf.format(datumIzdavanja.getTime());
        return dobavljac.getMaticniBrojDobavljaca() +","+kupac.getMaticniBrojKupca()+","+brojZaduzenja+",'"+dIzd+"','"+mestoIzdavanja+"','"+napomena+"',"+radnik.getRadnikID();
    }

    @Override
    public String getInsertColumnNames() {
        return " maticnibrojdobavljaca, maticnibrojkupca, brojzaduzenja, datumizdavanja, mestoizdavanja, napomena, radnikid ";
    }

    @Override
    public String getUpdateClause() {
        SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yy");
        String dtmIzd=sdf.format(datumIzdavanja.getTime());
        
        String nazivDob="";
        if(nazivDobIzmenjen==true){
            nazivDob=", kz.nazivdobavljaca='"+this.nazivDobavljaca+"' ";
        }
        return "kz.datumizdavanja='"+dtmIzd+"', kz.mestoizdavanja='"+mestoIzdavanja+"',kz.napomena='"+napomena+"',kz.radnikid="+radnik.getRadnikID()+nazivDob;
    }

    
    @Override
    public String getUpdateWhereClause() {
        return " kz.maticnibrojdobavljaca="+dobavljac.getMaticniBrojDobavljaca()+" and kz.maticnibrojkupca="+kupac.getMaticniBrojKupca()+" and kz.brojzaduzenja="+brojZaduzenja;
    }

    @Override
    public String getDeleteWhereClause() {
        return " kz.maticnibrojdobavljaca="+dobavljac.getMaticniBrojDobavljaca()+" and kz.maticnibrojkupca="+kupac.getMaticniBrojKupca()+" and kz.brojzaduzenja="+brojZaduzenja;
    }

    @Override
    public List<DomenskiObjekat> getListOfObjects(ResultSet rs) throws SQLException {
        List<DomenskiObjekat> listaZaduzenja=new ArrayList<>();
        while(rs.next()){
            
            int mbD=rs.getInt("maticnibrojdobavljaca");
            int pibD=rs.getInt("pibdobavljaca");
            String nazivD=rs.getString("nazivdobavljaca");
            String mestoD=rs.getString("mestodobavljaca");
            String adresaD=rs.getString("adresadobavljaca");
            long tekRacD=rs.getLong("tekuciracun");
            Dobavljac d=new Dobavljac(mbD, pibD, nazivD, mestoD, adresaD, tekRacD);
            
            int mbK=rs.getInt("maticnibrojKupca");
            int pibK=rs.getInt("pibKupca");
            String nazivK=rs.getString("nazivKupca");
            String mestoK=rs.getString("mestoKupca");
            String adresaK=rs.getString("adresKupca");
            String telK=rs.getString("telefonkupca");
            long zirRacK=rs.getLong("ziroracun");
            Kupac k=new Kupac(mbK, pibK, nazivK, mestoK, adresaK, telK, zirRacK);
            
            int radnikid=rs.getInt("radnikid");
            long jmb=rs.getLong("JMBG");
            String imePrez=rs.getString("IMEPREZIME");
            String tel=rs.getString("radniktelefon");
            Radnik r=new Radnik(radnikid, jmb, imePrez, tel);
            
            int brZad=rs.getInt("brojzaduzenja");
            Date datIzd=rs.getDate("datumizdavanja");
            String mestoIzd=rs.getString("mestoizdavanja");
            String nap=rs.getString("napomena");
            
            Knjizno_Zaduzenje knjiZad=new Knjizno_Zaduzenje(d, k, brZad, datIzd, mestoIzd, nap, nazivD, r);
            listaZaduzenja.add(knjiZad);
        }
        return listaZaduzenja;
    }

    @Override
    public String getNameOfIDColumn() {
        return " kz.brojzaduzenja ";
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
}
