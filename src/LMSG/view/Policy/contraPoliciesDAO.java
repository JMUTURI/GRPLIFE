package LMSG.view.Policy;

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

import LMSG.view.QuotationProcessing.QuotDAO;
import LMSG.view.QuotationProcessing.prodDependents;

import LMSG.view.connect.DBConnector;

import LMSG.view.connect.DBConnector;

public class contraPoliciesDAO extends LOVCC {
  public contraPoliciesDAO() {
  }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  public List<contraPolicies> ContraPolicies(){
     DBConnector myConn=new DBConnector();
    Connection conn=myConn.getDatabaseConn();
    List<contraPolicies> prodDpdsList=new ArrayList<contraPolicies>();
    String prodDpsQuery="begin LMS_WEB_CURSOR_GRP.GetContraPolicies(?,?,?);end;";
    try
    {
      CallableStatement cstmt=conn.prepareCall(prodDpsQuery);
      cstmt.registerOutParameter(1,OracleTypes.CURSOR);
      cstmt.setBigDecimal(2,(BigDecimal)session.getAttribute("ProductCode"));
      cstmt.setBigDecimal(3,null);
      cstmt.execute();
      ResultSet rs=(ResultSet)cstmt.getObject(1);
     
      while(rs.next()) 
      {
        contraPolicies quotTax=new contraPolicies();
        quotTax.setPOL_POLICY_NO(rs.getString(1));
        quotTax.setClient(rs.getString(2));
        quotTax.setPOL_INCEPTION_UWYR(rs.getBigDecimal(3));
        quotTax.setPOL_STATUS(rs.getString(4));
        quotTax.setPOL_CODE(rs.getBigDecimal(5));
        quotTax.setPOL_EFFECTIVE_DATE(rs.getDate(6));
        quotTax.setPOL_CALC_TYPE(rs.getString(7));
        quotTax.setPOL_CURRENT_ENDR_CODE(rs.getBigDecimal(8));
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
