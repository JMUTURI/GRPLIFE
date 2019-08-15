package LMSG.view.Policy;

import LMSG.view.Base.GlobalCC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.jdbc.internal.OracleTypes;

import LMSG.view.Base.LOVCC;

import LMSG.view.QuotationProcessing.occupations;

import LMSG.view.connect.DBConnector;

import LMSG.view.connect.DBConnector;

public class checkOffAgentsDAO extends LOVCC {
  public checkOffAgentsDAO() 
  {
  }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  public List<checkOffAgents> FindCheckOffAgents() {
     DBConnector myConn=new DBConnector();
    Connection conn=myConn.getDatabaseConn();
    CallableStatement cst=null;
    List<checkOffAgents> AgentsList=new ArrayList<checkOffAgents>();
    
    try
      
    {
      
      String AgentsQuery="begin LMS_WEB_CURSOR_GRP.FindCheckOffAgents(?,?);end;";
      cst=conn.prepareCall(AgentsQuery);
      cst.registerOutParameter(1,OracleTypes.CURSOR);
    String endrPay = (String)session.getAttribute("endrPayMethd");
      if(endrPay==null) 
      {
        FacesContext.getCurrentInstance().addMessage(null, 
                                                                            new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                                             "Reinsurance Process Successfully Done", 
                                                                                          "Please Select payment Method"));
      }
      else
      {
        cst.setString(2,(String)session.getAttribute("endrPayMethd"));
        System.out.println((String)session.getAttribute("endrPayMethd"));
      }
      cst.execute();
      ResultSet rs=(ResultSet)cst.getObject(1);
      while(rs.next()) 
      {
        checkOffAgents myTrans=new checkOffAgents();
        myTrans.setAGN_CODE(rs.getBigDecimal(1));
        myTrans.setAGN_NAME(rs.getString(2));
        myTrans.setAGN_SHT_DESC(rs.getString(3));
        myTrans.setAGN_AGENT_COMMISSION(rs.getBigDecimal(4));
        myTrans.setAGN_AGENT_WHT_TAX(rs.getBigDecimal(5));
        AgentsList.add(myTrans);
      }
      rs.close();
      cst.close();
        conn.close();    
    }
    catch(Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return AgentsList;
  }
}
