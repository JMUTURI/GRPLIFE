package LMSG.view.BPM;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import org.jbpm.api.model.OpenExecution;
import org.jbpm.api.task.Assignable;
import org.jbpm.api.task.AssignmentHandler;

public class ClaimsAssignTask implements AssignmentHandler {

    String assignee;
    public void assign(Assignable assignable, OpenExecution execution) {
        MyAssignee();
        assignable.setAssignee(assignee);
    }
    public String MyAssignee(){
        HttpSession session =
            (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        String TaskAss = (String)session.getAttribute("TaskAssignee");
        if (TaskAss == null){
            assignee = (String)session.getAttribute("Username");
            session.setAttribute("TaskAssignee", session.getAttribute("Username"));
        }else{
            assignee =(String)session.getAttribute("TaskAssignee");  
            
        }
        System.out.println("assignee: " + assignee);
        return null;
    }
}
   

