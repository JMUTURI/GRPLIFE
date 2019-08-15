package LMSG.view.Policy;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.internal.OracleTypes;

import LMSG.view.QuotationProcessing.occupations;

import LMSG.view.connect.DBConnector;

import LMSG.view.connect.DBConnector;

public class documentsDAO {
  public documentsDAO() {
  }
  public List<documents> FindOccupation() {
     DBConnector myConn=new DBConnector();
    Connection conn=myConn.getDatabaseConn();
    CallableStatement cst=null;
    List<documents> transactions=new ArrayList<documents>();
    
    try
      
    {
      
      String processQuery="begin LMS_WEB_CURSOR_GRP.getRequiredDocuments(?);end;";
      cst=conn.prepareCall(processQuery);
      cst.registerOutParameter(1,OracleTypes.CURSOR);
      cst.execute();
      ResultSet rs=(ResultSet)cst.getObject(1);
      while(rs.next()) 
      {
        documents myTrans=new documents();
        myTrans.setRD_CODE(rs.getBigDecimal(1));
        myTrans.setRD_SHT_DESC(rs.getString(2));
        myTrans.setRD_DESC(rs.getString(3));
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
