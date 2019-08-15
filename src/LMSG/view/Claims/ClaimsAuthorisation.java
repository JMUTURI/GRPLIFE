package LMSG.view.Claims;

import LMSG.view.Base.ADFUtils;

import LMSG.view.Base.GlobalCC;

import java.math.BigDecimal;

import java.util.Iterator;

import java.util.List;

import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;

import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Key;
import oracle.jbo.Row;

import org.apache.myfaces.trinidad.model.RowKeySet;

public class ClaimsAuthorisation {

    private RichTable productLOV;
    private RichInputText prodDesc;
    private RichSelectBooleanCheckbox clmAuthCheck;
    private RichTable clmAuthLOV;

    public ClaimsAuthorisation() {
    }
  HttpSession session =
      (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    public void setProductLOV(RichTable productLOV) {
        this.productLOV = productLOV;
    }

    public RichTable getProductLOV() {
        return productLOV;
    }

    public String getSelectedProduct() {
      DCIteratorBinding dciter = ADFUtils.findIterator("findProductsIterator");
      RowKeySet set =productLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
        prodDesc.setValue(r.getAttribute("prodDesc"));
        session.setAttribute("productCode", r.getAttribute("prodCode"));          
      }
      ADFUtils.findIterator("FindClaimAuthorisationIterator").executeQuery();    
      
        return null;
    }

    public void setProdDesc(RichInputText prodDesc) {
        this.prodDesc = prodDesc;
    }

    public RichInputText getProdDesc() {
        return prodDesc;
    }

    public void getRowChecked(ValueChangeEvent valueChangeEvent) {          
      if(valueChangeEvent.getOldValue()!=valueChangeEvent.getNewValue()){         
        
        DCIteratorBinding dciter = ADFUtils.findIterator("FindClaimAuthorisationIterator");
        RowKeySet rowKeySet=clmAuthLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = rowKeySet.iterator();       
       while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();         
          if(clmAuthCheck.isSelected()){  
            clmAuthCheck.setDisabled(true);
            session.setAttribute("policyCode",r.getAttribute("LTR_POL_CODE"));          
            session.setAttribute("ClaimNo",r.getAttribute("LTR_CLM_NO")); 
            session.setAttribute("MemberNumber",r.getAttribute("LTR_MEM_CODE")); 
          GlobalCC.RedirectPage("/g_clmpym.jspx");
          } 
        } 
       
      }
    }

    public void setClmAuthCheck(RichSelectBooleanCheckbox clmAuthCheck) {
        this.clmAuthCheck = clmAuthCheck;
    }

    public RichSelectBooleanCheckbox getClmAuthCheck() {
        return clmAuthCheck;
    }

    public void setClmAuthLOV(RichTable clmAuthLOV) {
        this.clmAuthLOV = clmAuthLOV;
    }

    public RichTable getClmAuthLOV() {
        return clmAuthLOV;
    }
}
