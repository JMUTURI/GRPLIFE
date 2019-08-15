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

import LMSG.view.Base.LOVCC;

import LMSG.view.connect.DBConnector;

import LMSG.view.connect.DBConnector;

public class prodDependentsDAO extends LOVCC {
  public prodDependentsDAO() {
  }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  public List<prodDependents> findProdDependents(){
     DBConnector myConn=new DBConnector();
    Connection conn=myConn.getDatabaseConn();
    List<prodDependents> prodDpdsList=new ArrayList<prodDependents>();
    String prodDpsQuery="begin LMS_WEB_CURSOR_GRP.get_quot_cover_dependents(?,?,?);end;";
    try
    {
      CallableStatement cstmt=conn.prepareCall(prodDpsQuery);
      cstmt.registerOutParameter(1,OracleTypes.CURSOR);
      cstmt.setBigDecimal(2,(BigDecimal)session.getAttribute("qcvtcvtCode"));
      cstmt.setBigDecimal(3,(BigDecimal)session.getAttribute("ProductCode"));
      cstmt.execute();
      //System.out.println("I shall Know HIm"+LOVCC.qcvtcvtCode);
      ResultSet rs=(ResultSet)cstmt.getObject(1);
     
      while(rs.next()) 
      {
        prodDependents quotTax=new prodDependents();
        quotTax.setMax_allowed(rs.getBigDecimal(4));
        quotTax.setDTY_DESCRIPTION(rs.getString(3));
        quotTax.setDTY_SHT_DESC(rs.getString(2));
        quotTax.setDTY_CODE(rs.getBigDecimal(1));
        prodDpdsList.add(quotTax);
      }
      conn.close();   
  }
    catch(Exception e) {
      e.printStackTrace();
    }
    return prodDpdsList;
  }
}
