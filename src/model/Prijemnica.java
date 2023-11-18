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
public class Prijemnica extends DomenskiObjekat{

    private int brojPrijemnice;
    private Date datumIzdavanja;
    private String nacinOtpreme;
    private String mestoIzdavanja;
    private Dobavljac dobavljac;
    private Kupac kupac;
    private Radnik radnik;
    private double iznosUkupno;
    private boolean iznosUkupnoIzmenjen=false;

    public Prijemnica() {
    }

    public Prijemnica(int brojPrijemnice, Date datumIzdavanja, String nacinOtpreme, String mestoIzdavanja, Dobavljac dobavljac, Kupac kupac, Radnik radnik, double iznosUkupno) {
        this.brojPrijemnice = brojPrijemnice;
        this.datumIzdavanja = datumIzdavanja;
        this.nacinOtpreme = nacinOtpreme;
        this.mestoIzdavanja = mestoIzdavanja;
        this.dobavljac = dobavljac;
        this.kupac = kupac;
        this.radnik = radnik;
        this.iznosUkupno = iznosUkupno;
    }
    public int getBrojPrijemnice() {
        return brojPrijemnice;
    }

    public void setBrojPrijemnice(int brojPrijemnice) {
        this.brojPrijemnice = brojPrijemnice;
    }

    public Date getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(Date datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public String getNacinOtpreme() {
        return nacinOtpreme;
    }

    public void setNacinOtpreme(String nacinOtpreme) {
        this.nacinOtpreme = nacinOtpreme;
    }

    public String getMestoIzdavanja() {
        return mestoIzdavanja;
    }

    public void setMestoIzdavanja(String mestoIzdavanja) {
        this.mestoIzdavanja = mestoIzdavanja;
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

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    public double getIznosUkupno() {
        return iznosUkupno;
    }

    public void setIznosUkupno(double iznosUkupno) {
        this.iznosUkupno = iznosUkupno;
    }

    public boolean isIznosUkupnoIzmenjen() {
        return iznosUkupnoIzmenjen;
    }

    public void setIznosUkupnoIzmenjen(boolean iznosUkupnoIzmenjen) {
        this.iznosUkupnoIzmenjen = iznosUkupnoIzmenjen;
    }
    
    
    @Override
    public String getTableName() {
        return " prijemnica p ";
    }

    @Override
    public String getColumnNames() {
        return " p.brojprijemnice, p.datumizdavanja, p.nacinotpreme, p.mestoizdavanjarobe, d.maticnibrojdobavljaca,d.pibdobavljaca,d.nazivdobavljaca,d.mestodobavljaca,d.adresadobavljaca,d.tekuciracun, k.maticnibrojkupca,k.pibkupca,k.nazivkupca,k.mestokupca,k.adreskupca,k.telefon as TELEFONKUPCA,k.ziroracun , r.radnikid, r.jmbg.get_jmbgBroj() as JMBG, r.imeprezime, r.telefon ,p.iznosukupno ";
    }

    @Override
    public String columnForOrderBy() {
        return " p.brojprijemnice ";
    }

    @Override
    public String join1() {
        return " join dobavljac d on d.maticnibrojdobavljaca=p.maticnibrojdobavljaca join kupac k on k.maticnibrojkupca=p.maticnibrojkupca join radnik r on r.radnikid=p.radnikid ";
    }


    @Override
    public String getColumnValues() {
        SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yy");
        String dat=sdf.format(this.datumIzdavanja.getTime());
        return brojPrijemnice+",'"+dat+"','"+nacinOtpreme+"','"+mestoIzdavanja+"',"+dobavljac.getMaticniBrojDobavljaca()+","+kupac.getMaticniBrojKupca()+","+radnik.getRadnikID();
    }

    @Override
    public String getInsertColumnNames() {
        return " brojprijemnice, datumizdavanja, nacinotpreme, mestoizdavanjarobe, maticnibrojdobavljaca, maticnibrojkupca, radnikid ";
    }

    @Override
    public String getUpdateClause() {
        SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yy");
        String dat=sdf.format(this.datumIzdavanja.getTime());
        String izn="";
        if(iznosUkupnoIzmenjen){
            izn=", p.iznosukupno="+iznosUkupno;
        }
        
        return " p.datumizdavanja='"+dat+"', p.nacinotpreme='"+nacinOtpreme+"',p.mestoizdavanjarobe='"+mestoIzdavanja+"',p.maticnibrojdobavljaca="+dobavljac.getMaticniBrojDobavljaca()+",p.maticnibrojkupca="+kupac.getMaticniBrojKupca()+", p.radnikid="+radnik.getRadnikID()+izn;
    }

    @Override
    public String getUpdateWhereClause() {
        return " p.brojprijemnice="+brojPrijemnice;
    }

    @Override
    public String getDeleteWhereClause() {
        return " p.brojprijemnice="+brojPrijemnice;
    }

    @Override
    public List<DomenskiObjekat> getListOfObjects(ResultSet rs) throws SQLException {
        List<DomenskiObjekat> listaPrijemnica=new ArrayList<>();
        while(rs.next()){
            
            int brPr=rs.getInt("brojprijemnice");
            Date dat=rs.getDate("datumizdavanja");
            String nac=rs.getString("nacinotpreme");
            String mesto=rs.getString("mestoizdavanjarobe");
            double izUk=rs.getDouble("iznosukupno");
            
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
            String telK=rs.getString("TELEFONKUPCA");
            long zirRacK=rs.getLong("ziroracun");
            Kupac k=new Kupac(mbK, pibK, nazivK, mestoK, adresaK, telK, zirRacK);
            
            int radID=rs.getInt("radnikid");
            long jmbg=rs.getLong("jmbg");
            String imPr=rs.getString("imeprezime");
            String tel=rs.getString("telefon");
            Radnik rad=new Radnik(radID, jmbg, imPr, tel);
            
            Prijemnica prij=new Prijemnica(brPr, dat, nac, mesto, d, k, rad, izUk);
            listaPrijemnica.add(prij);
        }
        return listaPrijemnica;
    }

    @Override
    public String getNameOfIDColumn() {
        return " p.brojprijemnice ";
    }

    @Override
    public int getMaxIdFromRS(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
