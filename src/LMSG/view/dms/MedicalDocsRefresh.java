package LMSG.view.dms;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.adf.controller.v2.lifecycle.PagePhaseEvent;
import oracle.adf.controller.v2.lifecycle.PagePhaseListener;
import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.jbo.ViewObject;

public class MedicalDocsRefresh implements PagePhaseListener {
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);

    public void afterPhase(PagePhaseEvent pagePhaseEvent) {
        if (pagePhaseEvent.getPhaseId() == 1) {
            if (session.getAttribute("dmsPage") == null) {
                DCBindingContainer bindings =
                    (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding medicalDocIterator =
                    bindings.findIteratorBinding("medicalDocsIterator");
                ViewObject viewObject = medicalDocIterator.getViewObject();
                viewObject.clearCache();
                viewObject.executeQuery();

                session.setAttribute("dmsPage", "N");
            }
        }
    }

    public void beforePhase(PagePhaseEvent pagePhaseEvent) {


    }
}
