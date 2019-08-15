package LMSG.view.root;

import LMSG.view.Base.GlobalCC;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;

import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;

import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.HashMap;

import java.util.Map;

import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.misc.BASE64Decoder;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

public class DocumentServlet extends HttpServlet {
    private static final HashMap<String, String> mimeTypes;

    static {
        mimeTypes = new HashMap<String, String>() {
                {
                    put(".bmp", "image/bmp");
                    put(".doc", "application/msword");
                    put(".docm",
                        "application/vnd.ms-word.document.macroEnabled.12");
                    put(".docx",
                        "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
                    put(".htm", "text/html");
                    put(".html", "text/html");
                    put(".jpb", "application/octet-stream");
                    put(".jpe", "image/jpeg");
                    put(".jpeg", "image/jpeg");
                    put(".jpg", "image/jpeg");
                    put(".pdf", "application/pdf");
                    put(".xhtml", "application/xhtml+xml");
                    put(".xls", "application/vnd.ms-excel");
                    put(".png", "image/png");
                    put(".xlsb",
                        "application/vnd.ms-excel.sheet.binary.macroEnabled.12");

                }
            };
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException,
                                                           IOException {
        String documentType =
            (String)request.getSession().getAttribute("docDocType");
        String extension = getKeyByValue(mimeTypes, documentType);
        String byteArr =
            (String)request.getSession().getAttribute("docBase24String");
        byte[] decodeResult = new BASE64Decoder().decodeBuffer(byteArr);
        if (documentType == null) {
            GlobalCC.INFORMATIONREPORTING("Unable to render document...Invalid Document type");
            return;
        }
        if ("application/pdf".equalsIgnoreCase(documentType)) {
            response.setContentType(documentType);
            response.setContentLength(decodeResult.length);
            response.getOutputStream().write(decodeResult);
            response.getOutputStream().flush();
            response.getOutputStream().close();
        } else if ("image/jpeg".equalsIgnoreCase(documentType) ||
                   "image/png".equalsIgnoreCase(documentType)) {
            Document document = new Document();
            String docName = UUID.randomUUID().toString() + extension;
            File toRender = convertToPdf(decodeResult, extension, docName);
            File outputFile = new File(docName + ".pdf");
            try {

                FileOutputStream fos = new FileOutputStream(docName + ".pdf");
                PdfWriter writer = PdfWriter.getInstance(document, fos);
                writer.open();
                document.open();
                document.add(Image.getInstance(docName));
                document.close();
                writer.close();

                byte[] bytesArray = new byte[(int)outputFile.length()];

                FileInputStream fis = new FileInputStream(outputFile);
                fis.read(bytesArray); //read file into bytes[]
                fis.close();

                response.setContentType("application/pdf");
                response.setContentLength(bytesArray.length);
                response.getOutputStream().write(bytesArray);
                response.getOutputStream().flush();
                response.getOutputStream().close();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                toRender.delete();
                outputFile.delete();
            }
        }else{
                    String docName = UUID.randomUUID().toString()+extension;
                    File toRender = convertToPdf(decodeResult,extension,docName);
                    File outputFile = new File(docName+".pdf");
                    
                    System.out.println(toRender.getAbsolutePath());
             System.out.println("Document Type "+documentType);
                    OpenOfficeConnection connection =null;
                               try {

                                   
                                    connection = new SocketOpenOfficeConnection(8100);
                                   connection.connect();

                                   DocumentConverter converter = new OpenOfficeDocumentConverter(connection);
                                   converter.convert(toRender, outputFile);
                                   connection.disconnect();
                                   
                                   byte[] bytesArray = new byte[(int) outputFile.length()]; 

                                     FileInputStream fis = new FileInputStream(outputFile);
                                     fis.read(bytesArray); //read file into bytes[]
                                     fis.close();
                                   
                                   response.setContentType("application/pdf");
                                   response.setContentLength(bytesArray.length);
                                   response.getOutputStream().write(bytesArray);
                                   response.getOutputStream().flush();
                                   response.getOutputStream().close();
                               }
                               catch (Exception ex){
                                   response.setContentType(documentType);
                                   response.setContentLength(decodeResult.length);
                                   response.getOutputStream().write(decodeResult);
                                   response.getOutputStream().flush();
                                   response.getOutputStream().close();
                               }
                               finally{
                                   if(connection!=null){
                                       connection.disconnect();
                                   }
                                   toRender.delete();
                                   outputFile.delete();
                               }
                    
                
         }
    }

    private File convertToPdf(byte[] byteArray, String extension,
                              String docName) throws IOException {
        FileOutputStream fileOuputStream = null;
        File file = new File(docName);
        try {
            fileOuputStream = new FileOutputStream(docName);
            fileOuputStream.write(byteArray);
        } finally {
            fileOuputStream.close();
        }
        return file;
    }

    private <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
