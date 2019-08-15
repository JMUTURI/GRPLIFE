package LMSG.view.ecm;


import LMSG.view.Base.GlobalCC;

import com.sun.java.util.collections.ArrayList;
import com.sun.java.util.collections.Iterator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;

import java.sql.Connection;

import oracle.jdbc.OracleConnection;
import java.sql.DriverManager;
import javax.faces.context.FacesContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import oracle.apps.xdo.XDOException;
import oracle.apps.xdo.common.pdf.util.PDFDocMerger;
import oracle.apps.xdo.dataengine.DataProcessor;
import oracle.apps.xdo.dataengine.Parameter;
import oracle.apps.xdo.template.FOProcessor;
import oracle.apps.xdo.template.RTFProcessor;
import oracle.apps.xdo.template.fo.util.FOUtility;


public class XMLPublisher {
    public XMLPublisher() {
    }

    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);

    public void foProcessorEngine() {
        try {
            FOProcessor processor = new FOProcessor();
            processor.setData("catalog.xml");
            processor.setTemplate("catalog.xsl");
            processor.setOutput("catalog.pdf");
            processor.setOutputFormat(FOProcessor.FORMAT_PDF);

            processor.generate();
        } catch (Exception e) {
            e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
    }

    public void foProcessorEngine2() {
        try {
            FOProcessor processor = new FOProcessor();
            processor.setData("catalogData.xml");
            processor.setTemplate("catalogData.xsl");
            processor.setOutput("catalogData.pdf");
            processor.setOutputFormat(FOProcessor.FORMAT_PDF);

            processor.generate();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
    }

    public byte[] processorEngine(String format, String templateFile,
                                  String styleFile, String reportName) {

        byte[] bytes = null;

        try {
            templateFile = "/Reports/" + templateFile;
            styleFile = "/Reports/" + styleFile;
            reportName = "/Reports/" + reportName;

            FacesContext context = FacesContext.getCurrentInstance();

            ServletContext sc =
                (ServletContext)context.getExternalContext().getContext();
            templateFile = sc.getRealPath(templateFile);
            styleFile = sc.getRealPath(styleFile);
            FOProcessor processor = new FOProcessor();
            RTFProcessor rtfProcessor = null; //input template
            rtfProcessor = new RTFProcessor(templateFile);
            rtfProcessor.setOutput(styleFile);
            rtfProcessor.process();

            /*  RTFProcessor rtfProcessor =
                new RTFProcessor(templateFile); //input template
            rtfProcessor.setOutput(styleFile); // output file
            rtfProcessor.process();
*/
            //System.out.println("First");
            String filename = null;
            filename = reportName;

            String data = reportName + ".xml";
            String template = styleFile;
            data = sc.getRealPath(data);
            filename = sc.getRealPath(filename);
            String output = null;
            processor.setData(data);
            processor.setTemplate(template);
            processor.setOutput(output);
            if (format == null) {
                processor.setData(data);
                processor.setTemplate(template);
                processor.setOutput(filename + ".pdf");
                output = filename + ".pdf";
                processor.setOutputFormat(FOProcessor.FORMAT_PDF);
            } else {
                processor.setData(data);
                processor.setTemplate(template);
                processor.setOutput(filename + "." + format);
                output = filename + "." + format;
                if (format.equalsIgnoreCase("pdf")) {
                    processor.setOutput(filename + "." + format);
                    processor.setOutputFormat(FOProcessor.FORMAT_PDF);
                } else if (format.equalsIgnoreCase("rtf")) {
                    processor.setOutput(filename + "." + format);
                    processor.setOutputFormat(FOProcessor.FORMAT_RTF);
                } else if (format.equalsIgnoreCase("html")) {
                    processor.setOutput(filename + "." + format);
                    processor.setOutputFormat(FOProcessor.FORMAT_HTML);
                } else if (format.equalsIgnoreCase("xls")) {
                    processor.setOutput(filename + "." + format);
                    processor.setOutputFormat(FOProcessor.FORMAT_EXCEL);
                }
            }
            //System.out.println("Generate");
            processor.generate();
            System.out.println("post Generate output=" + output);
            File file = new File(output);
            bytes = getBytesFromFile(file);
            //System.out.println("Final");
        } catch (Exception e) {
            e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return bytes;
    }

    public File FileProcessorEngine(String format, String templateFile,
                                    String styleFile, String reportName) {

        byte[] bytes = null;
        File file = null;
        try {
            templateFile = "/Reports/" + templateFile;
            styleFile = "/Reports/" + styleFile;
            reportName = "/Reports/" + reportName;

            FacesContext context = FacesContext.getCurrentInstance();

            ServletContext sc =
                (ServletContext)context.getExternalContext().getContext();
            templateFile = sc.getRealPath(templateFile);
            styleFile = sc.getRealPath(styleFile);
            FOProcessor processor = new FOProcessor();
            RTFProcessor rtfProcessor = null; //input template
            rtfProcessor = new RTFProcessor(templateFile);

            rtfProcessor.setOutput(styleFile);

            rtfProcessor.process();

            /*  RTFProcessor rtfProcessor =
              new RTFProcessor(templateFile); //input template
          rtfProcessor.setOutput(styleFile); // output file
          rtfProcessor.process();
  */
            //System.out.println("First");
            String filename = null;
            filename = reportName;

            String data = reportName + ".xml";
            String template = styleFile;
            data = sc.getRealPath(data);
            filename = sc.getRealPath(filename);
            String output = null;
            processor.setData(data);
            processor.setTemplate(template);
            processor.setOutput(output);
            if (format == null) {
                processor.setData(data);
                processor.setTemplate(template);
                processor.setOutput(filename + ".pdf");
                output = filename + ".pdf";
                processor.setOutputFormat(FOProcessor.FORMAT_PDF);
            } else {
                processor.setData(data);
                processor.setTemplate(template);
                processor.setOutput(filename + "." + format);
                output = filename + "." + format;
                if (format.equalsIgnoreCase("pdf")) {
                    processor.setOutput(filename + "." + format);
                    processor.setOutputFormat(FOProcessor.FORMAT_PDF);
                } else if (format.equalsIgnoreCase("rtf")) {
                    processor.setOutput(filename + "." + format);
                    processor.setOutputFormat(FOProcessor.FORMAT_RTF);
                } else if (format.equalsIgnoreCase("html")) {
                    processor.setOutput(filename + "." + format);
                    processor.setOutputFormat(FOProcessor.FORMAT_HTML);
                } else if (format.equalsIgnoreCase("xls")) {
                    processor.setOutput(filename + "." + format);
                    processor.setOutputFormat(FOProcessor.FORMAT_EXCEL);
                }
            }
            //System.out.println("Generate");
            processor.generate();
            System.out.println("post Generate");
            file = new File(output);
            //bytes = getBytesFromFile(file);
            System.out.println(file);
        } catch (Exception e) {
            e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return file;
    }

    public byte[] getBytesFromFile(File file) {
        byte[] bytes = null;
        try {
            InputStream is = new FileInputStream(file);

            // Get the size of the file
            long length = file.length();

            if (length > Integer.MAX_VALUE) {
                // File is too large
            }

            // Create the byte array to hold the data
            bytes = new byte[(int)length];

            // Read in the bytes
            int offset = 0;
            int numRead = 0;
            while (offset < bytes.length &&
                   (numRead = is.read(bytes, offset, bytes.length - offset)) >=
                   0) {
                offset += numRead;
            }

            // Ensure all the bytes have been read in
            if (offset < bytes.length) {
                throw new IOException("Could not completely read file " +
                                      file.getName());
            }

            // Close the input stream and return bytes
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return bytes;
    }

    public void xslFoUtility() {
        try {
            InputStream[] input = new InputStream[2];
            InputStream firstFOStream =
                FOUtility.createFO("catalog2.xml", "catalog.xsl");
            InputStream secondFOStream =
                FOUtility.createFO("catalog3.xml", "catalog.xsl");
            Array.set(input, 0, firstFOStream);
            Array.set(input, 1, secondFOStream);

            InputStream mergedFOStream = FOUtility.mergeFOs(input, null);

            if (mergedFOStream == null) {
                //System.out.println("Merge failed.");
            }

            FOProcessor processor = new FOProcessor();

            processor.setData(mergedFOStream);
            processor.setTemplate((String)null);
            processor.setOutput("catalog2.pdf");
            processor.setOutputFormat(FOProcessor.FORMAT_PDF);
            processor.generate();
        } catch (Exception e) {
            e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
    }

    public void xslFoUtility2() {
        try {
            InputStream[] input = new InputStream[2];
            InputStream firstFOStream =
                FOUtility.createFO("catalogData.xml", "catalogData.xsl");
            //InputStream secondFOStream = FOUtility.createFO("catalog3.xml",  "catalog.xsl");
            Array.set(input, 0, firstFOStream);
            // Array.set(input, 1, secondFOStream);

            // InputStream mergedFOStream = FOUtility.mergeFOs(input, null);

            // if (mergedFOStream == null) {
            //     //System.out.println("Merge failed.");
            //   }

            FOProcessor processor = new FOProcessor();
            processor.setData(firstFOStream);
            processor.setTemplate((String)null);
            processor.setOutput("catalogData.pdf");
            processor.setOutputFormat(FOProcessor.FORMAT_PDF);
            processor.generate();
        } catch (Exception e) {
            e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
    }

    public void pdfDocumentMerger() {
        try {
            FileInputStream[] inputStreams = new FileInputStream[2];
            inputStreams[0] = new FileInputStream("catalog.pdf");
            inputStreams[1] = new FileInputStream("catalog2.pdf");

            FileOutputStream outputStream =
                new FileOutputStream("catalog3.pdf");
            PDFDocMerger pdfMerger =
                new PDFDocMerger(inputStreams, outputStream);

            pdfMerger.setPageNumberCoordinates(300, 20);
            pdfMerger.setPageNumberFontInfo("Courier", 10);
            pdfMerger.setPageNumberValue(1, 1);
            pdfMerger.process();
            pdfMerger = null;
        } catch (Exception e) {
            e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(null, e);
            //System.out.println("XDOException" + e.getMessage());
        }
    }

    public void dataEngine2() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            String url = "jdbc:oracle:thin:@10.176.18.64:1522:niger";
            OracleConnection jdbcConnection =
                (OracleConnection)DriverManager.getConnection(url, "TQ_FMS",
                                                              "TQ_FMS");

            DataProcessor dataProcessor = new DataProcessor();
            dataProcessor.setDataTemplate("FGLRVOUC.xml");


            //Get Parameters
            ArrayList parameters2 = dataProcessor.getParameters();
            //set Parameter Values as ArrayList of oracle.apps.xdo.dataengine.Parameter

            Iterator it = parameters2.iterator();

            while (it.hasNext()) {
                Parameter p = (Parameter)it.next();
                if (p.getName().equals("quoteCode")) {
                    p.setValue("2010729");
                } else if (p.getName().equals("UP_ORG_CODE")) {
                    p.setValue("2");

                } else if (p.getName().equals("UP_BRH_CODE")) {
                    p.setValue("76");
                } else if (p.getName().equals("UP_YER_YEAR")) {
                    p.setValue("2010");
                } else if (p.getName().equals("UP_PRD_PERIOD")) {
                    p.setValue("AUG");
                }
            }
            dataProcessor.setParameters(parameters2);

            dataProcessor.setParameters(parameters2);
            dataProcessor.setConnection(jdbcConnection);
            dataProcessor.setOutput("MyDataTemplate24.xml");
            dataProcessor.processData();
            dataProcessor.setParameters(parameters2);

            //OR you can set Parameter Values as Hashtable.

            /*  Hashtable parameters = new Hashtable();
             parameters2.put("p_DeptNo","10");
             dataProcessor.setParameters(parameters);

             dataProcessor.setConnection(jdbcConnection);
             dataProcessor.setOutput("/home/EmpDetails.xml")
             dataProcessor.processData();

          Hashtable parameters = new Hashtable();
          parameters.put("actCode", 100);*/
            dataProcessor.setParameters(parameters2);
            dataProcessor.setConnection(jdbcConnection);
            dataProcessor.setOutput("MyDataTemplate24.xml");
            dataProcessor.processData();

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
    }

    public void dataEngine(String reportName, String dataFile,
                           Connection conn) {
        try {


            FacesContext context = FacesContext.getCurrentInstance();
            ServletContext sc =
                (ServletContext)context.getExternalContext().getContext();
            dataFile = "/Reports/" + dataFile;
            reportName = "/Reports/" + reportName;
            String data = dataFile;
            data = sc.getRealPath(data);
            String output = reportName + ".xml";
            
            //GlobalCC.errorValueNotEntered("output:"+output);            
            
            output = sc.getRealPath(output);
            System.out.println("report path " + output);
            DataProcessor dataProcessor = new DataProcessor();
            dataProcessor.setDataTemplate(data);
            //Get Parameters
            ArrayList parameters2 = dataProcessor.getParameters();
            Iterator it = parameters2.iterator();

            while (it.hasNext()) {
                Parameter p = (Parameter)it.next();
                if (p.getName().equalsIgnoreCase("V_PROD_CODE")) {
                    p.setValue(session.getAttribute("productCode"));
                    if (session.getAttribute("productCode") == null) {
                        p.setValue(session.getAttribute("prodCode"));
                    }
                    System.out.print("prodcode22222>>>" +
                                     session.getAttribute("prodCode"));
                } else if(p.getName().equalsIgnoreCase("V_PROD_CODE_1")){
                    p.setValue(session.getAttribute("productCode2"));
                    if (session.getAttribute("productCode2") == null) {
                        p.setValue(session.getAttribute("prodCode2"));
                    }                  
                } else if (p.getName().equalsIgnoreCase("V_CLA_CODE")) {
                    p.setValue(session.getAttribute("claCode"));
                }else if (p.getName().equalsIgnoreCase("V_REPORT_TPE")) {
                    p.setValue(session.getAttribute("reportVal"));
                } else if (p.getName().equalsIgnoreCase("V_MONTH")) {
                    p.setValue(session.getAttribute("month"));
                }else if (p.getName().equalsIgnoreCase("V_BRN_CODE") ||
                           p.getName().equalsIgnoreCase("V_BRN_CODE_1") ||
                           p.getName().equalsIgnoreCase("V_BRN") ||
                           p.getName().equalsIgnoreCase("V_CHKPROPBRN") ||
                           p.getName().equalsIgnoreCase("V_ProppremBRN")) {
                    p.setValue(session.getAttribute("brnCode"));
                } else if (p.getName().equalsIgnoreCase("V_AGEN_CODE") ||
                           p.getName().equalsIgnoreCase("V_AGN_CODE")) {
                    p.setValue(session.getAttribute("agnCode"));
                    System.out.print("agnCode22222>>>" +
                                     session.getAttribute("agnCode"));
                } else if (p.getName().equalsIgnoreCase("V_DATE_1") ||
                           p.getName().equalsIgnoreCase("V_DATE_FROM")) {
                    p.setValue(session.getAttribute("dateFrom"));
                } else if (p.getName().equalsIgnoreCase("V_DATE_2") ||
                           p.getName().equalsIgnoreCase("V_DATE_TO")) {
                    p.setValue(session.getAttribute("dateTo"));
                } else if (p.getName().equalsIgnoreCase("V_ORG_CODE")) {
                    p.setValue(1);
                } else if (p.getName().equalsIgnoreCase("V_DATE_3")) {
                    p.setValue(session.getAttribute("dateThree"));
                } else if (p.getName().equalsIgnoreCase("V_POL_CODE")) {
                    p.setValue(session.getAttribute("policyProposalCode"));
                } else if (p.getName().equalsIgnoreCase("V_TT_CODE")) {
                    p.setValue(session.getAttribute("ttCode"));
                } else if (p.getName().equalsIgnoreCase("V_RATE_CODE")) {
                    p.setValue(session.getAttribute("rateCode"));
                } else if (p.getName().equalsIgnoreCase("V_AGNT_TYPE")) {
                    p.setValue(session.getAttribute("actCode"));
                } else if (p.getName().equalsIgnoreCase("V_ENDR_CODE")) {
                    p.setValue(session.getAttribute("endorsementCode"));
                } else if (p.getName().equalsIgnoreCase("V_USER")) {
                    p.setValue(session.getAttribute("Username"));
                } else if (p.getName().equalsIgnoreCase("V_TRANS_NO")) {
                    if (session.getAttribute("vtransno") == null) {
                        p.setValue(session.getAttribute("transNo"));
                    } else {
                        p.setValue(session.getAttribute("vtransno"));
                        System.out.println("ransn" +
                                           session.getAttribute("vtransno"));
                    }
                } else if (p.getName().equalsIgnoreCase("V_MAT_TYPE") ||
                           p.getName().equalsIgnoreCase("V_PM_MATURITY_TYPE")) {
                    p.setValue(session.getAttribute("maturityType"));
                } else if (p.getName().equalsIgnoreCase("V_DATE")) {
                    p.setValue(session.getAttribute("date"));
                } else if (p.getName().equalsIgnoreCase("V_P_STATUS")) {
                    p.setValue(session.getAttribute("policyStatus"));
                } else if (p.getName().equalsIgnoreCase("V_LNA_NO")) {
                    p.setValue(session.getAttribute("lnNo"));
                } else if (p.getName().equalsIgnoreCase("V_AUTHORIZED_BY")) {
                    p.setValue(session.getAttribute("authorizedBy"));
                } else if (p.getName().equalsIgnoreCase("V_CHECKED_BY")) {
                    p.setValue(session.getAttribute("checkedBy"));
                } else if (p.getName().equalsIgnoreCase("V_PVSOURCE")) {
                    p.setValue(session.getAttribute("source"));
                } else if (p.getName().equalsIgnoreCase("V_DESCRIPTION")) {
                    p.setValue(session.getAttribute("description"));
                } else if (p.getName().equalsIgnoreCase("V_PERIOD")) {
                    p.setValue(session.getAttribute("period"));
                } else if (p.getName().equalsIgnoreCase("V_QUO_CODE")) {
                    p.setValue(session.getAttribute("quoteCode"));
                } else if (p.getName().equalsIgnoreCase("V_PREPARED_BY")) {
                    p.setValue(session.getAttribute("preparedBy"));
                } else if (p.getName().equalsIgnoreCase("V_CLAIM_NO") ||
                           p.getName().equalsIgnoreCase("V_CLM_NO")) {
                    p.setValue(session.getAttribute("claimNumber"));
                } else if (p.getName().equalsIgnoreCase("V_USERNAME")) {
                    p.setValue(session.getAttribute("Username"));
                } else if (p.getName().equalsIgnoreCase("V_YEAR")) {
                    if (session.getAttribute("valYear") == null) {
                        p.setValue(session.getAttribute("year"));
                        System.out.println("Year: " +
                                           session.getAttribute("year"));
                    } else {
                        p.setValue(session.getAttribute("valYear"));
                        System.out.println("valYear: " +
                                           session.getAttribute("valYear"));
                    }
                } else if (p.getName().equalsIgnoreCase("V_REG_CODE")) {
                    p.setValue(session.getAttribute("regCode"));
                } else if (p.getName().equalsIgnoreCase("V_BRA_CODE")) {
                    p.setValue(session.getAttribute("braCode"));
                } else if (p.getName().equalsIgnoreCase("V_BRU_CODE")) {
                    p.setValue(session.getAttribute("bruCode"));
                } else if (p.getName().equalsIgnoreCase("V_MATURITY_DATE")) {
                    p.setValue(session.getAttribute("maturityDate"));
                } else if (p.getName().equalsIgnoreCase("V_SIGN_DESIG")) {
                    p.setValue(session.getAttribute("designation"));
                } else if (p.getName().equalsIgnoreCase("V_SIGN_NAME") ||
                           p.getName().equalsIgnoreCase("V_SIGNATORY")) {
                    p.setValue(session.getAttribute("signatoryName"));
                } else if (p.getName().equalsIgnoreCase("V_REFERENCE")) {
                    p.setValue(session.getAttribute("reference"));
                } else if (p.getName().equalsIgnoreCase("V_SIGN_FOR")) {
                    p.setValue(session.getAttribute("signFor"));
                } else if (p.getName().equalsIgnoreCase("V_PRP_CODE")) {
                    p.setValue(session.getAttribute("prpCode"));
                } else if (p.getName().equalsIgnoreCase("V_CHEQUE_NO")) {
                    p.setValue(session.getAttribute("chequeNo"));
                } else if (p.getName().equalsIgnoreCase("V_ENCLOSURE")) {
                    p.setValue(session.getAttribute("enclosure"));
                } else if (p.getName().equalsIgnoreCase("V_TOP_NUMBER")) {
                    p.setValue(session.getAttribute("vtopnumber"));
                } else if (p.getName().equalsIgnoreCase("V_MATURITY_NO")) {
                    p.setValue(session.getAttribute("marturityNo"));
                } else if (p.getName().equalsIgnoreCase("V_RENEW")) {
                    p.setValue(session.getAttribute("renew"));
                } else if (p.getName().equalsIgnoreCase("V_LALT_CODE")) {
                    p.setValue(session.getAttribute("loantype"));
                } else if (p.getName().equalsIgnoreCase("V_PAID_STATUS")) {
                    p.setValue(session.getAttribute("paidStatus"));
                }
                else if(p.getName().equalsIgnoreCase("V_BNK_CODE")){
                  p.setValue(session.getAttribute("bankCode"));
                }
                else if (p.getName().equalsIgnoreCase("V_LOAN_TYPE")) {
                    p.setValue(session.getAttribute("loantype"));
                } else if (p.getName().equalsIgnoreCase("V_STATUS")) {
                    p.setValue(session.getAttribute("policyStatus"));
				} else if (p.getName().equalsIgnoreCase("V_AGCP_CODE")) {
                    p.setValue(session.getAttribute("agnComp"));
                } else if (p.getName().equalsIgnoreCase("UP_RCT_NO")){
                    p.setValue(session.getAttribute("brhRctCode"));
                    System.out.println("brhRctCode At publisher " + session.getAttribute("brhRctCode").toString());
                }
            }
            //conn.setDefaultRowPrefetch(200);
            dataProcessor.setParameters(parameters2);
            dataProcessor.setParameters(parameters2);
            dataProcessor.setConnection(conn);
            dataProcessor.setOutput(output);
            dataProcessor.processData();
            /* dataProcessor.setParameters(parameters2);
            dataProcessor.setParameters(parameters2);
            dataProcessor.setConnection(conn);
            dataProcessor.setOutput(output);
            dataProcessor.processData();*/

        } catch (Exception e) {
            e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
    }
    /////merging==========================

    public FileInputStream generatePDF(String format, String rtftemplate,
                                       String datafilename,
                                       String OutputFile) {
        FOProcessor processor = new FOProcessor();
        RTFProcessor rtfProcessor = null; //input template
        System.out.println("xxx OutputFile=" + OutputFile);
        try {
            rtfProcessor = new RTFProcessor(rtftemplate);
        } catch (IOException e) {
            e.printStackTrace();
        } // output file

        System.out.println("yyy OutputFile=" + OutputFile);
        try {
            rtfProcessor.setOutput("template1.xsl");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("zzz OutputFile=" + OutputFile);
        try {
            rtfProcessor.process();
        } catch (XDOException e) {
            e.printStackTrace();
        }
        System.out.println("aaa OutputFile=" + OutputFile);
        byte[] bytes = null;
        try {
            String filename = null;
            filename = OutputFile;
            String data = datafilename;
            String xsltemplate = "template1.xsl";
            String output = null;
            // FileOutputStream outputStream = new FileOutputStream("catalog3.pdf");
            processor.setData(data);
            processor.setTemplate(xsltemplate);
            processor.setOutput(filename + ".pdf");
            output = filename + ".pdf";
            processor.setOutput(output);
            processor.setOutputFormat(FOProcessor.FORMAT_PDF);
            System.out.println("bbbb OutputFile=" + OutputFile);
            processor.generate();
            System.out.println("cccc OutputFile=" + OutputFile);
            File file = new File(output);
            return new FileInputStream(file);


        } catch (Exception e) {
            System.out.println("XDOException " + e.getMessage());
        }

        return null;
    }

    public FileInputStream generatePDF(String format, String rtftemplate,
                                       String OutputFile) {
        FOProcessor processor = new FOProcessor();
        RTFProcessor rtfProcessor = null; //input template
        try {
            rtfProcessor = new RTFProcessor(rtftemplate);
        } catch (IOException e) {
            e.printStackTrace();
        } // output file
        try {
            rtfProcessor.setOutput("template1.xsl");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            rtfProcessor.process();
        } catch (XDOException e) {
            e.printStackTrace();
        }
        byte[] bytes = null;
        try {
            String filename = null;
            filename = OutputFile;
            String xsltemplate = "template1.xsl";
            String output = null;
            // FileOutputStream outputStream = new FileOutputStream("catalog3.pdf");
            //processor.setData(data);

            System.out.println("Generating PDF for template=" + xsltemplate);
            processor.setTemplate(xsltemplate);
            processor.setOutput(filename + ".pdf");
            output = filename + ".pdf";
            processor.setOutput(output);
            processor.setOutputFormat(FOProcessor.FORMAT_PDF);
            processor.generate();
            File file = new File(output);
            return new FileInputStream(file);


        } catch (Exception e) {
            System.out.println("XDOException " + e.getMessage());
        }

        return null;
    }

    public byte[] pdfDocumentMerger(FileInputStream[] inputStreams,
                                    FileOutputStream outputStream,
                                    String outputFilename) {
        byte[] bytes = null;
        //String output = null;
        try {

            PDFDocMerger pdfMerger =
                new PDFDocMerger(inputStreams, outputStream);
            /*pdfMerger.setPageNumberCoordinates(300, 20);
            pdfMerger.setPageNumberFontInfo("Courier", 10);
            pdfMerger.setPageNumberValue(1, 1);
            */

            pdfMerger.process();

            File file = new File(outputFilename);
            bytes = getBytesFromFile(file);
            pdfMerger = null;
            return bytes;
        } catch (XDOException e) {
            System.out.println("XDOException" + e.getMessage());
        }
        return bytes;
    }


    public void DocsToMerge(FileInputStream[] inputStreams,
                            String mergedfilename) throws InterruptedException {
        byte[] bytes = null;
        try {
            FileOutputStream mergedfile = new FileOutputStream(mergedfilename);
            bytes =
                    pdfDocumentMerger(inputStreams, mergedfile, mergedfilename);

            if (bytes == null) {
                System.out.println("inputStreams is NULL");
            } else {
                try {
                    HttpServletResponse response =
                        (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
                    ServletOutputStream servletOutputStream;
                    response.reset();
                    response.resetBuffer();
                    servletOutputStream = response.getOutputStream();

                    String output = null;

                    output = "merged2.pdf";

                    response.setContentType("application/octet-stream");
                    response.setHeader("Content-disposition",
                                       "attachment; filename=" + output + "");


                    response.setContentLength(bytes.length);
                    servletOutputStream.write(bytes, 0, bytes.length);
                    servletOutputStream.flush();
                    servletOutputStream.close();

                } catch (Exception e) {
                    e.printStackTrace();
                    GlobalCC.EXCEPTIONREPORTING(null, e);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException " + e.getMessage());
        }
    }
    ////=================================

    public static void main(String[] argv) {
        XMLPublisher xmlPublisher = new XMLPublisher();
        //  xmlPublisher.foProcessorEngine();
        //  xmlPublisher.xslFoUtility();
        //  xmlPublisher.pdfDocumentMerger();
        xmlPublisher.dataEngine2();
        // xmlPublisher.foProcessorEngine2();
        // xmlPublisher.foProcessorEngine3();
    }
    
  public File processorEngineandAttachEmail(String format,
                                            String templateFile,
                                            String styleFile,
                                            String reportName) {
      FOProcessor processor = new FOProcessor();
      byte[] bytes = null;

      try {
          templateFile = "/Reports/" + templateFile;
          styleFile = "/Reports/" + styleFile;
          reportName = "/Reports/" + reportName;

          FacesContext context = FacesContext.getCurrentInstance();

          ServletContext sc =
              (ServletContext)context.getExternalContext().getContext();
          templateFile = sc.getRealPath(templateFile);
          styleFile = sc.getRealPath(styleFile);
          RTFProcessor rtfProcessor =
              new RTFProcessor(templateFile); //input template
          rtfProcessor.setOutput(styleFile); // output file
          rtfProcessor.process();


          String filename = null;
          filename = reportName;

          String data = reportName + ".xml";
          String template = styleFile;
          data = sc.getRealPath(data);
          filename = sc.getRealPath(filename);
          String output = null;
          //processor.setData(data);
          // processor.setTemplate(template);
          // processor.setOutput(output);
          if (format == null) {
              processor.setData(data);
              processor.setTemplate(template);
              processor.setOutput(filename + ".pdf");
              output = filename + ".pdf";
              processor.setOutputFormat(FOProcessor.FORMAT_PDF);
          } else {
              processor.setData(data);
              processor.setTemplate(template);
              processor.setOutput(filename + "." + format);
              output = filename + "." + format;
              if (format.equalsIgnoreCase("pdf")) {
                  processor.setOutput(filename + "." + format);
                  processor.setOutputFormat(FOProcessor.FORMAT_PDF);
              } else if (format.equalsIgnoreCase("rtf")) {
                  processor.setOutput(filename + "." + format);
                  processor.setOutputFormat(FOProcessor.FORMAT_RTF);
              } else if (format.equalsIgnoreCase("html")) {
                  processor.setOutput(filename + "." + format);
                  processor.setOutputFormat(FOProcessor.FORMAT_HTML);
              } else if (format.equalsIgnoreCase("xls")) {
                  processor.setOutput(filename + "." + format);
                  processor.setOutputFormat(FOProcessor.FORMAT_EXCEL);
              }
          }
          processor.generate();
          File file = new File(output);
          return file;


      } catch (Exception e) {
          System.out.println("XDOException " + e.getMessage());
          e.printStackTrace();
      }
      return null;

  }
}
