package LMSG.view.Accounts;


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

import oracle.jbo.Key;
import oracle.jbo.Row;

import org.apache.myfaces.trinidad.model.RowKeySet;

import LMSG.view.Base.ADFUtils;

import LMSG.view.Base.GlobalCC;

import LMSG.view.connect.DBConnector;

public class receipting {
    private RichInputText receiptNo;
    private RichTable agentsLOV;
    private RichInputText agentsDesc;
    private RichInputText receiptAmount;
    private RichSelectOneChoice transaction;
    private RichInputDate paymentDate;
    private RichSelectOneChoice paymentMode;
    private RichInputText paymentSource;
    private RichTable policiesLOV;
    private RichInputText policiesDesc;
    private RichInputText refNo;
    private RichInputDate today;

    public receipting() {
        super();
    }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false); 
    public String findAgents() {
      DCIteratorBinding dciter = ADFUtils.findIterator("FindAgentsIterator");
      RowKeySet set =agentsLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      //System.out.println(1);
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
    
        //session.setAttribute("agnCode", r.getAttribute("AGN_CODE"));
        agentsDesc.setValue(r.getAttribute("AGN_SHT_DESC"));
        
      }
      return null;
    }
    
    public String findPolicies() {
      DCIteratorBinding dciter = ADFUtils.findIterator("FindPoliciesIterator");
      RowKeySet set =policiesLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      //System.out.println(1);
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
    
        //session.setAttribute("agnCode", r.getAttribute("AGN_CODE"));
        policiesDesc.setValue(r.getAttribute("POL_POLICY_NO"));
        
      }
      return null;
    }
    
    public String DoReceipting() 
    {
       Connection conn=null;
    try 
        {
     String coverDeleteQuery="BEGIN LMS_WEB_PKG_GRP_UW.create_receipt_not_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);END;";
     conn=new DBConnector().getDatabaseConn();
     CallableStatement cstmt=null;
     
       cstmt=conn.prepareCall(coverDeleteQuery);
        if(receiptNo.getValue()==null){
            cstmt.setString(1, null);   
        }else{
            cstmt.setString(1, receiptNo.getValue().toString());  
        }      
         if(agentsDesc.getValue()==null){
             cstmt.setString(2, null);   
         }else{
             cstmt.setString(2, agentsDesc.getValue().toString());  
         }      
         if(receiptAmount.getValue()==null){
             cstmt.setString(3, null);   
         }else{
             cstmt.setString(3, receiptAmount.getValue().toString());  
         }
         if(transaction.getValue()==null){
             cstmt.setString(4, null);   
         }else{
             cstmt.setString(4, transaction.getValue().toString());  
         }
         cstmt.setString(5, null); 
         cstmt.setString(6, null); 
         cstmt.setString(7, null); 
         cstmt.setString(8, null); 
         cstmt.setString(9, null); 
         if(paymentDate.getValue()==null){
             cstmt.setString(10, null);   
         }else{
             cstmt.setString(10, GlobalCC.parseDate(paymentDate.getValue().toString()));  
         } 
         if(paymentMode.getValue()==null){
             cstmt.setString(11, null);   
         }else{
             cstmt.setString(11, paymentMode.getValue().toString());  
         }
         if(paymentSource.getValue()==null){
             cstmt.setString(12, null);   
         }else{
             cstmt.setString(12, paymentSource.getValue().toString());  
         }
         if(policiesDesc.getValue()==null){
             cstmt.setString(13, null);   
         }else{
             cstmt.setString(13, policiesDesc.getValue().toString());  
         }
         cstmt.setString(14, null); 
         if(refNo.getValue()==null){
             cstmt.setString(15, null);   
         }else{
             cstmt.setString(15, refNo.getValue().toString());  
         }
         cstmt.setString(16, null);
         cstmt.setString(17, null); 
         cstmt.setString(18, null);
         cstmt.setString(19, null);
         if(today.getValue()==null){
             cstmt.setString(20, null);   
         }else{
             cstmt.setString(20, GlobalCC.parseDate(today.getValue().toString()));  
         }
         cstmt.setString(21, null);
         cstmt.setString(22, null);
         cstmt.setString(23, null);
         cstmt.setString(24, (String)session.getAttribute("Username"));
        
         cstmt.execute();
         cstmt.close();
        
         GlobalCC.INFORMATIONREPORTING("Receipting Complete.");
         conn.close();
     
     }
     catch(Exception ex) 
     {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
     }
      return null;
    }

    public void setReceiptNo(RichInputText receiptNo) {
        this.receiptNo = receiptNo;
    }

    public RichInputText getReceiptNo() {
        return receiptNo;
    }

    public void setAgentsLOV(RichTable agentsLOV) {
        this.agentsLOV = agentsLOV;
    }

    public RichTable getAgentsLOV() {
        return agentsLOV;
    }

    public void setAgentsDesc(RichInputText agentsDesc) {
        this.agentsDesc = agentsDesc;
    }

    public RichInputText getAgentsDesc() {
        return agentsDesc;
    }

    public void setReceiptAmount(RichInputText receiptAmount) {
        this.receiptAmount = receiptAmount;
    }

    public RichInputText getReceiptAmount() {
        return receiptAmount;
    }

    public void setTransaction(RichSelectOneChoice transaction) {
        this.transaction = transaction;
    }

    public RichSelectOneChoice getTransaction() {
        return transaction;
    }

    public void setPaymentDate(RichInputDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public RichInputDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentMode(RichSelectOneChoice paymentMode) {
        this.paymentMode = paymentMode;
    }

    public RichSelectOneChoice getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentSource(RichInputText paymentSource) {
        this.paymentSource = paymentSource;
    }

    public RichInputText getPaymentSource() {
        return paymentSource;
    }

    public void setPoliciesLOV(RichTable policiesLOV) {
        this.policiesLOV = policiesLOV;
    }

    public RichTable getPoliciesLOV() {
        return policiesLOV;
    }

    public void setPoliciesDesc(RichInputText policiesDesc) {
        this.policiesDesc = policiesDesc;
    }

    public RichInputText getPoliciesDesc() {
        return policiesDesc;
    }

    public void setRefNo(RichInputText refNo) {
        this.refNo = refNo;
    }

    public RichInputText getRefNo() {
        return refNo;
    }

    public void setToday(RichInputDate today) {
        this.today = today;
    }

    public RichInputDate getToday() {
        return today;
    }
}
