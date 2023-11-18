/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import db.DBBroker;
import domen.DomenskiObjekat;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;
import model.Artikal;
import model.Cena_Artikla;
import model.Clan;
import model.Dobavljac;
import model.Jedinica_Mere;
import model.Knjizno_Zaduzenje;
import model.Kupac;
import model.Prijemnica;
import model.Radnik;
import model.StavkaKnjiznogZaduzenja;
import model.StavkaPrijemnice;
import model.StavkaZapisnika;
import model.Ugovor_o_Saradnji;
import model.Zakon;
import model.Zapisnik_o_Sortiranju;

/**
 *
 * @author Ana
 */
public class Kontroler {
    private static Kontroler instanca;
    private DBBroker dbb;

    public Kontroler() throws Exception {
        dbb=new DBBroker();
        dbb.connect();
    }

    public static Kontroler getInstanca() throws Exception {
        if(instanca==null)
            instanca=new Kontroler();
        return instanca;
    }
    
    public List<Artikal> listaArtikala() throws Exception{
        Artikal a=new Artikal();
        dbb.connect();
        List<DomenskiObjekat> domObj=dbb.getWithJoin1(a);
        dbb.disconnect();
        List<Artikal> listaArt=domObj.stream().map(Artikal.class::cast).collect(toList());
        return listaArt;
    }
    public List<Jedinica_Mere> listaJM() throws Exception{
        Jedinica_Mere jm=new Jedinica_Mere();
        dbb.connect();
        List<DomenskiObjekat> domObj=dbb.getWithJoin1(jm);
        dbb.disconnect();
        List<Jedinica_Mere> listajm=domObj.stream().map(Jedinica_Mere.class::cast).collect(toList());
        return listajm;
    }
    public List<Cena_Artikla> listaCenaArtikla() throws Exception{
        Cena_Artikla ca=new Cena_Artikla();
        dbb.connect();
        List<DomenskiObjekat> domObj=dbb.getWithJoin1(ca);
        dbb.disconnect();
        List<Cena_Artikla> listaCa=domObj.stream().map(Cena_Artikla.class::cast).collect(toList());
        return listaCa;
    }
    public List<Zakon> listaZakona() throws Exception{
        Zakon z=new Zakon();
        dbb.connect();
        List<DomenskiObjekat> domObj=dbb.getAll(z);
        dbb.disconnect();
        List<Zakon> listaZ=domObj.stream().map(Zakon.class::cast).collect(toList());
        return listaZ;
    }
    public List<Clan> listaClanova(Zakon z) throws Exception{
        Clan c=new Clan();
        c.setZakon(z);
        dbb.connect();
        List<DomenskiObjekat> domObj=dbb.getWithJoin1(c);
        dbb.disconnect();
        List<Clan> listaC=domObj.stream().map(Clan.class::cast).collect(toList());
        return listaC;
    }
    public List<Ugovor_o_Saradnji> listaUgovora(Ugovor_o_Saradnji u) throws Exception{
        //Ugovor_o_Saradnji u=new Ugovor_o_Saradnji();
        dbb.connect();
        List<DomenskiObjekat> domObj=dbb.getWithJoin1(u);
        dbb.disconnect();
        List<Ugovor_o_Saradnji> listaU=domObj.stream().map(Ugovor_o_Saradnji.class::cast).collect(toList());
        return listaU;
    }
    public List<Kupac> listaKupaca() throws Exception{
        Kupac k=new Kupac();
        dbb.connect();
        List<DomenskiObjekat> domObj=dbb.getWithJoin1(k);
        dbb.disconnect();
        List<Kupac> listaK=domObj.stream().map(Kupac.class::cast).collect(toList());
        return listaK;
    }
    
    public List<Dobavljac> listaDobavljaca() throws Exception{
        Dobavljac d=new Dobavljac();
        dbb.connect();
        List<DomenskiObjekat> domObj=dbb.getWithJoin1(d);
        dbb.disconnect();
        List<Dobavljac> listaD=domObj.stream().map(Dobavljac.class::cast).collect(toList());
        return listaD;
    }
    public List<Radnik> listaRadnika() throws Exception{
        Radnik r=new Radnik();
        dbb.connect();
        List<DomenskiObjekat> domObj=dbb.getWithJoin1(r);
        dbb.disconnect();
        List<Radnik> listaR=domObj.stream().map(Radnik.class::cast).collect(toList());
        return listaR;
    }
    public List<Knjizno_Zaduzenje> listaKnjiznihZaduzenja() throws Exception{
        Knjizno_Zaduzenje kz=new Knjizno_Zaduzenje();
        dbb.connect();
        List<DomenskiObjekat> domObj=dbb.getWithJoin1(kz);
        dbb.disconnect();
        List<Knjizno_Zaduzenje> listaKZ=domObj.stream().map(Knjizno_Zaduzenje.class::cast).collect(toList());
        return listaKZ;
    }
    public List<StavkaKnjiznogZaduzenja> listaStavkiKnjiznogZaduzenja(Knjizno_Zaduzenje kz) throws Exception{
        StavkaKnjiznogZaduzenja skz=new StavkaKnjiznogZaduzenja();
        skz.setBrojZaduzenja(kz);
        dbb.connect();
        List<DomenskiObjekat> domObj=dbb.getWithJoin1(skz);
        dbb.disconnect();
        List<StavkaKnjiznogZaduzenja> listaStavki=domObj.stream().map(StavkaKnjiznogZaduzenja.class::cast).collect(toList());
        return listaStavki;
    }
    public List<Zapisnik_o_Sortiranju> listaZapisnika() throws Exception{
        Zapisnik_o_Sortiranju zap=new Zapisnik_o_Sortiranju();
        dbb.connect();
        List<DomenskiObjekat> domObj=dbb.getWithJoin1(zap);
        dbb.disconnect();
        List<Zapisnik_o_Sortiranju> listaZap=domObj.stream().map(Zapisnik_o_Sortiranju.class::cast).collect(toList());
        return listaZap;
    }
    public List<StavkaZapisnika> listaStavkiZapisnika(Zapisnik_o_Sortiranju zp) throws Exception{
        StavkaZapisnika sz=new StavkaZapisnika();
        sz.setZapisnik(zp);
        dbb.connect();
        List<DomenskiObjekat> domObj=dbb.getWithJoin1(sz);
        dbb.disconnect();
        List<StavkaZapisnika> listaSt=domObj.stream().map(StavkaZapisnika.class::cast).collect(toList());
        return listaSt;
    }
    public List<Prijemnica> listaPrijemnica() throws Exception{
        Prijemnica p=new Prijemnica();
        dbb.connect();
        List<DomenskiObjekat> domObj=dbb.getWithJoin1(p);
        dbb.disconnect();
        List<Prijemnica> listaP=domObj.stream().map(Prijemnica.class::cast).collect(toList());
        return listaP;
    }
    public List<StavkaPrijemnice> listaStavkiPrijemnice(Prijemnica p) throws Exception{
        StavkaPrijemnice sp=new StavkaPrijemnice();
        sp.setPrijemnica(p);
        dbb.connect();
        List<DomenskiObjekat> domObj=dbb.getWithJoin1(sp);
        dbb.disconnect();
        List<StavkaPrijemnice> listaSt=domObj.stream().map(StavkaPrijemnice.class::cast).collect(toList());
        return listaSt;
    }
    
    public void insertWithoutAutoincrement(DomenskiObjekat domObj) throws Exception{
        dbb.connect();
        dbb.insertWithoutAutoincrement(domObj);
        dbb.disconnect();
    }
    public void insertWithAutoincrement(DomenskiObjekat domObj) throws Exception{
        dbb.connect();
        dbb.insertWithAutoincrement(domObj);
        dbb.disconnect();
    }
    public int returnMaxID(DomenskiObjekat domObj) throws Exception{
        dbb.connect();
        int id=dbb.returnMaxID(domObj);
        dbb.disconnect();
        return id;
    }
    public void update(DomenskiObjekat domObj) throws Exception{
        dbb.connect();
        dbb.update(domObj);
        dbb.disconnect();
    }
    public void delete(DomenskiObjekat domObj) throws Exception{
        dbb.connect();
        dbb.delete(domObj);
        dbb.disconnect();
    }
}
