package com.turnkey.setups;

import LMSG.view.Base.ADFUtils;
import LMSG.view.Base.GlobalCC;
import LMSG.view.connect.DBConnector;

import java.math.BigDecimal;

import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.data.RichTree;
import oracle.adf.view.rich.component.rich.data.RichTreeTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputNumberSpinbox;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.output.RichOutputLabel;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Row;
import oracle.jbo.uicli.binding.JUCtrlValueBinding;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleTypes;

import org.apache.myfaces.trinidad.event.SelectionEvent;
import org.apache.myfaces.trinidad.model.RowKeySet;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

public class agentCompetitionsManip {
    private RichTreeTable productsDef;
    private RichInputNumberSpinbox numberOfPols;
    private RichInputNumberSpinbox premiumIncome;
    private RichInputNumberSpinbox rewardAmount;
    private RichInputDate wef;
    private RichInputDate wet;
    
  HttpSession session =
      (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    private RichTable agentCompetionsTab;
    private RichTree productsDefination;
    private RichSelectOneChoice branchesVal;
    private RichInputText competitionDesc;
    private RichPanelBox agentCompetionPanel;
    private RichPanelGroupLayout agentPerformancePanel;
    private RichPanelGroupLayout budgetPanel;
    private RichPanelGroupLayout competitionDashBoard;
    private RichSelectOneChoice competitionLevel;
    private RichInputNumberSpinbox persitency;
    private RichInputNumberSpinbox persitencyParam;

    public agentCompetitionsManip() {
        super();
    }

    public void setProductsDef(RichTreeTable productsDef) {
        this.productsDef = productsDef;
    }

    public RichTreeTable getProductsDef() {
        return productsDef;
    }

    public void setNumberOfPols(RichInputNumberSpinbox numberOfPols) {
        this.numberOfPols = numberOfPols;
    }

    public RichInputNumberSpinbox getNumberOfPols() {
        return numberOfPols;
    }

    public void setPremiumIncome(RichInputNumberSpinbox premiumIncome) {
        this.premiumIncome = premiumIncome;
    }

    public RichInputNumberSpinbox getPremiumIncome() {
        return premiumIncome;
    }

    public void setRewardAmount(RichInputNumberSpinbox rewardAmount) {
        this.rewardAmount = rewardAmount;
    }

    public RichInputNumberSpinbox getRewardAmount() {
        return rewardAmount;
    }

    public void setWef(RichInputDate wef) {
        this.wef = wef;
    }

    public RichInputDate getWef() {
        return wef;
    }
  public void setWet(RichInputDate wet) {
      this.wet = wet;
  }

  public RichInputDate getWet() {
      return wet;
  }

    public String newAgentCompetionDetails() {
     /* if (session.getAttribute("prodCode") == null ||
          session.getAttribute("productShtDesc") == null) {
          GlobalCC.errorValueNotEntered("Error: Select A Product");

          return null;
      }*/
        numberOfPols.setValue(null);
        premiumIncome.setValue(null);
        rewardAmount.setValue(null);
        wef.setValue(null);
        wet.setValue(null);
      ExtendedRenderKitService erkService =
          Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                             ExtendedRenderKitService.class);
      erkService.addScript(FacesContext.getCurrentInstance(),
                           "var hints = {autodismissNever:false}; " +
                           "AdfPage.PAGE.findComponent('" +
                           "demoTemplate:competitionDtlsPop" +
                           "').show(hints);");
        return null;
    }

    public void setAgentCompetionsTab(RichTable agentCompetionsTab) {
        this.agentCompetionsTab = agentCompetionsTab;
    }

    public RichTable getAgentCompetionsTab() {
        return agentCompetionsTab;
    }

    public void selectedProduct(SelectionEvent evt) {
        if (evt.getAddedSet() != evt.getRemovedSet()) {
            RowKeySet rowKeySet = productsDefination.getSelectedRowKeys();
            Object key2 = rowKeySet.iterator().next();
            productsDefination.setRowKey(key2);
            JUCtrlValueBinding nodeBinding =
                (JUCtrlValueBinding)productsDefination.getRowData();
            session.setAttribute("prodCode",
                                 nodeBinding.getAttribute("PROD_CODE"));
            session.setAttribute("productShtDesc",
                                 nodeBinding.getAttribute("PROD_DESC"));
            
          System.out.println("prodCode Selected=" +
                             session.getAttribute("prodCode"));
          System.out.println("productShtDesc Selected=" +
                           session.getAttribute("productShtDesc"));
            ADFUtils.findIterator("findAgentCompetionRatesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(agentCompetionsTab);
        }
    }

    public void selectedBranch(ValueChangeEvent evt) {
        if (evt.getNewValue() != evt.getOldValue()) {
            if (evt.getNewValue() != null) {
                Row row =
                    ADFUtils.findIterator("FindBranchesIterator").getRowAtRangeIndex(new Integer(evt.getNewValue().toString()));
                session.setAttribute("branchCode", row.getAttribute("BRN_CODE"));
               //session.setAttribute("branchCode",branchesVal.getValue());
                session.setAttribute("branchName", row.getAttribute("BRN_NAME"));
                System.out.println("branchValue Selected=" +
                                   session.getAttribute("branchName"));
              System.out.println("branchCode Selected=" +
                                 session.getAttribute("branchCode"));
                ADFUtils.findIterator("findAgentCompetionRatesIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(agentCompetionsTab);
            }
        }
    }

    public String saveAgentCompetionDtls() {
      DBConnector dbConnector = new DBConnector();
      OracleConnection conn = null;

      try {
        BigDecimal numberOfPolsVal = (BigDecimal)numberOfPols.getValue();
        BigDecimal  premiumIncomeVal = (BigDecimal)premiumIncome.getValue();
        BigDecimal  rewardAmountVal =  (BigDecimal)rewardAmount.getValue();
        String  wefVal =  GlobalCC.checkNullValues(wef.getValue());
        String  wetVal =  GlobalCC.checkNullValues(wet.getValue());
        String  competitionDescVal = GlobalCC.checkNullValues(competitionDesc.getValue());
        String competitionLevelVal = GlobalCC.checkNullValues(competitionLevel.getValue());
        BigDecimal persitencyVal = (BigDecimal)persitency.getValue();
        BigDecimal persitencyParamVal = (BigDecimal)persitencyParam.getValue();
          if (wefVal == null) {

          } else {
              if (wefVal.contains(":")) {
                  wefVal = GlobalCC.parseDate(wefVal);
              } else {
                  wefVal = GlobalCC.upDateParseDate(wefVal);
              }
          }

          if (wetVal == null) {

          } else {
              if (wetVal.contains(":")) {
                  wetVal = GlobalCC.parseDate(wetVal);
              } else {
                  wetVal = GlobalCC.upDateParseDate(wetVal);
              }
          }

          if (numberOfPolsVal == null) {
              GlobalCC.errorValueNotEntered("Error Value Missing: No.of Policies");
              return null;
          }
          if (premiumIncomeVal == null) {
              GlobalCC.errorValueNotEntered("Error Value Missing: Premium Income");
              return null;
          }
          if (rewardAmountVal == null) {
              GlobalCC.errorValueNotEntered("Error Value Missing: Amount to be awarded");
              return null;
          }
          if (competitionDescVal == null) {
             GlobalCC.errorValueNotEntered("Error Value Missing: Competion Desc");
             return null;
          }
          if (competitionLevelVal == null) {
              GlobalCC.errorValueNotEntered("Error Value Missing: Competition level");
              return null;
          }
          if (persitencyVal == null) {
             GlobalCC.errorValueNotEntered("Error Value Missing: Agent Persistency");
             return null;
          }
          if (persitencyParamVal == null) {
             GlobalCC.errorValueNotEntered("Error Value Missing: Agent Persistency Parameter(Years)");
             return null;
          }
          conn = dbConnector.getDatabaseConnection();
          String query = null;
          query =
                  "begin LMS_SETUPS_PKG.updateAgentCompetion(?,?,?,?,?,?,?,?,?,?,?,?); end;";

          OracleCallableStatement callStmt = null;
          callStmt = (OracleCallableStatement)conn.prepareCall(query);
          callStmt.setBigDecimal(1, (BigDecimal)session.getAttribute("agcpCode"));
          callStmt.setBigDecimal(2, numberOfPolsVal);
          callStmt.setBigDecimal(3, premiumIncomeVal);
          callStmt.setString(4, wefVal);
          callStmt.setString(5, wetVal);
          callStmt.setBigDecimal(6, rewardAmountVal);
          callStmt.setBigDecimal(7, (BigDecimal)session.getAttribute("prodCode"));
          callStmt.setBigDecimal(8, (BigDecimal)session.getAttribute("branchCode"));
          callStmt.setString(9, (String)competitionDescVal);
          callStmt.setString(10, competitionLevelVal);
          callStmt.setBigDecimal(11, persitencyVal);
          callStmt.setBigDecimal(12,persitencyParamVal);
          session.setAttribute("branchCode",(BigDecimal)session.getAttribute("branchCode"));
          callStmt.execute();
          callStmt.close();
          conn.commit();
          conn.close();

        numberOfPols.setValue(null);
        premiumIncome.setValue(null);
        rewardAmount.setValue(null);
        competitionDesc.setValue(null);
        wef.setValue(null);
        wet.setValue(null);
        ADFUtils.findIterator("findAgentCompetionRatesIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(agentCompetionsTab);
        GlobalCC.hidePopup("demoTemplate:competitionDtlsPop");
        //GlobalCC.saveSuccessful();

      } catch (Exception e) {
          GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
        return null;
    }

    public String updateAgentCompetionDtls() {
      Object key2 = agentCompetionsTab.getSelectedRowData();
      if (key2 == null) {
          GlobalCC.errorValueNotEntered("No Record Selected");
          return null;
      }
      JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
      if (r == null) {
          GlobalCC.errorValueNotEntered("No Record Selected");
          return null;
      }

      numberOfPols.setValue(r.getAttribute("agcpTotalPolicies"));
      premiumIncome.setValue(r.getAttribute("agcpTotalPremium"));
      rewardAmount.setValue(r.getAttribute("agcpRewardAmnt"));
      wef.setValue(r.getAttribute("agcpWef"));
      wet.setValue(r.getAttribute("agcpWet"));
      competitionDesc.setValue(r.getAttribute("agcpCompetitionDesc"));

      if(r.getAttribute("agcpLevel").equals("All Products")){
          competitionLevel.setValue("A");
      }else{
          competitionLevel.setValue("N");
      }
      
      persitency.setValue(r.getAttribute("agcpPersitency"));
      persitencyParam.setValue(r.getAttribute("agcpPersitencyParam"));
      session.setAttribute("agcpCode",r.getAttribute("agcpCode"));
      session.setAttribute("prodCode",r.getAttribute("agcpProdCode"));
      session.setAttribute("branchCode",r.getAttribute("agcpBrnCode"));
      System.out.println("agcpCode=" + session.getAttribute("agcpCode"));
      ExtendedRenderKitService erkService =
          Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                             ExtendedRenderKitService.class);
      erkService.addScript(FacesContext.getCurrentInstance(),
                           "var hints = {autodismissNever:false}; " +
                           "AdfPage.PAGE.findComponent('" +
                           "demoTemplate:competitionDtlsPop" +
                           "').show(hints);");
        return null;
    }
    public String deleteCompRates() {
        Object key2 = agentCompetionsTab.getSelectedRowData();
          if (key2 == null) {
              GlobalCC.errorValueNotEntered("No Record Selected");
              return null;
          }
          JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
          if (r == null) {
              GlobalCC.errorValueNotEntered("No Record Selected");
              return null;
          }

          DBConnector dbConnector = new DBConnector();
          OracleConnection conn = null;
          conn = dbConnector.getDatabaseConnection();

          try {

              String query =
                  "begin LMS_SETUPS_PKG.deleteAgentCompetionRates(?); end;";
              OracleCallableStatement callStmt = null;
              callStmt = (OracleCallableStatement)conn.prepareCall(query);
              //bind the variables
              callStmt.setBigDecimal(1, (BigDecimal)r.getAttribute("agcpCode"));
              callStmt.execute();
              callStmt.close();
              conn.close();
              ADFUtils.findIterator("findAgentCompetionRatesIterator").executeQuery();
              AdfFacesContext.getCurrentInstance().addPartialTarget(agentCompetionsTab);
              //GlobalCC.deleteSuccessful();
          } catch (Exception e) {
              GlobalCC.EXCEPTIONREPORTING(conn, e);
          }
        return null;
    }

    public void setProductsDefination(RichTree productsDefination) {
        this.productsDefination = productsDefination;
    }

    public RichTree getProductsDefination() {
        return productsDefination;
    }

    public void setBranchesVal(RichSelectOneChoice branchesVal) {
        this.branchesVal = branchesVal;
    }

    public RichSelectOneChoice getBranchesVal() {
        return branchesVal;
    }

    public void setCompetitionDesc(RichInputText competitionDesc) {
        this.competitionDesc = competitionDesc;
    }

    public RichInputText getCompetitionDesc() {
        return competitionDesc;
    }

    public void setAgentCompetionPanel(RichPanelBox agentCompetionPanel) {
        this.agentCompetionPanel = agentCompetionPanel;
    }

    public RichPanelBox getAgentCompetionPanel() {
        return agentCompetionPanel;
    }

    public void setAgentPerformancePanel(RichPanelGroupLayout agentPerformancePanel) {
        this.agentPerformancePanel = agentPerformancePanel;
    }

    public RichPanelGroupLayout getAgentPerformancePanel() {
        return agentPerformancePanel;
    }

    public void setBudgetPanel(RichPanelGroupLayout budgetPanel) {
        this.budgetPanel = budgetPanel;
    }

    public RichPanelGroupLayout getBudgetPanel() {
        return budgetPanel;
    }

    public void setCompetitionDashBoard(RichPanelGroupLayout competitionDashBoard) {
        this.competitionDashBoard = competitionDashBoard;
    }

    public RichPanelGroupLayout getCompetitionDashBoard() {
        return competitionDashBoard;
    }

    public void setCompetitionLevel(RichSelectOneChoice competitionLevel) {
        this.competitionLevel = competitionLevel;
    }

    public RichSelectOneChoice getCompetitionLevel() {
        return competitionLevel;
    }

    public void setPersitency(RichInputNumberSpinbox persitency) {
        this.persitency = persitency;
    }

    public RichInputNumberSpinbox getPersitency() {
        return persitency;
    }

    public void setPersitencyParam(RichInputNumberSpinbox persitencyParam) {
        this.persitencyParam = persitencyParam;
    }

    public RichInputNumberSpinbox getPersitencyParam() {
        return persitencyParam;
    }
}
