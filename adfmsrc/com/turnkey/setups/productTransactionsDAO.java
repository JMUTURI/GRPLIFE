package com.turnkey.setups;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.jdbc.internal.OracleTypes;

import LMSG.view.Base.GlobalCC;

import LMSG.view.connect.DBConnector;

public class productTransactionsDAO {
    public productTransactionsDAO() {
        super();
    }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    Connection conn=null;
    public List<productTransactions> findProductTransactions()
    
    {
      DBConnector connector=new DBConnector();
      conn=connector.getDatabaseConn();
      List<productTransactions> arrangementsList=new ArrayList<productTransactions>();
      String treatiesQuery="BEGIN LMS_SETUPS_CURSOR.prod_trans_types(?,?,?);END;";
      CallableStatement cst=null;
      try 
      {
        cst=conn.prepareCall(treatiesQuery);
        cst.registerOutParameter(1,OracleTypes.CURSOR);
        cst.setBigDecimal(2,(BigDecimal)session.getAttribute("ProductCode"));
        cst.setString(3,null);
       
        cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(1);
        while(rs.next())
        {
        productTransactions systems=new productTransactions();
            systems.setTrapProdCode(rs.getBigDecimal(1));
            systems.setTrapAccno(rs.getString(2));
            systems.setTrapContraAcc(rs.getString(3));
            systems.setTrapTrntCode(rs.getString(4));
            systems.setTrntDesc(rs.getString(5));
           
            
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
    public List<productTransactions> findTransactionTypes()
    
    {
      DBConnector connector=new DBConnector();
      conn=connector.getDatabaseConn();
      List<productTransactions> arrangementsList=new ArrayList<productTransactions>();
      String treatiesQuery="BEGIN LMS_SETUPS_CURSOR.findtransaction_types(?,?);END;";
      CallableStatement cst=null;
      try 
      {
        cst=conn.prepareCall(treatiesQuery);
        cst.registerOutParameter(1,OracleTypes.CURSOR);
        cst.setBigDecimal(2,(BigDecimal)session.getAttribute("ProductCode"));
        cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(1);
        while(rs.next())
        {
        productTransactions systems=new productTransactions();
            systems.setTrntCode(rs.getString(1));
            systems.setTransactionDesc(rs.getString(2));
                      
            
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
    public List<productTransactions> findGLAccounts()
    
    {
      DBConnector connector=new DBConnector();
      conn=connector.getDatabaseConn();
      List<productTransactions> arrangementsList=new ArrayList<productTransactions>();
      String treatiesQuery="BEGIN LMS_SETUPS_CURSOR.trans_gl_code_lov(?,?);END;";
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
        productTransactions systems=new productTransactions();
            systems.setAccNumber(rs.getString(1));
            systems.setAccName(rs.getString(2));
                      
            
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
    public List<productTransactions> findOtherProductsGLCodes()
    
    {
      DBConnector connector=new DBConnector();
      conn=connector.getDatabaseConn();
      List<productTransactions> arrangementsList=new ArrayList<productTransactions>();
      String treatiesQuery="BEGIN LMS_SETUPS_CURSOR.prod_trans_types2(?,?,?);END;";
      CallableStatement cst=null;
      try 
      {
        cst=conn.prepareCall(treatiesQuery);
        cst.registerOutParameter(1,OracleTypes.CURSOR);
        cst.setBigDecimal(2,(BigDecimal)session.getAttribute("ProductCode"));
        cst.setString(3,(String)session.getAttribute("trntCode"));
        cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(1);
        while(rs.next())
        {
        productTransactions systems=new productTransactions();
            systems.setProductDesc(rs.getString(1));
            systems.setOtherProdsGlcode(rs.getString(3));
            systems.setOtherProdsContraGlCode(rs.getString(4));
            
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
    
  public List<productTransactions> findTransTypes() 
  {   
      DBConnector dbCon=new DBConnector();
      Connection conn = null;
      conn = dbCon.getDatabaseConn();
      CallableStatement cst = null;
      String query = "begin LMS_SETUPS_CURSOR.transaction_types(?,?); end;";
      List<productTransactions> transTypesData= new ArrayList<productTransactions>();
          try {
          cst = conn.prepareCall(query);
         cst.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
         cst.setBigDecimal(2, null);
         cst.execute();
          
         ResultSet rs = (ResultSet)cst.getObject(1);
      //  ResultSet rs = cst.executeQuery();
          
          while (rs.next()) {
              
          productTransactions  transTypesDef= new productTransactions();
          transTypesDef.setTrntCode(rs.getString(1));
          transTypesDef.setTrntDesc(rs.getString(2));
          transTypesDef.setTrntGlCode(rs.getString(3));   
          transTypesDef.setTrntType(rs.getString(4));   
          transTypesDef.setTrntProdApplcb(rs.getString(5)); 
          transTypesDef.setTrntConGlCode(rs.getString(6));   
          transTypesDef.setTrntLevel(rs.getString(7));  
          transTypesData.add(transTypesDef);
               
          }
          cst.close();
          conn.commit();
          conn.close();
      } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
      return   transTypesData;
  }
}
