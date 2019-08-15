package LMSG.view.setups;

import LMSG.view.Base.ADFUtils;
import LMSG.view.Base.GlobalCC;

import LMSG.view.connect.DBConnector;

import java.io.BufferedOutputStream;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.el.ELContext;
import javax.el.ExpressionFactory;

import javax.el.MethodExpression;

import javax.faces.application.Application;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import javax.faces.event.MethodExpressionActionListener;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputNumberSpinbox;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectItem;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;

import oracle.adf.view.rich.component.rich.nav.RichCommandLink;
import oracle.adf.view.rich.component.rich.output.RichOutputFormatted;

import oracle.adf.view.rich.component.rich.output.RichOutputLabel;


import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Key;
import oracle.jbo.Row;

import oracle.jdbc.OracleTypes;

import org.apache.myfaces.trinidad.model.RowKeySet;

public class ImportTemplateManip {
    private RichInputText prodDesc;
    private RichTable productTable;
    private RichInputText tableDesc;
    private RichPanelBox productTab;
    private RichPanelBox productDetailsTab;
    private RichCommandButton prevButton;
    private RichCommandButton nextButton;
    private RichOutputFormatted tableDescription1;
    private RichOutputFormatted prodDescription1;

    private HtmlPanelGrid dynamicContainer;

    public ImportTemplateManip() {
        super();
    }

    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);

    public String findProductSelected() {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findImportTemplateProductsIterator");
            RowKeySet set = productTable.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                session.setAttribute("ProductCode",
                                     r.getAttribute("PROD_CODE"));
                session.setAttribute("productType",
                                     r.getAttribute("PROD_TYPE"));
                prodDesc.setValue(r.getAttribute("PROD_DESC"));
                tableDesc.setValue(r.getAttribute("LPIT_TABLE_NAME"));
                prodDescription1.setValue(r.getAttribute("PROD_DESC"));
                tableDescription1.setValue(r.getAttribute("LPIT_TABLE_NAME"));

            }

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String NextTransition() {
        Connection conn = null;
        try {
            if (productTab.isRendered()) {

                if (session.getAttribute("ProductCode") == null) {
                    GlobalCC.errorValueNotEntered("Select A Product.");
                    return null;
                }

                if (tableDesc.getValue() == null) {
                    GlobalCC.errorValueNotEntered("Enter A Table Name");
                    return null;
                }

                //Validate Table Provided.
                Integer TotalColumns =
                    ValidateTableName(tableDesc.getValue().toString());
                if (TotalColumns == 0) {
                    GlobalCC.errorValueNotEntered("The Table is Invalid");
                    return null;
                }

                //Save Table Details...
                SaveProductTable();

                tableDescription1.setValue(tableDesc.getValue().toString());

                //Construct Dynamic Objects...
                ConstructTemplateStruct();

                productDetailsTab.setRendered(true);
                productTab.setRendered(false);
                prevButton.setRendered(true);
                nextButton.setRendered(false);
            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public String PreviousTransition() {
        Connection conn = null;
        try {
            if (productDetailsTab.isRendered()) {

                productDetailsTab.setRendered(false);
                productTab.setRendered(true);
                prevButton.setRendered(false);
                nextButton.setRendered(true);
            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public Integer ValidateTableName(String TableName) {
        Connection conn = null;
        Integer TotalColumns = 0;
        try {
            conn = new DBConnector().getDatabaseConn();
            String CountQuery =
                "SELECT COUNT(*) FROM USER_TAB_COLUMNS WHERE TABLE_NAME='" +
                TableName + "'";
            CallableStatement cst1 = null;
            cst1 = conn.prepareCall(CountQuery);
            ResultSet rs1 = cst1.executeQuery();
            while (rs1.next()) {
                TotalColumns = rs1.getInt(1);
            }
            cst1.close();
            rs1.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return TotalColumns;
    }

    public String SaveProductTable() {
        Connection conn = null;
        try {
            conn = new DBConnector().getDatabaseConn();
            String CountQuery =
                "begin LMS_SETUPS_PKG.save_product_import_tmplt(?,?); end;";
            CallableStatement cst1 = null;
            cst1 = conn.prepareCall(CountQuery);
            cst1.setBigDecimal(1,
                               (BigDecimal)session.getAttribute("ProductCode"));
            cst1.setString(2, tableDesc.getValue().toString());
            cst1.execute();
            cst1.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public RichSelectOneChoice UserTableColumns(String TableName, Integer ID,
                                                String Value) {

        RichSelectOneChoice MyChoice = new RichSelectOneChoice();

        Connection conn = null;
        try {
            MyChoice.setId("DynChoice_" + ID);
            MyChoice.setValue(Value);

            conn = new DBConnector().getDatabaseConn();
            String CountQuery =
                "SELECT COLUMN_NAME FROM USER_TAB_COLUMNS WHERE TABLE_NAME='" +
                TableName + "'";
            CallableStatement cst1 = null;
            cst1 = conn.prepareCall(CountQuery);
            ResultSet rs1 = cst1.executeQuery();
            int k = 0;
            while (rs1.next()) {
                RichSelectItem ItemNames = new RichSelectItem();
                ItemNames.setId("SD_" + k);
                ItemNames.setLabel(rs1.getString(1));
                ItemNames.setValue(rs1.getString(1));
                MyChoice.getChildren().add(ItemNames);
                k++;

            }
            cst1.close();
            rs1.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return MyChoice;
    }

    public String ConstructTemplateStruct() {
        Connection conn = null;
        try {
            //CLEAR CONTAINER..
            dynamicContainer.getChildren().clear();

            //COUNT THE COLUMNS ON THE TEMPLATE TABLE..
            Integer TotalColumns = ValidateTableName("LMS_PROD_IMP_TMPLT");
            System.out.println("Total Columns " + TotalColumns);

            //GET THE COLUMNS ON THE TEMPLATE TABLE..
            String Query =
                "SELECT * FROM LMS_PROD_IMP_TMPLT WHERE LPIT_PROD_CODE = ?";
            CallableStatement cst = null;
            conn = new DBConnector().getDatabaseConn();
            cst = conn.prepareCall(Query);
            cst.setBigDecimal(1,
                              (BigDecimal)session.getAttribute("ProductCode"));
            ResultSet rs = cst.executeQuery();
            int iCount = 4;
            int IDCount = 1;
            while (rs.next()) {
                while (iCount <= TotalColumns) {
                    //CONSTRUCT THE COMPONENTS. FIRST COLUMN NAME.
                    RichOutputLabel LabelName = new RichOutputLabel();
                    LabelName.setId("DynLabel_" + IDCount);
                    LabelName.setValue("Column Name");
                    LabelName.setInlineStyle("font-weight:bold;");
                    dynamicContainer.getChildren().add(LabelName);
                    RichInputText TextName = new RichInputText();
                    TextName.setId("DynText_" + IDCount);
                    TextName.setValue(rs.getString(iCount));
                    dynamicContainer.getChildren().add(TextName);
                    //CONSTRUCT THE COMPONENTS. SECOND THE POSITION.
                    RichOutputLabel LabelName2 = new RichOutputLabel();
                    LabelName2.setId("DynLabel2_" + IDCount);
                    LabelName2.setValue("Position");
                    LabelName2.setInlineStyle("font-weight:bold;");
                    dynamicContainer.getChildren().add(LabelName2);
                    RichInputNumberSpinbox SpinBoxName =
                        new RichInputNumberSpinbox();
                    SpinBoxName.setId("DynSpin_" + IDCount);
                    SpinBoxName.setValue(rs.getString(iCount + 1));
                    dynamicContainer.getChildren().add(SpinBoxName);

                    //CONSTRUCT THE COMPONENTS. THIRD THE MAPPING..
                    RichOutputLabel LabelName3 = new RichOutputLabel();
                    LabelName3.setId("DynLabel3_" + IDCount);
                    LabelName3.setValue("Maps Into");
                    LabelName3.setInlineStyle("font-weight:bold;");
                    dynamicContainer.getChildren().add(LabelName3);

                    RichSelectOneChoice ChoiceName =
                        UserTableColumns(tableDesc.getValue().toString(),
                                         IDCount, rs.getString(iCount + 2));
                    //ChoiceName.setId("DynText_"+iCount+2);
                    //ChoiceName.setValue(rs.getString(iCount+2));
                    //ChoiceName.getChildren().add(ItemNames);
                    dynamicContainer.getChildren().add(ChoiceName);

                    RichCommandLink clearLink = getClearLink(IDCount);
                    //  clear.setId("DynLink_"+IDCount);
                    // clear.setText("Clear fields");
                    dynamicContainer.getChildren().add(clearLink);

                    iCount = iCount + 3;
                    IDCount++;
                }
            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
            e.printStackTrace();
        }
        return null;
    }

    public String SaveProductImportTemplateData() {
        Connection conn = null;
        String Parameters = null;
        String[][] ColumnValues = null;
        try {
            int comp = 0;
            int myCount = 0;
            Integer ColumnCount = 0;
            Integer TotalColumns = ValidateTableName("LMS_PROD_IMP_TMPLT");
            Integer ArraySize = TotalColumns; /*/ 3;*/
            float xFloat;
            xFloat = ArraySize;
            ColumnValues = new String[Math.round(xFloat)][5];

            while (comp < dynamicContainer.getChildCount()) {
                UIComponent mine = dynamicContainer.getChildren().get(comp);
                String ComponentID = mine.getId();
                if (ComponentID == null) {

                } else {
                    //LOOP THRU THE COMPONENTS SAVING THERE DATA.
                    if (ComponentID.contains("DynLabel_")) {
                        //do nothing...

                    } else if (ComponentID.contains("DynText_")) {
                        //Text Box.
                        RichInputText Textvalue = (RichInputText)mine;
                        if (Textvalue.getValue() == null) {

                        } else {
                            //GET ID TO DETERMINE COLUMN NAME.
                            String TextValID = Textvalue.getId();
                            String ColumnID =
                                TextValID.replace("DynText_", "");
                            String ColumnName =
                                "LPIT_COL" + ColumnID + "_NAME";
                            Parameters = ColumnName + ",";

                            ColumnValues[ColumnCount][0] =
                                    ColumnName; //Parameter
                            ColumnValues[ColumnCount][1] =
                                    Textvalue.getValue().toString(); //Column Mapping.
                            ColumnCount++;
                        }

                    } else if (ComponentID.contains("DynSpin_")) {
                        //Spin Box.
                        RichInputNumberSpinbox Spinvalue =
                            (RichInputNumberSpinbox)mine;
                        if (Spinvalue.getValue() == null) {

                        } else {
                            //GET ID TO DETERMINE COLUMN NAME.
                            String TextValID = Spinvalue.getId();
                            String ColumnID =
                                TextValID.replace("DynSpin_", "");
                            String ColumnName =
                                "LPIT_COL" + ColumnID + "_POSITION";
                            Parameters = ColumnName + ",";

                            ColumnValues[ColumnCount][0] =
                                    ColumnName; //Parameter
                            ColumnValues[ColumnCount][1] =
                                    Spinvalue.getValue().toString(); //Column Mapping.
                            ColumnCount++;
                        }

                    } else if (ComponentID.contains("DynChoice_")) {
                        //Select One Choice.
                        RichSelectOneChoice Choicevalue =
                            (RichSelectOneChoice)mine;
                        if (Choicevalue.getValue() == null) {

                        } else {
                            //GET ID TO DETERMINE COLUMN NAME.
                            String TextValID = Choicevalue.getId();
                            String ColumnID =
                                TextValID.replace("DynChoice_", "");
                            String ColumnName =
                                "LPIT_COL" + ColumnID + "_MAPPING";
                            Parameters = ColumnName + ",";

                            ColumnValues[ColumnCount][0] =
                                    ColumnName; //Parameter
                            ColumnValues[ColumnCount][1] =
                                    Choicevalue.getValue().toString(); //Column Mapping.
                            ColumnCount++;
                        }

                    }
                }
                comp++;
            }
            String Params = null;
            int count = 0;
            while (myCount < ColumnValues.length) {
                String Value = ColumnValues[myCount][0];
                String saveParameters = null;
                //System.out.println("Value "+Value);
                if (Value == null) {
                    //do nothing..
                } else {
                    String array[] = ColumnValues[myCount][0].split("_");
                    saveParameters = array[1];
                    // System.out.println("Column "+saveParameters);
                    if (Params == null) {
                        Params =
                                ColumnValues[myCount][0] + " = " + "'" + ColumnValues[myCount][1] +
                                "'" + ",";
                    } else {
                        Params =
                                Params + ColumnValues[myCount][0] + " = " + "'" +
                                ColumnValues[myCount][1] + "'" + ",";
                    }
                }
                myCount++;
            }
            String FullParameters = Params.substring(0, Params.length() - 1);
            System.out.println("Parameters trunc " + FullParameters);
            String Query =
                "UPDATE LMS_PROD_IMP_TMPLT SET " + FullParameters + " WHERE LPIT_PROD_CODE = ?";
            CallableStatement cst = null;
            conn = new DBConnector().getDatabaseConn();
            cst = conn.prepareCall(Query);
            cst.setBigDecimal(1,
                              (BigDecimal)session.getAttribute("ProductCode"));
            cst.execute();
            cst.close();
            conn.close();

            GlobalCC.INFORMATIONREPORTING("Template Saved Successfully");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }


    public String GenerateTemplateFile() {
        Connection conn = null;
        String[][] ColumnValues = null;
        int DivCnt = 0;
        int FinalPosition = 0;
        try {
            //session.setAttribute("QuoteCode", new BigDecimal("20124043"));
            conn = new DBConnector().getDatabaseConn();
            //DETERMINE IF THE QUOTE HAS SUBDIVISIONS...
            String Query1 = null;
            String SystemPoint = (String)session.getAttribute("SystemPoint");
            if (SystemPoint != null) {
                if (SystemPoint.equalsIgnoreCase("U")) {
                    Query1 =
                            "SELECT DISTINCT GSUB_DESC FROM LMS_POLICY_GRP_SUBDIVISIONS, LMS_GRP_SUBDIVISIONS \n" +
                            "WHERE PGSUB_GSUB_CODE = GSUB_CODE AND PGSUB_ENDR_CODE = ?";
                    CallableStatement cst1 = null;
                    cst1 = conn.prepareCall(Query1);
                    cst1.setBigDecimal(1,
                                       (BigDecimal)session.getAttribute("endorsementCode"));
                    ResultSet rs1 = cst1.executeQuery();
                    while (rs1.next()) {
                        DivCnt++;
                    }
                } else {
                    Query1 =
                            "SELECT DISTINCT GSUB_DESC FROM LMS_QUOTE_GRP_SUBDIVISIONS, LMS_GRP_SUBDIVISIONS \n" +
                            "WHERE QGSUB_GSUB_CODE = GSUB_CODE AND QGSUB_QUO_CODE = ?";
                    CallableStatement cst1 = null;
                    cst1 = conn.prepareCall(Query1);
                    cst1.setBigDecimal(1,
                                       (BigDecimal)session.getAttribute("QuoteCode"));
                    ResultSet rs1 = cst1.executeQuery();
                    while (rs1.next()) {
                        DivCnt++;
                    }
                }
            }

            //GET THE COLUMNS ON THE TEMPLATE TABLE..
            Integer TotalColumns = ValidateTableName("LMS_PROD_IMP_TMPLT");
            Integer ArraySize = TotalColumns; /*/ 3;*/
            float xFloat;
            xFloat = ArraySize + DivCnt;
            ColumnValues = new String[Math.round(xFloat)][5];


            String Query =
                "SELECT * FROM LMS_PROD_IMP_TMPLT WHERE LPIT_PROD_CODE = ?";
            CallableStatement cst = null;
            cst = conn.prepareCall(Query);
            cst.setBigDecimal(1,
                              (BigDecimal)session.getAttribute("ProductCode"));
            ResultSet rs = cst.executeQuery();
            int iCount = 4;
            while (rs.next()) {
                while (iCount <= TotalColumns) {
                    if (rs.getString(iCount) == null) {
                        //do nothing...
                    } else {
                        int Position = rs.getInt(iCount + 1);
                        ColumnValues[Position - 1][0] = rs.getString(iCount);
                        //FinalPosition = FinalPosition + (Position-1);
                        FinalPosition = FinalPosition + 1;
                    }
                    iCount = iCount + 3;
                }
            }

            //APPEND DIVISIONS TO THE ARRAY
            if (SystemPoint != null) {
                CallableStatement cst2 = null;
                cst2 = conn.prepareCall(Query1);
                if (SystemPoint.equalsIgnoreCase("U")) {
                    cst2.setBigDecimal(1,
                                       (BigDecimal)session.getAttribute("endorsementCode"));
                } else {
                    cst2.setBigDecimal(1,
                                       (BigDecimal)session.getAttribute("QuoteCode"));
                }

                ResultSet rs2 = cst2.executeQuery();
                while (rs2.next()) {
                    ColumnValues[FinalPosition][0] = rs2.getString(1);
                    FinalPosition++;
                }
            }
            int myCount = 0;
            String Params = null;
            while (myCount < ColumnValues.length) {
                String Value = ColumnValues[myCount][0];
                if (Value == null) {
                    //do nothing..
                } else {
                    if (Params == null) {
                        Params = ColumnValues[myCount][0] + ",";
                    } else {
                        Params = Params + ColumnValues[myCount][0] + ",";
                    }
                }
                myCount++;
            }

            String FullParameters = Params.substring(0, Params.length() - 1);
            System.out.println("Parameters trunc " + FullParameters);

            String prodTy = (String)session.getAttribute("productType");

            String Header = prodTy + "\n" +
                "CLIENT SHT_DESC\n" +
                "No of Recs\n" +
                Params;

            byte barray[] = Header.getBytes();


            //Print.
            HttpServletResponse response =
                (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();

            ServletOutputStream servletOutputStream;
            response.reset();
            response.resetBuffer();
            servletOutputStream = response.getOutputStream();
            BufferedOutputStream bufferedOutputStream =
                new BufferedOutputStream(servletOutputStream);

            String output = "Template.csv";
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition",
                               "attachment; filename=" + output + "");


            response.setContentLength(barray.length);

            bufferedOutputStream.write(barray, 0, barray.length);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();

            response.reset();
            response.resetBuffer();

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
            e.printStackTrace();
        }
        return null;
    }

    public String exportInvalidMembers() {
        Connection conn = null;
        String[][] ColumnValues = null;
        String[][] rowValues = null;
        int DivCnt = 0;
        int FinalPosition = 0;
        try {
            //session.setAttribute("QuoteCode", new BigDecimal("20124043"));
            conn = new DBConnector().getDatabaseConn();
            //DETERMINE IF THE QUOTE HAS SUBDIVISIONS...
            String Query1 = null;
            String SystemPoint = (String)session.getAttribute("SystemPoint");
            if (SystemPoint != null) {
                if (SystemPoint.equalsIgnoreCase("U")) {
                    Query1 =
                            "SELECT DISTINCT GSUB_DESC FROM LMS_POLICY_GRP_SUBDIVISIONS, LMS_GRP_SUBDIVISIONS \n" +
                            "WHERE PGSUB_GSUB_CODE = GSUB_CODE AND PGSUB_ENDR_CODE = ?";
                    CallableStatement cst1 = null;
                    cst1 = conn.prepareCall(Query1);
                    cst1.setBigDecimal(1,
                                       (BigDecimal)session.getAttribute("endorsementCode"));
                    ResultSet rs1 = cst1.executeQuery();
                    while (rs1.next()) {
                        DivCnt++;
                    }
                } else {
                    Query1 =
                            "SELECT DISTINCT GSUB_DESC FROM LMS_QUOTE_GRP_SUBDIVISIONS, LMS_GRP_SUBDIVISIONS \n" +
                            "WHERE QGSUB_GSUB_CODE = GSUB_CODE AND QGSUB_QUO_CODE = ?";
                    CallableStatement cst1 = null;
                    cst1 = conn.prepareCall(Query1);
                    cst1.setBigDecimal(1,
                                       (BigDecimal)session.getAttribute("QuoteCode"));
                    ResultSet rs1 = cst1.executeQuery();
                    while (rs1.next()) {
                        DivCnt++;
                    }
                }
            }

            //GET THE COLUMNS ON THE TEMPLATE TABLE..
            Integer TotalColumns = ValidateTableName("LMS_PROD_IMP_TMPLT");
            Integer ArraySize = TotalColumns; /*/ 3;*/
            float xFloat;
            xFloat = ArraySize + DivCnt;
            ColumnValues = new String[Math.round(xFloat)][5];
            rowValues = new String[Math.round(xFloat)][5];
            String Query =
                "SELECT * FROM LMS_PROD_IMP_TMPLT WHERE LPIT_PROD_CODE = ?";
            CallableStatement cst = null;
            cst = conn.prepareCall(Query);
            cst.setBigDecimal(1,
                              (BigDecimal)session.getAttribute("ProductCode"));
            ResultSet rs = cst.executeQuery();
            int iCount = 4;
            while (rs.next()) {
                while (iCount <= TotalColumns) {
                    if (rs.getString(iCount) == null) {
                        //do nothing...
                    } else {
                        int Position = rs.getInt(iCount + 1);
                        ColumnValues[Position - 1][0] = rs.getString(iCount);
                        System.out.println("column" + rs.getString(iCount));
                        //FinalPosition = FinalPosition + (Position-1);
                        FinalPosition = FinalPosition + 1;
                    }
                    iCount = iCount + 3;
                }
            }


            Query =
                    "SELECT * FROM LMS_PROD_IMP_TMPLT WHERE LPIT_PROD_CODE = ?";
            cst = null;
            cst = conn.prepareCall(Query);
            cst.setBigDecimal(1,
                              (BigDecimal)session.getAttribute("ProductCode"));
            rs = cst.executeQuery();
            int rowsCount = 6;
            String queryParam = "";
            while (rs.next()) {
                while (rowsCount <= TotalColumns) {
                    if (rs.getString(rowsCount) == null) {
                        //do nothing...
                    } else {
                        System.out.println("column 1" +
                                           rs.getString(rowsCount));
                        queryParam += rs.getString(rowsCount) + ",";
                    }
                    rowsCount = rowsCount + 3;
                }
            }
            queryParam =
                    queryParam.substring(0, queryParam.length() - 1) + ",LMID_REMARKS";

            Query =
                    "SELECT " + queryParam + " FROM LMS_MEMBER_IMPORT_DETAILS WHERE LMID_LMIT_CODE = ? AND LMID_STATUS='I'";
            System.out.println("-------------------------------------------------------------");
            System.out.println(Query);
            System.out.println("-------------------------------------------------------------");
            cst = null;
            cst = conn.prepareCall(Query);
            cst.setInt(1,
                       ((Integer)this.session.getAttribute("templateTranSeq")).intValue());
            rs = cst.executeQuery();
            String values = "\n";
            String tockens[] = queryParam.split(",");
            while (rs.next()) {
                for (int i = 1; i <= tockens.length; i++) {

                    values += rs.getString(i) + ",";
                    System.out.println(rs.getString(i));
                }
                values += "\n";
            }
            if (values.contains("null")) {
                values = values.replace("null", "");
            }
            //APPEND DIVISIONS TO THE ARRAY
            if (SystemPoint != null) {
                CallableStatement cst2 = null;
                cst2 = conn.prepareCall(Query1);
                if (SystemPoint.equalsIgnoreCase("U")) {
                    cst2.setBigDecimal(1,
                                       (BigDecimal)session.getAttribute("endorsementCode"));
                } else {
                    cst2.setBigDecimal(1,
                                       (BigDecimal)session.getAttribute("QuoteCode"));
                }

                ResultSet rs2 = cst2.executeQuery();
                while (rs2.next()) {
                    ColumnValues[FinalPosition][0] = rs2.getString(1);
                    FinalPosition++;
                }
            }

            int myCount = 0;
            String Params = null;
            String rows = null;
            int rCount = 0;
            while (myCount < ColumnValues.length) {
                String Value = ColumnValues[myCount][0];
                if (Value == null) {
                    //do nothing..
                } else {
                    if (Params == null) {
                        Params = ColumnValues[myCount][0] + ",";
                    } else {
                        Params = Params + ColumnValues[myCount][0] + ",";
                    }
                }
                myCount++;
            }
            Params += "REMARKS,";
            while (rCount < rowValues.length) {
                String Value = ColumnValues[rCount][0];
                if (Value == null) {
                    //do nothing..
                } else {
                    if (rows == null) {
                        rows = ColumnValues[rCount][0] + ",";
                    } else {
                        rows = rows + ColumnValues[rCount][0] + ",";
                    }
                }
                rCount++;
            }

            String FullParameters = Params.substring(0, Params.length() - 1);
            System.out.println("Parameters trunc " + FullParameters);
            //System.out.println("rowns trunc"+fullRowValues);
            String prodTy = (String)session.getAttribute("productType");

            String Header = prodTy + "\n" +
                "CLIENT SHT_DESC\n" +
                "No of Recs\n" +
                Params + values;

            byte barray[] = Header.getBytes();


            //Print.
            HttpServletResponse response =
                (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();

            ServletOutputStream servletOutputStream;
            response.reset();
            response.resetBuffer();
            servletOutputStream = response.getOutputStream();
            BufferedOutputStream bufferedOutputStream =
                new BufferedOutputStream(servletOutputStream);

            String output = "InvalidMems.csv";
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition",
                               "attachment; filename=" + output + "");


            response.setContentLength(barray.length);

            bufferedOutputStream.write(barray, 0, barray.length);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();

            response.reset();
            response.resetBuffer();

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
            e.printStackTrace();
        }
        return null;
    }

    public String exportExistingMem() {
        Connection conn = null;
        String[][] ColumnValues = null;
        String[][] rowValues = null;
        int DivCnt = 0;
        int FinalPosition = 0;
        try {
            //session.setAttribute("QuoteCode", new BigDecimal("20124043"));
            conn = new DBConnector().getDatabaseConn();
            //DETERMINE IF THE QUOTE HAS SUBDIVISIONS...
            String Query1 = null;
            String SystemPoint = (String)session.getAttribute("SystemPoint");
            if (SystemPoint != null) {
                if (SystemPoint.equalsIgnoreCase("U")) {
                    Query1 =
                            "SELECT DISTINCT GSUB_DESC FROM LMS_POLICY_GRP_SUBDIVISIONS, LMS_GRP_SUBDIVISIONS \n" +
                            "WHERE PGSUB_GSUB_CODE = GSUB_CODE AND PGSUB_ENDR_CODE = ?";
                    CallableStatement cst1 = null;
                    cst1 = conn.prepareCall(Query1);
                    cst1.setBigDecimal(1,
                                       (BigDecimal)session.getAttribute("endorsementCode"));
                    ResultSet rs1 = cst1.executeQuery();
                    while (rs1.next()) {
                        DivCnt++;
                    }
                    
                    //System.out.println("DivCnt= "+DivCnt);
                } else {
                    Query1 =
                            "SELECT DISTINCT GSUB_DESC FROM LMS_QUOTE_GRP_SUBDIVISIONS, LMS_GRP_SUBDIVISIONS \n" +
                            "WHERE QGSUB_GSUB_CODE = GSUB_CODE AND QGSUB_QUO_CODE = ?";
                    CallableStatement cst1 = null;
                    cst1 = conn.prepareCall(Query1);
                    cst1.setBigDecimal(1,
                                       (BigDecimal)session.getAttribute("QuoteCode"));
                    ResultSet rs1 = cst1.executeQuery();
                    while (rs1.next()) {
                        DivCnt++;
                    }
                    //System.out.println("DivCnt= "+DivCnt);
                }
            }

            //GET THE COLUMNS ON THE TEMPLATE TABLE..
            Integer TotalColumns = ValidateTableName("LMS_PROD_IMP_TMPLT");
            //System.out.println(TotalColumns);
            //System.out.println("Template Validated.");
            Integer ArraySize = TotalColumns; /*/ 3;*/
            float xFloat;
            xFloat = ArraySize + DivCnt;
            ColumnValues = new String[Math.round(xFloat)][5];
            rowValues = new String[Math.round(xFloat)][5];

            String Query =
                "SELECT * FROM LMS_PROD_IMP_TMPLT WHERE LPIT_PROD_CODE = ?";
            CallableStatement cst = null;
            cst = conn.prepareCall(Query);
            cst.setBigDecimal(1,
                              (BigDecimal)session.getAttribute("ProductCode"));
            ResultSet rs = cst.executeQuery();
            /*Adds the mapping*/
            
            //System.out.println("Template Validated.");
            
            
            
            int iCount = 4;
            while (rs.next()) {
                while (iCount <= TotalColumns) {
                    if (rs.getString(iCount) == null) {
                        //do nothing...
                    } else {
                        int Position = rs.getInt(iCount + 1);
                        ColumnValues[Position - 1][0] = rs.getString(iCount);
                        //System.out.println(ColumnValues[Position - 1][0]);
                        System.out.println("column" + rs.getString(iCount));
                        //FinalPosition = FinalPosition + (Position-1);
                        FinalPosition = FinalPosition + 1;
                    }
                    iCount = iCount + 3;
                }
            }


            Query =
                    "SELECT * FROM LMS_PROD_IMP_TMPLT WHERE LPIT_PROD_CODE = ?";
            cst = null;
            cst = conn.prepareCall(Query);
            cst.setBigDecimal(1,
                              (BigDecimal)session.getAttribute("ProductCode"));
            rs = cst.executeQuery();
            int rowsCount = 6;
            String queryParam = "";
            String parsedString = "";
            String dataset[] = new String[TotalColumns];
            while (rs.next()) {
                while (rowsCount <= TotalColumns) {
                    if (rs.getString(rowsCount) == null) {
                        //do nothing...
                    } else {
                        queryParam += rs.getString(rowsCount) + ",";
                        //System.out.println(queryParam);
                        dataset[rs.getInt(rowsCount - 1)] =
                                rs.getString(rowsCount);
                    }
                    rowsCount = rowsCount + 3;
                }

            }


            for (int i = 1; i <= 22; i++) {
                parsedString += parseTemplate(dataset[i]) + ",";
                //System.out.println(parsedString);

            }
            
            //System.out.println(queryParam);
            //queryParam = queryParam.substring(0, queryParam.length() - 1);
            parsedString =
                    parsedString.substring(0, parsedString.length() - 1);
            
            //System.out.println("Parsed String======= "+parsedString);

            if (session.getAttribute("policyCode") != null) {
                Query =
                        "SELECT " + parsedString + " " + "FROM LMS_POLICY_MEMBERS,LMS_MEMBERS,LMS_POLICY_MEMBER_COVERS,\n" +
                        "     LMS_GRP_CLASS_OCCUPATIONS,LMS_POLICY_CATEGORIES\n" +
                        "WHERE POLM_MEM_CODE=MEM_CODE\n" +
                        "AND PCM_POLM_CODE=POLM_CODE\n" +
                        "AND POLM_ENDR_CODE=PCM_ENDR_CODE\n" +
                        " AND PCM_CODE IN( "+
                        " SELECT MIN(PCM_CODE) FROM LMS_POLICY_MEMBER_COVERS "+
                        "  WHERE PCM_POLM_CODE=POLM_CODE "+
                         "  ) "+
                        "AND POLM_GCO_CODE=GCO_CODE(+) \n" +
                        "AND POLM_PCA_CODE=PCA_CODE\n" +
                        "AND POLM_MEM_STATUS NOT IN ('R','C')\n" +
                        "AND POLM_POL_CODE=" +(BigDecimal)session.getAttribute("policyCode")+" "+
                        "ORDER BY LMS_ENDORSEMENTS_MEMBERS_PROC.mem_no_tonumber2(MEM_NO,POLM_DTY_CODE)";
            } else {
                Query =
                        "SELECT " + parsedString + " " + " FROM LMS_QUOTATION_MEMBERS,LMS_MEMBERS,LMS_QUOT_MEMBER_CVT,\n" +
                        " LMS_GRP_CLASS_OCCUPATIONS,LMS_QUOTATION_CATEGORIES \n" +
                        " WHERE QMEM_MEM_CODE=MEM_CODE \n" +
                        " AND QCM_QMEM_CODE=QMEM_CODE\n" +
                        " AND QMEM_QUO_CODE=QCM_QUO_CODE\n " +
                        " AND QCM_CODE IN(\n" + 
                        " SELECT MIN(QCM_CODE) FROM LMS_QUOT_MEMBER_CVT\n" + 
                        " WHERE QCM_QMEM_CODE=QMEM_CODE\n" + 
                        " ) " +
                        "AND QMEM_GCO_CODE=GCO_CODE(+)\n" +
                        "AND QMEM_LCA_CODE=LCA_CODE\n" +
                        "AND QMEM_QUO_CODE=" + (BigDecimal)session.getAttribute("QuoteCode")+" "+
                        "ORDER BY LMS_ENDORSEMENTS_MEMBERS_PROC.mem_no_tonumber2(MEM_NO,QMEM_DTY_CODE)";
            }
             // System.out.println("-------------------------------------------------------------");
             //System.out.println("Query: "+Query);
            // System.out.println("-------------------------------------------------------------");
            cst = null;
            cst = conn.prepareCall(Query);

            rs = cst.executeQuery();
            String values = "\n";
            String tockens[] = queryParam.split(",");
            while (rs.next()) {
                for (int i = 1; i <= tockens.length; i++) {

                    values += rs.getString(i) + ",";
                    System.out.println(rs.getString(i));
                }
                values += "\n";
            }
            if (values.contains("null")) {
                values = values.replace("null", "");
            }
            //APPEND DIVISIONS TO THE ARRAY
            if (SystemPoint != null) {
                CallableStatement cst2 = null;
                cst2 = conn.prepareCall(Query1);
                if (SystemPoint.equalsIgnoreCase("U")) {
                    cst2.setBigDecimal(1,
                                       (BigDecimal)session.getAttribute("endorsementCode"));
                } else {
                    cst2.setBigDecimal(1,
                                       (BigDecimal)session.getAttribute("QuoteCode"));
                }

                ResultSet rs2 = cst2.executeQuery();
                while (rs2.next()) {
                    ColumnValues[FinalPosition][0] = rs2.getString(1);
                    FinalPosition++;
                }
            }

            int myCount = 0;
            String Params = null;
            String rows = null;
            int rCount = 0;
            while (myCount < ColumnValues.length) {
                String Value = ColumnValues[myCount][0];
                if (Value == null) {
                    //do nothing..
                } else {
                    if (Params == null) {
                        Params = ColumnValues[myCount][0] + ",";
                    } else {
                        Params = Params + ColumnValues[myCount][0] + ",";
                    }
                }
                myCount++;
            }
            Params += "REMARKS,";

            while (rCount < rowValues.length) {
                String Value = ColumnValues[rCount][0];
                if (Value == null) {
                    //do nothing..
                } else {
                    if (rows == null) {
                        rows = ColumnValues[rCount][0] + ",";
                    } else {
                        rows = rows + ColumnValues[rCount][0] + ",";
                    }
                }
                rCount++;
            }

            String FullParameters = Params.substring(0, Params.length() - 1);
            //System.out.println("Parameters trunc " + FullParameters);
            //System.out.println("rowns trunc"+fullRowValues);
            String prodTy = (String)session.getAttribute("productType");

            String Header = prodTy + "\n" +
                "CLIENT SHT_DESC\n" +
                "No of Recs\n" +
                Params + values;

            byte barray[] = Header.getBytes();


            //Print.
            HttpServletResponse response =
                (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();

            ServletOutputStream servletOutputStream;
            response.reset();
            response.resetBuffer();
            servletOutputStream = response.getOutputStream();
            BufferedOutputStream bufferedOutputStream =
                new BufferedOutputStream(servletOutputStream);

            String output = "policyMembers.csv";
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition",
                               "attachment; filename=" + output + "");


            response.setContentLength(barray.length);

            bufferedOutputStream.write(barray, 0, barray.length);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();

            response.reset();
            response.resetBuffer();

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
            e.printStackTrace();
        }
        return null;
    }

    public String GenerateBeneficiaryTemplate() {
        Connection conn = null;
        String[][] ColumnValues = null;
        int DivCnt = 0;
        int FinalPosition = 0;
        Integer TotalColumns = 10;
        try {
            ColumnValues = new String[TotalColumns][5];

            CallableStatement cst = null;
            conn = new DBConnector().getDatabaseConn();
            cst =
conn.prepareCall("BEGIN LMS_WEB_CURSOR_GRP.get_beneficiary_template(?);end;");
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            int iCount = 1;
            int Position = 0;
            while (rs.next()) {
                while (iCount <= TotalColumns) {
                    if (rs.getString(iCount) == null) {
                        //do nothing...
                        iCount = iCount + 1;
                    } else {
                        ColumnValues[Position][0] = rs.getString(iCount);
                        Position = Position + 1;
                        iCount = iCount + 1;
                    }

                }
            }


            int myCount = 0;
            String Params = null;
            while (myCount < ColumnValues.length) {
                String Value = ColumnValues[myCount][0];
                if (Value == null) {
                    //do nothing..
                } else {
                    if (Params == null) {
                        Params = ColumnValues[myCount][0] + ",";
                    } else {
                        Params = Params + ColumnValues[myCount][0] + ",";
                    }
                }
                myCount++;
            }

            String FullParameters = Params.substring(0, Params.length() - 1);
            System.out.println("Parameters trunc " + FullParameters);

            String prodTy = (String)session.getAttribute("productType");

            String Header = Params;

            byte barray[] = Header.getBytes();


            //Print.
            HttpServletResponse response =
                (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();

            ServletOutputStream servletOutputStream;
            response.reset();
            response.resetBuffer();
            servletOutputStream = response.getOutputStream();
            BufferedOutputStream bufferedOutputStream =
                new BufferedOutputStream(servletOutputStream);

            String output = "Template.csv";
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition",
                               "attachment; filename=" + output + "");


            response.setContentLength(barray.length);

            bufferedOutputStream.write(barray, 0, barray.length);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();

            response.reset();
            response.resetBuffer();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public String GenerateLoanRepaymentTemplate() {
        Connection conn = null;
        String[][] ColumnValues = null;
        int DivCnt = 0;
        int FinalPosition = 0;
        Integer TotalColumns = 6;
        try {
            ColumnValues = new String[TotalColumns][5];

            CallableStatement cst = null;
            conn = new DBConnector().getDatabaseConn();
            cst =
conn.prepareCall("BEGIN LMS_WEB_CURSOR_GRP.get_loan_repymnt_template(?);end;");
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            int iCount = 1;
            int Position = 0;
            while (rs.next()) {
                while (iCount <= TotalColumns) {
                    if (rs.getString(iCount) == null) {
                        //do nothing...
                        iCount = iCount + 1;
                    } else {
                        ColumnValues[Position][0] = rs.getString(iCount);
                        Position = Position + 1;
                        iCount = iCount + 1;
                    }

                }
            }


            int myCount = 0;
            String Params = null;
            while (myCount < ColumnValues.length) {
                String Value = ColumnValues[myCount][0];
                if (Value == null) {
                    //do nothing..
                } else {
                    if (Params == null) {
                        Params = ColumnValues[myCount][0] + ",";
                    } else {
                        Params = Params + ColumnValues[myCount][0] + ",";
                    }
                }
                myCount++;
            }

            String FullParameters = Params.substring(0, Params.length() - 1);
            System.out.println("Parameters trunc " + FullParameters);

            String prodTy = (String)session.getAttribute("productType");

            String Header = Params;

            byte barray[] = Header.getBytes();


            //Print.
            HttpServletResponse response =
                (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();

            ServletOutputStream servletOutputStream;
            response.reset();
            response.resetBuffer();
            servletOutputStream = response.getOutputStream();
            BufferedOutputStream bufferedOutputStream =
                new BufferedOutputStream(servletOutputStream);

            String output = "Template.csv";
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition",
                               "attachment; filename=" + output + "");


            response.setContentLength(barray.length);

            bufferedOutputStream.write(barray, 0, barray.length);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();

            response.reset();
            response.resetBuffer();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public RichCommandLink getClearLink(int idCount) {
        RichCommandLink clear = new RichCommandLink();
        clear.setId("DynLink_" + idCount);
        clear.setText("Clear fields");
        FacesContext facesCtx = FacesContext.getCurrentInstance();
        Application application = facesCtx.getApplication();
        ExpressionFactory elFactory = application.getExpressionFactory();
        ELContext elContext = facesCtx.getELContext();
        MethodExpression methodExpression = null;
        methodExpression =
                elFactory.createMethodExpression(elContext, "#{ImportTempBean.handleClearEvent}",
                                                 Object.class,
                                                 new Class[] { ActionEvent.class });
        MethodExpressionActionListener al = null;
        al = new MethodExpressionActionListener(methodExpression);
        clear.addActionListener(al);

        return clear;
    }

    public void handleClearEvent(ActionEvent event) {
        Connection conn = null;
        int compCount = 0;
        String id = null;
        String query = null;
        RichInputText Textvalue = null;
        RichInputNumberSpinbox Spinvalue = null;
        RichSelectOneChoice Choicevalue = null;

        UIComponent comp = event.getComponent();
        id = comp.getId().substring(comp.getId().indexOf("_") + 1);
        query =
                "UPDATE  LMS_PROD_IMP_TMPLT SET LPIT_COL" + id + "_NAME=null,LPIT_COL" +
                id + "_POSITION=null,LPIT_COL" + id +
                "_MAPPING=null WHERE LPIT_PROD_CODE=?";
        try {
            conn = new DBConnector().getDatabaseConn();
            CallableStatement cst1 = null;
            cst1 = conn.prepareCall(query);
            cst1.setBigDecimal(1,
                               (BigDecimal)session.getAttribute("ProductCode"));
            cst1.execute();
            cst1.close();
            conn.close();

            while (compCount < dynamicContainer.getChildCount()) {
                UIComponent mine =
                    dynamicContainer.getChildren().get(compCount);
                String ComponentID = mine.getId();
                if (ComponentID == null) {

                } else {
                    //LOOP THRU THE COMPONENTS SAVING THERE DATA.
                    if (ComponentID.equals("DynText_" + id)) {
                        //Text Box.
                        Textvalue = (RichInputText)mine;
                        if (Textvalue.getValue() == null) {

                        } else {
                            //GET ID TO DETERMINE COLUMN NAME.
                        }

                    } else if (ComponentID.equals("DynSpin_" + id)) {
                        //Spin Box.
                        Spinvalue = (RichInputNumberSpinbox)mine;
                        if (Spinvalue.getValue() == null) {

                        } else {

                        }

                    } else if (ComponentID.equals("DynChoice_" + id)) {
                        //Select One Choice.
                        Choicevalue = (RichSelectOneChoice)mine;
                        if (Choicevalue.getValue() == null) {

                        } else {

                        }

                    }
                }
                compCount++;
            }
            Textvalue.setValue(null);
            Spinvalue.setValue(null);
            Choicevalue.setValue(null);
            AdfFacesContext.getCurrentInstance().addPartialTarget(Textvalue);
            AdfFacesContext.getCurrentInstance().addPartialTarget(Spinvalue);
            AdfFacesContext.getCurrentInstance().addPartialTarget(Choicevalue);


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

    }

    public void setProdDesc(RichInputText prodDesc) {
        this.prodDesc = prodDesc;
    }

    public RichInputText getProdDesc() {
        return prodDesc;
    }

    public void setProductTable(RichTable productTable) {
        this.productTable = productTable;
    }

    public RichTable getProductTable() {
        return productTable;
    }

    public void setTableDesc(RichInputText tableDesc) {
        this.tableDesc = tableDesc;
    }

    public RichInputText getTableDesc() {
        return tableDesc;
    }

    public void setProductTab(RichPanelBox productTab) {
        this.productTab = productTab;
    }

    public RichPanelBox getProductTab() {
        return productTab;
    }

    public void setProductDetailsTab(RichPanelBox productDetailsTab) {
        this.productDetailsTab = productDetailsTab;
    }

    public RichPanelBox getProductDetailsTab() {
        return productDetailsTab;
    }

    public void setPrevButton(RichCommandButton prevButton) {
        this.prevButton = prevButton;
    }

    public RichCommandButton getPrevButton() {
        return prevButton;
    }

    public void setNextButton(RichCommandButton nextButton) {
        this.nextButton = nextButton;
    }

    public RichCommandButton getNextButton() {
        return nextButton;
    }

    public void setTableDescription1(RichOutputFormatted tableDescription1) {
        this.tableDescription1 = tableDescription1;
    }

    public RichOutputFormatted getTableDescription1() {
        return tableDescription1;
    }

    public void setProdDescription1(RichOutputFormatted prodDescription1) {
        this.prodDescription1 = prodDescription1;
    }

    public RichOutputFormatted getProdDescription1() {
        return prodDescription1;
    }

    public void setDynamicContainer(HtmlPanelGrid dynamicContainer) {
        this.dynamicContainer = dynamicContainer;
    }

    public HtmlPanelGrid getDynamicContainer() {
        return dynamicContainer;
    }

    public String parseTemplate(String oldValue) {
        // Add event code here...
        String value = null;
        Connection conn = null;
        try {
            conn = new DBConnector().getDatabaseConn();
            String query =
                "begin ? := lms_grp_misc.parseTemplate(?,?,?); end;";

            CallableStatement cstmt = conn.prepareCall(query);

            cstmt.registerOutParameter(1, OracleTypes.VARCHAR);
            cstmt.setString(2, oldValue);
            if (session.getAttribute("policyCode") != null) {
                cstmt.setBigDecimal(3,
                                    (BigDecimal)session.getAttribute("policyCode"));
                cstmt.setString(4, "U");
            } else {
                cstmt.setBigDecimal(3,
                                    (BigDecimal)session.getAttribute("QuoteCode"));
                cstmt.setString(4, "Q");
            }

            cstmt.execute();
            value = cstmt.getString(1);
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
            e.printStackTrace();
        }
        return value;
    }

}
