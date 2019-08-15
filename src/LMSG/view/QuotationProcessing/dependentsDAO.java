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

import LMSG.view.Base.GlobalCC;

import LMSG.view.Base.LOVCC;

import LMSG.view.connect.DBConnector;

public class dependentsDAO extends LOVCC {
  public dependentsDAO() {
  }
  private BigDecimal dependantCode;
  
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  public List<dependents> FindDependents() 
  {
      DBConnector myConn=new DBConnector();
      Connection conn=myConn.getDatabaseConn();
      CallableStatement cstmt=null;
   
    String dpdQuery="BEGIN LMS_WEB_CURSOR_GRP.get_quot_cover_dependents(?,?,?);END;";
      List<dependents> dpdList=new ArrayList<dependents>();
    try 
    {
    
      cstmt=conn.prepareCall(dpdQuery);
      cstmt.registerOutParameter(1,OracleTypes.CURSOR);
      cstmt.setBigDecimal(2,(BigDecimal)session.getAttribute("qcvtcvtCode"));
      cstmt.setBigDecimal(3,(BigDecimal)session.getAttribute("ProductCode"));
      cstmt.execute();
      ResultSet rs=(ResultSet)cstmt.getObject(1);
      while(rs.next()) 
      {
        dependents quotDependents=new dependents();
        quotDependents.setDTY_CODE(rs.getBigDecimal(1));
        quotDependents.setDTY_SHT_DESC(rs.getString(2));
        quotDependents.setDTY_DESCRIPTION(rs.getString(3));
        quotDependents.setPCD_MAX_NO_ALLOWED(rs.getBigDecimal(4));
        quotDependents.setPCD_MAX_SUM_ASSURED(rs.getBigDecimal(5));
        quotDependents.setPCD_MIN_SUM_ASSURED(rs.getBigDecimal(6));
        quotDependents.setPCD_CVT_CODE(rs.getBigDecimal(7));  
        dpdList.add(quotDependents);
      }
        conn.close();   
    }
    catch(Exception ex) 
    {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
    }
    return dpdList;
  }

    public void setDependantCode(BigDecimal dependantCode) {
        this.dependantCode = dependantCode;
    }

    public BigDecimal getDependantCode() {
        return dependantCode;
    }
}
