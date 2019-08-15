package LMSG.view.QuotationProcessing;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.internal.OracleTypes;

import LMSG.view.connect.DBConnector;


public class occupationsDAO {
  public occupationsDAO() {
  }
  public List<occupations>FindOccupation() {
     DBConnector myConn=new DBConnector();
    Connection conn=myConn.getDatabaseConn();
    CallableStatement cst=null;
    List<occupations> transactions=new ArrayList<occupations>();
    
    try
      
    {
      
      String processQuery="begin LMS_WEB_CURSOR_GRP.grp_occupations(?);end;";
      cst=conn.prepareCall(processQuery);
      cst.registerOutParameter(1,OracleTypes.CURSOR);
      cst.execute();
      ResultSet rs=(ResultSet)cst.getObject(1);
      while(rs.next()) 
      {
        occupations myTrans=new occupations();
        myTrans.setGco_code(rs.getBigDecimal(1));
        myTrans.setGCO_DESC(rs.getString(2));
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
