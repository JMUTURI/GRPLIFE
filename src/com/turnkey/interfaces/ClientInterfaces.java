package com.turnkey.interfaces;

import com.leadway.pf.service.ws.PfData;
import com.leadway.pf.service.ws.PfServiceProxy;
import com.leadway.projects.payment.endpoint.PaymentManagementProxy;
import com.leadway.projects.payment.endpoint.DebitCreditNote;

import java.io.File;

import java.math.BigDecimal;

import java.net.InetAddress;

import java.net.UnknownHostException;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.ResultSet;

import java.util.Calendar;

import java.util.Date;

import javax.faces.context.FacesContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import oracle.jdbc.OracleTypes;

import LMSG.view.Base.GlobalCC;

import LMSG.view.connect.DBConnector;

public class ClientInterfaces {
    public ClientInterfaces() {
        super();
    }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    public boolean SaveDebitCreditNote(){
            Connection conn=null;
            boolean result = false;
            try{
                Calendar test = null;
                Calendar Today = null;
                
                //Today.setTime(Now);
                String DebtNote = null;
                
                String PMSUrl = null;
                
                //Open a Connection to the webservice.
                DebitCreditNote MyDebitCredit = new DebitCreditNote();
                DebitCreditNote MyResponseDebitCredit = new DebitCreditNote();
                PaymentManagementProxy stub;
                
                //Get the Active PMS Connection...
                FacesContext context = FacesContext.getCurrentInstance();
                ServletContext sc = (ServletContext)context.getExternalContext().getContext();
                String path = null;
                path = sc.getRealPath("Connection/PMSConnection.xml");
                
                File file = new File(path);
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db=null;
                //Document doc;
                
                Document doc = db.parse(file);
                doc.getDocumentElement().normalize();
                NodeList nodeLst = doc.getElementsByTagName("connection");

                for (int s = 0; s < nodeLst.getLength(); s++) {
                    
                Node fstNode = nodeLst.item(s);
                    
                    if (fstNode.getNodeType() == Node.ELEMENT_NODE) {

                        if (s == 0) {
                            Element fstElmnt = (Element)fstNode;
                            NodeList fstNmElmntLst =
                                fstElmnt.getElementsByTagName("jdblUrl");
                            Element fstNmElmnt = (Element)fstNmElmntLst.item(0);
                            NodeList fstNm = fstNmElmnt.getChildNodes();
                            PMSUrl = (fstNm.item(0)).getNodeValue();
                        }
                    }
                }
                
                if(PMSUrl == null){
                GlobalCC.errorValueNotEntered("No PMS Server Specified.");
                    return result;
                }else{
                    //PMS Server Acquired...
                }
                //stub = new PaymentManagementProxy("http://10.176.18.56:8085/PaymentManagementService/PaymentManagement");
                //stub = new PaymentManagementProxy("http://172.20.90.68:8080/PaymentManagementService/PaymentManagement");
                stub = new PaymentManagementProxy(PMSUrl);
                
                
                //Query Database for DRCR Information for the Endorsement.
                DBConnector myConn=new DBConnector();
                conn=myConn.getDatabaseConn();
                CallableStatement cst=null;
                String DRCR="begin LMS_WEB_CURSOR_GRP.get_endr_drcr(?,?);end;";
                cst=conn.prepareCall(DRCR);
                
                cst.registerOutParameter(1,OracleTypes.CURSOR);
                cst.setBigDecimal(2, (BigDecimal)session.getAttribute("endorsementCode"));
                cst.execute();
                ResultSet rst=(ResultSet)cst.getObject(1);
                while(rst.next()){
                    MyDebitCredit.setAddress(rst.getString(1));
                    MyDebitCredit.setAgentCode(rst.getString(2));
                    MyDebitCredit.setAgentID(rst.getLong(3));
                    MyDebitCredit.setAgentName(rst.getString(4));
                    MyDebitCredit.setBranchCode(rst.getString(5));
                    MyDebitCredit.setBrokerReference(rst.getString(6));
                    MyDebitCredit.setCDNNumber(rst.getString(7));
                    MyDebitCredit.setCertificateNumber(rst.getString(8));
                    MyDebitCredit.setCityId(rst.getLong(9));
                    //MyDebitCredit.set(null);
                    MyDebitCredit.setCurrency(rst.getString(17));
                    MyDebitCredit.setCurrentInsurancePeriod(null);
                    MyDebitCredit.setDebitCreditNoteNumber(rst.getString(26));
                    DebtNote = rst.getString(26);
                    MyDebitCredit.setDebitCreditSign(rst.getString(20));
                    MyDebitCredit.setDeleted(false);
                    //test.setTime(rst.getDate(23));
                    MyDebitCredit.setEffectiveDate(test);
                    MyDebitCredit.setEntryDate(test);
                    MyDebitCredit.setISTransmitStatus(null);
                    MyDebitCredit.setInceptionDate(test);
                    MyDebitCredit.setLgaId(1);
                    MyDebitCredit.setLinkDebitCreditNumber(rst.getString(26));
                    MyDebitCredit.setNameOfInsured(rst.getString(27));
                    MyDebitCredit.setNarration(rst.getString(28));
                    MyDebitCredit.setPercentDistribution(null);
                    MyDebitCredit.setPolicyNumber(rst.getString(14));
                    MyDebitCredit.setPremiumAmount(rst.getDouble(15));
                    MyDebitCredit.setPreviousReference(null);
                    MyDebitCredit.setProrata(1);
                    MyDebitCredit.setReferenceNumber(rst.getString(26));
                    MyDebitCredit.setScheduleGroup(null);
                    MyDebitCredit.setStateCode(null);
                    MyDebitCredit.setSubsystem(null);
                    MyDebitCredit.setTransactionCode(rst.getString(32));
                    MyDebitCredit.setTransactionDate(Today);
                    MyDebitCredit.setTransactionLink(1);
                    MyDebitCredit.setTransactionMode(null);
                    MyDebitCredit.setTransactionSource(null);
                    MyDebitCredit.setTransactionType(null);
                    MyDebitCredit.setUserName("TQUEST");   
                    
                }
                
                //Call SaveDebitCredit Function on the Webservice.
                MyResponseDebitCredit = stub.saveDebitCreditNote(MyDebitCredit, "231", "10.176.18.128");
                //System.out.println( "Return Note No:" + MyResponseDebitCredit.getDebitCreditNoteNumber());
                //MyResponseDebitCredit = stub.findDebitNoteByDebitNoteNumber(DebtNote, "10.176.18.128");
                //System.out.println( "New Note No:" + MyResponseDebitCredit.getDebitCreditNoteNumber());
                System.out.println("Debit Credit Note Saved.");
                //System.out.println( "Return Note No:" + MyResponseDebitCredit.getDebitCreditNoteNumber());
                result = true;

                
            }catch(Exception e){
                e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(conn,e);
            }
            return result;
        }
    /*public boolean SaveDebitCreditNote(){
        boolean result = false;
        try{
            Calendar test = null;
            Calendar Today = null;
            
            //Today.setTime(Now);
            String DebtNote = null;
            
            //Open a Connection to the webservice.
            DebitCreditNote MyDebitCredit = new DebitCreditNote();
            DebitCreditNote MyResponseDebitCredit = new DebitCreditNote();
            PaymentManagementProxy stub;
            //stub = new PaymentManagementProxy("http://10.176.18.56:8085/PaymentManagementService/PaymentManagement");
            stub = new PaymentManagementProxy("http://172.20.90.68:8080/PaymentManagementService/PaymentManagement");
            
            
            //Query Database for DRCR Information for the Endorsement.
            DBConnector myConn=new DBConnector();
            Connection conn=myConn.getDatabaseConn();
            CallableStatement cst=null;
            String DRCR="begin LMS_WEB_CURSOR_GRP.get_endr_drcr(?,?);end;";
            cst=conn.prepareCall(DRCR);
            
            cst.registerOutParameter(1,OracleTypes.CURSOR);
            cst.setBigDecimal(2, (BigDecimal)session.getAttribute("endorsementCode"));
            cst.execute();
            ResultSet rst=(ResultSet)cst.getObject(1);
            while(rst.next()){
                MyDebitCredit.setAddress(rst.getString(1));
                MyDebitCredit.setAgentCode(rst.getString(2));
                //MyDebitCredit.setAgentID(rst.getLong(3));
                MyDebitCredit.setAgentID(null);
                MyDebitCredit.setAgentName(rst.getString(4));
                MyDebitCredit.setBranchCode(rst.getString(5));
                MyDebitCredit.setBrokerReference(rst.getString(6));
                MyDebitCredit.setCDNNumber(rst.getString(7));
                MyDebitCredit.setCertificateNumber(rst.getString(8));
                MyDebitCredit.setCityId(rst.getLong(9));
                //MyDebitCredit.set(null);
                MyDebitCredit.setCurrency(rst.getString(17));
                MyDebitCredit.setCurrentInsurancePeriod(null);
                MyDebitCredit.setDebitCreditNoteNumber(rst.getString(26));
                DebtNote = rst.getString(26);
                MyDebitCredit.setDebitCreditSign(rst.getString(20));
                MyDebitCredit.setDeleted(false);
                //test.setTime(rst.getDate(23));
                MyDebitCredit.setEffectiveDate(test);
                MyDebitCredit.setEntryDate(test);
                MyDebitCredit.setISTransmitStatus(null);
                MyDebitCredit.setInceptionDate(test);
                MyDebitCredit.setLgaId(1);
                MyDebitCredit.setLinkDebitCreditNumber(rst.getString(26));
                MyDebitCredit.setNameOfInsured(rst.getString(27));
                MyDebitCredit.setNarration(rst.getString(28));
                MyDebitCredit.setPercentDistribution(null);
                MyDebitCredit.setPolicyNumber(rst.getString(14));
                MyDebitCredit.setPremiumAmount(rst.getDouble(15));
                MyDebitCredit.setPreviousReference(null);
                MyDebitCredit.setProrata(1);
                MyDebitCredit.setReferenceNumber(rst.getString(26));
                MyDebitCredit.setScheduleGroup(null);
                MyDebitCredit.setStateCode(null);
                MyDebitCredit.setSubsystem("TQUEST");
                MyDebitCredit.setTransactionCode(rst.getString(32));
                MyDebitCredit.setTransactionDate(Today);
                MyDebitCredit.setTransactionLink(1);
                MyDebitCredit.setTransactionMode(null);
                MyDebitCredit.setTransactionSource(null);
                MyDebitCredit.setTransactionType(null);
                MyDebitCredit.setUserName("TQUEST");   
                
            }
            
            //Call SaveDebitCredit Function on the Webservice.
            MyResponseDebitCredit = stub.saveDebitCreditNote(MyDebitCredit, "231", "10.176.18.128");
            //System.out.println( "Return Note No:" + MyResponseDebitCredit.getDebitCreditNoteNumber());
            //MyResponseDebitCredit = stub.findDebitNoteByDebitNoteNumber(DebtNote, "10.176.18.128");
            //System.out.println( "New Note No:" + MyResponseDebitCredit.getDebitCreditNoteNumber());
            System.out.println("Debit Credit Note Saved.");
            //System.out.println( "Return Note No:" + MyResponseDebitCredit.getDebitCreditNoteNumber());
            result = true;

            
        }catch(Exception e){
            e.printStackTrace();
             GlobalCC.EXCEPTIONREPORTING(conn,e);
        }
        //return result;
    }*/
    
    public boolean RegisterNewPolicyOnPF(){
           boolean result = false;
           Connection conn=null;
           try{
              
               String Hostname;
               //Get Connected Machine.
               Hostname = connectedMachine();
               
               //Get Data from Turnquest Application.
               PfData MyData = new PfData();
               DBConnector myConn=new DBConnector();
               conn=myConn.getDatabaseConn();
               CallableStatement cst=null;
               String DRCR="begin LMS_WEB_CURSOR_GRP.get_premium_financing(?,?);end;";
               cst=conn.prepareCall(DRCR);
               
               cst.registerOutParameter(1,OracleTypes.CURSOR);
               cst.setBigDecimal(2, (BigDecimal)session.getAttribute("endorsementCode"));
               cst.execute();
               ResultSet rst=(ResultSet)cst.getObject(1);
               while(rst.next()){
                   MyData.setAccountNumber(rst.getString(1));
                   MyData.setAgencyCode(rst.getString(2));
                   MyData.setAgencyData(null);
                   MyData.setApprovalDate(parseWebServiceDate(rst.getDate(3)));
                   MyData.setApprovedBy(rst.getString(4));
                   MyData.setApprovedBy(rst.getString(5));
                   MyData.setBankConfirmDate(parseWebServiceDate(rst.getDate(6)));
                   MyData.setBankConfirmRef(rst.getString(7));
                   MyData.setBankSortCode(rst.getString(8));
                   MyData.setBranchCode(rst.getString(9));
                   MyData.setCalcRevisedPremium(rst.getString(10));
                   MyData.setClientCode(rst.getString(11));
                   MyData.setClientData(null);
                   MyData.setCommission(rst.getBigDecimal(12));
                   //MyData.setCreateDate(parseWebServiceDate(rst.getDate(13)));
                   //MyData.setCreatedBy(rst.getString(14));
                   MyData.setDebitNoteDate(parseWebServiceDate(rst.getDate(13)));
                   MyData.setDebitNoteNo(rst.getString(14));
                   MyData.setDepPremiumcommission(rst.getBigDecimal(15));
                   MyData.setDepositPaymentMode(rst.getString(16));
                   MyData.setDepositPremiumIndicator(rst.getString(17));
                   MyData.setDepositPremiumMin(rst.getBigDecimal(18));
                   MyData.setDepositPremiumPaid(rst.getBigDecimal(19));
                   MyData.setEndorsementNumber(rst.getString(20));
                   MyData.setErrMsg(rst.getString(21));
                   MyData.setFirstRepaymentDate(parseWebServiceDate(rst.getDate(22)));
                   MyData.setInstallPremium(rst.getBigDecimal(23));
                   MyData.setInterestRate(rst.getDouble(24));
                   MyData.setManageMode(rst.getString(25));
                   MyData.setPaymentFrequency(rst.getString(26));
                   MyData.setPfRefNo(rst.getString(27));
                   MyData.setPolicyExpirationDate(parseWebServiceDate(rst.getDate(28)));
                   MyData.setPolicyHolder(rst.getString(29));
                   MyData.setPolicyNumber(rst.getString(30));
                   //MyData.setPolicyTenor(rst.getInt(31));
                   MyData.setPremiumDue(rst.getBigDecimal(32));
                   MyData.setPremiumFinanced(rst.getBigDecimal(33));
                   MyData.setPremiumReceiptNo(rst.getString(34));
                   MyData.setPrevDDIndicator(rst.getString(35));
                   MyData.setResidualPremium(rst.getBigDecimal(36));
                   MyData.setRiskClass(rst.getString(37));
                   MyData.setRiskClassCode(rst.getString(38));
                   //MyData.setRiskItemCount(riskItemCount);
                   MyData.setSubsystemCode(rst.getString(40));
               }
               
               PfServiceProxy stub;
               stub = new PfServiceProxy("http://10.176.18.56:8086/PfServiceService/PfService");
               stub.registerNewPolicy(MyData);

               System.out.println("Premium Financing on Endorsement " +  session.getAttribute("endorsementCode"));
               
               result = true;
               
           }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(conn,e);
           }
           return result;
       }
       
       public static String connectedMachine(){
                  String hostname = null;
                  try {
                          InetAddress addr = InetAddress.getLocalHost();
                      
                          // Get hostname and Address.
                      InetAddress[] all_IPs = InetAddress.getAllByName(addr.getHostName());
                           for (int i=0; i<all_IPs.length; i++) {
                                   hostname = all_IPs[i].toString();
                           }
                      } catch (UnknownHostException e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);                                     
                      }
                  return hostname;
              }
       
       public static Calendar parseWebServiceDate(Date MyDate){
           Calendar cal=Calendar.getInstance();
           
           try{     
               if(MyDate==null){
                   Date Today = new Date();
                   cal.setTime(Today);
               }else{
               cal.setTime(MyDate);
               }
           }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
           }
           return cal;
        }
}
