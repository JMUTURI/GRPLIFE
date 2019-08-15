package LMSG.view.Renewals;

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

public class RenewalDAO {
    public RenewalDAO() {
        super();
    }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    public List<Renewal> findRenewalProducts() {
       DBConnector myConn=new DBConnector();
       Connection conn=myConn.getDatabaseConn();
       CallableStatement cst=null;
       List<Renewal> RenewalList = new ArrayList<Renewal>();
       
       try {
         String productsQuery="begin LMS_WEB_CURSOR_GRP.get_renewal_products(?);end;";
         cst=conn.prepareCall(productsQuery);
         cst.registerOutParameter(1,OracleTypes.CURSOR);
         cst.execute();
         ResultSet rst=(ResultSet)cst.getObject(1);
         while(rst.next()){
             
           Renewal myProducts = new Renewal();
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
             
           RenewalList.add(myProducts);
             
         }
         rst.close();
         cst.close();
        conn.close();          
       }
       catch(Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
       }
       return RenewalList;
     }
    
    public List<Renewal> findRenewalQuery() {
       DBConnector myConn=new DBConnector();
       Connection conn=myConn.getDatabaseConn();
       CallableStatement cst=null;
       List<Renewal> RenewalList = new ArrayList<Renewal>();
       
       try {
         String productsQuery="begin LMS_WEB_CURSOR_GRP.ren_policies_query(?,?,?,?,?,?,?);end;";
         cst=conn.prepareCall(productsQuery);
         cst.registerOutParameter(1,OracleTypes.CURSOR);
         cst.setBigDecimal(2,(BigDecimal)session.getAttribute("ProductCode"));
         String DFr = (String)session.getAttribute("RenDateFrom");
         if (DFr == null){
            cst.setString(3, null);     
         }else{
            cst.setString(3, GlobalCC.parseDate((String)session.getAttribute("RenDateFrom")));     
         }
         String DTo = (String)session.getAttribute("RenDateTo");
         if (DTo == null){
            cst.setString(4, null);     
         }else{
            cst.setString(4, GlobalCC.parseDate((String)session.getAttribute("RenDateTo")));    
         }
         cst.setBigDecimal(5, (BigDecimal)session.getAttribute("policyCode"));
         cst.setBigDecimal(6, (BigDecimal)session.getAttribute("UserCode"));
         cst.setBigDecimal(7, (BigDecimal)session.getAttribute("prpCode"));  
         cst.execute();
         ResultSet rst=(ResultSet)cst.getObject(1);
           
         while(rst.next()){
             
           Renewal myProducts = new Renewal();
           
           myProducts.setRN_POL_CODE(rst.getBigDecimal(1));
           myProducts.setRN_POL_POLICY_NO(rst.getString(2));
           myProducts.setRN_POL_INCEPTION_DATE(rst.getDate(3));
           myProducts.setRN_POL_EFFECTIVE_DATE(rst.getDate(4));
           myProducts.setRN_POL_UNDERWRITING_YEAR(rst.getString(5));
           myProducts.setRN_POL_PRP_CODE(rst.getBigDecimal(6));
           myProducts.setRN_POL_PRP_SHT_DESC(rst.getString(7));
           myProducts.setRN_POL_PROD_CODE(rst.getBigDecimal(8));
           myProducts.setRN_POL_PROD_SHT_DESC(rst.getString(9));
           myProducts.setRN_POL_CLIENT_PRP_CODE(rst.getBigDecimal(10));
           myProducts.setRN_POL_SAVINGS_RIDER(rst.getString(11));
           myProducts.setRN_POL_BRA_CODE(rst.getBigDecimal(12));
           myProducts.setRN_ENDR_RENEWAL_DATE(rst.getDate(13));
           myProducts.setRN_ENDR_CODE(rst.getBigDecimal(14));
           myProducts.setENDR_DURATION_TYPE(rst.getString(15));
           myProducts.setRN_CLIENT(rst.getString(16));
           myProducts.setRN_BRANCH_NAME(rst.getString(17));
           myProducts.setRN_POL_RENEWAL_AREA_STATUS(rst.getString(18));
           myProducts.setRN_PRP_CLNT_CODE(rst.getBigDecimal(19));
           //session.getAttribute("prpCode")
           //session.setAttribute("prpCode",rst.getBigDecimal(19));
           myProducts.setRN_POL_UMBRELLA(rst.getString(20));
             
           myProducts.setSelected(false);

             
           RenewalList.add(myProducts);
             
         System.out.println("Pol code "+rst.getBigDecimal(1));
             
         }
         rst.close();
         cst.close();
        conn.close();          
       }
       catch(Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
       }
       return RenewalList;
     }
    
  public List<Renewal> findRenewalPolicies() {
     DBConnector myConn=new DBConnector();
     Connection conn=myConn.getDatabaseConn();
     CallableStatement cst=null;
     List<Renewal> RenewalList = new ArrayList<Renewal>();
     
     try {
       String productsQuery="begin LMS_WEB_CURSOR_GRP.ren_policies(?,?,?,?,?,?,?,?);end;";
       cst=conn.prepareCall(productsQuery);
       cst.registerOutParameter(1,OracleTypes.CURSOR);
       cst.setBigDecimal(2,(BigDecimal)session.getAttribute("ProductCode"));
       cst.setString(3, null);  
       cst.setString(4, null);  
       cst.setBigDecimal(5, null);
       cst.setBigDecimal(6, null);
       cst.setBigDecimal(7, (BigDecimal)session.getAttribute("prpCode")); 
       cst.setString(8, (String)session.getAttribute("umbrellaCover")); 
       cst.execute();
       ResultSet rst=(ResultSet)cst.getObject(1);
         
       while(rst.next()){
           
         Renewal myProducts = new Renewal();
         
         myProducts.setRN_POL_CODE(rst.getBigDecimal(1));
         myProducts.setRN_POL_POLICY_NO(rst.getString(2));
         myProducts.setRN_POL_INCEPTION_DATE(rst.getDate(3));
         myProducts.setRN_POL_EFFECTIVE_DATE(rst.getDate(4));
         myProducts.setRN_POL_UNDERWRITING_YEAR(rst.getString(5));
         myProducts.setRN_POL_PRP_CODE(rst.getBigDecimal(6));
         myProducts.setRN_POL_PRP_SHT_DESC(rst.getString(7));
         myProducts.setRN_POL_PROD_CODE(rst.getBigDecimal(8));
         myProducts.setRN_POL_PROD_SHT_DESC(rst.getString(9));
         myProducts.setRN_POL_CLIENT_PRP_CODE(rst.getBigDecimal(10));
         myProducts.setRN_POL_SAVINGS_RIDER(rst.getString(11));
         myProducts.setRN_POL_BRA_CODE(rst.getBigDecimal(12));
         myProducts.setRN_ENDR_RENEWAL_DATE(rst.getDate(13));
         myProducts.setRN_ENDR_CODE(rst.getBigDecimal(14));
         myProducts.setENDR_DURATION_TYPE(rst.getString(15));
         myProducts.setRN_CLIENT(rst.getString(16));
         myProducts.setRN_BRANCH_NAME(rst.getString(17));

         RenewalList.add(myProducts);
           
       }
       rst.close();
       cst.close();
       conn.close();          
     }
     catch(Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
     }
     return RenewalList;
   }
}
