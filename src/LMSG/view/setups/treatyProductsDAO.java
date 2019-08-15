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

public class treatyProductsDAO {
    public treatyProductsDAO() {
        super();
    }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    public List<treatyProducts> findArrangementSetups()
    {
      DBConnector connector=new DBConnector();
      Connection conn=connector.getDatabaseConn();
      List<treatyProducts> arrangementsList=new ArrayList<treatyProducts>();
      String arrangmentsQuery="BEGIN LMS_SETUPS_CURSOR.find_treaty_products(?,?,?);END;";
      CallableStatement cst=null;
      try 
      {
        cst=conn.prepareCall(arrangmentsQuery);
        cst.registerOutParameter(1,OracleTypes.CURSOR);
        cst.setBigDecimal(2, (BigDecimal)session.getAttribute("ta_code"));
        cst.setBigDecimal(3,(BigDecimal)session.getAttribute("as_code"));
        cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(1);
        while(rs.next())
        {
         treatyProducts systems=new treatyProducts();
            systems.setTPRD_CODE(rs.getBigDecimal(1));
            systems.setTPRD_PROD_CODE(rs.getBigDecimal(2));
            systems.setPRODUCT_DISPLAY(rs.getString(3));
            systems.setTPRD_TA_CODE(rs.getBigDecimal(4));
            systems.setTPRD_AS_CODE(rs.getBigDecimal(5));
            systems.setTPRD_TA_SHT_DESC(rs.getString(6));
            systems.setTRPD_DEFAULT_TRTY(rs.getString(7));
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
