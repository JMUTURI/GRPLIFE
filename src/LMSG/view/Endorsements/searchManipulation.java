package LMSG.view.Endorsements;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.adf.view.rich.component.rich.input.RichSelectBooleanRadio;

import LMSG.view.Base.GlobalCC;

import LMSG.view.Navigation.Links;

public class searchManipulation {
    private RichSelectBooleanRadio newBusiness;
    private RichSelectBooleanRadio policyEnquiry;
    private RichSelectBooleanRadio editTransaction;
    private RichSelectBooleanRadio endorsements;
    private RichSelectBooleanRadio contraTransaction;
    private RichSelectBooleanRadio reinstatement;
    private RichSelectBooleanRadio lapsation;

    public searchManipulation() {
        super();
    }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    
    public String RedirectPolicyTrans(){
        try{
            Links MyLink = new Links();
            if(newBusiness.isSelected()){
                MyLink.NewBusiness();
            }else if(policyEnquiry.isSelected()){
                MyLink.PolicyEnquiry();
            }else if(editTransaction.isSelected()){
                MyLink.viewPolicies();
            }else if(endorsements.isSelected()){
                MyLink.goToUWTransactions();
            }else if(contraTransaction.isSelected()){
                MyLink.goToContraTrans();
            }else if(reinstatement.isSelected()){
                MyLink.goToReinstatement();
            }else if(lapsation.isSelected()){
                MyLink.goToLapsations();
            }else{
                GlobalCC.INFORMATIONREPORTING("Select A Transaction");
                return null;
            }
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public void setNewBusiness(RichSelectBooleanRadio newBusiness) {
        this.newBusiness = newBusiness;
    }

    public RichSelectBooleanRadio getNewBusiness() {
        return newBusiness;
    }

    public void setPolicyEnquiry(RichSelectBooleanRadio policyEnquiry) {
        this.policyEnquiry = policyEnquiry;
    }

    public RichSelectBooleanRadio getPolicyEnquiry() {
        return policyEnquiry;
    }

    public void setEditTransaction(RichSelectBooleanRadio editTransaction) {
        this.editTransaction = editTransaction;
    }

    public RichSelectBooleanRadio getEditTransaction() {
        return editTransaction;
    }

    public void setEndorsements(RichSelectBooleanRadio endorsements) {
        this.endorsements = endorsements;
    }

    public RichSelectBooleanRadio getEndorsements() {
        return endorsements;
    }

    public void setContraTransaction(RichSelectBooleanRadio contraTransaction) {
        this.contraTransaction = contraTransaction;
    }

    public RichSelectBooleanRadio getContraTransaction() {
        return contraTransaction;
    }

    public void setReinstatement(RichSelectBooleanRadio reinstatement) {
        this.reinstatement = reinstatement;
    }

    public RichSelectBooleanRadio getReinstatement() {
        return reinstatement;
    }

    public void setLapsation(RichSelectBooleanRadio lapsation) {
        this.lapsation = lapsation;
    }

    public RichSelectBooleanRadio getLapsation() {
        return lapsation;
    }
}
