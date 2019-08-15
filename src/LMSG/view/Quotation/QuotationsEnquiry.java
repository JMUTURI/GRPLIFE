package LMSG.view.Quotation;

import java.math.BigDecimal;

import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Key;
import oracle.jbo.Row;

import org.apache.myfaces.trinidad.event.SelectionEvent;
import org.apache.myfaces.trinidad.model.RowKeySet;

import LMSG.view.Base.ADFUtils;

import LMSG.view.Base.GlobalCC;
import LMSG.view.Base.LOVCC;

import LMSG.view.connect.DBConnector;

import java.sql.CallableStatement;
import java.sql.Connection;

import oracle.jbo.uicli.binding.JUCtrlValueBinding;

public class QuotationsEnquiry {
    private RichInputText productDesc;
    private RichTable productsLOV;
    private RichSelectOneChoice status;
    private RichInputDate dateFrom;
    private RichInputDate dateTo;
    private RichInputText clientsDesc;
    private RichTable clientsLOV;
    private RichInputText agentDesc;
    private RichTable agentsLOV;
    private RichInputText branchDesc;
    private RichTable branchesLOV;
    private RichTable quoteResultsLOV;
    private RichPanelBox resultsTab;
    private RichTable resultsLOV;
    private RichPanelBox ticketsTab;
    private RichSelectBooleanCheckbox quoteCBox;

    public QuotationsEnquiry() {
        super();
    }
    
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    
    public String findQuotationProducts() {
      DCIteratorBinding dciter = ADFUtils.findIterator("findProductsIterator");
      RowKeySet set =productsLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      //System.out.println(1);
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
    
        //LOVCC.ProductCode = (BigDecimal)r.getAttribute("prodCode");
        session.setAttribute("ProductCode", r.getAttribute("prodCode"));
        session.setAttribute("productType", r.getAttribute("prodType"));
        productDesc.setValue(r.getAttribute("prodshtDesc"));
        
        //conQuotationNoDispl.setValue(null);
        //session.setAttribute("prpCode", null);


        //ADFUtils.findIterator("findQuotationIterator").executeQuery();
        //AdfFacesContext.getCurrentInstance().addPartialTarget(quotationsTable);
        
      }
      return null;
    }
    
    public String findQuotationClients() {
      DCIteratorBinding dciter = ADFUtils.findIterator("findProposersIterator");
      RowKeySet set =clientsLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      //System.out.println(1);
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
    
        //LOVCC.ProductCode = (BigDecimal)r.getAttribute("prodCode");
        session.setAttribute("prpCode", r.getAttribute("PRP_CODE"));
        clientsDesc.setValue(r.getAttribute("CLIENT"));
        
      }
      return null;
    }
    
    public String findQuotationAgents() {
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
    
        session.setAttribute("agnCode", r.getAttribute("AGN_CODE"));
        agentDesc.setValue(r.getAttribute("AGN_NAME"));
        
      }
      return null;
    }
    
    public String findQuotationBranch() {
      DCIteratorBinding dciter = ADFUtils.findIterator("FindBranchesIterator");
      RowKeySet set =branchesLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      //System.out.println(1);
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
    
        session.setAttribute("brnCode", r.getAttribute("BRN_CODE"));
        branchDesc.setValue(r.getAttribute("BRN_NAME"));
        
      }
      return null;
    }
    
    public String SearchQuotation(){
        try{
            
            if(dateFrom.getValue()==null){
                session.setAttribute("quoteDateFrom", null); 
            }else{
                session.setAttribute("quoteDateFrom", GlobalCC.parseDate(dateFrom.getValue().toString()));
            }
            
            if(dateTo.getValue()==null){
                session.setAttribute("quoteDateTo", null);  
            }else{
                session.setAttribute("quoteDateTo", GlobalCC.parseDate(dateTo.getValue().toString()));
            }

            ADFUtils.findIterator("findQuotationsEnquiryIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(quoteResultsLOV);
            ADFUtils.findIterator("findTicketDetailsByUserIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(resultsLOV);
            resultsTab.setRendered(true);
            ticketsTab.setRendered(true);
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        
        return null;
    }
    
    public String ClearSearches(){
        try{
        
            session.setAttribute("brnCode", null);
            branchDesc.setValue(null);
            session.setAttribute("agnCode", null);
            agentDesc.setValue(null);
            session.setAttribute("prpCode", null);
            clientsDesc.setValue(null);
            session.setAttribute("ProductCode", null);
            productDesc.setValue(null);
            dateFrom.setValue(null);
            dateTo.setValue(null);
            status.setValue(null);
            
            resultsTab.setRendered(false);
            ticketsTab.setRendered(false);
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }
    
    public String findTicket2Selected(){
        try{
            
            DCIteratorBinding dciter = ADFUtils.findIterator("findTicketDetailsByUserIterator");
            RowKeySet set =resultsLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
                   
                   while (rowKeySetIter.hasNext()) {
                   List l = (List) rowKeySetIter.next();
                   Key key = (Key)l.get(0);
                   dciter.setCurrentRowWithKey(key.toStringFormat(true));
                     
                       
                   Row r = dciter.getCurrentRow();
                       
                          //LOVCC.TaskID = (String)r.getAttribute("TCKT_CDE");  
                session.setAttribute("TaskID", r.getAttribute("TCKT_CDE"));
                          //taskselName= (String)r.getAttribute("TCKT_NAME");   
                          //taskselAssignee= (String)r.getAttribute("TCKT_TO");   
                          //taskselDueDate=(Date)r.getAttribute("TCKT_DUE_DATE");
                          //taskselID=(String)r.getAttribute("TCKT_CDE");
                          //taskselCreateDate=(Date)r.getAttribute("TCKT_DATE");
                session.setAttribute("taskselName", r.getAttribute("TCKT_NAME"));
                session.setAttribute("taskselAssignee", r.getAttribute("TCKT_TO"));
                session.setAttribute("taskselDueDate", r.getAttribute("TCKT_DUE_DATE"));
                session.setAttribute("taskselID", r.getAttribute("TCKT_CDE"));
                session.setAttribute("taskselCreateDate", r.getAttribute("TCKT_DATE"));
                       
                GlobalCC.RedirectPage("/wfProcessing.jspx");
            
            }
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
       return null;
    }

    public void setProductDesc(RichInputText productDesc) {
        this.productDesc = productDesc;
    }

    public RichInputText getProductDesc() {
        return productDesc;
    }

    public void setProductsLOV(RichTable productsLOV) {
        this.productsLOV = productsLOV;
    }

    public RichTable getProductsLOV() {
        return productsLOV;
    }

    public void setStatus(RichSelectOneChoice status) {
        this.status = status;
    }

    public RichSelectOneChoice getStatus() {
        return status;
    }

    public void statusListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if(status.getValue()==null){
            session.setAttribute("quoteState", null);
        }else{
            session.setAttribute("quoteState", status.getValue().toString());
        }
    }

    public void setDateFrom(RichInputDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public RichInputDate getDateFrom() {
        return dateFrom;
    }

    public void setDateTo(RichInputDate dateTo) {
        this.dateTo = dateTo;
    }

    public RichInputDate getDateTo() {
        return dateTo;
    }

    public void setClientsDesc(RichInputText clientsDesc) {
        this.clientsDesc = clientsDesc;
    }

    public RichInputText getClientsDesc() {
        return clientsDesc;
    }

    public void setClientsLOV(RichTable clientsLOV) {
        this.clientsLOV = clientsLOV;
    }

    public RichTable getClientsLOV() {
        return clientsLOV;
    }

    public void setAgentDesc(RichInputText agentDesc) {
        this.agentDesc = agentDesc;
    }

    public RichInputText getAgentDesc() {
        return agentDesc;
    }

    public void setAgentsLOV(RichTable agentsLOV) {
        this.agentsLOV = agentsLOV;
    }

    public RichTable getAgentsLOV() {
        return agentsLOV;
    }

    public void setBranchDesc(RichInputText branchDesc) {
        this.branchDesc = branchDesc;
    }

    public RichInputText getBranchDesc() {
        return branchDesc;
    }

    public void setBranchesLOV(RichTable branchesLOV) {
        this.branchesLOV = branchesLOV;
    }

    public RichTable getBranchesLOV() {
        return branchesLOV;
    }

    public void setQuoteResultsLOV(RichTable quoteResultsLOV) {
        this.quoteResultsLOV = quoteResultsLOV;
    }

    public RichTable getQuoteResultsLOV() {
        return quoteResultsLOV;
    }

    public void setResultsTab(RichPanelBox resultsTab) {
        this.resultsTab = resultsTab;
    }

    public RichPanelBox getResultsTab() {
        return resultsTab;
    }

    public void setResultsLOV(RichTable resultsLOV) {
        this.resultsLOV = resultsLOV;
    }

    public RichTable getResultsLOV() {
        return resultsLOV;
    }

    public void setTicketsTab(RichPanelBox ticketsTab) {
        this.ticketsTab = ticketsTab;
    }

    public RichPanelBox getTicketsTab() {
        return ticketsTab;
    }

    public void quoteSelListener(SelectionEvent selectionEvent) {
        // Add event code here...
        DCIteratorBinding dciter = ADFUtils.findIterator("findQuotationsEnquiryIterator");
        RowKeySet set = selectionEvent.getAddedSet();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
            
            //LOVCC.TaxesCode=(BigDecimal)r.getAttribute("TT_CODE");
            session.setAttribute("QuoteCode", r.getAttribute("ENQ_quo_code"));
            ADFUtils.findIterator("findTicketDetailsByUserIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(resultsLOV);
            ticketsTab.setRendered(true);

          
        }
    }
    
    public String ViewQuotation(){
        try{
         
            DCIteratorBinding dciter = ADFUtils.findIterator("findQuotationsEnquiryIterator");
            RowKeySet set =quoteResultsLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            
            //System.out.println(1);
            while (rowKeySetIter.hasNext()) 
            {
                List l = (List) rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
                
                
                session.setAttribute("QuoteCode", r.getAttribute("ENQ_quo_code"));

              
            }   
        session.setAttribute("transType", "VQ");   
        GlobalCC.RedirectPage("/gquoedt.jspx");  
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }
  public String SearchQuotationStatuses()
    {
      try {
        if (this.dateFrom.getValue() == null)
          this.session.setAttribute("quoteDateFrom", null);
        else {
          this.session.setAttribute("quoteDateFrom", LMSG.view.Base.GlobalCC.parseDate(this.dateFrom.getValue().toString()));
        }

        if (this.dateTo.getValue() == null)
          this.session.setAttribute("quoteDateTo", null);
        else {
          this.session.setAttribute("quoteDateTo", LMSG.view.Base.GlobalCC.parseDate(this.dateTo.getValue().toString()));
        }

        LMSG.view.Base.ADFUtils.findIterator("findQuotationsEnquiryIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.quoteResultsLOV);
      } catch (Exception e) {
        LMSG.view.Base.GlobalCC.EXCEPTIONREPORTING(null, e);
      }

      return null;
    }

    public String ClearStatusSearches() {
      try {
        this.session.setAttribute("ProductCode", null);
        this.session.setAttribute("quoteDateFrom", null);
        this.session.setAttribute("quoteDateTo", null);
        this.productDesc.setValue(null);
        this.dateFrom.setValue(null);
        this.dateTo.setValue(null);

        LMSG.view.Base.ADFUtils.findIterator("findQuotationsEnquiryIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.quoteResultsLOV);
      }
      catch (Exception e) {
        LMSG.view.Base.GlobalCC.EXCEPTIONREPORTING(null, e);
      }
      return null;
    }
    
  public String ProcessQuotationStatuses()
    {
      Connection conn = null;
      try
      {
        boolean MakeCall = false;
        DBConnector db = new DBConnector();
        conn = db.getDatabaseConn();

        CallableStatement cst = null;

        cst = conn.prepareCall("begin LMS_WEB_PKG_GRP.update_quotation_status(?,?);end;");

        if (this.status.getValue() == null) {
          LMSG.view.Base.GlobalCC.INFORMATIONREPORTING("Select A Status");
          return null;
        }

        int rowCount = 0;
        boolean Value = false;
        rowCount = this.quoteResultsLOV.getRowCount();
        if (rowCount == 0) {
          return null;
        }

        for (int i = 0; i < rowCount; i++) {
          this.quoteResultsLOV.setRowIndex(i);
          JUCtrlValueBinding nodeBinding = (JUCtrlValueBinding)this.quoteResultsLOV.getRowData();

          if (nodeBinding == null) {
            continue;
          }
          Value = ((Boolean)nodeBinding.getAttribute("selected")).booleanValue();
          if (Value == true) {
            MakeCall = true;
            cst.setBigDecimal(1, (BigDecimal)nodeBinding.getAttribute("ENQ_quo_code"));
            cst.setString(2, this.status.getValue().toString());
            cst.execute();
          }
        }

        cst.close();
        conn.close();

        LMSG.view.Base.GlobalCC.INFORMATIONREPORTING("Quotation Statuses Updated");

        LMSG.view.Base.ADFUtils.findIterator("findQuotationsEnquiryIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.quoteResultsLOV);
      }
      catch (Exception e)
      {
        LMSG.view.Base.GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
      return null;
    }
  
  public void QuotationListener(ValueChangeEvent valueChangeEvent)
    {
      if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue()) {
        RowKeySet rowKeySet = this.quoteResultsLOV.getSelectedRowKeys();
        if (rowKeySet == null) {
          return;
        }
        if (!rowKeySet.iterator().hasNext())
        {
          LMSG.view.Base.GlobalCC.errorValueNotEntered("No Record Selected");
          return;
        }
        Object key2 = rowKeySet.iterator().next();
        this.quoteResultsLOV.setRowKey(key2);
        JUCtrlValueBinding nodeBinding = (JUCtrlValueBinding)this.quoteResultsLOV.getRowData();

        if (nodeBinding == null) {
          LMSG.view.Base.GlobalCC.errorValueNotEntered("No Record Selected");
          return;
        }

        if (this.quoteCBox.isSelected())
          nodeBinding.setAttribute("selected", Boolean.valueOf(true));
        else
          nodeBinding.setAttribute("selected", Boolean.valueOf(false));
      }
    }

    public void setQuoteCBox(RichSelectBooleanCheckbox quoteCBox) {
        this.quoteCBox = quoteCBox;
    }

    public RichSelectBooleanCheckbox getQuoteCBox() {
        return quoteCBox;
    }

   
}
