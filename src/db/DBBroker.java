/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.DomenskiObjekat;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ana
 */
public class DBBroker {
    private Connection konekcija;
    private String url;
    private String username;
    private String password;

    public DBBroker() {
        try {
            Properties properties=new Properties();
            FileInputStream fis=new FileInputStream("config.properties");
            properties.load(fis);
            
            this.url=properties.getProperty("url");
            this.username=properties.getProperty("username");
            this.password=properties.getProperty("password");
            
            fis.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void connect() throws Exception {
        try {
            konekcija=DriverManager.getConnection(url,username, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Greska prilikom uspostavljanja konekcije");
        }
    }
    public void disconnect() throws Exception{
        if(konekcija!=null){
            try {
                konekcija.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new Exception("Greska prilikom raskidanja konekcije");
            }
        }
    }
    public void commit() throws Exception{
        if(konekcija!=null){
            try {
                konekcija.commit();
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new Exception("Greska prilikom potvrdjivanja transakcije");
            }
        }
    }
    public void rollback() throws Exception{
        if(konekcija!=null){
            try {
                konekcija.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new Exception("Greska prilikom ponistavanja transakcije");
            }
        }
    }
    public List<DomenskiObjekat> getAll(DomenskiObjekat domObj) throws SQLException{
        Statement statement=konekcija.createStatement();
        String upit="select"+domObj.getColumnNames()+"from"+domObj.getTableName()+"order by"+domObj.columnForOrderBy();
        System.out.println(upit);
        ResultSet rs=statement.executeQuery(upit);
        return domObj.getListOfObjects(rs);
    }
    
    public List<DomenskiObjekat> getWithJoin1(DomenskiObjekat domObj) throws SQLException{
        Statement statement=konekcija.createStatement();
        String upit="select "+domObj.getColumnNames()+" from "+domObj.getTableName()+domObj.join1()+" order by "+domObj.columnForOrderBy();
        System.out.println(upit);
        ResultSet rs=statement.executeQuery(upit);
        return domObj.getListOfObjects(rs);
    }
    public int returnMaxID(DomenskiObjekat domObj) throws SQLException{
        Statement statement=konekcija.createStatement();
        String upit="select max("+domObj.getNameOfIDColumn()+") as max from "+domObj.getTableName();
        System.out.println(upit);
        ResultSet rs=statement.executeQuery(upit);
        return domObj.getMaxIdFromRS(rs);
    }
    public int insertWithoutAutoincrement(DomenskiObjekat domObj) throws SQLException{
        int id=returnMaxID(domObj);
        id++;
        System.out.println(id);
        Statement statement=konekcija.createStatement();
        
        String upit="insert into "+domObj.getTableName()+"("+domObj.getInsertColumnNames()+") values ("+id+","+domObj.getColumnValues()+")";
        System.out.println(upit);
        return statement.executeUpdate(upit);
    }
    public int insertWithAutoincrement(DomenskiObjekat domObj) throws SQLException{
        Statement statement=konekcija.createStatement();
        System.out.println(domObj.getColumnValues());
        String upit="insert into "+domObj.getTableName()+"("+domObj.getInsertColumnNames()+") values ("+domObj.getColumnValues()+")";
        System.out.println(upit);
        return statement.executeUpdate(upit);
    }
    public int update(DomenskiObjekat domObj) throws SQLException{
        Statement statement=konekcija.createStatement();
        String upit="update "+domObj.getTableName()+" set "+domObj.getUpdateClause()+" where "+domObj.getUpdateWhereClause();
        System.out.println(upit);
        return statement.executeUpdate(upit);
    }
    public int delete(DomenskiObjekat domObj) throws SQLException{
        Statement statement=konekcija.createStatement();
        String upit="delete from "+domObj.getTableName()+" where "+domObj.getDeleteWhereClause();
        System.out.println(upit);
        return statement.executeUpdate(upit);
    }
}
