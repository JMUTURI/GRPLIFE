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

import LMSG.view.setups.treaties;

public class productCvtDependentsDAO {
    public productCvtDependentsDAO() {
        super();
    }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    public List<productCvtDependants> findTreatyLOV()
    {
      DBConnector connector=new DBConnector();
      Connection conn=connector.getDatabaseConn();
      List<productCvtDependants> arrangementsList=new ArrayList<productCvtDependants>();
      String treatiesQuery="BEGIN LMS_SETUPS_CURSOR.prodcvtdependants(?,?,?);END;";
      CallableStatement cst=null;
      try 
      {
        cst=conn.prepareCall(treatiesQuery);
        cst.registerOutParameter(1,OracleTypes.CURSOR);
        cst.setBigDecimal(2,(BigDecimal)session.getAttribute("PCT_CODE"));
        cst.setBigDecimal(3,null);
        cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(1);
        while(rs.next())
        {
          productCvtDependants systems=new productCvtDependants();
            systems.setPcdCode(rs.getBigDecimal(1));
            systems.setDtyDescription(rs.getString(2));
            systems.setPcdProdcode(rs.getBigDecimal(3));
            systems.setPcdPctcode(rs.getBigDecimal(4));
            systems.setPcdDtycode(rs.getBigDecimal(5));
            systems.setPcdDtyshtdesc(rs.getString(6));
            systems.setPcdMaxnoallowed(rs.getBigDecimal(7));
            systems.setPcdMinage(rs.getBigDecimal(8));
            systems.setPcdMaxage(rs.getBigDecimal(9));
            systems.setPcdMaxsumassured(rs.getBigDecimal(10));
            systems.setPcdCvtcode(rs.getBigDecimal(11));
            systems.setPcdCvtshtdesc(rs.getString(12));
            systems.setPcdMinsumassrd(rs.getBigDecimal(13));
            systems.setPcd_default(rs.getString(14));
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
    public List<productCvtDependants> findDependentsLOV()
    {
      DBConnector connector=new DBConnector();
      Connection conn=connector.getDatabaseConn();
      List<productCvtDependants> arrangementsList=new ArrayList<productCvtDependants>();
      String treatiesQuery="BEGIN LMS_SETUPS_CURSOR.findDependentTypes(?);END;";
      CallableStatement cst=null;
      try 
      {
        cst=conn.prepareCall(treatiesQuery);
        cst.registerOutParameter(1,OracleTypes.CURSOR);
       
        cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(1);
        while(rs.next())
        {
          productCvtDependants systems=new productCvtDependants();
            systems.setDtyCode(rs.getBigDecimal(1));
            systems.setDtyShtDesc(rs.getString(2));
            systems.setDtyDesc(rs.getString(3));
            
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
