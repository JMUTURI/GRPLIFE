package LMSG.view.BPM;

import org.jbpm.api.jpdl.DecisionHandler;
import org.jbpm.api.model.OpenExecution;

import LMSG.view.Base.GlobalCC;

public class AccessEvaluation implements DecisionHandler {
    
    public String decide(OpenExecution execution) {
    try{
        String Rights = null;
         workflowProcessing wf = new workflowProcessing();
         Rights = wf.CheckUserRights();
       if(Rights == null){
             return "No";    
       }
       if (Rights.equalsIgnoreCase("N")) {
         return "No";
       }
       if (Rights.equalsIgnoreCase("Y")) {
         return "Yes";
       }
      
    }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
    }
    return "No";
}
    
}
