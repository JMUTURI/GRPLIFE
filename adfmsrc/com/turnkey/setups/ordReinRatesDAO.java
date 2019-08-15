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


import LMSG.view.connect.DBConnector;
public class ordReinRatesDAO {
    public ordReinRatesDAO() {
        super();
    }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    public List<ordReinRates> findOrdReinsuranceRates()
    {

       DBConnector myConn=new DBConnector();
      Connection conn=myConn.getDatabaseConn();
      CallableStatement cst=null;
      List<ordReinRates> myQuotations = new ArrayList<ordReinRates>();
        try {
          String quotQuery="begin LMS_SETUPS_CURSOR.findOrdReinRatesRec(?);end;";
          
          cst=conn.prepareCall(quotQuery);
          cst.registerOutParameter(1,OracleTypes.CURSOR);
         
          cst.execute();
          ResultSet rs=(ResultSet)cst.getObject(1);
          while(rs.next()) {
            ordReinRates rate=new ordReinRates();
              rate.setOrrpCode(rs.getBigDecimal(1));
              rate.setOrrpShtDesc(rs.getString(2));
              rate.setOrrpDesc(rs.getString(3));
              rate.setOrrpClassSpecific(rs.getString(4));
              myQuotations.add(rate);
          }
    }
        catch(Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
            }
      return myQuotations;
    
    }
    public List<ordReinRates> findOrdReinsuranceRatesDescription()
    {

       DBConnector myConn=new DBConnector();
      Connection conn=myConn.getDatabaseConn();
      CallableStatement cst=null;
      List<ordReinRates> myQuotations = new ArrayList<ordReinRates>();
        try {
          String quotQuery="begin LMS_SETUPS_CURSOR.find_rein_rates(?,?);end;";
          
          cst=conn.prepareCall(quotQuery);
          cst.registerOutParameter(1,OracleTypes.CURSOR);
          cst.setBigDecimal(2,(BigDecimal)session.getAttribute("orrpCode"));
          cst.execute();
          ResultSet rs=(ResultSet)cst.getObject(1);
          while(rs.next()) {
            ordReinRates rate=new ordReinRates();
              rate.setOrrtCode(rs.getBigDecimal(1));
              rate.setOrrtAnbFrom(rs.getString(2));
              rate.setOrrtAnbTo(rs.getString(3));
              rate.setOrrtRate(rs.getBigDecimal(4));
              rate.setOrrtDivFactor(rs.getBigDecimal(5));
              rate.setOrrtRateType(rs.getString(6));
              rate.setOrrtRateTypeDesc(rs.getString(7));
              rate.setOrrtWef(rs.getDate(8));
              rate.setOrrtWet(rs.getDate(9));
              myQuotations.add(rate);
          }
    }
        catch(Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
            }
      return myQuotations;
    
    }
}
