package LMSG.view.Medicals;

import LMSG.view.Base.GlobalCC;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.jdbc.OracleTypes;

import LMSG.view.Base.LOVCC;

import LMSG.view.connect.DBConnector;

public class medicalsDAO extends LOVCC {
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false); 
    public List<medical> FindMedicalGroups() {
        int cnt = 0;
        DBConnector myConn=new DBConnector();
       Connection conn=myConn.getDatabaseConn();
       CallableStatement cst=null;
       
       List<medical> MedList=new ArrayList<medical>();

       try {
         String polQuery="begin LMS_WEB_CURSOR_GRP.FindmedicalsGroup(?,?,?,?);end;";
         cst=conn.prepareCall(polQuery);
         cst.registerOutParameter(1,OracleTypes.CURSOR);
         cst.setBigDecimal(2,(BigDecimal)session.getAttribute("PolmMemCode"));
         cst.setBigDecimal(3, (BigDecimal)session.getAttribute("policyCode"));
         cst.setBigDecimal(4, (BigDecimal)session.getAttribute("PolmCode"));
        
         cst.execute();
         ResultSet rst=(ResultSet)cst.getObject(1);
         while(rst.next()){
             cnt++;
           medical myMeds=new medical();

           myMeds.setCMI_CODE(rst.getString(1));
           session.setAttribute("CMICode", rst.getString(1));
           myMeds.setCMI_PRP_CODE(rst.getString(2));
           myMeds.setCMI_ID_NO(rst.getString(4));
           myMeds.setMTG_SHT_DESC(rst.getString(5));
           myMeds.setMTG_DESC(rst.getString(6));  
           myMeds.setPOLM_MED_TOT_SA(rst.getBigDecimal(7)); 
           myMeds.setMemName(rst.getString(8));
           MedList.add(myMeds);
          
         }
         rst.close();
         cst.close();
          conn.close();
         
       }
       catch(Exception e) {
         GlobalCC.EXCEPTIONREPORTING(conn, e);
       }
       return MedList;
     }
    
    public List<medical> FindMedQuestionnaires() {
        int cnt = 0;
        DBConnector myConn=new DBConnector();
       Connection conn=myConn.getDatabaseConn();
       CallableStatement cst=null;
       
       List<medical> MedList=new ArrayList<medical>();
  
       try {
         String polMeds="begin LMS_WEB_CURSOR_GRP.Get_Medical_Questionnaires(?);end;";
         cst=conn.prepareCall(polMeds);
         cst.registerOutParameter(1,OracleTypes.CURSOR);     
         cst.execute();
         ResultSet rst=(ResultSet)cst.getObject(1);
         while(rst.next()){
             cnt++;
           medical myMeds=new medical();
           myMeds.setMedqCode(rst.getBigDecimal(1));
           myMeds.setMedqDesc(rst.getString(2));
           MedList.add(myMeds);
         }
         rst.close();
         cst.close();
         conn.close();
         
       }
       catch(Exception e) {
         GlobalCC.EXCEPTIONREPORTING(conn, e);
       }
       return MedList;
    }
    
    public List<medical> FindExistingPoliciesView() {
        DBConnector myConn=new DBConnector();
       Connection conn=myConn.getDatabaseConn();
       CallableStatement cst=null;
       
       List<medical> MedList=new ArrayList<medical>();
       
      
       try {
         String polQuery="begin LMS_WEB_CURSOR_GRP.FindExistingPolVw(?,?);end;";
         cst=conn.prepareCall(polQuery);
         cst.registerOutParameter(1,OracleTypes.CURSOR);
         cst.setBigDecimal(2,(BigDecimal)session.getAttribute("PolmMemCode")); 
        
         cst.execute();
         ResultSet rst=(ResultSet)cst.getObject(1);
         while(rst.next()){
             medical myMeds=new medical();

           myMeds.setPROPOSAL_NO(rst.getString(1));
           myMeds.setPOLICY_NO(rst.getString(2));
           myMeds.setTOT_SA(rst.getBigDecimal(3));
          
           MedList.add(myMeds);
          
         }
         rst.close();
         cst.close();
         conn.close();
         
       }
       catch(Exception e) {
         GlobalCC.EXCEPTIONREPORTING(conn, e);
       }
       return MedList;
     }
    
    public List<medical> FindClientMedicals() {
        DBConnector myConn=new DBConnector();
       Connection conn=myConn.getDatabaseConn();
       CallableStatement cst=null;
       
       List<medical> MedList=new ArrayList<medical>();
       
      
       try {
         String polQuery="begin LMS_WEB_CURSOR_GRP.FindclientMedicals(?,?);end;";
         cst=conn.prepareCall(polQuery);
         cst.registerOutParameter(1,OracleTypes.CURSOR);
         cst.setBigDecimal(2,(BigDecimal)session.getAttribute("PolmMemCode"));
        
         cst.execute();
         ResultSet rst=(ResultSet)cst.getObject(1);
         while(rst.next()){
             medical myMeds=new medical();

           myMeds.setCML_CODE(rst.getBigDecimal(1));
           myMeds.setCML_LIMIT_AMT(rst.getBigDecimal(2));
           myMeds.setCML_REQUEST_DATE(rst.getDate(3));
           myMeds.setSPR_NAME(rst.getString(4));
          myMeds.setCML_CLAIM_AMT(rst.getString(5));
          myMeds.setCML_PAYABLE_AMT(rst.getString(6));
          myMeds.setCML_RECEIVED(rst.getString(7));
           myMeds.setCML_DATE_RECEIVED(rst.getDate(8));
           myMeds.setCML_INVCE_DATE(rst.getDate(9));
           myMeds.setCML_INVCE_NO(rst.getString(10));
          myMeds.setCML_CHEQUE_NO(rst.getString(11));
          myMeds.setCML_CHEQUE_DATE(rst.getDate(12));
          myMeds.setCML_MED_LOADING(rst.getString(13));
          myMeds.setPOL_PROPOSAL_NO(rst.getString(14));
          myMeds.setCML_REMARKS(rst.getString(15));
          myMeds.setMTL_DESC(rst.getString(16));
          myMeds.setCML_RESULT_DATE(rst.getDate(17));
          myMeds.setMedDetails(rst.getString(18));
          MedList.add(myMeds);
          
         }
         rst.close();
         cst.close();
         conn.close();
         
       }
       catch(Exception e) {
         GlobalCC.EXCEPTIONREPORTING(conn, e);
       }
       return MedList;
     }
    
  public List<medical> FindMedicalPolicies() {
      DBConnector myConn=new DBConnector();
     Connection conn=myConn.getDatabaseConn();
     CallableStatement cst=null;
     
     List<medical> MedList=new ArrayList<medical>();
     
    
     try {
       String polQuery="begin LMS_WEB_CURSOR_GRP.find_medical_policies(?);end;";
       cst=conn.prepareCall(polQuery);
       cst.registerOutParameter(1,OracleTypes.CURSOR);
      
       cst.execute();
       ResultSet rst=(ResultSet)cst.getObject(1);
       while(rst.next()){
           medical myMeds=new medical();

         myMeds.setPol_code(rst.getBigDecimal(1));
         myMeds.setPol_policy_no(rst.getString(2));
         myMeds.setPol_current_endr_code(rst.getBigDecimal(3));
         myMeds.setClient(rst.getString(4));
      
        
         MedList.add(myMeds);
        
       }
       rst.close();
       cst.close();
       conn.close();
       
     }
     catch(Exception e) {
       GlobalCC.EXCEPTIONREPORTING(conn, e);
     }
     return MedList;
   }
  
  public List<medical> findMedTest() {

      DBConnector datahandler = null;
      DBConnector myConn=new DBConnector();
      datahandler = new DBConnector();
      Connection conn=myConn.getDatabaseConn();

      CallableStatement cst = null;
      List<medical> MedList = new ArrayList<medical>();
      try {

          String medicalQuery = "begin LMS_WEB_CURSOR.Medtest(?,?); end;";
          cst = conn.prepareCall(medicalQuery);

          //register out
          cst.registerOutParameter(1, OracleTypes.CURSOR);
          cst.setString(2,(String)session.getAttribute("CMICode")); //cmi code
          cst.execute();
          ResultSet rs=(ResultSet)cst.getObject(1);
          while (rs.next()) {
              medical myMeds = new medical();
              myMeds.setMedicalTestDescription(rs.getString(1));
              myMeds.setMTLCode(rs.getBigDecimal(2));
              myMeds.setMTLFees(rs.getBigDecimal(3));
              MedList.add(myMeds);
          }

          rs.close();
          cst.close();
          conn.close();

      } catch (Exception e) {
          GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
      return MedList;
  }
    
  public List<medical> FindPolicyMemberMedicals() {
      DBConnector myConn=new DBConnector();
     Connection conn=myConn.getDatabaseConn();
     CallableStatement cst=null;
     
     List<medical> MedList=new ArrayList<medical>();
     
    
     try {
       String polQuery="begin LMS_WEB_CURSOR_GRP.findpol_mem_medicals(?,?,?,?,?);end;";
       cst=conn.prepareCall(polQuery);
       cst.registerOutParameter(1,OracleTypes.CURSOR);
       cst.setBigDecimal(2,(BigDecimal)session.getAttribute("policyCode"));
       cst.setString(3, (String)this.session.getAttribute("srchMemNo"));
       cst.setString(4, (String)this.session.getAttribute("srchMemName"));
       cst.setInt(5, GlobalCC.RowsLimit);
      
       cst.execute();
       ResultSet rst=(ResultSet)cst.getObject(1);
         
         int i = 0;
         session.setAttribute("limitExceeded", "N");
       while(rst.next()){
           medical myMeds=new medical();

         myMeds.setPOLM_CODE(rst.getBigDecimal(1));
         myMeds.setMEM_CODE(rst.getBigDecimal(2));
         myMeds.setMEM_NO(rst.getString(3));
         myMeds.setMEM_NAME(rst.getString(4));
           
           i++;
             if(i >= GlobalCC.RowsLimit){
                 session.setAttribute("limitExceeded", "Y");
             }
      
        
         MedList.add(myMeds);
        
       }
       rst.close();
       cst.close();
       conn.close();
       
     }
     catch(Exception e) {
       GlobalCC.EXCEPTIONREPORTING(conn, e);
     }
     return MedList;
   }
    
    public List<medical> FindFacilitatorsView() {
        DBConnector myConn=new DBConnector();
       Connection conn=myConn.getDatabaseConn();
       CallableStatement cst=null;
       
       List<medical> MedList=new ArrayList<medical>();
       
      
       try {
         String polQuery="begin LMS_WEB_CURSOR_GRP.FindmedicalFacVw(?,?);end;";
         cst=conn.prepareCall(polQuery);
         cst.registerOutParameter(1,OracleTypes.CURSOR);
         cst.setString(2,(String)session.getAttribute("CMICode")); //cmi code
        
         cst.execute();
         ResultSet rst=(ResultSet)cst.getObject(1);
         while(rst.next()){
             medical myMeds=new medical();

           myMeds.setFC_SPR_NAME(rst.getString(1));
           myMeds.setFC_LIMIT_AMT(rst.getString(2));
           myMeds.setFC_CLAIM_AMT(rst.getString(3));
           myMeds.setFC_PAYABLE_AMT(rst.getString(4));
          
           MedList.add(myMeds);
          
         }
         rst.close();
         cst.close();
         conn.close();
         
       }
       catch(Exception e) {
         GlobalCC.EXCEPTIONREPORTING(conn, e);
       }
       return MedList;
     }
    
    public List<medical> FindUWDecisionView() {
        DBConnector myConn=new DBConnector();
       Connection conn=myConn.getDatabaseConn();
       CallableStatement cst=null;
       
       List<medical> MedList=new ArrayList<medical>();
       
      
       try {
         String polQuery="begin LMS_WEB_CURSOR_GRP.get_uw_decisions(?,?);end;";
         cst=conn.prepareCall(polQuery);
         cst.registerOutParameter(1,OracleTypes.CURSOR);
         cst.setBigDecimal(2,(BigDecimal)session.getAttribute("policyCode")); //cmi code
        
         cst.execute();
         ResultSet rst=(ResultSet)cst.getObject(1);
         while(rst.next()){
             medical myMeds=new medical();

           myMeds.setPUD_CODE(rst.getBigDecimal(1));
           myMeds.setUD_DESC(rst.getString(2));
          
           MedList.add(myMeds);
          
         }
         rst.close();
         cst.close();
         conn.close();
         
       }
       catch(Exception e) {
         GlobalCC.EXCEPTIONREPORTING(conn, e);
       }
       return MedList;
     }
    
    public List<medical> FindMemberUWDecisionView() {
        DBConnector myConn=new DBConnector();
       Connection conn=myConn.getDatabaseConn();
       CallableStatement cst=null;
       
       List<medical> MedList=new ArrayList<medical>();
       
      
       try {
         String polQuery="begin LMS_WEB_CURSOR_GRP.get_mem_uw_decisions(?,?);end;";
         cst=conn.prepareCall(polQuery);
         cst.registerOutParameter(1,OracleTypes.CURSOR);
         cst.setBigDecimal(2,(BigDecimal)session.getAttribute("PolmMemCode")); //Member code
        
         cst.execute();
         ResultSet rst=(ResultSet)cst.getObject(1);
         while(rst.next()){
             medical myMeds=new medical();

           myMeds.setMEM_PUD_CODE(rst.getBigDecimal(1));
           myMeds.setMEM_UD_DESC(rst.getString(2));

          
           MedList.add(myMeds);
          
         }
         rst.close();
         cst.close();
         conn.close();
         
       }
       catch(Exception e) {
         GlobalCC.EXCEPTIONREPORTING(conn, e);
       }
       return MedList;
     }
    
    public List<medical> FindMedicalPaymentsQuery() {
        DBConnector myConn=new DBConnector();
       Connection conn=myConn.getDatabaseConn();
       CallableStatement cst=null;
       
       List<medical> MedList=new ArrayList<medical>();
       
      
       try {
         String polQuery="begin LMS_WEB_CURSOR_GRP.medicalPaymentsQuery(?,?);end;";
         cst=conn.prepareCall(polQuery);
         cst.registerOutParameter(1,OracleTypes.CURSOR);
         cst.setString(2, (String)session.getAttribute("PaymentsFlag")); //cmi code
        
         cst.execute();
         ResultSet rst=(ResultSet)cst.getObject(1);
         while(rst.next()){
             medical myMeds=new medical();

           myMeds.setSearchCode(rst.getBigDecimal(1));
           myMeds.setSearchDesc(rst.getString(2));
          
           MedList.add(myMeds);
          
         }
         rst.close();
         cst.close();
         conn.close();
         
       }
       catch(Exception e) {
         GlobalCC.EXCEPTIONREPORTING(conn, e);
       }
       return MedList;
     }
    
    public List<medical> FindMedicalPayments() {
        DBConnector myConn=new DBConnector();
       Connection conn=myConn.getDatabaseConn();
       CallableStatement cst=null;
       
       List<medical> MedList=new ArrayList<medical>();
       
      
       try {
         String polQuery="begin LMS_WEB_CURSOR_GRP.Findmedpayments(?,?,?);end;";
         cst=conn.prepareCall(polQuery);
         cst.registerOutParameter(1,OracleTypes.CURSOR);
         cst.setBigDecimal(2, (BigDecimal)session.getAttribute("MedPolicy")); 
         cst.setBigDecimal(3, (BigDecimal)session.getAttribute("FacilitatorCode"));
        
         cst.execute();
         ResultSet rst=(ResultSet)cst.getObject(1);
         while(rst.next()){
             medical myMeds=new medical();
               myMeds.setMP_CML_CODE(rst.getBigDecimal(1));
               myMeds.setMP_CML_ID_NO(rst.getString(2));
               myMeds.setMP_PROPOSAL_NO(rst.getString(3));
                myMeds.setMP_CLIENT(rst.getString(4));
               myMeds.setMP_MED_TEST_DISPLAY(rst.getString(5));
               myMeds.setMP_CML_RECEIVED(rst.getString(6));
               myMeds.setMP_CML_PAYABLE_AMT(rst.getString(7));
               myMeds.setMP_CML_PAID(rst.getString(8));
               myMeds.setMP_FACILITATOR_DISPLAY(rst.getString(9));
               myMeds.setMP_CML_RAISED_BY(rst.getString(10));
               myMeds.setSPR_CODE(rst.getBigDecimal(11));
              myMeds.setCurCode(rst.getBigDecimal(12));
              myMeds.setCurSymbol(rst.getString(13));
               myMeds.setSelected(false);
             
          
           MedList.add(myMeds);
          
         }
         rst.close();
         cst.close();
         conn.close();
         
       }
       catch(Exception e) {
         GlobalCC.EXCEPTIONREPORTING(conn, e);
       }
       return MedList;
     }
    
    public List<medical> FindFacilitatorPayments() {
        DBConnector myConn=new DBConnector();
       Connection conn=myConn.getDatabaseConn();
       CallableStatement cst=null;
       
       List<medical> MedList=new ArrayList<medical>();
       
      
       try {
         String polQuery="begin LMS_WEB_CURSOR_GRP.findfacilitatorpayments(?,?);end;";
         cst=conn.prepareCall(polQuery);
         cst.registerOutParameter(1,OracleTypes.CURSOR);
         cst.setBigDecimal(2, (BigDecimal)session.getAttribute("MedTransNo")); 
        
         cst.execute();
         ResultSet rst=(ResultSet)cst.getObject(1);
         while(rst.next()){
             medical myMeds=new medical();
            
               myMeds.setFP_facilitator_display(rst.getString(1));
               myMeds.setFP_branch_display(rst.getString(2));
               myMeds.setFP_fpmt_amount(rst.getString(3));
                myMeds.setFP_fpmt_vat_rate(rst.getString(4));
               myMeds.setFP_fpmt_vat_amt(rst.getString(5));
               myMeds.setFP_fpmt_net_amount(rst.getString(6));
               myMeds.setFP_fpmt_pymt_type(rst.getString(7));
               myMeds.setFPMT_CODE(rst.getBigDecimal(8));
           MedList.add(myMeds);
          
         }
         rst.close();
         cst.close();
         conn.close();
         
       }
       catch(Exception e) {
         GlobalCC.EXCEPTIONREPORTING(conn, e);
       }
       return MedList;
     }

}
