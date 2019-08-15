package LMSG.view.Policy;

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

import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Key;
import oracle.jbo.Row;

import oracle.jdbc.OracleTypes;

import org.apache.myfaces.trinidad.model.RowKeySet;

import LMSG.view.Base.ADFUtils;

import LMSG.view.Base.GlobalCC;
import LMSG.view.Base.LOVCC;

import LMSG.view.QuotationProcessing.QuotDAO;

import LMSG.view.connect.DBConnector;

public class PolicyTransactions extends LOVCC {
    private RichTable productLOV;
    private RichInputText productDesc;
    private RichTable policiesLOV;
    private RichInputText policiesDesc;
    private RichTable contraTransLOV;
    private RichInputText transSel;
    private RichInputDate effDate;
    private RichPanelBox transactions;
    private RichTable transLOV;
    private RichPanelBox search;
    private RichCommandButton searchButton;
    private RichInputDate conEffDate;
    
    protected static String PolicyNumber = null;
    protected static String btrCode = null;
    protected static String TransNumber = null;
    private RichInputText schMonth;
    private RichInputText schYear;

    public PolicyTransactions() {
        super();
    }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    public String findProductSelected() {
      DCIteratorBinding dciter = ADFUtils.findIterator("findProductsIterator");
      RowKeySet set =productLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
          
          productDesc.setValue(r.getAttribute("prodDesc"));
          //LOVCC.ProductCode = (BigDecimal)r.getAttribute("prodCode");
          session.setAttribute("ProductCode", r.getAttribute("prodCode"));
          
          policiesDesc.setValue(null);
          //LOVCC.policyCode=null;
          session.setAttribute("policyCode", null);
          //LOVCC.PolicyTransCode=null;
          session.setAttribute("PolicyTransCode", null);
          transSel.setValue(null);
            ADFUtils.findIterator("FindPoliciesIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(policiesLOV);
          
          
       
      }

      return null;
    }
    
    public String findPoliciesSelected() {
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
          policiesDesc.setValue(r.getAttribute("POL_POLICY_NO"));
          PolicyNumber = (String)r.getAttribute("POL_POLICY_NO");
          effDate.setValue(r.getAttribute("POL_EFFECTIVE_DATE"));
         
          //LOVCC.policyCode=(BigDecimal)r.getAttribute("POL_CODE");
          session.setAttribute("policyCode", r.getAttribute("POL_CODE"));
          
          //LOVCC.PolicyTransCode=null;
          session.setAttribute("PolicyTransCode", null);
          transSel.setValue(null);
            ADFUtils.findIterator("FindContraPoliciesIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(contraTransLOV);
         

       
      }

      return null;
    }
    
    public String findRTProductSelected() {
      DCIteratorBinding dciter = ADFUtils.findIterator("findProductsIterator");
      RowKeySet set =productLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
          
          productDesc.setValue(r.getAttribute("prodDesc"));
          //LOVCC.ProductCode = (BigDecimal)r.getAttribute("prodCode");
          session.setAttribute("ProductCode", r.getAttribute("prodCode"));
          
          policiesDesc.setValue(null);
          //LOVCC.policyCode=null;
          session.setAttribute("policyCode", null);

            ADFUtils.findIterator("FindReinstatePolicyCandidatesIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(policiesLOV);
          
          
       
      }

      return null;
    }
    
    public String findRTPoliciesSelected() {
      DCIteratorBinding dciter = ADFUtils.findIterator("FindReinstatePolicyCandidatesIterator");
      RowKeySet set =policiesLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      //System.out.println(1);
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
          policiesDesc.setValue(r.getAttribute("RT_pol_policy_no"));
         
          effDate.setValue(r.getAttribute("RT_pol_effective_date"));
         
          //LOVCC.policyCode=(BigDecimal)r.getAttribute("RT_pol_code");
          session.setAttribute("policyCode", r.getAttribute("RT_pol_code"));

         

       
      }

      return null;
    }
    
    public String SearchResults(){
        
        if(policiesDesc.getValue()==null){
        
          String Message = "Select a Policy";
          FacesContext.getCurrentInstance().addMessage(null, 
                                                       new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                        Message, 
                                                                        Message));
          
          return null;
        }
        
        
        if(conEffDate.getValue()==null){
        
          String Message = "Enter a Transaction Effective Date";
          FacesContext.getCurrentInstance().addMessage(null, 
                                                       new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                        Message, 
                                                                        Message));
          
          return null;
        }
        schMonth.setValue(null);
        schYear.setValue(null);
        
        searchButton.setDisabled(true);
        transactions.setRendered(true);
        
        return null;
    }
    
    public String ReinstatePolicy(){
     
        DBConnector myConn=new DBConnector();
        Connection conn=myConn.getDatabaseConn();
        CallableStatement cst=null;
        int NewEndorsement = 0;
        
        if(schMonth.getValue()==null){
        
          String Message = "Enter a Schedule Month";
          FacesContext.getCurrentInstance().addMessage(null, 
                                                       new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                        Message, 
                                                                        Message));
          
          return null;
        }
        
        if(schYear.getValue()==null){
        
          String Message = "Enter a Schedule Year";
          FacesContext.getCurrentInstance().addMessage(null, 
                                                       new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                        Message, 
                                                                        Message));
          
          return null;
        }
        
        try {
         
          String polQuery="begin LMS_WEB_PKG_GRP.reinstate_policy(?,?,?,?,?,?);end;";
          cst=conn.prepareCall(polQuery);
          
          
          cst.setBigDecimal(1, (BigDecimal)session.getAttribute("policyCode"));
          cst.setString(2, GlobalCC.parseDate(conEffDate.getValue().toString())); 
          cst.setString(3, schMonth.getValue().toString());
          cst.setString(4, schYear.getValue().toString());
          cst.registerOutParameter(5, OracleTypes.DECIMAL);
          cst.registerOutParameter(6, OracleTypes.DECIMAL);

          cst.execute(); 
          
          //NewEndorsement = cst.getInt(5);
          //BigDecimal EndorsementNo = new BigDecimal(NewEndorsement);
          //LOVCC.endorsementCode = EndorsementNo;
          //LOVCC.endorsementCode= EndorsementNo;
          //LOVCC.transactionNumber = cst.getBigDecimal(6);
          session.setAttribute("endorsementCode", cst.getBigDecimal(5));
          session.setAttribute("transactionNumber", cst.getBigDecimal(6));
            //underwritingPolicy.UW = "U";
          session.setAttribute("SystemPoint","U");
          cst.close();
          conn.close(); 
          session.setAttribute("editComponents", "N");
          GlobalCC.RedirectPage("/g_undwrt.jspx");   
          
        }
        catch(Exception e) {
          GlobalCC.EXCEPTIONREPORTING(conn, e);
        }   
        return null;
    }
    
    public String findTransactionsSelected() {
      DCIteratorBinding dciter = ADFUtils.findIterator("FindContraPoliciesIterator");
      RowKeySet set =contraTransLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      //System.out.println(1);
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
          transSel.setValue(r.getAttribute("trans"));
         
          //LOVCC.PolicyTransCode=(BigDecimal)r.getAttribute("co_ltr_endr_code");
          session.setAttribute("PolicyTransCode", r.getAttribute("co_ltr_endr_code"));
          btrCode = (String)r.getAttribute("co_ltr_btr_trans_code");
          TransNumber = (String)r.getAttribute("co_ltr_trans_no");
         

      }

      return null;
    }
   
    public String CreateContraEndorsement(){
     
        DBConnector myConn=new DBConnector();
        Connection conn=myConn.getDatabaseConn();
        CallableStatement cst=null;
        int NewEndorsement = 0;
        
        try {
         
          String polQuery="begin LMS_GRP_WEB_PKG.CREATE_ENDOS_CONTRA(?,?,?,?,?,?,?,?);end;";
          cst=conn.prepareCall(polQuery);
          
          
          cst.setBigDecimal(1, (BigDecimal)session.getAttribute("policyCode"));
          cst.setBigDecimal(2, (BigDecimal)session.getAttribute("PolicyTransCode"));
          cst.setString(3, PolicyNumber);
          cst.setString(4, GlobalCC.parseDate(conEffDate.getValue().toString())); 
          cst.setString(5, btrCode);
          cst.setString(6, TransNumber);
          cst.registerOutParameter(7, OracleTypes.DECIMAL);
          cst.registerOutParameter(8, OracleTypes.DECIMAL);
         
          cst.execute(); 
          //NewEndorsement = cst.getInt(8);
          //BigDecimal EndorsementNo = new BigDecimal(NewEndorsement);
          //LOVCC.endorsementCode = EndorsementNo;
          //LOVCC.endorsementCode= EndorsementNo;
          //LOVCC.transactionNumber = cst.getBigDecimal(7);
          session.setAttribute("endorsementCode", cst.getBigDecimal(8));
            session.setAttribute("transactionNumber", cst.getBigDecimal(7));
          cst.close();
            conn.close();   
          session.setAttribute("editComponents", "N");
          GlobalCC.RedirectPage("/g_undwrt.jspx");   
          
        }
        catch(Exception e) {
          GlobalCC.EXCEPTIONREPORTING(conn, e);
        }   
        return null;
    }
  
    public String findPendingTransactions(){
        int TotalTransactions = 0;
        
         DBConnector myConn=new DBConnector();
        Connection conn=myConn.getDatabaseConn();
        
        if(policiesDesc.getValue()==null){
        
          String Message = "Select a Policy";
          FacesContext.getCurrentInstance().addMessage(null, 
                                                       new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                        Message, 
                                                                        Message));
          
          return null;
        }
        
        if(transSel.getValue()==null){
        
          String Message = "Select a Transaction to Contra";
          FacesContext.getCurrentInstance().addMessage(null, 
                                                       new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                        Message, 
                                                                        Message));
          
          return null;
        }
        
        if(conEffDate.getValue()==null){
        
          String Message = "Enter a Transaction Effective Date";
          FacesContext.getCurrentInstance().addMessage(null, 
                                                       new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                        Message, 
                                                                        Message));
          
          return null;
        }
        
        try{

            String PendingTrans = "begin LMS_WEB_CURSOR_GRP.getPendingTransactions(?,?);end;";
            CallableStatement cst1 = conn.prepareCall(PendingTrans);
            cst1.setBigDecimal(1, (BigDecimal)session.getAttribute("policyCode"));
            System.out.println((BigDecimal)session.getAttribute("policyCode"));
            cst1.registerOutParameter(2, OracleTypes.INTEGER);
            cst1.execute(); 
            TotalTransactions = cst1.getInt(2);
            if (TotalTransactions > 0){
              String Message = "This Policy has Another Unfinished Transaction....";
              FacesContext.getCurrentInstance().addMessage(null, 
                                                           new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                            Message, 
                                                                            Message));

                ADFUtils.findIterator("FindPendingTransactionsIterator").executeQuery();    
              AdfFacesContext.getCurrentInstance().addPartialTarget(transLOV);
              searchButton.setDisabled(true);
              transactions.setRendered(true);
        }else{
            CreateContraEndorsement();
        }
            conn.close();        
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }
        
        return null;
    }
    
    public String findPendingEndorsementSelected() {
      DCIteratorBinding dciter = ADFUtils.findIterator("FindPendingTransactionsIterator");
      RowKeySet set =transLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      //System.out.println(1);
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
         //LOVCC.endorsementCode = (BigDecimal)r.getAttribute("PT_ENDR_CODE");
         session.setAttribute("endorsementCode", (BigDecimal)r.getAttribute("PT_ENDR_CODE"));
        
        try{
          session.setAttribute("editComponents", "N");
          GlobalCC.RedirectPage("/g_undwrt.jspx");   
        }      
      catch(Exception e) {
        GlobalCC.EXCEPTIONREPORTING(null, e);
      }
       
      }

      return null;
    }
    
    public String DeletePendingEndorsementSelected() {
      BigDecimal EndorsementCode = null;
      BigDecimal TransCode = null;
      
      DCIteratorBinding dciter = ADFUtils.findIterator("FindPendingTransactionsIterator");
      RowKeySet set =transLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      //System.out.println(1);
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
          EndorsementCode = (BigDecimal)r.getAttribute("PT_ENDR_CODE");
          TransCode = (BigDecimal)r.getAttribute("PT_ENDR_LTR_TRANS_NO");

        try{
          
           DBConnector myConn=new DBConnector();
          Connection conn=myConn.getDatabaseConn();

          String PendingTrans = "begin LMS_GRP_TRANSACTIONS.DEL_GRP_POL_DTLS_PROC(?,?,?);end;";
          CallableStatement cst1 = conn.prepareCall(PendingTrans);
          cst1.setBigDecimal(1, (BigDecimal)session.getAttribute("policyCode"));
          cst1.setBigDecimal(2, EndorsementCode);
          cst1.setBigDecimal(3, TransCode);
          cst1.execute(); 
            conn.close();    
          String Message = "Endorsement Deleted";
          FacesContext.getCurrentInstance().addMessage(null, 
                                                       new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                        Message, 
                                                                        Message));
          
          CancelContra();
         
            
        }      
      catch(Exception e) {
        GlobalCC.EXCEPTIONREPORTING(null, e);
      }
       
      }

      return null;
    }
    
    public String CancelContra(){
        transactions.setRendered(false);
        searchButton.setDisabled(false);
        return null;
    }

    public void setProductLOV(RichTable productLOV) {
        this.productLOV = productLOV;
    }

    public RichTable getProductLOV() {
        return productLOV;
    }

    public void setProductDesc(RichInputText productDesc) {
        this.productDesc = productDesc;
    }

    public RichInputText getProductDesc() {
        return productDesc;
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

    public void setContraTransLOV(RichTable contraTransLOV) {
        this.contraTransLOV = contraTransLOV;
    }

    public RichTable getContraTransLOV() {
        return contraTransLOV;
    }

    public void setTransSel(RichInputText transSel) {
        this.transSel = transSel;
    }

    public RichInputText getTransSel() {
        return transSel;
    }

    public void setEffDate(RichInputDate effDate) {
        this.effDate = effDate;
    }

    public RichInputDate getEffDate() {
        return effDate;
    }

    public void setTransactions(RichPanelBox transactions) {
        this.transactions = transactions;
    }

    public RichPanelBox getTransactions() {
        return transactions;
    }

    public void setTransLOV(RichTable transLOV) {
        this.transLOV = transLOV;
    }

    public RichTable getTransLOV() {
        return transLOV;
    }

    public void setSearch(RichPanelBox search) {
        this.search = search;
    }

    public RichPanelBox getSearch() {
        return search;
    }

    public void setSearchButton(RichCommandButton searchButton) {
        this.searchButton = searchButton;
    }

    public RichCommandButton getSearchButton() {
        return searchButton;
    }

    public void setConEffDate(RichInputDate conEffDate) {
        this.conEffDate = conEffDate;
    }

    public RichInputDate getConEffDate() {
        return conEffDate;
    }

    public void setSchMonth(RichInputText schMonth) {
        this.schMonth = schMonth;
    }

    public RichInputText getSchMonth() {
        return schMonth;
    }

    public void setSchYear(RichInputText schYear) {
        this.schYear = schYear;
    }

    public RichInputText getSchYear() {
        return schYear;
    }
}
