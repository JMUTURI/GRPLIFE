package LMSG.view.ecm;

import LMSG.view.Base.GlobalCC;
import LMSG.view.connect.DBConnector;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DocumentProcessing {
    private RichCommandButton processBtn;

    public DocumentProcessing() {
        super();
        
    }
   
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    String runDateParam = GlobalCC.findSysParam("DMS_RUN_DATE",null);
    
  public String processDoc(String trans) {
    
      ReportEngine rpt = new ReportEngine();
         
         DBConnector datahandler = new DBConnector();
         Connection conn;
         conn = datahandler.getDatabaseConn();
         String hrQuery3 =
             "begin LMS_WEB_PKG.Process_Dms_Docs(?,?); end;";
         CallableStatement callStmt3 = null;
         try {
             callStmt3 = conn.prepareCall(hrQuery3);

             callStmt3.registerOutParameter(1, OracleTypes.CURSOR);
             callStmt3.setString(2, trans);
             callStmt3.execute();
             ResultSet rs = (ResultSet)callStmt3.getObject(1);
             
             while(rs.next()){
                 System.out.println("processing docs here!");
                 session.setAttribute("docName",rs.getString(2));
                 session.setAttribute("transTypeSht",rs.getString(3));
                 session.setAttribute("transType",rs.getString(4));
                 rpt.reportOne(rs.getBigDecimal(1));
                 
             }
             
             callStmt3.close();
             conn.close();
         } catch (Exception e) {
             e.printStackTrace();
         }
       finally {
           try {
             callStmt3.close();
             conn.close();  
           }
           catch(Exception e) {
             GlobalCC.EXCEPTIONREPORTING(conn, e);
           }
          
       }
     
      System.out.println("we finish policy proceessing here");
    
      return null;
  }
    
    
    
    public String getAllActiveEndorsements() {
        String workingDir = System.getProperty("user.dir");
        String workingOS = System.getProperty("os.name");
        session.setAttribute("workingDir",workingDir);
        session.setAttribute("workingOS",workingOS);
          System.out.println("Getting active endorsements!");    
           
           DBConnector datahandler = new DBConnector();
           Connection conn;
           
           conn = datahandler.getDatabaseConn();
           String hrQuery3 =
               "begin LMS_WEB_PKG.getAuthorisedTransactions(?,?,?); end;";
           CallableStatement callStmt3 = null;
           try {
               callStmt3 = conn.prepareCall(hrQuery3);

               callStmt3.registerOutParameter(1, OracleTypes.CURSOR);
               callStmt3.setDate(2,  extractSQLDate(runDateParam));
               callStmt3.setBigDecimal(3, (BigDecimal)session.getAttribute("endorsementCode"));
               System.out.println("Endorsement Code Processing " + String.valueOf(session.getAttribute("endorsementCode")));
               callStmt3.execute();
               ResultSet rs = (ResultSet)callStmt3.getObject(1);
               while(rs.next()){
                   
                   System.out.println("Fetching All Endorsements!");
                   session.setAttribute("endorsementCode",rs.getBigDecimal(1));
                   session.setAttribute("polNo",rs.getString(2));
                   session.setAttribute("endrNo",rs.getString(3));
                   processDoc("UW_GRP");
                   //updateTransaction();
               }
             GlobalCC.sysInformation("Documents Generated Successfully! ");
               callStmt3.close();
               conn.close();
           } catch (Exception e) {
               e.printStackTrace();
             GlobalCC.EXCEPTIONREPORTING(conn, e);
           }
         finally {
             try {
               callStmt3.close();
               conn.close();  
             }
             catch(Exception e) {
               GlobalCC.EXCEPTIONREPORTING(conn, e);
             }
            
         }
        return null;
    }
        
        
    public String updateTransaction(){
           
           DBConnector datahandler = new DBConnector();
           Connection conn;
           conn = datahandler.getDatabaseConn();
           
           String hrQuery3 =
               "begin LMS_WEB_PKG.updateProcessedDMSTransactions(?,?); end;";
           CallableStatement callStmt3 = null;
           
           try {
               callStmt3 = conn.prepareCall(hrQuery3);

               callStmt3.setBigDecimal(1, (BigDecimal)session.getAttribute("endorsementCode"));
               callStmt3.setString(2, (String)session.getAttribute("transTypeSht"));
               callStmt3.execute();
               callStmt3.close();
               conn.close();
           } catch (Exception e) {
               e.printStackTrace();
           }
         finally {
             try {
               callStmt3.close();
               conn.close();  
             }
             catch(Exception e) {
               GlobalCC.EXCEPTIONREPORTING(conn, e);
             }
            
         }
          
        System.out.println("Transaction updated!");
        return null;
    }
     
  public String getClaimTransactions() {
          
          String workingDir = System.getProperty("user.dir");
          String workingOS = System.getProperty("os.name");
          session.setAttribute("workingDir",workingDir);
          session.setAttribute("workingOS",workingOS);
          System.out.println("Checking all claims transactions!");
         
          DBConnector datahandler = new DBConnector();
          Connection conn;
          conn = datahandler.getDatabaseConn();
          String clmno = null;
          if (session.getAttribute("claimNumber")==null){
              clmno = (String)session.getAttribute("ClaimNo");
          } else {               
            clmno = (String)session.getAttribute("claimNumber");
          }
         String hrQuery3 =
             "begin LMS_WEB_PKG.getAuthorisedTransactions(?,?,?,?); end;";
                    
         CallableStatement callStmt3 = null;
         
         try {
             callStmt3 = conn.prepareCall(hrQuery3);
             callStmt3.registerOutParameter(1, OracleTypes.CURSOR);
             callStmt3.setDate(2, extractSQLDate(runDateParam));
             callStmt3.setString(3, null);
             callStmt3.setString(4,clmno);
             callStmt3.execute();
             ResultSet rs = (ResultSet)callStmt3.getObject(1);
            System.out.println("Before processing! " + clmno);
            //processDoc("CLM_GRP");
             while(rs.next()){
                 System.out.println("Fetching All Claims!");
                 //session.setAttribute("endorsementCode",rs.getBigDecimal(1));
                 session.setAttribute("polNo",rs.getString(2));
                 session.setAttribute("endrNo",rs.getString(3));
                 processDoc("CLM_GRP");
                // updateOtherTransactions("CLM");
             }
             GlobalCC.sysInformation("Documents Generated Successfully! ");
             callStmt3.close();
             conn.close();
         } catch (Exception e) {
             e.printStackTrace();
             GlobalCC.EXCEPTIONREPORTING(conn, e);
         }
       finally {
           try {
             callStmt3.close();
             conn.close();  
           }
           catch(Exception e) {
             GlobalCC.EXCEPTIONREPORTING(conn, e);
           }
          
       }
      
      return null;
  }
        
    public void setProcessBtn(RichCommandButton processBtn) {
        this.processBtn = processBtn;
    }
    
    

    public RichCommandButton getProcessBtn() {
        return processBtn;
    }


  public static java.sql.Date extractSQLDate(String component) {

           Date dateString2;
           dateString2 = null;
           SimpleDateFormat sdf1;
           if (component == null || String.valueOf(component).equalsIgnoreCase("null"))
                   return null;
           try {
                   System.out.println("DATE: " + component + " ..length " + component.length());
                   if (component.length() > 15) {
                           sdf1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
                   } else if (component.contains("/") && component.length() == 11){
                           sdf1 = new SimpleDateFormat("dd/MMM/yyyy");
                   }
                   else if (component.contains("/")){
                           sdf1 = new SimpleDateFormat("dd/MM/yyyy");
                   }
                   else{
                           sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                   }
                           dateString2 = sdf1.parse(component);
           } catch (Exception e) {
                   //GlobalCC.EXCEPTIONREPORTING(null, e);
                   return null;
           }
           return new java.sql.Date(dateString2.getTime());
   }
  

}
