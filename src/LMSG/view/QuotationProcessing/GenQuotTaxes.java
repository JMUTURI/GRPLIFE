package LMSG.view.QuotationProcessing;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.jdbc.internal.OracleTypes;


import LMSG.view.connect.DBConnector;

public class GenQuotTaxes {
  public GenQuotTaxes() {
  }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  public List<quotationTaxes> findTaxes(){
     DBConnector myConn=new DBConnector();
    Connection conn=myConn.getDatabaseConn();
    List<quotationTaxes> quotTaxes=new ArrayList<quotationTaxes>();
    String quotationQuery="begin LMS_WEB_CURSOR_GRP.quotationTaxes(?,?);end;";
    try
    {
      CallableStatement cstmt=conn.prepareCall(quotationQuery);
      cstmt.registerOutParameter(1,OracleTypes.CURSOR);
      cstmt.setBigDecimal(2,(BigDecimal)session.getAttribute("QuoteCode"));
      cstmt.execute();
      ResultSet rs=(ResultSet)cstmt.getObject(1);
     
      while(rs.next()) 
      {
        quotationTaxes quotTax=new quotationTaxes();
        quotTax.setQuoTaxDesc(rs.getString(4));
        quotTax.setQuoTaxRate(rs.getDouble(2));
        quotTax.setQuoTaxAmt(rs.getDouble(3));
        quotTax.setQuoTaxCode(rs.getBigDecimal(1));
        quotTaxes.add(quotTax);
      }
      conn.close();    
  }
    catch(Exception e) {
      e.printStackTrace();
    }
    return quotTaxes;
}
}
