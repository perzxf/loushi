package com.ls.entity.system;

import java.util.Date;

/**
 * @author zhangchuanfei
 */
public class SysNotice {


    /**
     * 公告ID（主键）
     */
    private Long    noticeId;

    /**
     * 公告标题
     */
    private String    noticeTitle;

    /**
     * 公告类型（1：通知，2：公告）
     */
    private Integer    noticeType;

    /**
     * 公告内容
     */
    private String    noticeContent;

    /**
     * 公告状态（0：关闭，1：正常）
     */
    private Integer    status;

    /**
     * 创建者
     */
    private String    createBy;

    /**
     * 创建时间 （根据时间排序）
     */
    private Date    createTime;

    /**
     * 备注信息
     */
    private String    remark;


    public Long getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public Integer getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(Integer noticeType) {
        this.noticeType = noticeType;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        return "SysNotice{" +
                "noticeId=" + noticeId +
                ", noticeTitle='" + noticeTitle + '\'' +
                ", noticeType=" + noticeType +
                ", noticeContent='" + noticeContent + '\'' +
                ", status=" + status +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                ", remark='" + remark + '\'' +
                '}';
    }
}
