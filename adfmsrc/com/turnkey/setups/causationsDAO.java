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

public class causationsDAO {
    public causationsDAO() {
        super();
    }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    Connection conn=null;
    public List<causations> findCausations()
    
    {
      DBConnector connector=new DBConnector();
      conn=connector.getDatabaseConn();
      List<causations> arrangementsList=new ArrayList<causations>();
      String treatiesQuery="BEGIN LMS_SETUPS_CURSOR.get_causations(?);END;";
      CallableStatement cst=null;
      try 
      {
        cst=conn.prepareCall(treatiesQuery);
        cst.registerOutParameter(1,OracleTypes.CURSOR);
                cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(1);
        while(rs.next())
        {
        causations systems=new causations();
            systems.setCausCode(rs.getBigDecimal(1));
            systems.setCausShtdesc(rs.getString(2));
            systems.setCausDesc(rs.getString(3));
            systems.setCausClacode(rs.getBigDecimal(4));
            systems.setCausType(rs.getString(5));
            systems.setCausWthld_emplr_fnd(rs.getString(6));
            systems.setCausClm_prefix(rs.getString(7));
            systems.setCaus_wthld_emple_fnd(rs.getString(8));
            systems.setCaus_age_from(rs.getBigDecimal(9));
            systems.setCaus_age_to(rs.getBigDecimal(10));

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
    public List<causations> findDeathDisabilityCauses()
    
    {
      DBConnector connector=new DBConnector();
      conn=connector.getDatabaseConn();
      List<causations> arrangementsList=new ArrayList<causations>();
      String treatiesQuery="BEGIN LMS_SETUPS_CURSOR.dth_dis_causes(?,?);END;";
      CallableStatement cst=null;
      try 
      {
        cst=conn.prepareCall(treatiesQuery);
        cst.registerOutParameter(1,OracleTypes.CURSOR);
        cst.setBigDecimal(2,null);
                cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(1);
        while(rs.next())
        {
        causations systems=new causations();
            systems.setDdcCode(rs.getBigDecimal(1));
            systems.setDdcShtDesc(rs.getString(2));
            systems.setDdcDesc(rs.getString(3));
            systems.setDdcHivDesc(rs.getString(4));
            systems.setDdcWaitingPrd(rs.getBigDecimal(5));
            //systems.setCausClm_prefix(rs.getString(7));
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
    public List<causations> findCausationCauses()
    
    {
      DBConnector connector=new DBConnector();
      conn=connector.getDatabaseConn();
      List<causations> arrangementsList=new ArrayList<causations>();
      String treatiesQuery="BEGIN LMS_SETUPS_CURSOR.get_causation_causes(?,?);END;";
      CallableStatement cst=null;
      try 
      {
        cst=conn.prepareCall(treatiesQuery);
        
        cst.setBigDecimal(1,(BigDecimal)session.getAttribute("CAUS_CODE"));
        cst.registerOutParameter(2,OracleTypes.CURSOR);
                cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(2);
        while(rs.next())
        {
        causations systems=new causations();
            systems.setCscCode(rs.getBigDecimal(1));
            systems.setCscCausCode(rs.getBigDecimal(2));
            systems.setCscDdcCode(rs.getBigDecimal(3));
            systems.setCscSex(rs.getString(4));
            systems.setCscMinClaimableprd(rs.getBigDecimal(5));
            systems.setDdsDesc(rs.getString(6));
            systems.setDdsShtDesc(rs.getString(7));
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
    public List<causations> findNonMedicalsSA()
    
    {
      DBConnector connector=new DBConnector();
      conn=connector.getDatabaseConn();
      List<causations> arrangementsList=new ArrayList<causations>();
      String treatiesQuery="BEGIN LMS_SETUPS_CURSOR.non_medical_sa(?,?);END;";
      CallableStatement cst=null;
      try 
      {
        cst=conn.prepareCall(treatiesQuery);
        
        
        cst.registerOutParameter(1,OracleTypes.CURSOR);
        cst.setBigDecimal(2,null);
                cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(1);
        while(rs.next())
        {
        causations systems=new causations();
            systems.setNmsCode(rs.getBigDecimal(1));
            systems.setMmsYearFrom(rs.getBigDecimal(2));
            systems.setNmsYearTo(rs.getBigDecimal(3));
            systems.setNmsRate(rs.getBigDecimal(4));
            systems.setNmsMaxAmt(rs.getBigDecimal(5));
            systems.setNmsDivFact(rs.getBigDecimal(6));
            systems.setNmsWef(rs.getDate(7));
            systems.setNmsWet(rs.getDate(8));
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
    public List<causations> findCoverTypeCausations()
    
    {
      DBConnector connector=new DBConnector();
      conn=connector.getDatabaseConn();
      List<causations> arrangementsList=new ArrayList<causations>();
      String treatiesQuery="BEGIN LMS_SETUPS_CURSOR.findCoverTypeCausations(?,?);END;";
      CallableStatement cst=null;
      try 
      {
        cst=conn.prepareCall(treatiesQuery);
        
        cst.setBigDecimal(1,(BigDecimal)session.getAttribute("PCT_CODE"));
        cst.registerOutParameter(2,OracleTypes.CURSOR);
        
                cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(2);
        while(rs.next())
        {
        causations systems=new causations();
            systems.setCvtcCode(rs.getBigDecimal(1));
            systems.setCvtcCvtCode(rs.getBigDecimal(2));
            systems.setCvtcCausShtDesc(String.valueOf(rs.getString(3)));
            systems.setCvtcCauseCode(rs.getBigDecimal(4));
            //systems.setNmsMaxAmt(rs.getBigDecimal(5));
            systems.setCvtcProdCode(rs.getBigDecimal(5));
            systems.setCvtcProdShtDesc(rs.getString(6));
            systems.setCvtcCausDesc(rs.getString(7));
            systems.setCvtcMinDaysClaimable(rs.getBigDecimal(8));
            systems.setCvtcMaxDaysClaimable(rs.getBigDecimal(9));
           arrangementsList.add(systems);
        }
          conn.close();    
      }
      catch(Exception ex) 
      {
            ex.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
      }
      return arrangementsList;
    }
    public List<causations> findPolicyDocuments()
    
    {
      DBConnector connector=new DBConnector();
      conn=connector.getDatabaseConn();
      List<causations> arrangementsList=new ArrayList<causations>();
      String treatiesQuery="BEGIN LMS_SETUPS_CURSOR.findPolicyDocuments(?);END;";
      CallableStatement cst=null;
      try 
      {
        cst=conn.prepareCall(treatiesQuery);
        cst.registerOutParameter(1,OracleTypes.CURSOR);
        
                cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(1);
        while(rs.next())
        {
        causations systems=new causations();
            systems.setRdClaCode(rs.getBigDecimal(1));
            systems.setRdCode(rs.getBigDecimal(2));
            systems.setRdShtDesc(rs.getString(3));
            systems.setRdDesc(rs.getString(4));
            systems.setRdByProd(rs.getString(5));
            systems.setRdByProdDesc(rs.getString(6));
            systems.setRdPolDoc(rs.getString(7));
            systems.setRdPolDocDesc(rs.getString(8));
            systems.setRdDthClmdoc(rs.getString(9));
            systems.setRdDthClmdocDesc(rs.getString(10));
            systems.setRdDisClmDoc(rs.getString(11));
            systems.setRdDisClmDocDesc(rs.getString(12));
            systems.setRdWthrClmDoc(rs.getString(13));
            systems.setRdWthrClmDocDesc(rs.getString(14));
            systems.setRD_MATURITY_DOC(rs.getString(15));
            systems.setRD_MATURITY_DOC_DESC(rs.getString(16));
            
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
    public List<causations> findProductReuiredDocs()
    
    {
      DBConnector connector=new DBConnector();
      conn=connector.getDatabaseConn();
      List<causations> arrangementsList=new ArrayList<causations>();
      String treatiesQuery="BEGIN LMS_SETUPS_CURSOR.findRequiredProdDocs(?,?);END;";
      CallableStatement cst=null;
      try 
      {
        cst=conn.prepareCall(treatiesQuery);
        cst.registerOutParameter(1,OracleTypes.CURSOR);
        cst.setBigDecimal(2,(BigDecimal)session.getAttribute("RD_CODE"));
        
        
                cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(1);
        while(rs.next())
        {
        causations systems=new causations();
            systems.setRdpRdCode(rs.getBigDecimal(1));
            systems.setRdpProdCode(rs.getBigDecimal(2));
            systems.setProductDisplay(rs.getString(3));
           
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
    public List<causations> findDrCrNarratives()
    
    {
      DBConnector connector=new DBConnector();
      conn=connector.getDatabaseConn();
      List<causations> arrangementsList=new ArrayList<causations>();
      String treatiesQuery="BEGIN LMS_SETUPS_CURSOR.findDrCrNarratives(?,?);END;";
      CallableStatement cst=null;
      try 
      {
        cst=conn.prepareCall(treatiesQuery);
        cst.registerOutParameter(1,OracleTypes.CURSOR);
        cst.setString(2,(String)session.getAttribute("BTR_TRANS_CODE"));
        
        
                cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(1);
        while(rs.next())
        {
        causations systems=new causations();
            systems.setDrcrCode(rs.getBigDecimal(1));
            systems.setBtrTransCode(rs.getString(2));
            systems.setDrNarrative(rs.getString(3));
            systems.setCrNarrative(rs.getString(4));
            systems.setDRCR_END_NARRATIVE(rs.getString(5));
            systems.setDRCR_DR_COIN_NARRATIVE(rs.getString(6));
            systems.setDRCR_CR_COIN_NARRATIVE(rs.getString(7));
            systems.setDRCR_COIN_APPORTION_NARRATIVE(rs.getString(8));
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
    public List<causations> findDisabilityLosses()
    
    {
      DBConnector connector=new DBConnector();
      conn=connector.getDatabaseConn();
      List<causations> arrangementsList=new ArrayList<causations>();
      String treatiesQuery="BEGIN LMS_SETUPS_CURSOR.findDisabilityLosses(?,?);END;";
      CallableStatement cst=null;
      try 
      {
        cst=conn.prepareCall(treatiesQuery);
        
        cst.registerOutParameter(1,OracleTypes.CURSOR);
        cst.setBigDecimal(2,(BigDecimal)session.getAttribute("CVTC_CODE"));
        
        
                cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(1);
        while(rs.next())
        {
        causations systems=new causations();
            systems.setLdlCode(rs.getBigDecimal(1));
            systems.setLdlDesc(rs.getString(2));
            systems.setLdlPerc(rs.getBigDecimal(3));
            systems.setLdlPctCode(rs.getBigDecimal(4));
            systems.setLdlCvtCode(rs.getBigDecimal(5));
            systems.setLdlCvtcCode(rs.getBigDecimal(6));
            systems.setLdlClosePol(rs.getString(7));
            systems.setLdlClosePolDesc(rs.getString(8));
            systems.setLdlWklIndemnity(rs.getString(9));
            systems.setLdlWklIndemnityDesc(rs.getString(10));
            systems.setLdlDivisionFactor(rs.getString(11));
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
