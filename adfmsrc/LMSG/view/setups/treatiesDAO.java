package LMSG.view.setups;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.jdbc.internal.OracleTypes;

import LMSG.view.Base.GlobalCC;

import LMSG.view.connect.DBConnector;

public class treatiesDAO {
    public treatiesDAO() {
        super();
    }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    public List<treaties> findTreatyLOV()
    {
      DBConnector connector=new DBConnector();
      Connection conn=connector.getDatabaseConn();
      List<treaties> arrangementsList=new ArrayList<treaties>();
      String treatiesQuery="BEGIN LMS_SETUPS_CURSOR.findTreatyLOV(?);END;";
      CallableStatement cst=null;
      try 
      {
        cst=conn.prepareCall(treatiesQuery);
        cst.registerOutParameter(1,OracleTypes.CURSOR);
       
        cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(1);
        while(rs.next())
        {
          treaties systems=new treaties();
            systems.setTRS_CODE(rs.getBigDecimal(1));
            systems.setTRS_TRT_CODE(rs.getBigDecimal(3));
            systems.setTRS_SHT_DESC(rs.getString(2));
            systems.setTRS_TRT_SHT_DESC(rs.getString(4));
            
           arrangementsList.add(systems);
        }
          conn.close();    
      }
      catch(Exception ex) 
      {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
      }
      return arrangementsList;
    }
}
