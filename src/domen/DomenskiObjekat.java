/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ana
 */
public abstract class DomenskiObjekat implements Serializable{
    
    public abstract String getTableName();
    public abstract String getColumnNames();
    public abstract String columnForOrderBy();
    public abstract String join1();
    public abstract String getColumnValues();
    public abstract String getInsertColumnNames();
    public abstract String getUpdateClause();
    public abstract String getUpdateWhereClause();
    public abstract String getDeleteWhereClause();
    public abstract List<DomenskiObjekat> getListOfObjects(ResultSet rs) throws SQLException;
    public abstract String getNameOfIDColumn();
    public abstract int getMaxIdFromRS(ResultSet rs)throws SQLException;
    
}
