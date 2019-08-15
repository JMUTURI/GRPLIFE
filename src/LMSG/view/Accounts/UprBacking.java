package LMSG.view.Accounts;

import LMSG.view.Base.ADFUtils;
import LMSG.view.Base.GlobalCC;

import LMSG.view.connect.DBConnector;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.data.RichTree;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.uicli.binding.JUCtrlHierNodeBinding;
import oracle.jbo.uicli.binding.JUCtrlValueBinding;

import org.apache.myfaces.trinidad.event.SelectionEvent;
import org.apache.myfaces.trinidad.model.RowKeySet;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;


public class UprBacking {

    private RichTree uprTree;
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    private RichTable uprTable;
    private RichTable uprDet;
  private RichTree ibnrTree;
     private RichTable ibnrTable;
    public void setUprTree(RichTree uprTree) {
        this.uprTree = uprTree;
    }

    public RichTree getUprTree() {
        return uprTree;
    }

    public void selectUpr(SelectionEvent selectionEvent) {
        if (selectionEvent.getAddedSet() != selectionEvent.getRemovedSet()) {
            RowKeySet keys = selectionEvent.getAddedSet();
            if (keys != null && keys.getSize() > 0) {
                for (Object treeRowKey : keys) {
                    uprTree.setRowKey(treeRowKey);
                    JUCtrlHierNodeBinding nd =
                        (JUCtrlHierNodeBinding)uprTree.getRowData();
                    //System.out.println("Type "+nd.getRow().getAttribute("type"));
                    if(nd.getRow().getAttribute("type").equals("S")){
                    BigDecimal transCode=(BigDecimal)nd.getRow().getAttribute("utrans_code");
                  //  session.setAttribute("fiscalYear", nd.getRow().getAttribute("utrans_year"));
                     session.setAttribute("fiscalYear", nd.getRow().getAttribute("utrans_code"));
                    session.setAttribute("transCode", transCode);
                    ADFUtils.findIterator("findUprDetailsIterator").executeQuery();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(uprTable);
                    }
                    
                }
            }
        }
    }

    public void setUprTable(RichTable uprTable) {
        this.uprTable = uprTable;
    }

    public RichTable getUprTable() {
        return uprTable;
    }

    public String populateNext() {
        DBConnector connection = new DBConnector();
        String query = "begin LMS_UPR_PKG.create_next_period(?);end;";
        CallableStatement stmt = null;
        Connection conn = null;
        try {
            conn = connection.getDatabaseConn();
            stmt = conn.prepareCall(query);
            stmt.setString(1, (String)session.getAttribute("Username"));
            stmt.execute();
            ADFUtils.findIterator("findUprsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(uprTree);
        }
        catch(SQLException e){
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public String processAction() {
        if(session.getAttribute("transCode")==null){
            GlobalCC.INFORMATIONREPORTING("No Transaction Selected...");
            return null;
        }
        DBConnector connection =new DBConnector();
        String query = "begin LMS_UPR_PKG.process_upr(?,?);end;";
        CallableStatement stmt = null;
        Connection conn = null;
        try {
            conn = connection.getDatabaseConn();
            stmt = conn.prepareCall(query);
            stmt.setBigDecimal(1, (BigDecimal)session.getAttribute("transCode"));
            stmt.setString(2, (String)session.getAttribute("Username"));
            stmt.execute();
            ADFUtils.findIterator("findUprDetailsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(uprTable);
            GlobalCC.INFORMATIONREPORTING("UPR/UCR Processed Successfully");
        }
        catch(SQLException e){
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }
        return null;
    }

    public String authorizeUpr() {
        if(session.getAttribute("transCode")==null){
            GlobalCC.INFORMATIONREPORTING("No Transaction Selected...");
            return null;
        }
        DBConnector connection =new DBConnector();
        String query = "begin LMS_UPR_PKG.authorize_upr_ucr(?,?);end;";
        CallableStatement stmt = null;
        Connection conn = null;
        try {
            conn = connection.getDatabaseConn();
            stmt = conn.prepareCall(query);
            stmt.setBigDecimal(1, (BigDecimal)session.getAttribute("transCode"));
            stmt.setString(2, (String)session.getAttribute("Username"));
            stmt.execute();
            ADFUtils.findIterator("findUprDetailsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(uprTable);
            GlobalCC.INFORMATIONREPORTING("UPR/UCR Authorised Successfully");
        }
        catch(SQLException e){
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }
        return null;
    }

    public String showDetails() {
        // 
        Object key2 = uprTable.getSelectedRowData();
            JUCtrlValueBinding r =
                (JUCtrlValueBinding)key2;
            if (r == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            session.setAttribute("brnCode", r.getAttribute("usum_brn_code"));
            session.setAttribute("sclCode", r.getAttribute("usum_scl_code"));
            session.setAttribute("curCode", r.getAttribute("usum_cur_code"));
        ADFUtils.findIterator("findUprDetailsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(uprDet);
            
        ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                               ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; " +
                             "AdfPage.PAGE.findComponent('" +
                             "generalTemplate:p1" +
                             "').show(hints);");
        return null;
    }

    public void setUprDet(RichTable uprDet) {
        this.uprDet = uprDet;
    }

    public RichTable getUprDet() {
        return uprDet;
    }

    public void selectUprTrans(SelectionEvent selectionEvent) {
        Object key2 = this.uprTable.getSelectedRowData();
        JUCtrlValueBinding rows = (JUCtrlValueBinding)key2;

        if (rows == null) {
          GlobalCC.errorValueNotEntered("No Record Selected");
          return;
        }
        /*session.setAttribute("subclass", rows.getAttribute("usum_scl_code"));
        session.setAttribute("brncode",  rows.getAttribute("usum_brn_code"));
        session.setAttribute("currency",  rows.getAttribute("usum_cur_code"));*/
    }
  public void selectIbnr(SelectionEvent selectionEvent) {
       if (selectionEvent.getAddedSet() != selectionEvent.getRemovedSet()) {
           RowKeySet keys = selectionEvent.getAddedSet();
           if (keys != null && keys.getSize() > 0) {
               for (Object treeRowKey : keys) {
                   ibnrTree.setRowKey(treeRowKey);
                   JUCtrlHierNodeBinding nd =
                       (JUCtrlHierNodeBinding)ibnrTree.getRowData();
                   //System.out.println("Type "+nd.getRow().getAttribute("type"));
                   if(nd.getRow().getAttribute("type").equals("S")){
                   BigDecimal transCode=(BigDecimal)nd.getRow().getAttribute("utrans_code");
                   session.setAttribute("fiscalYear", nd.getRow().getAttribute("utrans_year"));
                   session.setAttribute("transCode", transCode);
                   ADFUtils.findIterator("findIbnrSummaryIterator").executeQuery();
                   AdfFacesContext.getCurrentInstance().addPartialTarget(ibnrTable);
                   }
                   
               }
           }
       }
   }

     public void setIbnrTree(RichTree ibnrTree) {
         this.ibnrTree = ibnrTree;
     }

     public RichTree getIbnrTree() {
         return ibnrTree;
     }
   public String populateIbnrNext() {
       DBConnector connection =new DBConnector();
       String query = "begin GIS_IBNR_PKG.create_ibnr_next_period(?);end;";
       CallableStatement stmt = null;
       Connection conn = null;
       try {
           conn = connection.getDatabaseConn();
           stmt = conn.prepareCall(query);
           stmt.setString(1, (String)session.getAttribute("Username"));
           stmt.execute();
           ADFUtils.findIterator("findIbnrIterator").executeQuery();
           AdfFacesContext.getCurrentInstance().addPartialTarget(ibnrTree);
       }
       catch(SQLException e){
           GlobalCC.EXCEPTIONREPORTING(conn,e);
       }
       return null;
   }

     public void setIbnrTable(RichTable ibnrTable) {
         this.ibnrTable = ibnrTable;
     }

     public RichTable getIbnrTable() {
         return ibnrTable;
     }
   public String processIbnrAction() {
       if(session.getAttribute("transCode")==null){
           GlobalCC.INFORMATIONREPORTING("No Transaction Selected...");
           return null;
       }
       DBConnector connection =new DBConnector();
       String query = "begin GIS_IBNR_PKG.process_ibnr(?,?);end;";
       CallableStatement stmt = null;
       Connection conn = null;
       try {
           conn = connection.getDatabaseConn();
           stmt = conn.prepareCall(query);
           stmt.setBigDecimal(1, (BigDecimal)session.getAttribute("transCode"));
           stmt.setString(2, (String)session.getAttribute("Username"));
           stmt.execute();
         ADFUtils.findIterator("findIbnrSummaryIterator").executeQuery();
         AdfFacesContext.getCurrentInstance().addPartialTarget(ibnrTable);
           GlobalCC.INFORMATIONREPORTING("IBNR Processed Successfully");
       }
       catch(SQLException e){
           GlobalCC.EXCEPTIONREPORTING(conn,e);
       }
       return null;
   }
   public String authorizeIbnr() {
       if(session.getAttribute("transCode")==null){
           GlobalCC.INFORMATIONREPORTING("No Transaction Selected...");
           return null;
       }
       DBConnector connection =new DBConnector();
       String query = "begin GIS_IBNR_PKG.authorize_ibnr(?,?);end;";
       CallableStatement stmt = null;
       Connection conn = null;
       try {
           conn = connection.getDatabaseConn();
           stmt = conn.prepareCall(query);
           stmt.setBigDecimal(1, (BigDecimal)session.getAttribute("transCode"));
           stmt.setString(2, (String)session.getAttribute("Username"));
           stmt.execute();
         ADFUtils.findIterator("findIbnrSummaryIterator").executeQuery();
         AdfFacesContext.getCurrentInstance().addPartialTarget(ibnrTable);
           GlobalCC.INFORMATIONREPORTING("IBNR Authorised Successfully");
       }
       catch(SQLException e){
           GlobalCC.EXCEPTIONREPORTING(conn,e);
       }
       return null;
   }
}
