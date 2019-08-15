package com.turnkey.setups;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.jdbc.OracleTypes;

import LMSG.view.Base.GlobalCC;

import LMSG.view.Quotation.Quotations;

import LMSG.view.connect.DBConnector;

public class interestRatesDAO {
    public interestRatesDAO() {
        super();
    }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    public List<interestRates> findReinstatementRates()
    {

       DBConnector myConn=new DBConnector();
      Connection conn=myConn.getDatabaseConn();
      CallableStatement cst=null;
      List<interestRates> myQuotations = new ArrayList<interestRates>();
        try {
          String quotQuery="begin LMS_SETUPS_CURSOR.reinst_intrst_rates(?,?,?);end;";
       
          cst=conn.prepareCall(quotQuery);
          cst.registerOutParameter(1,OracleTypes.CURSOR);
          cst.setBigDecimal(2,null);
          cst.setBigDecimal(3,(BigDecimal)session.getAttribute("ProductCode"));
          cst.execute();
          ResultSet rs=(ResultSet)cst.getObject(1);
          while(rs.next()) {
            interestRates rate=new interestRates();
              rate.setRirCode(rs.getBigDecimal(1));
              rate.setRirProdCode(rs.getBigDecimal(2));
              rate.setRirProdshtdesc(rs.getString(3));
              rate.setRirRate(rs.getBigDecimal(4));
              rate.setRirWef(rs.getDate(5));
              rate.setRirWet(rs.getDate(6));
              myQuotations.add(rate);
          }
    }
        catch(Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
            }
      return myQuotations;
   
}
    public List<interestRates> findGeneralInterestRates()
    {

       DBConnector myConn=new DBConnector();
      Connection conn=myConn.getDatabaseConn();
      CallableStatement cst=null;
      List<interestRates> myQuotations = new ArrayList<interestRates>();
        try {
          String quotQuery="begin LMS_SETUPS_CURSOR.genrl_intrst_rates(?,?,?);end;";

          cst=conn.prepareCall(quotQuery);
          cst.registerOutParameter(1,OracleTypes.CURSOR);
          cst.setBigDecimal(2,null);
          cst.setBigDecimal(3,(BigDecimal)session.getAttribute("ProductCode"));
          cst.execute();
          ResultSet rs=(ResultSet)cst.getObject(1);
          while(rs.next()) {
            interestRates rate=new interestRates();
              rate.setLgrCode(rs.getBigDecimal(1));
              rate.setLgrProdCode(rs.getBigDecimal(2));
              rate.setLgrType(rs.getString(3));
              rate.setLgrRate(rs.getBigDecimal(4));
              rate.setLgrApplicationType(rs.getString(5));
              rate.setLgrDivFactor(rs.getBigDecimal(6));
              rate.setLgrDependsonFreq(rs.getString(7));
              rate.setLgrWef(rs.getDate(8));
              rate.setLgrWet(rs.getDate(9));
              rate.setApplicTypeDesc(rs.getString(11));
              rate.setFreqDesc(rs.getString(10));
              rate.setTypeDesc(rs.getString(12));
              myQuotations.add(rate);
          }
    }
        catch(Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
            }
      return myQuotations;
    
    }
    
  public List<interestRates> findGeneralInterestRatesForTable()
  {

     DBConnector myConn=new DBConnector();
    Connection conn=myConn.getDatabaseConn();
    CallableStatement cst=null;
    List<interestRates> myQuotations = new ArrayList<interestRates>();
      try {
        String quotQuery="begin LMS_SETUPS_CURSOR.genrl_intrst_rates_for_tbl(?,?,?,?);end;";
     
        cst=conn.prepareCall(quotQuery);
        cst.registerOutParameter(1,OracleTypes.CURSOR);
        cst.setBigDecimal(2,null);
        cst.setBigDecimal(3,(BigDecimal)session.getAttribute("ProductCode"));
        cst.setBigDecimal(4,(BigDecimal)session.getAttribute("lpnt_code"));
        cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(1);
        while(rs.next()) {
            interestRates rate=new interestRates();
            rate.setLgrCode(rs.getBigDecimal(1));
            rate.setLgrProdCode(rs.getBigDecimal(2));
            rate.setLgrType(rs.getString(3));
            rate.setLgrRate(rs.getBigDecimal(4));
            rate.setLgrApplicationType(rs.getString(5));
            rate.setLgrDivFactor(rs.getBigDecimal(6));
            rate.setLgrDependsonFreq(rs.getString(7));
            rate.setLgrWef(rs.getDate(8));
            rate.setLgrWet(rs.getDate(9));
            rate.setApplicTypeDesc(rs.getString(11));
            rate.setFreqDesc(rs.getString(10));
            rate.setTypeDesc(rs.getString(12));
            myQuotations.add(rate);
        }
      rs.close();
      cst.close();
      conn.close();      
  }
      catch(Exception e) {
              GlobalCC.EXCEPTIONREPORTING(conn,e);
          }
    return myQuotations;
  
  }
  
  public List<interestRates> findPensionTables()
  {

     DBConnector myConn=new DBConnector();
    Connection conn=myConn.getDatabaseConn();
    CallableStatement cst=null;
    List<interestRates> myQuotations = new ArrayList<interestRates>();
      try {
        String quotQuery="begin LMS_SETUPS_CURSOR.findPensionRateTables(?,?);end;";
     
        cst=conn.prepareCall(quotQuery);
        cst.registerOutParameter(1,OracleTypes.CURSOR);
        cst.setBigDecimal(2,(BigDecimal)session.getAttribute("ProductCode"));
       
        cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(1);
        while(rs.next()) {
            interestRates rate=new interestRates();

            rate.setLPNT_CODE(rs.getBigDecimal(1));
            rate.setLPNT_DESC(rs.getString(2));
            rate.setLPNT_POL_CODE(rs.getBigDecimal(3));
            rate.setPOL_POLICY_NO(rs.getString(4));
            rate.setLPNT_DEFAULT(rs.getString(5));
         
            myQuotations.add(rate);
        }
      rs.close();
      cst.close();
      conn.close();      
  }
      catch(Exception e) {
              GlobalCC.EXCEPTIONREPORTING(conn,e);
          }
    return myQuotations;
  
  }
  
  public List<interestRates> findPensionPolicies()
  {

     DBConnector myConn=new DBConnector();
    Connection conn=myConn.getDatabaseConn();
    CallableStatement cst=null;
    List<interestRates> myQuotations = new ArrayList<interestRates>();
      try {
        String quotQuery="begin LMS_SETUPS_CURSOR.find_pension_policies(?);end;";
     
        cst=conn.prepareCall(quotQuery);
        cst.registerOutParameter(1,OracleTypes.CURSOR);
       
        cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(1);
        while(rs.next()) {
            interestRates rate=new interestRates();
            
            rate.setLPNT_POL_CODE(rs.getBigDecimal(3));
            rate.setPOL_POLICY_NO(rs.getString(4));
         
            myQuotations.add(rate);
        }
      rs.close();
      cst.close();
      conn.close();      
  }
      catch(Exception e) {
              GlobalCC.EXCEPTIONREPORTING(conn,e);
          }
    return myQuotations;
  
  }
    public List<interestRates> findLoanInterestRates()
    {

       DBConnector myConn=new DBConnector();
      Connection conn=myConn.getDatabaseConn();
      CallableStatement cst=null;
      List<interestRates> myQuotations = new ArrayList<interestRates>();
        try {
          String quotQuery="begin LMS_SETUPS_CURSOR.loan_intrst_rates(?,?,?);end;";

          cst=conn.prepareCall(quotQuery);
          cst.registerOutParameter(1,OracleTypes.CURSOR);
          cst.setBigDecimal(2,null);
          cst.setBigDecimal(3,(BigDecimal)session.getAttribute("ProductCode"));
          cst.execute();
          ResultSet rs=(ResultSet)cst.getObject(1);
          while(rs.next()) {
            interestRates rate=new interestRates();
              rate.setLirCode(rs.getBigDecimal(1));
              rate.setLirProdCode(rs.getBigDecimal(2));
              rate.setLirProdShtDesc(rs.getString(3));
              rate.setLirRate(rs.getBigDecimal(4));
              rate.setLirWef(rs.getDate(5));
              rate.setLirWet(rs.getDate(6));
              rate.setServiceCharge(rs.getBigDecimal(7));
              rate.setServiceChargeDivFact(rs.getBigDecimal(8));
              
              myQuotations.add(rate);
          }
    }
        catch(Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
            }
      return myQuotations;
    
    }
}
