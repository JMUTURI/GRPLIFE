package LMSG.view.Endorsements;

import LMSG.view.TableTypes.MemberReinstatements;


import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.util.LinkedList;
import java.util.List;

import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.view.rich.component.rich.data.RichTable;

import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputNumberSpinbox;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.uicli.binding.JUCtrlValueBinding;

import oracle.sql.ARRAY;

import oracle.sql.ArrayDescriptor;

import org.apache.myfaces.trinidad.model.RowKeySet;

import LMSG.view.Base.ADFUtils;

import LMSG.view.Base.GlobalCC;

import LMSG.view.connect.DBConnector;

public class EndorseManipulation {
    private RichTable memberReinstatements;
    private RichSelectBooleanCheckbox reinstCbox;
    private RichInputNumberSpinbox earningsAmount;
    private RichInputNumberSpinbox earningsPrd;
    private RichInputDate loanIssueDate;
    private RichInputNumberSpinbox savingsAmount;

    public EndorseManipulation() {
        super();
    }
  HttpSession session =
      (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);

    public void MemberReinstListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue()){
        RowKeySet rowKeySet = memberReinstatements.getSelectedRowKeys();
        if (rowKeySet == null) {
            return;
        }
        if (!rowKeySet.iterator().hasNext()) //no selection
        {
                GlobalCC.errorValueNotEntered("No Record Selected");
            return;
        }
        Object key2 = rowKeySet.iterator().next();
        memberReinstatements.setRowKey(key2);
        JUCtrlValueBinding nodeBinding =
            (JUCtrlValueBinding)memberReinstatements.getRowData();
        if (nodeBinding == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
            return;
        }
      
        if(reinstCbox.isSelected()){
          nodeBinding.setAttribute("selected", true);
        }else{
          nodeBinding.setAttribute("selected", false);
        }
      }
    }
    
    public String ReinstateMembers(){
        Connection conn = null;
        CallableStatement cst = null;
        try{
           boolean MakeCall = false;
          DBConnector db = new DBConnector();
          conn = db.getDatabaseConn(); 
          
          
          List ReinstInfo = new LinkedList();
          ARRAY array = null; 
          
          ArrayDescriptor descriptor =
              ArrayDescriptor.createDescriptor("LMS_MEMBER_REINST_TAB", conn);
          
          cst = conn.prepareCall("BEGIN LMS_WEB_PKG_GRP_UW.ReinstateMembers(?,?);end;");
           
            
          int rowCount = 0;
          boolean Value = false;
          rowCount = memberReinstatements.getRowCount();
          if (rowCount == 0){
              return null;
          }
            
          for (int i = 0; i < rowCount; i++) {
            memberReinstatements.setRowIndex(i);
            JUCtrlValueBinding nodeBinding =
                (JUCtrlValueBinding)memberReinstatements.getRowData();
            if (nodeBinding == null) {
                //do nothing...
            }else{
              Value = (Boolean)nodeBinding.getAttribute("selected");
                if (Value==true){
                  MakeCall = true;
                  java.sql.Date LoanDate = null;
                  if (loanIssueDate.getValue() == null) {

                  } else {
                      LoanDate =
                              new java.sql.Date(((java.util.Date)loanIssueDate.getValue()).getTime());
                  }
                  
                  MemberReinstatements pn = new MemberReinstatements();
                  pn.setPOLM_CODE((BigDecimal)nodeBinding.getAttribute("MEM_POLM_CODE"));
                  if(earningsAmount.getValue()==null){
                    pn.setPCM_EARNINGS(null);
                  }else{
                    pn.setPCM_EARNINGS(new BigDecimal(earningsAmount.getValue().toString()));
                  }
                  if(earningsPrd.getValue()==null){
                    pn.setPCM_MULT_EARNINGS_PRD(null);
                  }else{
                    pn.setPCM_MULT_EARNINGS_PRD(new BigDecimal(earningsPrd.getValue().toString()));
                  }
                  pn.setPCM_LOAN_ISSUE_DATE(LoanDate);
                 
                  String ProductType = (String)session.getAttribute("productType");
                  if(ProductType.equalsIgnoreCase("LOAN")){
                      if(earningsPrd.getValue()==null){
                        pn.setPCM_ORIG_LOAN_REPAYMENT_PRD(null);
                      }else{
                        pn.setPCM_ORIG_LOAN_REPAYMENT_PRD(new BigDecimal(earningsPrd.getValue().toString()));
                      }
                      if(earningsAmount.getValue()==null){
                        pn.setPCM_ORIGINAL_LOAN_AMT(null);
                      }else{
                        pn.setPCM_ORIGINAL_LOAN_AMT(new BigDecimal(earningsAmount.getValue().toString()));
                      }
                      if(savingsAmount.getValue()==null){
                        pn.setPCM_SAVING_AMT(null);
                      }else{
                        pn.setPCM_SAVING_AMT(new BigDecimal(savingsAmount.getValue().toString()));
                      }
                  }else{
                    pn.setPCM_ORIG_LOAN_REPAYMENT_PRD(null);
                    pn.setPCM_ORIGINAL_LOAN_AMT(null);
                    pn.setPCM_SAVING_AMT(null);
                  }
                  ReinstInfo.add(pn);
                }
            }
          }
          
          if(MakeCall==true){
            array = new ARRAY(descriptor, conn, ReinstInfo.toArray());
            
            cst.setArray(1, array);  
            cst.setBigDecimal(2, (BigDecimal)session.getAttribute("endorsementCode"));
            cst.execute();
            cst.close();
            conn.close();
                ADFUtils.findIterator("FindMembersToReinstateIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(memberReinstatements);
                GlobalCC.INFORMATIONREPORTING("Members Successfully Populated.");
          }
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }finally{
          GlobalCC.CloseConnections(null, cst, conn);
        } 
      return null;
    }

    public void setMemberReinstatements(RichTable memberReinstatements) {
        this.memberReinstatements = memberReinstatements;
    }

    public RichTable getMemberReinstatements() {
        return memberReinstatements;
    }

    public void setReinstCbox(RichSelectBooleanCheckbox reinstCbox) {
        this.reinstCbox = reinstCbox;
    }

    public RichSelectBooleanCheckbox getReinstCbox() {
        return reinstCbox;
    }

    public void setEarningsAmount(RichInputNumberSpinbox earningsAmount) {
        this.earningsAmount = earningsAmount;
    }

    public RichInputNumberSpinbox getEarningsAmount() {
        return earningsAmount;
    }

    public void setEarningsPrd(RichInputNumberSpinbox earningsPrd) {
        this.earningsPrd = earningsPrd;
    }

    public RichInputNumberSpinbox getEarningsPrd() {
        return earningsPrd;
    }

    public void setLoanIssueDate(RichInputDate loanIssueDate) {
        this.loanIssueDate = loanIssueDate;
    }

    public RichInputDate getLoanIssueDate() {
        return loanIssueDate;
    }

    public void setSavingsAmount(RichInputNumberSpinbox savingsAmount) {
        this.savingsAmount = savingsAmount;
    }

    public RichInputNumberSpinbox getSavingsAmount() {
        return savingsAmount;
    }
}
