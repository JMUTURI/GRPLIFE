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

public class treatySetupDAO {
    public treatySetupDAO() {
        super();
    }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    public List<treatySetups> findTreatySetups()
    {
      DBConnector connector=new DBConnector();
      Connection conn=connector.getDatabaseConn();
      List<treatySetups> arrangementsList=new ArrayList<treatySetups>();
      String arrangmentsQuery="BEGIN LMS_SETUPS_CURSOR.findTreatySetups(?,?);END;";
      CallableStatement cst=null;
      try 
      {
        cst=conn.prepareCall(arrangmentsQuery);
        cst.registerOutParameter(1,OracleTypes.CURSOR);
        cst.setBigDecimal(2,(BigDecimal)session.getAttribute("as_code"));
        cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(1);
        while(rs.next())
        {
         treatySetups systems=new treatySetups();
            systems.setREI_TRS_SHT_DESC(rs.getString(1));
            systems.setREI_TRS_CODE(rs.getBigDecimal(2));
            systems.setREI_TRT_CODE(rs.getBigDecimal(3));
            systems.setREI_TRT_SHT_DESC(rs.getString(4));
            systems.setREI_CODE(rs.getBigDecimal(5));
            systems.setREI_WEF_DT(rs.getDate(6));
            systems.setREI_WET_DT(rs.getDate(7));
            systems.setREI_UW_YEAR(rs.getBigDecimal(8));
            systems.setREI_PREM_RESV_INT(rs.getBigDecimal(9));
            systems.setREI_CEDE_RATE(rs.getBigDecimal(10));
            systems.setREI_RATE_TYPE(rs.getString(11));
            systems.setREI_PROFIT_COMM(rs.getBigDecimal(12));
            systems.setREI_MGT_FEE(rs.getBigDecimal(13));
            systems.setREI_CASH_LOSS(rs.getBigDecimal(14));
            systems.setREI_ACCOUNTS(rs.getString(15));
            systems.setREI_ACCOUNTS_DESC(rs.getString(16));
            systems.setREI_AOFREINS_CODE(rs.getBigDecimal(17));
            systems.setREI_PREM_PORTFOLIO(rs.getBigDecimal(18));
            systems.setREI_LOSS_PORTFOLIO(rs.getBigDecimal(19));
            systems.setREI_QUAKE_LIMIT(rs.getBigDecimal(20));
            systems.setREI_COMM_RATE(rs.getBigDecimal(21));
            systems.setCUR_DESCN(rs.getString(22));
            systems.setREI_PRD_LOSSES_CARRIED_FRD(rs.getBigDecimal(24));
            systems.setREI_SI_START_FROM(rs.getBigDecimal(25));
            systems.setREI_GEN_CONDITIONS(rs.getString(26));
            systems.setREI_EXCLUSIONS(rs.getString(27));
            systems.setREI_INFORMATION(rs.getString(28));
            systems.setREI_WORDING(rs.getString(29));
            systems.setREI_WARRANTY(rs.getString(30));
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
