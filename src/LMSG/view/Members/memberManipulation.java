package LMSG.view.Members;

import java.io.IOException;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputNumberSpinbox;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailItem;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.output.RichOutputLabel;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Key;
import oracle.jbo.Row;

import oracle.jdbc.OracleTypes;

import org.apache.myfaces.trinidad.event.AttributeChangeEvent;
import org.apache.myfaces.trinidad.event.SelectionEvent;
import org.apache.myfaces.trinidad.model.RowKeySet;

import LMSG.view.Base.ADFUtils;

import LMSG.view.Base.GlobalCC;
import LMSG.view.Base.LOVCC;

import LMSG.view.Base.SettingsDAO;

import LMSG.view.Policy.PolicyValues;

import LMSG.view.QuotationProcessing.QuotDAO;
import LMSG.view.QuotationProcessing.QuotManipulation;

import LMSG.view.connect.DBConnector;

import LMSG.view.connect.DBConnector;

public class memberManipulation extends LOVCC {
    private RichInputText depTypeDesc;
    private RichTable depTypeLOV;
    private RichTable categoryLOV;
    private RichInputText categoryDesc;
    private RichInputText occupationDesc;
    private RichTable occupationLOV;
    private RichInputText memANB;
    private RichInputText memNo;
    private RichInputText memSurname;
    private RichInputText memOtherNames;
    private RichInputDate loanDate;
    private RichInputNumberSpinbox origloanAmt;
    private RichInputText loanInt;
    private RichOutputLabel origRpyPrd;
    private RichInputNumberSpinbox savingAmt;
    private RichInputText emprBF;
    private RichInputText empeBF;
    private RichSelectOneChoice contrType;
    private RichInputText empeContr;
    private RichInputText emprContr;
    private RichInputNumberSpinbox memEarnings;
    private RichInputText memEarnprds;
    private RichSelectBooleanCheckbox grpLifeRider;
    private RichInputDate joinDate;
    private RichInputText idNo;
    private RichInputDate dob;
    private RichSelectOneChoice memSex;
    private RichInputText weight;
    private RichInputText height;
    private RichInputText sysPres;
    private RichInputText diaPres;
    private RichCommandButton addMember;
    private RichTable depTypeLOV2;
    private RichInputText origRepayPeriod;
    private RichInputText djMemNo;
    private RichInputText djSurname;
    private RichInputText djOtherNames;
    private RichSelectOneChoice djSex;
    private RichInputText djIDNo;
    private RichInputDate djDOB;

    public static int DependantOrJoint = 0;
    private RichInputText jmemNo;
    private RichInputText jsurname;
    private RichInputText jotherNames;
    private RichSelectOneChoice jsex;
    private RichInputText jiDNo;
    private RichInputDate jdOB;
    private RichTable memDependantsLOV;
    private RichTable jointMemLOV;
    private RichShowDetailItem policyDetailsTab;
    private RichCommandButton anotherMem;
    private RichInputText jntPinNO;
    private RichInputText jntAddress;


    public memberManipulation() {
    }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);

    public String findDepTypeSelected() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindDependantTypesIterator");
        RowKeySet set = depTypeLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            depTypeDesc.setValue(r.getAttribute("DTY_DESCRIPTION"));
            //LOVCC.DepTypeDesc = (String)r.getAttribute("DTY_SHT_DESC");
            //LOVCC.DepTypeCode =(BigDecimal)r.getAttribute("DTY_CODE");
            session.setAttribute("DepTypeDesc",
                                 r.getAttribute("DTY_SHT_DESC"));
            session.setAttribute("DepTypeCode", r.getAttribute("DTY_CODE"));


        }

        return null;
    }

    public String findCategorySelected() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindPolicyCategoriesIterator");
        RowKeySet set = categoryLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            categoryDesc.setValue(r.getAttribute("PCA_SHT_DESC"));
            //LOVCC.PolicyCategory=(BigDecimal)r.getAttribute("PCA_CODE");
            session.setAttribute("PolicyCategory", r.getAttribute("PCA_CODE"));
            memEarnprds.setValue(r.getAttribute("PCA_PERIOD"));
        }

        return null;
    }

    public String findQuoteCategorySelected() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findCategoryIterator");
        RowKeySet set = categoryLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            categoryDesc.setValue(r.getAttribute("catDesc"));
            //LOVCC.PolicyCategory=(BigDecimal)r.getAttribute("lcaCode");
            session.setAttribute("PolicyCategory", r.getAttribute("lcaCode"));
            memEarnprds.setValue(r.getAttribute("catPeriod"));
        }

        return null;
    }

    public String findOccupationSelected() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindOccupationsIterator");
        RowKeySet set = occupationLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            occupationDesc.setValue(r.getAttribute("GCO_DESC"));
            //LOVCC.OccupationCode=(BigDecimal)r.getAttribute("gco_code");
            session.setAttribute("OccupationCode", r.getAttribute("gco_code"));

        }

        return null;
    }

    public String SaveMember() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;


        try {
            String polQuery =
                "begin LMS_WEB_PKG_GRP.add_member(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?" +
                ",?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?" +
                ",?,?,?,?,?,?);end;";
            cst = conn.prepareCall(polQuery);

            cst.registerOutParameter(1, OracleTypes.INTEGER);
            cst.setString(2, "P");
            cst.setBigDecimal(3,
                              (BigDecimal)session.getAttribute("endorsementCode"));
            cst.setBigDecimal(4,
                              (BigDecimal)session.getAttribute("policyCode"));
            //cst.setInt(5, Quotation.prodCode);
            if (memANB.getValue() == null) {
                cst.setBigDecimal(6, null);
            } else {
                cst.setString(6, memANB.getValue().toString());
            }
            if (memNo.getValue() == null) {
                cst.setString(7, null);
            } else {
                cst.setString(7, memNo.getValue().toString());
            }
            if (memSurname.getValue() == null) {
                cst.setString(8, null);
            } else {
                cst.setString(8, memSurname.getValue().toString());
            }
            if (loanDate.getValue() == null) {
                cst.setString(9, null);
            } else {
                cst.setString(9,
                              GlobalCC.parseDate(loanDate.getValue().toString()));
            }
            if (origloanAmt.getValue() == null) {
                cst.setBigDecimal(10, null);
            } else {
                cst.setString(10, origloanAmt.getValue().toString());
            }
            if (loanInt.getValue() == null) {
                cst.setBigDecimal(11, null);
            } else {
                cst.setString(11, loanInt.getValue().toString());
            }
            if (origRepayPeriod.getValue() == null) {
                cst.setBigDecimal(12, null);
            } else {
                cst.setString(12, origRepayPeriod.getValue().toString());
            }
            cst.setString(13, null);
            cst.setDate(14, null); //confirm value?
            if (savingAmt.getValue() == null) {
                cst.setBigDecimal(15, null);
            } else {
                cst.setString(15, savingAmt.getValue().toString());
            }
            if (emprBF.getValue() == null) {
                cst.setBigDecimal(16, null);
            } else {
                cst.setString(16, emprBF.getValue().toString());
            }
            if (empeBF.getValue() == null) {
                cst.setBigDecimal(17, null);
            } else {
                cst.setString(17, empeBF.getValue().toString());
            }
            if (contrType.getValue() == null) {
                cst.setString(18, null);
            } else {
                cst.setString(18, contrType.getValue().toString());
            }
            if (contrType.getValue() == null) {
                cst.setString(19, null);
            } else {
                cst.setString(19, contrType.getValue().toString());
            }
            if (empeContr.getValue() == null) {
                cst.setString(20, null);
            } else {
                cst.setString(20, empeContr.getValue().toString());
            }
            if (emprContr.getValue() == null) {
                cst.setString(21, null);
            } else {
                cst.setString(21, emprContr.getValue().toString());
            }
            if (memEarnings.getValue() == null) {
                cst.setString(22, null);
            } else {
                cst.setString(22, memEarnings.getValue().toString());
            }
            if (memEarnprds.getValue() == null) {
                cst.setString(23, null);
            } else {
                cst.setString(23, memEarnprds.getValue().toString());
            }
            if (grpLifeRider.isSelected()) {
                cst.setString(24, "Y");
            } else {
                cst.setString(24, "N");
            }
            cst.setBigDecimal(25,
                              (BigDecimal)session.getAttribute("prpCode")); //scheme ID?
            cst.setBigDecimal(26,
                              (BigDecimal)session.getAttribute("DepTypeCode"));
            cst.setString(27, (String)session.getAttribute("DepTypeDesc"));
            if (memOtherNames.getValue() == null) {
                cst.setString(28, null);
            } else {
                cst.setString(28, memOtherNames.getValue().toString());
            }
            cst.setString(29, null); //address
            cst.setString(30, null); //telephone
            if (joinDate.getValue() == null) {
                cst.setString(31, null);
            } else {
                cst.setString(31,
                              GlobalCC.parseDate(joinDate.getValue().toString()));
            }

            if (idNo.getValue() == null) {
                cst.setString(32, null);
            } else {
                cst.setString(32, idNo.getValue().toString());
            }
            if (dob.getValue() == null) {
                cst.setString(33, null);
            } else {
                cst.setString(33,
                              GlobalCC.parseDate(dob.getValue().toString()));
            }
            cst.setDate(34, null); //employment Date?
            if (memSex.getValue() == null) {
                cst.setString(35, null);
            } else {
                cst.setString(35, memSex.getValue().toString());
            }
            cst.setBigDecimal(36, null); //pdl Code?
            cst.setBigDecimal(37, null); //lc Code?
            if (weight.getValue() == null) {
                cst.setString(38, null);
            } else {
                cst.setString(38, weight.getValue().toString());
            }
            if (height.getValue() == null) {
                cst.setString(39, null);
            } else {
                cst.setString(39, height.getValue().toString());
            }
            cst.setBigDecimal(40,
                              (BigDecimal)session.getAttribute("OccupationCode"));
            if (sysPres.getValue() == null) {
                cst.setString(41, null);
            } else {
                cst.setString(41, sysPres.getValue().toString());
            }
            if (diaPres.getValue() == null) {
                cst.setString(42, null);
            } else {
                cst.setString(42, diaPres.getValue().toString());
            }
            cst.setBigDecimal(43, null); //cmi code?
            cst.setString(44, null); //diability death rate?
            cst.setBigDecimal(45, null); //age at diability death?
            cst.setBigDecimal(46,
                              (BigDecimal)session.getAttribute("PolicyCategory"));

            cst.execute();
            //BigDecimal No = new BigDecimal(cst.getInt(1));
            //LOVCC.MemberNumber = No;
            session.setAttribute("MemberNumber", cst.getBigDecimal(1));
            cst.close();
            conn.close();


            String Message = "Member Added";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));


            addMember.setDisabled(true);
            ADFUtils.findIterator("FindMemberDependantsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(memDependantsLOV);

            ADFUtils.findIterator("FindJointMembersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(jointMemLOV);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public String deleteJointMember() {

        Connection conn = null;
        try {
            DBConnector myConn = new DBConnector();
            conn = myConn.getDatabaseConn();
            CallableStatement cst = null;
            BigDecimal Code = null;


            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindQuoteJointMembersIterator");
            RowKeySet set = jointMemLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                Code = (BigDecimal)r.getAttribute("j_POLM_CODE");

                System.out.println("Polm Code= " + Code);
                String polQuery =
                    "begin LMS_WEB_PKG_GRP.deletepoljointmember(?);end;";
                cst = conn.prepareCall(polQuery);
                cst.setBigDecimal(1, Code);
                cst.execute();
                cst.close();
                conn.close();

                ADFUtils.findIterator("FindQuoteJointMembersIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(jointMemLOV);

                String Message = "Joint Member Deleted.";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


            }


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }


        return null;
    }

    public String RefreshComponents() {

        memNo.setValue(null);
        memSurname.setValue(null);
        loanDate.setValue(null);
        origloanAmt.setValue(null);
        loanInt.setValue(null);
        origRepayPeriod.setValue(null);
        savingAmt.setValue(null);
        emprBF.setValue(null);
        empeBF.setValue(null);
        contrType.setValue(null);
        empeContr.setValue(null);
        emprContr.setValue(null);
        //memEarnings.setValue(null);
        memEarnprds.setValue(null);
        occupationDesc.setValue(null);

        memOtherNames.setValue(null);
        joinDate.setValue(null);
        idNo.setValue(null);
        //dob.setValue(null);
        memSex.setValue(null);
        weight.setValue(null);
        height.setValue(null);
        sysPres.setValue(null);
        diaPres.setValue(null);
        categoryDesc.setValue(null);

        AdfFacesContext.getCurrentInstance().addPartialTarget(memNo);
        AdfFacesContext.getCurrentInstance().addPartialTarget(memSurname);
        AdfFacesContext.getCurrentInstance().addPartialTarget(loanDate);
        AdfFacesContext.getCurrentInstance().addPartialTarget(origloanAmt);
        AdfFacesContext.getCurrentInstance().addPartialTarget(loanInt);
        AdfFacesContext.getCurrentInstance().addPartialTarget(origRepayPeriod);
        AdfFacesContext.getCurrentInstance().addPartialTarget(savingAmt);
        AdfFacesContext.getCurrentInstance().addPartialTarget(emprBF);
        AdfFacesContext.getCurrentInstance().addPartialTarget(empeBF);
        AdfFacesContext.getCurrentInstance().addPartialTarget(contrType);
        AdfFacesContext.getCurrentInstance().addPartialTarget(empeContr);
        AdfFacesContext.getCurrentInstance().addPartialTarget(emprContr);
        AdfFacesContext.getCurrentInstance().addPartialTarget(occupationDesc);
        AdfFacesContext.getCurrentInstance().addPartialTarget(memEarnprds);
        AdfFacesContext.getCurrentInstance().addPartialTarget(memOtherNames);
        AdfFacesContext.getCurrentInstance().addPartialTarget(joinDate);
        AdfFacesContext.getCurrentInstance().addPartialTarget(idNo);
        AdfFacesContext.getCurrentInstance().addPartialTarget(memSex);
        AdfFacesContext.getCurrentInstance().addPartialTarget(weight);
        AdfFacesContext.getCurrentInstance().addPartialTarget(height);
        AdfFacesContext.getCurrentInstance().addPartialTarget(sysPres);
        AdfFacesContext.getCurrentInstance().addPartialTarget(diaPres);
        AdfFacesContext.getCurrentInstance().addPartialTarget(categoryDesc);

        return null;
    }

    public String SavePolicyMember() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;


        try {
            String polQuery =
                "begin LMS_WEB_PKG_GRP.add_member(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?" +
                ",?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?" +
                ",?,?,?,?,?,?);end;";
            cst = conn.prepareCall(polQuery);

            cst.registerOutParameter(1, OracleTypes.INTEGER);
            cst.setString(2, "P");
            cst.setBigDecimal(3,
                              (BigDecimal)session.getAttribute("endorsementCode"));
            cst.setBigDecimal(4,
                              (BigDecimal)session.getAttribute("policyCode"));
            cst.setBigDecimal(5,
                              (BigDecimal)session.getAttribute("ProductCode"));
            if (memANB.getValue() == null) {
                cst.setBigDecimal(6, null);
            } else {
                cst.setString(6, memANB.getValue().toString());
            }
            if (memNo.getValue() == null) {
                cst.setString(7, null);
            } else {
                cst.setString(7, memNo.getValue().toString());
            }
            if (memSurname.getValue() == null) {
                cst.setString(8, null);
            } else {
                cst.setString(8, memSurname.getValue().toString());
            }
            if (loanDate.getValue() == null) {
                cst.setString(9, null);
            } else {
                cst.setString(9,
                              GlobalCC.parseDate(loanDate.getValue().toString()));
            }
            if (origloanAmt.getValue() == null) {
                cst.setBigDecimal(10, null);
            } else {
                cst.setString(10, origloanAmt.getValue().toString());
            }
            if (loanInt.getValue() == null) {
                cst.setBigDecimal(11, null);
            } else {
                cst.setString(11, loanInt.getValue().toString());
            }
            if (origRepayPeriod.getValue() == null) {
                cst.setBigDecimal(12, null);
            } else {
                cst.setString(12, origRepayPeriod.getValue().toString());
            }
            cst.setString(13, null);
            cst.setDate(14, null); //confirm value?
            if (savingAmt.getValue() == null) {
                cst.setBigDecimal(15, null);
            } else {
                cst.setString(15, savingAmt.getValue().toString());
            }
            if (emprBF.getValue() == null) {
                cst.setBigDecimal(16, null);
            } else {
                cst.setString(16, emprBF.getValue().toString());
            }
            if (empeBF.getValue() == null) {
                cst.setBigDecimal(17, null);
            } else {
                cst.setString(17, empeBF.getValue().toString());
            }
            if (contrType.getValue() == null) {
                cst.setString(18, null);
            } else {
                cst.setString(18, contrType.getValue().toString());
            }
            if (contrType.getValue() == null) {
                cst.setString(19, null);
            } else {
                cst.setString(19, contrType.getValue().toString());
            }
            if (empeContr.getValue() == null) {
                cst.setString(20, null);
            } else {
                cst.setString(20, empeContr.getValue().toString());
            }
            if (emprContr.getValue() == null) {
                cst.setString(21, null);
            } else {
                cst.setString(21, emprContr.getValue().toString());
            }
            if (memEarnings.getValue() == null) {
                cst.setString(22, null);
            } else {
                cst.setString(22, memEarnings.getValue().toString());
            }
            if (memEarnprds.getValue() == null) {
                cst.setString(23, null);
            } else {
                cst.setString(23, memEarnprds.getValue().toString());
            }
            if (grpLifeRider.isSelected()) {
                cst.setString(24, "Y");
            } else {
                cst.setString(24, "N");
            }
            cst.setBigDecimal(25,
                              (BigDecimal)session.getAttribute("prpCode")); //scheme ID?
            cst.setBigDecimal(26,
                              (BigDecimal)session.getAttribute("DepTypeCode"));
            cst.setString(27, (String)session.getAttribute("DepTypeDesc"));
            if (memOtherNames.getValue() == null) {
                cst.setString(28, null);
            } else {
                cst.setString(28, memOtherNames.getValue().toString());
            }
            cst.setString(29, null); //address
            cst.setString(30, null); //telephone
            if (joinDate.getValue() == null) {
                cst.setString(31, null);
            } else {
                cst.setString(31,
                              GlobalCC.parseDate(joinDate.getValue().toString()));
            }

            if (idNo.getValue() == null) {
                cst.setString(32, null);
            } else {
                cst.setString(32, idNo.getValue().toString());
            }
            if (dob.getValue() == null) {
                cst.setString(33, null);
            } else {
                cst.setString(33,
                              GlobalCC.parseDate(dob.getValue().toString()));
            }
            cst.setDate(34, null); //employment Date?
            if (memSex.getValue() == null) {
                cst.setString(35, null);
            } else {
                cst.setString(35, memSex.getValue().toString());
            }
            cst.setBigDecimal(36, null); //pdl Code?
            cst.setBigDecimal(37, null); //lc Code?
            if (weight.getValue() == null) {
                cst.setString(38, null);
            } else {
                cst.setString(38, weight.getValue().toString());
            }
            if (height.getValue() == null) {
                cst.setString(39, null);
            } else {
                cst.setString(39, height.getValue().toString());
            }
            cst.setBigDecimal(40,
                              (BigDecimal)session.getAttribute("OccupationCode"));
            if (sysPres.getValue() == null) {
                cst.setString(41, null);
            } else {
                cst.setString(41, sysPres.getValue().toString());
            }
            if (diaPres.getValue() == null) {
                cst.setString(42, null);
            } else {
                cst.setString(42, diaPres.getValue().toString());
            }
            cst.setBigDecimal(43, null); //cmi code?
            cst.setString(44, null); //diability death rate?
            cst.setBigDecimal(45, null); //age at diability death?
            cst.setBigDecimal(46, (BigDecimal)session.getAttribute("pcaCode"));

            cst.execute();
            cst.close();
            conn.close();


            GlobalCC.INFORMATIONREPORTING("Member Added");

            ADFUtils.findIterator("FindMemberDependantsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(memDependantsLOV);

            //ADFUtils.findIterator("FindJointMembersIterator").executeQuery();
            //AdfFacesContext.getCurrentInstance().addPartialTarget(jointMemLOV);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public String SaveJointMember() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;

        BigDecimal Memb = (BigDecimal)session.getAttribute("MemberNumber");
        if (Memb == null) {
            String Message = "Save Main Member First";
            GlobalCC.INFORMATIONREPORTING(Message);
            return null;
        }

        try {
            String polQuery =
                "begin LMS_WEB_PKG_GRP.createpoljointmember(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?" +
                ",?,?,?,?,?,?);end;";
            cst = conn.prepareCall(polQuery);

            if (jsurname.getValue() == null) {
                cst.setBigDecimal(1, null);
            } else {
                cst.setString(1, jsurname.getValue().toString());
            }
            if (jotherNames.getValue() == null) {
                cst.setBigDecimal(2, null);
            } else {
                cst.setString(2, jotherNames.getValue().toString());
            }
            if (jiDNo.getValue() == null) {
                cst.setBigDecimal(3, null);
            } else {
                cst.setString(3, jiDNo.getValue().toString());
            }
            if (jdOB.getValue() == null) {
                cst.setString(4, null);
            } else {
                cst.setString(4,
                              GlobalCC.parseDate(jdOB.getValue().toString()));
            }

            if (jmemNo.getValue() == null) {
                cst.setBigDecimal(5, null);
            } else {
                cst.setString(5, jmemNo.getValue().toString());
            }
            if (jsex.getValue() == null) {
                cst.setBigDecimal(6, null);
            } else {
                cst.setString(6, jsex.getValue().toString());
            }
            cst.setString(7, null);
            cst.setString(8, null);
            cst.setString(9, null);
            cst.setString(10, null);
            cst.setString(11, null);
            cst.setString(12, null);
            cst.setString(13, null);
            cst.setString(14, null);
            cst.setString(15, null);
            cst.setString(16, null);
            cst.setString(17, null);
            cst.setString(18, null);
            cst.setBigDecimal(19,
                              (BigDecimal)session.getAttribute("MemberNumber"));
            cst.setBigDecimal(20,
                              (BigDecimal)session.getAttribute("PolicyCategory"));
            cst.setBigDecimal(21, (BigDecimal)session.getAttribute("prpCode"));
            cst.setBigDecimal(22,
                              (BigDecimal)session.getAttribute("endorsementCode"));
            cst.setBigDecimal(23,
                              (BigDecimal)session.getAttribute("OccupationCode"));
            cst.setString(24, "N");
            if(jntAddress.getValue()==null){
            cst.setString(25, null);
            }else{
              cst.setString(25,jntAddress.getValue().toString());
            }
            if(jntPinNO.getValue()==null){
              cst.setString(26, null);
            }else{
              cst.setString(26, jntPinNO.getValue().toString());
            }
            cst.execute();
            cst.close();
            conn.close();

            //System.out.println("JOINT MEMBER ADDED. ABOUT TO CALL FINDJOINTMEMBER ITERATOR.");
            ADFUtils.findIterator("FindJointMembersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(jointMemLOV);

            //System.out.println("Joint Member Iterator Called.");
            String Message = "Joint Member Added";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));

            jsurname.setValue(null);
            jotherNames.setValue(null);
            jsex.setValue(null);
            jiDNo.setValue(null);
            jdOB.setValue(null);

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
            e.printStackTrace();
        }
        return null;
    }

    public String deleteJointMemberSelected() {

        Connection conn = null;
        try {
            DBConnector myConn = new DBConnector();
            conn = myConn.getDatabaseConn();
            CallableStatement cst = null;
            BigDecimal Code = null;

            //System.out.println("\"About to call the Iterator. First Time\"");

            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindJointMembersIterator");
            RowKeySet set = jointMemLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

           // System.out.println("Point Two.");

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                Code = (BigDecimal)r.getAttribute("j_POLM_CODE");

               // System.out.println("About to call the Procedure.");

                //System.out.println("Polm Code= "+Code);
                String polQuery =
                    "begin LMS_WEB_PKG_GRP.deletepoljointmember(?);end;";
                cst = conn.prepareCall(polQuery);
                cst.setBigDecimal(1, Code);
                cst.execute();
                cst.close();
                conn.close();

                System.out.println("About to call the Iterator.");

                ADFUtils.findIterator("FindJointMembersIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(jointMemLOV);

                String Message = "Joint Member Deleted.";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


            }

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return null;
    }


    public String saveDependants() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;

        BigDecimal Memb = (BigDecimal)session.getAttribute("MemberNumber");
        if (Memb == null) {

            System.out.println("1");
            String Message = "Save Main Member First";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));

            return null;
        }

        try {
            String polQuery =
                "begin LMS_WEB_PKG_GRP.createDependents(?,?,?,?,?,?,?,?,?,?,?,?,?,?);end;";
            cst = conn.prepareCall(polQuery);

            if (djMemNo.getValue() == null) {
                cst.setBigDecimal(1, null);
            } else {
                cst.setString(1, djMemNo.getValue().toString());
            }
            if (djSurname.getValue() == null) {
                cst.setBigDecimal(2, null);
            } else {
                cst.setString(2, djSurname.getValue().toString());
            }
            if (djOtherNames.getValue() == null) {
                cst.setBigDecimal(3, null);
            } else {
                cst.setString(3, djOtherNames.getValue().toString());
            }
            cst.setBigDecimal(4,
                              (BigDecimal)session.getAttribute("DepTypeCode"));
            if (djSex.getValue() == null) {
                cst.setBigDecimal(5, null);
            } else {
                cst.setString(5, djSex.getValue().toString());
            }

            if (djDOB.getValue() == null) {
                cst.setString(6, null);
            } else {
                cst.setString(6,
                              GlobalCC.parseDate(djDOB.getValue().toString()));
            }
            cst.setString(7, (String)session.getAttribute("DepTypeDesc"));
            if (djIDNo.getValue() == null) {
                cst.setBigDecimal(8, null);
            } else {
                cst.setString(8, djIDNo.getValue().toString());
            }
            cst.setString(9, (String)session.getAttribute("CurrentStatus"));
            cst.setBigDecimal(10,
                              (BigDecimal)session.getAttribute("MemberNumber"));
            cst.setBigDecimal(11, (BigDecimal)session.getAttribute("prpCode"));
            cst.setBigDecimal(12,
                              (BigDecimal)session.getAttribute("PolicyCategory"));
            cst.setBigDecimal(13,
                              (BigDecimal)session.getAttribute("ProductCode"));
            String Cursta = (String)session.getAttribute("CurrentStatus");
            if (Cursta == "Q") {
                cst.setBigDecimal(14,
                                  (BigDecimal)session.getAttribute("QuoteCode")); //Quotation Code
            } else {
                cst.setBigDecimal(14,
                                  (BigDecimal)session.getAttribute("endorsementCode")); //Endorsement Code
            }
            cst.execute();
            cst.close();
            conn.close();

            ADFUtils.findIterator("FindMemberDependantsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(memDependantsLOV);


            String Message = "Dependant Added";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public String saveJointMemberDependants() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;

        BigDecimal Memb = (BigDecimal)session.getAttribute("MemberNumber");
        if (Memb == null) {

            System.out.println("1");
            String Message = "Save Main Member First";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));

            return null;
        }

        //System.out.println("2");
        /*try {
            //String dtyCode = 1003;
            String dtyDesc = "JOINT";
            String polQuery =
                "begin LMS_WEB_PKG_GRP.createDependents(?,?,?,?,?,?,?,?,?,?,?,?,?,?);end;";
            cst = conn.prepareCall(polQuery);

            //System.out.println("3");
            if (djMemNo.getValue() == null) {
                cst.setBigDecimal(1, null);
            } else {
                cst.setString(1, djMemNo.getValue().toString());
            }
            //System.out.println("4");
            if (djSurname.getValue() == null) {
                cst.setBigDecimal(2, null);
            } else {
                cst.setString(2, djSurname.getValue().toString());
            }
            //System.out.println("5");
            if (djOtherNames.getValue() == null) {
                cst.setBigDecimal(3, null);
            } else {
                cst.setString(3, djOtherNames.getValue().toString());
            }
            cst.setBigDecimal(4, null);
            //System.out.println("6");
            if (djSex.getValue() == null) {
                cst.setBigDecimal(5, null);
            } else {
                cst.setString(5, djSex.getValue().toString());
            }
            //System.out.println("7");
            if (djDOB.getValue() == null) {
                cst.setString(6, null);
            } else {
                cst.setString(6,
                              GlobalCC.parseDate(djDOB.getValue().toString()));
            }
            //System.out.println("8");
            cst.setString(7, dtyDesc);
            if (djIDNo.getValue() == null) {
                cst.setBigDecimal(8, null);
            } else {
                cst.setString(8, djIDNo.getValue().toString());
            }
            //System.out.println("9");
            cst.setString(9, (String)session.getAttribute("CurrentStatus"));
            cst.setBigDecimal(10,
                              (BigDecimal)session.getAttribute("MemberNumber"));
            cst.setBigDecimal(11, (BigDecimal)session.getAttribute("prpCode"));
            cst.setBigDecimal(12,
                              (BigDecimal)session.getAttribute("PolicyCategory"));
            cst.setBigDecimal(13,
                              (BigDecimal)session.getAttribute("ProductCode"));
            String Cursta = (String)session.getAttribute("CurrentStatus");
            //System.out.println("10");
            if (Cursta == "Q") {
                cst.setBigDecimal(14,
                                  (BigDecimal)session.getAttribute("QuoteCode")); //Quotation Code
            } else {
                cst.setBigDecimal(14,
                                  (BigDecimal)session.getAttribute("endorsementCode")); //Endorsement Code
            }
            cst.execute();
            cst.close();
            conn.close();

            this.djMemNo.setValue(null);
            this.djSurname.setValue(null);
            this.djOtherNames.setValue(null);
            this.djSex.setValue(null);
            this.djDOB.setValue(null);
            this.djIDNo.setValue(null);

            ADFUtils.findIterator("FindJointMembersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(jointMemLOV);


            String Message = "Joint Member Has Been Added";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;*/
        try {
            String polQuery =
                "begin LMS_WEB_PKG_GRP.createpoljointmember(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?" +
                ",?,?,?,?,?,?);end;";
            cst = conn.prepareCall(polQuery);

            if (djSurname.getValue() == null) {
                cst.setBigDecimal(1, null);
            } else {
                cst.setString(1, djSurname.getValue().toString());
            }
            if (djOtherNames.getValue() == null) {
                cst.setBigDecimal(2, null);
            } else {
                cst.setString(2, djOtherNames.getValue().toString());
            }
            if (djIDNo.getValue() == null) {
                cst.setBigDecimal(3, null);
            } else {
                cst.setString(3, djIDNo.getValue().toString());
            }
            if (djDOB.getValue() == null) {
                cst.setString(4, null);
            } else {
                cst.setString(4,
                              GlobalCC.parseDate(djDOB.getValue().toString()));
            }

            if (djMemNo.getValue() == null) {
                cst.setBigDecimal(5, null);
            } else {
                cst.setString(5, djMemNo.getValue().toString());
            }
            if (djSex.getValue() == null) {
                cst.setBigDecimal(6, null);
            } else {
                cst.setString(6, djSex.getValue().toString());
            }
            cst.setString(7, null);
            cst.setString(8, null);
            cst.setString(9, null);
            cst.setString(10, null);
            cst.setString(11, null);
            cst.setString(12, null);
            cst.setString(13, null);
            cst.setString(14, null);
            cst.setString(15, null);
            cst.setString(16, null);
            cst.setString(17, null);
            cst.setString(18, null);
            cst.setBigDecimal(19,
                              (BigDecimal)session.getAttribute("MemberNumber"));
            cst.setBigDecimal(20,
                              (BigDecimal)session.getAttribute("PolicyCategory"));
            cst.setBigDecimal(21, (BigDecimal)session.getAttribute("prpCode"));
            cst.setBigDecimal(22,
                              (BigDecimal)session.getAttribute("endorsementCode"));
            cst.setBigDecimal(23,
                              (BigDecimal)session.getAttribute("gco_code"));
            cst.setString(24, "N");
            
            if(jntAddress.getValue()==null){
              cst.setString(25,null);
            }else{
              cst.setString(25,jntAddress.getValue().toString());
            }
            if(jntPinNO.getValue()==null){
              cst.setString(26,null);
            }else{
              cst.setString(26,jntPinNO.getValue().toString());
            }
            
            
            cst.execute();
            cst.close();
            conn.close();

            //System.out.println("JOINT MEMBER ADDED. ABOUT TO CALL FINDJOINTMEMBER ITERATOR.");
            ADFUtils.findIterator("FindJointMembersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(jointMemLOV);

            String Message = "Joint Member Added.";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
            
            djSurname.setValue(null);
            djOtherNames.setValue(null);
            djIDNo.setValue(null);
            djDOB.setValue(null);
            djSex.setValue(null);
            djMemNo.setValue(null);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
            e.printStackTrace();
        }
        return null;
    }

    public String Return() {

        try {
            //LOVCC.MemberNumber = 0;
            //LOVCC.PolicyCategory = null;
            //LOVCC.OccupationCode = null;
            session.setAttribute("editComponents", "N");
            GlobalCC.RedirectPage("/g_undwrt.jspx");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return null;

    }

    public void setDepTypeDesc(RichInputText depTypeDesc) {
        this.depTypeDesc = depTypeDesc;
    }

    public RichInputText getDepTypeDesc() {
        return depTypeDesc;
    }

    public void setDepTypeLOV(RichTable depTypeLOV) {
        this.depTypeLOV = depTypeLOV;
    }

    public RichTable getDepTypeLOV() {
        return depTypeLOV;
    }

    public void setCategoryLOV(RichTable categoryLOV) {
        this.categoryLOV = categoryLOV;
    }

    public RichTable getCategoryLOV() {
        return categoryLOV;
    }

    public void setCategoryDesc(RichInputText categoryDesc) {
        this.categoryDesc = categoryDesc;
    }

    public RichInputText getCategoryDesc() {
        return categoryDesc;
    }

    public void setOccupationDesc(RichInputText occupationDesc) {
        this.occupationDesc = occupationDesc;
    }

    public RichInputText getOccupationDesc() {
        return occupationDesc;
    }

    public void setOccupationLOV(RichTable occupationLOV) {
        this.occupationLOV = occupationLOV;
    }

    public RichTable getOccupationLOV() {
        return occupationLOV;
    }

    public void setMemANB(RichInputText memANB) {
        this.memANB = memANB;
    }

    public RichInputText getMemANB() {
        return memANB;
    }

    public void setMemNo(RichInputText memNo) {
        this.memNo = memNo;
    }

    public RichInputText getMemNo() {
        return memNo;
    }

    public void setMemSurname(RichInputText memSurname) {
        this.memSurname = memSurname;
    }

    public RichInputText getMemSurname() {
        return memSurname;
    }

    public void setMemOtherNames(RichInputText memOtherNames) {
        this.memOtherNames = memOtherNames;
    }

    public RichInputText getMemOtherNames() {
        return memOtherNames;
    }

    public void setLoanDate(RichInputDate loanDate) {
        this.loanDate = loanDate;
    }

    public RichInputDate getLoanDate() {
        return loanDate;
    }

    public void setOrigloanAmt(RichInputNumberSpinbox origloanAmt) {
        this.origloanAmt = origloanAmt;
    }

    public RichInputNumberSpinbox getOrigloanAmt() {
        return origloanAmt;
    }

    public void setLoanInt(RichInputText loanInt) {
        this.loanInt = loanInt;
    }

    public RichInputText getLoanInt() {
        return loanInt;
    }

    public void setOrigRpyPrd(RichOutputLabel origRpyPrd) {
        this.origRpyPrd = origRpyPrd;
    }

    public RichOutputLabel getOrigRpyPrd() {
        return origRpyPrd;
    }

    public void setSavingAmt(RichInputNumberSpinbox savingAmt) {
        this.savingAmt = savingAmt;
    }

    public RichInputNumberSpinbox getSavingAmt() {
        return savingAmt;
    }

    public void setEmprBF(RichInputText emprBF) {
        this.emprBF = emprBF;
    }

    public RichInputText getEmprBF() {
        return emprBF;
    }

    public void setEmpeBF(RichInputText empeBF) {
        this.empeBF = empeBF;
    }

    public RichInputText getEmpeBF() {
        return empeBF;
    }

    public void setContrType(RichSelectOneChoice contrType) {
        this.contrType = contrType;
    }

    public RichSelectOneChoice getContrType() {
        return contrType;
    }

    public void setEmpeContr(RichInputText empeContr) {
        this.empeContr = empeContr;
    }

    public RichInputText getEmpeContr() {
        return empeContr;
    }

    public void setEmprContr(RichInputText emprContr) {
        this.emprContr = emprContr;
    }

    public RichInputText getEmprContr() {
        return emprContr;
    }

    public void setMemEarnings(RichInputNumberSpinbox memEarnings) {
        this.memEarnings = memEarnings;
    }

    public RichInputNumberSpinbox getMemEarnings() {
        return memEarnings;
    }

    public void setMemEarnprds(RichInputText memEarnprds) {
        this.memEarnprds = memEarnprds;
    }

    public RichInputText getMemEarnprds() {
        return memEarnprds;
    }

    public void setGrpLifeRider(RichSelectBooleanCheckbox grpLifeRider) {
        this.grpLifeRider = grpLifeRider;
    }

    public RichSelectBooleanCheckbox getGrpLifeRider() {
        return grpLifeRider;
    }

    public void setJoinDate(RichInputDate joinDate) {
        this.joinDate = joinDate;
    }

    public RichInputDate getJoinDate() {
        return joinDate;
    }

    public void setIdNo(RichInputText idNo) {
        this.idNo = idNo;
    }

    public RichInputText getIdNo() {
        return idNo;
    }

    public void setDob(RichInputDate dob) {
        this.dob = dob;
    }

    public RichInputDate getDob() {
        return dob;
    }

    public void setMemSex(RichSelectOneChoice memSex) {
        this.memSex = memSex;
    }

    public RichSelectOneChoice getMemSex() {
        return memSex;
    }

    public void setWeight(RichInputText weight) {
        this.weight = weight;
    }

    public RichInputText getWeight() {
        return weight;
    }

    public void setHeight(RichInputText height) {
        this.height = height;
    }

    public RichInputText getHeight() {
        return height;
    }

    public void setSysPres(RichInputText sysPres) {
        this.sysPres = sysPres;
    }

    public RichInputText getSysPres() {
        return sysPres;
    }

    public void setDiaPres(RichInputText diaPres) {
        this.diaPres = diaPres;
    }

    public RichInputText getDiaPres() {
        return diaPres;
    }

    public void setAddMember(RichCommandButton addMember) {
        this.addMember = addMember;
    }

    public RichCommandButton getAddMember() {
        return addMember;
    }

    public void setDepTypeLOV2(RichTable depTypeLOV2) {
        this.depTypeLOV2 = depTypeLOV2;
    }

    public RichTable getDepTypeLOV2() {
        return depTypeLOV2;
    }

    public void setOrigRepayPeriod(RichInputText origRepayPeriod) {
        this.origRepayPeriod = origRepayPeriod;
    }

    public RichInputText getOrigRepayPeriod() {
        return origRepayPeriod;
    }

    public void setDjMemNo(RichInputText djMemNo) {
        this.djMemNo = djMemNo;
    }

    public RichInputText getDjMemNo() {
        return djMemNo;
    }

    public void setDjSurname(RichInputText djSurname) {
        this.djSurname = djSurname;
    }

    public RichInputText getDjSurname() {
        return djSurname;
    }

    public void setDjOtherNames(RichInputText djOtherNames) {
        this.djOtherNames = djOtherNames;
    }

    public RichInputText getDjOtherNames() {
        return djOtherNames;
    }

    public void setDjSex(RichSelectOneChoice djSex) {
        this.djSex = djSex;
    }

    public RichSelectOneChoice getDjSex() {
        return djSex;
    }

    public void setDjIDNo(RichInputText djIDNo) {
        this.djIDNo = djIDNo;
    }

    public RichInputText getDjIDNo() {
        return djIDNo;
    }

    public void setDjDOB(RichInputDate djDOB) {
        this.djDOB = djDOB;
    }

    public RichInputDate getDjDOB() {
        return djDOB;
    }

    public void dependantsListener(ActionEvent actionEvent) {
        // Add event code here...
        DependantOrJoint = 1;
    }

    public void jointMemListener(ActionEvent actionEvent) {
        // Add event code here...
        DependantOrJoint = 2;
    }

    public void jointTabListener(AttributeChangeEvent attributeChangeEvent) {
        // Add event code here...
        DependantOrJoint = 2;
    }

    public void dependantTabListener(AttributeChangeEvent attributeChangeEvent) {
        // Add event code here...
        DependantOrJoint = 1;
    }

    public void setJmemNo(RichInputText jmemNo) {
        this.jmemNo = jmemNo;
    }

    public RichInputText getJmemNo() {
        return jmemNo;
    }

    public void setJsurname(RichInputText jsurname) {
        this.jsurname = jsurname;
    }

    public RichInputText getJsurname() {
        return jsurname;
    }

    public void setJotherNames(RichInputText jotherNames) {
        this.jotherNames = jotherNames;
    }

    public RichInputText getJotherNames() {
        return jotherNames;
    }

    public void setJsex(RichSelectOneChoice jsex) {
        this.jsex = jsex;
    }

    public RichSelectOneChoice getJsex() {
        return jsex;
    }

    public void setJiDNo(RichInputText jiDNo) {
        this.jiDNo = jiDNo;
    }

    public RichInputText getJiDNo() {
        return jiDNo;
    }

    public void setJdOB(RichInputDate jdOB) {
        this.jdOB = jdOB;
    }

    public RichInputDate getJdOB() {
        return jdOB;
    }

    public void setMemDependantsLOV(RichTable memDependantsLOV) {
        this.memDependantsLOV = memDependantsLOV;
    }

    public RichTable getMemDependantsLOV() {
        return memDependantsLOV;
    }

    public void setJointMemLOV(RichTable jointMemLOV) {
        this.jointMemLOV = jointMemLOV;
    }

    public RichTable getJointMemLOV() {
        return jointMemLOV;
    }

    public void setPolicyDetailsTab(RichShowDetailItem policyDetailsTab) {
        this.policyDetailsTab = policyDetailsTab;
    }

    public RichShowDetailItem getPolicyDetailsTab() {
        return policyDetailsTab;
    }

    public void setAnotherMem(RichCommandButton anotherMem) {
        this.anotherMem = anotherMem;
    }

    public RichCommandButton getAnotherMem() {
        return anotherMem;
    }

    public void dependantsListener(SelectionEvent selectionEvent) {
        // Add event code here...
        // Add event code here...
        String Rate = null;
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindDependantTypesIterator");
        RowKeySet set = selectionEvent.getAddedSet();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));


            Row r = dciter.getCurrentRow();
            //LOVCC.DepTypeCode=(BigDecimal)r.getAttribute("DTY_CODE");
            //LOVCC.DepTypeDesc=(String)r.getAttribute("DTY_DESCRIPTION");
            session.setAttribute("DepTypeCode", r.getAttribute("DTY_CODE"));
            session.setAttribute("DepTypeDesc",
                                 r.getAttribute("DTY_DESCRIPTION"));

            djMemNo.setValue(null);
            djSurname.setValue(null);
            djOtherNames.setValue(null);
            djSex.setValue(null);
            djDOB.setValue(null);
            djIDNo.setValue(null);

            AdfFacesContext.getCurrentInstance().addPartialTarget(djMemNo);
            AdfFacesContext.getCurrentInstance().addPartialTarget(djSurname);
            AdfFacesContext.getCurrentInstance().addPartialTarget(djOtherNames);
            AdfFacesContext.getCurrentInstance().addPartialTarget(djSex);
            AdfFacesContext.getCurrentInstance().addPartialTarget(djDOB);
            AdfFacesContext.getCurrentInstance().addPartialTarget(djIDNo);


            //ADFUtils.findIterator("findMemberCoverTypesIterator").executeQuery();
            //AdfFacesContext.getCurrentInstance().addPartialTarget(memLimits);


        }
    }

    public void setJntPinNO(RichInputText jntPinNO) {
        this.jntPinNO = jntPinNO;
    }

    public RichInputText getJntPinNO() {
        return jntPinNO;
    }

    public void setJntAddress(RichInputText jntAddress) {
        this.jntAddress = jntAddress;
    }

    public RichInputText getJntAddress() {
        return jntAddress;
    }
}
