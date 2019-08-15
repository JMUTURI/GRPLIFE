package LMSG.view.BPM;

import org.jbpm.api.Configuration;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.RepositoryService;

public class Deployment {
    public Deployment() {
        super();
    }
    
  

    public String Deploy() {
        ProcessEngine processEngine =
            new Configuration().setResource("jbpm.cfg.xml").buildProcessEngine();
        RepositoryService repositoryService =
            processEngine.getRepositoryService();
        //repositoryService.createDeployment().addResourceFromClasspath("EndorsementsProcess.jpdl.xml").deploy();
         repositoryService.createDeployment().addResourceFromClasspath("ClaimsProcessing.jpdl.xml").deploy();
        return null;
    }
    public static void main(String args[]){
     Deployment d=new Deployment();
     d.Deploy();
    }
}
