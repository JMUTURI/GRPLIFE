package LMSG.view.Policy;


import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.jdbc.OracleTypes;

import LMSG.view.Base.GlobalCC;
import LMSG.view.Base.LOVCC;

import LMSG.view.QuotationProcessing.QuotDAO;

import LMSG.view.connect.DBConnector;

import LMSG.view.connect.DBConnector;

public class policyCoverTypesDAO extends LOVCC {
  public policyCoverTypesDAO() {
  }
  private BigDecimal productCoverType;
  private BigDecimal CoverTypeCode;
  
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  public List<policyCoverTypes> FindCoverTypes() {
      DBConnector myConn=new DBConnector();
     Connection conn=myConn.getDatabaseConn();
     CallableStatement cst=null;
     List<policyCoverTypes> CoverTypesList = new ArrayList<policyCoverTypes>();
     
     try {
       String CoverTypesQuery="begin LMS_WEB_CURSOR_GRP.FindPolicyCoverTypes(?,?);end;";
       String RenewalArea = (String)session.getAttribute("RenewalArea");
        if(RenewalArea==null){
           CoverTypesQuery="begin LMS_WEB_CURSOR_GRP.FindPolicyCoverTypes(?,?);end;";
        }else if(RenewalArea.equalsIgnoreCase("Y")){
           CoverTypesQuery="begin LMS_WEB_CURSOR_GRP.find_renpolicycovertypes(?,?);end;";
        }else{
           CoverTypesQuery="begin LMS_WEB_CURSOR_GRP.FindPolicyCoverTypes(?,?);end;"; 
        }
       
       cst=conn.prepareCall(CoverTypesQuery);
       cst.registerOutParameter(1,OracleTypes.CURSOR);
       cst.setBigDecimal(2,(BigDecimal)session.getAttribute("endorsementCode"));
       cst.execute();
       ResultSet rst=(ResultSet)cst.getObject(1);
       session.setAttribute("coversAvail", "N");
       while(rst.next()){
         policyCoverTypes myProd=new policyCoverTypes();
         myProd.setPCVT_CVT_SHT_DESC(rst.getString(1));
         myProd.setPCVT_SA(rst.getBigDecimal(2));
         myProd.setPCVT_PREMIUM(rst.getBigDecimal(3));
         myProd.setPCVT_BUT_CHARGE_PREMIUM(rst.getBigDecimal(4));
         //System.out.println("BUT CHARGE:" + rst.getBigDecimal(4));
         myProd.setCVT_DEPEND_DISP(rst.getString(5));
         myProd.setPCVT_TOT_MEMBERS(rst.getBigDecimal(6));
         myProd.setPCVT_LOAD_DISC(rst.getString(7));
         myProd.setPCVT_DISC_LOAD_RATE(rst.getBigDecimal(8));
         myProd.setPCVT_DISC_LOAD_DIV_FACT(rst.getBigDecimal(9));
         //myProd.setPCVT_BUT_CHARGE_PREMIUM(rst.getBigDecimal(10));
         myProd.setPCVT_SA_PER_MEMBER(rst.getBigDecimal(11));
         myProd.setPCVT_UNIT_RATE(rst.getBigDecimal(13));
         myProd.setPCVT_USE_UNIT_RATE(rst.getString(12));
         myProd.setPCVT_CODE(rst.getBigDecimal(14));
         myProd.setPCVT_MAIN_RIDER(rst.getString(15));
         myProd.setPCVT_CVT_CODE(rst.getBigDecimal(16));
         myProd.setPCVT_AVG_ANB(rst.getString(17));
         myProd.setPCVT_MAIN_SA_PERC(rst.getBigDecimal(20));
         myProd.setPCVT_MAIN_COVER(rst.getString(21));
         myProd.setMAIN_COVER_DESC(rst.getString(22));
         myProd.setPCVT_PCT_CODE(rst.getBigDecimal(23));
         if(rst.getString(15) == null){
               
         }else if(rst.getString(15).equalsIgnoreCase("M")){
               session.setAttribute("coversAvail", "Y");
         }else{
               //do nothing...
         }
         myProd.setPCVT_LOANAMT_PER_MEM(rst.getBigDecimal(24));
         myProd.setPCVT_LOAN_RPYMT_PRD(rst.getBigDecimal(25));
         myProd.setPCVT_LOANINT_PER_MEM(rst.getBigDecimal(26));
         myProd.setPCVT_SAVINGS_PER_MEM(rst.getBigDecimal(27));
         myProd.setPCVT_DISC(rst.getString(28));
         myProd.setPCVT_DISC_RATE(rst.getBigDecimal(29));
         myProd.setPCVT_DISC_DIV_FACT(rst.getBigDecimal(30));
         myProd.setPcvt_pmas_code(rst.getBigDecimal(31));
         myProd.setPcvt_pmas_sht_desc(rst.getString(32));
         myProd.setPcvt_rate(rst.getBigDecimal(33));
         myProd.setPcvt_rate_div_fact(rst.getBigDecimal(34));
         myProd.setPcvt_use_cvr_rate(rst.getString(35));
         if(rst.getString(35)==null){
           myProd.setCVR_RATE_DESC("Use Policy Structure");
         }else if(rst.getString(35).equalsIgnoreCase("M")){
           myProd.setCVR_RATE_DESC("Use Policy Structure");
         }else if(rst.getString(35).equalsIgnoreCase("S")){
           myProd.setCVR_RATE_DESC("Select Specific Mask");
         }else if(rst.getString(35).equalsIgnoreCase("C")){
           myProd.setCVR_RATE_DESC("Input Rate");
         }
         myProd.setPcvt_load_age_fact(rst.getBigDecimal(36));
         myProd.setPcvtPctInbuilt(rst.getString(37));   
         myProd.setPcvtAccelerator(rst.getString(38));  
         CoverTypesList.add(myProd);
        
       }
       rst.close();
       cst.close();
         conn.close();    
       
     }
     catch(Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
     }
     return CoverTypesList;
   }
  public List<ProdCovers> FindProductCovers() {
      DBConnector myConn=new DBConnector();
     Connection conn=myConn.getDatabaseConn();
     CallableStatement cst=null;
     List<ProdCovers> CoverTypesList=new ArrayList<ProdCovers> ();
     
     try {
       String CoverTypesQuery="begin LMS_WEB_CURSOR_GRP.FindProductCovers(?,?,?,?);end;";
       cst=conn.prepareCall(CoverTypesQuery);
       cst.registerOutParameter(1,OracleTypes.CURSOR);
       cst.setBigDecimal(2,(BigDecimal)session.getAttribute("ProductCode"));
       cst.setBigDecimal(3,(BigDecimal)session.getAttribute("policyCode"));
       cst.setString(4,(String)session.getAttribute("allCovers"));
       cst.execute();
       ResultSet rst=(ResultSet)cst.getObject(1);
       while(rst.next()){
         ProdCovers myProd=new ProdCovers();
         myProd.setCvt_code(rst.getBigDecimal(1));
         myProd.setCvt_sht_desc(rst.getString(2));
         myProd.setCvt_desc(rst.getString(3));
         myProd.setCvt_main_cover(rst.getString(4));
         myProd.setPct_formular(rst.getString(5));
         myProd.setPct_code(rst.getBigDecimal(6));
         myProd.setPct_refund_formular(rst.getString(7));
         myProd.setPct_refund_formular(rst.getString(8));
         myProd.setPct_main_sa_perc(rst.getBigDecimal(9)); 
         myProd.setPctInbuilt(rst.getString(10)); 
         myProd.setPctAccelerator(rst.getString(11));
         CoverTypesList.add(myProd);
        
       }
       rst.close();
       cst.close();
         conn.close();    
       
     }
     catch(Exception e) {
       GlobalCC.EXCEPTIONREPORTING(conn, e);
     }
     return CoverTypesList;
   }

    public void setProductCoverType(BigDecimal productCoverType) {
        this.productCoverType = productCoverType;
    }

    public BigDecimal getProductCoverType() {
        return (BigDecimal)session.getAttribute("PCT_CODE");
      
    }

    public void setCoverTypeCode(BigDecimal CoverTypeCode) {
        this.CoverTypeCode = CoverTypeCode;
    }

    public BigDecimal getCoverTypeCode() {
        return (BigDecimal)session.getAttribute("pcvtCode");
    }
}
