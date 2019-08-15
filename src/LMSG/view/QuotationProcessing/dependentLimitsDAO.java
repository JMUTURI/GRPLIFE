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

public class dependentLimitsDAO {
  public dependentLimitsDAO() {
  }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  Connection conn=null;
  CallableStatement cstmt=null;
  public List<dependentLimits> FindDependentsLimits() 
  {
    List<dependentLimits> dpdLimitList=new ArrayList<dependentLimits>();
    String dpdLimitQuery="BEGIN LMS_WEB_CURSOR_GRP.getQuotDpdLimits(?,?);END;";
    conn=new DBConnector().getDatabaseConn();
    try 
    {
      cstmt=conn.prepareCall(dpdLimitQuery);
      cstmt.registerOutParameter(1,OracleTypes.CURSOR);
      cstmt.setBigDecimal(2,(BigDecimal)session.getAttribute("QuoteCode"));
      cstmt.execute();
      ResultSet rs=(ResultSet)cstmt.getObject(1);
      while(rs.next()) 
      {
        dependentLimits quotLimits=new dependentLimits();
        quotLimits.setQDL_CODE(rs.getBigDecimal(1));
        //System.out.println("Haiyah"+QuotDAO.qcvtCode);
        quotLimits.setDTY_DESCRIPTION(rs.getString(3));
        quotLimits.setQDL_MAX_TYPE_ALLOWED(rs.getBigDecimal(4));
        quotLimits.setQDL_LIMIT_AMT(rs.getBigDecimal(5));
        quotLimits.setCVT_CODE(rs.getBigDecimal(11));  
        dpdLimitList.add(quotLimits);
      }
        conn.close();   
    }
    catch(Exception ex) 
    {
      ex.printStackTrace();
    }
    return dpdLimitList;
  }
}
