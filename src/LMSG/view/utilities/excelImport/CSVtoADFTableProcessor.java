package LMSG.view.utilities.excelImport;

import LMSG.view.Base.ADFUtils;
import LMSG.view.Base.GlobalCC;
import LMSG.view.Base.LOVCC;
import LMSG.view.Base.Rendering;
import LMSG.view.TableTypes.MembersImportation;
import LMSG.view.TableTypes.SDivMemImportation;
import LMSG.view.connect.DBConnector;
import LMSG.view.setups.ImportTemplateManip;
import com.Ostermiller.util.CSVParser;
import com.turnkey.setups.setupManipulation;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.sql.BatchUpdateException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichSelectItem;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.output.RichOutputLabel;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import org.apache.myfaces.trinidad.component.core.data.CoreColumn;
import org.apache.myfaces.trinidad.component.core.data.CoreTable;
import org.apache.myfaces.trinidad.component.core.output.CoreOutputText;
import org.apache.myfaces.trinidad.model.UploadedFile;

public class CSVtoADFTableProcessor
  extends LOVCC
{
  private CoreTable table;
  private List rows = new ArrayList();
  private boolean useFirstRowAsHeaders = false;
  private int numberOfColumns;
  private String templateType;
  private String RedirectPage = null;
  private RichTable importedMembers;
  private RichTable importedPrem;
  private RichTable importedPensMem;
  private HtmlPanelGrid dynamicContainer;
  private RichSelectOneChoice searchCriteria;
  private RichSelectOneChoice allPolicyBatches;
  private UploadedFile upFile;
  private RichTable exportMembers;
  HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  
  public void ProcessDynamicCSV(InputStream csvFile)
  {
    String[][] csvvalues = (String[][])null;
    
    Integer TotalColumns = Integer.valueOf(0);
    Integer ColumnCount = Integer.valueOf(0);
    Connection conn = new DBConnector().getDatabaseConn();
    try
    {
      this.session.setAttribute("DynamicData", null);
      
      String CountQuery = "SELECT COUNT(*) FROM USER_TAB_COLUMNS WHERE TABLE_NAME='LMS_PROD_IMP_TMPLT'";
      
      CallableStatement cst1 = null;
      cst1 = conn.prepareCall(CountQuery);
      ResultSet rs1 = cst1.executeQuery();
      while (rs1.next()) {
        TotalColumns = Integer.valueOf(rs1.getInt(1));
      }
      Integer ArraySize = Integer.valueOf(TotalColumns.intValue() / 4);
      
      float xFloat = ArraySize.intValue();
      
      String[] ProductColumns = new String[Math.round(xFloat)];
      cst1.close();
      
      String Query = "SELECT * FROM LMS_PROD_IMP_TMPLT WHERE LPIT_PROD_CODE = ?";
      
      CallableStatement cst = null;
      cst = conn.prepareCall(Query);
      cst.setBigDecimal(1, (BigDecimal)this.session.getAttribute("ProductCode"));
      
      ResultSet rs = cst.executeQuery();
      int iCount = 4;
      while (rs.next())
      {
        Integer localInteger1;
        while (iCount <= TotalColumns.intValue())
        {
          ProductColumns[ColumnCount.intValue()] = rs.getString(iCount);
          iCount += 4;
          localInteger1 = ColumnCount;Integer localInteger2 = ColumnCount = Integer.valueOf(ColumnCount.intValue() + 1);
        }
      }
      csvvalues = CSVParser.parse(new InputStreamReader(csvFile));
      this.dynamicContainer.getChildren().clear();
      for (int i = 0; i < 1; i++) {
        for (int j = 0; j < csvvalues[i].length; j++)
        {
          RichOutputLabel LabelName = new RichOutputLabel();
          LabelName.setId("DynLabel_" + j);
          LabelName.setValue("Column No. " + j);
          LabelName.setInlineStyle("font-weight:bold;");
          this.dynamicContainer.getChildren().add(LabelName);
          
          RichOutputText TextName = new RichOutputText();
          TextName.setId("DynText_" + j);
          TextName.setValue(csvvalues[i][j]);
          TextName.setInlineStyle("font-weight:bold;");
          this.dynamicContainer.getChildren().add(TextName);
          
          RichOutputText MiddleName = new RichOutputText();
          MiddleName.setId("DynText2_" + j);
          MiddleName.setValue("Maps Into   ");
          this.dynamicContainer.getChildren().add(MiddleName);
          
          RichSelectOneChoice ChoiceName = new RichSelectOneChoice();
          int k = 0;
          while (k < ProductColumns.length)
          {
            RichSelectItem ItemNames = new RichSelectItem();
            ItemNames.setId("SD_" + k + j);
            ItemNames.setLabel(ProductColumns[k]);
            ItemNames.setValue(ProductColumns[k]);
            ChoiceName.getChildren().add(ItemNames);
            k++;
          }
          ChoiceName.setId("SC_" + k + j);
          ChoiceName.setShortDesc(csvvalues[i][j]);
          ChoiceName.setValue(csvvalues[i][j]);
          this.dynamicContainer.getChildren().add(ChoiceName);
        }
      }
      this.session.setAttribute("DynamicData", csvvalues);
      

      GlobalCC.showPopup("lmsgroup:DynaPopup");
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
  }
  
  public String getMemberData()
  {
    int i = 0;
    if (this.exportMembers.getRowCount() == 0) {
      GlobalCC.sysInformation("No Members to Import!");
    } else {
      for (i = 0; i < this.exportMembers.getRowCount(); i++) {}
    }
    return null;
  }
  
  public String LoadDynamicCSV()
  {
    Connection conn = null;
    Integer TotalColumns = Integer.valueOf(0);
    String[][] MandatoryColumns = (String[][])null;
    Integer ColumnCount = Integer.valueOf(0);
    String ParameterColumns = null;
    String Parameters = null;
    String[][] csvvalues = (String[][])null;
    boolean firstValue = false;
    String ProductType = null;
    boolean addBatch = false;
    boolean executeQuery = false;
    try
    {
      conn = new DBConnector().getDatabaseConn();
      

      String CountQuery = "SELECT COUNT(*) FROM USER_TAB_COLUMNS WHERE TABLE_NAME='LMS_PROD_IMP_TMPLT'";
      
      CallableStatement cst1 = null;
      cst1 = conn.prepareCall(CountQuery);
      ResultSet rs1 = cst1.executeQuery();
      while (rs1.next()) {
        TotalColumns = Integer.valueOf(rs1.getInt(1));
      }
      cst1.close();
      rs1.close();
      Integer ArraySize = Integer.valueOf(TotalColumns.intValue() / 4);
      
      float xFloat = ArraySize.intValue();
      
      MandatoryColumns = new String[Math.round(xFloat)][5];
      

      String Query = "SELECT * FROM LMS_PROD_IMP_TMPLT WHERE LPIT_PROD_CODE = ?";
      
      CallableStatement cst = null;
      cst = conn.prepareCall(Query);
      cst.setBigDecimal(1, (BigDecimal)this.session.getAttribute("ProductCode"));
      
      ResultSet rs = cst.executeQuery();
      int iCount = 4;
      while (rs.next())
      {
        ProductType = rs.getString(3);
        Integer localInteger1;
        Integer localInteger2;
        for (; iCount <= TotalColumns.intValue(); localInteger2 = ColumnCount = Integer.valueOf(ColumnCount.intValue() + 1))
        {
          MandatoryColumns[ColumnCount.intValue()][0] = rs.getString(iCount);
          
          MandatoryColumns[ColumnCount.intValue()][1] = rs.getString(iCount + 2);
          
          MandatoryColumns[ColumnCount.intValue()][2] = rs.getString(iCount + 3);
          

          iCount += 4;
          localInteger1 = ColumnCount;
        }
      }
      rs.close();
      
      int comp = 0;
      int position = 0;
      while (comp < this.dynamicContainer.getChildCount())
      {
        UIComponent mine = (UIComponent)this.dynamicContainer.getChildren().get(comp);
        String ComponentID = mine.getId();
        if (ComponentID != null) {
          if (ComponentID.contains("SC_"))
          {
            RichSelectOneChoice value = (RichSelectOneChoice)mine;
            if (value.getValue() == null)
            {
              GlobalCC.sysInformation("Select A Value for the Item " + value.getShortDesc());
              
              return null;
            }
            int myCount = 0;
            position += 1;
            while (myCount < MandatoryColumns.length)
            {
              String Value = MandatoryColumns[myCount][0];
              if (Value != null) {
                if (Value.equalsIgnoreCase(value.getValue().toString()))
                {
                  MandatoryColumns[myCount][3] = value.getShortDesc().toString();
                  
                  MandatoryColumns[myCount][4] = Integer.toString(position);
                }
              }
              myCount++;
            }
          }
        }
        comp++;
      }
      CallableStatement inst = null;
      CallableStatement seq = null;
      String seleSeq = "SELECT LMS_MEM_IMP_TRANS_SEQ.NEXTVAL FROM DUAL";
      seq = conn.prepareCall(seleSeq);
      ResultSet rst = seq.executeQuery();
      this.session.setAttribute("templateTranSeq", Integer.valueOf(0));
      while (rst.next()) {
        this.session.setAttribute("templateTranSeq", Integer.valueOf(rst.getInt(1)));
      }
      rst.close();
      String insertQuery = "INSERT INTO LMS_MEMBER_IMPORT_TRANS VALUES (?,?,?,?,?,?,?,?,?)";
      
      inst = conn.prepareCall(insertQuery);
      inst.setInt(1, ((Integer)this.session.getAttribute("templateTranSeq")).intValue());
      Date now = new Date();
      inst.setString(2, LOVCC.parseDate(now.toString()));
      inst.setString(3, (String)this.session.getAttribute("Username"));
      inst.setString(4, ProductType);
      inst.setBigDecimal(5, (BigDecimal)this.session.getAttribute("policyCode"));
      
      inst.setString(6, null);
      inst.setString(7, null);
      inst.setString(8, null);
      inst.setString(9, null);
      
      inst.execute();
      inst.close();
      
      int test = 0;
      CallableStatement cstImp = null;
      
      String importQuery = null;
      

      csvvalues = (String[][])this.session.getAttribute("DynamicData");
      for (int i = 0; i < csvvalues.length; i++)
      {
        int Cnt1 = 0;
        for (int j = 0; j < csvvalues[i].length; j++) {
          if (i == 0)
          {
            ParameterColumns = null;
            Parameters = null;
            int Cnt = 0;
            while ((test < MandatoryColumns.length) && 
              (MandatoryColumns.length != Cnt))
            {
              Integer Result = GlobalCC.CheckNullExcelValues(csvvalues[i][Cnt]);
              if (Result.intValue() != 0) {
                if (MandatoryColumns[test][3].equalsIgnoreCase(csvvalues[i][Cnt]))
                {
                  Cnt++;
                  if (!firstValue)
                  {
                    ParameterColumns = MandatoryColumns[test][1];
                    
                    Parameters = "?";
                    firstValue = true;
                  }
                  else if (Cnt + 1 >= MandatoryColumns.length)
                  {
                    if (ParameterColumns == null) {
                      ParameterColumns = MandatoryColumns[test][1];
                    } else {
                      ParameterColumns = ParameterColumns + "," + MandatoryColumns[test][1];
                    }
                    if (Parameters == null) {
                      Parameters = "?";
                    } else {
                      Parameters = Parameters + ",?";
                    }
                  }
                  else
                  {
                    if (ParameterColumns == null) {
                      ParameterColumns = MandatoryColumns[test][1];
                    } else {
                      ParameterColumns = ParameterColumns + "," + MandatoryColumns[test][1];
                    }
                    if (Parameters == null) {
                      Parameters = "?";
                    } else {
                      Parameters = Parameters + ",?";
                    }
                  }
                  test = -1;
                }
              }
              test++;
            }
            System.out.print(ParameterColumns);
            System.out.print(Parameters);
            
            String TemplateID = Integer.toString(((Integer)this.session.getAttribute("templateTranSeq")).intValue());
            

            importQuery = "INSERT INTO LMS_MEMBER_IMPORT_DETAILS(LMID_CODE,LMID_LMIT_CODE," + ParameterColumns + ") VALUES (LMS_MEM_IMP_DETAIL_SEQ.NEXTVAL," + TemplateID + "," + Parameters + ")";
            



            cstImp = conn.prepareCall(importQuery);
          }
          else
          {
            while ((test < MandatoryColumns.length) && 
              (MandatoryColumns.length != Cnt1))
            {
              Integer Result = GlobalCC.CheckNullExcelValues(csvvalues[0][Cnt1]);
              if (Result.intValue() != 0) {
                if (MandatoryColumns[test][3].equalsIgnoreCase(csvvalues[0][Cnt1]))
                {
                  Cnt1++;
                  cstImp.setString(MandatoryColumns[test][4], csvvalues[i][j]);
                  
                  addBatch = true;
                  test = 0;
                  break;
                }
              }
              test++;
            }
          }
        }
        if (addBatch == true)
        {
          cstImp.addBatch();
          addBatch = false;
          executeQuery = true;
        }
      }
      if (executeQuery == true)
      {
        cstImp.executeBatch();
        cstImp.close();
        
        String Module = (String)this.session.getAttribute("UW");
        if (Module.equalsIgnoreCase("U"))
        {
          ADFUtils.findIterator("findPolicyImportBatchesIter").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.allPolicyBatches);
          
          ValidatePolicyData();
          GlobalCC.hidePopup("lmsgroup:DynaPopup");
        }
        else
        {
          String Return = ImportQuotation();
          if (Return.equalsIgnoreCase("S")) {
            GlobalCC.sysInformation("Member Successfully Imported");
          }
        }
      }
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
  
  public Integer CreateMemberSequence()
  {
    Connection conn = null;
    Integer Sequence = Integer.valueOf(0);
    try
    {
      conn = new DBConnector().getDatabaseConn();
      

      CallableStatement seq = null;
      String seleSeq = "SELECT LMS_MEM_IMP_DETAIL_SEQ.NEXTVAL FROM DUAL";
      seq = conn.prepareCall(seleSeq);
      ResultSet rsSeq = seq.executeQuery();
      Sequence = Integer.valueOf(0);
      while (rsSeq.next()) {
        Sequence = Integer.valueOf(rsSeq.getInt(1));
      }
      rsSeq.close();
      seq.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return Sequence;
  }
  
  public void processCSVNewImplementation(InputStream csvFile)
  {
    Connection conn = null;
    Rendering render = new Rendering();
    try
    {
      boolean addBatch = false;
      String[][] csvvalues = (String[][])null;
      String[][] ColumnValues = (String[][])null;
      String[][] DivisionValues = (String[][])null;
      int DivCnt = 5;
      int FinalPosition = 0;
      String Params = null;
      String ParamValues = null;
      String DivParams = null;
      String DivParamValues = null;
      String FullParameters = null;
      String FullDivParameters = null;
      String ProductType = null;
      String SystemPoint = (String)this.session.getAttribute("SystemPoint");
      
      int MemberSequence = 0;
      
      conn = new DBConnector().getDatabaseConn();
      
      List ReinstInfo = new LinkedList();
      ARRAY array = null;
      
      ArrayDescriptor descriptor = ArrayDescriptor.createDescriptor("LMS_GRP_MEM_IMPORT_TAB", conn);
      


      List SDivInfo = new LinkedList();
      ARRAY SDarray = null;
      
      ArrayDescriptor SDdescriptor = ArrayDescriptor.createDescriptor("LMS_GRP_MEM_SDIV_IMPORT_TAB", conn);
      


      ImportTemplateManip ImportClass = new ImportTemplateManip();
      Integer TotalColumns = ImportClass.ValidateTableName("LMS_PROD_IMP_TMPLT");
      
      Integer ArraySize = TotalColumns;
      
      float xFloat = ArraySize.intValue();
      ColumnValues = new String[Math.round(xFloat)][5];
      
      float xFloatDiv = DivCnt;
      DivisionValues = new String[Math.round(xFloatDiv)][5];
      
      String Query = "SELECT * FROM LMS_PROD_IMP_TMPLT WHERE LPIT_PROD_CODE = ?";
      
      CallableStatement cst = null;
      cst = conn.prepareCall(Query);
      cst.setBigDecimal(1, (BigDecimal)this.session.getAttribute("ProductCode"));
      
      ResultSet rs = cst.executeQuery();
      int iCount = 6;
      while (rs.next()) {
        while (iCount <= TotalColumns.intValue())
        {
          if (rs.getString(iCount) != null)
          {
            int Position = rs.getInt(iCount - 1);
            ColumnValues[(Position - 1)][0] = rs.getString(iCount);
            ColumnValues[(Position - 1)][1] = rs.getString(iCount - 2);
            
            FinalPosition++;
          }
          iCount += 3;
        }
      }
      rs.close();
      cst.close();
      if (SystemPoint.equalsIgnoreCase("U"))
      {
        String QueryDiv = "SELECT DISTINCT GSUB_DESC, GSUB_CODE, GSUB_SHT_DESC FROM LMS_POLICY_GRP_SUBDIVISIONS, LMS_GRP_SUBDIVISIONS \nWHERE PGSUB_GSUB_CODE = GSUB_CODE AND PGSUB_ENDR_CODE = ?";
        

        CallableStatement cstDiv = null;
        cstDiv = conn.prepareCall(QueryDiv);
        cstDiv.setBigDecimal(1, (BigDecimal)this.session.getAttribute("endorsementCode"));
        
        ResultSet rsDiv = cstDiv.executeQuery();
        int Counter = 0;
        while (rsDiv.next())
        {
          DivisionValues[Counter][0] = rsDiv.getString(1);
          DivisionValues[Counter][1] = rsDiv.getString(2);
          DivisionValues[Counter][2] = rsDiv.getString(1);
          Counter++;
        }
        rsDiv.close();
        cstDiv.close();
      }
      else
      {
        String QueryDiv = "SELECT DISTINCT GSUB_DESC, GSUB_CODE, GSUB_SHT_DESC FROM LMS_QUOTE_GRP_SUBDIVISIONS, LMS_GRP_SUBDIVISIONS \nWHERE QGSUB_GSUB_CODE = GSUB_CODE AND QGSUB_QUO_CODE = ?";
        

        CallableStatement cstDiv = null;
        cstDiv = conn.prepareCall(QueryDiv);
        cstDiv.setBigDecimal(1, (BigDecimal)this.session.getAttribute("QuoteCode"));
        
        ResultSet rsDiv = cstDiv.executeQuery();
        int Counter = 0;
        while (rsDiv.next())
        {
          DivisionValues[Counter][0] = rsDiv.getString(1);
          DivisionValues[Counter][1] = rsDiv.getString(2);
          DivisionValues[Counter][2] = rsDiv.getString(1);
          Counter++;
        }
        rsDiv.close();
        cstDiv.close();
      }
      CallableStatement seq = null;
      String seleSeq = "SELECT LMS_MEM_IMP_TRANS_SEQ.NEXTVAL FROM DUAL";
      seq = conn.prepareCall(seleSeq);
      ResultSet rsSeq = seq.executeQuery();
      this.session.setAttribute("templateTranSeq", Integer.valueOf(0));
      while (rsSeq.next()) {
        this.session.setAttribute("templateTranSeq", Integer.valueOf(rsSeq.getInt(1)));
      }
      rsSeq.close();
      seq.close();
      String insertQuery = "INSERT INTO LMS_MEMBER_IMPORT_TRANS VALUES (?,?,?,?,?,?,?,?,?,?)";
      
      CallableStatement inst = conn.prepareCall(insertQuery);
      

      csvvalues = CSVParser.parse(new InputStreamReader(csvFile));
      
      System.out.println("csvvalues.length=" + csvvalues.length);
      for (int i = 0; i < csvvalues.length; i++)
      {
        if (i == 3)
        {
          int myCount = 0;
          while (myCount < ColumnValues.length)
          {
            String Value = ColumnValues[myCount][0];
            System.out.println("Value=" + Value);
            if ((Value != null) && 
              (ColumnValues[myCount][1].toString().trim().equalsIgnoreCase(csvvalues[i][myCount].toString().trim()))) {
              if (Params == null) {
                Params = "LMID_CODE, LMID_LMIT_CODE," + ColumnValues[myCount][0] + ",";
              } else {
                Params = Params + ColumnValues[myCount][0] + ",";
              }
            }
            myCount++;
          }
          FullParameters = Params.substring(0, Params.length() - 1);
        }
        for (int j = 0; j < csvvalues[i].length; j++)
        {
          if ((i == 0) && (j == 0))
          {
            ProductType = csvvalues[i][j];
            
            inst.setInt(1, ((Integer)this.session.getAttribute("templateTranSeq")).intValue());
            
            Date now = new Date();
            inst.setString(2, LOVCC.parseDate(now.toString()));
            inst.setString(3, (String)this.session.getAttribute("Username"));
            
            inst.setString(4, ProductType);
            inst.setBigDecimal(5, (BigDecimal)this.session.getAttribute("policyCode"));
            
            inst.setBigDecimal(6, (BigDecimal)this.session.getAttribute("QuoteCode"));
            
            inst.setString(7, null);
            inst.setString(8, null);
            inst.setString(9, null);
            inst.setString(10, null);
            
            inst.execute();
            inst.close();
          }
          if ((i > 3) && 
            (GlobalCC.CheckNullExcelValues(csvvalues[3][j]).intValue() > 0)) {
            if (j < FinalPosition)
            {
              if (GlobalCC.CheckNullExcelValues(csvvalues[i][j]).intValue() > 0)
              {
                if (j == 0)
                {
                  int Sequence = ((Integer)this.session.getAttribute("templateTranSeq")).intValue();
                  
                  MemberSequence = 0;
                  MemberSequence = CreateMemberSequence().intValue();
                  
                  ParamValues = Integer.toString(MemberSequence) + "," + Integer.toString(Sequence) + "," + "'" + csvvalues[i][j].replaceAll("'", "") + "'" + ",";
                }
                else
                {
                  ParamValues = ParamValues + "'" + csvvalues[i][j].replaceAll("'", "") + "'" + ",";
                }
              }
              else if (j == 0)
              {
                int Sequence = ((Integer)this.session.getAttribute("templateTranSeq")).intValue();
                
                MemberSequence = CreateMemberSequence().intValue();
                
                ParamValues = Integer.toString(MemberSequence) + "," + Integer.toString(Sequence) + "," + "'" + csvvalues[i][j].replaceAll("'", "") + "'" + ",";
              }
              else
              {
                ParamValues = ParamValues + "'" + csvvalues[i][j].replaceAll("'", "") + "'" + ",";
              }
              addBatch = true;
            }
            else if (GlobalCC.CheckNullExcelValues(csvvalues[i][j]).intValue() > 0)
            {
              int myDivCount = 0;
              SDivMemImportation SD = new SDivMemImportation();
              while (myDivCount < DivisionValues.length)
              {
                String Value = DivisionValues[myDivCount][0];
                if ((Value != null) && 
                  (DivisionValues[myDivCount][0].toString().equalsIgnoreCase(csvvalues[3][j].toString())))
                {
                  DivParams = DivisionValues[myDivCount][1] + "," + csvvalues[i][j] + ",";
                  



                  String FullDivParamValues = DivParams.substring(0, DivParams.length() - 1);
                  


                  SD.setLMIS_LMIT_CODE((Integer)this.session.getAttribute("templateTranSeq"));
                  SD.setLMIS_LMID_CODE(Integer.valueOf(MemberSequence));
                  SD.setLMIS_GSUB_CODE(new Integer(DivisionValues[myDivCount][1]));
                  SD.setLMIS_GSUB_SHT_DESC(DivisionValues[myDivCount][2]);
                  SD.setSDPARAMETER_VALS(csvvalues[i][j]);
                  SDivInfo.add(SD);
                }
                myDivCount++;
              }
            }
          }
        }
        if (addBatch == true)
        {
          String FullParamValues = ParamValues.substring(0, ParamValues.length() - 1);
          

          String FinalStatement = "";
          if ((render.isExpressVisible()) && (this.session.getAttribute("productType").equals("FUNE")))
          {
            FullParameters = FullParameters.replace("LMID_CODE", "GMID_CODE").replace("LMID_LMIT_CODE", "GMID_LMIT_CODE");
            
            FinalStatement = "INSERT INTO LMS_GRP_MEM_IMPORT_DETAILS(" + FullParameters + ") VALUES (" + FullParamValues + ")";
          }
          else
          {
            FinalStatement = "INSERT INTO LMS_MEMBER_IMPORT_DETAILS(" + FullParameters + ") VALUES (" + FullParamValues + ")";
          }
          System.out.println( i+" Final Statement " + FinalStatement);
          
          MembersImportation pn = new MembersImportation();
          pn.setLMID_LMIT_CODE((Integer)this.session.getAttribute("templateTranSeq"));
          pn.setPARAMETER_VALS(FinalStatement);
          ReinstInfo.add(pn);
          addBatch = false;
        }
      }
      array = new ARRAY(descriptor, conn, ReinstInfo.toArray());
      SDarray = new ARRAY(SDdescriptor, conn, SDivInfo.toArray());
      CallableStatement cstMain = null;
      
      String MainQuery = "begin LMS_WEB_PKG_GRP_UW.Dynamic_Member_Inserts(?,?);end;";
      
      cstMain = conn.prepareCall(MainQuery);
      cstMain.setArray(1, array);
      cstMain.setArray(2, SDarray);
      cstMain.execute();
      cstMain.close();
      conn.close();
      if ((render.isExpressVisible()) && (this.session.getAttribute("productType").equals("FUNE"))) {
        importExpressFuneral(SystemPoint);
      }
      if (SystemPoint.equalsIgnoreCase("U"))
      {
        ADFUtils.findIterator("findPolicyImportBatchesIter").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.allPolicyBatches);
        ValidatePolicyData();
      }
      else
      {
        ADFUtils.findIterator("findPolicyImportBatchesIter").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.allPolicyBatches);
        
        ValidateQuoteData();
      }
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
      e.printStackTrace();
    }
  }
  
  public void processCSVNewImplementation(UploadedFile uFile)
  {
    Connection conn = null;
    try
    {
      boolean addBatch = false;
      String[][] csvvalues = (String[][])null;
      String[][] ColumnValues = (String[][])null;
      String[][] DivisionValues = (String[][])null;
      int DivCnt = 5;
      int FinalPosition = 0;
      String Params = null;
      String ParamValues = null;
      String DivParams = null;
      String DivParamValues = null;
      String FullParameters = null;
      String FullDivParameters = null;
      String ProductType = null;
      String SystemPoint = (String)this.session.getAttribute("SystemPoint");
      

      int MemberSequence = 0;
      int chunkSize = 1048576;
      InputStream in = null;
      File fin = null;
      
      conn = new DBConnector().getDatabaseConn();
      
      List ReinstInfo = new LinkedList();
      ARRAY array = null;
      
      ArrayDescriptor descriptor = ArrayDescriptor.createDescriptor("LMS_GRP_MEM_IMPORT_TAB", conn);
      


      List SDivInfo = new LinkedList();
      ARRAY SDarray = null;
      
      ArrayDescriptor SDdescriptor = ArrayDescriptor.createDescriptor("LMS_GRP_MEM_SDIV_IMPORT_TAB", conn);
      


      ImportTemplateManip ImportClass = new ImportTemplateManip();
      Integer TotalColumns = ImportClass.ValidateTableName("LMS_PROD_IMP_TMPLT");
      
      Integer ArraySize = TotalColumns;
      
      float xFloat = ArraySize.intValue();
      ColumnValues = new String[Math.round(xFloat)][5];
      
      float xFloatDiv = DivCnt;
      DivisionValues = new String[Math.round(xFloatDiv)][5];
      
      String Query = "SELECT * FROM LMS_PROD_IMP_TMPLT WHERE LPIT_PROD_CODE = ?";
      
      CallableStatement cst = null;
      cst = conn.prepareCall(Query);
      cst.setBigDecimal(1, (BigDecimal)this.session.getAttribute("ProductCode"));
      
      ResultSet rs = cst.executeQuery();
      int iCount = 6;
      while (rs.next()) {
        while (iCount <= TotalColumns.intValue())
        {
          if (rs.getString(iCount) != null)
          {
            int Position = rs.getInt(iCount - 1);
            ColumnValues[(Position - 1)][0] = rs.getString(iCount);
            ColumnValues[(Position - 1)][1] = rs.getString(iCount - 2);
            
            FinalPosition++;
          }
          iCount += 3;
        }
      }
      rs.close();
      cst.close();
      if (SystemPoint.equalsIgnoreCase("U"))
      {
        String QueryDiv = "SELECT DISTINCT GSUB_DESC, GSUB_CODE, GSUB_SHT_DESC FROM LMS_POLICY_GRP_SUBDIVISIONS, LMS_GRP_SUBDIVISIONS \nWHERE PGSUB_GSUB_CODE = GSUB_CODE AND PGSUB_ENDR_CODE = ?";
        

        CallableStatement cstDiv = null;
        cstDiv = conn.prepareCall(QueryDiv);
        cstDiv.setBigDecimal(1, (BigDecimal)this.session.getAttribute("endorsementCode"));
        
        ResultSet rsDiv = cstDiv.executeQuery();
        int Counter = 0;
        while (rsDiv.next())
        {
          DivisionValues[Counter][0] = rsDiv.getString(1);
          DivisionValues[Counter][1] = rsDiv.getString(2);
          DivisionValues[Counter][2] = rsDiv.getString(1);
          Counter++;
        }
        rsDiv.close();
        cstDiv.close();
      }
      else
      {
        String QueryDiv = "SELECT DISTINCT GSUB_DESC, GSUB_CODE, GSUB_SHT_DESC FROM LMS_QUOTE_GRP_SUBDIVISIONS, LMS_GRP_SUBDIVISIONS \nWHERE QGSUB_GSUB_CODE = GSUB_CODE AND QGSUB_QUO_CODE = ?";
        

        CallableStatement cstDiv = null;
        cstDiv = conn.prepareCall(QueryDiv);
        cstDiv.setBigDecimal(1, (BigDecimal)this.session.getAttribute("QuoteCode"));
        
        ResultSet rsDiv = cstDiv.executeQuery();
        int Counter = 0;
        while (rsDiv.next())
        {
          DivisionValues[Counter][0] = rsDiv.getString(1);
          DivisionValues[Counter][1] = rsDiv.getString(2);
          DivisionValues[Counter][2] = rsDiv.getString(1);
          Counter++;
        }
        rsDiv.close();
        cstDiv.close();
      }
      CallableStatement seq = null;
      String seleSeq = "SELECT LMS_MEM_IMP_TRANS_SEQ.NEXTVAL FROM DUAL";
      seq = conn.prepareCall(seleSeq);
      ResultSet rsSeq = seq.executeQuery();
      this.session.setAttribute("templateTranSeq", Integer.valueOf(0));
      while (rsSeq.next()) {
        this.session.setAttribute("templateTranSeq", Integer.valueOf(rsSeq.getInt(1)));
      }
      rsSeq.close();
      seq.close();
      String insertQuery = "INSERT INTO LMS_MEMBER_IMPORT_TRANS VALUES (?,?,?,?,?,?,?,?,?,?)";
      
      CallableStatement inst = conn.prepareCall(insertQuery);
      
      ArrayList<String> filePaths = new FileProcessor().readAndFragment("D://EXPRESS/FAMILY_CARE.csv", 1048576);
      CallableStatement cstMain = null;
      for (int dataFile = 0; dataFile < filePaths.size(); dataFile++)
      {
        fin = new File((String)filePaths.get(dataFile));
        in = new FileInputStream(fin);
        csvvalues = CSVParser.parse(new InputStreamReader(in));
        System.out.println("csvvalues.length=" + csvvalues.length);
        for (int i = 0; i < csvvalues.length; i++)
        {
          if ((dataFile == 0) && 
            (i == 3))
          {
            int myCount = 0;
            while (myCount < ColumnValues.length)
            {
              String Value = ColumnValues[myCount][0];
              System.out.println("Value=" + Value);
              if ((Value != null) && 
                (ColumnValues[myCount][1].toString().trim().equalsIgnoreCase(csvvalues[i][myCount].toString().trim()))) {
                if (Params == null) {
                  Params = "LMID_CODE, LMID_LMIT_CODE," + ColumnValues[myCount][0] + ",";
                } else {
                  Params = Params + ColumnValues[myCount][0] + ",";
                }
              }
              myCount++;
            }
            FullParameters = Params.substring(0, Params.length() - 1);
          }
          for (int j = 0; j < csvvalues[i].length; j++) {
            if (dataFile == 0)
            {
              if ((i == 0) && (j == 0))
              {
                ProductType = csvvalues[i][j];
                
                inst.setInt(1, ((Integer)this.session.getAttribute("templateTranSeq")).intValue());
                
                Date now = new Date();
                inst.setString(2, LOVCC.parseDate(now.toString()));
                inst.setString(3, (String)this.session.getAttribute("Username"));
                
                inst.setString(4, ProductType);
                inst.setBigDecimal(5, (BigDecimal)this.session.getAttribute("policyCode"));
                
                inst.setBigDecimal(6, (BigDecimal)this.session.getAttribute("QuoteCode"));
                
                inst.setString(7, null);
                inst.setString(8, null);
                inst.setString(9, null);
                inst.setString(10, null);
                
                inst.execute();
                inst.close();
              }
              if ((i > 3) && 
                (GlobalCC.CheckNullExcelValues(csvvalues[3][j]).intValue() > 0)) {
                if (j < FinalPosition)
                {
                  if (GlobalCC.CheckNullExcelValues(csvvalues[i][j]).intValue() > 0)
                  {
                    if (j == 0)
                    {
                      int Sequence = ((Integer)this.session.getAttribute("templateTranSeq")).intValue();
                      
                      MemberSequence = 0;
                      MemberSequence = CreateMemberSequence().intValue();
                      
                      ParamValues = Integer.toString(MemberSequence) + "," + Integer.toString(Sequence) + "," + "'" + csvvalues[i][j] + "'" + ",";
                    }
                    else
                    {
                      ParamValues = ParamValues + "'" + csvvalues[i][j] + "'" + ",";
                    }
                  }
                  else if (j == 0)
                  {
                    int Sequence = ((Integer)this.session.getAttribute("templateTranSeq")).intValue();
                    
                    MemberSequence = CreateMemberSequence().intValue();
                    
                    ParamValues = Integer.toString(MemberSequence) + "," + Integer.toString(Sequence) + "," + "'" + csvvalues[i][j] + "'" + ",";
                  }
                  else
                  {
                    ParamValues = ParamValues + "'" + csvvalues[i][j] + "'" + ",";
                  }
                  addBatch = true;
                }
                else if (GlobalCC.CheckNullExcelValues(csvvalues[i][j]).intValue() > 0)
                {
                  int myDivCount = 0;
                  SDivMemImportation SD = new SDivMemImportation();
                  while (myDivCount < DivisionValues.length)
                  {
                    String Value = DivisionValues[myDivCount][0];
                    if ((Value != null) && 
                      (DivisionValues[myDivCount][0].toString().equalsIgnoreCase(csvvalues[3][j].toString())))
                    {
                      DivParams = DivisionValues[myDivCount][1] + "," + csvvalues[i][j] + ",";
                      



                      String FullDivParamValues = DivParams.substring(0, DivParams.length() - 1);
                      


                      SD.setLMIS_LMIT_CODE((Integer)this.session.getAttribute("templateTranSeq"));
                      SD.setLMIS_LMID_CODE(Integer.valueOf(MemberSequence));
                      SD.setLMIS_GSUB_CODE(new Integer(DivisionValues[myDivCount][1]));
                      SD.setLMIS_GSUB_SHT_DESC(DivisionValues[myDivCount][2]);
                      SD.setSDPARAMETER_VALS(csvvalues[i][j]);
                      SDivInfo.add(SD);
                    }
                    myDivCount++;
                  }
                }
              }
            }
          }
          if (addBatch == true)
          {
            String FullParamValues = ParamValues.substring(0, ParamValues.length() - 1);
            

            String FinalStatement = "INSERT INTO LMS_MEMBER_IMPORT_DETAILS(" + FullParameters + ") VALUES (" + FullParamValues + ")";
            


            System.out.println("Final Statement " + FinalStatement);
            
            MembersImportation pn = new MembersImportation();
            pn.setLMID_LMIT_CODE((Integer)this.session.getAttribute("templateTranSeq"));
            pn.setPARAMETER_VALS(FinalStatement);
            ReinstInfo.add(pn);
            addBatch = false;
          }
        }
        array = new ARRAY(descriptor, conn, ReinstInfo.toArray());
        SDarray = new ARRAY(SDdescriptor, conn, SDivInfo.toArray());
        
        String MainQuery = "begin LMS_WEB_PKG_GRP_UW.Dynamic_Member_Inserts(?,?);end;";
        
        cstMain = conn.prepareCall(MainQuery);
        cstMain.setArray(1, array);
        cstMain.setArray(2, SDarray);
        cstMain.execute();
      }
      cstMain.close();
      conn.close();
      filePaths.clear();
      in.close();
      if (SystemPoint.equalsIgnoreCase("U"))
      {
        ADFUtils.findIterator("findPolicyImportBatchesIter").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.allPolicyBatches);
        
        ValidatePolicyData();
      }
      else
      {
        ADFUtils.findIterator("findPolicyImportBatchesIter").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.allPolicyBatches);
        
        ValidateQuoteData();
      }
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
      e.printStackTrace();
    }
  }
  
  public void processCSV(InputStream csvFile)
  {
    boolean addBatch = false;
    String[][] csvvalues = (String[][])null;
    try
    {
      Connection conn = new DBConnector().getDatabaseConn();
      
      CallableStatement cst = null;
      CallableStatement inst = null;
      CallableStatement seq = null;
      String seleSeq = "SELECT LMS_MEM_IMP_TRANS_SEQ.NEXTVAL FROM DUAL";
      seq = conn.prepareCall(seleSeq);
      ResultSet rs = seq.executeQuery();
      this.session.setAttribute("templateTranSeq", Integer.valueOf(0));
      while (rs.next()) {
        this.session.setAttribute("templateTranSeq", Integer.valueOf(rs.getInt(1)));
      }
      String insertQuery = "INSERT INTO LMS_MEMBER_IMPORT_TRANS VALUES (?,?,?,?,?,?,?,?,?,?)";
      
      inst = conn.prepareCall(insertQuery);
      String importQuery = "INSERT INTO LMS_MEMBER_IMPORT_DETAILS VALUES (LMS_MEM_IMP_DETAIL_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      

      cst = conn.prepareCall(importQuery);
      
      csvvalues = CSVParser.parse(new InputStreamReader(csvFile));
      
      this.rows = new ArrayList();
      
      this.numberOfColumns = 0;
      for (int i = 0; i < csvvalues.length; i++)
      {
        Map tablerow = new HashMap();
        if (i == 0) {
          for (int j = 0; j < csvvalues[i].length; j++)
          {
            if (j > this.numberOfColumns) {
              this.numberOfColumns = j;
            }
            tablerow.put("cell" + (j + 1), csvvalues[i][j]);
            if ((i == 0) && (j == 0))
            {
              this.templateType = csvvalues[i][j];
              if (this.templateType == null) {
                this.session.setAttribute("templayeTypeInt", Integer.valueOf(0));
              } else if (this.templateType.equalsIgnoreCase("")) {
                this.session.setAttribute("templayeTypeInt", Integer.valueOf(0));
              } else if (this.templateType.equalsIgnoreCase("EARN")) {
                this.session.setAttribute("templayeTypeInt", Integer.valueOf(1));
              } else if (this.templateType.equalsIgnoreCase("FUNE")) {
                this.session.setAttribute("templayeTypeInt", Integer.valueOf(2));
              } else if (this.templateType.equalsIgnoreCase("LOAN")) {
                this.session.setAttribute("templayeTypeInt", Integer.valueOf(3));
              } else if (this.templateType.equalsIgnoreCase("PENS")) {
                this.session.setAttribute("templayeTypeInt", Integer.valueOf(4));
              } else if (this.templateType.equalsIgnoreCase("ANN")) {
                this.session.setAttribute("templayeTypeInt", Integer.valueOf(5));
              } else if (this.templateType.equalsIgnoreCase("GRAT")) {
                this.session.setAttribute("templayeTypeInt", Integer.valueOf(4));
              } else if (this.templateType.equalsIgnoreCase("EDUC")) {
                this.session.setAttribute("templayeTypeInt", Integer.valueOf(6));
              } else if (this.templateType.equalsIgnoreCase("LVLT")) {
                this.session.setAttribute("templayeTypeInt", Integer.valueOf(7));
              }
              inst.setInt(1, ((Integer)this.session.getAttribute("templateTranSeq")).intValue());
              
              Date now = new Date();
              
              inst.setString(2, LOVCC.parseDate(now.toString()));
              inst.setString(3, (String)this.session.getAttribute("Username"));
              
              inst.setString(4, this.templateType);
              inst.setBigDecimal(5, (BigDecimal)this.session.getAttribute("policyCode"));
              
              inst.setBigDecimal(6, (BigDecimal)this.session.getAttribute("QuoteCode"));
              
              inst.setString(7, null);
              inst.setString(8, null);
              inst.setString(9, null);
              inst.setString(10, null);
              
              inst.execute();
            }
          }
        }
        if (i >= 4)
        {
          Integer NullValue = GlobalCC.CheckNullExcelValues(csvvalues[i][0]);
          if (NullValue.intValue() != 0)
          {
            Integer TempType = (Integer)this.session.getAttribute("templayeTypeInt");
            switch (TempType.intValue())
            {
            case 0: 
              break;
            case 1: 
              if (i < csvvalues.length)
              {
                cst.setInt(1, ((Integer)this.session.getAttribute("templateTranSeq")).intValue());
                
                cst.setString(2, csvvalues[i][0]);
                cst.setString(3, csvvalues[i][1]);
                cst.setString(4, csvvalues[i][2]);
                cst.setString(5, csvvalues[i][3]);
                String Result = GlobalCC.parseDateAuthFormat(csvvalues[i][4]);
                if (Result.equalsIgnoreCase("Invalid Date Format"))
                {
                  GlobalCC.errorValueNotEntered("Invalid Date Format " + csvvalues[i][4] + " for Member No " + csvvalues[i][0] + " And Member Name " + csvvalues[i][3] + " " + csvvalues[i][2] + ". The Valid Date Format is DD-MMM-YYYY");
                  







                  return;
                }
                cst.setString(6, csvvalues[i][4]);
                cst.setString(7, csvvalues[i][5]);
                cst.setString(8, csvvalues[i][6]);
                cst.setString(9, csvvalues[i][7]);
                cst.setString(10, csvvalues[i][8]);
                cst.setString(11, csvvalues[i][9]);
                cst.setString(12, csvvalues[i][14]);
                cst.setString(13, csvvalues[i][15]);
                cst.setString(14, csvvalues[i][16]);
                
                cst.setString(15, null);
                cst.setString(16, null);
                cst.setString(17, null);
                cst.setString(18, null);
                cst.setString(19, null);
                cst.setString(20, null);
                cst.setString(21, null);
                cst.setString(22, null);
                cst.setString(23, null);
                cst.setString(24, null);
                cst.setString(25, null);
                cst.setString(26, csvvalues[i][16]);
                cst.setString(27, csvvalues[i][17]);
                cst.setString(28, csvvalues[i][18]);
                cst.setString(29, null);
                cst.setString(30, null);
                cst.setString(31, null);
                cst.setString(32, null);
                cst.setString(33, csvvalues[i][10]);
                cst.setString(34, csvvalues[i][11]);
                cst.setString(35, csvvalues[i][12]);
                cst.setString(36, csvvalues[i][13]);
                cst.setString(37, null);
                cst.setString(38, null);
                cst.setString(39, null);
                cst.setString(40, null);
                cst.setString(41, null);
                cst.setString(42, null);
                cst.setString(43, null);
                cst.setString(44, null);
                cst.setString(45, null);
                cst.setString(46, null);
                cst.setString(47, null);
                
                addBatch = true;
              }
              break;
            case 2: 
              if (i < csvvalues.length)
              {
                cst.setInt(1, ((Integer)this.session.getAttribute("templateTranSeq")).intValue());
                
                cst.setString(2, csvvalues[i][0]);
                cst.setString(3, csvvalues[i][1]);
                cst.setString(4, csvvalues[i][2]);
                cst.setString(5, csvvalues[i][3]);
                String Result2 = GlobalCC.parseDateAuthFormat(csvvalues[i][4]);
                if (Result2.equalsIgnoreCase("Invalid Date Format"))
                {
                  GlobalCC.errorValueNotEntered("Invalid Date Format " + csvvalues[i][4] + " for Member No " + csvvalues[i][0] + " And Member Name " + csvvalues[i][3] + " " + csvvalues[i][2] + ". The Valid Date Format is DD-MMM-YYYY");
                  







                  return;
                }
                cst.setString(6, csvvalues[i][4]);
                cst.setString(7, csvvalues[i][5]);
                cst.setString(8, csvvalues[i][6]);
                cst.setString(9, csvvalues[i][7]);
                cst.setString(10, csvvalues[i][8]);
                cst.setString(11, csvvalues[i][9]);
                cst.setString(12, csvvalues[i][10]);
                cst.setString(13, csvvalues[i][11]);
                cst.setString(14, csvvalues[i][12]);
                
                cst.setString(15, null);
                cst.setString(16, null);
                cst.setString(17, null);
                cst.setString(18, null);
                cst.setString(19, null);
                cst.setString(20, null);
                cst.setString(21, null);
                cst.setString(22, null);
                cst.setString(23, null);
                cst.setString(24, null);
                cst.setString(25, null);
                cst.setString(26, null);
                cst.setString(27, null);
                addBatch = true;
              }
              break;
            case 3: 
              if (i < csvvalues.length)
              {
                cst.setInt(1, ((Integer)this.session.getAttribute("templateTranSeq")).intValue());
                
                cst.setString(2, csvvalues[i][0]);
                cst.setString(3, csvvalues[i][1]);
                cst.setString(4, csvvalues[i][2]);
                cst.setString(5, csvvalues[i][3]);
                String Result3 = GlobalCC.parseDateAuthFormat(csvvalues[i][4]);
                if (Result3.equalsIgnoreCase("Invalid Date Format"))
                {
                  GlobalCC.errorValueNotEntered("Invalid Date Format " + csvvalues[i][4] + " for Member No " + csvvalues[i][0] + " And Member Name " + csvvalues[i][3] + " " + csvvalues[i][2] + ". The Valid Date Format is DD-MMM-YYYY");
                  







                  return;
                }
                cst.setString(6, csvvalues[i][4]);
                cst.setString(7, csvvalues[i][5]);
                cst.setString(8, csvvalues[i][6]);
                cst.setString(9, csvvalues[i][7]);
                cst.setString(10, csvvalues[i][8]);
                cst.setString(11, csvvalues[i][9]);
                cst.setString(12, null);
                cst.setString(13, null);
                cst.setString(14, csvvalues[i][10]);
                cst.setString(15, csvvalues[i][11]);
                cst.setString(16, csvvalues[i][12]);
                cst.setString(17, csvvalues[i][13]);
                cst.setString(18, csvvalues[i][14]);
                cst.setString(19, csvvalues[i][15]);
                cst.setString(20, null);
                cst.setString(21, null);
                cst.setString(22, csvvalues[i][17]);
                cst.setString(23, null);
                cst.setString(24, null);
                cst.setString(25, null);
                cst.setString(26, null);
                
                cst.setString(27, csvvalues[i][16]);
                cst.setString(28, csvvalues[i][17]);
                cst.setString(29, null);
                cst.setString(30, null);
                cst.setString(31, null);
                cst.setString(32, null);
                cst.setString(33, null);
                cst.setString(34, null);
                cst.setString(35, null);
                cst.setString(36, null);
                cst.setString(37, null);
                cst.setString(38, null);
                cst.setString(39, null);
                cst.setString(40, null);
                cst.setString(41, null);
                cst.setString(42, null);
                cst.setString(43, null);
                cst.setString(44, null);
                cst.setString(45, null);
                cst.setString(46, null);
                cst.setString(47, null);
                
                addBatch = true;
              }
              break;
            case 4: 
              if (i < csvvalues.length)
              {
                cst.setInt(1, ((Integer)this.session.getAttribute("templateTranSeq")).intValue());
                
                cst.setString(2, csvvalues[i][0]);
                cst.setString(3, csvvalues[i][1]);
                cst.setString(4, csvvalues[i][2]);
                cst.setString(5, csvvalues[i][3]);
                String Result4 = GlobalCC.parseDateAuthFormat(csvvalues[i][4]);
                if (Result4.equalsIgnoreCase("Invalid Date Format"))
                {
                  GlobalCC.errorValueNotEntered("Invalid Date Format " + csvvalues[i][4] + " for Member No " + csvvalues[i][0] + " And Member Name " + csvvalues[i][3] + " " + csvvalues[i][2] + ". The Valid Date Format is DD-MMM-YYYY");
                  







                  return;
                }
                cst.setString(6, csvvalues[i][4]);
                cst.setString(7, csvvalues[i][5]);
                cst.setString(8, csvvalues[i][6]);
                cst.setString(9, csvvalues[i][7]);
                cst.setString(10, csvvalues[i][8]);
                cst.setString(11, csvvalues[i][9]);
                cst.setString(12, csvvalues[i][10]);
                cst.setString(13, csvvalues[i][11]);
                cst.setString(14, null);
                cst.setString(15, null);
                cst.setString(16, null);
                cst.setString(17, null);
                cst.setString(18, null);
                cst.setString(19, csvvalues[i][12]);
                cst.setString(20, csvvalues[i][13]);
                cst.setString(21, csvvalues[i][14]);
                cst.setString(22, csvvalues[i][15]);
                cst.setString(23, csvvalues[i][17]);
                cst.setString(24, csvvalues[i][16]);
                
                cst.setString(25, csvvalues[i][19]);
                cst.setString(26, null);
                cst.setString(27, csvvalues[i][20]);
                cst.setString(28, csvvalues[i][15]);
                cst.setString(29, null);
                cst.setString(30, null);
                cst.setString(31, null);
                cst.setString(32, null);
                cst.setString(33, null);
                cst.setString(34, null);
                cst.setString(35, null);
                cst.setString(36, null);
                cst.setString(37, null);
                cst.setString(38, null);
                cst.setString(39, csvvalues[i][21]);
                
                cst.setString(40, csvvalues[i][22]);
                
                cst.setString(41, null);
                cst.setString(42, null);
                cst.setString(43, null);
                cst.setString(44, csvvalues[i][23]);
                cst.setString(45, csvvalues[i][24]);
                cst.setString(46, null);
                cst.setString(47, null);
                addBatch = true;
              }
              break;
            case 5: 
              if (i < csvvalues.length)
              {
                cst.setInt(1, ((Integer)this.session.getAttribute("templateTranSeq")).intValue());
                
                cst.setString(2, csvvalues[i][0]);
                cst.setString(3, csvvalues[i][1]);
                cst.setString(4, csvvalues[i][2]);
                cst.setString(5, csvvalues[i][3]);
                String Result5 = GlobalCC.parseDateAuthFormat(csvvalues[i][4]);
                if (Result5.equalsIgnoreCase("Invalid Date Format"))
                {
                  GlobalCC.errorValueNotEntered("Invalid Date Format " + csvvalues[i][4] + " for Member No " + csvvalues[i][0] + " And Member Name " + csvvalues[i][3] + " " + csvvalues[i][2] + ". The Valid Date Format is DD-MMM-YYYY");
                  







                  return;
                }
                cst.setString(6, csvvalues[i][4]);
                cst.setString(7, csvvalues[i][5]);
                cst.setString(8, csvvalues[i][6]);
                cst.setString(9, csvvalues[i][7]);
                cst.setString(10, csvvalues[i][8]);
                cst.setString(11, null);
                cst.setString(12, null);
                cst.setString(13, null);
                cst.setString(14, null);
                cst.setString(15, null);
                cst.setString(16, null);
                cst.setString(17, null);
                cst.setString(18, null);
                cst.setString(19, null);
                cst.setString(20, null);
                cst.setString(21, null);
                cst.setString(22, csvvalues[i][9]);
                System.out.println(csvvalues[i][9]);
                cst.setString(23, null);
                cst.setString(24, null);
                
                cst.setString(25, null);
                cst.setString(26, null);
                cst.setString(27, csvvalues[i][10]);
                cst.setString(28, csvvalues[i][9]);
                
                cst.setString(29, csvvalues[i][12]);
                cst.setString(30, csvvalues[i][13]);
                cst.setString(31, null);
                cst.setString(32, null);
                cst.setString(33, null);
                cst.setString(34, null);
                cst.setString(35, null);
                cst.setString(36, null);
                cst.setString(37, csvvalues[i][14]);
                cst.setString(38, null);
                cst.setString(39, null);
                cst.setString(40, null);
                cst.setString(41, null);
                cst.setString(42, null);
                cst.setString(43, csvvalues[i][15]);
                cst.setString(44, null);
                cst.setString(45, null);
                cst.setString(46, null);
                cst.setString(47, null);
                addBatch = true;
              }
              break;
            case 6: 
              if (i < csvvalues.length)
              {
                cst.setInt(1, ((Integer)this.session.getAttribute("templateTranSeq")).intValue());
                
                cst.setString(2, csvvalues[i][0]);
                cst.setString(3, csvvalues[i][1]);
                cst.setString(4, csvvalues[i][2]);
                cst.setString(5, csvvalues[i][3]);
                String Result6 = GlobalCC.parseDateAuthFormat(csvvalues[i][4]);
                if (Result6.equalsIgnoreCase("Invalid Date Format"))
                {
                  GlobalCC.errorValueNotEntered("Invalid Date Format " + csvvalues[i][4] + " for Member No " + csvvalues[i][0] + " And Member Name " + csvvalues[i][3] + " " + csvvalues[i][2] + ". The Valid Date Format is DD-MMM-YYYY");
                  







                  return;
                }
                cst.setString(6, csvvalues[i][4]);
                cst.setString(7, csvvalues[i][7]);
                cst.setString(8, csvvalues[i][8]);
                cst.setString(9, csvvalues[i][9]);
                cst.setString(10, csvvalues[i][10]);
                cst.setString(11, null);
                cst.setString(12, null);
                cst.setString(13, null);
                cst.setString(14, null);
                cst.setString(15, null);
                cst.setString(16, null);
                cst.setString(17, null);
                cst.setString(18, null);
                cst.setString(19, null);
                cst.setString(20, null);
                cst.setString(21, null);
                cst.setString(22, null);
                
                cst.setString(23, null);
                cst.setString(24, null);
                
                cst.setString(25, null);
                cst.setString(26, null);
                cst.setString(27, null);
                cst.setString(28, null);
                
                cst.setString(29, null);
                
                cst.setString(30, null);
                cst.setString(31, csvvalues[i][11]);
                cst.setString(32, csvvalues[i][12]);
                cst.setString(33, null);
                cst.setString(34, null);
                cst.setString(35, null);
                cst.setString(36, null);
                cst.setString(37, null);
                cst.setString(38, null);
                cst.setString(39, null);
                cst.setString(40, null);
                cst.setString(41, csvvalues[i][5]);
                cst.setString(42, csvvalues[i][6]);
                cst.setString(43, null);
                cst.setString(44, null);
                cst.setString(45, null);
                cst.setString(46, null);
                cst.setString(47, null);
                
                addBatch = true;
              }
              break;
            case 7: 
              if (i < csvvalues.length)
              {
                cst.setInt(1, ((Integer)this.session.getAttribute("templateTranSeq")).intValue());
                
                cst.setString(2, csvvalues[i][0]);
                cst.setString(3, csvvalues[i][1]);
                cst.setString(4, csvvalues[i][2]);
                cst.setString(5, csvvalues[i][3]);
                String Result7 = GlobalCC.parseDateAuthFormat(csvvalues[i][4]);
                if (Result7.equalsIgnoreCase("Invalid Date Format"))
                {
                  GlobalCC.errorValueNotEntered("Invalid Date Format " + csvvalues[i][4] + " for Member No " + csvvalues[i][0] + " And Member Name " + csvvalues[i][3] + " " + csvvalues[i][2] + ". The Valid Date Format is DD-MMM-YYYY");
                  







                  return;
                }
                cst.setString(6, csvvalues[i][4]);
                System.out.println(csvvalues[i][4]);
                cst.setString(7, csvvalues[i][5]);
                cst.setString(8, csvvalues[i][6]);
                cst.setString(9, csvvalues[i][7]);
                cst.setString(10, csvvalues[i][8]);
                cst.setString(11, null);
                cst.setString(12, null);
                cst.setString(13, null);
                cst.setString(14, csvvalues[i][9]);
                cst.setString(15, null);
                
                cst.setString(16, null);
                cst.setString(17, null);
                cst.setString(18, null);
                
                cst.setString(19, null);
                cst.setString(20, null);
                cst.setString(21, null);
                cst.setString(22, null);
                cst.setString(23, null);
                cst.setString(24, null);
                cst.setString(25, null);
                cst.setString(26, null);
                
                cst.setString(27, csvvalues[i][10]);
                System.out.println(csvvalues[i][10]);
                cst.setString(28, csvvalues[i][11]);
                cst.setString(29, null);
                cst.setString(30, null);
                cst.setString(31, null);
                cst.setString(32, null);
                System.out.println(csvvalues[i][11]);
                cst.setString(33, null);
                cst.setString(34, null);
                cst.setString(35, null);
                cst.setString(36, null);
                cst.setString(37, null);
                cst.setString(38, null);
                cst.setString(39, null);
                cst.setString(40, null);
                cst.setString(41, null);
                cst.setString(42, null);
                cst.setString(43, null);
                cst.setString(44, null);
                cst.setString(45, null);
                cst.setString(46, null);
                cst.setString(47, null);
                
                addBatch = true;
              }
              break;
            }
            Integer TempT = (Integer)this.session.getAttribute("templayeTypeInt");
            if (TempT.intValue() == 3) {}
          }
        }
        this.rows.add(tablerow);
        if (addBatch == true)
        {
          cst.addBatch();
          addBatch = false;
        }
      }
      cst.executeBatch();
      cst.close();
      conn.close();
      
      String SystemPoint = (String)this.session.getAttribute("SystemPoint");
      if (SystemPoint.equalsIgnoreCase("U"))
      {
        ADFUtils.findIterator("findPolicyImportBatchesIter").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.allPolicyBatches);
        
        ValidatePolicyData();
      }
      else
      {
        ADFUtils.findIterator("findPolicyImportBatchesIter").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.allPolicyBatches);
        
        ValidateQuoteData();
      }
    }
    catch (BatchUpdateException b)
    {
      int Start = 5;
      System.err.println("Update counts of successful commands: ");
      int[] updateCounts1 = b.getUpdateCounts();
      for (int i = 0; i < updateCounts1.length; i++) {
        if (i == 0) {
          Start = 6;
        } else {
          Start++;
        }
      }
      String Error = "Error Occured While Importing Member Number " + csvvalues[Start][0] + " And Member Surname " + csvvalues[Start][2] + " : " + b.getMessage();
      


      System.out.println(Error);
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, Error));
      



      return;
    }
    catch (Exception e)
    {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, e.getMessage()));
    }
  }
  
  public void processCSVForPayment(InputStream csvFile)
  {
    boolean addBatch = false;
    String[][] csvvalues = (String[][])null;
    Connection conn = new DBConnector().getDatabaseConn();
    try
    {
      CallableStatement cst = null;
      CallableStatement inst = null;
      CallableStatement seq = null;
      String seleSeq = "SELECT LMS_MEM_PREM_BATCH_SEQ.NEXTVAL FROM DUAL";
      seq = conn.prepareCall(seleSeq);
      ResultSet rs = seq.executeQuery();
      
      this.session.setAttribute("receiptTemplateSeq", Integer.valueOf(0));
      while (rs.next()) {
        this.session.setAttribute("receiptTemplateSeq", Integer.valueOf(rs.getInt(1)));
      }
      String insertQuery = "INSERT INTO LMS_MEM_PREM_BATCH VALUES (?,?,?,?)";
      
      inst = conn.prepareCall(insertQuery);
      String importQuery = "INSERT INTO LMS_MEM_IMPORTED_PREM  VALUES(LMS_MEM_IMPORTED_PREM_SEQ.NEXTVAL,?,?,?,?,?,?,?,?)";
      
      cst = conn.prepareCall(importQuery);
      


      csvvalues = CSVParser.parse(new InputStreamReader(csvFile));
      
      this.rows = new ArrayList();
      
      this.numberOfColumns = 0;
      for (int i = 0; i < csvvalues.length; i++)
      {
        Map tablerow = new HashMap();
        for (int j = 0; j < csvvalues[i].length; j++)
        {
          if (j > this.numberOfColumns) {
            this.numberOfColumns = j;
          }
          tablerow.put("cell" + (j + 1), csvvalues[i][j]);
          if ((i == 0) && 
            (j == 0))
          {
            inst.setInt(1, ((Integer)this.session.getAttribute("receiptTemplateSeq")).intValue());
            
            Date now = new Date();
            inst.setString(2, LOVCC.parseDate(now.toString()));
            inst.setString(3, (String)this.session.getAttribute("Username"));
            
            inst.setBigDecimal(4, (BigDecimal)this.session.getAttribute("GrctCode"));
            

            inst.execute();
          }
          if (i >= 1)
          {
            Integer Value = GlobalCC.CheckNullExcelValues(csvvalues[i][0]);
            if (Value.intValue() != 0)
            {
              cst.setString(1, csvvalues[i][0]);
              cst.setString(2, csvvalues[i][1]);
              cst.setString(3, csvvalues[i][4]);
              cst.setString(4, csvvalues[i][5]);
              cst.setString(5, csvvalues[i][6]);
              
              cst.setInt(6, ((Integer)this.session.getAttribute("receiptTemplateSeq")).intValue());
              
              cst.setString(7, csvvalues[i][2]);
              cst.setString(8, csvvalues[i][3]);
              addBatch = true;
            }
          }
          System.out.println("cell" + (j + 1));
          System.out.println(csvvalues[i][j]);
          System.out.println("Another");
        }
        this.rows.add(tablerow);
        if (addBatch == true)
        {
          cst.addBatch();
          addBatch = false;
        }
      }
      cst.executeBatch();
      conn.close();
      
      ADFUtils.findIterator("findImportPremiumMemberCoversIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.importedPrem);
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
      e.printStackTrace();
    }
  }
  
  public void processCSVForPension(InputStream csvFile)
  {
    boolean addBatch = false;
    String[][] csvvalues = (String[][])null;
    Connection conn = new DBConnector().getDatabaseConn();
    try
    {
      CallableStatement cst = null;
      CallableStatement inst = null;
      CallableStatement seq = null;
      String seleSeq = "SELECT LMS_MEM_PENS_BATCH_SEQ.NEXTVAL FROM DUAL";
      seq = conn.prepareCall(seleSeq);
      ResultSet rs = seq.executeQuery();
      
      this.session.setAttribute("receiptTemplateSeq", Integer.valueOf(0));
      while (rs.next()) {
        this.session.setAttribute("receiptTemplateSeq", Integer.valueOf(rs.getInt(1)));
      }
      String insertQuery = "INSERT INTO LMS_MEM_PENS_BTACH(MPB_BATCH_CODE,MPB_BATCH_DATE,MPB_BATCH_BY,MPB_GRCT_CODE) VALUES (?,?,?,?)";
      
      inst = conn.prepareCall(insertQuery);
      String importQuery = "INSERT INTO LMS_IMPORT_MEM_PENS_DETLS(IMPD_CODE,IMPD_MEM_CODE,IMPD_MEM_NO,IMPD_MEM_NAMES,IMPD_EMPYER_CONTRI,IMPD_EMPYEE_CONTRI,IMPD_EMPYEE_VOL_CONTR,IMPD_EMPYER_VOL_CONTR,IMPD_TAX_RELIEF_APPLICABLE,IMPD_MEMBER_COUNT,IMPD_GRCT_RECEIPT_NO,IMPD_PNDP_AMOUNT,IMPD_GRCT_CODE,IMPD_PNPMS_CODE,IMPD_BATCH_NO,IMPD_EMPYR_REG_AMT,IMPD_EMPYR_UNREG_AMT,IMPD_EMPYE_REG_AMT,IMPD_EMPYE_UNREG_AMT)VALUES (LMS_MEM_PENS_BATCH_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      




      cst = conn.prepareCall(importQuery);
      


      csvvalues = CSVParser.parse(new InputStreamReader(csvFile));
      
      this.rows = new ArrayList();
      
      this.numberOfColumns = 0;
      for (int i = 0; i < csvvalues.length; i++)
      {
        Map tablerow = new HashMap();
        for (int j = 0; j < csvvalues[i].length; j++)
        {
          if (j > this.numberOfColumns) {
            this.numberOfColumns = j;
          }
          tablerow.put("cell" + (j + 1), csvvalues[i][j]);
          if ((i == 0) && 
            (j == 0))
          {
            inst.setInt(1, ((Integer)this.session.getAttribute("receiptTemplateSeq")).intValue());
            
            Date now = new Date();
            inst.setString(2, LOVCC.parseDate(now.toString()));
            inst.setString(3, (String)this.session.getAttribute("Username"));
            
            inst.setBigDecimal(4, (BigDecimal)this.session.getAttribute("GrctCode"));
            

            inst.execute();
          }
          if (i >= 1)
          {
            cst.setString(1, null);
            cst.setString(2, csvvalues[i][0]);
            cst.setString(3, csvvalues[i][1]);
            cst.setString(4, csvvalues[i][6]);
            cst.setString(5, csvvalues[i][7]);
            cst.setString(6, csvvalues[i][8]);
            
            cst.setString(7, csvvalues[i][9]);
            
            cst.setString(8, csvvalues[i][10]);
            cst.setString(9, null);
            cst.setString(10, null);
            cst.setString(11, null);
            cst.setBigDecimal(12, (BigDecimal)this.session.getAttribute("GrctCode"));
            
            cst.setString(13, null);
            cst.setInt(14, ((Integer)this.session.getAttribute("receiptTemplateSeq")).intValue());
            
            cst.setString(15, csvvalues[i][2]);
            cst.setString(16, csvvalues[i][3]);
            cst.setString(17, csvvalues[i][4]);
            cst.setString(18, csvvalues[i][5]);
            
            addBatch = true;
          }
          System.out.println("cell" + (j + 1));
          System.out.println(csvvalues[i][j]);
          System.out.println("Another");
        }
        this.rows.add(tablerow);
        if (addBatch == true)
        {
          cst.addBatch();
          addBatch = false;
        }
      }
      cst.executeBatch();
      rs.close();
      cst.close();
      conn.close();
      
      ADFUtils.findIterator("findImportedPensionAllocationsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.importedPensMem);
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
      e.printStackTrace();
    }
  }
  
  public void processCSVForPensionWithdrawals(InputStream csvFile)
  {
    boolean addBatch = false;
    String[][] csvvalues = (String[][])null;
    Connection conn = new DBConnector().getDatabaseConn();
    try
    {
      CallableStatement cst = null;
      CallableStatement inst = null;
      CallableStatement seq = null;
      String seleSeq = "SELECT LMS_MEM_PENS_BATCH_SEQ.NEXTVAL FROM DUAL";
      seq = conn.prepareCall(seleSeq);
      ResultSet rs = seq.executeQuery();
      
      this.session.setAttribute("receiptTemplateSeq", Integer.valueOf(0));
      while (rs.next()) {
        this.session.setAttribute("receiptTemplateSeq", Integer.valueOf(rs.getInt(1)));
      }
      String insertQuery = "INSERT INTO LMS_MEM_PENS_BTACH VALUES (?,?,?,?,?)";
      
      inst = conn.prepareCall(insertQuery);
      //String importQuery = "INSERT INTO LMS_IMPORT_MEM_PENS_DETLS VALUES (LMS_MEM_PENS_BATCH_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      String importQuery = "INSERT INTO LMS_IMPORT_MEM_PENS_DETLS(IMPD_CODE,IMPD_MEM_CODE,IMPD_MEM_NO,IMPD_MEM_NAMES,IMPD_EMPYER_CONTRI,IMPD_EMPYEE_CONTRI,IMPD_EMPYEE_VOL_CONTR,IMPD_EMPYER_VOL_CONTR,IMPD_TAX_RELIEF_APPLICABLE,IMPD_MEMBER_COUNT,IMPD_GRCT_RECEIPT_NO,IMPD_PNDP_AMOUNT,IMPD_GRCT_CODE,IMPD_PNPMS_CODE,IMPD_BATCH_NO,IMPD_EMPYR_REG_AMT,IMPD_EMPYR_UNREG_AMT,IMPD_EMPYE_REG_AMT,IMPD_EMPYE_UNREG_AMT)VALUES (LMS_MEM_PENS_BATCH_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      cst = conn.prepareCall(importQuery);
      


      csvvalues = CSVParser.parse(new InputStreamReader(csvFile));
      
      this.rows = new ArrayList();
      
      this.numberOfColumns = 0;
      for (int i = 0; i < csvvalues.length; i++)
      {
        Map tablerow = new HashMap();
        for (int j = 0; j < csvvalues[i].length; j++)
        {
          if (j > this.numberOfColumns) {
            this.numberOfColumns = j;
          }
          tablerow.put("cell" + (j + 1), csvvalues[i][j]);
          if ((i == 0) && 
            (j == 0))
          {
            inst.setInt(1, ((Integer)this.session.getAttribute("receiptTemplateSeq")).intValue());
            
            Date now = new Date();
            inst.setString(2, LOVCC.parseDate(now.toString()));
            inst.setString(3, (String)this.session.getAttribute("Username"));
            
            inst.setBigDecimal(4, (BigDecimal)this.session.getAttribute("GrctCode"));
            
            inst.setString(5, "W");
            
            inst.execute();
          }
          if (i >= 1)
          {
              cst.setString(1, null);
              cst.setString(2, csvvalues[i][0]);
              cst.setString(3, csvvalues[i][1]);
              cst.setString(4, csvvalues[i][6]);
              cst.setString(5, csvvalues[i][7]);
              cst.setString(6, csvvalues[i][8]);
              
              cst.setString(7, csvvalues[i][9]);
              
              cst.setString(8, csvvalues[i][10]);
              cst.setString(9, null);
              cst.setString(10, null);
              cst.setString(11, null);
              cst.setBigDecimal(12, (BigDecimal)this.session.getAttribute("GrctCode"));
              
              cst.setString(13, null);
              cst.setInt(14, ((Integer)this.session.getAttribute("receiptTemplateSeq")).intValue());
              
              cst.setString(15, csvvalues[i][2]);
              cst.setString(16, csvvalues[i][3]);
              cst.setString(17, csvvalues[i][4]);
              cst.setString(18, csvvalues[i][5]);
            
            addBatch = true;
          }
          System.out.println("cell" + (j + 1));
          System.out.println(csvvalues[i][j]);
          System.out.println("Another");
        }
        this.rows.add(tablerow);
        if (addBatch == true)
        {
          cst.addBatch();
          addBatch = false;
        }
      }
      cst.executeBatch();
      rs.close();
      cst.close();
      conn.close();
      
      ADFUtils.findIterator("findImportedPensionAllocationsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.importedPensMem);
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
  }
  
  public void processCSVForRefund(InputStream csvFile)
  {
    boolean addBatch = false;
    String[][] csvvalues = (String[][])null;
    Connection conn = new DBConnector().getDatabaseConn();
    try
    {
      CallableStatement cst = null;
      CallableStatement inst = null;
      CallableStatement seq = null;
      String seleSeq = "SELECT LMS_MEM_IMP_TRANS_SEQ.NEXTVAL FROM DUAL";
      seq = conn.prepareCall(seleSeq);
      ResultSet rs = seq.executeQuery();
      this.session.setAttribute("templateTranSeq", Integer.valueOf(0));
      while (rs.next()) {
        this.session.setAttribute("templateTranSeq", Integer.valueOf(rs.getInt(1)));
      }
      String insertQuery = "INSERT INTO LMS_MEMBER_IMPORT_TRANS VALUES (?,?,?,?,?,?,?,?,?,?)";
      
      inst = conn.prepareCall(insertQuery);
      String importQuery = "INSERT INTO LMS_IMPORT_REFUND_MEMBERS VALUES (LMS_REFM_CODE_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?)";
      
      cst = conn.prepareCall(importQuery);
      


      csvvalues = CSVParser.parse(new InputStreamReader(csvFile));
      
      this.rows = new ArrayList();
      
      this.numberOfColumns = 0;
      for (int i = 0; i < csvvalues.length; i++)
      {
        Map tablerow = new HashMap();
        for (int j = 0; j < csvvalues[i].length; j++)
        {
          if (j > this.numberOfColumns) {
            this.numberOfColumns = j;
          }
          tablerow.put("cell" + (j + 1), csvvalues[i][j]);
          if ((i == 0) && 
            (j == 0))
          {
            inst.setInt(1, ((Integer)this.session.getAttribute("templateTranSeq")).intValue());
            
            Date now = new Date();
            inst.setString(2, LOVCC.parseDate(now.toString()));
            inst.setString(3, (String)this.session.getAttribute("Username"));
            
            inst.setString(4, null);
            inst.setBigDecimal(5, (BigDecimal)this.session.getAttribute("policyCode"));
            
            inst.setString(6, null);
            inst.setString(7, null);
            inst.setString(8, null);
            inst.setString(9, null);
            inst.setString(10, null);
            
            inst.execute();
          }
          if (i >= 1)
          {
            Integer Result = GlobalCC.CheckNullExcelValues(csvvalues[i][0]);
            if (Result.intValue() == 0) {
              Result = GlobalCC.CheckNullExcelValues(getMemberNo(csvvalues[i][1].trim() + " " + csvvalues[i][2].trim()));
            } else {
              Result = GlobalCC.CheckNullExcelValues(csvvalues[i][0]);
            }
            if (Result.intValue() != 0)
            {
              cst.setInt(1, ((Integer)this.session.getAttribute("templateTranSeq")).intValue());
              if (csvvalues[i][0] == "") {
                cst.setString(2, getMemberNo(csvvalues[i][1].trim() + " " + csvvalues[i][2].trim()));
              } else {
                cst.setString(2, csvvalues[i][0]);
              }
              cst.setString(3, csvvalues[i][1]);
              cst.setString(4, csvvalues[i][2]);
              
              cst.setString(5, csvvalues[i][5]);
              cst.setString(6, null);
              cst.setString(7, null);
              cst.setString(8, csvvalues[i][3]);
              cst.setString(9, csvvalues[i][4]);
              addBatch = true;
            }
          }
          System.out.println("cell" + (j + 1));
          System.out.println(csvvalues[i][j]);
          System.out.println("Another");
        }
        this.rows.add(tablerow);
        if (addBatch == true)
        {
          cst.addBatch();
          addBatch = false;
        }
      }
      cst.executeBatch();
      conn.close();
      
      ADFUtils.findIterator("findPolicyImportBatchesIter").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.allPolicyBatches);
      
      ValidateRefundMembers();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
  }
  
  public void processCSVForLoanRepayment(InputStream csvFile)
  {
    boolean addBatch = false;
    String[][] csvvalues = (String[][])null;
    Connection conn = new DBConnector().getDatabaseConn();
    try
    {
      CallableStatement cst = null;
      CallableStatement inst = null;
      CallableStatement seq = null;
      String seleSeq = "SELECT LMS_MEM_IMP_TRANS_SEQ.NEXTVAL FROM DUAL";
      seq = conn.prepareCall(seleSeq);
      ResultSet rs = seq.executeQuery();
      this.session.setAttribute("templateTranSeq", Integer.valueOf(0));
      while (rs.next()) {
        this.session.setAttribute("templateTranSeq", Integer.valueOf(rs.getInt(1)));
      }
      String insertQuery = "INSERT INTO LMS_MEMBER_IMPORT_TRANS VALUES (?,?,?,?,?,?,?,?,?,?)";
      
      inst = conn.prepareCall(insertQuery);
      String importQuery = "INSERT INTO LMS_IMPORT_LN_RPYMT_MEMBERS VALUES (LMS_LIRM_CODE_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?)";
      
      cst = conn.prepareCall(importQuery);
      


      csvvalues = CSVParser.parse(new InputStreamReader(csvFile));
      
      this.rows = new ArrayList();
      
      this.numberOfColumns = 0;
      for (int i = 0; i < csvvalues.length; i++)
      {
        Map tablerow = new HashMap();
        for (int j = 0; j < csvvalues[i].length; j++)
        {
          if (j > this.numberOfColumns) {
            this.numberOfColumns = j;
          }
          tablerow.put("cell" + (j + 1), csvvalues[i][j]);
          if ((i == 0) && 
            (j == 0))
          {
            inst.setInt(1, ((Integer)this.session.getAttribute("templateTranSeq")).intValue());
            
            Date now = new Date();
            inst.setString(2, LOVCC.parseDate(now.toString()));
            inst.setString(3, (String)this.session.getAttribute("Username"));
            
            inst.setString(4, null);
            inst.setBigDecimal(5, (BigDecimal)this.session.getAttribute("policyCode"));
            
            inst.setString(6, null);
            inst.setString(7, null);
            inst.setString(8, null);
            inst.setString(9, null);
            inst.setString(10, null);
            
            inst.execute();
          }
          if (i >= 1)
          {
            Integer Result = GlobalCC.CheckNullExcelValues(csvvalues[i][0]);
            if (Result.intValue() != 0)
            {
              cst.setInt(1, ((Integer)this.session.getAttribute("templateTranSeq")).intValue());
              
              cst.setString(2, csvvalues[i][0]);
              cst.setString(3, csvvalues[i][1]);
              cst.setString(4, csvvalues[i][2]);
              
              cst.setString(5, csvvalues[i][3]);
              
              cst.setString(6, csvvalues[i][4]);
              
              cst.setString(7, csvvalues[i][5]);
              cst.setString(8, null);
              cst.setString(9, null);
              
              addBatch = true;
            }
          }
          System.out.println("cell" + (j + 1));
          System.out.println(csvvalues[i][j]);
          System.out.println("Another");
        }
        this.rows.add(tablerow);
        if (addBatch == true)
        {
          cst.addBatch();
          addBatch = false;
        }
      }
      cst.executeBatch();
      conn.close();
      
      ADFUtils.findIterator("findPolicyImportBatchesIter").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.allPolicyBatches);
      
      ValidateLoanRepaymentMembers();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
  }
  
  public void processCSVForRates(InputStream csvFile)
  {
    boolean addBatch = false;
    String[][] csvvalues = (String[][])null;
    Integer RatesTemplate = null;
    try
    {
      Connection conn = new DBConnector().getDatabaseConn();
      
      CallableStatement cst = null;
      CallableStatement inst = null;
      CallableStatement seq = null;
      String seleSeq = "SELECT LMS_LRID_CODE_SEQ.NEXTVAL FROM DUAL";
      seq = conn.prepareCall(seleSeq);
      ResultSet rs = seq.executeQuery();
      RatesTemplate = Integer.valueOf(0);
      while (rs.next()) {
        RatesTemplate = Integer.valueOf(rs.getInt(1));
      }
      String insertQuery = "INSERT INTO LMS_RATES_IMPORT_TRANS VALUES (?,?,?,?)";
      
      inst = conn.prepareCall(insertQuery);
      String importQuery = "INSERT INTO LMS_RATES_IMPORT_DETAILS VALUES (LMS_LRIT_CODE_SEQ.NEXTVAL,?,?,?)";
      
      cst = conn.prepareCall(importQuery);
      


      csvvalues = CSVParser.parse(new InputStreamReader(csvFile));
      
      this.rows = new ArrayList();
      
      this.numberOfColumns = 0;
      for (int i = 0; i < csvvalues.length; i++)
      {
        Map tablerow = new HashMap();
        for (int j = 0; j < csvvalues[i].length; j++)
        {
          if (j > this.numberOfColumns) {
            this.numberOfColumns = j;
          }
          tablerow.put("cell" + (j + 1), csvvalues[i][j]);
          if ((i == 0) && 
            (j == 0))
          {
            inst.setInt(1, RatesTemplate.intValue());
            Date now = new Date();
            inst.setString(2, LOVCC.parseDate(now.toString()));
            inst.setString(3, (String)this.session.getAttribute("Username"));
            
            inst.setString(4, null);
            

            inst.execute();
          }
          if (i >= 1)
          {
            cst.setInt(1, RatesTemplate.intValue());
            cst.setString(2, csvvalues[i][0]);
            cst.setString(3, csvvalues[i][1]);
            
            addBatch = true;
          }
          System.out.println("cell" + (j + 1));
          System.out.println(csvvalues[i][j]);
          System.out.println("Another");
        }
        this.rows.add(tablerow);
        if (addBatch == true)
        {
          cst.addBatch();
          addBatch = false;
        }
      }
      cst.executeBatch();
      conn.close();
      


      setupManipulation MySet = new setupManipulation();
      MySet.CreateImportedPremiumRate(RatesTemplate);
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
  }
  
  public String ValidateRefundMembers()
  {
    Connection conn = null;
    String Success = "F";
    try
    {
      this.session.setAttribute("TotalMembers", new BigDecimal("0"));
      this.session.setAttribute("ValidMembers", new BigDecimal("0"));
      this.session.setAttribute("InValidMembers", new BigDecimal("0"));
      
      String attchToPolicyQuery = "BEGIN LMS_IMPORT_MEM_DATA.validate_refund_batch(?,?,?,?,?,?);END;";
      
      conn = new DBConnector().getDatabaseConn();
      CallableStatement cstmt = null;
      cstmt = conn.prepareCall(attchToPolicyQuery);
      cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("policyCode"));
      
      cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("endorsementCode"));
      
      cstmt.setInt(3, ((Integer)this.session.getAttribute("templateTranSeq")).intValue());
      cstmt.registerOutParameter(4, 3);
      cstmt.registerOutParameter(5, 3);
      cstmt.registerOutParameter(6, 3);
      
      cstmt.execute();
      
      this.session.setAttribute("TotalMembers", cstmt.getBigDecimal(4));
      this.session.setAttribute("ValidMembers", cstmt.getBigDecimal(5));
      this.session.setAttribute("InValidMembers", cstmt.getBigDecimal(6));
      
      cstmt.close();
      conn.close();
      Success = "S";
      

      ADFUtils.findIterator("findRefundInvalidMembersIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.importedMembers);
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return Success;
  }
  
  public String getMemberNo(String memName)
  {
    Connection conn = null;
    String memberNo = "";
    try
    {
      String memberNoQuery = "BEGIN ?:=LMS_IMPORT_MEM_DATA.getMemberNumber(?,?); END;";
      
      conn = new DBConnector().getDatabaseConn();
      CallableStatement cstmt = null;
      cstmt = conn.prepareCall(memberNoQuery);
      cstmt.registerOutParameter(1, 12);
      cstmt.setString(2, memName);
      cstmt.setBigDecimal(3, (BigDecimal)this.session.getAttribute("policyCode"));
      

      cstmt.execute();
      memberNo = cstmt.getString(1);
      cstmt.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return memberNo;
  }
  
  public String ValidateLoanRepaymentMembers()
  {
    Connection conn = null;
    String Success = "F";
    try
    {
      this.session.setAttribute("TotalMembers", new BigDecimal("0"));
      this.session.setAttribute("ValidMembers", new BigDecimal("0"));
      this.session.setAttribute("InValidMembers", new BigDecimal("0"));
      
      String attchToPolicyQuery = "BEGIN LMS_IMPORT_MEM_DATA.validate_ln_repayment_batch(?,?,?,?,?,?);END;";
      
      conn = new DBConnector().getDatabaseConn();
      CallableStatement cstmt = null;
      cstmt = conn.prepareCall(attchToPolicyQuery);
      cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("policyCode"));
      
      cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("endorsementCode"));
      
      cstmt.setInt(3, ((Integer)this.session.getAttribute("templateTranSeq")).intValue());
      cstmt.registerOutParameter(4, 3);
      cstmt.registerOutParameter(5, 3);
      cstmt.registerOutParameter(6, 3);
      
      cstmt.execute();
      
      this.session.setAttribute("TotalMembers", cstmt.getBigDecimal(4));
      this.session.setAttribute("ValidMembers", cstmt.getBigDecimal(5));
      this.session.setAttribute("InValidMembers", cstmt.getBigDecimal(6));
      
      cstmt.close();
      conn.close();
      Success = "S";
      

      ADFUtils.findIterator("findLnRepayInvalidMembersIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.importedMembers);
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return Success;
  }
  
  public String RefundSelectedMembers()
  {
    Connection conn = null;
    try
    {
      String attchToPolicyQuery = "BEGIN LMS_IMPORT_MEM_DATA.import_refund_excel_data(?,?,?);END;";
      
      conn = new DBConnector().getDatabaseConn();
      CallableStatement cstmt = null;
      cstmt = conn.prepareCall(attchToPolicyQuery);
      cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("policyCode"));
      
      cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("endorsementCode"));
      
      cstmt.setInt(3, ((Integer)this.session.getAttribute("templateTranSeq")).intValue());
      cstmt.execute();
      conn.close();
      GlobalCC.INFORMATIONREPORTING("Member Successfully Imported");
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
  
  public String ProcessLoanRepaymentMembers()
  {
    Connection conn = null;
    try
    {
      String attchToPolicyQuery = "BEGIN LMS_IMPORT_MEM_DATA.import_loan_repayment_data(?,?,?);END;";
      
      conn = new DBConnector().getDatabaseConn();
      CallableStatement cstmt = null;
      cstmt = conn.prepareCall(attchToPolicyQuery);
      cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("policyCode"));
      
      cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("endorsementCode"));
      
      cstmt.setInt(3, ((Integer)this.session.getAttribute("templateTranSeq")).intValue());
      cstmt.execute();
      conn.close();
      GlobalCC.INFORMATIONREPORTING("Member Successfully Imported");
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
  
  public void processCSVForMemberImport(InputStream csvFile)
  {
    boolean addBatch = false;
    String[][] csvvalues = (String[][])null;
    Connection conn = new DBConnector().getDatabaseConn();
    try
    {
      CallableStatement cst = null;
      CallableStatement inst = null;
      CallableStatement seq = null;
      String seleSeq = "SELECT LMS_MEM_IMP_TRANS_SEQ.NEXTVAL FROM DUAL";
      seq = conn.prepareCall(seleSeq);
      ResultSet rs = seq.executeQuery();
      this.session.setAttribute("receiptTemplateSeq", Integer.valueOf(0));
      while (rs.next()) {
        this.session.setAttribute("receiptTemplateSeq", Integer.valueOf(rs.getInt(1)));
      }
      String insertQuery = "INSERT INTO LMS_MEMBER_IMPORT_TRANS VALUES (?,?,?,?,?,?,?,?,?,?)";
      
      inst = conn.prepareCall(insertQuery);
      String importQuery = "INSERT INTO LMS_IMPORT_MEM_EARNINGS VALUES (LMS_LIME_CODE_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      
      cst = conn.prepareCall(importQuery);
      


      csvvalues = CSVParser.parse(new InputStreamReader(csvFile));
      
      this.rows = new ArrayList();
      
      this.numberOfColumns = 0;
      for (int i = 0; i < csvvalues.length; i++)
      {
        Map tablerow = new HashMap();
        for (int j = 0; j < csvvalues[i].length; j++)
        {
          if (j > this.numberOfColumns) {
            this.numberOfColumns = j;
          }
          tablerow.put("cell" + (j + 1), csvvalues[i][j]);
          if ((i == 0) && 
            (j == 0))
          {
            inst.setInt(1, ((Integer)this.session.getAttribute("receiptTemplateSeq")).intValue());
            
            Date now = new Date();
            inst.setString(2, LOVCC.parseDate(now.toString()));
            inst.setString(3, (String)this.session.getAttribute("Username"));
            
            inst.setString(4, null);
            inst.setBigDecimal(5, (BigDecimal)this.session.getAttribute("policyCode"));
            
            inst.setBigDecimal(6, null);
            inst.setBigDecimal(7, null);
            inst.setBigDecimal(8, null);
            inst.setBigDecimal(9, null);
            inst.setBigDecimal(10, null);
            
            inst.execute();
          }
          if (i >= 1)
          {
            Integer NullValue = GlobalCC.CheckNullExcelValues(csvvalues[i][0]);
            if (NullValue.intValue() != 0)
            {
              cst.setString(1, csvvalues[i][0]);
              cst.setString(2, csvvalues[i][1]);
              
              cst.setString(3, csvvalues[i][2]);
              
              cst.setString(4, csvvalues[i][3]);
              

              String prodTy = (String)this.session.getAttribute("productType");
              if (prodTy == null)
              {
                cst.setString(5, null);
                cst.setString(6, null);
                
                cst.setString(7, null);
                cst.setString(8, null);
                
                cst.setString(9, null);
              }
              else if (prodTy.equalsIgnoreCase("EARN"))
              {
                cst.setString(5, csvvalues[i][5]);
                
                cst.setString(6, csvvalues[i][6]);
                
                cst.setString(7, csvvalues[i][4]);
                
                cst.setString(8, null);
                
                cst.setString(9, null);
              }
              else if (prodTy.equalsIgnoreCase("LOAN"))
              {
                cst.setString(5, null);
                cst.setString(6, null);
                
                cst.setString(7, csvvalues[i][4]);
                
                cst.setString(8, csvvalues[i][5]);
                
                cst.setString(9, csvvalues[i][6]);
              }
              cst.setInt(10, ((Integer)this.session.getAttribute("receiptTemplateSeq")).intValue());
              
              cst.setBigDecimal(11, (BigDecimal)this.session.getAttribute("endorsementCode"));
              
              cst.setString(12, csvvalues[i][7]);
              if (prodTy == null) {
                cst.setString(13, null);
              } else if (prodTy.equalsIgnoreCase("PENS")) {
                cst.setString(13, csvvalues[i][0]);
              } else {
                cst.setString(13, null);
              }
              addBatch = true;
            }
          }
          System.out.println("cell" + (j + 1));
          System.out.println(csvvalues[i][j]);
          System.out.println("Another");
        }
        this.rows.add(tablerow);
        if (addBatch == true)
        {
          cst.addBatch();
          addBatch = false;
        }
      }
      cst.executeBatch();
      conn.close();
      

      ImportSelectedMembers();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
  }
  
  public String ImportSelectedMembers()
  {
    Connection conn = null;
    try
    {
      String attchToPolicyQuery = "BEGIN LMS_WEB_PKG_GRP_UW.import_mem_earnings(?,?);END;";
      
      conn = new DBConnector().getDatabaseConn();
      CallableStatement cstmt = null;
      cstmt = conn.prepareCall(attchToPolicyQuery);
      cstmt.setInt(1, ((Integer)this.session.getAttribute("receiptTemplateSeq")).intValue());
      
      cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("policyCode"));
      
      cstmt.execute();
      GlobalCC.INFORMATIONREPORTING("Member Successfully Imported");
      
      System.out.println("Successful");
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
  
  private void setupTableColumns()
  {
    try
    {
      FacesContext fc = FacesContext.getCurrentInstance();
      Application app = fc.getApplication();
      this.table.getChildren().clear();
      CoreColumn col = (CoreColumn)app.createComponent("org.apache.myfaces.trinidad.CoreColumn");
      
      col.setId("rowheader");
      CoreOutputText cell = (CoreOutputText)app.createComponent("org.apache.myfaces.trinidad.CoreOutputText");
      
      cell.setId("rowcell");
      cell.setValueBinding("value", app.createValueBinding("#{rowStatusDyn.index}"));
      

      col.getChildren().add(cell);
      col.setHeaderText("^");
      this.table.getChildren().add(col);
      for (int i = 0; i < this.numberOfColumns + 1; i++)
      {
        col = (CoreColumn)app.createComponent("org.apache.myfaces.trinidad.CoreColumn");
        
        col.setId("col" + i);
        cell = (CoreOutputText)app.createComponent("org.apache.myfaces.trinidad.CoreOutputText");
        
        cell.setId("cell" + i);
        cell.setValueBinding("value", app.createValueBinding("#{rowDyn['cell" + (i + 1) + "']}"));
        


        col.getChildren().add(cell);
        col.setValueBinding("headerText", app.createValueBinding("#{CsvProcessor.columnHeaders['" + i + "']}"));
        

        col.setSortable(true);
        col.setSortProperty("cell" + (i + 1));
        this.table.getChildren().add(col);
      }
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
  }
  
  public void setTable(CoreTable table)
  {
    this.table = table;
  }
  
  public CoreTable getTable()
  {
    return this.table;
  }
  
  public void setRows(List rows)
  {
    this.rows = rows;
  }
  
  public List getRows()
  {
    return this.rows.subList(this.useFirstRowAsHeaders ? 1 : 0, this.rows.size());
  }
  
  public Map getColumnHeaders()
  {
    Map columnHeaders = new HashMap();
    if (this.useFirstRowAsHeaders) {
      for (int i = 0; i < this.numberOfColumns + 1; i++) {
        columnHeaders.put(Integer.toString(i), ((Map)this.rows.get(0)).get("cell" + (i + 1)));
      }
    } else {
      for (int i = 0; i < this.numberOfColumns + 1; i++) {
        columnHeaders.put(Integer.toString(i), String.valueOf((char)(65 + i)));
      }
    }
    return columnHeaders;
  }
  
  public void setUseFirstRowAsHeaders(boolean useFirstRowAsHeaders)
  {
    this.useFirstRowAsHeaders = useFirstRowAsHeaders;
  }
  
  public boolean isUseFirstRowAsHeaders()
  {
    return this.useFirstRowAsHeaders;
  }
  
  public void ImportToDatabase() {}
  
  public String ValidateQuoteData()
  {
    String Success = "F";
    String attchToPolicyQuery = "BEGIN LMS_IMPORT_MEM_DATA.validate_quote_excel(?,?,?,?,?);END;";
    
    Connection conn = new DBConnector().getDatabaseConn();
    CallableStatement cstmt = null;
    try
    {
      this.session.setAttribute("TotalMembers", new BigDecimal("0"));
      this.session.setAttribute("ValidMembers", new BigDecimal("0"));
      this.session.setAttribute("InValidMembers", new BigDecimal("0"));
      
      cstmt = conn.prepareCall(attchToPolicyQuery);
      cstmt.setInt(1, ((Integer)this.session.getAttribute("templateTranSeq")).intValue());
      cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("QuoteCode"));
      
      cstmt.registerOutParameter(3, 3);
      cstmt.registerOutParameter(4, 3);
      cstmt.registerOutParameter(5, 3);
      
      cstmt.execute();
      
      this.session.setAttribute("TotalMembers", cstmt.getBigDecimal(3));
      this.session.setAttribute("ValidMembers", cstmt.getBigDecimal(4));
      this.session.setAttribute("InValidMembers", cstmt.getBigDecimal(5));
      
      cstmt.close();
      conn.close();
      Success = "S";
      
      ADFUtils.findIterator("findInvalidMembersIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.importedMembers);
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return Success;
  }
  
  public String ValidatePolicyData()
  {
    String Success = "F";
    String attchToPolicyQuery = "BEGIN LMS_IMPORT_MEM_DATA.validate_excel_batch(?,?,?,?,?,?);END;";
    
    Connection conn = new DBConnector().getDatabaseConn();
    CallableStatement cstmt = null;
    try
    {
      this.session.setAttribute("TotalMembers", new BigDecimal("0"));
      this.session.setAttribute("ValidMembers", new BigDecimal("0"));
      this.session.setAttribute("InValidMembers", new BigDecimal("0"));
      
      cstmt = conn.prepareCall(attchToPolicyQuery);
      cstmt.setInt(1, ((Integer)this.session.getAttribute("templateTranSeq")).intValue());
      cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("endorsementCode"));
      
      cstmt.setString(3, (String)this.session.getAttribute("delExistMembers"));
      
      cstmt.registerOutParameter(4, 3);
      cstmt.registerOutParameter(5, 3);
      cstmt.registerOutParameter(6, 3);
      
      cstmt.execute();
      
      this.session.setAttribute("TotalMembers", cstmt.getBigDecimal(4));
      this.session.setAttribute("ValidMembers", cstmt.getBigDecimal(5));
      this.session.setAttribute("InValidMembers", cstmt.getBigDecimal(6));
      
      cstmt.close();
      conn.close();
      Success = "S";
      
      ADFUtils.findIterator("findInvalidMembersIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.importedMembers);
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return Success;
  }
  
  public String importExpressFuneral(String module)
  {
    String attachFuneMem = "BEGIN LMS_GRP_MISC.importfuneralmembers(?,?);END;";
    
    Connection conn = new DBConnector().getDatabaseConn();
    CallableStatement cstmt = null;
    try
    {
      cstmt = conn.prepareCall(attachFuneMem);
      cstmt.setInt(1, ((Integer)this.session.getAttribute("templateTranSeq")).intValue());
      cstmt.setString(2, module);
      cstmt.execute();
      cstmt.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
  
  public String ImportToDbase()
  {
    String Result = "F";
    this.RedirectPage = "P";
    String attchToPolicyQuery = "BEGIN LMS_IMPORT_MEM_DATA.IMPORT_EXCEL_DATA(?,?,?,?);END;";
    
    Connection conn = new DBConnector().getDatabaseConn();
    CallableStatement cstmt = null;
    try
    {
      cstmt = conn.prepareCall(attchToPolicyQuery);
      cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("policyCode"));
      
      cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("endorsementCode"));
      
      cstmt.setInt(3, ((Integer)this.session.getAttribute("templateTranSeq")).intValue());
      cstmt.setString(4, (String)this.session.getAttribute("delExistMembers"));
      
      cstmt.execute();
      cstmt.close();
      conn.close();
      
      System.out.println("Successful");
      Result = "S";
      GlobalCC.sysInformation("Members Successfully Imported.");
      
      ADFUtils.findIterator("findInvalidMembersIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.importedMembers);
    }
    catch (Exception e)
    {
      ADFUtils.findIterator("findInvalidMembersIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.importedMembers);
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return Result;
  }
  
  public String ImportQuotation()
  {
    String Result = "F";
    this.RedirectPage = "Q";
    String attchToPolicyQuery = "BEGIN lms_web_pkg_grp.import_quot_excel_data(?,?);END;";
    
    Connection conn = new DBConnector().getDatabaseConn();
    CallableStatement cstmt = null;
    try
    {
      cstmt = conn.prepareCall(attchToPolicyQuery);
      cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("QuoteCode"));
      
      cstmt.setInt(2, ((Integer)this.session.getAttribute("templateTranSeq")).intValue());
      cstmt.execute();
      
      cstmt.close();
      conn.close();
      
      Result = "S";
      GlobalCC.sysInformation("Members Successfully Imported.");
      
      ADFUtils.findIterator("findInvalidMembersIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.importedMembers);
    }
    catch (Exception e)
    {
      ADFUtils.findIterator("findInvalidMembersIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.importedMembers);
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return Result;
  }
  
  public String BackToMembers()
  {
    try
    {
      if (LOVCC.RedirectPage == "P") {
        GlobalCC.RedirectPage("/undwrmem.jspx");
      } else {
        GlobalCC.RedirectPage("/quomembr.jspx");
      }
    }
    catch (Exception ex)
    {
      GlobalCC.EXCEPTIONREPORTING(null, ex);
    }
    return null;
  }
  
  public ArrayList<String> readAndFragment(UploadedFile _file, int CHUNK_SIZE)
    throws IOException
  {
    File fileToDelete = null;
    this.upFile = _file;
    String fileName = "";
    String filePath = "";
    

    int FILE_SIZE = (int)_file.getLength();
    ArrayList<String> nameList = new ArrayList();
    
    FacesContext context = FacesContext.getCurrentInstance();
    

    ServletContext sc = (ServletContext)context.getExternalContext().getContext();
    

    LineNumberReader lnr = new LineNumberReader(new InputStreamReader(this.upFile.getInputStream()));
    lnr.skip(9223372036854775807L);
    System.out.println("LINE NUMBER:" + lnr.getLineNumber());
    System.out.println("Total File Size: " + FILE_SIZE);
    

    int NUMBER_OF_CHUNKS = 0;
    byte[] temporary = null;
    try
    {
      InputStream inStream = null;
      int totalBytesRead = 1;
      int minLines = 1;int maxlines = 10000;
      try
      {
        inStream = this.upFile.getInputStream();
        while (lnr.getLineNumber() > totalBytesRead)
        {
          for (totalBytesRead = minLines; totalBytesRead <= maxlines; totalBytesRead++)
          {
            System.out.println("reading file" + lnr.readLine());
            minLines++;
          }
          minLines = maxlines + 1;
          maxlines = minLines + 10000;
        }
      }
      finally
      {
        inStream.close();
      }
    }
    catch (FileNotFoundException ex)
    {
      ex.printStackTrace();
    }
    catch (IOException ex)
    {
      ex.printStackTrace();
    }
    return nameList;
  }
  
  void write(byte[] DataByteArray, String DestinationFileName)
  {
    try
    {
      OutputStream output = null;
      try
      {
        output = new BufferedOutputStream(new FileOutputStream(DestinationFileName));
        
        output.write(DataByteArray);
        System.out.println("Writing Process Was Performed");
      }
      finally
      {
        output.close();
      }
    }
    catch (FileNotFoundException ex)
    {
      ex.printStackTrace();
    }
    catch (IOException ex)
    {
      ex.printStackTrace();
    }
  }
  
  public void setImportedMembers(RichTable importedMembers)
  {
    this.importedMembers = importedMembers;
  }
  
  public RichTable getImportedMembers()
  {
    return this.importedMembers;
  }
  
  public void setImportedPrem(RichTable importedPrem)
  {
    this.importedPrem = importedPrem;
  }
  
  public RichTable getImportedPrem()
  {
    return this.importedPrem;
  }
  
  public void setImportedPensMem(RichTable importedPensMem)
  {
    this.importedPensMem = importedPensMem;
  }
  
  public RichTable getImportedPensMem()
  {
    return this.importedPensMem;
  }
  
  public void setDynamicContainer(HtmlPanelGrid dynamicContainer)
  {
    this.dynamicContainer = dynamicContainer;
  }
  
  public HtmlPanelGrid getDynamicContainer()
  {
    return this.dynamicContainer;
  }
  
  public void setSearchCriteria(RichSelectOneChoice searchCriteria)
  {
    this.searchCriteria = searchCriteria;
  }
  
  public RichSelectOneChoice getSearchCriteria()
  {
    return this.searchCriteria;
  }
  
  public void setAllPolicyBatches(RichSelectOneChoice allPolicyBatches)
  {
    this.allPolicyBatches = allPolicyBatches;
  }
  
  public RichSelectOneChoice getAllPolicyBatches()
  {
    return this.allPolicyBatches;
  }
  
  public void setExportMembers(RichTable exportMembers)
  {
    this.exportMembers = exportMembers;
  }
  
  public RichTable getExportMembers()
  {
    return this.exportMembers;
  }
  
  public void searchListener(ValueChangeEvent valueChangeEvent)
  {
    if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue())
    {
      ADFUtils.findIterator("findInvalidMembersIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.importedMembers);
    }
  }
}
