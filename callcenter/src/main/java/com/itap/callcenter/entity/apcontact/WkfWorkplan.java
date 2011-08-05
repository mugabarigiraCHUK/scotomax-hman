/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itap.callcenter.entity.apcontact;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author scotomax
 */
@Entity
@Table(name = "wkf_workplan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WkfWorkplan.findAll", query = "SELECT w FROM WkfWorkplan w"),
    @NamedQuery(name = "WkfWorkplan.findByWorkplanId", query = "SELECT w FROM WkfWorkplan w WHERE w.workplanId = :workplanId"),
    @NamedQuery(name = "WkfWorkplan.findByCalendarId", query = "SELECT w FROM WkfWorkplan w WHERE w.calendarId = :calendarId"),
    @NamedQuery(name = "WkfWorkplan.findByWorkplanName", query = "SELECT w FROM WkfWorkplan w WHERE w.workplanName = :workplanName"),
    @NamedQuery(name = "WkfWorkplan.findByWorkplanDescription", query = "SELECT w FROM WkfWorkplan w WHERE w.workplanDescription = :workplanDescription"),
    @NamedQuery(name = "WkfWorkplan.findByWorkplanStartDate", query = "SELECT w FROM WkfWorkplan w WHERE w.workplanStartDate = :workplanStartDate"),
    @NamedQuery(name = "WkfWorkplan.findByWorkplanEndDate", query = "SELECT w FROM WkfWorkplan w WHERE w.workplanEndDate = :workplanEndDate"),
    @NamedQuery(name = "WkfWorkplan.findByWorkplanStartTime", query = "SELECT w FROM WkfWorkplan w WHERE w.workplanStartTime = :workplanStartTime"),
    @NamedQuery(name = "WkfWorkplan.findByWorkplanEndTime", query = "SELECT w FROM WkfWorkplan w WHERE w.workplanEndTime = :workplanEndTime"),
    @NamedQuery(name = "WkfWorkplan.findByWorkplanCreateDate", query = "SELECT w FROM WkfWorkplan w WHERE w.workplanCreateDate = :workplanCreateDate"),
    @NamedQuery(name = "WkfWorkplan.findByWorkplanUpdateDate", query = "SELECT w FROM WkfWorkplan w WHERE w.workplanUpdateDate = :workplanUpdateDate")})
public class WkfWorkplan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "workplan_id")
    private Integer workplanId;
    @Basic(optional = false)
    @Column(name = "calendar_id")
    private int calendarId;
    @Basic(optional = false)
    @Column(name = "workplan_name")
    private String workplanName;
    @Column(name = "workplan_description")
    private String workplanDescription;
    @Basic(optional = false)
    @Column(name = "workplan_start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date workplanStartDate;
    @Basic(optional = false)
    @Column(name = "workplan_end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date workplanEndDate;
    @Basic(optional = false)
    @Column(name = "workplan_start_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date workplanStartTime;
    @Basic(optional = false)
    @Column(name = "workplan_end_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date workplanEndTime;
    @Basic(optional = false)
    @Column(name = "workplan_create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date workplanCreateDate;
    @Basic(optional = false)
    @Column(name = "workplan_update_date")
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
    public int hashCode() {
        int hash = 0;
        hash += (workplanId != null ? workplanId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WkfWorkplan)) {
            return false;
        }
        WkfWorkplan other = (WkfWorkplan) object;
        if ((this.workplanId == null && other.workplanId != null) || (this.workplanId != null && !this.workplanId.equals(other.workplanId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itap.callcenter.entity.apcontact.WkfWorkplan[ workplanId=" + workplanId + " ]";
    }
    
}
