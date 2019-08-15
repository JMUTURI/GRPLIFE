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

public class prodProvisionsDAO 
{
  public prodProvisionsDAO() {
  }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  Connection conn=null;
  CallableStatement cstmt=null;
  public List<prodProvisions> FindProvision() 
  {
    List<prodProvisions> pList=new ArrayList<prodProvisions>();
    String provQuery="BEGIN LMS_WEB_CURSOR_GRP.getProvisions(?,?);END;";
    conn=new DBConnector().getDatabaseConn();
    try 
    {
      cstmt=conn.prepareCall(provQuery);
      cstmt.registerOutParameter(1,OracleTypes.CURSOR);
      cstmt.setBigDecimal(2,(BigDecimal)session.getAttribute("ProductCode"));
      cstmt.execute();
      ResultSet rs=(ResultSet)cstmt.getObject(1);
      while(rs.next()) 
      {
       prodProvisions prov=new prodProvisions();
        prov.setPPROV_CODE(rs.getBigDecimal(1));
        prov.setPROV_SHT_DESC(rs.getString(2));
        prov.setPROV_DESC(rs.getString(3));
        prov.setPPROV_PROD_CODE(rs.getBigDecimal(4));
        prov.setPPROV_EDITABLE(rs.getString(5));
        pList.add(prov);
      }
        conn.close();   
    }
    catch(Exception ex) 
    {
      ex.printStackTrace();
    }
    return pList;
  }
}
