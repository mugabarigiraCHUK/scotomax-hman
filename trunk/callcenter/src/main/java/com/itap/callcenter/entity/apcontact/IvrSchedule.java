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
@Table(name = "ivr_schedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IvrSchedule.findAll", query = "SELECT i FROM IvrSchedule i"),
    @NamedQuery(name = "IvrSchedule.findByScheduleId", query = "SELECT i FROM IvrSchedule i WHERE i.scheduleId = :scheduleId"),
    @NamedQuery(name = "IvrSchedule.findByScheduleName", query = "SELECT i FROM IvrSchedule i WHERE i.scheduleName = :scheduleName"),
    @NamedQuery(name = "IvrSchedule.findByScheduleDescription", query = "SELECT i FROM IvrSchedule i WHERE i.scheduleDescription = :scheduleDescription"),
    @NamedQuery(name = "IvrSchedule.findByScheduleCaller", query = "SELECT i FROM IvrSchedule i WHERE i.scheduleCaller = :scheduleCaller"),
    @NamedQuery(name = "IvrSchedule.findByScheduleCalled", query = "SELECT i FROM IvrSchedule i WHERE i.scheduleCalled = :scheduleCalled"),
    @NamedQuery(name = "IvrSchedule.findByScheduleChannel", query = "SELECT i FROM IvrSchedule i WHERE i.scheduleChannel = :scheduleChannel"),
    @NamedQuery(name = "IvrSchedule.findByScheduleStartDate", query = "SELECT i FROM IvrSchedule i WHERE i.scheduleStartDate = :scheduleStartDate"),
    @NamedQuery(name = "IvrSchedule.findByScheduleRetryTime", query = "SELECT i FROM IvrSchedule i WHERE i.scheduleRetryTime = :scheduleRetryTime"),
    @NamedQuery(name = "IvrSchedule.findByScheduleCreateDate", query = "SELECT i FROM IvrSchedule i WHERE i.scheduleCreateDate = :scheduleCreateDate"),
    @NamedQuery(name = "IvrSchedule.findByScheduleUpdateDate", query = "SELECT i FROM IvrSchedule i WHERE i.scheduleUpdateDate = :scheduleUpdateDate")})
public class IvrSchedule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "schedule_id")
    private Integer scheduleId;
    @Basic(optional = false)
    @Column(name = "schedule_name")
    private String scheduleName;
    @Column(name = "schedule_description")
    private String scheduleDescription;
    @Basic(optional = false)
    @Column(name = "schedule_caller")
    private String scheduleCaller;
    @Basic(optional = false)
    @Column(name = "schedule_called")
    private String scheduleCalled;
    @Basic(optional = false)
    @Column(name = "schedule_channel")
    private int scheduleChannel;
    @Basic(optional = false)
    @Column(name = "schedule_start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date scheduleStartDate;
    @Basic(optional = false)
    @Column(name = "schedule_retry_time")
    private int scheduleRetryTime;
    @Basic(optional = false)
    @Column(name = "schedule_create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date scheduleCreateDate;
    @Basic(optional = false)
    @Column(name = "schedule_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date scheduleUpdateDate;

    public IvrSchedule() {
    }

    public IvrSchedule(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public IvrSchedule(Integer scheduleId, String scheduleName, String scheduleCaller, String scheduleCalled, int scheduleChannel, Date scheduleStartDate, int scheduleRetryTime, Date scheduleCreateDate, Date scheduleUpdateDate) {
        this.scheduleId = scheduleId;
        this.scheduleName = scheduleName;
        this.scheduleCaller = scheduleCaller;
        this.scheduleCalled = scheduleCalled;
        this.scheduleChannel = scheduleChannel;
        this.scheduleStartDate = scheduleStartDate;
        this.scheduleRetryTime = scheduleRetryTime;
        this.scheduleCreateDate = scheduleCreateDate;
        this.scheduleUpdateDate = scheduleUpdateDate;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getScheduleName() {
        return scheduleName;
    }

    public void setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName;
    }

    public String getScheduleDescription() {
        return scheduleDescription;
    }

    public void setScheduleDescription(String scheduleDescription) {
        this.scheduleDescription = scheduleDescription;
    }

    public String getScheduleCaller() {
        return scheduleCaller;
    }

    public void setScheduleCaller(String scheduleCaller) {
        this.scheduleCaller = scheduleCaller;
    }

    public String getScheduleCalled() {
        return scheduleCalled;
    }

    public void setScheduleCalled(String scheduleCalled) {
        this.scheduleCalled = scheduleCalled;
    }

    public int getScheduleChannel() {
        return scheduleChannel;
    }

    public void setScheduleChannel(int scheduleChannel) {
        this.scheduleChannel = scheduleChannel;
    }

    public Date getScheduleStartDate() {
        return scheduleStartDate;
    }

    public void setScheduleStartDate(Date scheduleStartDate) {
        this.scheduleStartDate = scheduleStartDate;
    }

    public int getScheduleRetryTime() {
        return scheduleRetryTime;
    }

    public void setScheduleRetryTime(int scheduleRetryTime) {
        this.scheduleRetryTime = scheduleRetryTime;
    }

    public Date getScheduleCreateDate() {
        return scheduleCreateDate;
    }

    public void setScheduleCreateDate(Date scheduleCreateDate) {
        this.scheduleCreateDate = scheduleCreateDate;
    }

    public Date getScheduleUpdateDate() {
        return scheduleUpdateDate;
    }

    public void setScheduleUpdateDate(Date scheduleUpdateDate) {
        this.scheduleUpdateDate = scheduleUpdateDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scheduleId != null ? scheduleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IvrSchedule)) {
            return false;
        }
        IvrSchedule other = (IvrSchedule) object;
        if ((this.scheduleId == null && other.scheduleId != null) || (this.scheduleId != null && !this.scheduleId.equals(other.scheduleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itap.callcenter.entity.apcontact.IvrSchedule[ scheduleId=" + scheduleId + " ]";
    }
    
}
