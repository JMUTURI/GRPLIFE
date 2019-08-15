package LMSG.view.dms;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NodePermissions
{
  @SerializedName("create")
  @Expose
  private Boolean create;
  @SerializedName("edit")
  @Expose
  private Boolean edit;
  @SerializedName("delete")
  @Expose
  private Boolean delete;
  
  public Boolean getCreate()
  {
    return this.create;
  }
  
  public void setCreate(Boolean create)
  {
    this.create = create;
  }
  
  public Boolean getEdit()
  {
    return this.edit;
  }
  
  public void setEdit(Boolean edit)
  {
    this.edit = edit;
  }
  
  public Boolean getDelete()
  {
    return this.delete;
  }
  
  public void setDelete(Boolean delete)
  {
    this.delete = delete;
  }
}

