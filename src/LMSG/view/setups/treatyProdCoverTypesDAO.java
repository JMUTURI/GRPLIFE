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

public class treatyProdCoverTypesDAO {
    public treatyProdCoverTypesDAO() {
        super();
    }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    public List<treatyProdCoverTypes> findTreatyProdCoverTypes()
    {
      DBConnector connector=new DBConnector();
      Connection conn=connector.getDatabaseConn();
      List<treatyProdCoverTypes> treatyArrangementsList=new ArrayList<treatyProdCoverTypes>();
      String treatyQuery="BEGIN LMS_SETUPS_CURSOR.find_treaty_prod_covers(?,?);END;";
      CallableStatement cst=null;
      try 
      {
        cst=conn.prepareCall(treatyQuery);
        cst.registerOutParameter(1,OracleTypes.CURSOR);
        cst.setBigDecimal(2, (BigDecimal)session.getAttribute("trpd_code"));
        cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(1);
        while(rs.next())
        {
          treatyProdCoverTypes systems=new treatyProdCoverTypes();
            systems.setTCT_CODE(rs.getBigDecimal(1));
            systems.setTCT_TPRD_CODE(rs.getBigDecimal(2));
            systems.setTCT_TA_CODE(rs.getBigDecimal(3));
            systems.setTCT_TA_SHT_DESC(rs.getString(4));
            systems.setTCT_PROD_CODE(rs.getBigDecimal(5));
            systems.setTCT_AS_CODE(rs.getBigDecimal(6));
            systems.setTCT_PCT_CODE(rs.getBigDecimal(7));
            systems.setTCT_CVT_CODE(rs.getBigDecimal(8));
            systems.setTCT_CVT_SHT_DESC(rs.getString(9));
            systems.setCVT_DESC(rs.getString(10));
            systems.setTCT_RETENTION_LIMIT(rs.getBigDecimal(11));
            systems.setTCT_MULTI_LIFE_RETN_LIMT(rs.getBigDecimal(12));
            systems.setTCT_OS_BAL_METHOD(rs.getString(13));
            systems.setRIOS_DESC(rs.getString(14));
            systems.setTCT_RATE_TYPE(rs.getString(15));
            systems.setTCT_CESSION_RATE(rs.getBigDecimal(16));
            systems.setTCT_OVER_LIMIT_TOCEDE(rs.getBigDecimal(17));
            systems.setTCT_RIOS_CODE(rs.getBigDecimal(18));
            systems.setTCT_REDUCE_BAL(rs.getString(19));
            systems.setTCT_AAL(rs.getBigDecimal(20));
            //systems.setTCT_OS_BAL_METHOD_DESC(rs.getString(20));
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
