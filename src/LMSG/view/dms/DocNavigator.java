package LMSG.view.dms;

import LMSG.view.Base.GlobalCC;
import LMSG.view.Base.LOVCC;

import java.util.HashMap;

import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailItem;
import oracle.adf.view.rich.context.AdfFacesContext;

public class DocNavigator extends LOVCC {
  HttpSession session =
    (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
  private RichShowDetailItem policyDocumentTab;
  private RichShowDetailItem claimsDocTab;
  private RichShowDetailItem quotationDocTab;
  private RichShowDetailItem commissionDocTab;
  private RichShowDetailItem medDocTab;
  private HtmlPanelGrid polDocumentPG;
  private HtmlPanelGrid quotationPG;

  public String showTransDocs() {
    String DialogName = null;
    boolean trans = false;
    if ((this.session.getAttribute("policyCode") != null) ||
        (this.session.getAttribute("QuoteCode") != null) ||
        (this.session.getAttribute("agnCode") != null) ||
        this.session.getAttribute("FacilitatorCode") != null) {
      trans = true;
      session.removeAttribute("dmsPage");
      DialogName = "/dmsDocView.jspx";
    }
    if (!trans) {
      String Message = "Cannot View Documents At this level";
      GlobalCC.INFORMATIONREPORTING(Message);
      return null;
    }
    try {
      FacesContext context = FacesContext.getCurrentInstance();


      ViewHandler viewHandler = context.getApplication().getViewHandler();


      UIViewRoot dialog = viewHandler.createView(context, DialogName);

      HashMap properties = new HashMap();
      properties.put("width", Integer.valueOf(1200));
      properties.put("height", Integer.valueOf(800));

      AdfFacesContext afContext = AdfFacesContext.getCurrentInstance();

      afContext.launchDialog(dialog, null, null, true, properties);
    } catch (Exception e) {
    }
    return null;
  }

  public boolean isUndewritingVisible() {
    boolean visible = false;
    if ((this.session.getAttribute("policyCode") != null) &&
        (this.session.getAttribute("ClaimNo") == null)) {
      visible = true;
    } else {
      visible = false;
    }
    return visible;
  }


  public void setPolicyDocumentTab(RichShowDetailItem policyDocumentTab) {
    this.policyDocumentTab = policyDocumentTab;
  }

  public RichShowDetailItem getPolicyDocumentTab() {
    return policyDocumentTab;
  }

  public void setClaimsDocTab(RichShowDetailItem claimsDocTab) {
    this.claimsDocTab = claimsDocTab;
  }

  public RichShowDetailItem getClaimsDocTab() {
    return claimsDocTab;
  }

  public void setQuotationDocTab(RichShowDetailItem quotationDocTab) {
    this.quotationDocTab = quotationDocTab;
  }

  public RichShowDetailItem getQuotationDocTab() {
    return quotationDocTab;
  }

  public void setCommissionDocTab(RichShowDetailItem commissionDocTab) {
    this.commissionDocTab = commissionDocTab;
  }

  public RichShowDetailItem getCommissionDocTab() {
    return commissionDocTab;
  }

  public void setMedDocTab(RichShowDetailItem medDocTab) {
    this.medDocTab = medDocTab;
  }

  public RichShowDetailItem getMedDocTab() {
    return medDocTab;
  }

  public void setPolDocumentPG(HtmlPanelGrid polDocumentPG) {
    this.polDocumentPG = polDocumentPG;
  }

  public HtmlPanelGrid getPolDocumentPG() {
    return polDocumentPG;
  }

  public void setQuotationPG(HtmlPanelGrid quotationPG) {
    this.quotationPG = quotationPG;
  }

  public HtmlPanelGrid getQuotationPG() {
    return quotationPG;
  }
  public boolean isQuotationVisible()
  {
    if (this.session.getAttribute("QuoteCode")!=null) {
      return true;
    }
    return false;
  }
  public boolean isPolicyVisible()
  {
    if (this.session.getAttribute("policyCode")!=null && !isPensionproduct()) {
      return true;
    }
    return false;
  }
  public boolean isCommissionVisible()
  {
    if (this.session.getAttribute("agnCode")!=null && this.session.getAttribute("QuoteCode")==null&&this.session.getAttribute("policyCode")==null) {
      return true;
    }
    return false;
  }
  public boolean isClaimVisible()
  {
    if (this.session.getAttribute("ClaimNo")!=null) {
      return true;
    }
    return false;
  }
  public boolean isMedicalVisible()
  {
    if (this.session.getAttribute("FacilitatorCode")!=null) {
      return true;
    }
    return false;
  }
    public boolean isPensionproduct()
    {
      String prodTy = (String)this.session.getAttribute("productType");
      if (prodTy == null) {
        return false;
      }
      if (prodTy.equalsIgnoreCase("PENS")) {
        return true;
      }
      return false;
    }
  
}
