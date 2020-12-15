package LMSG.view.WebServices;

import LMSG.view.Base.GlobalCC;
import LMSG.view.Base.LOVCC;
import LMSG.view.connect.DBConnector;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GrpTicket {
    public GrpTicket() {
        super();
    }
  public String UpdateWorkflowAttributes(BPMParams params) {
      String Result = "F";
      Connection conn = null;
      CallableStatement cst = null;
      try {
        DBConnector myConn = new DBConnector();
        conn = myConn.getDatabaseConn();
        String Updatewkflw = "BEGIN Tqc_Web_Pkg.save_workflw_attributes(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);END;";

        cst = conn.prepareCall(Updatewkflw);
        cst.setString(1, params.getTaskID());
        cst.setInt(2, params.getSysCode());
        cst.setString(3, params.getCurrentStatus());
        cst.setBigDecimal(4, params.getClientCode()); // Client Code
        cst.setBigDecimal(5, params.getAgnCode());
        cst.setBigDecimal(6, params.getPolicyCode());
        cst.setString(7, params.getPolicyNumber()); // Replace with Global Policy Number
        cst.setString(8, params.getClaimNo());
        cst.setBigDecimal(9, params.getQuoteCode());
        cst.setString(10, params.getUsername());
        cst.setString(11, null);
        cst.setString(12, params.getWorkflowID());
        cst.setString(13, params.getQuotationNo());
        cst.setBigDecimal(14, params.getEndorsementCode());
        cst.setString(15, params.getProductType());
        cst.setString(16, params.getTaskAssignee());
        cst.setString(17, params.getTicketRemarks());
        cst.setString(18, params.getEndorsement());
        cst.setBigDecimal(19, params.getTransactionNumber());
        cst.setBigDecimal(20, params.getPrpCode()); // PRP Code...

        System.out.println("Done updating!");
        GlobalCC.CloseConnections(null, cst, conn);
        Result = "S";
      } catch (Exception ex) {
        GlobalCC.CloseConnections(null, cst, conn);
      } finally {
        GlobalCC.CloseConnections(null, cst, conn);
      }
      return Result;
    }
}
