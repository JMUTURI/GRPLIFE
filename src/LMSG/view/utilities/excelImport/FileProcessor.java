package LMSG.view.utilities.excelImport;

import LMSG.view.Accounts.PortfolioBean;
import LMSG.view.Base.GlobalCC;
import LMSG.view.Policy.underwritingPolicy;
import com.turnkey.setups.setupManipulation;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import oracle.adf.view.rich.component.rich.input.RichInputFile;
import oracle.adf.view.rich.component.rich.input.RichSelectOneRadio;
import org.apache.commons.io.FileDeleteStrategy;
import org.apache.myfaces.trinidad.model.UploadedFile;

public class FileProcessor
{
  private CSVtoADFTableProcessor tablecreator;
  private UploadedFile uploadedFile;
  private String filename;
  private long filesize;
  private String filecontents;
  private String filetype;
  private RichInputFile upFile;
  private RichSelectOneRadio templateOption;
  
  public void setUploadedFile(UploadedFile uploadedFile)
  {
    this.uploadedFile = uploadedFile;
    System.out.println(this.uploadedFile);
    this.filename = uploadedFile.getFilename();
    System.out.println(this.filename);
    this.filesize = uploadedFile.getLength();
    System.out.println(this.filesize);
    this.filetype = uploadedFile.getContentType();
    System.out.println(this.filetype);
    try
    {
      this.tablecreator.processCSV(uploadedFile.getInputStream());
    }
    catch (Exception e)
    {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, e.getMessage()));
    }
  }
  
  public UploadedFile getUploadedFile()
  {
    return this.uploadedFile;
  }
  
  public void setFilename(String filename)
  {
    this.filename = filename;
  }
  
  public String getFilename()
  {
    return this.filename;
  }
  
  public void setFilesize(long filesize)
  {
    this.filesize = filesize;
  }
  
  public long getFilesize()
  {
    return this.filesize;
  }
  
  public void setFilecontents(String filecontents)
  {
    this.filecontents = filecontents;
  }
  
  public String getFilecontents()
  {
    return this.filecontents;
  }
  
  public void setFiletype(String filetype)
  {
    this.filetype = filetype;
  }
  
  public String getFiletype()
  {
    return this.filetype;
  }
  
  public void setTablecreator(CSVtoADFTableProcessor tablecreator)
  {
    this.tablecreator = tablecreator;
  }
  
  public CSVtoADFTableProcessor getTablecreator()
  {
    return this.tablecreator;
  }
  
  public void setUpFile(RichInputFile upFile)
  {
    this.upFile = upFile;
  }
  
  public RichInputFile getUpFile()
  {
    return this.upFile;
  }
  
  public void fileChange(ValueChangeEvent valueChangeEvent)
  {
    if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue())
    {
      UploadedFile _file = (UploadedFile)valueChangeEvent.getNewValue();
      this.uploadedFile = _file;
      this.filename = _file.getFilename();
      this.filesize = _file.getLength();
      this.filetype = _file.getContentType();
      try
      {
        if (this.templateOption.getValue() == null) {
          this.tablecreator.processCSV(this.uploadedFile.getInputStream());
        } else if (this.templateOption.getValue().toString().equalsIgnoreCase("D")) {
          this.tablecreator.ProcessDynamicCSV(this.uploadedFile.getInputStream());
        } else {
          this.tablecreator.processCSV(this.uploadedFile.getInputStream());
        }
      }
      catch (Exception e)
      {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, e.getMessage()));
      }
    }
  }
  
  public void fileChangeTesting(ValueChangeEvent valueChangeEvent)
  {
    if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue())
    {
      UploadedFile _file = (UploadedFile)valueChangeEvent.getNewValue();
      this.uploadedFile = _file;
      this.filename = _file.getFilename();
      this.filesize = _file.getLength();
      this.filetype = _file.getContentType();
      try
      {
        this.tablecreator.processCSVNewImplementation(this.uploadedFile.getInputStream());
      }
      catch (Exception e)
      {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, e.getMessage()));
      }
    }
  }
  
  public void fileChangeForPayment(ValueChangeEvent valueChangeEvent)
  {
    if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue())
    {
      UploadedFile _file = (UploadedFile)valueChangeEvent.getNewValue();
      this.uploadedFile = _file;
      this.filename = _file.getFilename();
      this.filesize = _file.getLength();
      this.filetype = _file.getContentType();
      try
      {
        this.tablecreator.processCSVForPayment(this.uploadedFile.getInputStream());
      }
      catch (Exception e)
      {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, e.getMessage()));
      }
    }
  }
  
  public void fileChangeForPensions(ValueChangeEvent valueChangeEvent)
  {
    if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue())
    {
      UploadedFile _file = (UploadedFile)valueChangeEvent.getNewValue();
      this.uploadedFile = _file;
      this.filename = _file.getFilename();
      this.filesize = _file.getLength();
      this.filetype = _file.getContentType();
      try
      {
        this.tablecreator.processCSVForPension(this.uploadedFile.getInputStream());
      }
      catch (Exception e)
      {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, e.getMessage()));
      }
    }
  }
  
  public void fileChangeForRefund(ValueChangeEvent valueChangeEvent)
  {
    if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue())
    {
      UploadedFile _file = (UploadedFile)valueChangeEvent.getNewValue();
      this.uploadedFile = _file;
      this.filename = _file.getFilename();
      this.filesize = _file.getLength();
      this.filetype = _file.getContentType();
      try
      {
        this.tablecreator.processCSVForRefund(this.uploadedFile.getInputStream());
      }
      catch (Exception e)
      {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, e.getMessage()));
      }
    }
  }
  
  public void fileChangeForLoanRepayment(ValueChangeEvent valueChangeEvent)
  {
    if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue())
    {
      UploadedFile _file = (UploadedFile)valueChangeEvent.getNewValue();
      this.uploadedFile = _file;
      this.filename = _file.getFilename();
      this.filesize = _file.getLength();
      this.filetype = _file.getContentType();
      try
      {
        this.tablecreator.processCSVForLoanRepayment(this.uploadedFile.getInputStream());
      }
      catch (Exception e)
      {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, e.getMessage()));
      }
    }
  }
  
  public void fileChangeForMemberImport(ValueChangeEvent valueChangeEvent)
  {
    if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue())
    {
      UploadedFile _file = (UploadedFile)valueChangeEvent.getNewValue();
      this.uploadedFile = _file;
      this.filename = _file.getFilename();
      this.filesize = _file.getLength();
      this.filetype = _file.getContentType();
      try
      {
        this.tablecreator.processCSVForMemberImport(this.uploadedFile.getInputStream());
      }
      catch (Exception e)
      {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, e.getMessage()));
      }
    }
  }
  
  public void fileChangeForBeneficiaryImport(ValueChangeEvent valueChangeEvent)
  {
    if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue())
    {
      UploadedFile _file = (UploadedFile)valueChangeEvent.getNewValue();
      this.uploadedFile = _file;
      this.filename = _file.getFilename();
      this.filesize = _file.getLength();
      this.filetype = _file.getContentType();
      try
      {
        underwritingPolicy Manip = new underwritingPolicy();
        Manip.processCSVForBeneficiaries(this.uploadedFile.getInputStream());
      }
      catch (Exception e)
      {
        GlobalCC.EXCEPTIONREPORTING(null, e);
      }
    }
  }
  
  public void fileChangeForRatesImport(ValueChangeEvent valueChangeEvent)
  {
    if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue())
    {
      UploadedFile _file = (UploadedFile)valueChangeEvent.getNewValue();
      this.uploadedFile = _file;
      this.filename = _file.getFilename();
      this.filesize = _file.getLength();
      this.filetype = _file.getContentType();
      try
      {
        setupManipulation Manip = new setupManipulation();
        Manip.processCSVForRates(this.uploadedFile.getInputStream());
      }
      catch (Exception e)
      {
        GlobalCC.EXCEPTIONREPORTING(null, e);
      }
    }
  }
  
  public void fileChangeForLoadImport(ValueChangeEvent valueChangeEvent)
  {
    if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue())
    {
      UploadedFile _file = (UploadedFile)valueChangeEvent.getNewValue();
      this.uploadedFile = _file;
      this.filename = _file.getFilename();
      this.filesize = _file.getLength();
      this.filetype = _file.getContentType();
      try
      {
        setupManipulation Manip = new setupManipulation();
        Manip.processCSVForLoadings(this.uploadedFile.getInputStream());
      }
      catch (Exception e)
      {
        GlobalCC.EXCEPTIONREPORTING(null, e);
      }
    }
  }
  
  public void fileChangeForAnnRatesImport(ValueChangeEvent valueChangeEvent)
  {
    if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue())
    {
      UploadedFile _file = (UploadedFile)valueChangeEvent.getNewValue();
      this.uploadedFile = _file;
      this.filename = _file.getFilename();
      this.filesize = _file.getLength();
      this.filetype = _file.getContentType();
      try
      {
        setupManipulation Manip = new setupManipulation();
        Manip.processCSVForAnnRates(this.uploadedFile.getInputStream());
      }
      catch (Exception e)
      {
        GlobalCC.EXCEPTIONREPORTING(null, e);
      }
    }
  }
  
  public void fileChangeForWithdrawals(ValueChangeEvent valueChangeEvent)
  {
    if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue()) {
      try
      {
        UploadedFile _file = (UploadedFile)valueChangeEvent.getNewValue();
        
        this.uploadedFile = _file;
        this.filename = _file.getFilename();
        this.filesize = _file.getLength();
        this.filetype = _file.getContentType();
        
        this.tablecreator.processCSVForPensionWithdrawals(this.uploadedFile.getInputStream());
      }
      catch (Exception e)
      {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, e.getMessage()));
      }
    }
  }
  
  public ArrayList<String> readAndFragment(String SourceFileName, int CHUNK_SIZE)
    throws IOException
  {
    File willBeRead = new File(SourceFileName);
    File fileToDelete = null;
    
    int FILE_SIZE = (int)willBeRead.length();
    ArrayList<String> nameList = new ArrayList();
    
    System.out.println("Total File Size: " + FILE_SIZE);
    
    int NUMBER_OF_CHUNKS = 0;
    byte[] temporary = null;
    try
    {
      InputStream inStream = null;
      int totalBytesRead = 0;
      try
      {
        inStream = new BufferedInputStream(new FileInputStream(willBeRead));
        while (totalBytesRead < FILE_SIZE)
        {
          String PART_NAME = "data_" + NUMBER_OF_CHUNKS + ".csv";
          System.out.println("part name " + PART_NAME);
          
          int bytesRemaining = FILE_SIZE - totalBytesRead;
          if (bytesRemaining < CHUNK_SIZE)
          {
            CHUNK_SIZE = bytesRemaining;
            System.out.println("CHUNK_SIZE: " + CHUNK_SIZE);
          }
          temporary = new byte[CHUNK_SIZE];
          int bytesRead = inStream.read(temporary, 0, CHUNK_SIZE);
          if (bytesRead > 0)
          {
            totalBytesRead += bytesRead;
            NUMBER_OF_CHUNKS++;
          }
          fileToDelete = new File("D://EXPRESS//" + PART_NAME);
          if (fileToDelete.exists()) {
            FileDeleteStrategy.FORCE.delete(fileToDelete);
          } else {
            System.err.println("I cannot find '" + fileToDelete + "' ('" + fileToDelete.getAbsolutePath() + "')");
          }
          write(temporary, "D://EXPRESS//" + PART_NAME);
          nameList.add("D://EXPRESS//" + PART_NAME);
          System.out.println("Total Bytes Read: " + totalBytesRead);
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
  
  public void setTemplateOption(RichSelectOneRadio templateOption)
  {
    this.templateOption = templateOption;
  }
  
  public RichSelectOneRadio getTemplateOption()
  {
    return this.templateOption;
  }
  
  public void fileChangeForClaims(ValueChangeEvent valueChangeEvent)
  {
    PortfolioBean portfolio = new PortfolioBean();
    if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue())
    {
      UploadedFile _file = (UploadedFile)valueChangeEvent.getNewValue();
      this.uploadedFile = _file;
      this.filename = _file.getFilename();
      this.filesize = _file.getLength();
      this.filetype = _file.getContentType();
      System.out.println("File type =====" + this.filetype);
      try
      {
        portfolio.importExcelData(this.uploadedFile.getInputStream());
      }
      catch (Exception e)
      {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, e.getMessage()));
      }
    }
  }
}
