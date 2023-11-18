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
public class Ugovor_o_Saradnji extends DomenskiObjekat{

    private int ugovorID;
    private Date datumZakljucivanja;
    private Dobavljac dobavljac;
    private Kupac kupac;
    private int tabela;

    public Ugovor_o_Saradnji() {
    }

    public Ugovor_o_Saradnji(int ugovorID, Date datumZakljucivanja, Dobavljac dobavljac, Kupac kupac) {
        this.ugovorID = ugovorID;
        this.datumZakljucivanja = datumZakljucivanja;
        this.dobavljac = dobavljac;
        this.kupac = kupac;
    }
    public Ugovor_o_Saradnji( Date datumZakljucivanja, Dobavljac dobavljac, Kupac kupac) {
        
        this.datumZakljucivanja = datumZakljucivanja;
        this.dobavljac = dobavljac;
        this.kupac = kupac;
    }
    
    public int getUgovorID() {
        return ugovorID;
    }

    public void setUgovorID(int ugovorID) {
        this.ugovorID = ugovorID;
    }

    public Date getDatumZakljucivanja() {
        return datumZakljucivanja;
    }

    public void setDatumZakljucivanja(Date datumZakljucivanja) {
        this.datumZakljucivanja = datumZakljucivanja;
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

    public int getTabela() {
        return tabela;
    }

    public void setTabela(int tabela) {
        this.tabela = tabela;
    }
    
    @Override
    public String getTableName() {
        
                System.out.println(this.tabela);
        switch(this.tabela){
            case 1:
                System.out.println("uslo u case 1");
                return " Ugovor_o_saradnji PARTITION(DATUMZAKLJUCIVANJA_2020) u ";
            case 2:
                System.out.println("uslo u case 2");
                return " Ugovor_o_saradnji PARTITION(DATUMZAKLJUCIVANJA_2021) u ";
            case 3:
                System.out.println("uslo u case 3");
                return " Ugovor_o_saradnji PARTITION(DATUMZAKLJUCIVANJA_2022) u ";
            default:
                System.out.println("uslo u default");
                return " Ugovor_o_saradnji u ";
        }
    }

    @Override
    public String getColumnNames() {
        
        return " u.ugovorid,u.datumzakljucivanja,d.maticnibrojdobavljaca,d.pibdobavljaca,d.nazivdobavljaca,d.mestodobavljaca,d.adresadobavljaca,d.tekuciracun, k.maticnibrojkupca,k.pibkupca,k.nazivkupca,k.mestokupca,k.adreskupca,k.telefon,k.ziroracun ";
    }

    @Override
    public String columnForOrderBy() {
        return " u.ugovorid ";
    }

    @Override
    public String join1() {
        return " join dobavljac d on u.maticnibrojdobavljaca=d.maticnibrojdobavljaca join kupac k on u.maticnibrojkupca=k.maticnibrojkupca ";
    }

    @Override
    public String getColumnValues() {
        SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yy");
        String dZak=sdf.format(datumZakljucivanja.getTime());
        return ugovorID+",'"+dZak+"',"+dobavljac.getMaticniBrojDobavljaca()+","+kupac.getMaticniBrojKupca();
    }

    @Override
    public String getInsertColumnNames() {
        return " ugovorid, datumzakljucivanja, maticnibrojdobavljaca, maticnibrojkupca ";
    }

    @Override
    public String getUpdateClause() {
        SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yy");
        String dtmZklj=sdf.format(datumZakljucivanja.getTime());
        return " u.datumzakljucivanja='"+dtmZklj+"',u.maticnibrojdobavljaca="+dobavljac.getMaticniBrojDobavljaca()+",u.maticnibrojkupca="+kupac.getMaticniBrojKupca();
    }

    @Override
    public String getUpdateWhereClause() {
        return " u.ugovorid="+ugovorID;
    }

    @Override
    public String getDeleteWhereClause() {
        return " u.ugovorid="+ugovorID;
    }

    @Override
    public List<DomenskiObjekat> getListOfObjects(ResultSet rs) throws SQLException {
        List<DomenskiObjekat> listaUgovora=new ArrayList<>();
        while(rs.next()){
            int id=rs.getInt("UgovorID");
            Date datum=rs.getDate("datumzakljucivanja");
            Ugovor_o_Saradnji u=new Ugovor_o_Saradnji();
            u.setUgovorID(id);
            u.setDatumZakljucivanja(datum);
            
            int mbk=rs.getInt("maticnibrojkupca");
            int pibk=rs.getInt("pibkupca");
            String nazivk=rs.getString("nazivkupca");
            String mestok=rs.getString("mestokupca");
            String adresak=rs.getString("adreskupca");
            String telefon=rs.getString("telefon");
            long zr=rs.getLong("ziroracun");
            Kupac k=new Kupac(mbk, pibk, nazivk, mestok, adresak, telefon, zr);
            u.setKupac(k);
            
            int mbd=rs.getInt("maticnibrojdobavljaca");
            int pibd=rs.getInt("pibdobavljaca");
            String nazivd=rs.getString("nazivdobavljaca");
            String mestod=rs.getString("mestodobavljaca");
            String adresa=rs.getString("adresadobavljaca");
            long tr=rs.getLong("tekuciracun");
            Dobavljac d=new Dobavljac(mbd, pibd, nazivd, mestod, adresa, tr);
            u.setDobavljac(d);
            
            
            //Ugovor_o_Saradnji uos=new Ugovor_o_Saradnji(id, datum, d, k);
            listaUgovora.add(u);
        }
        return listaUgovora;
    }

    @Override
    public String getNameOfIDColumn() {
        return " u.ugovorid ";
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

    @Override
    public String toString() {
        return "Ugovor o saradnji [ Kupac: "+kupac.getNazivKupca()+" - Dobavljac: "+dobavljac.getNazivDobavljaca()+" - "+datumZakljucivanja+" ]";
    }

}
