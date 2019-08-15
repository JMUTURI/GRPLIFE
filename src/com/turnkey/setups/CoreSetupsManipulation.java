package com.turnkey.setups;


import java.sql.CallableStatement;
import java.sql.Connection;

import javax.faces.context.FacesContext;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.data.RichTree;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.uicli.binding.JUCtrlValueBinding;

import oracle.jdbc.OracleTypes;

import org.apache.myfaces.trinidad.event.SelectionEvent;
import org.apache.myfaces.trinidad.model.RowKeySet;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

import LMSG.view.Base.ADFUtils;

import LMSG.view.Base.GlobalCC;

import LMSG.view.connect.DBConnector;

import java.math.BigDecimal;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import oracle.adf.model.binding.DCIteratorBinding;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.uicli.binding.JUCtrlHierNodeBinding;

public class CoreSetupsManipulation {
    private RichTable contraGlAccLovTab;
    private RichTable glAccLovTab;
    private RichInputText trntCode;
    private RichInputText trntGlCode;
    private RichInputText trntConGlCode;
    private RichInputText trntDesc;
    private RichSelectOneChoice trntProdApplicable;
    private RichSelectOneChoice trntAppLevel;
    private RichSelectOneChoice trntType;
    private RichTable transTypesTab;
    private RichTree accessGroupsTree;
    private RichInputText shortDesc;
    private RichInputText description;
    private RichSelectOneChoice type;
    private RichTable groupUsersTable;
    private RichTable groupPoliciesTable;
    private RichTable usersTable;
    private RichTable productsTable;
    private RichInputText prodDesc;
    private RichInputText policyDesc;
    private RichTable policiesTable;
    private RichInputText prodDesc1;
    private RichTable productsTable1;
    private RichInputText policyDesc1;
    private RichTable policiesTable1;
    private RichTable searchPoliciesTable;
    private RichTree subdivisionsTree;

    public CoreSetupsManipulation() {
        super();
    }
    
  HttpSession session =
      (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    
  public String selectGLCode() 
  {  
      RowKeySet rowKeySet = glAccLovTab.getSelectedRowKeys();
      
      if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.INFORMATIONREPORTING("Error: No Record Selected");
          return null;
      }

      Object key2 = rowKeySet.iterator().next();
      glAccLovTab.setRowKey(key2);

      JUCtrlValueBinding r = (JUCtrlValueBinding)glAccLovTab.getRowData();

      if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
          return null;
      }
      
          ExtendedRenderKitService erkService =
              Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                 ExtendedRenderKitService.class);
          erkService.addScript(FacesContext.getCurrentInstance(),
                               "var hints = {autodismissNever:false}; " +
                               "AdfPage.PAGE.findComponent('" + "demoTemplate:glAccLovPopUp" +
                               "').hide(hints);");
          
          trntGlCode.setValue(r.getAttribute("accNumber"));
          AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
          adfFacesContext.addPartialTarget(trntGlCode);
  
      
      
      return null;
  }
  
  public String selectContraGLCode() 
  {      
      RowKeySet rowKeySet = contraGlAccLovTab.getSelectedRowKeys();
      
      if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
          return null;
      }

      Object key2 = rowKeySet.iterator().next();
      contraGlAccLovTab.setRowKey(key2);

      JUCtrlValueBinding r = (JUCtrlValueBinding)contraGlAccLovTab.getRowData();

      if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
          return null;
      }
  
          ExtendedRenderKitService erkService =
              Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                 ExtendedRenderKitService.class);
          erkService.addScript(FacesContext.getCurrentInstance(),
                               "var hints = {autodismissNever:false}; " +
                               "AdfPage.PAGE.findComponent('" + "demoTemplate:contraGlAccLovPopUp" +
                               "').hide(hints);");
          
          trntConGlCode.setValue(r.getAttribute("accNumber"));
      
          AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
          adfFacesContext.addPartialTarget(trntConGlCode);
  
      
      
      return null;
  }
  
  public String saveTransType() {

      String trntCodeVal;
      String trntGlCodeVal;
      String trntConGlCodeVal;
      String trntDescVal;
      String trntTypeVal;
      String trntProdApplicableVal;
     String  trntAppLevelVal;


      DBConnector DBConnector = new DBConnector();
      Connection conn = null;

      try {
          trntCodeVal = GlobalCC.checkNullValues(trntCode.getValue());
          trntGlCodeVal = GlobalCC.checkNullValues(trntGlCode.getValue());
          trntConGlCodeVal = GlobalCC.checkNullValues(trntConGlCode.getValue());
          trntDescVal = GlobalCC.checkNullValues(trntDesc.getValue());
          trntTypeVal = GlobalCC.checkNullValues(trntType.getValue());
          trntProdApplicableVal = GlobalCC.checkNullValues(trntProdApplicable.getValue());
          trntAppLevelVal = GlobalCC.checkNullValues(trntAppLevel.getValue());


          if (trntGlCodeVal == null) {
                GlobalCC.errorValueNotEntered("Error Value Missing: Gl Account Code");
              return null;
          }

          if (trntDescVal == null) {
                GlobalCC.errorValueNotEntered("Error Value Missing: Description");
              return null;
          }

          if (trntTypeVal == null) {
                GlobalCC.errorValueNotEntered("Error Value Missing: Transaction Type");
              return null;
          }
          

          conn = DBConnector.getDatabaseConn();
          String query = null;
          query = "begin LMS_SETUPS_PKG.update_transaction_types(?,?,?,?,?,?,?,?); end;";

          CallableStatement callStmt = null;
          callStmt = conn.prepareCall(query);
          //bind the variables

          callStmt.setString(1, trntCodeVal);
          callStmt.setString(2, trntDescVal);
          callStmt.setString(3, trntGlCodeVal);
          callStmt.setString(4, trntTypeVal);
          callStmt.setString(5, trntProdApplicableVal);
          callStmt.setString(6, trntConGlCodeVal);
          callStmt.setString(7, trntAppLevelVal);
          callStmt.registerOutParameter(8, OracleTypes.VARCHAR);

          callStmt.execute();
          String errMessage = null;
          errMessage = callStmt.getString(8);

          callStmt.close();
          conn.commit();
          conn.close();

          if (errMessage != null) {
              GlobalCC.errorValueNotEntered(errMessage);
              return null;
          }

          trntCode.setValue(null);
          trntGlCode.setValue(null);
          trntConGlCode.setValue(null);
          trntDesc.setValue(null);
          trntType.setValue(null);
          trntProdApplicable.setValue(null);
          trntAppLevel.setValue(null);
          
          GlobalCC.hidePopup("demoTemplate:transTypePopUp");
          
          GlobalCC.sysInformation("Transaction Type Successfully Saved.");

          ADFUtils.findIterator("findTransTypesIterator1").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(transTypesTab);
      } catch (Exception e) {

            GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
      return null;
  }
  
  public String AddTransType(){
    
      try{
        trntCode.setValue(null);
        trntCode.setDisabled(false);
        trntGlCode.setValue(null);
        trntConGlCode.setValue(null);
        trntDesc.setValue(null);
        trntType.setValue(null);
        trntProdApplicable.setValue(null);
        trntAppLevel.setValue(null);
          
        GlobalCC.showPopup("demoTemplate:transTypePopUp");
          
      }catch(Exception e){
        GlobalCC.EXCEPTIONREPORTING(null, e);
      }
    return null;
  }
  
  public String viewTransType() {
      try{  
    DCIteratorBinding dciter = ADFUtils.findIterator("findTransTypesIterator1");
    RowKeySet set =transTypesTab.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    
    //System.out.println(1);
    while (rowKeySetIter.hasNext()) 
    {
        List l = (List) rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
        
      trntCode.setValue(r.getAttribute("trntCode"));
      trntCode.setDisabled(true);
      trntGlCode.setValue(r.getAttribute("trntGlCode"));
      trntConGlCode.setValue(r.getAttribute("trntConGlCode"));
      trntDesc.setValue(r.getAttribute("trntDesc"));
      trntType.setValue(r.getAttribute("trntType"));
      trntProdApplicable.setValue(r.getAttribute("trntProdApplcb"));
      trntAppLevel.setValue(r.getAttribute("trntLevel"));
    }

    GlobalCC.showPopup("demoTemplate:transTypePopUp");
          
    }catch(Exception e){
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }
  
  public String deleteTransType()  {
   
    Connection conn = null;
    try{  
    DBConnector DBConnector = new DBConnector();
        
    DCIteratorBinding dciter = ADFUtils.findIterator("findTransTypesIterator1");
    RowKeySet set =transTypesTab.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    
    //System.out.println(1);
    while (rowKeySetIter.hasNext())
    {
      List l = (List) rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      
      
      conn = DBConnector.getDatabaseConn();
      String query = "begin LMS_WEB_PKG_SETUP.delete_transaction_types(?,?); end;";
      CallableStatement callStmt = null;
      callStmt = conn.prepareCall(query);
      //bind the variables
      callStmt.setString(1, (String)r.getAttribute("trntCode"));
      callStmt.registerOutParameter(2, OracleTypes.VARCHAR);
      callStmt.execute();
      
      String errMessage = null;
      errMessage = callStmt.getString(2);
      callStmt.close();
     
        
      if(errMessage!=null){
        GlobalCC.errorValueNotEntered(errMessage);
          return null;
      }
    }
      conn.commit();
      conn.close();
        
      ADFUtils.findIterator("findTransTypesIterator1").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(transTypesTab);
        
    }catch (Exception e) {
       GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
      return null;
  }

    public void setContraGlAccLovTab(RichTable contraGlAccLovTab) {
        this.contraGlAccLovTab = contraGlAccLovTab;
    }

    public RichTable getContraGlAccLovTab() {
        return contraGlAccLovTab;
    }

    public void setGlAccLovTab(RichTable glAccLovTab) {
        this.glAccLovTab = glAccLovTab;
    }

    public RichTable getGlAccLovTab() {
        return glAccLovTab;
    }

    public void setTrntCode(RichInputText trntCode) {
        this.trntCode = trntCode;
    }

    public RichInputText getTrntCode() {
        return trntCode;
    }

    public void setTrntGlCode(RichInputText trntGlCode) {
        this.trntGlCode = trntGlCode;
    }

    public RichInputText getTrntGlCode() {
        return trntGlCode;
    }

    public void setTrntConGlCode(RichInputText trntConGlCode) {
        this.trntConGlCode = trntConGlCode;
    }

    public RichInputText getTrntConGlCode() {
        return trntConGlCode;
    }

    public void setTrntDesc(RichInputText trntDesc) {
        this.trntDesc = trntDesc;
    }

    public RichInputText getTrntDesc() {
        return trntDesc;
    }

    public void setTrntProdApplicable(RichSelectOneChoice trntProdApplicable) {
        this.trntProdApplicable = trntProdApplicable;
    }

    public RichSelectOneChoice getTrntProdApplicable() {
        return trntProdApplicable;
    }

    public void setTrntAppLevel(RichSelectOneChoice trntAppLevel) {
        this.trntAppLevel = trntAppLevel;
    }

    public RichSelectOneChoice getTrntAppLevel() {
        return trntAppLevel;
    }

    public void setTrntType(RichSelectOneChoice trntType) {
        this.trntType = trntType;
    }

    public RichSelectOneChoice getTrntType() {
        return trntType;
    }

    public void setTransTypesTab(RichTable transTypesTab) {
        this.transTypesTab = transTypesTab;
    }

    public RichTable getTransTypesTab() {
        return transTypesTab;
    }

    public void setAccessGroupsTree(RichTree accessGroupsTree) {
        this.accessGroupsTree = accessGroupsTree;
    }

    public RichTree getAccessGroupsTree() {
        return accessGroupsTree;
    }

    public void AccessGroupsListener(SelectionEvent selectionEvent) {
        // Add event code here...
        if (selectionEvent.getAddedSet() != selectionEvent.getRemovedSet()) {
            RowKeySet keys = selectionEvent.getAddedSet(); 
            if (keys != null && keys.getSize() > 0) {
                for (Object treeRowKey : keys) {
                    accessGroupsTree.setRowKey(treeRowKey);
                    JUCtrlHierNodeBinding nd =
                        (JUCtrlHierNodeBinding)accessGroupsTree.getRowData();
                    
                session.setAttribute("lpagCode", nd.getRow().getAttribute("LPAG_CODE"));
                shortDesc.setValue(nd.getRow().getAttribute("LPAG_SHT_DESC"));
                description.setValue(nd.getRow().getAttribute("LPAG_DESC"));
                type.setValue(nd.getRow().getAttribute("LPAG_TYPE"));
                session.setAttribute("action", "E");  
                    
                ADFUtils.findIterator("findUserAccessGroupsIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(groupUsersTable);
                    
                ADFUtils.findIterator("findPolicyAccessGroupsIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(groupPoliciesTable);

              }
            }
        }
    }
    
    public String AddAccessGroup(){
      
      session.setAttribute("action", "A");  
      session.setAttribute("lpagCode", null);
      shortDesc.setValue(null);
      description.setValue(null);
      type.setValue(null);
          
      ADFUtils.findIterator("findUserAccessGroupsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(groupUsersTable);
          
      ADFUtils.findIterator("findPolicyAccessGroupsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(groupPoliciesTable);
      
      return null;
      
    }
    
    public String DeleteAccessGroup(){    
    try{
        session.setAttribute("action", "D");  
        SaveAccessGroup();
        
        session.setAttribute("lpagCode", null);
        shortDesc.setValue(null);
        description.setValue(null);
        type.setValue(null);
            
        ADFUtils.findIterator("findUserAccessGroupsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(groupUsersTable);
            
        ADFUtils.findIterator("findPolicyAccessGroupsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(groupPoliciesTable);
    }catch(Exception e){
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
    }
    
    public String SaveAccessGroup(){
        Connection conn = null;
        try{
          if(shortDesc.getValue()==null){
            GlobalCC.INFORMATIONREPORTING("Enter A Short Description");
            return null;
          }
          if(shortDesc.getValue()==null){
            GlobalCC.INFORMATIONREPORTING("Enter A Short Description");
            return null;
          }
          String Query = "begin LMS_SETUPS_PKG.save_access_group(?,?,?,?,?); end;";
          DBConnector MyConn = new DBConnector();
          conn = MyConn.getDatabaseConn();
          CallableStatement cst = conn.prepareCall(Query);
          cst.setString(1, (String)session.getAttribute("action"));
          cst.setBigDecimal(2, (BigDecimal)session.getAttribute("lpagCode"));
          if(shortDesc.getValue()==null){
            cst.setString(3, null);
          }else{
            cst.setString(3, shortDesc.getValue().toString());
          }
          if(description.getValue()==null){
            cst.setString(4, null);
          }else{
            cst.setString(4, description.getValue().toString());
          }
          if(type.getValue()==null){
            cst.setString(5, "R");
          }else{
            cst.setString(5, type.getValue().toString());
          }
          cst.execute();
          cst.close();
          conn.close();
            
          GlobalCC.INFORMATIONREPORTING("Transaction Successfully Completed.");
            
          ADFUtils.findIterator("findAccessGroupsIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(accessGroupsTree);
            
          ADFUtils.findIterator("findUserAccessGroupsIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(groupUsersTable);
              
          ADFUtils.findIterator("findPolicyAccessGroupsIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(groupPoliciesTable);
            
        }catch(Exception e){
          GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public void setShortDesc(RichInputText shortDesc) {
        this.shortDesc = shortDesc;
    }

    public RichInputText getShortDesc() {
        return shortDesc;
    }

    public void setDescription(RichInputText description) {
        this.description = description;
    }

    public RichInputText getDescription() {
        return description;
    }

    public void setType(RichSelectOneChoice type) {
        this.type = type;
    }

    public RichSelectOneChoice getType() {
        return type;
    }

    public void setGroupUsersTable(RichTable groupUsersTable) {
        this.groupUsersTable = groupUsersTable;
    }

    public RichTable getGroupUsersTable() {
        return groupUsersTable;
    }

    public void setGroupPoliciesTable(RichTable groupPoliciesTable) {
        this.groupPoliciesTable = groupPoliciesTable;
    }

    public RichTable getGroupPoliciesTable() {
        return groupPoliciesTable;
    }
    
  public String AttachUsersToGroup() {
      Connection conn = null;
    try{
      String Query = "begin LMS_SETUPS_PKG.attach_usr_to_accessgrp(?,?,?,?); end;";
      DBConnector MyConn = new DBConnector();
      conn = MyConn.getDatabaseConn();
      CallableStatement cst = conn.prepareCall(Query);
        
      DCIteratorBinding dciter = ADFUtils.findIterator("FindSystemUsersIterator");
      RowKeySet set =usersTable.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
          
          cst.setString(1, "A");
          cst.setString(2, null);
          cst.setBigDecimal(3, (BigDecimal)session.getAttribute("lpagCode"));
          cst.setBigDecimal(4, (BigDecimal)r.getAttribute("USR_CODE"));
          cst.execute();
      }
      ADFUtils.findIterator("findUserAccessGroupsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(groupUsersTable);
      
      GlobalCC.INFORMATIONREPORTING("Transaction Successfully Completed");
      cst.close();
      conn.close();
    }catch(Exception e){
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
  
  public String DeleteUsersToGroup() {
      Connection conn = null;
    try{
      String Query = "begin LMS_SETUPS_PKG.attach_usr_to_accessgrp(?,?,?,?); end;";
      DBConnector MyConn = new DBConnector();
      conn = MyConn.getDatabaseConn();
      CallableStatement cst = conn.prepareCall(Query);
        
      DCIteratorBinding dciter = ADFUtils.findIterator("findUserAccessGroupsIterator");
      RowKeySet set =groupUsersTable.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
          
          cst.setString(1, "D");
          cst.setBigDecimal(2, (BigDecimal)r.getAttribute("AGU_CODE"));
          cst.setBigDecimal(3, (BigDecimal)session.getAttribute("lpagCode"));
          cst.setBigDecimal(4, (BigDecimal)r.getAttribute("AGU_USR_CODE"));
          cst.execute();
      }
      ADFUtils.findIterator("findUserAccessGroupsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(groupUsersTable);
      
      GlobalCC.INFORMATIONREPORTING("Transaction Successfully Completed");
      cst.close();
      conn.close();
    }catch(Exception e){
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }

    public void setUsersTable(RichTable usersTable) {
        this.usersTable = usersTable;
    }

    public RichTable getUsersTable() {
        return usersTable;
    }

    public void setProductsTable(RichTable productsTable) {
        this.productsTable = productsTable;
    }

    public RichTable getProductsTable() {
        return productsTable;
    }

    public void setProdDesc(RichInputText prodDesc) {
        this.prodDesc = prodDesc;
    }

    public RichInputText getProdDesc() {
        return prodDesc;
    }

    public void setPolicyDesc(RichInputText policyDesc) {
        this.policyDesc = policyDesc;
    }

    public RichInputText getPolicyDesc() {
        return policyDesc;
    }

    public void setPoliciesTable(RichTable policiesTable) {
        this.policiesTable = policiesTable;
    }

    public RichTable getPoliciesTable() {
        return policiesTable;
    }
    
  public String findProductSelected() {
    try{
 
      DCIteratorBinding dciter = ADFUtils.findIterator("findProductsIterator");
      RowKeySet set =productsTable.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
          
         session.setAttribute("ProductCode", r.getAttribute("prodCode"));
         prodDesc.setValue(r.getAttribute("prodDesc"));
          
         session.setAttribute("policyCode", null);
         policyDesc.setValue(null);
          
        AdfFacesContext.getCurrentInstance().addPartialTarget(prodDesc);
        AdfFacesContext.getCurrentInstance().addPartialTarget(policyDesc);
          
        ADFUtils.findIterator("FindPoliciesIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(policiesTable);
        
        GlobalCC.hidePopup("lmsgroup:p3");
      }
      
    }catch(Exception e){
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }
  
  public String findPoliciesSelected() {
    try{
  
      DCIteratorBinding dciter = ADFUtils.findIterator("FindPoliciesIterator");
      RowKeySet set =policiesTable.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
          
         session.setAttribute("policyCode", r.getAttribute("POL_CODE"));
         policyDesc.setValue(r.getAttribute("POL_POLICY_NO"));
            
        AdfFacesContext.getCurrentInstance().addPartialTarget(policyDesc);
        GlobalCC.hidePopup("lmsgroup:popup1");
       
      }
      
    }catch(Exception e){
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }
  
  public String AttachPolicyToGroup(){
    Connection conn = null;
    try{
      if(session.getAttribute("policyCode")==null){
        GlobalCC.INFORMATIONREPORTING("Select A Policy");
        return null;
      }
      if(session.getAttribute("lpagCode")==null){
        GlobalCC.INFORMATIONREPORTING("Select An Access Group");
        return null;
      }
        
      String Query = "begin LMS_SETUPS_PKG.attach_policy_to_accessgrp(?,?); end;";
      DBConnector MyConn = new DBConnector();
      conn = MyConn.getDatabaseConn();
      CallableStatement cst = conn.prepareCall(Query);
      cst.setBigDecimal(1, (BigDecimal)session.getAttribute("policyCode"));
      cst.setBigDecimal(2, (BigDecimal)session.getAttribute("lpagCode"));
      cst.execute();
      cst.close();
      conn.close();
        
      GlobalCC.INFORMATIONREPORTING("Transaction Successfully Completed");
      GlobalCC.hidePopup("lmsgroup:p2");
        
      ADFUtils.findIterator("findPolicyAccessGroupsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(groupPoliciesTable);
        
    }catch(Exception e){
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }
  
  public String AddPolicyToGroup(){
      try{
        session.setAttribute("ProductCode", null);
        prodDesc.setValue(null);
          
        session.setAttribute("policyCode", null);
        policyDesc.setValue(null);  
          
        GlobalCC.showPopup("lmsgroup:p2");
          
      }catch(Exception e){
        GlobalCC.EXCEPTIONREPORTING(null, e);
      }
    return null;
  }
  
  public String DeletePolicyToGroup() {
      Connection conn = null;
    try{
      String Query = "begin LMS_SETUPS_PKG.attach_policy_to_accessgrp(?,?); end;";
      DBConnector MyConn = new DBConnector();
      conn = MyConn.getDatabaseConn();
      CallableStatement cst = conn.prepareCall(Query);
        
      DCIteratorBinding dciter = ADFUtils.findIterator("findPolicyAccessGroupsIterator");
      RowKeySet set =groupPoliciesTable.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
          
          cst.setBigDecimal(1, (BigDecimal)r.getAttribute("POL_CODE"));
          cst.setBigDecimal(2, new BigDecimal("1000"));
          cst.execute();
      }
      ADFUtils.findIterator("findPolicyAccessGroupsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(groupPoliciesTable);
      
      GlobalCC.INFORMATIONREPORTING("Transaction Successfully Completed");
      cst.close();
      conn.close();
    }catch(Exception e){
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }

    public void setProdDesc1(RichInputText prodDesc1) {
        this.prodDesc1 = prodDesc1;
    }

    public RichInputText getProdDesc1() {
        return prodDesc1;
    }

    public void setProductsTable1(RichTable productsTable1) {
        this.productsTable1 = productsTable1;
    }

    public RichTable getProductsTable1() {
        return productsTable1;
    }

    public void setPolicyDesc1(RichInputText policyDesc1) {
        this.policyDesc1 = policyDesc1;
    }

    public RichInputText getPolicyDesc1() {
        return policyDesc1;
    }

    public void setPoliciesTable1(RichTable policiesTable1) {
        this.policiesTable1 = policiesTable1;
    }

    public RichTable getPoliciesTable1() {
        return policiesTable1;
    }
    
  public String findProductSelected2() {
    try{
  
      DCIteratorBinding dciter = ADFUtils.findIterator("findProductsIterator");
      RowKeySet set =productsTable1.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
          
         session.setAttribute("ProductCode", r.getAttribute("prodCode"));
         prodDesc1.setValue(r.getAttribute("prodDesc"));
          
         session.setAttribute("lpagPolicyCode", null);
         policyDesc1.setValue(null);
          
        AdfFacesContext.getCurrentInstance().addPartialTarget(prodDesc1);
        AdfFacesContext.getCurrentInstance().addPartialTarget(policyDesc1);
          
        ADFUtils.findIterator("FindPoliciesIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(policiesTable);
        
        GlobalCC.hidePopup("lmsgroup:popup3");
      }
      
    }catch(Exception e){
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }
  
  public String findPoliciesSelected2() {
    try{
  
      DCIteratorBinding dciter = ADFUtils.findIterator("FindPoliciesIterator");
      RowKeySet set =policiesTable1.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
          
         session.setAttribute("lpagPolicyCode", r.getAttribute("POL_CODE"));
         policyDesc1.setValue(r.getAttribute("POL_POLICY_NO"));
            
        AdfFacesContext.getCurrentInstance().addPartialTarget(policyDesc1);
        GlobalCC.hidePopup("lmsgroup:popup4");
       
      }
      
    }catch(Exception e){
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }
  
  public String InitiateSearchPolicy(){
      try{
        session.setAttribute("ProductCode", null);
        prodDesc1.setValue(null);
          
        session.setAttribute("lpagPolicyCode", null);
        policyDesc1.setValue(null);  
          
        GlobalCC.showPopup("lmsgroup:popup2");
          
      }catch(Exception e){
        GlobalCC.EXCEPTIONREPORTING(null, e);
      }
    return null;
  }
  
  public String SearchPolicy(){
    
      try{
        if(session.getAttribute("lpagPolicyCode")==null){
          GlobalCC.INFORMATIONREPORTING("Select A Policy");
          return null;
        }
          
        ADFUtils.findIterator("findAccessGroupsForPolicyIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(searchPoliciesTable);
          
      }catch(Exception e){
        GlobalCC.EXCEPTIONREPORTING(null, e);
      }
      return null;
  }

    public void setSearchPoliciesTable(RichTable searchPoliciesTable) {
        this.searchPoliciesTable = searchPoliciesTable;
    }

    public RichTable getSearchPoliciesTable() {
        return searchPoliciesTable;
    }

    public void setSubdivisionsTree(RichTree subdivisionsTree) {
        this.subdivisionsTree = subdivisionsTree;
    }

    public RichTree getSubdivisionsTree() {
        return subdivisionsTree;
    }

    public void subdivisionsListener(SelectionEvent selectionEvent) {
        // Add event code here...
        if (selectionEvent.getAddedSet() != selectionEvent.getRemovedSet()) {
            RowKeySet keys = selectionEvent.getAddedSet(); 
            if (keys != null && keys.getSize() > 0) {
                for (Object treeRowKey : keys) {
                    subdivisionsTree.setRowKey(treeRowKey);
                    JUCtrlHierNodeBinding nd =
                        (JUCtrlHierNodeBinding)subdivisionsTree.getRowData();
                    
                session.setAttribute("subdivisionCode", nd.getRow().getAttribute("GSUB_CODE"));
                shortDesc.setValue(nd.getRow().getAttribute("GSUB_SHT_DESC"));
                description.setValue(nd.getRow().getAttribute("GSUB_DESC"));
                session.setAttribute("action", "E");  
               
              }
            }
        }
    }
    
  public String AddSubdivision(){
    
    session.setAttribute("action", "A");  
    session.setAttribute("subdivisionCode", null);
    shortDesc.setValue(null);
    description.setValue(null);

    return null;
    
  }
  
  public String DeleteSubdivision(){    
  try{
      session.setAttribute("action", "D");  
      SaveSubdivision();
      
      session.setAttribute("action", "A");  
      session.setAttribute("subdivisionCode", null);
      shortDesc.setValue(null);
      description.setValue(null);
     
  }catch(Exception e){
    GlobalCC.EXCEPTIONREPORTING(null, e);
  }
  return null;
  }
  
  public String SaveSubdivision(){
      Connection conn = null;
      try{
        if(shortDesc.getValue()==null){
          GlobalCC.INFORMATIONREPORTING("Enter A Short Description");
          return null;
        }
        if(shortDesc.getValue()==null){
          GlobalCC.INFORMATIONREPORTING("Enter A Short Description");
          return null;
        }
        String Query = "begin LMS_SETUPS_PKG.save_grp_subdivisions(?,?,?,?); end;";
        DBConnector MyConn = new DBConnector();
        conn = MyConn.getDatabaseConn();
        CallableStatement cst = conn.prepareCall(Query);
        cst.setString(1, (String)session.getAttribute("action"));
        cst.setBigDecimal(2, (BigDecimal)session.getAttribute("subdivisionCode"));
        if(shortDesc.getValue()==null){
          cst.setString(3, null);
        }else{
          cst.setString(3, shortDesc.getValue().toString());
        }
        if(description.getValue()==null){
          cst.setString(4, null);
        }else{
          cst.setString(4, description.getValue().toString());
        }
        
        cst.execute();
        cst.close();
        conn.close();
          
        GlobalCC.INFORMATIONREPORTING("Transaction Successfully Completed.");
            
        ADFUtils.findIterator("FindGroupSubdivisionsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(subdivisionsTree);
          
      }catch(Exception e){
        GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
      return null;
  }
}
