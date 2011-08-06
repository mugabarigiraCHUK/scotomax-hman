/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itap.callcenter.entity.apc.wkf;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.itap.callcenter.entity.DomainObject;

/**
 *
 * @author scotomax
 */
@Entity
@Table(name = "wkf_workplan")
@XmlRootElement
public class WkfWorkplan implements Serializable, DomainObject {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "workplan_id", length = 11, nullable = false)
    private Integer workplanId;
    
    @Column(name = "calendar_id", length = 11, nullable = false)
    private int calendarId;
    
    @Column(name = "workplan_name", length = 50, nullable = false)
    private String workplanName;
    
    @Column(name = "workplan_description", nullable = false)
    private String workplanDescription;
    
    @Column(name = "workplan_start_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date workplanStartDate;
    
    @Column(name = "workplan_end_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date workplanEndDate;
    
    @Column(name = "workplan_start_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date workplanStartTime;
    
    @Column(name = "workplan_end_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date workplanEndTime;
    
    @Column(name = "workplan_create_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date workplanCreateDate;
    
    @Column(name = "workplan_update_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date workplanUpdateDate;

    public WkfWorkplan() {
    }

    public WkfWorkplan(Integer workplanId) {
        this.workplanId = workplanId;
    }

    public WkfWorkplan(Integer workplanId, int calendarId, String workplanName, Date workplanStartDate, Date workplanEndDate, Date workplanStartTime, Date workplanEndTime, Date workplanCreateDate, Date workplanUpdateDate) {
        this.workplanId = workplanId;
        this.calendarId = calendarId;
        this.workplanName = workplanName;
        this.workplanStartDate = workplanStartDate;
        this.workplanEndDate = workplanEndDate;
        this.workplanStartTime = workplanStartTime;
        this.workplanEndTime = workplanEndTime;
        this.workplanCreateDate = workplanCreateDate;
        this.workplanUpdateDate = workplanUpdateDate;
    }

    public Integer getWorkplanId() {
        return workplanId;
    }

    public void setWorkplanId(Integer workplanId) {
        this.workplanId = workplanId;
    }

    public int getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(int calendarId) {
        this.calendarId = calendarId;
    }

    public String getWorkplanName() {
        return workplanName;
    }

    public void setWorkplanName(String workplanName) {
        this.workplanName = workplanName;
    }

    public String getWorkplanDescription() {
        return workplanDescription;
    }

    public void setWorkplanDescription(String workplanDescription) {
        this.workplanDescription = workplanDescription;
    }

    public Date getWorkplanStartDate() {
        return workplanStartDate;
    }

    public void setWorkplanStartDate(Date workplanStartDate) {
        this.workplanStartDate = workplanStartDate;
    }

    public Date getWorkplanEndDate() {
        return workplanEndDate;
    }

    public void setWorkplanEndDate(Date workplanEndDate) {
        this.workplanEndDate = workplanEndDate;
    }

    public Date getWorkplanStartTime() {
        return workplanStartTime;
    }

    public void setWorkplanStartTime(Date workplanStartTime) {
        this.workplanStartTime = workplanStartTime;
    }

    public Date getWorkplanEndTime() {
        return workplanEndTime;
    }

    public void setWorkplanEndTime(Date workplanEndTime) {
        this.workplanEndTime = workplanEndTime;
    }

    public Date getWorkplanCreateDate() {
        return workplanCreateDate;
    }

    public void setWorkplanCreateDate(Date workplanCreateDate) {
        this.workplanCreateDate = workplanCreateDate;
    }

    public Date getWorkplanUpdateDate() {
        return workplanUpdateDate;
    }

    public void setWorkplanUpdateDate(Date workplanUpdateDate) {
        this.workplanUpdateDate = workplanUpdateDate;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) { return false; }
        if (o == this) { return true; }
        if (o.getClass() != getClass()) {
            return false;
        }
        WkfWorkplan other = (WkfWorkplan) o;
        return new EqualsBuilder()
                 .append(workplanId, other.workplanId)
                 .isEquals();
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
         .append(this.workplanId)
         .toHashCode();
    }
    
}
