package LMSG.view.Policy;

import LMSG.view.Base.ADFUtils;

import LMSG.view.Base.GlobalCC;

import LMSG.view.connect.DBConnector;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.layout.RichPanelTabbed;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailItem;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Key;
import oracle.jbo.Row;

import org.apache.myfaces.trinidad.event.SelectionEvent;
import org.apache.myfaces.trinidad.model.RowKeySet;

public class MemCoverClaim {
    private RichTable productLOV;
    private RichInputText prodDesc;
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    private RichInputText policyNo;
    private RichTable policyNoLOV;
    private RichTable membersLOV;
    private RichTable coverLOV;
    private RichPanelBox memCoverPanel;
    private RichPanelBox memDisplayPanel;
    private RichPanelBox polDetailsPanel;
    private RichPanelBox policyPanel;
    private RichInputText memberNo;
    private RichTable memLOV;
    private RichInputText memNoTF;
    private RichInputText memSurnameTF;
    private RichInputText memOtherNamesTF;
    private RichInputText memDependentTypesTF;
    private RichInputText memOccupationTF;
    private RichInputText memAnbTF;
    private RichShowDetailItem beneficiaryPanel;
    private RichShowDetailItem memCoverDetailsPanel;
    private RichPanelTabbed tabbedPanel;
    private RichTable studentsLOV;
    private RichTable memberCovers;
    private RichInputText srchMemNo;
    private RichInputText srchMemName;

    public MemCoverClaim() {
    }

    public void setProductLOV(RichTable productLOV) {
        this.productLOV = productLOV;
    }

    public RichTable getProductLOV() {
        return productLOV;
    }

    public void setProdDesc(RichInputText prodDesc) {
        this.prodDesc = prodDesc;
    }

    public RichInputText getProdDesc() {
        return prodDesc;
    }

    public String getSelectedProduct() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findProductsIterator");
        RowKeySet set = productLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
            prodDesc.setValue(r.getAttribute("prodDesc"));
            session.setAttribute("ProductCode", r.getAttribute("prodCode"));
        }
        return null;
    }

    public void setPolicyNo(RichInputText policyNo) {
        this.policyNo = policyNo;
    }

    public RichInputText getPolicyNo() {
        return policyNo;
    }

    public String getSelectedPolicyNo() {
      DCIteratorBinding dciter =
          ADFUtils.findIterator("FindPolicyProposersIterator");
      RowKeySet set = policyNoLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      while (rowKeySetIter.hasNext()) {
          List l = (List)rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
          policyNo.setValue(r.getAttribute("POL_POLICY_NO"));
          session.setAttribute("policyCode",r.getAttribute("POL_CODE"));
      }    
        return null;
    }

    public void setPolicyNoLOV(RichTable policyNoLOV) {
        this.policyNoLOV = policyNoLOV;
    }

    public RichTable getPolicyNoLOV() {
        return policyNoLOV;
    }
  

    public void setMembersLOV(RichTable membersLOV) {
        this.membersLOV = membersLOV;
    }

    public RichTable getMembersLOV() {
        return membersLOV;
    }

    public void getSelectedRow(SelectionEvent selectionEvent) {
      DCIteratorBinding dciter =
          ADFUtils.findIterator("FindPolicyMemIterator");
      RowKeySet set = membersLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      while (rowKeySetIter.hasNext()) {
          List l = (List)rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
          session.setAttribute("PolmCode",r.getAttribute("POLM_CODE"));
        session.setAttribute("MemberCode",r.getAttribute("POLM_MEM_CODE"));
          
      }  
        ADFUtils.findIterator("FindMemberTransactionsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(memberCovers);
        
     // ADFUtils.findIterator("FindMemberCoverDetailsIterator").executeQuery();
     //AdfFacesContext.getCurrentInstance().addPartialTarget(coverLOV);
     
    }

    public void setCoverLOV(RichTable coverLOV) {
        this.coverLOV = coverLOV;
    }

    public RichTable getCoverLOV() {
        return coverLOV;
    }

    public void setMemCoverPanel(RichPanelBox memCoverPanel) {
        this.memCoverPanel = memCoverPanel;
    }

    public RichPanelBox getMemCoverPanel() {
        return memCoverPanel;
    }

    public void setMemDisplayPanel(RichPanelBox memDisplayPanel) {
        this.memDisplayPanel = memDisplayPanel;
    }

    public RichPanelBox getMemDisplayPanel() {
        return memDisplayPanel;
    }

    public void setPolDetailsPanel(RichPanelBox polDetailsPanel) {
        this.polDetailsPanel = polDetailsPanel;
    }

    public RichPanelBox getPolDetailsPanel() {
        return polDetailsPanel;
    }

    public String getNextAction() {
        // Add event code here...
        return null;
    }

    public String goToNextPage() {
              polDetailsPanel.setRendered(true);
              memDisplayPanel.setRendered(true);
              memCoverDetailsPanel.setRendered(true);
               beneficiaryPanel.setRendered(true);
              tabbedPanel.setRendered(true);
              policyPanel.setRendered(false);
      ADFUtils.findIterator("FindPoliciesIterator").executeQuery();         
      ADFUtils.findIterator("FindPolicyMemIterator").executeQuery();
      ADFUtils.findIterator("FindMemberCoverDetailsIterator").executeQuery(); 
        return null;
    }

    public String performClear() {
        prodDesc.setValue(null);
        policyNo.setValue(null);
        return null;
    }

    public void setPolicyPanel(RichPanelBox policyPanel) {
        this.policyPanel = policyPanel;
    }

    public RichPanelBox getPolicyPanel() {
        return policyPanel;
    }

    public String getMemNo() {
        // Add event code here...
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindPolicyMemIterator");
        RowKeySet set = memLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
            memberNo.setValue(r.getAttribute("POLM_MEM_NO"));
            session.setAttribute("PolmCode",r.getAttribute("POLM_CODE"));
            
        }
        return null;
    }

    public void setMemberNo(RichInputText memberNo) {
        this.memberNo = memberNo;
    }

    public RichInputText getMemberNo() {
        return memberNo;
    }

    public void setMemLOV(RichTable memLOV) {
        this.memLOV = memLOV;
    }

    public RichTable getMemLOV() {
        return memLOV;
    }

    public String updateMemberDetails() {
        // Add event code here...
        DCIteratorBinding dciter =
         ADFUtils.findIterator("FindPolicyMemIterator");
        RowKeySet set = membersLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        //System.out.println("here......");        
        while(rowKeySetIter.hasNext()){
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow(); 
            String memName=r.getAttribute("MEMBER_DISPLAY").toString();
            session.setAttribute("PolmCode",r.getAttribute("POLM_CODE"));            
            memNoTF.setValue(r.getAttribute("POLM_MEM_NO"));            
            memSurnameTF.setValue(r.getAttribute("MEM_SURNAME"));
            memOtherNamesTF.setValue(r.getAttribute("MEM_OTHER_NAMES"));
            memDependentTypesTF.setValue(r.getAttribute("POLM_DTY_DESCRIPTION"));
            memOccupationTF.setValue(r.getAttribute("OCCUPATION_DISPLAY"));
            memAnbTF.setValue(r.getAttribute("POLM_ANB"));
   }
    GlobalCC.showPopup("lmsgroup:updateMember");
        
        return null;
    }

    public void setMemNoTF(RichInputText memNoTF) {
        this.memNoTF = memNoTF;
    }

    public RichInputText getMemNoTF() {
        return memNoTF;
    }

    public void setMemSurnameTF(RichInputText memSurnameTF) {
        this.memSurnameTF = memSurnameTF;
    }

    public RichInputText getMemSurnameTF() {
        return memSurnameTF;
    }

    public void setMemOtherNamesTF(RichInputText memOtherNamesTF) {
        this.memOtherNamesTF = memOtherNamesTF;
    }

    public RichInputText getMemOtherNamesTF() {
        return memOtherNamesTF;
    }

    public void setMemDependentTypesTF(RichInputText memDependentTypesTF) {
        this.memDependentTypesTF = memDependentTypesTF;
    }

    public RichInputText getMemDependentTypesTF() {
        return memDependentTypesTF;
    }

    public void setMemOccupationTF(RichInputText memOccupationTF) {
        this.memOccupationTF = memOccupationTF;
    }

    public RichInputText getMemOccupationTF() {
        return memOccupationTF;
    }

    public void setMemAnbTF(RichInputText memAnbTF) {
        this.memAnbTF = memAnbTF;
    }

    public RichInputText getMemAnbTF() {
        return memAnbTF;
    }

    public String saveMemberRec() {
        // Add event code here...
    String query= "BEGIN LMS_WEB_PKG_GRP.update_member_details(?,?,?,?);END;";
     Connection conn = new DBConnector().getDatabaseConn();
     CallableStatement cstmt = null;
     try{
       cstmt=conn.prepareCall(query); 
         cstmt.setBigDecimal(1,(BigDecimal)session.getAttribute("PolmCode"));
         cstmt.setString(2,(String)memNoTF.getValue());
         cstmt.setString(3,(String)memSurnameTF.getValue());
         cstmt.setString(4,(String)memOtherNamesTF.getValue());
         cstmt.execute();
       ADFUtils.findIterator("FindPolicyMemIterator").executeQuery();
       ADFUtils.findIterator("FindMembersBeneficiariesDetailsIterator").executeQuery();
       AdfFacesContext.getCurrentInstance().addPartialTarget(membersLOV);
       AdfFacesContext.getCurrentInstance().addPartialTarget(studentsLOV);
     }catch(Exception ex){
       GlobalCC.EXCEPTIONREPORTING(conn, ex);
     }
         
        return null;
    }

    public void setBeneficiaryPanel(RichShowDetailItem beneficiaryPanel) {
        this.beneficiaryPanel = beneficiaryPanel;
    }

    public RichShowDetailItem getBeneficiaryPanel() {
        return beneficiaryPanel;
    }

    public void setMemCoverDetailsPanel(RichShowDetailItem memCoverDetailsPanel) {
        this.memCoverDetailsPanel = memCoverDetailsPanel;
    }

    public RichShowDetailItem getMemCoverDetailsPanel() {
        return memCoverDetailsPanel;
    }

    public void setTabbedPanel(RichPanelTabbed tabbedPanel) {
        this.tabbedPanel = tabbedPanel;
    }

    public RichPanelTabbed getTabbedPanel() {
        return tabbedPanel;
    }

    public void setStudentsLOV(RichTable studentsLOV) {
        this.studentsLOV = studentsLOV;
    }

    public RichTable getStudentsLOV() {
        return studentsLOV;
    }

    public void setMemberCovers(RichTable memberCovers) {
        this.memberCovers = memberCovers;
    }

    public RichTable getMemberCovers() {
        return memberCovers;
    }
    public void getSelectedMemTrans(SelectionEvent selectionEvent) {
      DCIteratorBinding dciter =
          ADFUtils.findIterator("FindMemberTransactionsIterator");
      RowKeySet set = memberCovers.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      while (rowKeySetIter.hasNext()) {
          List l = (List)rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
        session.setAttribute("endorsementCode",r.getAttribute("endr_code"));
       }  
        
      ADFUtils.findIterator("FindMemberCoverDetailsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(coverLOV);
     
    }
  public String SearchMembers() {
      try {
          if (this.srchMemName.getValue() == null) {
              this.session.setAttribute("srchMemName", null);
          } else {
              this.session.setAttribute("srchMemName",
                                        this.srchMemName.getValue().toString());
          }
          if (this.srchMemNo.getValue() == null) {
              this.session.setAttribute("srchMemNo", null);
          } else {
              this.session.setAttribute("srchMemNo",
                                        this.srchMemNo.getValue().toString());
          }
          ADFUtils.findIterator("FindPolicyMemIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.memLOV);
      } catch (Exception e) {
          GlobalCC.EXCEPTIONREPORTING(null, e);
      }
      return null;
  }
  public String ClearSearchMembers() {
      try {
          this.session.setAttribute("srchMemName", null);
          this.session.setAttribute("srchMemNo", null);
          this.srchMemNo.setValue(null);
          this.srchMemName.setValue(null);
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.srchMemNo);
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.srchMemName);

          ADFUtils.findIterator("FindPolicyMemIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.memLOV);
      } catch (Exception e) {
          GlobalCC.EXCEPTIONREPORTING(null, e);
      }
      return null;
  }

    public void setSrchMemNo(RichInputText srchMemNo) {
        this.srchMemNo = srchMemNo;
    }

    public RichInputText getSrchMemNo() {
        return srchMemNo;
    }

    public void setSrchMemName(RichInputText srchMemName) {
        this.srchMemName = srchMemName;
    }

    public RichInputText getSrchMemName() {
        return srchMemName;
    }
}
