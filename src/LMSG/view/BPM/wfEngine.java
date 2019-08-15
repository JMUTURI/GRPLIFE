package LMSG.view.BPM;

import LMSG.view.Base.GlobalCC;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.jbpm.api.Configuration;
import org.jbpm.api.ExecutionService;
import org.jbpm.api.IdentityService;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.RepositoryService;
import org.jbpm.api.TaskQuery;
import org.jbpm.api.TaskService;
import org.jbpm.api.task.Task;
import org.jbpm.pvm.internal.cfg.JbpmConfiguration;

public class wfEngine {
    public wfEngine() {
        super();
    }
    private static ExecutionService executionService;
    private static TaskService taskService;
    private static IdentityService identityService;
    
    /**
     *
     *
     * @return PID of the workflow Instance.
     */
    public JbpmConfiguration startWorkFlowInstance() {
        /*ProcessEngine processEngine =
            new Configuration().setResource("jbpm.cfg.xml").buildProcessEngine();
        executionService = processEngine.getExecutionService();
        taskService = processEngine.getTaskService();
        identityService = processEngine.getIdentityService();*/
        
         JbpmConfiguration jbpmConfig = new JbpmConfiguration();
          ProcessEngine processEngine = jbpmConfig.buildProcessEngine();        
            executionService = processEngine.getExecutionService();
            taskService = processEngine.getTaskService();
            identityService = processEngine.getIdentityService();
            return jbpmConfig; 
    }
    
    /**
     * endWorkFlowInstance
     */
    public String endWorkFlowInstance(JbpmConfiguration jbpmConfig) {
       jbpmConfig.close();
         return null;
     } 
    /**
     *
     *
     * @return PID of the workflow.
     */
    public String startWorkflow(String workflowDefinitionId,
                                Map<String, Serializable> parameters) {
        String pid = null;
        try {
            ProcessInstance processInstance =
                executionService.startProcessInstanceByKey(workflowDefinitionId,
                                                           parameters);
            pid = processInstance.getId();

        } catch (Exception e) {
          GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return pid;
    }
    
    /**
     *
     *
     * @return Get the Task Lists.
     */
    
    public List<Task> getTaskList(String userName) {
        List<Task> Tasks = new ArrayList<Task>();
        Tasks = taskService.findPersonalTasks(userName);
        return Tasks;
    }
    
    /**
     *
     *
     * @return Complete A Task.
     */
    
    public void CompleteTask(String taskID) {
        taskService.completeTask(taskID);
    }
    /**
     *
     *
     * @return Find Grouped Tasks.
     */
    public List<Task> findGroupTasks(String groupName) {
        return taskService.findGroupTasks(groupName);
    }
    
    /**
     *
     *
     * @ Take Task.
     */

    public void takeTask(String taskID, String userName) {
        taskService.takeTask(taskID, userName);
    }
    
    /**
     *
     *
     * Update Task Variables.
     */

    public void updateTaskVariables(String taskID,
                                    java.util.Map<java.lang.String, java.lang.Object> variables) {
        taskService.setVariables(taskID, variables);
    }
    
    /**
         * Gets all Tasks associated with the specified path
         *
         * @param pathId the path id
         * @return the list of associated tasks
         */
    public List<Task> findTasksForWorkflowPath(String pathId){
        List<Task> tasks = new ArrayList<Task>();
        TaskQuery taskQuery = taskService.createTaskQuery().processInstanceId(pathId);
        if(taskQuery==null){
            
        }else{
            tasks = taskQuery.list();
        }
        return tasks;
        
    }
    /**
     * Deploy Workflow
     * @param fileName
     */
     public void deployWorkflow(String fileName) {
         /* Deploy JPDL File */
         ProcessEngine processEngine =
             new Configuration().setResource("jbpm.cfg.xml").buildProcessEngine();
         RepositoryService repositoryService =
             processEngine.getRepositoryService();
         repositoryService.createDeployment().addResourceFromClasspath(fileName).deploy();
     }
    public void AssignTask(String taskId, String userId){
       taskService.assignTask(taskId, userId);
    }

    public void setExecutionService(ExecutionService executionService) {
        wfEngine.executionService = executionService;
    }

    public ExecutionService getExecutionService() {
        return executionService;
    }

    public void setTaskService(TaskService taskService) {
        wfEngine.taskService = taskService;
    }

    public TaskService getTaskService() {
        return taskService;
    }

    public void setIdentityService(IdentityService identityService) {
        wfEngine.identityService = identityService;
    }

    public IdentityService getIdentityService() {
        return identityService;
    }
}
