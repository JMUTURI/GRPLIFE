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

import LMSG.view.QuotationProcessing.productProvisions;

import LMSG.view.connect.DBConnector;

public class coverProvisionsDAO extends LOVCC {
  public coverProvisionsDAO() {
  }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  Connection conn=null;
  CallableStatement cstmt=null;
  public List<productProvisions> FindProdProvision() 
  {
    List<productProvisions> ProdProvList=new ArrayList<productProvisions>();
    String prodprovQuery="BEGIN LMS_WEB_CURSOR_GRP.get_prov_cover(?,?,?);END;";
    conn=new DBConnector().getDatabaseConn();
    try 
    {
      cstmt=conn.prepareCall(prodprovQuery);
      cstmt.registerOutParameter(1,OracleTypes.CURSOR);
      cstmt.setBigDecimal(2,(BigDecimal)session.getAttribute("ProductCode"));
      cstmt.setBigDecimal(3,(BigDecimal)session.getAttribute("pcvtCode"));
      cstmt.execute();
      ResultSet rs=(ResultSet)cstmt.getObject(1);
      while(rs.next()) 
      {
        productProvisions prov=new productProvisions();
        prov.setPPROV_CODE(rs.getBigDecimal(1));
        prov.setPROV_SHT_DESC(rs.getString(2));
        prov.setPROV_DESC(rs.getString(3));
        prov.setPPROV_EDITABLE(rs.getString(4));
        ProdProvList.add(prov);
      }
        conn.close();
    }
    catch(Exception ex) 
    {
      ex.printStackTrace();
    }
    return ProdProvList;
  }
}
