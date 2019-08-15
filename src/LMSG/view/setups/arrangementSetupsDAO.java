package LMSG.view.setups;

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

import LMSG.view.connect.DBConnector;

public class arrangementSetupsDAO {
    public arrangementSetupsDAO() {
        super();
    }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    public List<arrangementSetups> findArrangementSetups()
    {
      DBConnector connector=new DBConnector();
      Connection conn=connector.getDatabaseConn();
      List<arrangementSetups> arrangementsList=new ArrayList<arrangementSetups>();
      String arrangmentsQuery="BEGIN LMS_SETUPS_CURSOR.find_arrangement_setups(?,?);END;";
      CallableStatement cst=null;
      try 
      {
        cst=conn.prepareCall(arrangmentsQuery);
        cst.registerOutParameter(1,OracleTypes.CURSOR);
        cst.setBigDecimal(2, (BigDecimal)session.getAttribute("ta_code"));
        cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(1);
        while(rs.next())
        {
          arrangementSetups systems=new arrangementSetups();
            systems.setAS_UWYR(rs.getBigDecimal(1));
            systems.setAS_CODE(rs.getBigDecimal(2));
            systems.setAS_TA_CODE(rs.getBigDecimal(3));
            systems.setAS_RETENTION_LIMIT(rs.getBigDecimal(4));
            
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
