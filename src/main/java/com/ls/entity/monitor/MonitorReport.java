package com.ls.entity.monitor;

import java.util.Date;

/**
 * @author zhangchuanfei
 */
public class MonitorReport {


    /**
     * 报告ID（主键）
     */
    private Long    reportId;

    /**
     * 报告内容
     */
    private String  reportContent;

    /**
     * 生成报告时间
     */
    private Date    createDate;

    /**
     * 报告来源于的数据ID（关联舆情项目数据表）
     */
    private Long    dataId;

    /**
     * 报告来源于的舆情项目ID（关联舆情项目表）
     */
    private Long    projectId;

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getDataId() {
        return dataId;
    }

    public void setDataId(Long dataId) {
        this.dataId = dataId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "MonitorReport{" +
                "reportId=" + reportId +
                ", reportContent='" + reportContent + '\'' +
                ", createDate=" + createDate +
                ", dataId=" + dataId +
                ", projectId=" + projectId +
                '}';
    }
}
