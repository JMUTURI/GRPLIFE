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

public class quotPremMaskDAO {
  public quotPremMaskDAO() {
  }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  Connection conn=null;
  CallableStatement cstmt=null;
  public List<quotPremMask> findPremiumMask() 
  {
    conn=new DBConnector().getDatabaseConn();
    List<quotPremMask> MaskList=new ArrayList<quotPremMask>();
    String MaskQuery="BEGIN LMS_WEB_CURSOR_GRP.get_quot_prem_mask(?,?);END;";
    try 
    {
      cstmt=conn.prepareCall(MaskQuery);
      cstmt.registerOutParameter(1,OracleTypes.CURSOR);
      cstmt.setBigDecimal(2,(BigDecimal)session.getAttribute("ProductCode"));
      cstmt.execute();
      ResultSet rs=(ResultSet)cstmt.getObject(1);
      while(rs.next()) 
      {
        quotPremMask prop=new quotPremMask();
        prop.setPMAS_SHT_DESC(rs.getString(2));
        prop.setPMAS_CODE(rs.getBigDecimal(1));
        prop.setPMAS_DESC(rs.getString(3));
       MaskList.add(prop);
      }
        conn.close();   
    }
    catch(Exception ex) 
    {
      ex.printStackTrace();
    }
    return MaskList;
  }
}
