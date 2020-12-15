package LMSG.view.WebServices;

import javax.jws.WebService;

@WebService
public interface CreateTicketLMSGRP {
    
    public String startTicket(String DocumentType,  String user,String documentName,String documentId);
    public String CreateWorkflowInstance(BPMParams params);
 
}