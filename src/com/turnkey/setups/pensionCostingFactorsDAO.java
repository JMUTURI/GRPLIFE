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

public class pensionCostingFactorsDAO {
    public pensionCostingFactorsDAO() {
        super();
    }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    
    public List<pensionCostingFactors> findPensionCostingFactors()

    {
      Connection conn=null;
      DBConnector connector=new DBConnector();
      conn=connector.getDatabaseConn();
      List<pensionCostingFactors> arrangementsList=new ArrayList<pensionCostingFactors>();
      String treatiesQuery="BEGIN LMS_SETUPS_CURSOR.FindPensionCostFactors(?,?);END;";
      CallableStatement cst=null;
      
      try 
      {
        cst=conn.prepareCall(treatiesQuery);
        cst.setBigDecimal(1,(BigDecimal)session.getAttribute("ProductCode"));
        cst.registerOutParameter(2,OracleTypes.CURSOR);
       
        cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(2);
        while(rs.next())
        {
        pensionCostingFactors systems=new pensionCostingFactors();
            systems.setPcfsCode(rs.getBigDecimal(1));
            systems.setPcfsEsca(rs.getBigDecimal(2));
            systems.setPcfsInterest(rs.getBigDecimal(3));
            systems.setPcfsWithRate(rs.getBigDecimal(5));
            systems.setPcfsRateType(rs.getString(6));
            systems.setPcfsRateTypeDesc(rs.getString(7));
            systems.setPcfsDivFact(rs.getBigDecimal(8));
            
            
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
    
  public List<pensionCostingFactors> findPensionCostingFactorRates()
  
  {
    Connection conn=null;
    DBConnector connector=new DBConnector();
    conn=connector.getDatabaseConn();
    List<pensionCostingFactors> arrangementsList=new ArrayList<pensionCostingFactors>();
    String treatiesQuery="BEGIN LMS_SETUPS_CURSOR.find_pens_cost_fac_rates(?,?);END;";
    CallableStatement cst=null;
    try 
    {
      cst=conn.prepareCall(treatiesQuery);
      cst.registerOutParameter(1,OracleTypes.CURSOR);
      cst.setBigDecimal(2,(BigDecimal)session.getAttribute("PCFS_CODE"));
     
      cst.execute();
      ResultSet rs=(ResultSet)cst.getObject(1);
      while(rs.next())
      {
      pensionCostingFactors systems=new pensionCostingFactors();

          systems.setPCFR_CODE(rs.getBigDecimal(1));
          systems.setPCFR_TERM_FROM(rs.getBigDecimal(2));
          systems.setPCFR_TERM_TO(rs.getBigDecimal(3));
          systems.setPCFR_BENE_DISC_FACT(rs.getBigDecimal(4));
          systems.setPCFR_CONTR_FACT(rs.getBigDecimal(5));
     
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
  
    public List<pensionCostingFactors> findPensionContributionFactors()
    
    {
      Connection conn=null;
      DBConnector connector=new DBConnector();
      conn=connector.getDatabaseConn();
      List<pensionCostingFactors> arrangementsList=new ArrayList<pensionCostingFactors>();
      String treatiesQuery="BEGIN LMS_SETUPS_CURSOR.FindContributionFactors(?,?);END;";
      CallableStatement cst=null;
      try 
      {
        cst=conn.prepareCall(treatiesQuery);
        cst.setBigDecimal(1,(BigDecimal)session.getAttribute("ProductCode"));
        cst.registerOutParameter(2,OracleTypes.CURSOR);
       
        cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(2);
        while(rs.next())
        {
        pensionCostingFactors systems=new pensionCostingFactors();
            systems.setPeirCode(rs.getBigDecimal(1));
            systems.setPeirCntrTaxExempt(rs.getBigDecimal(2));
            systems.setPeirTaxExempt(rs.getBigDecimal(3));
            systems.setPeirMaxTaxExempt(rs.getBigDecimal(4));
            systems.setPeir_int_rate(rs.getBigDecimal(5));
            systems.setPeirTaxRelief(rs.getBigDecimal(6));
            systems.setPeirUndwConvFactor(rs.getBigDecimal(7));
            systems.setPeirDirConvFactor(rs.getBigDecimal(8));
            systems.setPeirFactorType(rs.getString(9));
            systems.setPeirFactorTypeDesc(rs.getString(10));
            systems.setPeirWef(rs.getDate(11));
            systems.setPeirWet(rs.getDate(12));
            systems.setPeir_empyr_lump_tax_exmpt(rs.getBigDecimal(13));
            
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
    public List<pensionCostingFactors> findRetirementAges()
    
    {
      Connection conn=null;
      DBConnector connector=new DBConnector();
      conn=connector.getDatabaseConn();
      List<pensionCostingFactors> arrangementsList=new ArrayList<pensionCostingFactors>();
      String treatiesQuery="BEGIN LMS_SETUPS_CURSOR.findRetireAges(?,?);END;";
      CallableStatement cst=null;
      try 
      {
        cst=conn.prepareCall(treatiesQuery);
        cst.setBigDecimal(1,(BigDecimal)session.getAttribute("ProductCode"));
        cst.registerOutParameter(2,OracleTypes.CURSOR);
       
        cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(2);
        while(rs.next())
        {
        pensionCostingFactors systems=new pensionCostingFactors();
            systems.setRetCode(rs.getBigDecimal(1));
            systems.setRetAge(rs.getBigDecimal(2));
            systems.setRetProdCode(rs.getBigDecimal(3));
            systems.setRetSex(rs.getString(4));
            systems.setRetSexDesc(rs.getString(5));
           
            
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
    public List<pensionCostingFactors> findEmvErRates()
    
    {
      Connection conn=null;
      DBConnector connector=new DBConnector();
      conn=connector.getDatabaseConn();
      List<pensionCostingFactors> arrangementsList=new ArrayList<pensionCostingFactors>();
      String treatiesQuery="BEGIN LMS_SETUPS_CURSOR.findEMVEmployerRates(?,?);END;";
      CallableStatement cst=null;
      try 
      {
        cst=conn.prepareCall(treatiesQuery);
        cst.setBigDecimal(1,(BigDecimal)session.getAttribute("RET_CODE"));
        cst.registerOutParameter(2,OracleTypes.CURSOR);
       
        cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(2);
        while(rs.next())
        {
        pensionCostingFactors systems=new pensionCostingFactors();
            systems.setEmverCode(rs.getBigDecimal(1));
            systems.setEmverAnb(rs.getBigDecimal(2));
            systems.setEmverBasicSa(rs.getBigDecimal(3));
            systems.setEmverBasicPrem(rs.getBigDecimal(4));
            systems.setEmverEmvValue(rs.getBigDecimal(5));
            systems.setEmverProdCode(rs.getBigDecimal(6));
            systems.setEmverRetCode(rs.getBigDecimal(7));
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
    public List<pensionCostingFactors> findEmvEERates()
    
    {
      Connection conn=null;
      DBConnector connector=new DBConnector();
      conn=connector.getDatabaseConn();
      List<pensionCostingFactors> arrangementsList=new ArrayList<pensionCostingFactors>();
      String treatiesQuery="BEGIN LMS_SETUPS_CURSOR.findEMVEmployeeRates(?,?);END;";
      CallableStatement cst=null;
      try 
      {
        cst=conn.prepareCall(treatiesQuery);
        cst.setBigDecimal(1,(BigDecimal)session.getAttribute("ProductCode"));
        cst.registerOutParameter(2,OracleTypes.CURSOR);
       
        cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(2);
        while(rs.next())
        {
        pensionCostingFactors systems=new pensionCostingFactors();
            systems.setEmveeCode(rs.getBigDecimal(1));
            systems.setEmveeTerm(rs.getBigDecimal(2));
            systems.setEmveeBasicPrem(rs.getBigDecimal(3));
            systems.setEmveeBasicSa(rs.getBigDecimal(4));
            systems.setEmveeEmv(rs.getBigDecimal(5));
            systems.setEmveeProdCode(rs.getBigDecimal(6));
            //systems.setEmverRetCode(rs.getBigDecimal(7));
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
    public List<pensionCostingFactors> findGratuityPensionrates()
    
    {
      Connection conn=null;
      DBConnector connector=new DBConnector();
      conn=connector.getDatabaseConn();
      List<pensionCostingFactors> arrangementsList=new ArrayList<pensionCostingFactors>();
      String treatiesQuery="BEGIN LMS_SETUPS_CURSOR.findGraPensionRates(?,?);END;";
      CallableStatement cst=null;
      try 
      {
        cst=conn.prepareCall(treatiesQuery);
        cst.setBigDecimal(1,(BigDecimal)session.getAttribute("ProductCode"));
        cst.registerOutParameter(2,OracleTypes.CURSOR);
       
        cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(2);
        while(rs.next())
        {
        pensionCostingFactors systems=new pensionCostingFactors();
            systems.setGrapCode(rs.getBigDecimal(1));
            systems.setGrapProdCode(rs.getBigDecimal(2));
            systems.setGrapServiceYrs(rs.getBigDecimal(3));
            systems.setGrapGratPct(rs.getBigDecimal(4));
            systems.setGrapPensionPct(rs.getBigDecimal(5));
           
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
    
  public List<pensionCostingFactors> findPensionVestingScales()

  {
    Connection conn=null;
    DBConnector connector=new DBConnector();
    conn=connector.getDatabaseConn();
    List<pensionCostingFactors> arrangementsList=new ArrayList<pensionCostingFactors>();
    String treatiesQuery="BEGIN LMS_SETUPS_CURSOR.findPensionVestingScales(?,?);END;";
    CallableStatement cst=null;
    
    try 
    {
      cst=conn.prepareCall(treatiesQuery);
      cst.setBigDecimal(1,(BigDecimal)session.getAttribute("ProductCode"));
      cst.registerOutParameter(2,OracleTypes.CURSOR);
     
      cst.execute();
      ResultSet rs=(ResultSet)cst.getObject(2);
      while(rs.next())
      {
      pensionCostingFactors systems=new pensionCostingFactors();

          systems.setPVGS_CODE(rs.getBigDecimal(1));
          systems.setPVGS_YRS_FROM(rs.getBigDecimal(2));
          systems.setPVGS_YRS_TO(rs.getBigDecimal(3));
          systems.setPVGS_EMYR_PCT_ENT(rs.getBigDecimal(4));
          systems.setPVGS_EMYE_PCT_ENT(rs.getBigDecimal(5));
          
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
  
    public List<pensionCostingFactors> findPensionCommutationFactors()

    {
      Connection conn=null;
      DBConnector connector=new DBConnector();
      conn=connector.getDatabaseConn();
      List<pensionCostingFactors> arrangementsList=new ArrayList<pensionCostingFactors>();
      String treatiesQuery="BEGIN LMS_SETUPS_CURSOR.getPensCommutation(?,?);END;";
      CallableStatement cst=null;
      
      try 
      {
        cst=conn.prepareCall(treatiesQuery);
        cst.registerOutParameter(1,OracleTypes.CURSOR);
        cst.setBigDecimal(2,(BigDecimal)session.getAttribute("ProductCode"));
        
       
        cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(1);
        while(rs.next())
        {
        pensionCostingFactors systems=new pensionCostingFactors();

            systems.setPCOM_CODE(rs.getBigDecimal(1));
            systems.setPCOM_RANGE_FROM(rs.getBigDecimal(2));
            systems.setPCOM_RANGE_TO(rs.getBigDecimal(3));
            systems.setPCOM_PERC(rs.getBigDecimal(4));
            
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
