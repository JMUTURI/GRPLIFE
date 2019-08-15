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

import LMSG.view.Base.LOVCC;

import LMSG.view.QuotationProcessing.occupations;

import LMSG.view.connect.DBConnector;

import LMSG.view.connect.DBConnector;

public class groupPolicyDocsDAO extends LOVCC {
  public groupPolicyDocsDAO() {
  }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  public List<groupPolicyDocs> FindPolicyDocs() {
     DBConnector myConn=new DBConnector();
    Connection conn=myConn.getDatabaseConn();
    CallableStatement cst=null;
    List<groupPolicyDocs> transactions=new ArrayList<groupPolicyDocs>();
    
    try
      
    {
     
      String processQuery="begin LMS_WEB_CURSOR_GRP.getpolicydocuments(?,?);end;";
      cst=conn.prepareCall(processQuery);
      cst.registerOutParameter(1,OracleTypes.CURSOR);
      cst.setBigDecimal(2,(BigDecimal)session.getAttribute("endorsementCode"));
      cst.execute();
      ResultSet rs=(ResultSet)cst.getObject(1);
      while(rs.next()) 
      {
        groupPolicyDocs myTrans=new groupPolicyDocs();
        myTrans.setGPD_CODE(rs.getBigDecimal(1));
        myTrans.setGPD_RD_CODE(rs.getBigDecimal(2));
        myTrans.setDOCUMENT_DISPLAY(rs.getString(3));
        myTrans.setGPD_RD_SHT_DESC(rs.getString(4));
        myTrans.setDOCUMENT_SUBMITTED(rs.getString(5));
        myTrans.setDateGiven(rs.getDate(6));
        myTrans.setGPD_DOC_NO(rs.getString(7));
        transactions.add(myTrans);
      }
      rs.close();
      cst.close(); 
        conn.close();    
      
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    return transactions;
  }
}
