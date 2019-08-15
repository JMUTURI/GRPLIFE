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

public class memPensionDAO extends LOVCC {
  public memPensionDAO() {
  }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  public List<memPension> findMemberPensionDtls() {
     DBConnector myConn=new DBConnector();
    Connection conn=myConn.getDatabaseConn();
    CallableStatement cst=null;
   
    List<memPension> MemberPensions=new ArrayList<memPension>();
    try {
      String DpdQuery="begin LMS_WEB_CURSOR_GRP.memPensionDtls(?,?,?);end;";
   
       cst=conn.prepareCall(DpdQuery);
       cst.registerOutParameter(1,OracleTypes.CURSOR);
       cst.setBigDecimal(2,(BigDecimal)session.getAttribute("QuoteCode"));
       cst.setBigDecimal(3, (BigDecimal)session.getAttribute("MemberNumber"));
    
      cst.execute();
      
      /*cst1=conn.prepareCall(pmasQuery);
      cst1.setInt(1,Quotation.quotationCode);
      cst1.registerOutParameter(2,OracleTypes.VARCHAR);*/
      ResultSet rs=(ResultSet)cst.getObject(1);
  //      String rs1=cst1.getString(1);
      
      while (rs.next()) {
        memPension existQout=new memPension();
         existQout.setQMPNS_WEF_DATE(rs.getDate(1));
        existQout.setQMPNS_WET_DATE(rs.getDate(2));
        existQout.setQMPNS_EARNINGS(rs.getBigDecimal(3));
        existQout.setQMPNS_EMPLOYER_CONTR(rs.getBigDecimal(4));
        System.out.println("Empr Contri" + rs.getBigDecimal(4));
        existQout.setQMPNS_EMPLOYEE_CONTR(rs.getBigDecimal(5));
        existQout.setQMPNS_EMPLYE_VOLU_CONTR(rs.getBigDecimal(6));
        existQout.setQMPNS_TOTAL_CONTR(rs.getBigDecimal(7));
        existQout.setQMPNS_ADMIN_FEE_RATE(rs.getBigDecimal(8));
        existQout.setQMPNS_NET_ANNUAL_FUND(rs.getBigDecimal(9));
        existQout.setQMPNS_COMP_INT_RATE(rs.getBigDecimal(10));
        existQout.setQMPNS_ANNTY_FAC_RATE(rs.getBigDecimal(11));
        existQout.setQMPNS_PENS_ANNUM(rs.getBigDecimal(12));
        existQout.setQMPNS_EST_MAT_VAL(rs.getBigDecimal(13));
        existQout.setQMPNS_ER_EST_EMV_VAL(rs.getBigDecimal(14));
        existQout.setQMPNS_EE_EST_MAT_VAL(rs.getBigDecimal(15));
        existQout.setQMPNS_FUTURE_LIABILITY(rs.getBigDecimal(18));
          System.out.println(rs.getBigDecimal(18));
        existQout.setQMPNS_PAST_LIABILITY(rs.getBigDecimal(17));
          System.out.println(rs.getBigDecimal(17));
        existQout.setQMPNS_TOTAL_LIABILITY(rs.getBigDecimal(16));
          System.out.println(rs.getBigDecimal(16));
        existQout.setQMPNS_ANNUITY_AMOUNT(rs.getBigDecimal(19));
        existQout.setQMPNS_EMPLYE_PENS_BF(rs.getBigDecimal(20));
        existQout.setQMPNS_EMPLYR_PENS_BF(rs.getBigDecimal(21));
        existQout.setQMPNS_TOT_PENS_BF(rs.getBigDecimal(22));
        existQout.setQMPNS_ANN_PURCHASE_PRICE(rs.getBigDecimal(23));
        existQout.setQMPNS_EMPLYR_REG_BAL_BF(rs.getBigDecimal(24));
        existQout.setQMPNS_EMPLYR_UNREG_BAL_BF(rs.getBigDecimal(25));
        existQout.setQMPNS_EMPLYE_REG_BAL_BF(rs.getBigDecimal(26));
        existQout.setQMPNS_EMPLYE_UNREG_BAL_BF(rs.getBigDecimal(27));
        existQout.setQMPNS_EMPLYR_REG_CONTRI_AMT(rs.getBigDecimal(28));
        existQout.setQMPNS_EMPLYR_UNREG_CONTRI_AMT(rs.getBigDecimal(29));
        existQout.setQMPNS_EMPLYE_REG_CONTRI_AMT(rs.getBigDecimal(30));
        existQout.setQMPNS_EMPLYE_UNREG_CONTRI_AMT(rs.getBigDecimal(31));
        existQout.setQMPNS_EMPLYR_LUMPSUM(rs.getBigDecimal(32));
        existQout.setQMPNS_ER_HIST_EST_EMV_VAL(rs.getBigDecimal(33));
        existQout.setQMPNS_EE_HIST_EST_EMV_VAL(rs.getBigDecimal(34));
        
       MemberPensions.add(existQout);
      }
       //existQuotation.add(existQout);
      
      rs.close();
      cst.close();
        conn.close();   
     
      
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    return MemberPensions;
  }
}
