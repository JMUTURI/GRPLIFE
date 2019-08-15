package LMSG.view.QuotationProcessing;


import java.math.BigDecimal;

import java.util.List;


import java.sql.*;

import java.util.ArrayList;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.jdbc.internal.OracleTypes;

import LMSG.view.Base.GlobalCC;
import LMSG.view.Base.LOVCC;


import LMSG.view.connect.DBConnector;

public class GenQuotCat extends LOVCC {
  public GenQuotCat() {
  }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  public List<quotCategory> findCategory()
  {
     DBConnector myConn=new DBConnector();
    Connection conn=myConn.getDatabaseConn();
    List<quotCategory> QuotationCategory=new ArrayList<quotCategory>();
    String QuotCategoryQuery="begin LMS_WEB_CURSOR_GRP.quotationCategories(?,?);END;";
   
    try
    {
      CallableStatement cst=conn.prepareCall(QuotCategoryQuery);
      cst.registerOutParameter(1,OracleTypes.CURSOR);
      cst.setBigDecimal(2,(BigDecimal)session.getAttribute("QuoteCode"));
      cst.execute();
      ResultSet rs=(ResultSet)cst.getObject(1);
      while(rs.next()) 
      {
        quotCategory quotCat=new quotCategory();
        quotCat.setLcaCode(rs.getBigDecimal(1));
        quotCat.setCatDesc(rs.getString(3));
        quotCat.setCatShtDesc(rs.getString(2));
        quotCat.setCatPeriod(rs.getString(4));
        
        //LOVCC.pcaCode= rs.getBigDecimal(1);
          session.setAttribute("pcaCode",rs.getBigDecimal(1));
        QuotationCategory.add(quotCat);
      }
      rs.close();
      cst.close();
        conn.close();    
    }
    catch(Exception e)
    {
      e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return QuotationCategory;
}
    public List<quotCategory> findClassTermLimits()
    {
       DBConnector myConn=new DBConnector();
      Connection conn=myConn.getDatabaseConn();
      List<quotCategory> QuotationCategory=new ArrayList<quotCategory>();
      String QuotCategoryQuery="begin LMS_WEB_CURSOR_GRP.findClassTermLimits(?,?);END;";
     
      try
      {
        CallableStatement cst=conn.prepareCall(QuotCategoryQuery);
        cst.registerOutParameter(1,OracleTypes.CURSOR);
        cst.setBigDecimal(2,(BigDecimal)session.getAttribute("QuoteCode"));
        cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(1);
        while(rs.next()) 
        {
          quotCategory quotCat=new quotCategory();
          quotCat.setCtlCode(rs.getBigDecimal(1));
          quotCat.setCtlQuoCode(rs.getBigDecimal(2));
          quotCat.setCtlLcaCode(rs.getBigDecimal(3));
          quotCat.setCtlFee(rs.getBigDecimal(4));
          quotCat.setCategDesc(rs.getString(5));
          //LOVCC.pcaCode= rs.getBigDecimal(1);
            session.setAttribute("pcaCode",rs.getBigDecimal(1));
          QuotationCategory.add(quotCat);
        }
        rs.close();
        cst.close();
          conn.close();    
      }
      catch(Exception e)
      {
        e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(null, e);
      }
      return QuotationCategory;
    }
}
