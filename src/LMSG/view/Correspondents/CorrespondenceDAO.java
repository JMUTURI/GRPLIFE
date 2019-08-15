package LMSG.view.Correspondents;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.jdbc.OracleTypes;

import LMSG.view.Base.GlobalCC;
import LMSG.view.Base.LOVCC;

import LMSG.view.connect.DBConnector;

public class CorrespondenceDAO extends LOVCC {
    public CorrespondenceDAO() {
        super();
    }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    public List<Correspondence> findMessageTemplates() {
        
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Correspondence> msgTemplates = new ArrayList<Correspondence>();
        try {
           
                String msgQuery = 
                    "begin TQC_WEB_CURSOR.MessageTemplates(?,?,?,?); end;";
                cst = conn.prepareCall(msgQuery);
                      
             cst.registerOutParameter(1, 
                                     OracleTypes.CURSOR);
             cst.setInt(2, GlobalCC.sysCode);
             cst.setString(3, (String)session.getAttribute("sysModule"));
             cst.setString(4, (String)session.getAttribute("msgType"));
             cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            int k = 0;
            while (rs.next()) {
                Correspondence msgTemp = new Correspondence();
                msgTemp.setMsgCode(rs.getBigDecimal(1));
                msgTemp.setMsgShtDesc(rs.getString(2));
                msgTemp.setMsgDesc(rs.getString(3));
                msgTemplates.add(msgTemp);
                k++;
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }            
      
        return msgTemplates;
    }
    
    public List<Correspondence> findMessageValues() {
        
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Correspondence> msgTemplates = new ArrayList<Correspondence>();
        try {
           
            String msgQuery = 
                    "begin LMS_WEB_CURSOR_GRP.get_qpc_dtls(?,?,?); end;";
            cst = conn.prepareCall(msgQuery);
                      
            cst.registerOutParameter(1, 
                                     OracleTypes.CURSOR);
            cst.setString(2, (String)session.getAttribute("sysModule"));
            String SysMdle = (String)session.getAttribute("sysModule");
            if (SysMdle.equalsIgnoreCase("Q")){
                cst.setBigDecimal(3,(BigDecimal)session.getAttribute("QuoteCode")); 
            }else if (SysMdle.equalsIgnoreCase("U")){
                cst.setBigDecimal(3,(BigDecimal)session.getAttribute("policyCode"));
            }else{
                cst.setString(3,(String)session.getAttribute("ClaimNo"));
            }
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            int k = 0;
            while (rs.next()) {
                Correspondence msgTemp = new Correspondence();
                
                msgTemp.setCLIENT(rs.getString(1));
                msgTemp.setAGN_NAME(rs.getString(2));
                msgTemp.setCODE(rs.getString(3));
                msgTemp.setVAL(rs.getString(4));
                msgTemplates.add(msgTemp);
                k++;
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }            
      
        return msgTemplates;
    }
}
