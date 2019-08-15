package LMSG.view.QuotationProcessing;

import java.math.BigDecimal;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.jdbc.internal.OracleTypes;

import LMSG.view.connect.DBConnector;
public class GenQuotProvisions {
  public GenQuotProvisions() {
  }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  Connection conn=null;
  CallableStatement cstmt=null;
  public List<quotationProvision> FindProvision() 
  {
    List<quotationProvision> ProvList=new ArrayList<quotationProvision>();
    String provQuery="BEGIN LMS_WEB_CURSOR_GRP.getProdProvisions(?,?);END;";
    conn=new DBConnector().getDatabaseConn();
    try 
    {
      cstmt=conn.prepareCall(provQuery);
      cstmt.registerOutParameter(1,OracleTypes.CURSOR);
      cstmt.setBigDecimal(2,(BigDecimal)session.getAttribute("QuoteCode"));
      cstmt.execute();
      ResultSet rs=(ResultSet)cstmt.getObject(1);
      while(rs.next()) 
      {
        quotationProvision prov=new quotationProvision();
        prov.setQpprCode(rs.getBigDecimal(1));
        prov.setQuotProvshtDesc(rs.getString(2));
        prov.setQuotProvDesc(rs.getString(3));
        prov.setQuotProvEditable(rs.getString(4));
        ProvList.add(prov);
      }
        conn.close();    
    }
    catch(Exception ex) 
    {
      ex.printStackTrace();
    }
    return ProvList;
  }
}
