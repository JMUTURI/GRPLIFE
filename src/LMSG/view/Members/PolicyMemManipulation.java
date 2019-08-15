package LMSG.view.Members;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.output.RichOutputLabel;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Key;
import oracle.jbo.Row;

import org.apache.myfaces.trinidad.model.RowKeySet;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

import LMSG.view.Base.ADFUtils;

import LMSG.view.Base.GlobalCC;

import LMSG.view.connect.DBConnector;

import javax.faces.event.ActionEvent;

import org.apache.myfaces.trinidad.event.AttributeChangeEvent;

public class PolicyMemManipulation {
    private RichTable memDependantsLOV;
    private RichTable depTypeLOV2;
    private RichInputText djMemNo;
    private RichInputText djSurname;
    private RichInputText djOtherNames;
    private RichSelectOneChoice djSex;
    private RichInputText djIDNo;
    private RichInputDate djDOB;
    private RichInputText memNo;
    private RichInputText surname;
    private RichInputText otherNames;
    private RichSelectOneChoice memsex;
    private RichInputDate dob;
    private RichOutputText memNoDisplay;
    private RichOutputText memberNameDisp;
    private RichTable coversLOV;
    private RichInputText oldEarnAmt;
    private RichInputText oldEarnPeriod;
    private RichInputText newEarnAmt;
    private RichInputText newEarnPeriod;
    private RichInputText pmpnsCode;
    private RichInputText oldLoanAmt;
    private RichInputText newLoanAmt;
    private RichInputText oldLoanPrd;
    private RichInputText newLoanPrd;
    private RichInputText oldLoanInt;
    private RichInputText newLoanInt;
    private RichInputDate oldLoanDate;
    private RichInputDate newLoanDate;
    private RichInputDate occupation;
    private RichInputText TEST;
    private RichInputText memOccupation;
    private RichTable occupLOV;
    private RichInputText quoMemNo;
    private RichInputText quoSurname;
    private RichInputText quoOtherNames;
    private RichSelectOneChoice quoMemsex;
    
    public static int DependantOrJoint = 0;
    private RichInputText jmemNo;
    private RichInputText jsurname;
    private RichInputText jotherNames;
    private RichSelectOneChoice jsex;
    private RichInputText jiDNo;
    private RichInputDate jdOB;
    private RichTable jointMembersLOV;
    private RichInputText djPinNo;
    private RichInputText djAddress;
    private RichInputText memPinNo;
    private RichInputText memAddress;


    public PolicyMemManipulation() {
        super();
    }
    
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    
  public void setJmemNo(RichInputText jmemNo) {
      this.jmemNo = jmemNo;
  }

  public RichInputText getJmemNo() {
      return jmemNo;
  }

  public void setJsurname(RichInputText jsurname) {
      this.jsurname = jsurname;
  }

  public RichInputText getJsurname() {
      return jsurname;
  }

  public void setJotherNames(RichInputText jotherNames) {
      this.jotherNames = jotherNames;
  }

  public RichInputText getJotherNames() {
      return jotherNames;
  }

  public void setJsex(RichSelectOneChoice jsex) {
      this.jsex = jsex;
  }

  public RichSelectOneChoice getJsex() {
      return jsex;
  }

  public void setJiDNo(RichInputText jiDNo) {
      this.jiDNo = jiDNo;
  }

  public RichInputText getJiDNo() {
      return jiDNo;
  }

  public void setJdOB(RichInputDate jdOB) {
      this.jdOB = jdOB;
  }

  public RichInputDate getJdOB() {
      return jdOB;
  }
  /*
  public void setJointMembersLOV(RichTable jointMembersLOV) {
      this.jointMemLOV = jointMemLOV;
  }

  public RichTable getJointMemLOV() {
      return jointMemLOV;
  }
   */ 
  public void dependantsListener(ActionEvent actionEvent) {
    // Add event code here...
    DependantOrJoint = 1;
  }
  
  public void jointMemListener(ActionEvent actionEvent) {
    // Add event code here...
    DependantOrJoint = 2;
  }
  
  public void jointTabListener(AttributeChangeEvent attributeChangeEvent) {
    // Add event code here...
    DependantOrJoint = 2;
  }

  public void dependantTabListener(AttributeChangeEvent attributeChangeEvent) {
    // Add event code here...
    DependantOrJoint = 1;
  }
    
  public String SaveJointMember() {
      DBConnector myConn=new DBConnector();
     Connection conn=myConn.getDatabaseConn();
     CallableStatement cst=null;

    //BigDecimal Memb = (BigDecimal)session.getAttribute("MemberNumber"); --Was Coming in aas null before commenting out
    
    BigDecimal Memb = (BigDecimal)session.getAttribute("PolmMemCode");
    if (Memb == null) {
      String Message = "Save Main Member First";
      GlobalCC.INFORMATIONREPORTING(Message);
      return null;
    }
    
    //System.out.println("Member Number: "+Memb);

    try {
       String polQuery="begin LMS_WEB_PKG_GRP.createpoljointmember(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?" +
                                                                 ",?,?,?,?,?,?);end;";
       cst=conn.prepareCall(polQuery);
       
       if(jsurname.getValue()==null){
         cst.setBigDecimal(1, null);
       }else{
         cst.setString(1, jsurname.getValue().toString());
       }
       if(jotherNames.getValue()==null){
         cst.setBigDecimal(2, null);
       }else{
         cst.setString(2, jotherNames.getValue().toString());
       }
       if(jiDNo.getValue()==null){
         cst.setBigDecimal(3, null);
       }else{
         cst.setString(3, jiDNo.getValue().toString());
       }
       if (jdOB.getValue()==null){
         cst.setString(4, null);
       }else{
         cst.setString(4, GlobalCC.parseDate(jdOB.getValue().toString()));
       }
      
       if(jmemNo.getValue()==null){
         cst.setBigDecimal(5, null);
       }else{
         cst.setString(5, jmemNo.getValue().toString());
       }
       if(jsex.getValue()==null){
         cst.setBigDecimal(6, null);
       }else{
         cst.setString(6, jsex.getValue().toString());
       }
       cst.setString(7, null);
       cst.setString(8, null);
       cst.setString(9, null);
       cst.setString(10, null);
       cst.setString(11, null);
       cst.setString(12, null);
       cst.setString(13, null);
       cst.setString(14, null);
       cst.setString(15, null);
       cst.setString(16, null);
       cst.setString(17, null);
       cst.setString(18, null);
       cst.setBigDecimal(19, (BigDecimal)session.getAttribute("MemberNumber"));
       cst.setBigDecimal(20, (BigDecimal)session.getAttribute("PolicyCategory"));
       cst.setBigDecimal(21, (BigDecimal)session.getAttribute("prpCode"));
       cst.setBigDecimal(22,(BigDecimal)session.getAttribute("endorsementCode")); 
       cst.setBigDecimal(23,(BigDecimal)session.getAttribute("OccupationCode"));
       cst.setString(24, "N");
        if(memAddress.getValue()==null){
          cst.setString(25,null); 
        }else{
          cst.setString(25,memAddress.getValue().toString()); 
        }
        if(memPinNo.getValue()==null){
          cst.setString(26,null);
        }else{
          cst.setString(26,memPinNo.getValue().toString());
        }
       cst.execute(); 
       cst.close();
       conn.close();

        //System.out.println("JOINT MEMBER ADDED. ABOUT TO CALL FINDJOINTMEMBER ITERATOR.");
       ADFUtils.findIterator("FindJointMembersIterator").executeQuery();    
       AdfFacesContext.getCurrentInstance().addPartialTarget(jointMembersLOV);
       
       String Message = "Joint Member Added.";
       FacesContext.getCurrentInstance().addMessage(null, 
                                                    new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                     Message, 
                                                                     Message));
        jsurname.setValue(null);
        jotherNames.setValue(null);
        jiDNo.setValue(null);
        jdOB.setValue(null);
        jsex.setValue(null);
        jmemNo.setValue(null);
     }
     catch(Exception e) {
       GlobalCC.EXCEPTIONREPORTING(conn, e);
       e.printStackTrace();
     }
     return null;
   }
  
  public String deleteJointMemberSelected(){
      
      Connection conn=null;
      try{
         DBConnector myConn=new DBConnector();
         conn=myConn.getDatabaseConn();
         CallableStatement cst=null;
         BigDecimal Code = null;
         
      System.out.println("\"About to call the Iterator. First Time\"");
          
      DCIteratorBinding dciter = ADFUtils.findIterator("FindJointMembersIterator");
      RowKeySet set =jointMembersLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      System.out.println("Point Two.");
      
      while (rowKeySetIter.hasNext())
      {
       List l = (List) rowKeySetIter.next();
       Key key = (Key)l.get(0);
       dciter.setCurrentRowWithKey(key.toStringFormat(true));
       Row r = dciter.getCurrentRow();
      
       Code = (BigDecimal)r.getAttribute("j_POLM_CODE");
          
       System.out.println("About to call the Procedure.");
          
       //System.out.println("Polm Code= "+Code);
       String polQuery="begin LMS_WEB_PKG_GRP.deletepoljointmember(?);end;";
       cst=conn.prepareCall(polQuery);
       cst.setBigDecimal(1,Code);
       cst.execute(); 
       cst.close();
       conn.close();
          
       System.out.println("About to call the Iterator.");
  
       ADFUtils.findIterator("FindJointMembersIterator").executeQuery();    
       AdfFacesContext.getCurrentInstance().addPartialTarget(jointMembersLOV);
          
        String Message = "Joint Member Deleted.";
        FacesContext.getCurrentInstance().addMessage(null, 
                                                     new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                      Message, 
                                                                      Message));
       
      
      }
       
         
      }catch(Exception e){
         GlobalCC.EXCEPTIONREPORTING(conn,e);
      }

      
      return null;    
  }
    
    public String findDependantsSelected() {
        try{
      DCIteratorBinding dciter = ADFUtils.findIterator("FindDependantTypesIterator");
      RowKeySet set =depTypeLOV2.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      //System.out.println(1);
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
         
          //categoryDesc.setValue(r.getAttribute("catDesc"));
          //LOVCC.PolicyCategory=(BigDecimal)r.getAttribute("lcaCode"); 
          //memEarnprds.setValue(r.getAttribute("catPeriod"));
          
          session.setAttribute("DepTypeCode", r.getAttribute("DTY_CODE"));
          session.setAttribute("DepTypeDesc", r.getAttribute("DTY_SHT_DESC"));
          
          //djMemNo.setValue(session.getAttribute("IndMemNo"));
          djMemNo.setValue(null);
          djSurname.setValue(null);
          djOtherNames.setValue(null);
          djSex.setValue(null);
          djDOB.setValue(null);
          djIDNo.setValue(null);
          
          // Render Popup
          ExtendedRenderKitService erkService =
          Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
          ExtendedRenderKitService.class);
          erkService.addScript(FacesContext.getCurrentInstance(),
          "var hints = {autodismissNever:false}; " +
          "AdfPage.PAGE.findComponent('" + "lmsgroup:popup7" +
          "').show(hints);");
      }
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }

      return null;
    }
    
    public String DeleteDependantsSelected() {
         Connection conn=null;
        try{
            DBConnector myConn=new DBConnector();
            conn=myConn.getDatabaseConn();
            CallableStatement cst=null;
            BigDecimal Code = null;
            
       
      DCIteratorBinding dciter = ADFUtils.findIterator("FindMemberDependantsIterator");
      RowKeySet set =memDependantsLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
         
          Code = (BigDecimal)r.getAttribute("POLM_CODE");
          String polQuery="begin LMS_WEB_PKG_GRP.delete_pol_member(?,?);end;";
          cst=conn.prepareCall(polQuery);
          cst.setBigDecimal(1,(BigDecimal)session.getAttribute("endorsementCode"));
          cst.setBigDecimal(2,Code);
          cst.execute(); 
          cst.close();
          conn.close();

                ADFUtils.findIterator("FindMemberDependantsIterator").executeQuery();    
          AdfFacesContext.getCurrentInstance().addPartialTarget(memDependantsLOV);
          
       
      }
          
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }

      return null;
    }
    
    public String DeleteMember() {
         Connection conn=null;
        try{
            conn=new DBConnector().getDatabaseConn();
            
            String endorseType = (String)session.getAttribute("endrValue");
            if(endorseType==null){
              //do nothing
              GlobalCC.INFORMATIONREPORTING("System Unable to Determine Endorsement");
              return null;
            }else if(endorseType.equalsIgnoreCase("NB") || endorseType.equalsIgnoreCase("RN")){
              String deleteMember ="BEGIN LMS_WEB_PKG_GRP.del_mem_covers(?,?,?);END;";
              
              CallableStatement cstmt=conn.prepareCall(deleteMember);
              cstmt.setBigDecimal(1,(BigDecimal)session.getAttribute("endorsementCode"));
              cstmt.setBigDecimal(2,(BigDecimal)session.getAttribute("PolmCode"));
              cstmt.setBigDecimal(3, (BigDecimal)session.getAttribute("PolmMemCode"));
              cstmt.execute();
              cstmt.close();
            }else{
              String polQuery="begin LMS_WEB_PKG_GRP_UW.delete_member_for_refund(?,?,?,?);end;";
                
              CallableStatement cst=conn.prepareCall(polQuery);
              cst.setBigDecimal(1, (BigDecimal)session.getAttribute("policyCode"));
              cst.setBigDecimal(2, (BigDecimal)session.getAttribute("endorsementCode"));
              cst.setBigDecimal(3,(BigDecimal)session.getAttribute("PolmCode"));
              cst.setBigDecimal(4,(BigDecimal)session.getAttribute("PolmMemCode"));
              cst.execute();
              cst.close();
            }
            conn.close();   
            session.setAttribute("editComponents", "N");
            GlobalCC.RedirectPage("/g_undwrt.jspx");
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }

      return null;
    }
    
    public String saveDependants() {
        DBConnector myConn=new DBConnector();
       Connection conn=myConn.getDatabaseConn();
       CallableStatement cst=null;
    
    
      
       try {
         String polQuery="begin LMS_WEB_PKG_GRP.createDependents(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);end;";
         cst=conn.prepareCall(polQuery);
         
         if(djMemNo.getValue()==null){
           cst.setBigDecimal(1, null);
         }else{
           cst.setString(1, djMemNo.getValue().toString());
         }
         if(djSurname.getValue()==null){
           cst.setBigDecimal(2, null);
         }else{
           cst.setString(2, djSurname.getValue().toString());
         }
         if(djOtherNames.getValue()==null){
           cst.setBigDecimal(3, null);
         }else{
           cst.setString(3, djOtherNames.getValue().toString());
         }
         cst.setBigDecimal(4, (BigDecimal)session.getAttribute("DepTypeCode"));
         if(djSex.getValue()==null){
           cst.setBigDecimal(5, null);
         }else{
           cst.setString(5, djSex.getValue().toString());
         }
         if (djDOB.getValue()==null){
           cst.setString(6,null);
         }else{
           cst.setString(6, GlobalCC.parseDate(djDOB.getValue().toString()));
         }
         
         cst.setString(7, (String)session.getAttribute("DepTypeDesc"));
         if(djIDNo.getValue()==null){
           cst.setBigDecimal(8, null);
         }else{
           cst.setString(8, djIDNo.getValue().toString());
         }
         cst.setString(9, "P");
         cst.setBigDecimal(10, (BigDecimal)session.getAttribute("MemberNumber"));
         cst.setBigDecimal(11, (BigDecimal)session.getAttribute("prpCode"));
         cst.setBigDecimal(12, (BigDecimal)session.getAttribute("PolicyCategory"));
         cst.setBigDecimal(13,(BigDecimal)session.getAttribute("ProductCode")); 
         cst.setBigDecimal(14,(BigDecimal)session.getAttribute("endorsementCode"));
         if(djAddress.getValue()==null){
          cst.setString(15, null);   
           }else{
             cst.setString(15, djAddress.getValue().toString());  
           }
         if(djPinNo.getValue()==null){
          cst.setString(16, null);   
           }else{
             cst.setString(16, djPinNo.getValue().toString());  
           }
         cst.execute(); 
         cst.close();
           conn.close();   
 
           djMemNo.setValue(null);
           djSurname.setValue(null);
           djOtherNames.setValue(null);
           djSex.setValue(null);
           djDOB.setValue(null);
           djIDNo.setValue(null);
           djAddress.setValue(null);
           djPinNo.setValue(null);    
           AdfFacesContext.getCurrentInstance().addPartialTarget(djMemNo);
           AdfFacesContext.getCurrentInstance().addPartialTarget(djSurname);
           AdfFacesContext.getCurrentInstance().addPartialTarget(djOtherNames);
           AdfFacesContext.getCurrentInstance().addPartialTarget(djSex);
           AdfFacesContext.getCurrentInstance().addPartialTarget(djDOB);
           AdfFacesContext.getCurrentInstance().addPartialTarget(djIDNo);
           session.setAttribute("CurrentStatus", "P");
            ADFUtils.findIterator("FindMemberDependantsIterator").executeQuery();    
         AdfFacesContext.getCurrentInstance().addPartialTarget(memDependantsLOV);
         
         
         
         String Message = "Dependant Added";
         FacesContext.getCurrentInstance().addMessage(null, 
                                                      new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                       Message, 
                                                                       Message));
        
         
         
       }
       catch(Exception e) {
           
           djMemNo.setValue(null);
           djSurname.setValue(null);
           djOtherNames.setValue(null);
           djSex.setValue(null);
           djDOB.setValue(null);
           djIDNo.setValue(null);
           
           AdfFacesContext.getCurrentInstance().addPartialTarget(djMemNo);
           AdfFacesContext.getCurrentInstance().addPartialTarget(djSurname);
           AdfFacesContext.getCurrentInstance().addPartialTarget(djOtherNames);
           AdfFacesContext.getCurrentInstance().addPartialTarget(djSex);
           AdfFacesContext.getCurrentInstance().addPartialTarget(djDOB);
           AdfFacesContext.getCurrentInstance().addPartialTarget(djIDNo);
           
         GlobalCC.EXCEPTIONREPORTING(conn, e);
       }
       return null;
     }
    public String AlterMemberDetails(){
         Connection conn=null;
        try{
            String todayString = null;
            if(dob.getValue()==null){
                GlobalCC.INFORMATIONREPORTING("Enter a Date of Birth");
                return null;
            }
            if(dob.getValue().toString().contains(":")){
                todayString = GlobalCC.parseDate(dob.getValue().toString());
            }else{
                todayString = GlobalCC.upDateParseDate(dob.getValue().toString());
            }
            
            String deleteMember ="BEGIN LMS_WEB_PKG_GRP_UW.update_mem_other_dtls(?,?,?,?,?,?,?,?,?);END;";
           conn=new DBConnector().getDatabaseConn();
            CallableStatement cstmt=conn.prepareCall(deleteMember);
            cstmt.setBigDecimal(1,(BigDecimal)session.getAttribute("policyCode"));
            cstmt.setBigDecimal(2,(BigDecimal)session.getAttribute("endorsementCode"));
            cstmt.setBigDecimal(3,(BigDecimal)session.getAttribute("MemberNumber"));
            if(memNo.getValue()==null){
                cstmt.setString(4, null);   
            }else{
                cstmt.setString(4, memNo.getValue().toString());   
            }
            if(surname.getValue()==null){
                cstmt.setString(5, null);   
            }else{
                cstmt.setString(5, surname.getValue().toString());   
            }
            if(otherNames.getValue()==null){
                cstmt.setString(6, null);   
            }else{
                cstmt.setString(6, otherNames.getValue().toString());   
            }
            if(memsex.getValue()==null){
                cstmt.setString(7, null);   
            }else{
                cstmt.setString(7, memsex.getValue().toString());   
            }
            if(dob.getValue()==null){
                cstmt.setString(8, null);   
            }else{
                cstmt.setString(8, todayString);   
            }
            if(memOccupation.getValue()==null){
              cstmt.setString(9, null);   
            }else{
              cstmt.setString(9, memOccupation.getValue().toString());   
            }
            
            cstmt.execute();
            conn.close();

            ADFUtils.findIterator("FindIndivudualMemberDetailsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(memNoDisplay);
            AdfFacesContext.getCurrentInstance().addPartialTarget(memberNameDisp);
            ADFUtils.findIterator("FindIndivudualMemberCoversIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(coversLOV);
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }
        return null;
    }
    
    public String EditMember(){
        try{
            ADFUtils.findIterator("FindIndivudualMemberDetailsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(memNo);
            AdfFacesContext.getCurrentInstance().addPartialTarget(surname);
            AdfFacesContext.getCurrentInstance().addPartialTarget(otherNames);
            AdfFacesContext.getCurrentInstance().addPartialTarget(memsex);
            AdfFacesContext.getCurrentInstance().addPartialTarget(dob);
            
            //Render Popup
            ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
            ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
            "var hints = {autodismissNever:false}; " +
            "AdfPage.PAGE.findComponent('" + "lmsgroup:p1" +
            "').show(hints);");
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }
    
    public String EditCover(){
        try{
            DCIteratorBinding dciter = ADFUtils.findIterator("FindIndivudualMemberCoversIterator");
            RowKeySet set =coversLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            
            while (rowKeySetIter.hasNext()) 
            {
                List l = (List) rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
               
                String MainRider = (String)r.getAttribute("PCM_MAIN_RIDER");
                if(!MainRider.equalsIgnoreCase("M") && !MainRider.equalsIgnoreCase("S")){
                  GlobalCC.INFORMATIONREPORTING("You can only edit the Main Cover.");
                  return null;
                }
                session.setAttribute("memcoverID", r.getAttribute("CVT_PCM_CODE"));
                //session.setAttribute("memCoverTypeCode", r.getAttribute("CVT_PCM_PCVT_CVT_CODE"));
                oldEarnAmt.setValue(r.getAttribute("CVT_PCM_EARNINGS"));
                oldEarnPeriod.setValue(r.getAttribute("CVT_PCM_MULT_EARNINGS_PRD"));
                newEarnAmt.setValue(r.getAttribute("CVT_PCM_EARNINGS"));
                newEarnPeriod.setValue(r.getAttribute("CVT_PCM_MULT_EARNINGS_PRD"));
                oldLoanAmt.setValue(r.getAttribute("CVT_PCM_ORIGINAL_LOAN_AMT"));
                oldLoanPrd.setValue(r.getAttribute("CVT_PCM_ORIG_LOAN_REPAYMENT_PRD"));
                oldLoanInt.setValue(r.getAttribute("PCM_LOAN_INT"));
                oldLoanDate.setValue(r.getAttribute("CVT_PCM_LOAN_ISSUE_DATE"));
                newLoanAmt.setValue(r.getAttribute("CVT_PCM_ORIGINAL_LOAN_AMT"));
                newLoanPrd.setValue(r.getAttribute("CVT_PCM_ORIG_LOAN_REPAYMENT_PRD"));
                newLoanInt.setValue(r.getAttribute("PCM_LOAN_INT"));
                newLoanDate.setValue(r.getAttribute("CVT_PCM_LOAN_ISSUE_DATE"));
             
                //Render Popup
                GlobalCC.showPopup("lmsgroup:p2");
            }      
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }
    
    public String AlterMemberPensionDetails (){
        
         Connection conn=null;
      try
      {
       
        String deleteQuery="BEGIN LMS_WEB_PKG_GRP_UW.Remove_Alter_pension_dtls(?,?,?,?);END;";
        conn=new DBConnector().getDatabaseConn();
        CallableStatement cstmt=conn.prepareCall(deleteQuery);
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("PolmCode"));
        if(pmpnsCode.getValue()==null){
            cstmt.setBigDecimal(2, null);     
        }else{
            cstmt.setString(2, pmpnsCode.getValue().toString());        
        }    
        cstmt.setString(3, "A");
        cstmt.setBigDecimal(4, (BigDecimal)session.getAttribute("endorsementCode"));
         

          cstmt.execute();
          conn.close();    
          String Message = "Pension Details Altered.";
          FacesContext.getCurrentInstance().addMessage(null, 
                                                       new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                        Message, 
                                                                        Message));  
      }
      catch(Exception e) 
      {
          session.setAttribute("memcoverID", null);
          GlobalCC.EXCEPTIONREPORTING(conn,e);
          
      }
      return null;
    }
    
    public String UpdateMemberCoverDetails(){
         Connection conn=null;
      try
      {
        String deleteQuery="BEGIN LMS_WEB_PKG_GRP_UW.alter_mem_cvr_dtls(?,?,?,?,?,?,?,?,?,?);END;";
        conn=new DBConnector().getDatabaseConn();
        CallableStatement cstmt=conn.prepareCall(deleteQuery);
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("endorsementCode"));
        cstmt.setBigDecimal(2, (BigDecimal)session.getAttribute("memcoverID"));
          if(newEarnAmt.getValue()==null){
              if(oldEarnAmt.getValue()==null){
                cstmt.setString(3, null);
              }else{
                cstmt.setString(3, oldEarnAmt.getValue().toString());
              }
          }else{
              cstmt.setString(3, newEarnAmt.getValue().toString());
          }
          if(newLoanAmt.getValue()==null){
            if(oldLoanAmt.getValue()==null){
              cstmt.setString(4, null);
            }else{
              cstmt.setString(4, oldLoanAmt.getValue().toString());
            }
          }else{
              cstmt.setString(4, newLoanAmt.getValue().toString());
          }
          if(newEarnPeriod.getValue()==null){
            if(oldEarnPeriod.getValue()==null){
              cstmt.setString(5, null);
            }else{
              cstmt.setString(5, oldEarnPeriod.getValue().toString());
            }
          }else{
              cstmt.setString(5, newEarnPeriod.getValue().toString());
          }
          cstmt.setString(6, null);
          if(newLoanInt.getValue()==null){
            if(oldLoanInt.getValue()==null){
              cstmt.setString(7, null);
            }else{
              cstmt.setString(7, oldLoanInt.getValue().toString());
            }
          }else{
              cstmt.setString(7, newLoanInt.getValue().toString());
          }
          if(newLoanDate.getValue()==null){
            if(oldLoanDate.getValue()==null){
              cstmt.setString(8, null);
            }else{
              cstmt.setString(8, GlobalCC.upDateParseDate(oldLoanDate.getValue().toString()));
            }
          }else{
              if(newLoanDate.getValue().toString().contains(":")){
                cstmt.setString(8, GlobalCC.parseDate(newLoanDate.getValue().toString()));   
              }else{
                cstmt.setString(8, GlobalCC.upDateParseDate(newLoanDate.getValue().toString()));    
              }
          }
          if(newLoanPrd.getValue()==null){
            if(oldLoanPrd.getValue()==null){
              cstmt.setString(9, null);
            }else{
              cstmt.setString(9, oldLoanPrd.getValue().toString());
            }
          }else{
              cstmt.setString(9, newLoanPrd.getValue().toString());
          }
          cstmt.setString(10, null);

          cstmt.execute();
          conn.close();
            ADFUtils.findIterator("FindIndivudualMemberCoversIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(coversLOV);
          session.setAttribute("memcoverID", null);
      }
      catch(Exception e) 
      {
          session.setAttribute("memcoverID", null);
          //session.setAttribute("memCoverTypeCode", null);
            GlobalCC.EXCEPTIONREPORTING(conn,e);
          
      }
      return null;
    }
    
    public void setMemDependantsLOV(RichTable memDependantsLOV) {
        this.memDependantsLOV = memDependantsLOV;
    }

    public RichTable getMemDependantsLOV() {
        return memDependantsLOV;
    }

    public void setDepTypeLOV2(RichTable depTypeLOV2) {
        this.depTypeLOV2 = depTypeLOV2;
    }

    public RichTable getDepTypeLOV2() {
        return depTypeLOV2;
    }

    public void setDjMemNo(RichInputText djMemNo) {
        this.djMemNo = djMemNo;
    }

    public RichInputText getDjMemNo() {
        return djMemNo;
    }

    public void setDjSurname(RichInputText djSurname) {
        this.djSurname = djSurname;
    }

    public RichInputText getDjSurname() {
        return djSurname;
    }

    public void setDjOtherNames(RichInputText djOtherNames) {
        this.djOtherNames = djOtherNames;
    }

    public RichInputText getDjOtherNames() {
        return djOtherNames;
    }

    public void setDjSex(RichSelectOneChoice djSex) {
        this.djSex = djSex;
    }

    public RichSelectOneChoice getDjSex() {
        return djSex;
    }

    public void setDjIDNo(RichInputText djIDNo) {
        this.djIDNo = djIDNo;
    }

    public RichInputText getDjIDNo() {
        return djIDNo;
    }

    public void setDjDOB(RichInputDate djDOB) {
        this.djDOB = djDOB;
    }

    public RichInputDate getDjDOB() {
        return djDOB;
    }

    public void setMemNo(RichInputText memNo) {
        this.memNo = memNo;
    }

    public RichInputText getMemNo() {
        return memNo;
    }

    public void setSurname(RichInputText surname) {
        this.surname = surname;
    }

    public RichInputText getSurname() {
        return surname;
    }

    public void setOtherNames(RichInputText otherNames) {
        this.otherNames = otherNames;
    }

    public RichInputText getOtherNames() {
        return otherNames;
    }

    public void setMemsex(RichSelectOneChoice memsex) {
        this.memsex = memsex;
    }

    public RichSelectOneChoice getMemsex() {
        return memsex;
    }

    public void setDob(RichInputDate dob) {
        this.dob = dob;
    }

    public RichInputDate getDob() {
        return dob;
    }

    public void setMemNoDisplay(RichOutputText memNoDisplay) {
        this.memNoDisplay = memNoDisplay;
    }

    public RichOutputText getMemNoDisplay() {
        return memNoDisplay;
    }

    public void setMemberNameDisp(RichOutputText memberNameDisp) {
        this.memberNameDisp = memberNameDisp;
    }

    public RichOutputText getMemberNameDisp() {
        return memberNameDisp;
    }

    public void setCoversLOV(RichTable coversLOV) {
        this.coversLOV = coversLOV;
    }

    public RichTable getCoversLOV() {
        return coversLOV;
    }

    public void setOldEarnAmt(RichInputText oldEarnAmt) {
        this.oldEarnAmt = oldEarnAmt;
    }

    public RichInputText getOldEarnAmt() {
        return oldEarnAmt;
    }

    public void setOldEarnPeriod(RichInputText oldEarnPeriod) {
        this.oldEarnPeriod = oldEarnPeriod;
    }

    public RichInputText getOldEarnPeriod() {
        return oldEarnPeriod;
    }

    public void setNewEarnAmt(RichInputText newEarnAmt) {
        this.newEarnAmt = newEarnAmt;
    }

    public RichInputText getNewEarnAmt() {
        return newEarnAmt;
    }

    public void setNewEarnPeriod(RichInputText newEarnPeriod) {
        this.newEarnPeriod = newEarnPeriod;
    }

    public RichInputText getNewEarnPeriod() {
        return newEarnPeriod;
    }

    public void setPmpnsCode(RichInputText pmpnsCode) {
        this.pmpnsCode = pmpnsCode;
    }

    public RichInputText getPmpnsCode() {
        return pmpnsCode;
    }

    public void setOldLoanAmt(RichInputText oldLoanAmt) {
        this.oldLoanAmt = oldLoanAmt;
    }

    public RichInputText getOldLoanAmt() {
        return oldLoanAmt;
    }

    public void setNewLoanAmt(RichInputText newLoanAmt) {
        this.newLoanAmt = newLoanAmt;
    }

    public RichInputText getNewLoanAmt() {
        return newLoanAmt;
    }

    public void setOldLoanPrd(RichInputText oldLoanPrd) {
        this.oldLoanPrd = oldLoanPrd;
    }

    public RichInputText getOldLoanPrd() {
        return oldLoanPrd;
    }

    public void setNewLoanPrd(RichInputText newLoanPrd) {
        this.newLoanPrd = newLoanPrd;
    }

    public RichInputText getNewLoanPrd() {
        return newLoanPrd;
    }

    public void setOldLoanInt(RichInputText oldLoanInt) {
        this.oldLoanInt = oldLoanInt;
    }

    public RichInputText getOldLoanInt() {
        return oldLoanInt;
    }

    public void setNewLoanInt(RichInputText newLoanInt) {
        this.newLoanInt = newLoanInt;
    }

    public RichInputText getNewLoanInt() {
        return newLoanInt;
    }

    public void setOldLoanDate(RichInputDate oldLoanDate) {
        this.oldLoanDate = oldLoanDate;
    }

    public RichInputDate getOldLoanDate() {
        return oldLoanDate;
    }

    public void setNewLoanDate(RichInputDate newLoanDate) {
        this.newLoanDate = newLoanDate;
    }

    public RichInputDate getNewLoanDate() {
        return newLoanDate;
    }

    public void setOccupation(RichInputDate occupation) {
        this.occupation = occupation;
    }

    public RichInputDate getOccupation() {
        return occupation;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setTEST(RichInputText TEST) {
        this.TEST = TEST;
    }

    public RichInputText getTEST() {
        return TEST;
    }

    public void setMemOccupation(RichInputText memOccupation) {
        this.memOccupation = memOccupation;
    }

    public RichInputText getMemOccupation() {
        return memOccupation;
    }

    public void setOccupLOV(RichTable occupLOV) {
        this.occupLOV = occupLOV;
    }

    public RichTable getOccupLOV() {
        return occupLOV;
    }

    public String selectOccupation() {
        // Add event code here.
        try{
       DCIteratorBinding dciter = ADFUtils.findIterator("findGroupOccupationsIterator");
        RowKeySet set =occupLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        while (rowKeySetIter.hasNext())
        {
         List l = (List) rowKeySetIter.next();
         Key key = (Key)l.get(0);
         dciter.setCurrentRowWithKey(key.toStringFormat(true));
         Row r = dciter.getCurrentRow();  
         memOccupation.setValue(r.getAttribute("LC_DESC"));   
         AdfFacesContext.getCurrentInstance().addPartialTarget(memOccupation);
         
        
        }
        GlobalCC.hidePopup("lmsgroup:p3");
           
        }catch(Exception e){
           GlobalCC.EXCEPTIONREPORTING(null,e);
        }

        return null;
    }

    public void setQuoMemNo(RichInputText quoMemNo) {
        this.quoMemNo = quoMemNo;
    }

    public RichInputText getQuoMemNo() {
        return quoMemNo;
    }

    public void setQuoSurname(RichInputText quoSurname) {
        this.quoSurname = quoSurname;
    }

    public RichInputText getQuoSurname() {
        return quoSurname;
    }

    public void setQuoOtherNames(RichInputText quoOtherNames) {
        this.quoOtherNames = quoOtherNames;
    }

    public RichInputText getQuoOtherNames() {
        return quoOtherNames;
    }

    public void setQuoMemsex(RichSelectOneChoice quoMemsex) {
        this.quoMemsex = quoMemsex;
    }

    public RichSelectOneChoice getQuoMemsex() {
        return quoMemsex;
    }

    public String backToQuotation() {
        // Add event code here...
        GlobalCC.RedirectPage("/gquoedt.jspx");
        return null;
    }

    public void setJointMembersLOV(RichTable jointMembersLOV) {
        this.jointMembersLOV = jointMembersLOV;
    }

    public RichTable getJointMembersLOV() {
        return jointMembersLOV;
    }

    public void setDjPinNo(RichInputText djPinNo) {
        this.djPinNo = djPinNo;
    }

    public RichInputText getDjPinNo() {
        return djPinNo;
    }

    public void setDjAddress(RichInputText djAddress) {
        this.djAddress = djAddress;
    }

    public RichInputText getDjAddress() {
        return djAddress;
    }

    public void setMemPinNo(RichInputText memPinNo) {
        this.memPinNo = memPinNo;
    }

    public RichInputText getMemPinNo() {
        return memPinNo;
    }

    public void setMemAddress(RichInputText memAddress) {
        this.memAddress = memAddress;
    }

    public RichInputText getMemAddress() {
        return memAddress;
    }
}
