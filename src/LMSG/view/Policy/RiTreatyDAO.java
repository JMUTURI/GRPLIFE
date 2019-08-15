package LMSG.view.Policy;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.internal.OracleTypes;

import LMSG.view.QuotationProcessing.quotationTaxes;

import LMSG.view.connect.DBConnector;

import LMSG.view.connect.DBConnector;

public class RiTreatyDAO {
  public RiTreatyDAO() {
  }
  public List<RiTreaty> findRITreaties(){
     DBConnector myConn=new DBConnector();
    Connection conn=myConn.getDatabaseConn();
    List<RiTreaty> quotTaxes=new ArrayList<RiTreaty>();
    String quotationQuery="begin LMS_WEB_CURSOR_GRP.getTreaties(?);end;";
    try
    {
      CallableStatement cstmt=conn.prepareCall(quotationQuery);
      cstmt.registerOutParameter(1,OracleTypes.CURSOR);
      cstmt.execute();
      ResultSet rs=(ResultSet)cstmt.getObject(1);

      while(rs.next()) 
      {
        RiTreaty quotTax=new RiTreaty();
        quotTax.setTA_DESC(rs.getString(3));
        quotTax.setTA_SHT_DESC(rs.getString(2));
        quotTax.setTA_CODE(rs.getBigDecimal(1));
        quotTaxes.add(quotTax);
      }
      conn.close();    
  }
    catch(Exception e) {
      e.printStackTrace();
    }
    return quotTaxes;
  }
}
