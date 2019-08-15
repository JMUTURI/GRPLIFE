package LMSG.view.dms;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlfrescoCommentItem
{
  @SerializedName("url")
  @Expose
  private String url;
  @SerializedName("nodeRef")
  @Expose
  private String nodeRef;
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("title")
  @Expose
  private String title;
  @SerializedName("content")
  @Expose
  private String content;
  @SerializedName("author")
  @Expose
  private AlfrescoAuthor author;
  @SerializedName("createdOn")
  @Expose
  private String createdOn;
  @SerializedName("modifiedOn")
  @Expose
  private String modifiedOn;
  @SerializedName("createdOnISO")
  @Expose
  private String createdOnISO;
  @SerializedName("modifiedOnISO")
  @Expose
  private String modifiedOnISO;
  @SerializedName("isUpdated")
  @Expose
  private Boolean isUpdated;
  @SerializedName("permissions")
  @Expose
  private Permissions permissions;
  
  public String getUrl()
  {
    return this.url;
  }
  
  public void setUrl(String url)
  {
    this.url = url;
  }
  
  public String getNodeRef()
  {
    return this.nodeRef;
  }
  
  public void setNodeRef(String nodeRef)
  {
    this.nodeRef = nodeRef;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public void setTitle(String title)
  {
    this.title = title;
  }
  
  public String getContent()
  {
    try
    {
      if (this.content != null)
      {
        Matcher m = Pattern.compile(".*<p>(.*)<\\/p>.*").matcher(this.content);
        m.matches();
        return m.group(1);
      }
    }
    catch (Exception ex)
    {
      return this.content;
    }
    return this.content;
  }
  
  public void setContent(String content)
  {
    this.content = content;
  }
  
  public AlfrescoAuthor getAuthor()
  {
    return this.author;
  }
  
  public void setAuthor(AlfrescoAuthor author)
  {
    this.author = author;
  }
  
  public String getCreatedOn()
  {
    return this.createdOn;
  }
  
  public void setCreatedOn(String createdOn)
  {
    this.createdOn = createdOn;
  }
  
  public String getModifiedOn()
  {
    return this.modifiedOn;
  }
  
  public void setModifiedOn(String modifiedOn)
  {
    this.modifiedOn = modifiedOn;
  }
  
  public String getCreatedOnISO()
  {
    return this.createdOnISO;
  }
  
  public void setCreatedOnISO(String createdOnISO)
  {
    this.createdOnISO = createdOnISO;
  }
  
  public String getModifiedOnISO()
  {
    return this.modifiedOnISO;
  }
  
  public void setModifiedOnISO(String modifiedOnISO)
  {
    this.modifiedOnISO = modifiedOnISO;
  }
  
  public Boolean getIsUpdated()
  {
    return this.isUpdated;
  }
  
  public void setIsUpdated(Boolean isUpdated)
  {
    this.isUpdated = isUpdated;
  }
  
  public Permissions getPermissions()
  {
    return this.permissions;
  }
  
  public void setPermissions(Permissions permissions)
  {
    this.permissions = permissions;
  }
}
