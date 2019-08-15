package LMSG.view.Correspondents;

import java.io.InputStream;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputFile;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;

import oracle.adf.view.rich.component.rich.output.RichOutputLabel;

import oracle.adf.view.rich.component.rich.output.RichOutputText;

import oracle.jdbc.OracleTypes;

import org.apache.myfaces.trinidad.model.UploadedFile;

import LMSG.view.Base.ADFUtils;

import LMSG.view.Base.CurrentUser;
import LMSG.view.Base.GlobalCC;
import LMSG.view.Base.LOVCC;
import LMSG.view.Base.Settings;
import LMSG.view.Policy.PolicyValues;
import LMSG.view.Reports.XMLPublisher;
import LMSG.view.connect.DBConnector;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Date;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.*;

import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import oracle.apps.xdo.delivery.DeliveryManager;
import oracle.apps.xdo.delivery.DeliveryPropertyDefinitions;
import oracle.apps.xdo.delivery.DeliveryRequest;
import oracle.apps.xdo.delivery.InvalidFactoryException;
import oracle.apps.xdo.delivery.UndefinedRequestTypeException;
import oracle.apps.xdo.delivery.smtp.Attachment;
import oracle.apps.xdo.delivery.DeliveryException;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleResultSet;

public class CorrespondenceManipulation extends LOVCC {
    private RichPanelBox smsDetails;
    private RichPanelBox smsTemplateMessage;
    private RichInputText phoneNumber;
    private RichInputText message;
    private RichPanelBox emailDetails;
    private RichInputText toEmail;
    private RichInputText ccEmail;
    private RichPanelBox emailTemplateMessage;
    private RichInputText subjectEmail;
    private RichInputFile file;
    private RichInputFile fileUpload;
    private RichTable msgTemplate;
    private RichInputText msgTemplateDesc;    
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    private RichOutputLabel titleLabel;
    private RichOutputText alertMessage;

    public String saveSMSMessage() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        if (session.getAttribute("msgTempDesc") == null) {
            message.setValue(null);
        } else {
            message.setValue(session.getAttribute("msgTempDesc"));
        }

        CallableStatement cst = null;
        String populateMaturities =
            "begin TQC_SMS_PKG.SEND_SMS_MSG(?,?,?,?,?,?,?,?,?,?,?,?,?); end;";
        try {
            cst = conn.prepareCall(populateMaturities);

            cst.setBigDecimal(1, (BigDecimal)session.getAttribute("prpCode"));
            cst.setBigDecimal(2, new BigDecimal("0")); //Agent Code
            cst.setBigDecimal(3,
                              (BigDecimal)session.getAttribute("QuoteCode"));
            cst.setString(4, (String)session.getAttribute("QuotationNo"));
            cst.setBigDecimal(5,
                              (BigDecimal)session.getAttribute("policyCode"));
            cst.setString(6, (String)session.getAttribute("policyNumber"));
            cst.setString(7, (String)session.getAttribute("ClaimNo"));
            cst.setString(8, null);
            cst.setString(9, (String)session.getAttribute("msgTempDesc"));
            cst.setInt(10, GlobalCC.sysCode);
            cst.setString(11, (String)session.getAttribute("sysModule"));
            cst.setString(12, (String)session.getAttribute("Username"));
            cst.registerOutParameter(13, OracleTypes.NUMBER);
            cst.execute();
            session.setAttribute("smsCode", cst.getBigDecimal(13));
            cst.close();
            conn.close();
            smsDetails.setRendered(true);
            smsTemplateMessage.setRendered(false);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return null;
    }

    public String sendEmailMessage(String to, String subject, String message) {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        
        String updateEmail = "begin ? := TQC_EMAIL_PKG.send_email(?,?,?,?,?); end;";
        try {
            cst = conn.prepareCall(updateEmail);
            cst.registerOutParameter(1, OracleTypes.NUMBER);
            cst.setString(2, GlobalCC.emailFrom);
            cst.setString(3, to);
            cst.setString(4,null);
            cst.setString(5, subject);
            cst.setString(6, message);
            cst.execute();
            conn.close();
            GlobalCC.sysInformation("Message Sent SuccessFully");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
            e.printStackTrace();
        }


        return null;
    }

    public String updateEmailMessage() {

        String toEmailAddress = GlobalCC.checkNullValues(toEmail.getValue());
        //String ccEmailAddress = GlobalCC.checkNullValues(ccEmail.getValue());
        String emailSubject =
            GlobalCC.checkNullValues(subjectEmail.getValue());
        String msg = GlobalCC.checkNullValues(message.getValue());
        if (toEmailAddress == null) {
            GlobalCC.errorValueNotEntered("Enter the Email Address");
            return null;
        }

        if (emailSubject == null) {
            GlobalCC.errorValueNotEntered("Enter the Email Subject");
            return null;
        }

        if (msg == null) {
            GlobalCC.errorValueNotEntered("ENTER THE EMAIL MESSAGE");
            return null;
        }

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        String updateEmail =
            "UPDATE TQC_EMAIL_MESSAGES SET EMAIL_ADDRESS = ?, EMAIL_SUBJ = ? , EMAIL_MSG = ? , EMAIL_PREPARED_BY = ? ,EMAIL_PREPARED_DATE = ? , EMAIL_SEND_DATE = ? WHERE EMAIL_CODE = ?";
        try {
            cst = conn.prepareCall(updateEmail);
            cst.setString(1, toEmailAddress);
            cst.setString(2, emailSubject);
            cst.setString(3, msg);
            cst.setString(4, (String)session.getAttribute("Username"));
            cst.setString(5, GlobalCC.parseDate(Settings.toDay.toString()));
            cst.setString(6, GlobalCC.parseDate(Settings.toDay.toString()));
            cst.setBigDecimal(7, LOVCC.emailCode);
            cst.execute();
            conn.close();
            sendEmailMessage(toEmailAddress, emailSubject, msg);

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return null;

    }

    public String updateSMSMessage() {

        String telNo = GlobalCC.checkNullValues(phoneNumber.getValue());
        String msg = GlobalCC.checkNullValues(message.getValue());
        if (telNo == null) {
            GlobalCC.errorValueNotEntered("ENTER THE PHONE NUMBER");
            return null;
        }

        if (msg == null) {
            GlobalCC.errorValueNotEntered("ENTER THE SMS MESSAGE");
            return null;
        }


        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        String updateSMS =
            "UPDATE TQC_SMS_MESSAGES SET SMS_TEL_NO = ?, SMS_MSG = ?, SMS_PREPARED_BY = ?,SMS_PREPARED_DATE = ? , SMS_SEND_DATE = ?, SMS_USR_CODE = ?, " +
            "SMS_CLNT_CODE=(SELECT PRP_CLNT_CODE FROM LMS_PROPOSERS WHERE PRP_CODE=" +(BigDecimal)session.getAttribute("prpCode")+") "+
            "WHERE SMS_CODE = ?";
        try {
            cst = conn.prepareCall(updateSMS);
            cst.setString(1, telNo);
            cst.setString(2, msg);
            cst.setString(3, (String)session.getAttribute("Username"));
            cst.setString(4, GlobalCC.parseDate(Settings.toDay.toString()));
            cst.setString(5, GlobalCC.parseDate(Settings.toDay.toString()));
            cst.setBigDecimal(6, (BigDecimal)session.getAttribute("UserCode"));
            cst.setBigDecimal(7, (BigDecimal)session.getAttribute("smsCode"));
            cst.execute();
            cst.close();
            conn.close();
            GlobalCC.sysInformation("Message Queued for Sending");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return null;
    }


    public String saveEmailMessage() {


        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        CallableStatement cint = null;
        String seqQuery = "SELECT TQC_SMS_CODE_SEQ.NEXTVAL FROM DUAL";

        String insertQuery =
            "INSERT INTO TQC_EMAIL_MESSAGES(EMAIL_CODE, EMAIL_SYS_CODE, EMAIL_SYS_MODULE, EMAIL_CLNT_CODE,EMAIL_AGN_CODE, EMAIL_POL_CODE, EMAIL_POL_NO,EMAIL_CLM_NO, EMAIL_QUOT_CODE,EMAIL_ADDRESS, EMAIL_SUBJ,EMAIL_MSG, EMAIL_STATUS,EMAIL_PREPARED_BY, EMAIL_PREPARED_DATE) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            cint = conn.prepareCall(seqQuery);
            ResultSet rs = cint.executeQuery();

            while (rs.next()) {
                LOVCC.emailCode = rs.getBigDecimal(1);
            }


            cst = conn.prepareCall(insertQuery);

            cst.setBigDecimal(1, LOVCC.emailCode);
            System.out.println(LOVCC.emailCode);
            cst.setInt(2, GlobalCC.sysCode);
            cst.setString(3, (String)session.getAttribute("sysModule"));
            cst.setBigDecimal(4, (BigDecimal)session.getAttribute("prpCode"));
            if (session.getAttribute("AgentCode") == null) {
                cst.setString(5, "0"); //Agent Code
            } else {
                cst.setBigDecimal(5,
                                  (BigDecimal)session.getAttribute("AgentCode")); //Agent Code
            }
            cst.setBigDecimal(6,
                              (BigDecimal)session.getAttribute("policyCode"));
            cst.setString(7, (String)session.getAttribute("policyNumber"));
            cst.setString(8, (String)session.getAttribute("ClaimNo"));
            cst.setBigDecimal(9,
                              (BigDecimal)session.getAttribute("QuoteCode"));
            cst.setString(10, null);
            cst.setString(11, null);
            cst.setString(12, null);
            cst.setString(13, "R");
            cst.setString(14, (String)session.getAttribute("Username"));
            cst.setString(15, GlobalCC.parseDate(Settings.toDay.toString()));
            System.out.println(Settings.toDay.toString());
            cst.execute();

            conn.close();
            ADFUtils.findIterator("findMessageValuesIterator").executeQuery();
            emailDetails.setRendered(true);
            emailTemplateMessage.setRendered(false);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return null;
    }

    public void fileUploadedValue(ValueChangeEvent valueChangeEvent) {

        if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue()) {
            UploadedFile _file = (UploadedFile)valueChangeEvent.getNewValue();
            DBConnector datahandler = new DBConnector();
            Connection conn;
            conn = datahandler.getDatabaseConn();
            String fileupload =
                "INSERT INTO TQC_EMAIL_ATTACHMENTS(EATT_CODE, EATT_EMAIL_CODE, EATT_FILE, EATT_FILENAME) VALUES (TQC_EATT_CODE_SEQ.NEXTVAL,?,?,?)";

            PreparedStatement ps;
            try {
                ps = conn.prepareStatement(fileupload);
                int length = 0;
                Object _fileData = null;
                String _filename = null;
                length = (int)_file.getLength();
                _fileData = _file.getInputStream();
                _filename = _file.getFilename();
                ps.setBigDecimal(1, LOVCC.emailCode);
                ps.setBinaryStream(2, (InputStream)_fileData, length);
                ps.setString(3, _filename);
                ps.execute();
                conn.close();
            } catch (Exception e) {
                GlobalCC.EXCEPTIONREPORTING(conn, e);
            }


        }

        // Add event code here...
    }

    public void setSmsDetails(RichPanelBox smsDetails) {
        this.smsDetails = smsDetails;
    }

    public RichPanelBox getSmsDetails() {
        return smsDetails;
    }

    public void setSmsTemplateMessage(RichPanelBox smsTemplateMessage) {
        this.smsTemplateMessage = smsTemplateMessage;
    }

    public RichPanelBox getSmsTemplateMessage() {
        return smsTemplateMessage;
    }

    public void setPhoneNumber(RichInputText phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public RichInputText getPhoneNumber() {
        return phoneNumber;
    }

    public void setMessage(RichInputText message) {
        this.message = message;
    }

    public RichInputText getMessage() {
        return message;
    }

    public void setEmailDetails(RichPanelBox emailDetails) {
        this.emailDetails = emailDetails;
    }

    public RichPanelBox getEmailDetails() {
        return emailDetails;
    }

    public void setToEmail(RichInputText toEmail) {
        this.toEmail = toEmail;
    }

    public RichInputText getToEmail() {
        return toEmail;
    }

    public void setCcEmail(RichInputText ccEmail) {
        this.ccEmail = ccEmail;
    }

    public RichInputText getCcEmail() {
        return ccEmail;
    }

    public void setEmailTemplateMessage(RichPanelBox emailTemplateMessage) {
        this.emailTemplateMessage = emailTemplateMessage;
    }

    public RichPanelBox getEmailTemplateMessage() {
        return emailTemplateMessage;
    }

    public void setSubjectEmail(RichInputText subjectEmail) {
        this.subjectEmail = subjectEmail;
    }

    public RichInputText getSubjectEmail() {
        return subjectEmail;
    }

    public void setFile(RichInputFile file) {
        this.file = file;
    }

    public RichInputFile getFile() {
        return file;
    }

    public void setFileUpload(RichInputFile fileUpload) {
        this.fileUpload = fileUpload;
    }

    public RichInputFile getFileUpload() {
        return fileUpload;
    }

    public void setMsgTemplate(RichTable msgTemplate) {
        this.msgTemplate = msgTemplate;
    }

    public RichTable getMsgTemplate() {
        return msgTemplate;
    }

    public void setMsgTemplateDesc(RichInputText msgTemplateDesc) {
        this.msgTemplateDesc = msgTemplateDesc;
    }

    public RichInputText getMsgTemplateDesc() {
        return msgTemplateDesc;
    }

    public static boolean isValidEmailAddress(String emailAddress) {
        // a null string is invalid
        if (emailAddress == null)
            return false;

        // a string without a "@" is an invalid email address
        if (emailAddress.indexOf("@") < 0)
            return false;

        // a string without a "."  is an invalid email address
        if (emailAddress.indexOf(".") < 0)
            return false;

        if (lastEmailFieldTwoCharsOrMore(emailAddress) == false)
            return false;

        try {
            InternetAddress internetAddress =
                new InternetAddress(emailAddress);
            return true;
        } catch (AddressException ae) {
            // log exception
            return false;
        }
    }


    /**
     * Returns true if the last email field (i.e., the country code, or something
     * like .com, .biz, .cc, etc.) is two chars or more in length, which it really
     * must be to be legal.
     */
    private static boolean lastEmailFieldTwoCharsOrMore(String emailAddress) {
        if (emailAddress == null)
            return false;
        StringTokenizer st = new StringTokenizer(emailAddress, ".");
        String lastToken = null;
        while (st.hasMoreTokens()) {
            lastToken = st.nextToken();
        }

        if (lastToken.length() >= 2) {
            return true;
        } else {
            return false;
        }
    }

    public String processEmailDebits(BigDecimal RptCode,String email,String reportName,String content,String subject) {
        Connection conn = null;
        String  host=null;
        String mailPort=null;
        String sender=null;
        conn = new DBConnector().getDatabaseConn();
        
        CallableStatement csts = null;
        File fileToSend = null;    
      conn = new DBConnector().getDatabaseConn();
      String emailVal = null;
      String passVal = null;
      String emailQuery =
          "SELECT MAIL_HOST,MAIL_PORT,MAIL_EMAIL FROM TQC_SYSTEM_MAILS WHERE MAIL_IN_OUT = 'O' AND MAIL_TYPE='NORMAL'";

      OracleCallableStatement cst = null;
      
      try {
          cst = (OracleCallableStatement)conn.prepareCall(emailQuery);
          OracleResultSet rs = (OracleResultSet)cst.executeQuery();

          while (rs.next()) {
              host = rs.getString(1);
              mailPort= rs.getString(2);
              sender = rs.getString(3);
          }
          cst.close();
          rs.close();
          conn.close();
      } catch (Exception e) {
          e.printStackTrace();
          GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
        String[] sendtos = email.split(",");
        for (String sendto : sendtos) {
            boolean validEmail = isValidEmailAddress(sendto);
            if (!validEmail) {
                GlobalCC.INFORMATIONREPORTING("Email Address " + sendto +
                                              " is Invalid..Please Enter Valid Email Address");
                return null;
            }
        }
        Attachment m = null;
        try {
            m = new Attachment();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        try {
            if(RptCode!=null){
            fileToSend =
                    new CorrespondenceManipulation().generateAttachments(RptCode);
            m.addAttachment(fileToSend.getAbsolutePath(), // file to deliver
                    reportName + ".pdf", // file name appears in the email
                    "application/pdf");
            }

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        DeliveryManager dm = null;
        // create a delivery request
        try {
            dm = new DeliveryManager();
        } catch (InvalidFactoryException e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        DeliveryRequest req = null;
        try {
            req = dm.createRequest(DeliveryManager.TYPE_SMTP_EMAIL);
        } catch (UndefinedRequestTypeException e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        req.addProperty(DeliveryPropertyDefinitions.SMTP_SUBJECT,
                        subject);
        // set SMTP server host

        req.addProperty(DeliveryPropertyDefinitions.SMTP_HOST,host);

        req.addProperty(DeliveryPropertyDefinitions.SMTP_PORT,mailPort);

        // set the sender email address
        req.addProperty(DeliveryPropertyDefinitions.SMTP_FROM,sender);

        // set the destination email address
        req.addProperty(DeliveryPropertyDefinitions.SMTP_TO_RECIPIENTS, email);
        // set the content type of the email body
        //req.addProperty(DeliveryPropertyDefinitions.SMTP_CONTENT_TYPE, "application/pdf");
        // set the document file name appeared in the email
        //req.addProperty(DeliveryPropertyDefinitions.SMTP_CONTENT_FILENAME, fileToSend.getName());
        // set the document to deliver


        // submit the request

        try {
            req.setDocument(content, "UTF-8");
        } catch (DeliveryException e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        req.addProperty(DeliveryPropertyDefinitions.SMTP_ATTACHMENT, m);

        // close the request
        try {
            req.submit();
            // fileToSend.delete();

        } catch (DeliveryException e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        req.close();


        try {
            conn.close();
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        return null;
    }
    
    public String ticketAlert(String ticketFrom,String ticketTo,String TicketName,String comments){
      Connection conn = null;
      String  host=null;
      String mailPort=null;
      String sender=null;
      String email=null;
      conn = new DBConnector().getDatabaseConn();
      String subject="Ticket Assignment ";
      String content="Dear "+ticketTo+",\nKindly act on Group Life "+TicketName+" ticket. \n"+
                     "The ticket Reference code is "+session.getAttribute("TaskID")+"\n\n"+
                     "Regards "+ticketFrom+" .";
      
      CallableStatement csts = null;
      File fileToSend = null;          
      String emailVal = null;
      String passVal = null;
      String emailQuery =
        "SELECT MAIL_HOST,MAIL_PORT,MAIL_EMAIL FROM TQC_SYSTEM_MAILS WHERE MAIL_IN_OUT = 'O' AND MAIL_TYPE='NORMAL'";

      OracleCallableStatement cst = null;
      
      try {
        conn = new DBConnector().getDatabaseConn();
        cst = (OracleCallableStatement)conn.prepareCall(emailQuery);
        OracleResultSet rs = (OracleResultSet)cst.executeQuery();

        while (rs.next()) {
            host = rs.getString(1);
            mailPort= rs.getString(2);
            sender = rs.getString(3);
        }
        cst.close();
        rs.close();
        conn.close();
      } catch (Exception e) {
        e.printStackTrace();
        GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
      
      String userEmail =
        "SELECT USR_EMAIL \n" + 
        "FROM tqc_users\n" + 
        "WHERE USR_USERNAME='"+ticketTo+"'";
      

      OracleCallableStatement cst1 = null;
      
      try {
        conn = new DBConnector().getDatabaseConn();
        cst1 = (OracleCallableStatement)conn.prepareCall(userEmail);
        OracleResultSet rst = (OracleResultSet)cst1.executeQuery();

        while (rst.next()) {
            email = rst.getString(1);
        }
        cst1.close();
        rst.close();
        conn.close();
      } catch (Exception e) {
        e.printStackTrace();
        GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
     // System.out.println("query="+email);
      
      String[] sendtos = email.split(",");
      for (String sendto : sendtos) {
          boolean validEmail = isValidEmailAddress(sendto);
          if (!validEmail) {
              GlobalCC.INFORMATIONREPORTING("Email Address " + sendto +
                                            " is Invalid..Please Enter Valid Email Address");
              return null;
          }
      }
      Attachment m = null;
      try {
          m = new Attachment();
      } catch (Exception e) {
          GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
      DeliveryManager dm = null;
      // create a delivery request
      try {
          dm = new DeliveryManager();
      } catch (InvalidFactoryException e) {
          GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
      DeliveryRequest req = null;
      try {
          req = dm.createRequest(DeliveryManager.TYPE_SMTP_EMAIL);
      } catch (UndefinedRequestTypeException e) {
          GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
      req.addProperty(DeliveryPropertyDefinitions.SMTP_SUBJECT,
                      subject);
      // set SMTP server host

      req.addProperty(DeliveryPropertyDefinitions.SMTP_HOST,host);

      req.addProperty(DeliveryPropertyDefinitions.SMTP_PORT,mailPort);

      // set the sender email address
      req.addProperty(DeliveryPropertyDefinitions.SMTP_FROM,sender);

      // set the destination email address
      req.addProperty(DeliveryPropertyDefinitions.SMTP_TO_RECIPIENTS, email);
      // set the content type of the email body
      //req.addProperty(DeliveryPropertyDefinitions.SMTP_CONTENT_TYPE, "application/pdf");
      // set the document file name appeared in the email
      //req.addProperty(DeliveryPropertyDefinitions.SMTP_CONTENT_FILENAME, fileToSend.getName());
      // set the document to deliver


      // submit the request

      try {
          req.setDocument(content, "UTF-8");
      } catch (DeliveryException e) {
          GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
      req.addProperty(DeliveryPropertyDefinitions.SMTP_ATTACHMENT, m);

      // close the request
      try {
          req.submit();
          // fileToSend.delete();

      } catch (DeliveryException e) {
          GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
      req.close();


      try {
          conn.close();
      } catch (Exception ex) {
          GlobalCC.EXCEPTIONREPORTING(conn, ex);
      } 
        
      return null;
    }

    public String sendMailDoc(String sender, String receiver, String cc,
                              String subject, String content, String filename,
                              String contentFilename,BigDecimal rptcode,
                              String contentType) {

        String success = null;        
        GlobalCC GlobalCC = new GlobalCC();
        File file=this.generateAttachments(rptcode);

        Properties props = new Properties();
        Authenticator auth = new MailAuthenticator();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "25");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.trust", "*");
        Session mailSession = Session.getInstance(props, auth);
        //Session mailSession = Session.getDefaultInstance(props, null);

        //mailSession.setDebug(true);
        Transport transport = null;
        try {


            Message message = new MimeMessage(mailSession);
            message.setFrom(new InternetAddress(sender));
            message.setRecipients(Message.RecipientType.TO,
                                  InternetAddress.parse(receiver));
            if (cc != null) {
                message.setRecipients(Message.RecipientType.CC,
                                      InternetAddress.parse(cc));
            }

            if (contentFilename == null) {
                contentFilename = "DEBIT_NOTE.pdf";
            }


            Multipart mp = new MimeMultipart();

            MimeBodyPart htmlPart = new MimeBodyPart();
            htmlPart.setContent(content, "text/html");
            mp.addBodyPart(htmlPart);

            MimeBodyPart attachment = new MimeBodyPart();
            attachment.setFileName(contentFilename);
            if (contentType == null) {
                contentType = "application/pdf";
            }
            attachment.setContent(this.getBytesFromFile(file), contentType);
            mp.addBodyPart(attachment);

            message.setContent(mp);
            /*

          Multipart mp = new MimeMultipart();
              MimeBodyPart mbp = new MimeBodyPart();
              mbp.setFileName(contentFilename);
              mbp.setContent(filename, "application/pdf");
              mp.addBodyPart(mbp);
              mbp.setText(content);
              message.setContent(mp);*/
            //message.setFileName(contentFilename);
            message.setSubject(subject);
            // message.setText(content);

            Transport.send(message);
            success = "success";
        } catch (Exception e) {

            GlobalCC.EXCEPTIONREPORTING(null, e);
            e.printStackTrace();
        }


        return success;
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        GlobalCC GlobalCC = new GlobalCC();
        Connection conn;
        conn = new DBConnector().getDatabaseConn();
        String emailVal = null;
        String passVal = null;
        String emailQuery =
            "SELECT  MAIL_USERNAME, MAIL_PASSWORD, MAIL_SECURE FROM TQC_SYSTEM_MAILS WHERE MAIL_IN_OUT = 'O' AND MAIL_TYPE='GOOGLE'";

        OracleCallableStatement cst = null;
        try {
            cst = (OracleCallableStatement)conn.prepareCall(emailQuery);
            OracleResultSet rs = (OracleResultSet)cst.executeQuery();

            while (rs.next()) {
                emailVal = rs.getString(1);
                passVal = rs.getString(2);
            }
            cst.close();
            rs.close();
            System.out.println();
            System.out.println(emailVal);
            System.out.println(passVal);
            if (emailVal == null) {
                GlobalCC.errorValueNotEntered("EMAILS_FROM Not Defined Please Check");
                return null;
            }
            if (passVal == null) {
                GlobalCC.errorValueNotEntered("EMAILS_FROM_PASSWORD Not Defined Please Check");
                return null;
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return new PasswordAuthentication(emailVal, passVal);
    }
    public String getMailType(){
     String mailType=null;
      Connection conn;
      conn = new DBConnector().getDatabaseConn();
      String emailQuery =
          "SELECT  MAIL_TYPE FROM TQC_SYSTEM_MAILS WHERE MAIL_IN_OUT = 'O' ";

      OracleCallableStatement cst = null;
      try {
          cst = (OracleCallableStatement)conn.prepareCall(emailQuery);
          OracleResultSet rs = (OracleResultSet)cst.executeQuery();

          while (rs.next()) {
              mailType = rs.getString(1);
          }
          cst.close();
          rs.close();
          if (mailType == null) {
              GlobalCC.INFORMATIONREPORTING("Outgoing email not set in CRM");
              return null;
          }

          conn.close();
      } catch (Exception e) {
          e.printStackTrace();
          GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
     
      return mailType;
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

    public File generateAttachments(BigDecimal rptCode) {
        XMLPublisher xmlPublisher = new XMLPublisher();

        String templateFile = null;
        String styleFile = null;
        String reportName = null;
        String dataFile = null;
        File file = null;
        String reportFormat = null;

        if (reportFormat == null) {
            reportFormat = "pdf";
        }
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();
        CallableStatement cst = null;
        String jobquery = "begin ? := tqc_web_cursor.getRptDetails(?); end;";

        try {
            cst = conn.prepareCall(jobquery);
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2, rptCode);
            cst.executeQuery();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                templateFile = rs.getString(5);
                styleFile = rs.getString(7);
                reportName = rs.getString(2);
                dataFile = rs.getString(3);
            }

            System.out.println("report code" + rptCode);
            System.out.println(templateFile);
            System.out.println(styleFile);
            System.out.println(reportName);
            System.out.println(dataFile);
            xmlPublisher.dataEngine(reportName, dataFile, conn, session);
            file =
                  xmlPublisher.processorEngineandAttachEmail(reportFormat, templateFile,
                                                             styleFile, reportName);
            return file;
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;

    }
  public void emailReport(String emailAt) {
    Connection conn = null;
    OracleCallableStatement cst = null;
    OracleCallableStatement cs = null;
    conn = new DBConnector().getDatabaseConn();
    OracleResultSet rs = null;
    OracleResultSet rst = null;
    String reportName="";
    String content="";
    String emailAddress="";
    BigDecimal rptCode=null;
    String mailType =this.getMailType();
    session.setAttribute("emailPoint", emailAt);
    if(GlobalCC.getSytemParam("GRP_AUTO_EMAIL").equalsIgnoreCase("Y")) {
      try {
          String emailDetails =
              "SELECT EMD_RPT_NAME,EMD_MSGT_NARR,EMD_RPT_CODE,USR_EMAIL," +
              "LMS_GRP_MISC.PROCESS_MSG("+(BigDecimal)session.getAttribute("endorsementCode") +",NULL,EMD_MSGT_NARR,'P',NULL,NULL, NULL) " +
              " FROM LMS_EMAIL_DETAILS,TQC_USERS " +
              "  WHERE ((EMD_USR_CODE=USR_CODE AND EMD_USR_CODE IS NOT NULL) \n" + 
              " OR (USR_USERNAME ='"+(String)session.getAttribute("Username")+"' AND EMD_USR_CODE IS NULL)) " +
              " AND EMD_RECEPIENT='U' " +
              "AND EMD_APPLY_AT= '"+emailAt+"'"+
              " UNION ALL " +
              "SELECT EMD_RPT_NAME,EMD_MSGT_NARR,EMD_RPT_CODE, " + 
              "(SELECT PRP_EMAIL FROM LMS_PROPOSERS WHERE PRP_CODE="+(BigDecimal)session.getAttribute("prpCode") +")USR_EMAIL," +
              "LMS_GRP_MISC.PROCESS_MSG("+(BigDecimal)session.getAttribute("endorsementCode") +",NULL,EMD_MSGT_NARR,'P',NULL,NULL, NULL) " +
              "FROM LMS_EMAIL_DETAILS  " + 
              "WHERE EMD_RECEPIENT='C' " + 
              "AND EMD_APPLY_AT= '"+emailAt+"' "+
              " UNION ALL "+
              "SELECT EMD_RPT_NAME,EMD_MSGT_NARR,EMD_RPT_CODE, " + 
              "(SELECT AGN_EMAIL_ADDRESS FROM LMS_AGENCIES,LMS_POLICY_ENDORSEMENTS " +
                " WHERE AGN_CODE=ENDR_AGEN_CODE AND ENDR_CODE="+(BigDecimal)session.getAttribute("endorsementCode") +")USR_EMAIL," +
              "LMS_GRP_MISC.PROCESS_MSG("+(BigDecimal)session.getAttribute("endorsementCode") +",NULL,EMD_MSGT_NARR,'P',NULL,NULL, NULL) " +
              "FROM LMS_EMAIL_DETAILS  " + 
              "WHERE EMD_RECEPIENT='A' " + 
              "AND EMD_APPLY_AT= '"+emailAt+"' "+
              " UNION ALL "+
              "SELECT EMD_RPT_NAME,EMD_MSGT_NARR,EMD_RPT_CODE, EMD_CUSTOM_EMAIL, "+
              "LMS_GRP_MISC.PROCESS_MSG("+(BigDecimal)session.getAttribute("endorsementCode") +",NULL,EMD_MSGT_NARR,'P',NULL,NULL, NULL) " +
              "FROM LMS_EMAIL_DETAILS  " + 
              "WHERE EMD_RECEPIENT='CE' " + 
              "AND EMD_APPLY_AT= '"+emailAt+"' "+
              " UNION ALL "+
              "SELECT EMD_RPT_NAME,EMD_MSGT_NARR,EMD_RPT_CODE, " + 
              "(SELECT  DISTINCT SPR_EMAIL FROM LMS_POLICY_ENDORSEMENTS,TQC_SERVICE_PROVIDERS " +
                " WHERE ENDR_TQ_SPR_CODE=SPR_CODE AND ENDR_CODE="+(BigDecimal)session.getAttribute("endorsementCode") +")USR_EMAIL," +
                "LMS_GRP_MISC.PROCESS_MSG("+(BigDecimal)session.getAttribute("endorsementCode") +",NULL,EMD_MSGT_NARR,'P',NULL,NULL, NULL) " +
                "FROM LMS_EMAIL_DETAILS  " + 
                "WHERE EMD_RECEPIENT='S' " + 
                "AND EMD_APPLY_AT= '"+emailAt+"' ";            
          //System.out.println(emailDetails);
          if(session.getAttribute("QuoteCode")!=null){
            emailDetails =
                            "SELECT EMD_RPT_NAME,EMD_MSGT_NARR,EMD_RPT_CODE,USR_EMAIL," +
                            "LMS_GRP_MISC.PROCESS_MSG("+(BigDecimal)session.getAttribute("QuoteCode") +",NULL,EMD_MSGT_NARR,'Q',NULL,NULL, NULL) " +
                            " FROM LMS_EMAIL_DETAILS,TQC_USERS " +
                            "  WHERE ((EMD_USR_CODE=USR_CODE AND EMD_USR_CODE IS NOT NULL) \n" + 
                            " OR (USR_USERNAME = '"+(String)session.getAttribute("Username")+"' AND EMD_USR_CODE IS NULL)) " +
                            " AND EMD_RECEPIENT='U' " +
                            "AND EMD_APPLY_AT= '"+emailAt+"'"+
                            " UNION ALL " +
                            "SELECT EMD_RPT_NAME,EMD_MSGT_NARR,EMD_RPT_CODE, " + 
                            "(SELECT PRP_EMAIL FROM LMS_PROPOSERS WHERE PRP_CODE="+(BigDecimal)session.getAttribute("prpCode") +")USR_EMAIL," +
                            "LMS_GRP_MISC.PROCESS_MSG("+(BigDecimal)session.getAttribute("QuoteCode") +",NULL,EMD_MSGT_NARR,'Q',NULL,NULL, NULL) " +
                            "FROM LMS_EMAIL_DETAILS  " + 
                            "WHERE EMD_RECEPIENT='C' " + 
                            "AND EMD_APPLY_AT= '"+emailAt+"' "+
                            " UNION ALL "+
                            "SELECT EMD_RPT_NAME,EMD_MSGT_NARR,EMD_RPT_CODE, " + 
                            "(SELECT AGN_EMAIL_ADDRESS FROM LMS_AGENCIES,LMS_QUOTATIONS " +
                              " WHERE AGN_CODE=QUO_AGENCY_CODE AND QUO_CODE="+(BigDecimal)session.getAttribute("QuoteCode") +")USR_EMAIL," +
                            "LMS_GRP_MISC.PROCESS_MSG("+(BigDecimal)session.getAttribute("endorsementCode") +",NULL,EMD_MSGT_NARR,'Q',NULL,NULL, NULL) " +
                            "FROM LMS_EMAIL_DETAILS  " + 
                            "WHERE EMD_RECEPIENT='A' " + 
                            "AND EMD_APPLY_AT= '"+emailAt+"' "+
                            " UNION ALL "+
                            "SELECT EMD_RPT_NAME,EMD_MSGT_NARR,EMD_RPT_CODE, EMD_CUSTOM_EMAIL, "+
                            "LMS_GRP_MISC.PROCESS_MSG("+(BigDecimal)session.getAttribute("QuoteCode") +",NULL,EMD_MSGT_NARR,'Q',NULL,NULL, NULL) " +
                            "FROM LMS_EMAIL_DETAILS  " + 
                            "WHERE EMD_RECEPIENT='CE' " + 
                            "AND EMD_APPLY_AT= '"+emailAt+"' "; 
          }
         
         
          cs = (OracleCallableStatement)conn.prepareCall(emailDetails);
          rst = (OracleResultSet)cs.executeQuery();
          while (rst.next()) {
              reportName=rst.getString(1);              
              rptCode=rst.getBigDecimal(3);
              emailAddress=rst.getString(4);
              content =rst.getString(5);
              //System.out.println("Address "+emailAddress);
          }
          //titleLabel.setValue("Are you sure you want to send report to "+emailAddress);
          //System.out.println(emailDetails);
          if(emailAddress!=null){
          session.setAttribute("alertMsg", "Are you sure you want to email "+emailAddress+" ?");
          GlobalCC.showPopup("lmsgroup:msgConfirm");
          }
          rst.close();
          cs.close();
         conn.close();
      }catch(Exception ex){
        ex.printStackTrace();
      }
    }
  }
  public void sendEmail(String emailPoint){
    Connection conn = null;
    OracleCallableStatement cst = null;
    OracleCallableStatement cs = null;
    conn = new DBConnector().getDatabaseConn();
    OracleResultSet rs = null;
    OracleResultSet rst = null;
    String reportName="";
    String Subject="";
    String content="";
    String emailAddress="";
    BigDecimal rptCode=null;
    String mailType =this.getMailType();

    if(GlobalCC.getSytemParam("GRP_AUTO_EMAIL").equalsIgnoreCase("Y")) {
      try {
          String emailDetails =
              "SELECT EMD_RPT_NAME,EMD_MSGT_NARR,EMD_RPT_CODE,USR_EMAIL," +
              "LMS_GRP_MISC.PROCESS_MSG("+(BigDecimal)session.getAttribute("endorsementCode") +",NULL,EMD_MSGT_NARR,'P',NULL,NULL, NULL) " +
              " FROM LMS_EMAIL_DETAILS,TQC_USERS " +
              "  WHERE ((EMD_USR_CODE=USR_CODE AND EMD_USR_CODE IS NOT NULL) \n" + 
              " OR (USR_USERNAME = '"+(String)session.getAttribute("Username")+"' AND EMD_USR_CODE IS NULL)) " +
              " AND EMD_RECEPIENT='U' " +
              " AND EMD_APPLY_AT= '"+emailPoint+"' "+
              " AND NVL(EMD_PROD_CODE,"+(BigDecimal)session.getAttribute("ProductCode")+")="+(BigDecimal)session.getAttribute("ProductCode")+" "+ 
              " UNION ALL " +
              "SELECT EMD_RPT_NAME,EMD_MSGT_NARR,EMD_RPT_CODE, " + 
              "(SELECT PRP_EMAIL FROM LMS_PROPOSERS WHERE PRP_CODE="+(BigDecimal)session.getAttribute("prpCode") +")USR_EMAIL," +
              "LMS_GRP_MISC.PROCESS_MSG("+(BigDecimal)session.getAttribute("endorsementCode") +",NULL,EMD_MSGT_NARR,'P',NULL,NULL, NULL) " +
              "FROM LMS_EMAIL_DETAILS  " + 
              "WHERE EMD_RECEPIENT='C' " + 
              "AND EMD_APPLY_AT= '"+emailPoint+"' "+
             " AND NVL(EMD_PROD_CODE,"+(BigDecimal)session.getAttribute("ProductCode")+")="+(BigDecimal)session.getAttribute("ProductCode")+" "+ 
              " UNION ALL "+
              "SELECT EMD_RPT_NAME,EMD_MSGT_NARR,EMD_RPT_CODE, " + 
              "(SELECT AGN_EMAIL_ADDRESS FROM LMS_AGENCIES,LMS_POLICY_ENDORSEMENTS " +
                " WHERE AGN_CODE=ENDR_AGEN_CODE AND ENDR_CODE="+(BigDecimal)session.getAttribute("endorsementCode") +")USR_EMAIL," +
              "LMS_GRP_MISC.PROCESS_MSG("+(BigDecimal)session.getAttribute("endorsementCode") +",NULL,EMD_MSGT_NARR,'P',NULL,NULL, NULL) " +
              "FROM LMS_EMAIL_DETAILS  " + 
              "WHERE EMD_RECEPIENT='A' " + 
              "AND EMD_APPLY_AT= '"+emailPoint+"' "+
              " UNION ALL "+
              "SELECT EMD_RPT_NAME,EMD_MSGT_NARR,EMD_RPT_CODE, EMD_CUSTOM_EMAIL, "+
              "LMS_GRP_MISC.PROCESS_MSG("+(BigDecimal)session.getAttribute("endorsementCode") +",NULL,EMD_MSGT_NARR,'P',NULL,NULL, NULL) " +
              "FROM LMS_EMAIL_DETAILS  " + 
              "WHERE EMD_RECEPIENT='CE' " + 
              "AND EMD_APPLY_AT= '"+emailPoint+"' "+
             " AND NVL(EMD_PROD_CODE,"+(BigDecimal)session.getAttribute("ProductCode")+")="+(BigDecimal)session.getAttribute("ProductCode")+" "+ 
              " UNION ALL "+
              "SELECT EMD_RPT_NAME,EMD_MSGT_NARR,EMD_RPT_CODE, " + 
              "(SELECT  DISTINCT SPR_EMAIL FROM LMS_POLICY_ENDORSEMENTS,TQC_SERVICE_PROVIDERS " +
                " WHERE ENDR_TQ_SPR_CODE=SPR_CODE AND ENDR_CODE="+(BigDecimal)session.getAttribute("endorsementCode") +")USR_EMAIL," +
                "LMS_GRP_MISC.PROCESS_MSG("+(BigDecimal)session.getAttribute("endorsementCode") +",NULL,EMD_MSGT_NARR,'P',NULL,NULL, NULL) " +
                "FROM LMS_EMAIL_DETAILS  " + 
                "WHERE EMD_RECEPIENT='S' " + 
                "AND EMD_APPLY_AT= '"+emailPoint+"' "+
              " AND NVL(EMD_PROD_CODE,"+(BigDecimal)session.getAttribute("ProductCode")+")="+(BigDecimal)session.getAttribute("ProductCode")+" "+ 
              " UNION ALL "+
              "SELECT DISTINCT EMD_RPT_NAME,EMD_MSGT_NARR,EMD_RPT_CODE,AGN_EMAIL_ADDRESS USR_EMAIL," +
              "LMS_GRP_MISC.PROCESS_MSG("+(BigDecimal)session.getAttribute("endorsementCode") +",NULL,EMD_MSGT_NARR,'P',NULL,NULL, NULL) "+
              "FROM LMS_AGENCIES,LMS_TREATY_PARTICIPANTS,(\n" + 
              "SELECT EMD_RPT_NAME,EMD_MSGT_NARR,EMD_RPT_CODE\n" + 
              "FROM LMS_EMAIL_DETAILS " + 
              "WHERE EMD_RECEPIENT='P' " + 
              " AND EMD_APPLY_AT= '"+emailPoint+"') "+
              "WHERE AGN_CODE=TRPA_AGEN_CODE\n" + 
              "AND TRPA_TRS_CODE IN(\n" + 
              "select DISTINCT REI_TRS_CODE\n" + 
              "FROM LMS_POLICY_MEM_RI_TRT_DTLS,LMS_TREATY_SETUPS\n" + 
              "WHERE PMRITD_ENDR_CODE=" +(BigDecimal)session.getAttribute("endorsementCode")+" "+ 
              "AND PMRITD_REI_CODE=REI_CODE ) " +
              "AND AGN_EMAIL_ADDRESS IS NOT NULL" ;            
          //System.out.println(emailDetails);
          if(session.getAttribute("QuoteCode")!=null){
            emailDetails =
                            "SELECT EMD_RPT_NAME,EMD_MSGT_NARR,EMD_RPT_CODE,USR_EMAIL," +
                            "LMS_GRP_MISC.PROCESS_MSG("+(BigDecimal)session.getAttribute("QuoteCode") +",NULL,EMD_MSGT_NARR,'Q',NULL,NULL, NULL) " +
                            "FROM LMS_EMAIL_DETAILS,TQC_USERS " +
                            "  WHERE ((EMD_USR_CODE=USR_CODE AND EMD_USR_CODE IS NOT NULL) \n" + 
                            " OR (USR_USERNAME = '"+(String)session.getAttribute("Username")+"' AND EMD_USR_CODE IS NULL)) " +
                            " AND EMD_RECEPIENT='U' " +
                            "AND EMD_APPLY_AT= '"+emailPoint+"'"+
                            " AND NVL(EMD_PROD_CODE,"+(BigDecimal)session.getAttribute("ProductCode")+")="+(BigDecimal)session.getAttribute("ProductCode")+" "+ 
                            " UNION ALL " +
                            "SELECT EMD_RPT_NAME,EMD_MSGT_NARR,EMD_RPT_CODE, " + 
                            "(SELECT PRP_EMAIL FROM LMS_PROPOSERS WHERE PRP_CODE="+(BigDecimal)session.getAttribute("prpCode") +")USR_EMAIL," +
                            "LMS_GRP_MISC.PROCESS_MSG("+(BigDecimal)session.getAttribute("QuoteCode") +",NULL,EMD_MSGT_NARR,'Q',NULL,NULL, NULL) " +
                            "FROM LMS_EMAIL_DETAILS  " + 
                            "WHERE EMD_RECEPIENT='C' " + 
                            "AND EMD_APPLY_AT= '"+emailPoint+"' "+
                            " AND NVL(EMD_PROD_CODE,"+(BigDecimal)session.getAttribute("ProductCode")+")="+(BigDecimal)session.getAttribute("ProductCode")+" "+ 
                            " UNION ALL "+
                            "SELECT EMD_RPT_NAME,EMD_MSGT_NARR,EMD_RPT_CODE, " + 
                            "(SELECT AGN_EMAIL_ADDRESS FROM LMS_AGENCIES,LMS_QUOTATIONS " +
                              " WHERE AGN_CODE=QUO_AGENCY_CODE AND QUO_CODE="+(BigDecimal)session.getAttribute("QuoteCode") +")USR_EMAIL," +
                            "LMS_GRP_MISC.PROCESS_MSG("+(BigDecimal)session.getAttribute("endorsementCode") +",NULL,EMD_MSGT_NARR,'Q',NULL,NULL, NULL) " +
                            "FROM LMS_EMAIL_DETAILS  " + 
                            "WHERE EMD_RECEPIENT='A' " + 
                            "AND EMD_APPLY_AT= '"+emailPoint+"' "+
                            " AND NVL(EMD_PROD_CODE,"+(BigDecimal)session.getAttribute("ProductCode")+")="+(BigDecimal)session.getAttribute("ProductCode")+" "+ 
                            " UNION ALL "+
                            "SELECT EMD_RPT_NAME,EMD_MSGT_NARR,EMD_RPT_CODE, EMD_CUSTOM_EMAIL, "+
                            "LMS_GRP_MISC.PROCESS_MSG("+(BigDecimal)session.getAttribute("QuoteCode") +",NULL,EMD_MSGT_NARR,'Q',NULL,NULL, NULL) " +
                            "FROM LMS_EMAIL_DETAILS  " + 
                            "WHERE EMD_RECEPIENT='CE' " + 
                            "AND EMD_APPLY_AT= '"+emailPoint+"' "+
                            " AND NVL(EMD_PROD_CODE,"+(BigDecimal)session.getAttribute("ProductCode")+")="+(BigDecimal)session.getAttribute("ProductCode"); 
          }
         
         
          cs = (OracleCallableStatement)conn.prepareCall(emailDetails);
          rst = (OracleResultSet)cs.executeQuery();
          while (rst.next()) {
              reportName=rst.getString(1); 
              Subject=reportName;
              rptCode=rst.getBigDecimal(3);
              emailAddress=rst.getString(4);
              content =rst.getString(5);
              
              if(emailAddress==""){
                GlobalCC.INFORMATIONREPORTING("Email address for the client not set");
              }
              
              if (reportName==""){
                if(emailPoint.equals("POLAUTH")){
                  reportName="Policy Authorization Report";
                }else if(emailPoint.equals("CLMAUTH")){
                  reportName="Claim Authorization Report";
                }else if(emailPoint.equals("QUOAUTH")){
                  reportName="Qutotation Authorization Report";
                }else if(emailPoint.equals("MEDCOMP")){
                  reportName="Medical Completion Report";
                }else if(emailPoint.equals("REIN")){
                  reportName="Reinsurance Completion Report";
                }
                
              }
              
            if(emailPoint.equals("POLAUTH")){
              Subject="Policy Authorization";
            }else if(emailPoint.equals("CLMAUTH")){
              Subject="Claim Authorization";
            }else if(emailPoint.equals("QUOAUTH")){
              Subject="Qutotation Authorization";
            }else if(emailPoint.equals("MEDCOMP")){
              Subject="Medical Completion";
            }else if(emailPoint.equals("REIN")){
              Subject="Reinsurance Completion";
            
            }
               
              if (mailType.equalsIgnoreCase("NORMAL")) {
                  this.processEmailDebits(rptCode,emailAddress,reportName,content,Subject);
    
              } else if (mailType.equalsIgnoreCase("GOOGLE")) {
                  String emailVal = null;
                  String passVal = null;
                  String emailQuery =
                      "SELECT  MAIL_USERNAME, MAIL_PASSWORD, MAIL_SECURE FROM TQC_SYSTEM_MAILS WHERE MAIL_IN_OUT = 'O' AND MAIL_TYPE='GOOGLE'";
    
    
                  cst =
                    (OracleCallableStatement)conn.prepareCall(emailQuery);
                  rs = (OracleResultSet)cst.executeQuery();
    
                  while (rs.next()) {
                      emailVal = rs.getString(1);
                      passVal = rs.getString(2);
    
                      this.sendMailDoc(rs.getString(1),
                                                                   emailAddress, 
                                                                   null,
                                                                   reportName+" Report",
                                                                   content,
                                                                   reportName+".pdf",
                                                                   reportName+".pdf",
                                                                   rptCode,
                                                                   "");
                  }
                cst.close();
                rs.close();
    
              }
          }
          
          cs.close();
          rst.close();
          
          conn.close();
      } catch (Exception e) {
          e.printStackTrace();
          GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
    } 
  }

    public void setTitleLabel(RichOutputLabel titleLabel) {
        this.titleLabel = titleLabel;
    }

    public RichOutputLabel getTitleLabel() {
        return titleLabel;
    }

    public String showConfirmAlert() {
        // Add event code here...
        if(session.getAttribute("emailPoint").toString()==null){
          return null;
        }else{            
          sendEmail(session.getAttribute("emailPoint").toString());
        }
        return null;
    }

    public String cancelAlert() {
        // Add event code here...
        GlobalCC.hidePopup("lmsgroup:msgConfirm");
        return null;
    }

    public void setAlertMessage(RichOutputText alertMessage) {
        this.alertMessage = alertMessage;
    }

    public RichOutputText getAlertMessage() {
        return alertMessage;
    }
}
