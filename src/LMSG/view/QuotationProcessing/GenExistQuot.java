package LMSG.view.QuotationProcessing;

import java.math.BigDecimal;

import java.util.List;

import java.sql.*;

import java.util.ArrayList;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.jdbc.internal.OracleTypes;


import LMSG.view.Base.LOVCC;

import LMSG.view.connect.DBConnector;

public class GenExistQuot extends LOVCC {
  public static String pmas_sht_desc;
  private RichSelectOneChoice quotationCalcType;

  public GenExistQuot() {
  }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  public List<ExistingQuot> findQuotation() {
     DBConnector myConn=new DBConnector();
    Connection conn=myConn.getDatabaseConn();
    CallableStatement cst=null;
    CallableStatement cst1=null;
    List<ExistingQuot> existQuotation=new ArrayList<ExistingQuot>();
    try {
      String QuotQuery="begin LMS_WEB_CURSOR_GRP.get_quotations(?,?,?,?);end;";
   
      cst=conn.prepareCall(QuotQuery);
      cst.registerOutParameter(1,OracleTypes.CURSOR);
      cst.setString(2,(String)session.getAttribute("transType"));
      cst.setInt(3, 0);//Quotation.prodCode);
      cst.setBigDecimal(4,(BigDecimal)session.getAttribute("QuoteCode"));
      System.out.println((BigDecimal)session.getAttribute("QuoteCode"));
      cst.execute();
      
      /*cst1=conn.prepareCall(pmasQuery);
      cst1.setInt(1,Quotation.quotationCode);
      cst1.registerOutParameter(2,OracleTypes.VARCHAR);*/
      ResultSet rs=(ResultSet)cst.getObject(1);
//      String rs1=cst1.getString(1);
      
      while (rs.next()) {
        ExistingQuot existQout=new ExistingQuot();
         existQout.setClient(rs.getString(1));
        existQout.setAgnname(rs.getString(6));
        existQout.setQuoNumber(rs.getString(3));
        //System.out.println(rs.getString(3));
        existQout.setBranchName(rs.getString(8));
       existQout.setQuoDate(rs.getDate(7));
        existQout.setQuoNumber(rs.getString(3));
        existQout.setTotPremium(rs.getDouble(9));
        existQout.setTotSumAssured(rs.getDouble(10));
        existQout.setProdShtdesc(rs.getString(11));
        existQout.setProposer(rs.getString(1));
        existQout.setPmascode(rs.getString(12));
        //existQout.setDurationType(rs.getString(14));
        existQout.setQuoEffectDate(rs.getDate(13));
        existQout.setQuoAvganb(rs.getInt(16));
        existQout.setDepCovered(rs.getString(18));
        existQout.setQuoSavingsRider(rs.getString(19));
                ExistingQuot.savingsRider.setValue(rs.getString(19));
                ExistingQuot.calcType.setValue(rs.getString(15));
                ExistingQuot.quotType.setValue(rs.getString(20));
                ExistingQuot.quotDurationType.setValue(rs.getString(14));
                ExistingQuot.freqOfPayment.setValue(rs.getString(21));
                ExistingQuot.quoGrpLifeRider.setValue(rs.getString(24));
        existQout.setQuoFclAmt(rs.getDouble(22));
        existQout.setQuoCoverTo(rs.getDate(23));
        existQout.setQuoOverrideFcl(rs.getDouble(25));
      //existQout.set(rs.getString(15));
           
        
        existQout.setQuoStatus(rs.getString(17));
        
        existQuotation.add(existQout);
      }
      
        
        //existQuotation.add(existQout);
      
      rs.close();
      cst.close();
        conn.close();    
      
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    return existQuotation;
  }

  public void setQuotationCalcType(RichSelectOneChoice quotationCalcType) {
    this.quotationCalcType = quotationCalcType;
  }

  public RichSelectOneChoice getQuotationCalcType() {
    return quotationCalcType;
  }
}
