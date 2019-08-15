package LMSG.view.setups;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.internal.OracleTypes;

import LMSG.view.Base.GlobalCC;

import LMSG.view.connect.DBConnector;

import LMSG.view.utilities.emails;

public class treatyArrangementsDAO {
    public treatyArrangementsDAO() {
        super();
    }
    public List<treatyArrangements> findTreatyArrangements()
    {
      DBConnector connector=new DBConnector();
      Connection conn=connector.getDatabaseConn();
      List<treatyArrangements> treatyArrangementsList=new ArrayList<treatyArrangements>();
      String treatyQuery="BEGIN LMS_SETUPS_CURSOR.find_treaty_arrange(?);END;";
      CallableStatement cst=null;
      try 
      {
        cst=conn.prepareCall(treatyQuery);
        cst.registerOutParameter(1,OracleTypes.CURSOR);
        cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(1);
        while(rs.next())
        {
          treatyArrangements systems=new treatyArrangements();
            systems.setTa_code(rs.getBigDecimal(1));
            systems.setTA_SHT_DESC(rs.getString(2));
            systems.setTA_DESC(rs.getString(3));
            systems.setTA_TYPE(rs.getString(4));
            systems.setTA_CUR_CODE(rs.getBigDecimal(5));
            systems.setTA_CUR_SYMBOL(rs.getString(6));
            systems.setTA_CLA_CODE(rs.getBigDecimal(7));
            systems.setTA_CLA_SHT_DESC(rs.getString(8));
           treatyArrangementsList.add(systems);
        }
          conn.close();    
      }
      catch(Exception ex) 
      {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
      }
      return treatyArrangementsList;
    }
}
