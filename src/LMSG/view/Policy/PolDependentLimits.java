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

import LMSG.view.Base.GlobalCC;

import LMSG.view.Base.LOVCC;

import LMSG.view.QuotationProcessing.dependentLimits;

import LMSG.view.connect.DBConnector;

import LMSG.view.connect.DBConnector;

public class PolDependentLimits extends LOVCC {
  public PolDependentLimits() {
  }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  //Connection conn=null;
  //CallableStatement cstmt=null;
  public List<dependentLimits> FindDependentsLimits() 
  {
    List<dependentLimits> dpdLimitList=new ArrayList<dependentLimits>();
    String dpdLimitQuery="BEGIN LMS_WEB_CURSOR_GRP.getQuotDpdLimits(?,?,?,?);END;";
    String RenewalArea = (String)session.getAttribute("RenewalArea");
     if(RenewalArea==null){
       dpdLimitQuery="BEGIN LMS_WEB_CURSOR_GRP.getQuotDpdLimits(?,?,?,?);END;";
     }else if(RenewalArea.equalsIgnoreCase("Y")){
       dpdLimitQuery="BEGIN LMS_WEB_CURSOR_GRP.get_renquotdpdlimits(?,?,?,?);END;";
     }else{
       dpdLimitQuery="BEGIN LMS_WEB_CURSOR_GRP.getQuotDpdLimits(?,?,?,?);END;";
     }
      DBConnector myConn=new DBConnector();
      Connection conn=myConn.getDatabaseConn();
      CallableStatement cstmt=null;
    try 
    {
      cstmt=conn.prepareCall(dpdLimitQuery);
      cstmt.registerOutParameter(1,OracleTypes.CURSOR);
      cstmt.setBigDecimal(2,null);
      cstmt.setBigDecimal(3,(BigDecimal)session.getAttribute("endorsementCode"));
      cstmt.setBigDecimal(4,(BigDecimal)session.getAttribute("pcaCode"));
      cstmt.execute();
      ResultSet rs=(ResultSet)cstmt.getObject(1);
      while(rs.next()) 
      {
        dependentLimits quotLimits=new dependentLimits();
        quotLimits.setQDL_CODE(rs.getBigDecimal(1));
        quotLimits.setDTY_DESCRIPTION(rs.getString(3));
        quotLimits.setQDL_MAX_TYPE_ALLOWED(rs.getBigDecimal(4));
        quotLimits.setQDL_LIMIT_AMT(rs.getBigDecimal(5));
        quotLimits.setPCA_CATEG_DESC(rs.getString(7));
        quotLimits.setCvt_desc(rs.getString(6));
        quotLimits.setQDL_DTY_CODE(rs.getBigDecimal(8));
        quotLimits.setQDL_PCVT_CODE(rs.getBigDecimal(9));
        quotLimits.setQDL_MIN_AMT(rs.getBigDecimal(10));
        quotLimits.setCVT_CODE(rs.getBigDecimal(11));
        dpdLimitList.add(quotLimits);
      }
        conn.close();    
    }
    catch(Exception ex) 
    {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
    }
    return dpdLimitList;
  }
}
