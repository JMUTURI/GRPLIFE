package com.turnkey.setups;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.internal.OracleTypes;

import LMSG.view.Base.GlobalCC;

import LMSG.view.connect.DBConnector;

public class relationTypesDAO {
    public relationTypesDAO() {
        super();
    }
    Connection conn=null;
    public List<relationTypes> findRelationTypes()
    
    {
      DBConnector connector=new DBConnector();
      conn=connector.getDatabaseConn();
      List<relationTypes> arrangementsList=new ArrayList<relationTypes>();
      String treatiesQuery="BEGIN LMS_SETUPS_CURSOR.relation_types(?,?);END;";
      CallableStatement cst=null;
      try 
      {
        cst=conn.prepareCall(treatiesQuery);
        cst.registerOutParameter(1,OracleTypes.CURSOR);
        cst.setBigDecimal(2,null);
        cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(1);
        while(rs.next())
        {
         relationTypes systems=new relationTypes();
            systems.setRetCode(rs.getBigDecimal(1));
            systems.setRetShtDesc(rs.getString(2));
            systems.setRetDesc(rs.getString(3));
            systems.setRetComments(rs.getString(4));
            systems.setDobRequired(rs.getString(5));
            systems.setDobRequiredDesc(rs.getString(6));
            
           arrangementsList.add(systems);
        }
          conn.close();    
      }
      catch(Exception ex) 
      {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
      }
      return arrangementsList;
    }
    public List<relationTypes> findDependentTypes()
    
    {
        Connection conn=null;
      DBConnector connector=new DBConnector();
      conn=connector.getDatabaseConn();
      List<relationTypes> arrangementsList=new ArrayList<relationTypes>();
      String treatiesQuery="BEGIN LMS_SETUPS_CURSOR.dependenttypes(?,?);END;";
      CallableStatement cst=null;
      try 
      {
        cst=conn.prepareCall(treatiesQuery);
        cst.registerOutParameter(1,OracleTypes.CURSOR);
        cst.setBigDecimal(2,null);
        cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(1);
        while(rs.next())
        {
         relationTypes systems=new relationTypes();
            systems.setDtyCode(rs.getBigDecimal(1));
            systems.setDtyShtDesc(rs.getString(2));
            systems.setDtyDesc(rs.getString(3));
           
            
           arrangementsList.add(systems);
        }
          conn.close();    
      }
      catch(Exception ex) 
      {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
      }
      return arrangementsList;
    }
}
