package LMSG.view.QuotationProcessing;

import LMSG.view.Base.GlobalCC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import oracle.jdbc.OracleTypes;

import LMSG.view.connect.DBConnector;


public class okQuotationsDAO {
  public okQuotationsDAO() {
  }
  public List<okQuotations> FindOkQuotations() {
      DBConnector myConn=new DBConnector();
     Connection conn=myConn.getDatabaseConn();
     CallableStatement cst=null;
     List<okQuotations> OkQuotList=new ArrayList<okQuotations>();
     
     try {
       String okQuotQuery="begin LMS_WEB_CURSOR_GRP.get_ok_quot(?,?,?);end;";
       cst=conn.prepareCall(okQuotQuery);
       cst.registerOutParameter(1,OracleTypes.CURSOR);
       cst.setInt(2, 0);//Quotation.prodCode);
       cst.setBigDecimal(3, null);//Quotation.conQuotationCode);;
       
       cst.execute();
       ResultSet rst=(ResultSet)cst.getObject(1);
       while(rst.next()){
         okQuotations myProd=new okQuotations();
         myProd.setQUO_CODE(rst.getBigDecimal(1));
         myProd.setQUO_NO(rst.getString(2));
         myProd.setClient(rst.getString(3));
         myProd.setQUO_EFFECTIVE_DATE(rst.getDate(4));
         myProd.setProd_sht_desc(rst.getString(5));
         myProd.setProduct_display(rst.getString(6));
         myProd.setBranch(rst.getString(7));
         myProd.setOccupation(rst.getString(8));
         myProd.setHazard(rst.getString(9));
         myProd.setUwYear(rst.getBigDecimal(10));
         myProd.setPaymentFreq(rst.getString(11));
         OkQuotList.add(myProd);
       }
       rst.close();
       cst.close();
         conn.close();   
       
     }
     catch(Exception e) {
       GlobalCC.EXCEPTIONREPORTING(conn, e);
     }
     return OkQuotList;
   }
}
