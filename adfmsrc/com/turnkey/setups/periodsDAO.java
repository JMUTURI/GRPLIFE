package com.turnkey.setups;

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

public class periodsDAO {
    public periodsDAO() {
        super();
    }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    Connection conn=null;
    public List<periods> findPeriods()
    
    {
      DBConnector connector=new DBConnector();
      conn=connector.getDatabaseConn();
      List<periods> periodList=new ArrayList<periods>();
      String periodsQuery="BEGIN LMS_SETUPS_CURSOR.fetchLmsPeriods(?);END;";
      CallableStatement cst=null;
      try 
      {
        cst=conn.prepareCall(periodsQuery);
        cst.registerOutParameter(1,OracleTypes.CURSOR);
       
        cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(1);
        while(rs.next())
        {
        periods systems=new periods();
            systems.setPerCode(rs.getBigDecimal(1));
            systems.setPerName(rs.getString(2));
            systems.setPerValFreqDesc(rs.getString(3));
            systems.setPerValFreq(rs.getString(4));
            systems.setPerWef(rs.getDate(5));
            systems.setPerWet(rs.getDate(6));
            systems.setPerId(rs.getBigDecimal(7));
            
           periodList.add(systems);
        }
          conn.close();    
      }
      catch(Exception ex) 
      {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
      }
      return periodList;
    }
}
