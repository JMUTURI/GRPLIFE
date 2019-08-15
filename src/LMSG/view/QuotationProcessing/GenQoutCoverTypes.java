package LMSG.view.QuotationProcessing;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.jdbc.internal.OracleTypes;


import LMSG.view.Base.LOVCC;

import LMSG.view.Policy.ProdCovers;

import LMSG.view.connect.DBConnector;

public class GenQoutCoverTypes extends LOVCC {
  public GenQoutCoverTypes() {
  }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
   DBConnector myConn=new DBConnector();
  Connection conn=myConn.getDatabaseConn();
  CallableStatement cst=null;
  public List<quotCoverTypes> findCoverTypes() {
    List<quotCoverTypes> CoverTypesList=new ArrayList<quotCoverTypes>();
    
    try {
      String coverTypesQuery="begin LMS_WEB_CURSOR_GRP.quotationCoverTypes(?,?,?);end;";
      cst=conn.prepareCall(coverTypesQuery);
      cst.registerOutParameter(1,OracleTypes.CURSOR);
      cst.setBigDecimal(2,(BigDecimal)session.getAttribute("QuoteCode"));
      cst.setBigDecimal(3,(BigDecimal)session.getAttribute("qcvtCode"));
      
      System.out.println((BigDecimal)session.getAttribute("QuoteCode"));
      cst.execute();
      ResultSet rs=(ResultSet)cst.getObject(1);
      while (rs.next()) 
      {
        System.out.println("Table values In");
        quotCoverTypes coverType=new quotCoverTypes();
           coverType.setQuocvtShtDesc(rs.getString(1)); 
           coverType.setQuoQcvtSa(rs.getDouble(2)); 
          coverType.setQuoButChargePrem(rs.getDouble(3)); 
          coverType.setQuoButChargePrem2(rs.getString(4));
          coverType.setQCVT_PREMIUM(rs.getDouble("QCVT_PREMIUM"));
          coverType.setQCVT_LOAD_DISC(rs.getString("QCVT_LOAD_DISC"));
          coverType.setQCVT_DISC_LOAD_DIV_FACT(rs.getInt("QCVT_DISC_LOAD_DIV_FACT"));
          coverType.setQCVT_CODE(rs.getBigDecimal(16));
          coverType.setCover_display(rs.getString("COVER_DISPLAY"));
          //private String quoDependents;
          coverType.setQuoMembers(rs.getInt(5)); 
          coverType.setDiscLoadRate(rs.getBigDecimal(7)); 
          coverType.setQuoQcvtRate(rs.getDouble(8)); 
          coverType.setQuoAvganb(rs.getDouble(9)); 
          coverType.setQuoQCVTwetDate(rs.getDate(10)); 
          coverType.setQuoQcvtAvgprd(rs.getInt(11)); 
          coverType.setQuoSaPerMember(rs.getDouble(12));
          coverType.setQuoUnitRate(rs.getDouble(14)); 
          coverType.setQCVT_CVT_CODE(rs.getBigDecimal("QCVT_CVT_CODE"));
        coverType.setQuoUseUnitRate(rs.getString(13));
        
        //LOVCC.qcvtCode = rs.getBigDecimal("QCVT_CODE");
        session.setAttribute("qcvtCode", rs.getBigDecimal("QCVT_CODE"));

     
        CoverTypesList.add(coverType);
      }
        conn.close();    
    }
    catch(Exception e) {
        e.printStackTrace();
      }
    
  return CoverTypesList;
}
  public List<ProdCovers> findProductCovers() {
    List<ProdCovers> CoverTypesList=new ArrayList<ProdCovers>();
    
    try {
      String coverTypesQuery="begin LMS_WEB_CURSOR_GRP.FindQuotationProductCovers(?,?,?);end;";
      cst=conn.prepareCall(coverTypesQuery);
      cst.registerOutParameter(1,OracleTypes.CURSOR);
      cst.setBigDecimal(2,(BigDecimal)session.getAttribute("ProductCode"));
      cst.setBigDecimal(3,(BigDecimal)session.getAttribute("QuoteCode"));
      cst.execute();
      ResultSet rs=(ResultSet)cst.getObject(1);
      while (rs.next()) 
      {
       ProdCovers coverType=new ProdCovers();
           coverType.setCvt_code(rs.getBigDecimal(1)); 
           coverType.setCvt_sht_desc(rs.getString(2)); 
            coverType.setCvt_desc(rs.getString(3));
          coverType.setCvt_main_cover(rs.getString(4)); 
          coverType.setPct_formular(rs.getString(5));
          coverType.setPct_code(rs.getBigDecimal(6));
          coverType.setPct_refund_formular(rs.getString(7));
          coverType.setCvt_duration_type(rs.getString(8));
         
          CoverTypesList.add(coverType);
      }
        conn.close();    
    }
    catch(Exception e) {
        e.printStackTrace();
      }
    
  return CoverTypesList;
  }
}
