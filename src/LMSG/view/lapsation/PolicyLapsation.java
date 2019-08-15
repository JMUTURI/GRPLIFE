package LMSG.view.Lapsation;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Key;
import oracle.jbo.Row;

import org.apache.myfaces.trinidad.model.RowKeySet;

import LMSG.view.Base.ADFUtils;

import java.util.ArrayList;


import javax.servlet.http.HttpSession;

import org.jbpm.api.task.Task;


import LMSG.view.connect.DBConnector;

import LMSG.view.BPM.wfEngine;
import LMSG.view.Base.GlobalCC;

import org.jbpm.pvm.internal.cfg.JbpmConfiguration;


public class PolicyLapsation {
    private RichTable productLOV;
    private RichSelectOneChoice lapseType;
    private RichInputText productDesc;
    private RichPanelBox searchResults;
    private RichSelectBooleanCheckbox lapseCbox;
    
    protected static BigDecimal [][]PolLapseCode = new BigDecimal[20][2];
    protected static String []PolLapseDesc = new String[20];
    protected static int t = 0;
    private RichTable lapsationsLOV;
    
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    
    public String Workflows(){
        String TaskID = null;
        
        JbpmConfiguration pid = null;
        wfEngine wf = new wfEngine();
        pid = wf.startWorkFlowInstance();

        //Get Task List
        List<Task> Tasks=new ArrayList<Task>();
        Tasks = wf.getTaskList("jimbo");
        int i = 0;
        for (Iterator iter = Tasks.iterator(); iter.hasNext();) {
            Task task = Tasks.get(i);
            TaskID = task.getId();
            System.out.println((iter.next()));
            i++;
        } 
        
        wf.endWorkFlowInstance(pid);
        return null;
    }

    public String findProductSelected() {
      DCIteratorBinding dciter = ADFUtils.findIterator("findLapsedProductsIterator");
      RowKeySet set =productLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
          
          productDesc.setValue(r.getAttribute("lp_prod_desc"));
          session.setAttribute("ProductCode", r.getAttribute("lp_prod_code"));
          session.setAttribute("ProductLapsationDays", r.getAttribute("lp_PROD_LAPSE_PRD_DAYS"));

            ADFUtils.findIterator("FindLapsedPoliciesIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(lapsationsLOV);
          
          searchResults.setRendered(false);
       
      }

      return null;
    }
    
    public String ShowResults(){
        
        if (productDesc.getValue()==null){
          GlobalCC.INFORMATIONREPORTING("Select a Product");
          return null;
          
        }
        t = 0;
        searchResults.setRendered(true); 
       
        
        return null;
    }


    public void setProductLOV(RichTable productLOV) {
        this.productLOV = productLOV;
    }

    public RichTable getProductLOV() {
        return productLOV;
    }

    public void lapselistener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if(lapseType.getValue()==null){
            //do nothing
        }else{
           //LOVCC.LapseType = lapseType.getValue().toString();
           session.setAttribute("LapseType", lapseType.getValue().toString());
            ADFUtils.findIterator("findLapsedProductsIterator").executeQuery();    
           AdfFacesContext.getCurrentInstance().addPartialTarget(productDesc);
           searchResults.setRendered(false);
        }
    }

    public void setLapseType(RichSelectOneChoice lapseType) {
        this.lapseType = lapseType;
    }

    public RichSelectOneChoice getLapseType() {
        return lapseType;
    }

    public void setProductDesc(RichInputText productDesc) {
        this.productDesc = productDesc;
    }

    public RichInputText getProductDesc() {
        return productDesc;
    }

    public void setSearchResults(RichPanelBox searchResults) {
        this.searchResults = searchResults;
    }

    public RichPanelBox getSearchResults() {
        return searchResults;
    }

    public void toLapseListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (lapseCbox.isSelected()){
            AddRow();
        }else{
            RemoveRow();
        }      
        
        }
    
    public String AddRow(){
        BigDecimal Code = null;
        BigDecimal Prem = null;
        
        DCIteratorBinding dciter = ADFUtils.findIterator("FindLapsedPoliciesIterator");
        RowKeySet set = lapsationsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        while (rowKeySetIter.hasNext()) {
        List l = (List) rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
           
        Row r = dciter.getCurrentRow();

            Code = (BigDecimal)r.getAttribute("PL_pol_code");
            Prem = (BigDecimal)r.getAttribute("PL_os_prem");
   
            PolLapseCode[t][0] = Code;
            System.out.println(PolLapseCode[t][0]);
            PolLapseCode[t][1] = Prem;
            PolLapseDesc[t] = "Y";

        
            t++;

        }
        
        
        return null;
    }
    
    public String RemoveRow(){
        BigDecimal Code = null;
        
        DCIteratorBinding dciter = ADFUtils.findIterator("FindLapsedPoliciesIterator");
        RowKeySet set = lapsationsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        while (rowKeySetIter.hasNext()) {
        List l = (List) rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
           
        Row r = dciter.getCurrentRow();

            Code = (BigDecimal)r.getAttribute("PL_pol_code");
            System.out.println(Code);

            int m = 0;
            while (m < t){
                System.out.println(PolLapseCode[m][0]);
                if (PolLapseCode[m][0].equals(Code)){
                    PolLapseDesc[m] = "N"; //Policy Not Selected
                }
                m++;
            }
        }
        return null;
    }
    
    public String LapsePolicies() 
    {
      String fclQuery="BEGIN LMS_WEB_PKG_GRP.lapse_policies(?,?,?);END;";
      Connection conn=new DBConnector().getDatabaseConn();
      CallableStatement cst=null;
      try 
      {
          int i = 0;
          cst=conn.prepareCall(fclQuery);
          
          while (i < t){
                   
              if (PolLapseDesc[i].equalsIgnoreCase("Y")){                          
                  cst.setBigDecimal(1,PolLapseCode[i][0]);
                  cst.setString(2, (String)session.getAttribute("LapseType"));
                  cst.setBigDecimal(3,PolLapseCode[i][1]);
                  cst.execute();
              }
               i++;
          
            }
          conn.close();
            ADFUtils.findIterator("FindLapsedPoliciesIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(lapsationsLOV);
        
        String Message = "Policies Successfully Lapsed.";
        FacesContext.getCurrentInstance().addMessage(null, 
                                                     new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                      Message, 
                                                                      Message));
        
      }
      catch(Exception e)
      {
        GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
      return null;
    }

    public void setLapseCbox(RichSelectBooleanCheckbox lapseCbox) {
        this.lapseCbox = lapseCbox;
    }

    public RichSelectBooleanCheckbox getLapseCbox() {
        return lapseCbox;
    }

    public void setLapsationsLOV(RichTable lapsationsLOV) {
        this.lapsationsLOV = lapsationsLOV;
    }

    public RichTable getLapsationsLOV() {
        return lapsationsLOV;
    }
}
