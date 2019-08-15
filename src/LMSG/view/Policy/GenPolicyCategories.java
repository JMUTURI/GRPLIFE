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

import LMSG.view.QuotationProcessing.quotCategory;

import LMSG.view.connect.DBConnector;

public class GenPolicyCategories{
  public GenPolicyCategories() {
  }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  public List<quotCategory> findCategory()
  {
     DBConnector myConn=new DBConnector();
    Connection conn=myConn.getDatabaseConn();
    List<quotCategory> QuotationCategory=new ArrayList<quotCategory>();
    String QuotCategoryQuery="begin LMS_WEB_CURSOR_GRP.findpolicycategories(?,?);END;";
   
    try
    {
      CallableStatement cst=conn.prepareCall(QuotCategoryQuery);
      cst.registerOutParameter(1,OracleTypes.CURSOR);
      cst.setBigDecimal(2,(BigDecimal)session.getAttribute("endorsementCode"));
      //cst.setBigDecimal(3,(BigDecimal)session.getAttribute("pcaCode"));
      cst.execute();
      ResultSet rs=(ResultSet)cst.getObject(1);
      while(rs.next()) 
      {
        quotCategory quotCat=new quotCategory();
        quotCat.setLcaCode(rs.getBigDecimal(1));
        quotCat.setCatDesc(rs.getString(2));
        quotCat.setCatShtDesc(rs.getString(3));
        quotCat.setCatPeriod(rs.getString(4));
        quotCat.setPca_sch_code(rs.getBigDecimal(5));
        quotCat.setPca_lpag_code(rs.getBigDecimal(6));
        quotCat.setLpag_desc(rs.getString(7));
        quotCat.setPmas_code(rs.getBigDecimal(8));
        quotCat.setPmas_sht_desc(rs.getString(9));
        quotCat.setPCA_USE_CVR_RATE(rs.getString(10));
        quotCat.setPCA_RATE(rs.getBigDecimal(11));
        quotCat.setPCA_RATE_DIV_FACT(rs.getBigDecimal(12));

        QuotationCategory.add(quotCat);
        
      }
      rs.close();
      cst.close();
        conn.close();    
    }
    catch(Exception e)
    {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return QuotationCategory;
}
    public List<quotCategory> findPolicyClassTermLimits()
    {
       DBConnector myConn=new DBConnector();
      Connection conn=myConn.getDatabaseConn();
      List<quotCategory> QuotationCategory=new ArrayList<quotCategory>();
      String QuotCategoryQuery="begin LMS_WEB_CURSOR_GRP.findPolicyClassTermLimits(?,?,?);END;";
     
      try
      {
        CallableStatement cst=conn.prepareCall(QuotCategoryQuery);
        cst.registerOutParameter(1,OracleTypes.CURSOR);
        cst.setBigDecimal(2,(BigDecimal)session.getAttribute("endorsementCode"));
        cst.setBigDecimal(3,(BigDecimal)session.getAttribute("pcaCode"));
        cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(1);
        while(rs.next()) 
        {
          quotCategory quotCat=new quotCategory();
          quotCat.setCtlCode(rs.getBigDecimal(1));
         // quotCat.set(rs.getString(2));
          quotCat.setCtlLcaCode(rs.getBigDecimal(3));
          quotCat.setCtlFee(rs.getBigDecimal(4));
          quotCat.setCategDesc(rs.getString(5));
          QuotationCategory.add(quotCat);
          
        }
        rs.close();
        cst.close();
          conn.close();    
      }
      catch(Exception e)
      {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
      return QuotationCategory;
    }
}