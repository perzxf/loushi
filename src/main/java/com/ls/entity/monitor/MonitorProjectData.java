package com.ls.entity.monitor;

import java.util.Date;

/**
 * @author zhangchuanfei
 */
public class MonitorProjectData {

    /**
     * 数据ID（主键）
     */
    private Long    data_id;

    /**
     * 事件标题
     */
    private String  event_title;

    /**
     * 事件链接（原文链接）
     */
    private String  event_url;

    /**
     * 事件发生日期
     */
    private Date    event_date;

    /**
     * 事件内容
     */
    private String  event_content;

    /**
     * 监测到事件的日期 （根据时间排序）
     */
    private Date    monitor_date;

    /**
     * 处理状态（1：已处理，0：未处理）
     */
    private int     state;

    /**
     * 事件类型（1：正面，2：负面，3：疑似中性）
     */
    private int     event_type;

    /**
     * 舆情项目ID（关联舆情项目表）
     */
    private Long    project_id;


    public Long getData_id() {
        return data_id;
    }

    public void setData_id(Long data_id) {
        this.data_id = data_id;
    }

    public String getEvent_title() {
        return event_title;
    }

    public void setEvent_title(String event_title) {
        this.event_title = event_title;
    }

    public String getEvent_url() {
        return event_url;
    }

    public void setEvent_url(String event_url) {
        this.event_url = event_url;
    }

    public Date getEvent_date() {
        return event_date;
    }

    public void setEvent_date(Date event_date) {
        this.event_date = event_date;
    }

    public String getEvent_content() {
        return event_content;
    }

    public void setEvent_content(String event_content) {
        this.event_content = event_content;
    }

    public Date getMonitor_date() {
        return monitor_date;
    }

    public void setMonitor_date(Date monitor_date) {
        this.monitor_date = monitor_date;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getEvent_type() {
        return event_type;
    }

    public void setEvent_type(int event_type) {
        this.event_type = event_type;
    }

    public Long getProject_id() {
        return project_id;
    }

    public void setProject_id(Long project_id) {
        this.project_id = project_id;
    }

    @Override
    public String toString() {
        return "MonitorProjectData{" +
                "data_id=" + data_id +
                ", event_title='" + event_title + '\'' +
                ", event_url='" + event_url + '\'' +
                ", event_date=" + event_date +
                ", event_content='" + event_content + '\'' +
                ", monitor_date=" + monitor_date +
                ", state=" + state +
                ", event_type=" + event_type +
                ", project_id=" + project_id +
                '}';
    }
}
