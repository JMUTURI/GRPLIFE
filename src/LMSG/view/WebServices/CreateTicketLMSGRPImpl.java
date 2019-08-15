package LMSG.view.WebServices;

import LMSG.view.BPM.ProcessDMSTicket;
import LMSG.view.Base.GlobalCC;
import LMSG.view.connect.DBConnector;

import java.sql.CallableStatement;
import java.sql.Connection;

import javax.jws.WebMethod;
import javax.jws.WebService;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.sql.DataSource;

import oracle.jdbc.OracleConnection;

@WebService
public class CreateTicketLMSGRPImpl implements CreateTicketLMSGRP {

    @WebMethod
    public String startTicket( String DocumentType,  String user,String documentName,String documentId){
		
	  System.out.println("DocumentType " + DocumentType + "user " + user);   
	  System.out.println("documentName " + documentName + "documentId " + documentId); 
    
		try {
        ProcessDMSTicket Tpg = new ProcessDMSTicket();
        Tpg.saveDmsDocuments(DocumentType, user, documentName,documentId);
        System.out.println("Successfully!"); 
		} catch (Exception e) {
			  //return e.getMessage();
        e.printStackTrace();
		}
    
    
		return "Y";
	}
    
   
    
}
