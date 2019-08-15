package LMSG.view.Reports;

import LMSG.view.Base.GlobalCC;

import com.sun.java.util.collections.ArrayList;
import com.sun.java.util.collections.Hashtable;
import com.sun.java.util.collections.Iterator;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.lang.reflect.Array;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;

import javax.faces.context.FacesContext;

import javax.servlet.ServletContext;

import javax.servlet.http.HttpSession;

import oracle.apps.xdo.common.pdf.util.PDFDocMerger;
import oracle.apps.xdo.dataengine.DataProcessor;
import oracle.apps.xdo.dataengine.Parameter;
import oracle.apps.xdo.template.FOProcessor;
import oracle.apps.xdo.template.RTFProcessor;
import oracle.apps.xdo.template.fo.util.FOUtility;

public class XMLPublisher {
    public XMLPublisher() {
        super();
    }

    public byte[] processorEngine(String format, String templateFile,
                                  String styleFile, String reportName) {
        FOProcessor processor = new FOProcessor();
        byte[] bytes = null;

        try {
            templateFile = "/Reports/" + templateFile;
            styleFile = "/Reports/" + styleFile;
            reportName = "/Reports/" + reportName;

            FacesContext context = FacesContext.getCurrentInstance();

            // ServletContext

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
            bytes = getBytesFromFile(file);
        } catch (Exception e) {
            System.out.println("XDOException " + e.getMessage());
            //e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return bytes;
    }


    public byte[] getBytesFromFile(File file) throws IOException {
        InputStream is = new FileInputStream(file);

        // Get the size of the file
        long length = file.length();

        if (length > Integer.MAX_VALUE) {
            // File is too large
        }

        // Create the byte array to hold the data
        byte[] bytes = new byte[(int)length];

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
        return bytes;
    }

    public void dataEngine(String reportName, String dataFile, Connection conn,
                           HttpSession session) {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            ServletContext sc =
                (ServletContext)context.getExternalContext().getContext();
            dataFile = "/Reports/" + dataFile;
            reportName = "/Reports/" + reportName;
            String data = dataFile;
            data = sc.getRealPath(data);
            String output = reportName + ".xml";
            output = sc.getRealPath(output);
            DataProcessor dataProcessor = new DataProcessor();
            dataProcessor.setDataTemplate(data);


            //Get Parameters
            ArrayList parameters2 = dataProcessor.getParameters();
            Iterator it = parameters2.iterator();

            while (it.hasNext()) {
                Parameter p = (Parameter)it.next();
                if (p.getName().equals("UP_DATE_FROM")) {
                    p.setValue(session.getAttribute("startDate"));
                }
                if (p.getName().equals("UP_DATE_TO")) {
                    p.setValue(session.getAttribute("endDate"));
                }
                if (p.getName().equals("UP_ENDR_TYPE")) {
                    p.setValue(session.getAttribute("endrType"));
                }
                if (p.getName().equals("UP_POL_CODE")) {
                    p.setValue(session.getAttribute("policyCode"));
                }
                if (p.getName().equals("V_POL_CODE")) {
                    p.setValue(session.getAttribute("policyCode"));
                }
                if (p.getName().equals("V_PRP_CODE")) {
                    p.setValue(session.getAttribute("clientPRPCode"));
                }
                if (p.getName().equals("START_DATE")) {
                    p.setValue(session.getAttribute("startDate"));
                }
                if (p.getName().equals("END_DATE")) {
                    p.setValue(session.getAttribute("endDate"));
                }
                if (p.getName().equals("PUP_VAL_YEAR")) {
                    p.setValue(session.getAttribute("UWYear"));
                }
                if (p.getName().equals("V_POLM_CODE")) {
                    p.setValue(session.getAttribute("MemberSel"));
                }
                if (p.getName().equals("V_ENDR_CODE")) {
                    p.setValue(session.getAttribute("endorsementCode"));
                }
                if (p.getName().equals("V_ENDR_TYPE")) {
                    p.setValue(session.getAttribute("endrType"));
                }
                if (p.getName().equals("up_quo_code")) {
                    p.setValue(session.getAttribute("QuoteCode"));
                }
                if (p.getName().equals("UP_QUO_CODE")) {
                    p.setValue(session.getAttribute("QuoteCode"));
                }
                if (p.getName().equals("V_AGEN_CODE")) {
                    p.setValue(session.getAttribute("agnCode"));
                }
                /*if (p.getName().equals("V_YEAR")) {
                    p.setValue(session.getAttribute("UWYear"));
                }*/
                else if (p.getName().equalsIgnoreCase("V_YEAR")) {
                    if (session.getAttribute("UWYear") != null) {
                        p.setValue(session.getAttribute("UWYear"));
                        System.out.println("Year: " +
                                           session.getAttribute("UWYear"));
                    } else if (session.getAttribute("year") != null) {
                        p.setValue(session.getAttribute("year"));
                        System.out.println("Year: " +
                                           session.getAttribute("year"));
                    } else {
                        p.setValue(session.getAttribute("year"));
                        System.out.println("Year: " +
                                           session.getAttribute("year"));
                    }
                }
                if (p.getName().equals("V_USER")) {
                    p.setValue(session.getAttribute("Username"));
                }
                if (p.getName().equals("V_APPLY_RATES")) {
                    p.setValue(session.getAttribute("showRates"));
                }
                if (p.getName().equals("V_BRN_CODE")) {
                    p.setValue(session.getAttribute("branchCode"));
                }
                if (p.getName().equals("V_CLM_NO")) {
                    p.setValue(session.getAttribute("ClaimNo"));
                }
                if (p.getName().equals("V_VCHR_NO")) {
                    p.setValue(session.getAttribute("voucherNumber"));
                }
                if (p.getName().equals("V_DATE_FROM")) {
                    if (session.getAttribute("RenDateFrom") != null)
                        p.setValue(session.getAttribute("RenDateFrom"));
                    else
                        p.setValue(session.getAttribute("dateFrom"));
                }
                if (p.getName().equals("V_DATE_TO")) {
                    System.out.println("am here fetching params");
                    if (session.getAttribute("RenDateTo") != null)
                        p.setValue(session.getAttribute("RenDateTo"));
                    else
                        p.setValue(session.getAttribute("dateTo"));
                }
                if (p.getName().equals("V_PCA_CODE")) {
                    p.setValue(session.getAttribute("rptLCACode"));
                }
                if (p.getName().equals("V_PCA_CODE")) {
                    p.setValue(session.getAttribute("rptLCACode"));
                }
                if (p.getName().equals("V_AGNT_TYPE")) {
                    p.setValue(session.getAttribute("agnTypes"));
                }
                if (p.getName().equals("V_CLA_CODE")) {
                    p.setValue(session.getAttribute("classCode"));
                }
                if (p.getName().equals("V_RATE_CODE")) {
                    p.setValue(session.getAttribute("rateCode"));
                }
                if (p.getName().equals("V_PROD_CODE")) {
                    p.setValue(session.getAttribute("prodCode"));
                }
                if (p.getName().equals("V_CLAIM_STATUS") ||
                    p.getName().equals("CLAIM_STATUS")) {
                    p.setValue(session.getAttribute("clmStatus"));
                }
                if (p.getName().equals("V_FAC_CODE")) {
                    p.setValue(session.getAttribute("FacCode"));
                    //System.out.println("PASSED FAC CODE: "+session.getAttribute("FacCode"));
                }
                if (p.getName().equals("V_CURRENCY_CODE")) {

                    p.setValue(session.getAttribute("curCode"));
                    System.out.println("CURRENCY: " + p.getValue());
                }
                if (p.getName().equals("V_BTS_CODE")) {
                    p.setValue(session.getAttribute("btsCode"));
                } else if (p.getName().equalsIgnoreCase("V_SBU_CODE")) {
                    p.setValue(session.getAttribute("sbuCode"));
                } else if (p.getName().equalsIgnoreCase("V_REPORT_TPE")) {
                    p.setValue(session.getAttribute("reportVal"));
                } else if (p.getName().equalsIgnoreCase("V_MONTH")) {
                    p.setValue(session.getAttribute("month"));
                }
                if (p.getName().equals("V_REI_CODE")) {
                    p.setValue(session.getAttribute("reiCode"));
                }
                if (p.getName().equals("V_VOUCHER_NO")) {
                    p.setValue(session.getAttribute("voucherNo"));
                }
                if (p.getName().equals("V_FMPT_CODE")) {
                    p.setValue(session.getAttribute("fmptCode"));
                }
                if (p.getName().equals("V_GRCT_CODE")) {
                    p.setValue(session.getAttribute("GrctCode"));
                    System.out.println("The receipt code " +
                                       session.getAttribute("GrctCode"));
                }

            }

            dataProcessor.setParameters(parameters2);
            dataProcessor.setParameters(parameters2);
            dataProcessor.setConnection(conn);
            dataProcessor.setOutput(output);
            dataProcessor.processData();

        } catch (Exception e) {
            System.out.println("Exception " + e.getMessage());
            e.printStackTrace();
        }
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
