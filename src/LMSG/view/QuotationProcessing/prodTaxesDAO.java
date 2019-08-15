package LMSG.view.QuotationProcessing;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.internal.OracleTypes;

import LMSG.view.connect.DBConnector;

import LMSG.view.connect.DBConnector;

public class prodTaxesDAO {
  public prodTaxesDAO() {
  }
  public List<prodTaxes> findProductTaxes() {
     DBConnector myConn=new DBConnector();
    Connection conn=myConn.getDatabaseConn();
    CallableStatement cst=null;
   
    List<prodTaxes> ProductTaxes=new ArrayList<prodTaxes>();
    try {
      String TaxQuery="begin LMS_WEB_CURSOR_GRP.get_taxes(?,?);end;";
   
      cst=conn.prepareCall(TaxQuery);
      cst.registerOutParameter(1,OracleTypes.CURSOR);
     cst.setInt(2, 0);//Quotation.prodCode);
    
      cst.execute();

      ResultSet rs=(ResultSet)cst.getObject(1);   
      while (rs.next()) {
        prodTaxes existQout=new prodTaxes();
        existQout.setTT_CODE(rs.getBigDecimal(1));
        existQout.setTT_SHT_DESC(rs.getString(2));
        existQout.setTT_DESC(rs.getString(3));
        existQout.setTRT_RATE(rs.getBigDecimal(4));
        existQout.setTRT_DIVISION_FACTOR(rs.getBigDecimal(5));
        existQout.setTT_RENEWAL_ENDOS(rs.getString(6));
        existQout.setTRT_RATE_TYPE(rs.getString(7));
        existQout.setTRT_CODE(rs.getBigDecimal(8));
           
       ProductTaxes.add(existQout);
      }
   
      rs.close();
      cst.close();
        conn.close();   
      
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    return ProductTaxes;
  }
}
