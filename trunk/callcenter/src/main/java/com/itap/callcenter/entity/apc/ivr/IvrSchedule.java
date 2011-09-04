/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itap.callcenter.entity.apc.ivr;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.itap.callcenter.entity.DomainObject;

/**
 *
 * @author scotomax
 */
@Entity
@Table(name = "ivr_schedule")
@XmlRootElement
public class IvrSchedule implements Serializable, DomainObject {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "schedule_id", length = 11, nullable = false)
    @NotNull
    private Integer scheduleId;
    
    @Column(name = "schedule_name", length = 50, nullable = false)
    @NotNull
    private String scheduleName;
    
    @Column(name = "schedule_description", length = 100)
    private String scheduleDescription;
    
    @Column(name = "schedule_caller", length = 50, nullable = false)
    @NotNull
    private String scheduleCaller;
    
    @Column(name = "schedule_called", length = 50, nullable = false)
    @NotNull
    private String scheduleCalled;
    
    @ManyToOne
    @JoinColumn(name = "schedule_channel", nullable = false)
    @NotNull
    private IvrChannel scheduleChannel;
    
    @Column(name = "schedule_start_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date scheduleStartDate;
    
    @Column(name = "schedule_retry_time", length = 11, nullable = false)
    @NotNull
    private Integer scheduleRetryTime;
    
    @Column(name = "schedule_create_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date scheduleCreateDate;
    
    @Column(name = "schedule_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date scheduleUpdateDate;

    public IvrSchedule() {
    }

    public IvrSchedule(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public IvrSchedule(Integer scheduleId, String scheduleName, String scheduleCaller, String scheduleCalled, IvrChannel scheduleChannel, Date scheduleStartDate, Integer scheduleRetryTime, Date scheduleCreateDate, Date scheduleUpdateDate) {
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

    public IvrChannel getScheduleChannel() {
        return scheduleChannel;
    }

    public void setScheduleChannel(IvrChannel scheduleChannel) {
        this.scheduleChannel = scheduleChannel;
    }

    public Date getScheduleStartDate() {
        return scheduleStartDate;
    }

    public void setScheduleStartDate(Date scheduleStartDate) {
        this.scheduleStartDate = scheduleStartDate;
    }

    public Integer getScheduleRetryTime() {
        return scheduleRetryTime;
    }

    public void setScheduleRetryTime(Integer scheduleRetryTime) {
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
    public String toString() {
    	return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
		.append("scheduleId", scheduleId)
		.append("scheduleName", scheduleName)
		.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) { return false; }
        if (o == this) { return true; }
        if (o.getClass() != getClass()) {
            return false;
        }
        IvrSchedule other = (IvrSchedule) o;
        return new EqualsBuilder()
                 .append(scheduleId, other.scheduleId)
                 .isEquals();
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
         .append(this.scheduleId)
         .toHashCode();
    }
    
}
