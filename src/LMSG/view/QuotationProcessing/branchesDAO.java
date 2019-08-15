package LMSG.view.QuotationProcessing;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.internal.OracleTypes;

import LMSG.view.connect.DBConnector;

public class branchesDAO {
  public branchesDAO() {
  }
  Connection conn=null;
  CallableStatement cstmt=null;
  public List<branches> findBranches() 
  {
    conn=new DBConnector().getDatabaseConn();
    List<branches> BranchesList=new ArrayList<branches>();
    String branchesQuery="BEGIN LMS_WEB_CURSOR_GRP.getBranches(?);END;";
    try 
    {
      cstmt=conn.prepareCall(branchesQuery);
      cstmt.registerOutParameter(1,OracleTypes.CURSOR);
      cstmt.execute();
      ResultSet rs=(ResultSet)cstmt.getObject(1);
      while(rs.next()) 
      {
        branches prop=new branches();
        prop.setBRN_SHT_DESC(rs.getString(2));
        prop.setBRN_CODE(rs.getBigDecimal(1));
        prop.setBRN_NAME(rs.getString(3));
       BranchesList.add(prop);
      }
        conn.close();   
    }
    catch(Exception ex) 
    {
      ex.printStackTrace();
    }
    return BranchesList;
  }
  public List<branches> findBudgetBranches() 
  {
    conn=new DBConnector().getDatabaseConn();
    List<branches> BranchesList=new ArrayList<branches>();
    String branchesQuery="BEGIN LMS_SETUPS_CURSOR.findBudgetBranches(?);END;";
    try 
    {
      cstmt=conn.prepareCall(branchesQuery);
      cstmt.registerOutParameter(1,OracleTypes.CURSOR);
      cstmt.execute();
      ResultSet rs=(ResultSet)cstmt.getObject(1);
      while(rs.next()) 
      {
        branches prop=new branches();
        prop.setBRN_SHT_DESC(rs.getString(2));
        prop.setBRN_CODE(rs.getBigDecimal(1));
        prop.setBRN_NAME(rs.getString(3));
       BranchesList.add(prop);
      }
        conn.close();   
    }
    catch(Exception ex) 
    {
      ex.printStackTrace();
    }
    return BranchesList;
  }
}
