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

import LMSG.view.BPM.wfEngine;

import org.jbpm.pvm.internal.cfg.JbpmConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.jbpm.api.task.Task;


@WebService
public class CreateTicketLMSGRPImpl implements CreateTicketLMSGRP {

    @WebMethod
    public String startTicket(String DocumentType, String user,
                              String documentName, String documentId) {

        System.out.println("DocumentType " + DocumentType + "user " + user);
        System.out.println("documentName " + documentName + "documentId " +
                           documentId);

        try {
            ProcessDMSTicket Tpg = new ProcessDMSTicket();
            Tpg.saveDmsDocuments(DocumentType, user, documentName, documentId);
            System.out.println("Successfully!");
        } catch (Exception e) {
            //return e.getMessage();
            e.printStackTrace();
        }


        return "Y";
    }

    public String CreateWorkflowInstance(BPMParams params) {

        try {
            JbpmConfiguration pid = null;
            wfEngine wf = new wfEngine();
            GrpTicket ticket=new GrpTicket();
            // JBPMEngine test = new JBPMEngine();
            // Deploy the Workflow
            // wf.deployWorkflow((String)session.getAttribute("ProcessBPMDef") +
            // ".jpdl.xml");

            // start the instance
            pid = wf.startWorkFlowInstance();

            // start workflow
            HashMap map = new HashMap();
            map.put("DocsSubmitted", "Yes");
            map.put("clientDecision", "Accept");
            map.put("VoucherDecision", "No");
            map.put("Transaction", "Other");

            String workflowID = wf.startWorkflow("ClaimsProcessingGroup", map);
            System.out.println("instance: " + workflowID);

            // Get Task List
            List<Task> Tasks = new ArrayList<Task>();
            Tasks = wf.findTasksForWorkflowPath(workflowID);
            int i = 0;
            for (Iterator iter = Tasks.iterator(); iter.hasNext(); ) {
                Task task = Tasks.get(i);
                // LOVCC.TaskID = task.getId();
                System.out.println(task.getId());
                // LOVCC.TaskActivityName = task.getActivityName();
                System.out.println(task.getActivityName());
                System.out.println(task.getAssignee());
                // System.out.println(task.getDuedate());
                // System.out.println((iter.next()));
                iter.next();
                i++;
            }
            ticket.UpdateWorkflowAttributes(params);
            wf.endWorkFlowInstance(pid);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


}
