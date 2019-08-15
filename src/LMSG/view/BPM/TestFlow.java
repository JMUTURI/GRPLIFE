package LMSG.view.BPM;

import org.jbpm.pvm.internal.cfg.JbpmConfiguration;

public class TestFlow {
    public TestFlow() {
            super();
        }
        public static void main(String[] args) {
            
            JbpmConfiguration pid = null;
            wfEngine wf = new wfEngine();
            //Deploy the Workflow
            wf.deployWorkflow("ClaimsProcessingGroup.jpdl.xml");
            
            pid = wf.startWorkFlowInstance();
            System.out.println("WorflowPath[id=" + pid + "]");
        } 
}
