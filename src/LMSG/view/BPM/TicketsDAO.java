package LMSG.view.BPM;

import LMSG.view.Base.GlobalCC;
import LMSG.view.Quotation.Quotations;

import LMSG.view.connect.DBConnector;

import br.com.technique.process.render.graph.JpdlModel;

import java.io.FileInputStream;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.Map;

import javax.faces.context.FacesContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import oracle.jdbc.OracleTypes;

import br.com.technique.process.render.graph.Node;

public class TicketsDAO {
    public TicketsDAO() {
        super();
    }
  HttpSession session =
      (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  
  public List<Tickets> findQuotation()
  {
    DBConnector myConn=new DBConnector();
    Connection conn=myConn.getDatabaseConn();
    CallableStatement cst=null;
    List<Tickets> myTickets = new ArrayList<Tickets>();
   
    try {
      String quotQuery="begin LMS_WEB_CURSOR_GRP.get_all_quotations(?,?);end;";
      cst=conn.prepareCall(quotQuery);
      cst.registerOutParameter(1,OracleTypes.CURSOR);
      cst.setBigDecimal(2,(BigDecimal)session.getAttribute("ProductCode"));

      cst.execute();
      ResultSet rs=(ResultSet)cst.getObject(1);
        while(rs.next()) {
          Tickets myQuot=new Tickets();
          myQuot.setClient(rs.getString(1));
          myQuot.setQuoCode(rs.getBigDecimal(2));
          myQuot.setQuoNo(rs.getString(3));
          myQuot.setQUO_EFFECTIVE_DATE(rs.getDate(13));
          myTickets.add(myQuot);
        }
      }
      catch(Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
      }
    return myTickets;
  }
  
  public List<Tickets> findPolicyTransactions()
  {
    DBConnector myConn=new DBConnector();
    Connection conn=myConn.getDatabaseConn();
    CallableStatement cst=null;
    List<Tickets> myTickets = new ArrayList<Tickets>();
   
    try {
      String quotQuery="begin LMS_WEB_CURSOR_GRP.find_policy_transactions(?,?,?);end;";
      cst=conn.prepareCall(quotQuery);
      cst.registerOutParameter(1,OracleTypes.CURSOR);
      cst.setString(2,(String)session.getAttribute("TicketModule"));
      cst.setBigDecimal(3,(BigDecimal)session.getAttribute("ProductCode"));

      cst.execute();
      ResultSet rs=(ResultSet)cst.getObject(1);
        while(rs.next()) {
          Tickets myQuot=new Tickets();
            
          myQuot.setENDR_CODE(rs.getBigDecimal(1));
          myQuot.setENDR_POL_CODE(rs.getBigDecimal(2));
          myQuot.setENDR_POL_POLICY_NO(rs.getString(3));
          myQuot.setBTR_TRANS_TYPE(rs.getString(4));
          myQuot.setENDR_EFFECTIVE_DATE(rs.getDate(5));
          myQuot.setCLIENT(rs.getString(6));
          myQuot.setBTR_TRANS_CODE(rs.getString(7));
          myQuot.setPRP_CLNT_CODE(rs.getBigDecimal(8));
          myQuot.setENDR_LTR_TRANS_NO(rs.getBigDecimal(9));
          myQuot.setPOL_PROD_TYPE(rs.getString(10));
          
          myTickets.add(myQuot);
        }
      }
      catch(Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
      }
    return myTickets;
  }
  
  public  List<Tickets> ReadJPDLXml(){
      List<Tickets> msgTemplates = new ArrayList<Tickets>();
     
    try{
      ServletContext sc =
          (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
        String Mypath = null;
     
        String Module = (String)session.getAttribute("TicketModule");
        if(Module.equalsIgnoreCase("Q")){
          Mypath = sc.getRealPath("/images/JPDL/testquote3.jpdl.xml");
        }else if(Module.equalsIgnoreCase("P")){
          Mypath = sc.getRealPath("/images/JPDL/UnderwriteProcess.jpdl.xml");
        }else if(Module.equalsIgnoreCase("E")){
          Mypath = sc.getRealPath("/images/JPDL/EndorsementsProcess.jpdl.xml");
        }else if(Module.equalsIgnoreCase("C")){
          Mypath = sc.getRealPath("/images/JPDL/ClaimsProcessingGroup.jpdl.xml");
        }
      System.out.println("path "+Mypath);
      FileInputStream Test = new FileInputStream(Mypath);
      JpdlModel jpdlModel = new JpdlModel (Test);
     
      Map<String, Node> nodes = jpdlModel.getNodes(); 
     
      for (Node node : nodes.values()) { 
        String name = node.getName(); 
          if (name==null){
           
          }else{
            String Type = node.getType().toString();
              if(Type.equalsIgnoreCase("Task")){
                Tickets newTasks = new Tickets();
                newTasks.setTaskName(name);
                msgTemplates.add(newTasks);
              }
          }
      }
     
      }catch(Exception e){
        GlobalCC.EXCEPTIONREPORTING(null, e);
        e.printStackTrace();
      }
      return msgTemplates;
    } 
}
