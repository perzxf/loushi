package com.ls.entity.monitor;

import java.util.Date;

/**
 * @author zhangchuanfei
 */
public class MonitorProject {

    /**
     * 项目ID（主键）
     */
    private Long    projectId;

    /**
     * 项目名称
     */
    private String  projectName;

    /**
     * 分析对象（舆情监控对象）
     */
    private String  monitorName;

    /**
     * 关键词（多个可用逗号隔开，展示的时候就是分析对象+关键词）
     */
    private String  keywords;

    /**
     * 创建者
     */
    private String  createBy;

    /**
     * 创建时间（根据时间排序）
     */
    private Date    createTime;

    /**
     * 备注信息
     */
    private String  remark;


    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getMonitorName() {
        return monitorName;
    }

    public void setMonitorName(String monitorName) {
        this.monitorName = monitorName;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "MonitorProject{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", monitorName='" + monitorName + '\'' +
                ", keywords='" + keywords + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                ", remark='" + remark + '\'' +
                '}';
    }
}
