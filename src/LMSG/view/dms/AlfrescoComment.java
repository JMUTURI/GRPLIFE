package LMSG.view.dms;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class AlfrescoComment
{
  @SerializedName("nodePermissions")
  @Expose
  private NodePermissions nodePermissions;
  @SerializedName("total")
  @Expose
  private Integer total;
  @SerializedName("pageSize")
  @Expose
  private Integer pageSize;
  @SerializedName("startIndex")
  @Expose
  private Integer startIndex;
  @SerializedName("itemCount")
  @Expose
  private Integer itemCount;
  @SerializedName("items")
  @Expose
  private List<AlfrescoCommentItem> items = null;
  
  public NodePermissions getNodePermissions()
  {
    return this.nodePermissions;
  }
  
  public void setNodePermissions(NodePermissions nodePermissions)
  {
    this.nodePermissions = nodePermissions;
  }
  
  public Integer getTotal()
  {
    return this.total;
  }
  
  public void setTotal(Integer total)
  {
    this.total = total;
  }
  
  public Integer getPageSize()
  {
    return this.pageSize;
  }
  
  public void setPageSize(Integer pageSize)
  {
    this.pageSize = pageSize;
  }
  
  public Integer getStartIndex()
  {
    return this.startIndex;
  }
  
  public void setStartIndex(Integer startIndex)
  {
    this.startIndex = startIndex;
  }
  
  public Integer getItemCount()
  {
    return this.itemCount;
  }
  
  public void setItemCount(Integer itemCount)
  {
    this.itemCount = itemCount;
  }
  
  public List<AlfrescoCommentItem> getItems()
  {
    return this.items;
  }
  
  public void setItems(List<AlfrescoCommentItem> items)
  {
    this.items = items;
  }
}

