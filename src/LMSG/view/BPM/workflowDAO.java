package LMSG.view.BPM;


import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.jdbc.OracleTypes;

import org.jbpm.api.task.Task;

import LMSG.view.Base.GlobalCC;
import LMSG.view.Base.LOVCC;


import LMSG.view.connect.DBConnector;


public class workflowDAO extends LOVCC {
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    
    public List<workflow> findTickets() 
    {
        List<Task> Tasks=new ArrayList<Task>();
        List<workflow> wflow =new ArrayList<workflow>();
      try 
      { 
          wfEngine wf = new wfEngine();
          Tasks = wf.getTaskList((String)session.getAttribute("Username"));
          
          int i = 0;
          for (Iterator iter = Tasks.iterator(); iter.hasNext();) {
              Task task = Tasks.get(i);
              workflow newTasks = new workflow();
 
              newTasks.setTaskID(task.getId());
              newTasks.setTaskActivityName(task.getActivityName());
              newTasks.setTaskAssignee(task.getAssignee());
              newTasks.setTaskDuedate(task.getDuedate());
              newTasks.setTaskCreateDate(task.getCreateTime());
     
              wflow.add(newTasks);

              iter.next();
              i++;
          }


      }
      catch(Exception e) 
      {
            GlobalCC.EXCEPTIONREPORTING(null,e);
      }
      return wflow;
    }
    
    public List<workflow> findTicketDetails() {
        
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<workflow> msgTemplates = new ArrayList<workflow>();
        ResultSet rs = null;
        try {
           
            String msgQuery = 
            "begin ? := TQC_WEB_PKG.get_tckt_dtls(?); end;";
            cst = conn.prepareCall(msgQuery);
                      
            cst.registerOutParameter(1, 
                                     OracleTypes.CURSOR);
            cst.setString(2,(String)session.getAttribute("TaskID"));
            cst.execute();
            rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                workflow newTasks = new workflow();

                newTasks.setTCKT_CODE(rs.getBigDecimal(1));
                newTasks.setUSRSYSTEM(rs.getString(2));
                newTasks.setSYSMODULE(rs.getString(3));
                //LOVCC.CurrentStatus = rs.getString(16);
                session.setAttribute("CurrentStatus", rs.getString(16));
                newTasks.setTCKT_CLNT_CODE(rs.getBigDecimal(4));
                session.setAttribute("ClientCode", rs.getBigDecimal(4));
                newTasks.setCLIENT(rs.getString(5));
                newTasks.setTCKT_AGN_CODE(rs.getBigDecimal(6));
                session.setAttribute("agnCode", rs.getBigDecimal(6)); //LOVCC.agnCode = rs.getBigDecimal(6);
                newTasks.setAGENT(rs.getString(7));
                newTasks.setTCKT_POL_CODE(rs.getBigDecimal(8));
                //LOVCC.policyCode = rs.getBigDecimal(8);
                session.setAttribute("policyCode", rs.getBigDecimal(8));
                newTasks.setTCKT_POL_NO(rs.getString(9));
                //LOVCC.policyNumber = rs.getString(9);
                session.setAttribute("policyNumber", rs.getString(9));
                session.setAttribute("PolicyNumberSel", rs.getString(9));
                //LOVCC.PolicyNumberSel = rs.getString(9);
                newTasks.setTCKT_CLM_NO(rs.getString(10));
                session.setAttribute("ClaimNo", rs.getString(10));
                newTasks.setTCKT_QUOT_CODE(rs.getBigDecimal(11));
                //LOVCC.QuoteCode = rs.getBigDecimal(11);
                //session.getAttribute("QuoteCode")
                session.setAttribute("QuoteCode", rs.getBigDecimal(11));
                //Quotation.quotationCode = rs.getInt(11);
                newTasks.setQUO_NO(rs.getString(12));
                //LOVCC.QuotationNo = rs.getString(12);
                session.setAttribute("QuotationNo", rs.getString(12));
                newTasks.setTCKT_BY(rs.getString(13));
                session.setAttribute("TicketFrom", rs.getString(13));
                newTasks.setTCKT_DATE(rs.getDate(14));
                newTasks.setTCKT_PROCESS_ID(rs.getString(15));
                //LOVCC.workflowID = rs.getString(15);
                session.setAttribute("workflowID", rs.getString(15));
                newTasks.setTCKT_ENDR_CODE(rs.getBigDecimal(17));
                //LOVCC.endorsementCode = rs.getBigDecimal(17);
                session.setAttribute("endorsementCode", rs.getBigDecimal(17));
                newTasks.setTCKT_PROD_TYPE(rs.getString(18));
                //LOVCC.productType = rs.getString(18);
                session.setAttribute("productType", rs.getString(18));
                newTasks.setTCKT_TO(rs.getString(19));
                newTasks.setTCKT_REMARKS(rs.getString(20));
                newTasks.setTCKT_ENDORSEMENT(rs.getString(23));
                //LOVCC.Endorsement = rs.getString(23);
                session.setAttribute("Endorsement", rs.getString(23));
                session.setAttribute("transactionNumber", rs.getBigDecimal(24));
                System.out.println(session.getAttribute("transactionNumber"));
                newTasks.setTCKT_REF_NO(rs.getString(25));
                session.setAttribute("prpCode", rs.getBigDecimal(26));

                
                msgTemplates.add(newTasks);
            }
            rs.close();
            cst.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }finally{
        GlobalCC.CloseConnections(rs, cst, conn);
        }             
      
        return msgTemplates;
    }
    
    public List<workflow> findTicketAssignee() {
        
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<workflow> msgTemplates = new ArrayList<workflow>();
        ResultSet rs = null;
        
        try {
           
            String msgQuery = 
            "begin ? := Tqc_Interfaces_Pkg.get_task_assignee(?,?,?,?,?,?,?,?); end;";
            cst = conn.prepareCall(msgQuery);
                      
            cst.registerOutParameter(1, 
                                     OracleTypes.CURSOR);
            cst.setInt(2, (Integer)session.getAttribute("sysCode"));
            cst.setString(3, (String)session.getAttribute("ProcessShtDesc"));
            cst.setString(4, (String)session.getAttribute("ProcessAreaShtDesc"));
            cst.setString(5, (String)session.getAttribute("ProcessSubAShtDesc"));
            cst.setString(6, (String)session.getAttribute("SumAssured"));
            cst.setString(7, (String)session.getAttribute("DebitCredit"));
            cst.registerOutParameter(8, 
                                     OracleTypes.NUMBER);
            cst.registerOutParameter(9, 
                                     OracleTypes.VARCHAR);
            cst.execute();
            //TaskAssigneeID = cst.getBigDecimal(8);
            //TaskAssignee = cst.getString(9);
            session.setAttribute("TaskAssigneeID", cst.getBigDecimal(8));
            session.setAttribute("TaskAssignee", cst.getString(9));
            
            BigDecimal TaskAssID = (BigDecimal)session.getAttribute("TaskAssigneeID");
        if (TaskAssID == null){
            rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                workflow newTasks = new workflow();
                newTasks.setTaskUserID(rs.getBigDecimal(1));
                newTasks.setTaskUserShtDesc(rs.getString(2));
                newTasks.setTaskUserDesc(rs.getString(3));
                session.setAttribute("NextTaskAssignee", "Y");

                msgTemplates.add(newTasks);
            }
            rs.close();
            }
            cst.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }finally{
          GlobalCC.CloseConnections(rs, cst, conn);
        }             
      
        return msgTemplates;
    }
    
    public List<workflow> findTicketDetailsByUser() {
        
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();
        CallableStatement cst = null;
        List<workflow> msgTemplates = new ArrayList<workflow>();
        ResultSet rs = null;
        try {
           
            String msgQuery = 
            "begin ? := TQC_WEB_PKG.get_tckt_dtls_by_usr_life(?,?,?,?,?); end;";
            cst = conn.prepareCall(msgQuery);
                      
            cst.registerOutParameter(1, 
                                     OracleTypes.CURSOR);
            String Assig = (String)session.getAttribute("UserSelected");
            if(Assig == null){
            cst.setString(2,(String)session.getAttribute("Username"));   
            }else{
            cst.setString(2,(String)session.getAttribute("UserSelected"));
            }
            cst.setBigDecimal(3,(BigDecimal)session.getAttribute("QuoteCode"));
            cst.setBigDecimal(4,(BigDecimal)session.getAttribute("policyCode"));
            cst.setString(5,(String)session.getAttribute("ClaimNo"));
            cst.setInt(6, (Integer)session.getAttribute("sysCode"));
           //System.out.println("policyCode="+session.getAttribute("policyCode")+"\n"+"SysCode"+session.getAttribute("sysCode"));
            cst.execute();
             rs = (ResultSet)cst.getObject(1);                     
            while (rs.next()) {
                //System.out.println("here...");
                workflow newTasks = new workflow();                
                newTasks.setTCKT_CODE(rs.getBigDecimal(1));                
                newTasks.setTCKT_CDE(rs.getString(1));
                newTasks.setUSRSYSTEM(rs.getString(2));
                newTasks.setSYSMODULE(rs.getString(3));
                //LOVCC.CurrentStatus = rs.getString(16);
                newTasks.setTCKT_CLNT_CODE(rs.getBigDecimal(4));
                //LOVCC.prpCode = rs.getBigDecimal(4);
                newTasks.setCLIENT(rs.getString(5));
                newTasks.setTCKT_AGN_CODE(rs.getBigDecimal(6));
                //LOVCC.agnCode = rs.getBigDecimal(6);
                newTasks.setAGENT(rs.getString(7));
                newTasks.setTCKT_POL_CODE(rs.getBigDecimal(8));
                //LOVCC.policyCode = rs.getBigDecimal(8);
                newTasks.setTCKT_POL_NO(rs.getString(9));
                //LOVCC.policyNumber = rs.getString(9);
                //LOVCC.PolicyNumberSel = rs.getString(9);
                newTasks.setTCKT_CLM_NO(rs.getString(10));
                newTasks.setTCKT_QUOT_CODE(rs.getBigDecimal(11));
                //LOVCC.QuoteCode = rs.getBigDecimal(11);
                //Quotation.quotationCode = rs.getInt(11);
                newTasks.setQUO_NO(rs.getString(12));
                //LOVCC.QuotationNo = rs.getString(12);
                newTasks.setTCKT_BY(rs.getString(13));
                //session.setAttribute("TicketFrom", rs.getString(13));
                newTasks.setTCKT_DATE(rs.getDate(14));
                newTasks.setTCKT_PROCESS_ID(rs.getString(15));
                //LOVCC.workflowID = rs.getString(15);
                newTasks.setTCKT_ENDR_CODE(rs.getBigDecimal(17));
                //LOVCC.endorsementCode = rs.getBigDecimal(17);
                newTasks.setTCKT_PROD_TYPE(rs.getString(18));
                //LOVCC.productType = rs.getString(18);
                newTasks.setTCKT_TO(rs.getString(19));
                newTasks.setTCKT_REMARKS(rs.getString(20));
                newTasks.setTCKT_NAME(rs.getString(21));
                newTasks.setTCKT_DUE_DATE(rs.getDate(22));
                newTasks.setTCKT_ENDORSEMENT(rs.getString(23));
                session.setAttribute("ModuleTickets", "Y");
                newTasks.setTCKT_REF_NO(rs.getString(25));
                msgTemplates.add(newTasks);
                
              
            } // close connection to db,resultset and callable statement
            rs.close();
            cst.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
            e.printStackTrace();
        }finally{
        GlobalCC.CloseConnections(rs, cst, conn);
        }            
      
        return msgTemplates;
    }
    
}
