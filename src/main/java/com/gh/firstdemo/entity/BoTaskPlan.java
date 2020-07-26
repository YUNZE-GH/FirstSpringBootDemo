package com.gh.firstdemo.entity;


import java.io.Serializable;

public class BoTaskPlan implements Serializable {

  private String id;
  private long orderindex;
  private String bindid;
  private java.sql.Timestamp createtime;
  private String createuser;
  private java.sql.Timestamp updatetime;
  private String updateuser;
  private String orgid;
  private String taskName;
  private String taskType;
  private String taskRemark;
  private java.sql.Timestamp taskPlanStartTime;
  private java.sql.Timestamp taskPlanEndTime;
  private double taskPlanHours;
  private java.sql.Timestamp taskActualStartTime;
  private java.sql.Timestamp taskActualEndTime;
  private double taskActualHours;
  private String isOverdue;
  private long importance;
  private long taskState;
  private String files;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public long getOrderindex() {
    return orderindex;
  }

  public void setOrderindex(long orderindex) {
    this.orderindex = orderindex;
  }


  public String getBindid() {
    return bindid;
  }

  public void setBindid(String bindid) {
    this.bindid = bindid;
  }


  public java.sql.Timestamp getCreatetime() {
    return createtime;
  }

  public void setCreatetime(java.sql.Timestamp createtime) {
    this.createtime = createtime;
  }


  public String getCreateuser() {
    return createuser;
  }

  public void setCreateuser(String createuser) {
    this.createuser = createuser;
  }


  public java.sql.Timestamp getUpdatetime() {
    return updatetime;
  }

  public void setUpdatetime(java.sql.Timestamp updatetime) {
    this.updatetime = updatetime;
  }


  public String getUpdateuser() {
    return updateuser;
  }

  public void setUpdateuser(String updateuser) {
    this.updateuser = updateuser;
  }


  public String getOrgid() {
    return orgid;
  }

  public void setOrgid(String orgid) {
    this.orgid = orgid;
  }


  public String getTaskName() {
    return taskName;
  }

  public void setTaskName(String taskName) {
    this.taskName = taskName;
  }


  public String getTaskType() {
    return taskType;
  }

  public void setTaskType(String taskType) {
    this.taskType = taskType;
  }


  public String getTaskRemark() {
    return taskRemark;
  }

  public void setTaskRemark(String taskRemark) {
    this.taskRemark = taskRemark;
  }


  public java.sql.Timestamp getTaskPlanStartTime() {
    return taskPlanStartTime;
  }

  public void setTaskPlanStartTime(java.sql.Timestamp taskPlanStartTime) {
    this.taskPlanStartTime = taskPlanStartTime;
  }


  public java.sql.Timestamp getTaskPlanEndTime() {
    return taskPlanEndTime;
  }

  public void setTaskPlanEndTime(java.sql.Timestamp taskPlanEndTime) {
    this.taskPlanEndTime = taskPlanEndTime;
  }


  public double getTaskPlanHours() {
    return taskPlanHours;
  }

  public void setTaskPlanHours(double taskPlanHours) {
    this.taskPlanHours = taskPlanHours;
  }


  public java.sql.Timestamp getTaskActualStartTime() {
    return taskActualStartTime;
  }

  public void setTaskActualStartTime(java.sql.Timestamp taskActualStartTime) {
    this.taskActualStartTime = taskActualStartTime;
  }


  public java.sql.Timestamp getTaskActualEndTime() {
    return taskActualEndTime;
  }

  public void setTaskActualEndTime(java.sql.Timestamp taskActualEndTime) {
    this.taskActualEndTime = taskActualEndTime;
  }


  public double getTaskActualHours() {
    return taskActualHours;
  }

  public void setTaskActualHours(double taskActualHours) {
    this.taskActualHours = taskActualHours;
  }


  public String getIsOverdue() {
    return isOverdue;
  }

  public void setIsOverdue(String isOverdue) {
    this.isOverdue = isOverdue;
  }


  public long getImportance() {
    return importance;
  }

  public void setImportance(long importance) {
    this.importance = importance;
  }


  public long getTaskState() {
    return taskState;
  }

  public void setTaskState(long taskState) {
    this.taskState = taskState;
  }


  public String getFiles() {
    return files;
  }

  public void setFiles(String files) {
    this.files = files;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("{");
    sb.append("\"id\":\"")
            .append(id).append('\"');
    sb.append(",\"orderindex\":")
            .append(orderindex);
    sb.append(",\"bindid\":\"")
            .append(bindid).append('\"');
    sb.append(",\"createtime\":\"")
            .append(createtime).append('\"');
    sb.append(",\"createuser\":\"")
            .append(createuser).append('\"');
    sb.append(",\"updatetime\":\"")
            .append(updatetime).append('\"');
    sb.append(",\"updateuser\":\"")
            .append(updateuser).append('\"');
    sb.append(",\"orgid\":\"")
            .append(orgid).append('\"');
    sb.append(",\"taskName\":\"")
            .append(taskName).append('\"');
    sb.append(",\"taskType\":\"")
            .append(taskType).append('\"');
    sb.append(",\"taskRemark\":\"")
            .append(taskRemark).append('\"');
    sb.append(",\"taskPlanStartTime\":\"")
            .append(taskPlanStartTime).append('\"');
    sb.append(",\"taskPlanEndTime\":\"")
            .append(taskPlanEndTime).append('\"');
    sb.append(",\"taskPlanHours\":")
            .append(taskPlanHours);
    sb.append(",\"taskActualStartTime\":\"")
            .append(taskActualStartTime).append('\"');
    sb.append(",\"taskActualEndTime\":\"")
            .append(taskActualEndTime).append('\"');
    sb.append(",\"taskActualHours\":")
            .append(taskActualHours);
    sb.append(",\"isOverdue\":\"")
            .append(isOverdue).append('\"');
    sb.append(",\"importance\":")
            .append(importance);
    sb.append(",\"taskState\":")
            .append(taskState);
    sb.append(",\"files\":\"")
            .append(files).append('\"');
    sb.append('}');
    return sb.toString();
  }
}
