package LMSG.view.GroupProducts;

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

import LMSG.view.connect.DBConnector;


/**
 * LMS Products Class
 * Gets All Products available for Group Life
 * @author Jim Gitau
 */

public class ProductsDAO {
    public ProductsDAO() {
        super();
    }
    
  private BigDecimal productCoverType;
  private BigDecimal CoverTypeCode;
  private BigDecimal cloneProductCode;
  
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    
    public List<productDetails> findProducts() {
       DBConnector myConn=new DBConnector();
       Connection conn=myConn.getDatabaseConn();
       CallableStatement cst=null;
       List<productDetails> prods=new ArrayList<productDetails>();
       ResultSet rst=null;
       
       try {
         String productsQuery="begin LMS_WEB_CURSOR_GRP.get_products(?);end;";
         cst=conn.prepareCall(productsQuery);
         cst.registerOutParameter(1,OracleTypes.CURSOR);
         cst.execute();
         rst=(ResultSet)cst.getObject(1);
         while(rst.next()){
             
           productDetails myProducts = new productDetails();
           myProducts.setProdCode(rst.getBigDecimal(1));
           myProducts.setProdshtDesc(rst.getString(2));
           myProducts.setProdDesc(rst.getString(3));
           myProducts.setProdType(rst.getString(4));
           myProducts.setProd_lapse_prd_days(rst.getBigDecimal(5));
           myProducts.setPROD_MIN_EARNINGS_PRD(rst.getBigDecimal(6));
           myProducts.setPROD_DEPENDT_COVERED(rst.getString(7));
           myProducts.setPROD_SAVINGS_COVERED(rst.getString(8));
           myProducts.setPMAS_CODE(rst.getBigDecimal(9));
           myProducts.setPMAS_SHT_DESC(rst.getString(10));
           myProducts.setPMAS_DESC(rst.getString(11));
           myProducts.setPROD_DEPENDT_COVERED2(rst.getString(12));
           myProducts.setPROD_EARNING_PRD_TYPE(rst.getString(13));  
           prods.add(myProducts);   
             
         }
         rst.close();
         cst.close();
        conn.close();          
       }
       catch(Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
       }finally{
        GlobalCC.CloseConnections(rst, cst, conn);
      }
       return prods;
     }
    
  public List<productDetails> findProductsSetUp() {
     DBConnector myConn=new DBConnector();
     Connection conn=myConn.getDatabaseConn();
     CallableStatement cst=null;
     List<productDetails> prods=new ArrayList<productDetails>();
     ResultSet rst=null;
     
     try {
       String productsQuery="begin LMS_WEB_CURSOR_GRP.get_products_setup(?);end;";
       cst=conn.prepareCall(productsQuery);
       cst.registerOutParameter(1,OracleTypes.CURSOR);
       cst.execute();
       rst=(ResultSet)cst.getObject(1);
       while(rst.next()){
           
         productDetails myProducts = new productDetails();
         myProducts.setProdCode(rst.getBigDecimal(1));
         myProducts.setProdshtDesc(rst.getString(2));
         myProducts.setProdDesc(rst.getString(3));
         myProducts.setProdType(rst.getString(4));
         myProducts.setProd_lapse_prd_days(rst.getBigDecimal(5));
         myProducts.setPROD_MIN_EARNINGS_PRD(rst.getBigDecimal(6));
         myProducts.setPROD_DEPENDT_COVERED(rst.getString(7));
         myProducts.setPROD_SAVINGS_COVERED(rst.getString(8));
         myProducts.setPMAS_CODE(rst.getBigDecimal(9));
         myProducts.setPMAS_SHT_DESC(rst.getString(10));
         myProducts.setPMAS_DESC(rst.getString(11));
         myProducts.setPROD_DEPENDT_COVERED2(rst.getString(12));
         myProducts.setPROD_EARNING_PRD_TYPE(rst.getString(13));  
         prods.add(myProducts);   
           
       }
       rst.close();
       cst.close();
      conn.close();          
     }
     catch(Exception e) {
          GlobalCC.EXCEPTIONREPORTING(conn,e);
     }finally{
      GlobalCC.CloseConnections(rst, cst, conn);
    }
     return prods;
   }
    
  public List<productDetails> findOtherProducts() {
     DBConnector myConn=new DBConnector();
     Connection conn=myConn.getDatabaseConn();
     CallableStatement cst=null;
     List<productDetails> prods=new ArrayList<productDetails>();
     ResultSet rst=null;
     
     try {
       String productsQuery="begin LMS_WEB_CURSOR_GRP.get_productsII(?,?);end;";
       cst=conn.prepareCall(productsQuery);
       cst.registerOutParameter(1,OracleTypes.CURSOR);
       cst.setBigDecimal(2,(BigDecimal)session.getAttribute("ProductCode"));
       cst.execute();
       rst=(ResultSet)cst.getObject(1);
       while(rst.next()){
           
         productDetails myProducts = new productDetails();
         myProducts.setProdCode(rst.getBigDecimal(1));
         myProducts.setProdshtDesc(rst.getString(2));
         myProducts.setProdDesc(rst.getString(3));
         myProducts.setProdType(rst.getString(4));
         myProducts.setProd_lapse_prd_days(rst.getBigDecimal(5));
         myProducts.setPROD_MIN_EARNINGS_PRD(rst.getBigDecimal(6));
         myProducts.setPROD_DEPENDT_COVERED(rst.getString(7));
         myProducts.setPROD_SAVINGS_COVERED(rst.getString(8));
         myProducts.setPMAS_CODE(rst.getBigDecimal(9));
         myProducts.setPMAS_SHT_DESC(rst.getString(10));
         myProducts.setPMAS_DESC(rst.getString(11));
         myProducts.setPROD_DEPENDT_COVERED2(rst.getString(12));
           
         prods.add(myProducts);
           
       }
       rst.close();
       cst.close();
      conn.close();          
     }
     catch(Exception e) {
          GlobalCC.EXCEPTIONREPORTING(conn,e);
     }finally{
      GlobalCC.CloseConnections(rst, cst, conn);
    }
     return prods;
   }
    
    public List<productDetails> findProductsByType() {
       DBConnector myConn=new DBConnector();
       Connection conn=myConn.getDatabaseConn();
       CallableStatement cst=null;
       List<productDetails> prods=new ArrayList<productDetails>();
       ResultSet rst=null;
       
       try {
         String productsQuery="begin LMS_WEB_CURSOR_GRP.get_products_by_type(?,?);end;";
         cst=conn.prepareCall(productsQuery);
         cst.registerOutParameter(1,OracleTypes.CURSOR);
         cst.setString(2, "PENS"); //alter to cater for all product types.
         cst.execute();
         rst=(ResultSet)cst.getObject(1);
         while(rst.next()){
             
           productDetails myProducts = new productDetails();
           myProducts.setProdCode(rst.getBigDecimal(1));
           myProducts.setProdshtDesc(rst.getString(2));
           myProducts.setProdDesc(rst.getString(3));
           myProducts.setProdType(rst.getString(4));
           prods.add(myProducts);
             
         }
         rst.close();
         cst.close();
           conn.close();    
         
       }
       catch(Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
       }finally{
        GlobalCC.CloseConnections(rst, cst, conn);
      }
       return prods;
     }
    
    public List<productDetails> findPremiumMask() {
       DBConnector myConn=new DBConnector();
       Connection conn=myConn.getDatabaseConn();
       CallableStatement cst=null;
       List<productDetails> prods=new ArrayList<productDetails>();
       ResultSet rst=null;
       
       try {
         String MaskQuery="BEGIN LMS_WEB_CURSOR_GRP.get_quot_prem_mask(?,?);END;";
         cst=conn.prepareCall(MaskQuery);
         cst.registerOutParameter(1,OracleTypes.CURSOR);
         cst.setBigDecimal(2,(BigDecimal)session.getAttribute("ProductCode"));
           
         cst.execute();
         rst=(ResultSet)cst.getObject(1);
         while(rst.next()){
             
           productDetails myProducts = new productDetails();
           myProducts.setPMAS_CODE(rst.getBigDecimal(1));
           myProducts.setPMAS_SHT_DESC(rst.getString(2));
           myProducts.setPMAS_DESC(rst.getString(3));

           prods.add(myProducts);
             
         }
         rst.close();
         cst.close();
         conn.close();    
         
       }
       catch(Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
       }finally{
        GlobalCC.CloseConnections(rst, cst, conn);
      }
       return prods;
     }
    
    public List<productDetails> findProductCovers() {
       DBConnector myConn=new DBConnector();
       Connection conn=myConn.getDatabaseConn();
       CallableStatement cst=null;
       List<productDetails> prods=new ArrayList<productDetails>();
       ResultSet rst=null;
       
       try {
         String coverTypesQuery="begin LMS_WEB_CURSOR_GRP.FindQuotationProductCovers(?,?,?);end;";
         cst=conn.prepareCall(coverTypesQuery);
         cst.registerOutParameter(1,OracleTypes.CURSOR);
         cst.setBigDecimal(2,(BigDecimal)session.getAttribute("ProductCode"));
         cst.setBigDecimal(3,(BigDecimal)session.getAttribute("QuoteCode"));
           
         cst.execute();
         rst=(ResultSet)cst.getObject(1);
         while(rst.next()){
             
             productDetails coverType=new productDetails();
                coverType.setCvt_code(rst.getBigDecimal(1)); 
                coverType.setCvt_sht_desc(rst.getString(2)); 
                coverType.setCvt_desc(rst.getString(3));
                coverType.setCvt_main_cover(rst.getString(4)); 
                coverType.setPct_formular(rst.getString(5));
                coverType.setPct_code(rst.getBigDecimal(6));
                coverType.setPct_refund_formular(rst.getString(7));
                coverType.setCvt_duration_type(rst.getString(8));
                coverType.setPct_main_sa_perc(rst.getBigDecimal(9));
                coverType.setPctInbuilt(rst.getString(10));
                coverType.setPctAccelerator(rst.getString(11));
           prods.add(coverType);
             
         }
         rst.close();
         cst.close();
           conn.close();    
         
       }
       catch(Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
       }finally{
        GlobalCC.CloseConnections(rst, cst, conn);
      }
       return prods;
     }
    
    public List<productDetails> findProductProvisions() {
       DBConnector myConn=new DBConnector();
       Connection conn=myConn.getDatabaseConn();
       CallableStatement cst=null;
       List<productDetails> prods=new ArrayList<productDetails>();
       ResultSet rst=null;
       
       try {
         String prodprovQuery="BEGIN LMS_WEB_CURSOR_GRP.getProvisions(?,?);END;";
         cst=conn.prepareCall(prodprovQuery);
         cst.registerOutParameter(1,OracleTypes.CURSOR);
         cst.setBigDecimal(2,(BigDecimal)session.getAttribute("ProductCode"));
           
         cst.execute();
         rst=(ResultSet)cst.getObject(1);
         while(rst.next()){
             
             productDetails prov=new productDetails();
             
             prov.setPPROV_CODE(rst.getBigDecimal(1));
             prov.setPROV_SHT_DESC(rst.getString(2));
             prov.setPROV_DESC(rst.getString(3));
             prov.setPPROV_PROD_CODE(rst.getInt(4));
             prov.setPPROV_EDITABLE(rst.getString(5));
             prov.setSelected(false);

             prods.add(prov);
             
         }
         rst.close();
         cst.close();
           conn.close();    
         
       }
       catch(Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
       }finally{
        GlobalCC.CloseConnections(rst, cst, conn);
      }
       return prods;
     }
    
  public List<productDetails> findMemberProvisions() {
     DBConnector myConn=new DBConnector();
     Connection conn=myConn.getDatabaseConn();
     CallableStatement cst=null;
     List<productDetails> memProv=new ArrayList<productDetails>();
     ResultSet rst=null;
     
     try {
       String prodprovQuery="BEGIN LMS_WEB_CURSOR_GRP.findMemberProvisions(?,?);END;";
       cst=conn.prepareCall(prodprovQuery);
       cst.registerOutParameter(1,OracleTypes.CURSOR);
       cst.setBigDecimal(2,(BigDecimal)session.getAttribute("MemberNumber"));
         
       cst.execute();
       rst=(ResultSet)cst.getObject(1);
       while(rst.next()){
           
           productDetails prov=new productDetails();
           prov.setPROV_SHT_DESC(rst.getString(1));
           prov.setPROV_DESC(rst.getString(2));
           prov.setMempCode(rst.getBigDecimal(3));
           memProv.add(prov);
      }
       rst.close();
       cst.close();
         conn.close();    
       
     }
     catch(Exception e) {
         //e.printStackTrace();
          GlobalCC.EXCEPTIONREPORTING(conn,e);
     }finally{
      GlobalCC.CloseConnections(rst, cst, conn);
    }
     return memProv;
   }
    public List<productDetails> findProductCoverDependants() {
       DBConnector myConn=new DBConnector();
       Connection conn=myConn.getDatabaseConn();
       CallableStatement cst=null;
       List<productDetails> prods=new ArrayList<productDetails>();
       ResultSet rst=null;
       
       try {
           String prodDpsQuery="begin LMS_WEB_CURSOR_GRP.get_quot_cover_dependents(?,?,?);end;";
         cst=conn.prepareCall(prodDpsQuery);
           
         cst.registerOutParameter(1,OracleTypes.CURSOR);
         cst.setBigDecimal(2,(BigDecimal)session.getAttribute("qcvtcvtCode"));
         cst.setBigDecimal(3,(BigDecimal)session.getAttribute("ProductCode"));
           
         cst.execute();
         rst=(ResultSet)cst.getObject(1);
         while(rst.next()){
             
            
             productDetails quotTax=new productDetails();
             quotTax.setPcd_max_sum_assured(rst.getBigDecimal(5));
             quotTax.setMax_allowed(rst.getBigDecimal(4));
             quotTax.setDTY_DESCRIPTION(rst.getString(3));
             quotTax.setDTY_SHT_DESC(rst.getString(2));
             quotTax.setDTY_CODE(rst.getBigDecimal(1));
             quotTax.setPCD_MIN_SUM_ASSURED(rst.getBigDecimal(6));

             prods.add(quotTax);
             
         }
         rst.close();
         cst.close();
         conn.close();    
         
       }
       catch(Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
       }finally{
        GlobalCC.CloseConnections(rst, cst, conn);
      }
       return prods;
     }
    
    public List<productDetails> findLapsedProducts() {
       DBConnector myConn=new DBConnector();
       Connection conn=myConn.getDatabaseConn();
       CallableStatement cst=null;
       List<productDetails> prods=new ArrayList<productDetails>();
       ResultSet rst=null;
       
       try {
         String prodprovQuery="BEGIN LMS_WEB_CURSOR_GRP.findlapseproducts(?,?);END;";
         cst=conn.prepareCall(prodprovQuery);
         cst.registerOutParameter(1,OracleTypes.CURSOR);
         cst.setString(2,(String)session.getAttribute("LapseType"));
           
         cst.execute();
         rst=(ResultSet)cst.getObject(1);
         while(rst.next()){
             
             productDetails prov=new productDetails();
             
             prov.setLp_prod_code(rst.getBigDecimal(1));
             prov.setLp_prod_sht_desc(rst.getString(2));
             prov.setLp_prod_desc(rst.getString(3));
             prov.setLp_prod_type(rst.getString(4));
             prov.setLp_PROD_LAPSE_PRD_DAYS(rst.getString(5));

             prods.add(prov);
             
         }
         rst.close();
         cst.close();
         conn.close();    
         
       }
       catch(Exception e) {
          GlobalCC.EXCEPTIONREPORTING(conn,e);
       }finally{
        GlobalCC.CloseConnections(rst, cst, conn);
      }
       return prods;
     }
  public void setProductCoverType(BigDecimal productCoverType) {
      this.productCoverType = productCoverType;
  }

  public BigDecimal getProductCoverType() {
      return (BigDecimal)session.getAttribute("CVT_CODE");
    
  }

  public void setCoverTypeCode(BigDecimal CoverTypeCode) {
      this.CoverTypeCode = CoverTypeCode;
  }

  public BigDecimal getCoverTypeCode() {
      return (BigDecimal)session.getAttribute("qcvtCode");
  }

    public void setCloneProductCode(BigDecimal cloneProductCode) {
        this.cloneProductCode = cloneProductCode;
        session.setAttribute("cloneProdCode", cloneProductCode);
    }

    public BigDecimal getCloneProductCode() {
        return (BigDecimal)session.getAttribute("cloneProdCode");
    }
}
