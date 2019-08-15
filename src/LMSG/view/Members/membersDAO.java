package LMSG.view.Members;

import LMSG.view.Base.GlobalCC;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.jdbc.OracleTypes;

import LMSG.view.Base.LOVCC;

import LMSG.view.connect.DBConnector;

public class membersDAO extends LOVCC {
  public membersDAO() {
  }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  public List<members1> FindMemberDependants() {
      DBConnector myConn=new DBConnector();
     Connection conn=myConn.getDatabaseConn();
     CallableStatement cst=null;
     List<members1> MemberList=new ArrayList<members1>();
    
     try {
       String polQuery="begin LMS_WEB_CURSOR_GRP.getDependentMembers(?,?,?,?);end;";
       cst=conn.prepareCall(polQuery);
       cst.registerOutParameter(1,OracleTypes.CURSOR);
       cst.setBigDecimal(2,(BigDecimal)session.getAttribute("MemberNumber"));
         String Cursa = (String)session.getAttribute("CurrentStatus");
         if(Cursa.equalsIgnoreCase("Q")){
        cst.setBigDecimal(3,(BigDecimal)session.getAttribute("QuoteCode")); //Quotation Code   
         }else{
        cst.setBigDecimal(3,(BigDecimal)session.getAttribute("endorsementCode")); //Endorsement Code
         }
        cst.setString(4,(String)session.getAttribute("CurrentStatus"));
      
       cst.execute();
       ResultSet rst=(ResultSet)cst.getObject(1);
       while(rst.next()){
         members1 myMem=new members1();
     
           myMem.setPOLM_CODE(rst.getBigDecimal(1));
           myMem.setMEM_SURNAME(rst.getString(2));
           myMem.setMEM_OTHER_NAMES(rst.getString(3));
           myMem.setMEM_DOB(rst.getDate(4));
           myMem.setDTY_DESCRIPTION(rst.getString(5));
           myMem.setMEM_NO(rst.getString(6));
           myMem.setMEM_SEX(rst.getString(7));
           myMem.setMEM_IDENTITY_NO(rst.getString(8));
           myMem.setMemPinNO(rst.getString(9));
           myMem.setMemAddress(rst.getString(10));
       
         MemberList.add(myMem);
        
       }
       rst.close();
       cst.close();
         conn.close();   

     }
     catch(Exception e) {
       GlobalCC.EXCEPTIONREPORTING(conn, e);
     }
     return MemberList;
   }
  
  public List<members1> FindJointMembers() {
      DBConnector myConn=new DBConnector();
     Connection conn=myConn.getDatabaseConn();
     CallableStatement cst=null;
     List<members1> MemberList=new ArrayList<members1>();
    
     try {
       String polQuery="begin LMS_WEB_CURSOR_GRP.getJointMembers(?,?,?);end;";
       cst=conn.prepareCall(polQuery);
       cst.registerOutParameter(1,OracleTypes.CURSOR);
       //System.out.println("Member Number Passed to Iterator is "+(BigDecimal)session.getAttribute("MemberNumber1"));
       if((BigDecimal)session.getAttribute("MemberNumber1") == null){
           cst.setBigDecimal(2,(BigDecimal)session.getAttribute("PolmMemCode"));
       }else{
           cst.setBigDecimal(2,(BigDecimal)session.getAttribute("MemberNumber1")); 
       }
       cst.setBigDecimal(3,(BigDecimal)session.getAttribute("endorsementCode"));
       
       //System.out.println("MemberNumber Passed is: "+((BigDecimal)session.getAttribute("PolmMemCode")));
       //System.out.println("Endorsement Code Passed is: "+(BigDecimal)session.getAttribute("endorsementCode"));
      
       cst.execute();
       ResultSet rst=(ResultSet)cst.getObject(1);        
       while(rst.next()){
         members1 myMem=new members1();
           myMem.setJ_POLM_CODE(rst.getBigDecimal(1));
           myMem.setJ_MEM_SURNAME(rst.getString(2));
           myMem.setJ_MEM_OTHER_NAMES(rst.getString(3));
           myMem.setJ_MEM_DOB(rst.getDate(4));
           myMem.setJ_DTY_DESCRIPTION(rst.getString(5));
           myMem.setJ_MEM_NO(rst.getString(6));
           myMem.setJ_MEM_SEX(rst.getString(7));
           myMem.setJ_MEM_IDENTITY_NO(rst.getString(8));
           myMem.setJMemPinNO(rst.getString(9));
           myMem.setJMemAddress(rst.getString(10));
         MemberList.add(myMem);
       }
         
       rst.close();
       cst.close();
         conn.close();   

     }
     catch(Exception e) {
       GlobalCC.EXCEPTIONREPORTING(conn, e);
     }
     return MemberList;
   }
  
    public List<members1> FindQuoteJointMembers() {
        DBConnector myConn=new DBConnector();
       Connection conn=myConn.getDatabaseConn();
       CallableStatement cst=null;
       List<members1> MemberList=new ArrayList<members1>();
      
       try {
         String polQuery="begin LMS_WEB_CURSOR_GRP.getquotejointmembers(?,?,?);end;";
         cst=conn.prepareCall(polQuery);
         cst.registerOutParameter(1,OracleTypes.CURSOR);
         cst.setBigDecimal(2,(BigDecimal)session.getAttribute("quoteMemMemCode"));
         cst.setBigDecimal(3,(BigDecimal)session.getAttribute("QuoteCode"));
        
         cst.execute();
         ResultSet rst=(ResultSet)cst.getObject(1);
           
         while(rst.next()){
           members1 myMem=new members1();
       
             myMem.setJ_POLM_CODE(rst.getBigDecimal(1));
             myMem.setJ_MEM_SURNAME(rst.getString(2));
             myMem.setJ_MEM_OTHER_NAMES(rst.getString(3));
             myMem.setJ_MEM_DOB(rst.getDate(4));
             myMem.setJ_DTY_DESCRIPTION(rst.getString(5));
             myMem.setJ_MEM_NO(rst.getString(6));
             myMem.setJ_MEM_SEX(rst.getString(7));
             myMem.setJ_MEM_IDENTITY_NO(rst.getString(8));   
             myMem.setJMemPinNO(rst.getString(9));
             myMem.setJMemAddress(rst.getString(10));
           MemberList.add(myMem);
          
         }
         rst.close();
         cst.close();
           conn.close();   

       }
       catch(Exception e) {
         GlobalCC.EXCEPTIONREPORTING(conn, e);
       }
       return MemberList;
     }
  public List<members1> FindMembers() {
      DBConnector myConn=new DBConnector();
     Connection conn=myConn.getDatabaseConn();
     CallableStatement cst=null;
     List<members1> MemberList=new ArrayList<members1>();
    
     try {
       String polQuery="begin LMS_WEB_CURSOR_GRP.getMember(?,?,?);end;";
       cst=conn.prepareCall(polQuery);
       cst.registerOutParameter(1,OracleTypes.CURSOR);
       cst.setBigDecimal(2,(BigDecimal)session.getAttribute("MemberNumber"));
       cst.setBigDecimal(3,(BigDecimal)session.getAttribute("endorsementCode"));
      
       cst.execute();
       ResultSet rst=(ResultSet)cst.getObject(1);
       while(rst.next()){
         members1 myMem=new members1();
     
           myMem.setM_POLM_CODE(rst.getBigDecimal(1));
           myMem.setM_MEM_SURNAME(rst.getString(2));
           myMem.setM_MEM_OTHER_NAMES(rst.getString(3));
           myMem.setM_MEM_DOB(rst.getDate(4));
           myMem.setM_DTY_DESCRIPTION(rst.getString(5));
           myMem.setM_MEM_NO(rst.getString(6));
           myMem.setM_MEM_SEX(rst.getString(7));
           myMem.setM_MEM_IDENTITY_NO(rst.getString(8));
           myMem.setM_fullName(rst.getString(9));
        
       
         MemberList.add(myMem);
        
       }
       rst.close();
       cst.close();
         conn.close();   

     }
     catch(Exception e) {
       GlobalCC.EXCEPTIONREPORTING(conn, e);
     }
     return MemberList;
   }
  public List<members1> FindMemberCoverTypes() {
      DBConnector myConn=new DBConnector();
     Connection conn=myConn.getDatabaseConn();
     CallableStatement cst=null;
     List<members1> MemberList=new ArrayList<members1>();
     double totPrem=0.00;
    
     try {
			String polQuery="begin LMS_WEB_CURSOR_GRP.getMemberCovers(?,?,?);end;";
			String RenewalArea = (String)session.getAttribute("RenewalArea");
			if(RenewalArea==null){
				polQuery="begin LMS_WEB_CURSOR_GRP.getMemberCovers(?,?,?);end;";
			}else if(RenewalArea.equalsIgnoreCase("Y")){
				polQuery="begin LMS_WEB_CURSOR_GRP.get_renmembercovers(?,?,?);end;";
			}else{
				polQuery="begin LMS_WEB_CURSOR_GRP.getMemberCovers(?,?,?);end;";
			}
			cst=conn.prepareCall(polQuery);
			cst.registerOutParameter(1,OracleTypes.CURSOR);
			cst.setBigDecimal(2,(BigDecimal)session.getAttribute("MemberNumber"));
			cst.setBigDecimal(3,(BigDecimal)session.getAttribute("endorsementCode"));

       cst.execute();
       ResultSet rst=(ResultSet)cst.getObject(1);
       while(rst.next()){
      members1 myMem=new members1();     
			myMem.setCVT_DESC(rst.getString(1));
			myMem.setPCM_COVER_WEF_DATE(rst.getDate(2));
			myMem.setPCM_COVER_WET_DATE(rst.getDate(3));
			myMem.setPCM_SA(rst.getBigDecimal(4));
			myMem.setPCM_PREMIUM(rst.getString(5));
			myMem.setPCM_ORIGINAL_LOAN_AMT(rst.getString(6));
			myMem.setPCM_ORIG_LOAN_REPAYMENT_PRD(rst.getString(7));
			myMem.setPCM_LOAN_INT(rst.getString(8));
			myMem.setPCM_SAVING_AMT(rst.getString(9));
			myMem.setPCM_LOAN_ISSUE_DATE(rst.getDate(10));
			myMem.setPCM_RATE(rst.getBigDecimal(11));
			myMem.setPCM_LOAD_DISC_PREM(rst.getBigDecimal(12));
			myMem.setPCM_ADD_REF_PREM(rst.getBigDecimal(13));
			myMem.setPCM_PAY_PERIOD_PREMIUM(rst.getBigDecimal(14));
			myMem.setPCM_EARNINGS(rst.getBigDecimal(15));
			myMem.setPCM_MULT_EARNINGS_PRD(rst.getBigDecimal(16));
			myMem.setPCM_CODE(rst.getBigDecimal(17)); 
			myMem.setPCM_PCVT_CODE(rst.getBigDecimal(18)); 
			myMem.setPCM_BASIC_SAL(rst.getBigDecimal(19));
			myMem.setPCM_HOUSE_ALLOW(rst.getBigDecimal(20));
			myMem.setPCM_TRANS_ALLOW(rst.getBigDecimal(21));
			myMem.setPCM_OTHER_ALLOW(rst.getBigDecimal(22));
			myMem.setPCM_DISC_PREM(rst.getBigDecimal(23));
			myMem.setPCM_PURE_RATE(rst.getBigDecimal(24));
			myMem.setPCM_PURE_PREMIUM(rst.getBigDecimal(25));
			myMem.setPCM_ADR_RATE(rst.getBigDecimal(26));
			myMem.setPCM_ACCIDENTAL_PREM(rst.getBigDecimal(27));
			myMem.setPCM_LOADING_TYPE(rst.getString(28));
			myMem.setPCM_LOADING_RATE(rst.getBigDecimal(29));
			myMem.setPCM_LOADING_DIV_FACTOR(rst.getBigDecimal(30));
      myMem.setTotPrem(rst.getBigDecimal(31));
			MemberList.add(myMem);
       }
       rst.close();
       cst.close();
         conn.close();   
 
     }
     catch(Exception e) {
       GlobalCC.EXCEPTIONREPORTING(conn, e);
     }
     return MemberList;
   }
  
    public List<members1> FindQuoteMemberCovers() {
        DBConnector myConn=new DBConnector();
       Connection conn=myConn.getDatabaseConn();
       CallableStatement cst=null;
       List<members1> MemberList=new ArrayList<members1>();
      
       try {
         String DpdQuery="begin LMS_WEB_CURSOR_GRP.memCoverTypes(?,?,?);end;";
         cst=conn.prepareCall(DpdQuery);
         cst.registerOutParameter(1,OracleTypes.CURSOR);
          
           cst.setBigDecimal(2,(BigDecimal)session.getAttribute("QuoteCode"));
           cst.setBigDecimal(3,(BigDecimal)session.getAttribute("MemberNumber"));
           
           System.out.println(session.getAttribute("QuoteCode"));
           System.out.println(session.getAttribute("MemberNumber"));
           
         cst.execute();
         ResultSet rst=(ResultSet)cst.getObject(1);
         while(rst.next()){
           members1 existQout = new members1();
             
             existQout.setCover_display(rst.getString(1));
             existQout.setQCM_COVER_WEF_DATE(rst.getDate(2));
             existQout.setQCM_COVER_WET_DATE(rst.getDate(3));
             existQout.setQCM_SA(rst.getBigDecimal(4));
             existQout.setQCM_LOAD_DISC_PREM(rst.getBigDecimal(5));
             existQout.setQCM_PREMIUM(rst.getBigDecimal(6));
             existQout.setQCM_ORIGINAL_LOAN_AMT(rst.getBigDecimal(7));
             existQout.setQCM_ORIG_LOAN_REPAYMENT_PRD(rst.getBigDecimal(8));
             existQout.setQCM_SAVING_AMT(rst.getBigDecimal(9));
             existQout.setQCM_LOAN_ISSUE_DATE(rst.getDate(10));
             existQout.setQCM_CODE(rst.getBigDecimal(11));
             existQout.setQCM_EARNINGS(rst.getBigDecimal(12));
             existQout.setQCM_MULT_EARNINGS_PRD(rst.getBigDecimal(13));
             existQout.setQCM_QCVT_CODE(rst.getBigDecimal(14));
             existQout.setQCM_BASIC_SAL(rst.getBigDecimal(15));
             existQout.setQCM_HOUSE_ALLOW(rst.getBigDecimal(16));
             existQout.setQCM_TRANS_ALLOW(rst.getBigDecimal(17));
             existQout.setQCM_OTHER_ALLOW(rst.getBigDecimal(18));
             existQout.setQCM_RATE(rst.getBigDecimal(19));
             existQout.setQcm_disc_prem(rst.getBigDecimal(20));
             existQout.setQcm_pure_rate(rst.getBigDecimal(21));
             existQout.setQcm_pure_premium(rst.getBigDecimal(22));
             existQout.setTotPrem(rst.getBigDecimal(23));
             MemberList.add(existQout);
          
         }
         rst.close();
         cst.close();
           conn.close();   

       }
       catch(Exception e) {
         GlobalCC.EXCEPTIONREPORTING(conn, e);
       }
       return MemberList;
     }
    
	public List<members1> FindIndivudualMemberCovers() {
		DBConnector myConn=new DBConnector();
		Connection conn=myConn.getDatabaseConn();
		CallableStatement cst=null;
		List<members1> MemberList=new ArrayList<members1>();
      
		try {
			String polQuery="begin LMS_WEB_CURSOR_GRP.GetAlterMemCovers(?,?,?);end;";
			cst=conn.prepareCall(polQuery);
			cst.registerOutParameter(1,OracleTypes.CURSOR);
			cst.setBigDecimal(2,(BigDecimal)session.getAttribute("PolmCode"));
			cst.setBigDecimal(3,(BigDecimal)session.getAttribute("endorsementCode"));
			cst.execute();
			ResultSet rst=(ResultSet)cst.getObject(1);
			while(rst.next()){
				members1 myMem=new members1();
				myMem.setCVT_CVT_DESC(rst.getString(1));
				myMem.setCVT_PCM_COVER_WEF_DATE(rst.getDate(2));
				myMem.setCVT_PCM_COVER_WET_DATE(rst.getDate(3));
				myMem.setCVT_PCM_SA(rst.getString(4));  
				myMem.setCVT_PCM_PREMIUM(rst.getString(5));
				myMem.setCVT_PCM_CODE(rst.getBigDecimal(6));
				myMem.setCVT_PCM_PCVT_CVT_CODE(rst.getBigDecimal(7));
				myMem.setCVT_PCM_RATE(rst.getBigDecimal(9));
				myMem.setCVT_PCM_ENDR_CODE(rst.getBigDecimal(10));
				myMem.setCVT_PCM_EARNINGS(rst.getString(11));
				myMem.setCVT_PCM_MULT_EARNINGS_PRD(rst.getString(12));
				myMem.setCVT_PCM_LOAN_ISSUE_DATE(rst.getDate(13));
				myMem.setCVT_PCM_ORIGINAL_LOAN_AMT(rst.getString(14));
				myMem.setCVT_PCM_ORIG_LOAN_REPAYMENT_PRD(rst.getString(15));
				myMem.setCVT_PCM_SAVING_AMT(rst.getString(16));
				myMem.setPCM_LOAN_INT(rst.getString(17));
				myMem.setPCM_MAIN_RIDER(rst.getString(18));    
				MemberList.add(myMem);
			}
			rst.close();
			cst.close();
			conn.close();   
		}
		catch(Exception e) {
			GlobalCC.EXCEPTIONREPORTING(conn, e);
       }
       return MemberList;
    }
   
    public List<members1> FindIndivudualMemberDetails() {
         DBConnector myConn=new DBConnector();
        Connection conn=myConn.getDatabaseConn();
        CallableStatement cst=null;
        List<members1> MemberList=new ArrayList<members1>();
       
        try {
          String polQuery="begin LMS_WEB_CURSOR_GRP.GetAlterMemberDisplay(?,?,?,?);end;";
          cst=conn.prepareCall(polQuery);
          cst.registerOutParameter(1,OracleTypes.CURSOR);
          cst.setBigDecimal(2,(BigDecimal)session.getAttribute("policyCode"));
          cst.setBigDecimal(3,(BigDecimal)session.getAttribute("PolmCode"));
          cst.setBigDecimal(4,(BigDecimal)session.getAttribute("PolmMemCode"));
          cst.execute();
          ResultSet rst=(ResultSet)cst.getObject(1);
          while(rst.next()){
            members1 myMem=new members1();
              

              myMem.setMEM_POLM_CODE(rst.getBigDecimal(1));
              myMem.setMEM_POLM_MEM_CODE(rst.getBigDecimal(3));
              session.setAttribute("MemberNumber", rst.getBigDecimal(3));
              myMem.setMEM_POLM_MEM_NO(rst.getString(2));
              session.setAttribute("IndMemNo", rst.getString(2));
              myMem.setMEM_MEMBER_DISPLAY(rst.getString(4));  
              myMem.setMEM_POLM_PCA_CODE(rst.getBigDecimal(13));
              session.setAttribute("PolicyCategory", rst.getBigDecimal(13));
              myMem.setMEM_MEM_DOB(rst.getDate(14));
              myMem.setMEM_MEM_SURNAME(rst.getString(15));
              myMem.setMEM_MEM_OTHER_NAMES(rst.getString(16));
              myMem.setMEM_MEM_SEX(rst.getString(17));
              myMem.setMEM_POL_PRP_CODE(rst.getBigDecimal(18));
              session.setAttribute("prpCode", rst.getBigDecimal(18));
              myMem.setGcoDesc(rst.getString(19));
              myMem.setPolmLcCode(rst.getBigDecimal(20));
              session.setAttribute("lcCode", rst.getBigDecimal(20));       
            MemberList.add(myMem);
           
          }
          rst.close();
          cst.close();
            conn.close();   

        }
        catch(Exception e) {
          GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return MemberList;
      }
    
    public List<members1> FindIndivudualMemberPensions() {
         DBConnector myConn=new DBConnector();
        Connection conn=myConn.getDatabaseConn();
        CallableStatement cst=null;
        List<members1> MemberList=new ArrayList<members1>();
       
        try {
          String polQuery="begin LMS_WEB_CURSOR_GRP.GetAlterMemPensDtls(?,?,?);end;";
          cst=conn.prepareCall(polQuery);
          cst.registerOutParameter(1,OracleTypes.CURSOR);
          cst.setBigDecimal(2,(BigDecimal)session.getAttribute("PolmCode"));
          cst.setBigDecimal(3,(BigDecimal)session.getAttribute("endorsementCode"));
          cst.execute();
          ResultSet rst=(ResultSet)cst.getObject(1);
          while(rst.next()){
            members1 myMem=new members1();
              

              myMem.setPMPNS_CODE(rst.getBigDecimal(1));
              myMem.setPMPNS_EARNINGS(rst.getString(2));
              myMem.setPMPNS_EMPLYE_VOLU_TYPE(rst.getString(3));
              myMem.setPMPNS_COMP_INT_RATE(rst.getString(4));  
              myMem.setPMPNS_EMPLOYER_CONTR(rst.getString(5));
              myMem.setPMPNS_EMPLYE_VOLU_CONTR(rst.getString(6));
              myMem.setPMPNS_ANNTY_FAC_RATE(rst.getString(7));
              myMem.setPMPNS_PENS_ANNUM(rst.getString(8));
              myMem.setPMPNS_EMPLOYEE_CONTR(rst.getString(9));
              myMem.setPMPNS_TOTAL_CONTR(rst.getString(10));
             myMem.setPMPNS_NET_ANNUAL_FUND(rst.getString(11));
             myMem.setPMPNS_ADMIN_FEE_RATE(rst.getString(12));

              
           
          
            MemberList.add(myMem);
           
          }
          rst.close();
          cst.close();
            conn.close();   

        }
        catch(Exception e) {
          GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return MemberList;
      }
    
    public List<members1> FindMembersForExport() {
         DBConnector myConn=new DBConnector();
        Connection conn=myConn.getDatabaseConn();
        CallableStatement cst=null;
        List<members1> MemberList=new ArrayList<members1>();
       
        try {
          String polQuery="begin LMS_WEB_CURSOR_GRP.get_mem_for_export(?,?,?);end;";
          cst=conn.prepareCall(polQuery);
          cst.registerOutParameter(1,OracleTypes.CURSOR);
          cst.setBigDecimal(2,(BigDecimal)session.getAttribute("PolmCode"));
          cst.setBigDecimal(3,(BigDecimal)session.getAttribute("endorsementCode"));
          cst.execute();
          ResultSet rst=(ResultSet)cst.getObject(1);
          while(rst.next()){
            members1 myMem=new members1();
              
              myMem.setEX_PCM_CODE(rst.getBigDecimal(1));  
              myMem.setEX_POLM_MEM_NO(rst.getString(2));
              myMem.setEX_PCM_EARNINGS(rst.getBigDecimal(3));
              myMem.setEX_PCM_MULT_EARNINGS_PRD(rst.getBigDecimal(4));
              myMem.setEX_MEM_SURNAME(rst.getString(5));
              myMem.setEX_MEM_OTHER_NAMES(rst.getString(6));
              myMem.setEX_PCA_SHT_DESC(rst.getString(7));
              myMem.setEX_AddRemove(rst.getString(8));
              myMem.setEX_original_loan_amt(rst.getBigDecimal(9));
              myMem.setEX_loan_repayment_prd(rst.getBigDecimal(10));
            
              
           
          
            MemberList.add(myMem);
           
          }
          rst.close();
          cst.close();
            conn.close();   

        }
        catch(Exception e) {
          GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return MemberList;
      }
    public List<members1> FindMembersBeneficiaries() {
         DBConnector myConn=new DBConnector();
        Connection conn=myConn.getDatabaseConn();
        CallableStatement cst=null;
        List<members1> MemberList=new ArrayList<members1>();
       
        try {
          String polQuery="begin LMS_WEB_CURSOR_GRP.findPolicyMemberStudents(?,?,?,?);end;";
          cst=conn.prepareCall(polQuery);
          cst.registerOutParameter(1,OracleTypes.CURSOR);
          cst.setBigDecimal(2,(BigDecimal)session.getAttribute("MemberNumber"));
          String Module = (String)session.getAttribute("benModule");
            if(Module==null){
              cst.setBigDecimal(3,(BigDecimal)session.getAttribute("endorsementCode"));
              cst.setString(4, (String)session.getAttribute("benModule"));
            }else if(Module.equalsIgnoreCase("C")){
              cst.setBigDecimal(3,(BigDecimal)session.getAttribute("policyCode"));
              cst.setString(4, (String)session.getAttribute("benModule"));
            }else{
              cst.setBigDecimal(3,(BigDecimal)session.getAttribute("endorsementCode"));
              cst.setString(4, (String)session.getAttribute("benModule"));
            }
          
          cst.execute();
          ResultSet rst=(ResultSet)cst.getObject(1);
          while(rst.next()){
            members1 myMem=new members1();
              

              myMem.setQmemBenCode(rst.getBigDecimal(1));
              session.setAttribute("studentBenCode", rst.getBigDecimal(1));
              myMem.setQmemBenMainMemCode(rst.getBigDecimal(2));
              myMem.setQmemBenSurname(rst.getString(3));
              myMem.setQmemBenOtherNames(rst.getString(4));  
              myMem.setQmemBenClass(rst.getString(5));
              myMem.setQmemBenTerm(rst.getString(6));
              myMem.setQmemBenMemNo(rst.getString(7));
              myMem.setClassDisplay(rst.getString(8));
              myMem.setBenTerm(rst.getString(9));
              myMem.setFeeDisplay(rst.getBigDecimal(10));
              myMem.setQmem_ben_sex(rst.getString(11));
              myMem.setPmem_share_pct(rst.getBigDecimal(12));
              myMem.setSpr_code(rst.getBigDecimal(13));
              myMem.setSpr_name(rst.getString(14));
              myMem.setPmem_rsa_pin(rst.getString(15));
          
            MemberList.add(myMem);
           
          }
          rst.close();
          cst.close();
            conn.close();   

        }
        catch(Exception e) {
          GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return MemberList;
      }
    
  public List<members1> FindMembersBeneficiariesCovers() {
       DBConnector myConn=new DBConnector();
      Connection conn=myConn.getDatabaseConn();
      CallableStatement cst=null;
      List<members1> MemberList=new ArrayList<members1>();
     
      try {
        String polQuery="begin LMS_WEB_CURSOR_GRP.findpolicymemberstudentscovers(?,?,?);end;";
        cst=conn.prepareCall(polQuery);
        cst.registerOutParameter(1,OracleTypes.CURSOR);
        cst.setBigDecimal(2,(BigDecimal)session.getAttribute("MemberNumber"));
        cst.setBigDecimal(3,(BigDecimal)session.getAttribute("endorsementCode"));
       
        cst.execute();
        ResultSet rst=(ResultSet)cst.getObject(1);
        while(rst.next()){
          members1 myMem=new members1();            

            myMem.setQmemBenCode(rst.getBigDecimal(1));
            session.setAttribute("studentBenCode", rst.getBigDecimal(1));
            myMem.setQmemBenMainMemCode(rst.getBigDecimal(2));
            myMem.setQmemBenSurname(rst.getString(3));
            myMem.setQmemBenOtherNames(rst.getString(4));  
            myMem.setQmemBenClass(rst.getString(5));
            myMem.setQmemBenTerm(rst.getString(6));
            myMem.setQmemBenMemNo(rst.getString(7));
            myMem.setClassDisplay(rst.getString(8));
            myMem.setBenTerm(rst.getString(9));
            myMem.setFeeDisplay(rst.getBigDecimal(10));
            myMem.setQmem_ben_sex(rst.getString(11));
            myMem.setPmem_share_pct(rst.getBigDecimal(12));
            myMem.setSpr_code(rst.getBigDecimal(13));
            myMem.setSpr_name(rst.getString(14));
            myMem.setPmem_rsa_pin(rst.getString(15));
            myMem.setPmem_dob(rst.getDate(16));
            myMem.setPmem_ben_type(rst.getString(17));
            myMem.setPmem_id_no(rst.getString(18));
            myMem.setPmem_ret_desc(rst.getString(19));
            myMem.setPmem_comments(rst.getString(20));
            MemberList.add(myMem);
         
        }
        rst.close();
        cst.close();
          conn.close();   

      }
      catch(Exception e) {
        GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
      return MemberList;
    }
  
    public List<members1> FindMembersBeneficiariesCoversII() {
         DBConnector myConn=new DBConnector();
        Connection conn=myConn.getDatabaseConn();
        CallableStatement cst=null;
        List<members1> MemberList=new ArrayList<members1>();
       
        try {
          String polQuery="begin LMS_WEB_CURSOR_GRP.findpolicymemberstudentscovers(?,?,?);end;";
          cst=conn.prepareCall(polQuery);
          cst.registerOutParameter(1,OracleTypes.CURSOR);
          cst.setBigDecimal(2,(BigDecimal)session.getAttribute("PolmCode"));
          cst.setBigDecimal(3,(BigDecimal)session.getAttribute("endorsementCode"));
         
          cst.execute();
          ResultSet rst=(ResultSet)cst.getObject(1);
          while(rst.next()){
            members1 myMem=new members1();
              

              myMem.setQmemBenCode(rst.getBigDecimal(1));
              myMem.setQmemBenMainMemCode(rst.getBigDecimal(2));
              myMem.setQmemBenSurname(rst.getString(3));
              myMem.setQmemBenOtherNames(rst.getString(4));  
              myMem.setQmemBenClass(rst.getString(5));
              myMem.setQmemBenTerm(rst.getString(6));
              myMem.setQmemBenMemNo(rst.getString(7));
              myMem.setClassDisplay(rst.getString(8));
              myMem.setBenTerm(rst.getString(9));
              myMem.setFeeDisplay(rst.getBigDecimal(10));
              myMem.setQmem_ben_sex(rst.getString(11));
              myMem.setPmem_share_pct(rst.getBigDecimal(12));
              myMem.setSpr_code(rst.getBigDecimal(13));
              myMem.setSpr_name(rst.getString(14));
              myMem.setPmem_rsa_pin(rst.getString(15));
              myMem.setPmem_dob(rst.getDate(16));
              myMem.setPmem_ben_type(rst.getString(17));
              myMem.setPmem_id_no(rst.getString(18));
              myMem.setPmem_ret_desc(rst.getString(19));
             myMem.setPmem_comments(rst.getString(20));           
          
            MemberList.add(myMem);
           
          }
          rst.close();
          cst.close();
            conn.close();   

        }
        catch(Exception e) {
          GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return MemberList;
      }
  
  public List<members1> FindQuoteMembersExceptions() {
       DBConnector myConn=new DBConnector();
      Connection conn=myConn.getDatabaseConn();
      CallableStatement cst=null;
      List<members1> MemberList=new ArrayList<members1>();
     
      try {
        String polQuery="begin LMS_WEB_CURSOR_GRP.find_quo_member_exceptions(?,?,?);end;";
        cst=conn.prepareCall(polQuery);
        cst.registerOutParameter(1,OracleTypes.CURSOR);
        cst.setBigDecimal(2,(BigDecimal)session.getAttribute("MemberNumber"));
        cst.setBigDecimal(3,(BigDecimal)session.getAttribute("QuoteCode"));
       
        cst.execute();
        ResultSet rst=(ResultSet)cst.getObject(1);
        while(rst.next()){
          members1 myMem=new members1();

            myMem.setPOLME_CODE(rst.getBigDecimal(1));
            myMem.setPOLME_LGE_CODE(rst.getBigDecimal(2));
            myMem.setPOLME_LGE_SHT_DESC(rst.getString(3));
            myMem.setLGE_DESC(rst.getString(4));  
            myMem.setPOLME_AUTHORISED(rst.getString(5));
            myMem.setPOLME_AUTHORISED_BY(rst.getString(6));
            myMem.setPOLME_BLOCK(rst.getString(7));
           
          MemberList.add(myMem);
         
        }
        rst.close();
        cst.close();
        conn.close();   

      }
      catch(Exception e) {
        GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
      return MemberList;
    }
  
  public List<members1> FindMembersExceptions() {
       DBConnector myConn=new DBConnector();
      Connection conn=myConn.getDatabaseConn();
      CallableStatement cst=null;
      List<members1> MemberList=new ArrayList<members1>();
     
      try {
        String polQuery="begin LMS_WEB_CURSOR_GRP.find_member_exceptions(?,?,?);end;";
        cst=conn.prepareCall(polQuery);
        cst.registerOutParameter(1,OracleTypes.CURSOR);
        cst.setBigDecimal(2,(BigDecimal)session.getAttribute("MemberNumber"));
        cst.setBigDecimal(3,(BigDecimal)session.getAttribute("endorsementCode"));
       
        cst.execute();
        ResultSet rst=(ResultSet)cst.getObject(1);
        while(rst.next()){
          members1 myMem=new members1();


            myMem.setPOLME_CODE(rst.getBigDecimal(1));
            myMem.setPOLME_LGE_CODE(rst.getBigDecimal(2));
            myMem.setPOLME_LGE_SHT_DESC(rst.getString(3));
            myMem.setLGE_DESC(rst.getString(4));  
            myMem.setPOLME_AUTHORISED(rst.getString(5));
            myMem.setPOLME_AUTHORISED_BY(rst.getString(6));
            myMem.setPOLME_BLOCK(rst.getString(7));
            myMem.setPOLME_REMARKS(rst.getString(8));
            
          MemberList.add(myMem);
         
        }
        rst.close();
        cst.close();
          conn.close();   

      }
      catch(Exception e) {
        GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
      return MemberList;
    }
  
  public List<members1> FindMembersToReinstate() {
       DBConnector myConn=new DBConnector();
      Connection conn=myConn.getDatabaseConn();
      CallableStatement cst=null;
      List<members1> MemberList=new ArrayList<members1>();
     
      try {
        String polQuery="begin LMS_POLICY_MEMBERS_PROC.reinst_query(?,?);end;";
        cst=conn.prepareCall(polQuery);
        cst.registerOutParameter(1,OracleTypes.CURSOR);
        cst.setBigDecimal(2,(BigDecimal)session.getAttribute("policyCode"));
      
        cst.execute();
        ResultSet rst=(ResultSet)cst.getObject(1);
        while(rst.next()){
          members1 myMem=new members1();
            
            myMem.setMEM_POLM_CODE(rst.getBigDecimal(1));
            myMem.setMEM_POLM_MEM_NO(rst.getString(5));
            myMem.setMEM_MEMBER_DISPLAY(rst.getString(24));
            myMem.setDTY_DESCRIPTION(rst.getString(25));  
            myMem.setPCM_EARNINGS(rst.getBigDecimal(19));
            myMem.setPCM_MULT_EARNINGS_PRD(rst.getBigDecimal(20));
            myMem.setPCM_LOAN_ISSUE_DATE(rst.getDate(12));
            myMem.setPCM_SAVING_AMT(rst.getString(13));
            myMem.setSelected(false);

          MemberList.add(myMem);
         
        }
        rst.close();
        cst.close();
          conn.close();   

      }
      catch(Exception e) {
        GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
      return MemberList;
    }
  public List<members1> FindMembersAnnDependents() {
       DBConnector myConn=new DBConnector();
      Connection conn=myConn.getDatabaseConn();
      CallableStatement cst=null;
      List<members1> MemberList=new ArrayList<members1>();
     
      try {
        String polQuery="begin LMS_WEB_CURSOR_GRP.getPolicyBeneficiaryDetails(?,?);end;";
        cst=conn.prepareCall(polQuery);
        cst.registerOutParameter(1,OracleTypes.CURSOR);
        cst.setBigDecimal(2,(BigDecimal)session.getAttribute("MemberNumber"));
        //cst.setBigDecimal(3,(BigDecimal)session.getAttribute("endorsementCode"));
       
        cst.execute();
        ResultSet rst=(ResultSet)cst.getObject(1);
        while(rst.next()){
          members1 myMem=new members1();
            

            myMem.setPabNUmber(rst.getBigDecimal(1));
            myMem.setPabSURNAME(rst.getString(2));
            myMem.setPabOTHERNAMES(rst.getString(3));
            myMem.setPabDOB(rst.getDate(4));  
            myMem.setPabANB(rst.getBigDecimal(5));
            myMem.setPabBEN_PCT(rst.getBigDecimal(6));
            myMem.setPabANN_PURCHASE_AMT(rst.getBigDecimal(7));
            myMem.setPabBEN_TERMINAL_AMT(rst.getBigDecimal(8));
            
            
         
        
          MemberList.add(myMem);
         
        }
        rst.close();
        cst.close();
          conn.close();   

      }
      catch(Exception e) {
        GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
      return MemberList;
    }
  
  public List<members1> FindMembersAnnDependentPayments() {
       DBConnector myConn=new DBConnector();
      Connection conn=myConn.getDatabaseConn();
      CallableStatement cst=null;
      List<members1> MemberList=new ArrayList<members1>();
     
      try {
        String polQuery="begin LMS_WEB_CURSOR_GRP.find_pol_ann_dep_partpymts(?,?,?);end;";
        cst=conn.prepareCall(polQuery);
        cst.registerOutParameter(1,OracleTypes.CURSOR);
        cst.setBigDecimal(2,(BigDecimal)session.getAttribute("pabCode"));
        cst.setBigDecimal(3,(BigDecimal)session.getAttribute("endorsementCode"));
       
        cst.execute();
        ResultSet rst=(ResultSet)cst.getObject(1);
        while(rst.next()){
          members1 member=new members1();
          
          member.setQABP_CODE(rst.getBigDecimal(1));
          member.setQABP_NO(rst.getBigDecimal(2));
          member.setQABP_DATE_DUE(rst.getDate(3));
          member.setQABP_AMOUNT(rst.getBigDecimal(4));
          member.setQABP_PAID(rst.getString(5));
          member.setQABP_PAID_DESC(rst.getString(6));
          member.setQABP_PAID_DATE(rst.getDate(7));
          member.setQABP_VOUCHER_NO(rst.getBigDecimal(8));

          MemberList.add(member);
         
        }
        rst.close();
        cst.close();
        conn.close();   

      }
      catch(Exception e) {
        GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
      return MemberList;
    }
  public List<members1> FindMemberCoverDetails() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    List MemberCoverDtlsList = new ArrayList();
    try
    {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.get_mem_cvr_dtls(?,?,?);end;";
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, -10);
      cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("PolmCode"));
      cst.setBigDecimal(3, (BigDecimal)this.session.getAttribute("endorsementCode"));
      cst.execute();
      ResultSet rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        members1 memberCovers = new members1();
        memberCovers.setCVT_DESC(rst.getString(1));
        memberCovers.setPCM_COVER_WEF_DATE(rst.getDate(2));
        memberCovers.setPCM_COVER_WET_DATE(rst.getDate(3));
        memberCovers.setEndType(rst.getString(4));
        memberCovers.setPCM_SA(rst.getBigDecimal(5));
        memberCovers.setPcmPremium(rst.getBigDecimal(6));
        memberCovers.setPCM_ADD_REF_PREM(rst.getBigDecimal(7));
        memberCovers.setPCM_EARNINGS(rst.getBigDecimal(8));
        memberCovers.setPCM_MULT_EARNINGS_PRD(rst.getBigDecimal(9));
        memberCovers.setOriginal_loan_amt(rst.getBigDecimal(10));  
        memberCovers.setOrig_loan_repayment_prd(rst.getBigDecimal(11));
        memberCovers.setLoan_issue_date(rst.getDate(12));
        MemberCoverDtlsList.add(memberCovers);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return MemberCoverDtlsList;
  }
  public List<members1> FindMembersBeneficiariesDetails() {
       DBConnector myConn=new DBConnector();
      Connection conn=myConn.getDatabaseConn();
      CallableStatement cst=null;
      List<members1> MemberList=new ArrayList<members1>();
     
      try {
        String polQuery="begin LMS_WEB_CURSOR_GRP.get_beneficiary_details(?,?);end;";
        cst=conn.prepareCall(polQuery);
        cst.registerOutParameter(1,OracleTypes.CURSOR);
        cst.setBigDecimal(2,(BigDecimal)session.getAttribute("MemberCode"));
        cst.execute();
        ResultSet rst=(ResultSet)cst.getObject(1);
        while(rst.next()){
          members1 myMem=new members1();
            

            myMem.setQmemBenCode(rst.getBigDecimal(1));
            myMem.setQmemBenMainMemCode(rst.getBigDecimal(2));
            myMem.setQmemBenSurname(rst.getString(3));
            myMem.setQmemBenOtherNames(rst.getString(4));  
            myMem.setQmemBenClass(rst.getString(5));
            myMem.setQmemBenTerm(rst.getString(6));
            myMem.setQmemBenMemNo(rst.getString(7));
            myMem.setClassDisplay(rst.getString(8));
            myMem.setBenTerm(rst.getString(9));
            myMem.setFeeDisplay(rst.getBigDecimal(10));
            myMem.setQmem_ben_sex(rst.getString(11));
            myMem.setPmem_share_pct(rst.getBigDecimal(12));
            myMem.setSpr_code(rst.getBigDecimal(13));
            myMem.setSpr_name(rst.getString(14));
            myMem.setPmem_rsa_pin(rst.getString(15));
            myMem.setPmem_dob(rst.getDate(16));
            
         
        
          MemberList.add(myMem);
         
        }
        rst.close();
        cst.close();
          conn.close();   

      }
      catch(Exception e) {
        GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
      return MemberList;
    }
    public List<members1> FindMemberTransactions() {
         DBConnector myConn=new DBConnector();
        Connection conn=myConn.getDatabaseConn();
        CallableStatement cst=null;
        List<members1> MemberList=new ArrayList<members1>();
       
        try {
          String polQuery="begin LMS_WEB_CURSOR_GRP.getmembertransactions(?,?);end;";
          cst=conn.prepareCall(polQuery);
          cst.registerOutParameter(1,OracleTypes.CURSOR);
          cst.setBigDecimal(2,(BigDecimal)session.getAttribute("PolmCode"));
          cst.execute();
          ResultSet rst=(ResultSet)cst.getObject(1);
          while(rst.next()){
            members1 myMem=new members1();
              myMem.setEndr_no(rst.getString(1));
              myMem.setEndr_cover_from_date(rst.getDate(2));
              myMem.setEndr_cover_to_date(rst.getDate(3));
              myMem.setEndr_authorization_date(rst.getDate(4));
              myMem.setEndr_prepared_by(rst.getString(5));
              myMem.setEndr_authorized_by(rst.getString(6));
              myMem.setEndr_code(rst.getBigDecimal(7));
              myMem.setBtr_trans_type(rst.getString(8));
              MemberList.add(myMem);
           
          }
          rst.close();
          cst.close();
            conn.close();   

        }
        catch(Exception e) {
          GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return MemberList;
      }
}
