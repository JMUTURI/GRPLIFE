package LMSG.view.ecm;

import LMSG.view.Base.GlobalCC;
import LMSG.view.connect.DBConnector;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.sql.DataSource;

import oracle.adf.view.rich.component.rich.input.RichSelectBooleanRadio;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.input.RichSelectOneRadio;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.nav.RichCommandLink;
import oracle.adf.view.rich.component.rich.output.RichOutputLabel;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OracleTypes;


public class ReportEngine {
    private RichCommandLink rptlink;
    private RichOutputLabel importProcessStatusUnk;
    private RichOutputLabel olConfirmMsgValueUnk;
    private RichOutputLabel olConfirmMsgValue;
    private RichOutputLabel importProcessStatus;

    public ReportEngine() {
        super();
    }

    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    private RichSelectOneRadio repFormat;
    private RichCommandButton rptBtn;
    private RichCommandLink rpt1;
    private RichSelectBooleanRadio radioBtn;
    private RichSelectOneChoice sendTo;

  public String reportOne(BigDecimal rptCode) {

      XMLPublisher xmlPublisher = new XMLPublisher();

      String templateFile = null;
      String styleFile = null;
      String reportName = null;
      String dataFile = null;
      byte[] bytes = null;
      String reportFormat = null;
      if (repFormat != null) {
          reportFormat = GlobalCC.checkNullValues(repFormat.getValue());
      } else if (session.getAttribute("outputFormat") != null) {
          reportFormat = (String)session.getAttribute("outputFormat");
      } else {
          reportFormat = "pdf";
      }
      DBConnector datahandler = new DBConnector();
      Connection conn;
      conn = datahandler.getDatabaseConn();
      CallableStatement cst = null;
      if (rptCode.toString().equalsIgnoreCase("0")) {
          //System.out.println("Report Not Attached");
          GlobalCC.errorValueNotEntered("Report Not Attached");
          return null;
      }
      System.out.println(" JOSE " + rptCode);
      String jobquery = "begin ? := tqc_web_cursor.getRptDetails(?); end;";
      
      try {
          conn = datahandler.getDatabaseConn();
          cst = conn.prepareCall(jobquery);
          cst.registerOutParameter(1, OracleTypes.CURSOR);
          cst.setBigDecimal(2, rptCode);
          cst.executeQuery();
          OracleResultSet rs = (OracleResultSet)cst.getObject(1);

          while (rs.next()) {
              templateFile = rs.getString(5);
              styleFile = rs.getString(7);
              reportName = rs.getString(2);
              dataFile = rs.getString(3);
              session.setAttribute("title", reportName);
              
              System.out.println("rptCode1="+rptCode+"reportName2="+reportName);
          }
          xmlPublisher.dataEngine(reportName, dataFile, conn);
          bytes =
                  xmlPublisher.processorEngine(reportFormat, templateFile, styleFile,
                                               reportName);

          if (bytes == null) {
              return null;
          }

          FacesContext facesContext = FacesContext.getCurrentInstance();
          ExternalContext externalContext =
              facesContext.getExternalContext();
          HttpServletResponse response =
              (HttpServletResponse)externalContext.getResponse();
    
          BufferedOutputStream outputStream = null;
          String filename = null;
          filename = reportName;
          filename = filename.replace(" ", "_");
          String polno = (String)session.getAttribute("polNo");
          polno = polno.replace("/", "_");
          
          Date dt = new Date();
          SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy hh:mm:ss");
          
          String mainDir = GlobalCC.findSysParam("LMS_DMS_MAIN_DIR",null);
          String subDir = (String)session.getAttribute("transTypeSht");
          System.out.println("Main Dir "+ mainDir + "  " 
                             + " subDir " + subDir);
          
          filename = polno+filename+"-"+ft.format(dt).replace(":","").replace("/", "");
          session.setAttribute("filename", filename);
          String output = null;
          if (reportFormat == null || reportFormat.equals("pdf")) {
              output = filename + ".pdf";
              response.setContentType("application/pdf");
          } else {
              output = filename + "." + reportFormat;
              session.setAttribute("filename", filename);
              response.setContentType("application/octet-stream");
              // response.setContentType("vnd.ms-excel");
          }
          
          String rootDir = (String)session.getAttribute("workingDir");
          
          try {
              OutputStream out;
              String file;
              String Os = (String)session.getAttribute("workingOS");
              String folder2 = null;
              String transType = (String)session.getAttribute("transType");
              
              if(subDir.equalsIgnoreCase("PSUR")){
                  subDir = "CLM_GRP";
              }
              if(subDir.equalsIgnoreCase("LNA")){
                  subDir = "CLM_GRP";
              }
              
              if(Os.toLowerCase().indexOf("win")>0) {
                  file = mainDir+"/"+subDir+"_"+output;
                  folder2 = mainDir;
              } else {
                  file = mainDir+"/"+subDir+"_"+output;
                  folder2 = mainDir;

              }
      
              File folder = new File(folder2);
              File toPrint = new File(file);
              
              if(!folder.exists()){
                  folder.mkdirs();
              } 
              out = new FileOutputStream(toPrint);
              int read = 0;
              
              out.write(bytes, 0, bytes.length);
              out.flush();
              out.close();
          } finally {
              
          }
          GenerateTemplateFile();
          System.out.println("We finished here at the report! ");

          if (rptBtn != null) {
              AdfFacesContext.getCurrentInstance().addPartialTarget(rptBtn);
          } 
     
          conn.commit();
          conn.close();

      } catch (Exception e) {
          e.printStackTrace();
          GlobalCC.EXCEPTIONREPORTING(null, e);
      }

      return null;
  }
  
  //generate my csv
  public String GenerateTemplateFile() {
      
      
      try {
          String polno = (String)session.getAttribute("polNo");
          String endrNo = (String)session.getAttribute("endrNo");
          String transType = (String)session.getAttribute("transType");
          String transTypeSht = (String)session.getAttribute("transTypeSht");
          String docName = (String)session.getAttribute("docName");
          String prodTy = "";
          if (transTypeSht.equals("UW_GRP")){
               prodTy = "Policy No,Endorsement No, Transaction Type, " +
                  "Document Name";
          }
          if (transTypeSht.equals("CLM_GRP")){
              prodTy = "Policy No,Claim No, Transaction Type, " +
                  "Document Name";
          }
         
          String Params = polno+","+endrNo+","+transType+","+docName;
          
          String Header = prodTy + "\n" + Params;
          byte barray[] = Header.getBytes();
          String filename = (String)session.getAttribute("filename");
          String mainDir = GlobalCC.findSysParam("LMS_DMS_MAIN_DIR",null);
          String subDir = (String)session.getAttribute("transTypeSht");
          OutputStream out;
          String file;
          String rootDir = (String)session.getAttribute("workingDir");
          String Os = (String)session.getAttribute("workingOS");
          String folder2 = null;
          if(Os.toLowerCase().indexOf("win")>0) {
              file = mainDir+"/"+subDir+"_"+filename+".csv";
              folder2 = mainDir;
          } else {
              file = mainDir+"/"+subDir+"_"+filename+".csv";
              folder2 = mainDir;
          }
          
          File folder = new File(folder2);
          File toPrint = new File(file);
          
          if(!folder.exists()){
              folder.mkdirs();
          } 
          out = new FileOutputStream(toPrint);
          int read = 0;
          
          out.write(barray, 0, barray.length);
          out.flush();
          out.close();

      } catch (Exception e) {
          
          e.printStackTrace();
      }
      return null;
  }
    
    public String[] reportData(String rptCode) {
        String[] dataDetails = new String[4];
        String templateFile = null;
        String dataFile = null;
        String reportName = null;
        String styleFile = null;
        String output = null;
        XMLPublisher xmlPublisher = new XMLPublisher();
        byte[] bytes = null;
        String reportFormat = null;


        if (repFormat != null) {
            reportFormat = GlobalCC.checkNullValues(repFormat.getValue());
        } else if (session.getAttribute("outputFormat") != null) {
            reportFormat = (String)session.getAttribute("outputFormat");
        } else {
            reportFormat = "pdf";
        }
        DBConnector dbConnector = new DBConnector();
        OracleConnection conn = null;
        OracleCallableStatement cst = null;
        if (rptCode.toString().equalsIgnoreCase("0")) {
            //System.out.println("Report Not Attached");
            GlobalCC.errorValueNotEntered("Report Not Attached");
            return null;
        }

        System.out.println(" JOSE " + rptCode);
        String jobquery = "begin ? := tqc_web_cursor.getRptDetails(?); end;";

        try {
            conn = dbConnector.getDatabaseConnection();
            cst = (OracleCallableStatement)conn.prepareCall(jobquery);
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setString(2, rptCode);
            cst.executeQuery();
            OracleResultSet rs = (OracleResultSet)cst.getObject(1);

            while (rs.next()) {
                templateFile = rs.getString(5);
                styleFile = rs.getString(7);
                reportName = rs.getString(2);
                dataFile = rs.getString(3);

                //System.out.println("rptCode=>"+rptCode+";templateFile=>"+templateFile+";dataFile="+dataFile);

                session.setAttribute("title", reportName);
                //styleFile = styleFile.toUpperCase();
                // styleFile = styleFile.replace(".XSL", ".xsl");
                //dataFile = dataFile.toUpperCase();
                // dataFile = dataFile.replace(".XML", ".xml");
                //templateFile = templateFile.toUpperCase();
                //  templateFile = templateFile.replace(".RTF", ".rtf");
                // reportName = reportName.toUpperCase();

                System.out.println(reportName);
            }
            output = reportName + "." + reportFormat;
            dataDetails[0] = templateFile;
            dataDetails[1] = dataFile;
            dataDetails[2] = styleFile;
            dataDetails[3] = output;

            xmlPublisher.dataEngine(reportName, dataFile, conn);

            bytes =
                    xmlPublisher.processorEngine(reportFormat, templateFile, styleFile,
                                                 reportName);
            conn.commit();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return dataDetails;
    }

    public File SaveReportOne(BigDecimal rptCode) {
        XMLPublisher xmlPublisher = new XMLPublisher();

        String templateFile = null;
        String styleFile = null;
        String reportName = null;
        String dataFile = null;
        byte[] bytes = null;
        File file = null;
        String reportFormat = null;
        if (repFormat != null) {
            reportFormat = GlobalCC.checkNullValues(repFormat.getValue());
        } else if (session.getAttribute("outputFormat") != null) {
            reportFormat = (String)session.getAttribute("outputFormat");
        } else {
            reportFormat = "pdf";
        }
        DBConnector dbConnector = new DBConnector();
        OracleConnection conn = null;
        OracleCallableStatement cst = null;
        if (rptCode.toString().equalsIgnoreCase("0")) {
            //System.out.println("Report Not Attached");
            GlobalCC.errorValueNotEntered("Report Not Attached");
            return null;
        }
        String jobquery = "begin ? := tqc_web_cursor.getRptDetails(?); end;";

        try {
            conn = dbConnector.getDatabaseConnection();
            cst = (OracleCallableStatement)conn.prepareCall(jobquery);
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2, rptCode);
            cst.executeQuery();
            OracleResultSet rs = (OracleResultSet)cst.getObject(1);
            System.out.println(" JOSE " + rptCode);
            while (rs.next()) {
                templateFile = rs.getString(5);
                styleFile = rs.getString(7);
                reportName = rs.getString(2);
                dataFile = rs.getString(3);
                session.setAttribute("title", reportName);
                //styleFile = styleFile.toUpperCase();
                // styleFile = styleFile.replace(".XSL", ".xsl");
                //dataFile = dataFile.toUpperCase();
                // dataFile = dataFile.replace(".XML", ".xml");
                //templateFile = templateFile.toUpperCase();
                //  templateFile = templateFile.replace(".RTF", ".rtf");
                // reportName = reportName.toUpperCase();

                System.out.println(reportName);
            }
            xmlPublisher.dataEngine(reportName, dataFile, conn);

            file =
xmlPublisher.FileProcessorEngine(reportFormat, templateFile, styleFile,
                                 reportName);

conn.close();
            /*bytes
          HttpServletResponse response =
              (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
          ServletOutputStream servletOutputStream;
          response.reset();
          response.resetBuffer();
          servletOutputStream = response.getOutputStream();


          String filename = null;
          filename = reportName;
        File file = new File(reportName);
          file.

          String output = null;
          if (reportFormat == null) {

              output = filename + ".pdf";
          } else {
              output = filename + "." + reportFormat;
          }


          response.setContentType("application/octet-stream");
          response.setHeader("Content-disposition",
                             "attachment; filename=" + output + "");


          response.setContentLength(bytes.length);

          servletOutputStream.write(bytes, 0, bytes.length);
          servletOutputStream.flush();
          servletOutputStream.close();
          AdfFacesContext.getCurrentInstance().addPartialTarget(rptBtn);*/

        } catch (Exception e) {
            e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return file;
    }


    public void LmsReport(ActionEvent actionEvent) {
        String reportId = actionEvent.getComponent().getId();
        if(reportId.contains("1998")){
          reportId=reportId.replaceAll(reportId, "1998");
            }
        else if(reportId.contains("2120")){
        reportId=reportId.replaceAll(reportId, "2120");
          }
        else if(reportId.contains("25186")){
        reportId=reportId.replaceAll(reportId, "25186");
          }
        else{
        reportId = reportId.replace("rpt", "");
        }
        if (reportId.equalsIgnoreCase("0")) {
            if (session.getAttribute("rptCode") == null) {
                GlobalCC.errorValueNotEntered("No Report Selected");
            } else {
                reportId = (String)session.getAttribute("rptCode");
                reportId = reportId.replace("rpt", "");
                reportOne(new BigDecimal(reportId));
            }
        } else {
            reportId = reportId.replace("rpt", "");
            reportOne(new BigDecimal(reportId));
        }
        System.out.println("PolCode: " +
                           session.getAttribute("policyProposalCode"));
        System.out.println("reportId: " + reportId);
        System.out.println("marturityNo:" +
                           session.getAttribute("marturityNo"));
    }

    public void LmsReport2() {
        String reportId = (String)(session.getAttribute("rptCode"));
        if (reportId.equalsIgnoreCase("0")) {
            if (session.getAttribute("rptCode") == null) {
                GlobalCC.errorValueNotEntered("No Report Selected");
            } else {
                reportId = (String)session.getAttribute("rptCode");
                reportId = reportId.replace("rpt", "");
                reportOne(new BigDecimal(reportId));
            }
        } else {
            reportId = reportId.replace("rpt", "");
            reportOne(new BigDecimal(reportId));
        }
        System.out.println("PolCode: " +
                           session.getAttribute("policyProposalCode"));
        System.out.println("reportId: " + reportId);
        System.out.println("marturityNo:" +
                           session.getAttribute("marturityNo"));
    }

    public void activeRpt(ActionEvent actionEvent) {
        
        //public activeRpt(String rptName) {
        String reportId = actionEvent.getComponent().getId().trim();
        System.out.print("report id"+reportId);
        //reportId = reportId.replace("rpt", "");
        DBConnector dbConn = new DBConnector();
        OracleConnection conn = null;
        conn = dbConn.getDatabaseConnection();
        String rptCode = null;
        OracleCallableStatement cst = null;
        try {
            String sysQuery = "begin LMS_WEB_PKG2.is_report_active(?,?); end;";
            cst = (OracleCallableStatement)conn.prepareCall(sysQuery);
            //register out
            cst.setString(1, reportId);
            cst.registerOutParameter(2, OracleTypes.VARCHAR);
            cst.execute();
            rptCode = cst.getString(2);
            System.out.print("REPORT CODE 2"+rptCode);
            session.setAttribute("rptCode", rptCode);
            LmsReport2();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
    }

    public void printToprinter(ActionEvent actionEvent) {
        String reportId = actionEvent.getComponent().getId();
        reportId = reportId.replace("rpt", "");
        if (reportId.equalsIgnoreCase("0")) {
            if (session.getAttribute("rptCode") == null) {
                GlobalCC.errorValueNotEntered("No Report Selected");
            } else {
                reportId = (String)session.getAttribute("rptCode");
                reportId = reportId.replace("rpt", "");
                reportOne(new BigDecimal(reportId));
            }
        } else {
            reportId = reportId.replace("rpt", "");
            reportOne(new BigDecimal(reportId));
        }

    }

    public void accountLvl(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue()) {
            if (valueChangeEvent.getNewValue() == null) {
                session.setAttribute("accLvl", null);
            } else {
                session.setAttribute("accLvl",
                                     new BigDecimal(valueChangeEvent.getNewValue().toString()));
            }
        }
        // Add event code here...
    }

    public void consBrh(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue()) {
            if (valueChangeEvent.getNewValue() == null) {
                session.setAttribute("consBrh", "N");
            } else {
                if (valueChangeEvent.getNewValue().toString().equalsIgnoreCase("true")) {
                    session.setAttribute("consBrh", "Y");
                } else {
                    session.setAttribute("consBrh", "N");
                }
            }
        }
    }

    public void dateTo(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue()) {
            if (valueChangeEvent.getNewValue() == null) {
                session.setAttribute("dateTo", null);
            } else {
                session.setAttribute("dateTo",
                                     GlobalCC.parseDate(valueChangeEvent.getNewValue().toString()));

            }
        }
    }

    public void chequeTo(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue()) {
            if (valueChangeEvent.getNewValue() == null) {
                session.setAttribute("valTo", null);
            } else {
                session.setAttribute("valTo", valueChangeEvent.getNewValue());

            }
        }
    }

    public void chequeFrom(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue()) {
            if (valueChangeEvent.getNewValue() == null) {
                session.setAttribute("valFrom", null);
            } else {
                session.setAttribute("valFrom",
                                     valueChangeEvent.getNewValue());

            }
        }
    }

    public void dateFrom(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue()) {
            if (valueChangeEvent.getNewValue() == null) {
                session.setAttribute("dateFrom", null);
            } else {
                session.setAttribute("dateFrom",
                                     GlobalCC.parseDate(valueChangeEvent.getNewValue().toString()));

            }
        }
    }

    public void weekEnding(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue()) {
            if (valueChangeEvent.getNewValue() == null) {
                session.setAttribute("weekending", null);
            } else {
                session.setAttribute("weekending",
                                     GlobalCC.parseDate(valueChangeEvent.getNewValue().toString()));


            }
        }
    }

    public void outputFormat(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue()) {
            if (valueChangeEvent.getNewValue() == null) {
                session.setAttribute("outputFormat", null);
            } else {
                session.setAttribute("outputFormat",
                                     valueChangeEvent.getNewValue().toString());

            }
        }
    }

    public void serialNo(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue()) {
            if (valueChangeEvent.getNewValue() == null) {
                session.setAttribute("serialNo", null);
            } else {
                session.setAttribute("serialNo",
                                     valueChangeEvent.getNewValue().toString());

            }
        }
    }

    public void rptType(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue()) {
            if (valueChangeEvent.getNewValue() == null) {
                session.setAttribute("rptCode", null);
            } else {
                session.setAttribute("rptCode",
                                     valueChangeEvent.getNewValue().toString());

            }
            //System.out.println("Report Value");
            //System.out.println(valueChangeEvent.getNewValue());

        }
    }

    public void finRptVal(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue()) {
            if (valueChangeEvent.getNewValue() == null) {
                session.setAttribute("rptCode", null);
            } else {
                RichSelectBooleanRadio myRadio =
                    (RichSelectBooleanRadio)valueChangeEvent.getComponent();
                if (myRadio.isSelected()) {
                    //System.out.println(valueChangeEvent.getComponent().getId());
                    session.setAttribute("rptCode",
                                         valueChangeEvent.getComponent().getId());
                }

            }
        }
    }


    public void accAllSelec(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue()) {
            if (valueChangeEvent.getNewValue() == null) {
                session.setAttribute("allSelAcc", null);
            } else {
                session.setAttribute("allSelAcc",
                                     valueChangeEvent.getNewValue().toString());

            }
        }
    }

    public void consDivs(ValueChangeEvent evt) {
        if (evt.getNewValue() != evt.getOldValue() &&
            evt.getNewValue() != null) {
            //System.out.println("Value");
            if (evt.getNewValue().toString().equalsIgnoreCase("false")) {
                session.setAttribute("consDiv", false);
            } else {
                session.setAttribute("consDiv", true);

            }
            //System.out.println( session.getAttribute("consDiv"));
        }
    }

    public void consBranch(ValueChangeEvent evt) {
        if (evt.getNewValue() != evt.getOldValue() &&
            evt.getNewValue() != null) {
            if (evt.getNewValue().toString().equalsIgnoreCase("false")) {
                session.setAttribute("consBrh", false);
            } else {
                session.setAttribute("consBrh", true);

            }
        }
    }

    public void consOrg(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue() &&
            valueChangeEvent.getNewValue() != null) {

            if (valueChangeEvent.getNewValue().toString().equalsIgnoreCase("false")) {
                session.setAttribute("consOrg", false);
            } else {
                session.setAttribute("consOrg", true);

            }
        }
    }

    public void paramReport(ActionEvent actionEvent) {
        String reportId = actionEvent.getComponent().getId();
        reportId = reportId.replace("rpt", "");
        if (reportId.equalsIgnoreCase("0")) {
            if (session.getAttribute("rptCode") == null) {
                GlobalCC.errorValueNotEntered("No Report Selected");
            } else {
                reportId = (String)session.getAttribute("rptCode");
                reportId = reportId.replace("rpt", "");
                session.setAttribute("rptCode", reportId);
                GlobalCC.showPopup("demoTemplate:paramReport");
            }
        } else {
            reportId = reportId.replace("rpt", "");
            session.setAttribute("rptCode", reportId);
            GlobalCC.showPopup("demoTemplate:paramReport");
        }

    }

    public String genRpt() {
        String reportId = (String)session.getAttribute("rptCode");
        reportOne(new BigDecimal(reportId));
        return null;
    }

    public String launchParamRpt() {
        String reportId = rptlink.getId();
        reportId = reportId.replace("rpt", "");
        if (reportId.equalsIgnoreCase("0")) {
            if (session.getAttribute("rptCode") == null) {
                GlobalCC.errorValueNotEntered("No Report Selected");
            } else {
                reportId = (String)session.getAttribute("rptCode");
                reportId = reportId.replace("rpt", "");
                session.setAttribute("rptCode", reportId);
                GlobalCC.showPopup("demoTemplate:paramReport");

            }
        } else {
            reportId = reportId.replace("rpt", "");
            session.setAttribute("rptCode", reportId);
            GlobalCC.showPopup("demoTemplate:paramReport");

        }
        return null;
    }

   

    public void verificationReport(ActionEvent actionEvent) {
        BigDecimal polCode =
            (BigDecimal)session.getAttribute("policyProposalCode");
        if (polCode == null) {
            GlobalCC.errorValueNotEntered("Error Value Missing: Policy Code");
        } else {
            String reportId = actionEvent.getComponent().getId();
            reportId = reportId.replace("rpt", "");
            if (reportId.equalsIgnoreCase("0")) {
                if (session.getAttribute("rptCode") == null) {
                    GlobalCC.errorValueNotEntered("No Report Selected");
                } else {
                    reportId = (String)session.getAttribute("rptCode");
                    reportId = reportId.replace("rpt", "");
                    reportOne(new BigDecimal(reportId));
                }
            } else {
                reportId = reportId.replace("rpt", "");
                reportOne(new BigDecimal(reportId));
            }
        }

    }

    public void directPolicyReport(ActionEvent actionEvent) {
        BigDecimal polCode =
            (BigDecimal)session.getAttribute("policyProposalCode");
        if (polCode == null) {
            GlobalCC.errorValueNotEntered("Error Value Missing: Policy Code");
        } else {
            String reportId = actionEvent.getComponent().getId();
            reportId = reportId.replace("rpt", "");
                        
            if (reportId.equalsIgnoreCase("0")) {
                if (session.getAttribute("rptCode") == null) {
                    GlobalCC.errorValueNotEntered("No Report Selected");
                } else {
                    reportId = (String)session.getAttribute("rptCode");
                    reportId = reportId.replace("rpt", "");
                    reportOne(new BigDecimal(reportId));
                }
            } else {
                reportId = reportId.replace("rpt", "");
                reportOne(new BigDecimal(reportId));
            }
        }

  }

    public void dischargeVoucher(ActionEvent actionEvent) {
        
    String reportId = actionEvent.getComponent().getId();
    reportId = reportId.replace("rpt", "");            
          
    //GlobalCC.errorValueNotEntered("Reportid:"+reportId);
          
    if (reportId.equalsIgnoreCase("0")) {
        if (session.getAttribute("rptCode") == null) {
            GlobalCC.errorValueNotEntered("No Report Selected");
        } else {
            reportId = (String)session.getAttribute("rptCode");
            reportId = reportId.replace("rpt", "");
            reportOne(new BigDecimal(reportId));
        }
    } else {
        reportId = reportId.replace("rpt", "");
        reportOne(new BigDecimal(reportId));
    }
    
  }
    
  public void directPolReport(ActionEvent actionEvent) {
      BigDecimal polCode =
          (BigDecimal)session.getAttribute("policyProposalCode");
      if (polCode == null) {
          GlobalCC.errorValueNotEntered("Error Value Missing: Policy Code");
      } else {
          String reportId = actionEvent.getComponent().getId();
          reportId = reportId.replace("rp", "");
          if (reportId.equalsIgnoreCase("0")) {
              if (session.getAttribute("rptCode") == null) {
                  GlobalCC.errorValueNotEntered("No Report Selected");
              } else {
                  reportId = (String)session.getAttribute("rptCode");
                  reportId = reportId.replace("rpt", "");
                  reportOne(new BigDecimal(reportId));
              }
          } else {
              reportId = reportId.replace("rp", "");
              reportOne(new BigDecimal(reportId));
          }
      }

  }
  
  public void directPlcyReport(ActionEvent actionEvent) {
      BigDecimal polCode =
          (BigDecimal)session.getAttribute("policyProposalCode");
      if (polCode == null) {
          GlobalCC.errorValueNotEntered("Error Value Missing: Policy Code");
      } else {
          String reportId = actionEvent.getComponent().getId();
          reportId = reportId.replace("rt", "");
          if (reportId.equalsIgnoreCase("0")) {
              if (session.getAttribute("rptCode") == null) {
                  GlobalCC.errorValueNotEntered("No Report Selected");
              } else {
                  reportId = (String)session.getAttribute("rptCode");
                  reportId = reportId.replace("rpt", "");
                  reportOne(new BigDecimal(reportId));
              }
          } else {
              reportId = reportId.replace("rp", "");
              reportOne(new BigDecimal(reportId));
          }
      }

  }

  

    public void directEndorsementReport(ActionEvent actionEvent) {
        BigDecimal endorseCode =
            (BigDecimal)session.getAttribute("endorsementCode");
        if (endorseCode == null) {
            GlobalCC.errorValueNotEntered("Error Value Missing: Endorsement Code");
        } else {
            String reportId = actionEvent.getComponent().getId();
            reportId = reportId.replace("rpt", "");
            if (reportId.equalsIgnoreCase("0")) {
                if (session.getAttribute("rptCode") == null) {
                    GlobalCC.errorValueNotEntered("No Report Selected");
                } else {
                    reportId = (String)session.getAttribute("rptCode");
                    reportId = reportId.replace("rpt", "");
                    reportOne(new BigDecimal(reportId));
                }
            } else {
                reportId = reportId.replace("rpt", "");
                reportOne(new BigDecimal(reportId));
            }
        }

    }

    public void setRepFormat(RichSelectOneRadio repFormat) {
        this.repFormat = repFormat;
    }

    public RichSelectOneRadio getRepFormat() {
        return repFormat;
    }

    public void setRptBtn(RichCommandButton rptBtn) {
        this.rptBtn = rptBtn;
    }

    public RichCommandButton getRptBtn() {
        return rptBtn;
    }

    public void setRpt1(RichCommandLink rpt1) {
        this.rpt1 = rpt1;
    }

    public RichCommandLink getRpt1() {
        return rpt1;
    }

    public void setRadioBtn(RichSelectBooleanRadio radioBtn) {
        this.radioBtn = radioBtn;
    }

    public RichSelectBooleanRadio getRadioBtn() {
        return radioBtn;
    }

    public void setSendTo(RichSelectOneChoice sendTo) {
        this.sendTo = sendTo;
    }

    public RichSelectOneChoice getSendTo() {
        return sendTo;
    }


    public void setRptlink(RichCommandLink rptlink) {
        this.rptlink = rptlink;
    }

    public RichCommandLink getRptlink() {
        return rptlink;
    }
  
  public void runFmsReport(String reportId) {
   
     
      reportId = reportId.replaceAll("rpt", "");
      if (reportId.equalsIgnoreCase("0")) {
          if (session.getAttribute("rptCode") == null) {
              GlobalCC.errorValueNotEntered("No Report Selected");
          } else {
            
              reportId = (String)session.getAttribute("rptCode");
              reportId = reportId.replaceAll("rpt", "");
            System.out.println("here1  "+reportId);
              if(reportId.equalsIgnoreCase("198")) 
              {   System.out.println("here2");
               if(!validateTrialBalance())
               { 
                //   GlobalCC.launchPopup("TbMessage");
                     GlobalCC.INFORMATIONREPORTING("TRANSACTION UPDATE IN PROGRESS.THE REPORT WILL BE GENERATED SHORTLY.");
                     actionRefreshTb();
                   return;
                   }
                   
                 }
              
              reportOne(new BigDecimal(reportId));
           
          }
      } else {
          reportId = reportId.replace("rpt", "");
          reportOne(new BigDecimal(reportId));
      }

  return;
  }
   
  public boolean validateTrialBalance() {
  
          DBConnector datahandler = new DBConnector();
          OracleConnection conn = null;
          conn = datahandler.getDatabaseConnection();
          OracleCallableStatement cst = null;
          try {

              String query =
                  "begin ?:=fms_management_pkg.Trial_Balance_Query(?,?); end;";
              cst = (OracleCallableStatement)conn.prepareCall(query);
                  cst.registerOutParameter(1, OracleTypes.NUMBER);
              cst.setObject(2, session.getAttribute("orgCode"));
              cst.setObject(3, session.getAttribute("year"));
              cst.execute();
              BigDecimal val=cst.getBigDecimal(1);
              if(val.compareTo(new BigDecimal("0"))==0)
                  return true;
              cst.close();
              conn.close();
                } catch (Exception e) {
              GlobalCC.EXCEPTIONREPORTING(conn, e);
          }
    finally {
        try {
          cst.close();
          conn.close();  
        }
        catch(Exception e) {
          GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
       
    }
  
    return false;
  }

    public String actionRefreshTb() {
       
    String success=null;
      DBConnector datahandler = new DBConnector();
      OracleConnection conn = null;
      conn = datahandler.getDatabaseConnection();
      OracleCallableStatement cst = null;
      try {

          String query =
              "begin fms_management_pkg.populateYearTrialBal(?,?); end;";
          cst = (OracleCallableStatement)conn.prepareCall(query);
          cst.setObject(1, session.getAttribute("orgCode"));
          cst.setObject(2, session.getAttribute("year"));
          cst.execute();
          cst.close();
          conn.close();
          
              success="success";
          // GlobalCC.closePopup("TbMessage");
          //GlobalCC.INFORMATIONREPORTING("TRANSACTION UPDATE COMPLETE.");
            reportOne(new BigDecimal("198"));
            } catch (Exception e) {
          GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
      finally {
          try {
            cst.close();
            conn.close();  
          }
          catch(Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
          }
         
      }
        return success;
    }
  public void runFmsTeplateReport(String reportId) {
   
      session.setAttribute("outputFormat","xls");
      reportId = reportId.replaceAll("rpt", "");
      if (reportId.equalsIgnoreCase("0")) {
          if (session.getAttribute("rptCode") == null) {
              GlobalCC.errorValueNotEntered("No Report Selected");
          } else {
            
              reportId = (String)session.getAttribute("rptCode");
              reportId = reportId.replaceAll("rpt", "");
            System.out.println("here1  "+reportId);
              if(reportId.equalsIgnoreCase("198")) 
              {   System.out.println("here2");
               if(!validateTrialBalance())
               { 
                //   GlobalCC.launchPopup("TbMessage");
                     GlobalCC.INFORMATIONREPORTING("TRANSACTION UPDATE IN PROGRESS.THE REPORT WILL BE GENERATED SHORTLY.");
                     actionRefreshTb();
                   return;
                   }
                   
                 }
              
              reportOne(new BigDecimal(reportId));
           
          }
      } else {
          reportId = reportId.replace("rpt", "");
          reportOne(new BigDecimal(reportId));
      }

  return;
  }

    public void setImportProcessStatusUnk(RichOutputLabel importProcessStatusUnk) {
        this.importProcessStatusUnk = importProcessStatusUnk;
    }

    public RichOutputLabel getImportProcessStatusUnk() {
        return importProcessStatusUnk;
    }

    public void setOlConfirmMsgValueUnk(RichOutputLabel olConfirmMsgValueUnk) {
        this.olConfirmMsgValueUnk = olConfirmMsgValueUnk;
    }

    public RichOutputLabel getOlConfirmMsgValueUnk() {
        return olConfirmMsgValueUnk;
    }

    public void setOlConfirmMsgValue(RichOutputLabel olConfirmMsgValue) {
        this.olConfirmMsgValue = olConfirmMsgValue;
    }

    public RichOutputLabel getOlConfirmMsgValue() {
        return olConfirmMsgValue;
    }

    public void setImportProcessStatus(RichOutputLabel importProcessStatus) {
        this.importProcessStatus = importProcessStatus;
    }

    public RichOutputLabel getImportProcessStatus() {
        return importProcessStatus;
    }
}
