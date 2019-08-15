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

public class memCoverTypesDAO {
  public memCoverTypesDAO() {
  }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  public List<memCoverTypes> findMemberCoverTypes() {
     DBConnector myConn=new DBConnector();
    Connection conn=myConn.getDatabaseConn();
    CallableStatement cst=null;
   
    List<memCoverTypes> MemberCoverTypes=new ArrayList<memCoverTypes>();
    try {
      String DpdQuery="begin LMS_WEB_CURSOR_GRP.memCoverTypes(?,?,?);end;";
   
      cst=conn.prepareCall(DpdQuery);
      cst.registerOutParameter(1,OracleTypes.CURSOR);
     cst.setBigDecimal(2,(BigDecimal)session.getAttribute("QuoteCode"));
     cst.setBigDecimal(3,(BigDecimal)session.getAttribute("MemberNumber"));
     System.out.println((BigDecimal)session.getAttribute("QuoteCode"));
     System.out.println(session.getAttribute("MemberNumber"));
    
      cst.execute();

      ResultSet rs=(ResultSet)cst.getObject(1);   
      while (rs.next()) {
        memCoverTypes existQout=new memCoverTypes();
         existQout.setCover_display(rs.getString(1));
        existQout.setQCM_COVER_WEF_DATE(rs.getDate(2));
        existQout.setQCM_COVER_WET_DATE(rs.getDate(3));
        existQout.setQCM_SA(rs.getBigDecimal(4));
        existQout.setQCM_LOAD_DISC_PREM(rs.getBigDecimal(5));
        existQout.setQCM_PREMIUM(rs.getBigDecimal(6));
        existQout.setQCM_ORIGINAL_LOAN_AMT(rs.getBigDecimal(7));
        existQout.setQCM_ORIG_LOAN_REPAYMENT_PRD(rs.getBigDecimal(8));
        existQout.setQCM_SAVING_AMT(rs.getBigDecimal(9));
        existQout.setQCM_LOAN_ISSUE_DATE(rs.getDate(10));     
        MemberCoverTypes.add(existQout);
      }
   
      rs.close();
      cst.close();
        conn.close();   
     
      
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    return MemberCoverTypes;
  }
}
