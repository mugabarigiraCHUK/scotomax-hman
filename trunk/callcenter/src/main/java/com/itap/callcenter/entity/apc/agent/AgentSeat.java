/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itap.callcenter.entity.apc.agent;

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
@Table(name = "agent_seat")
@XmlRootElement
public class AgentSeat implements Serializable, DomainObject {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "seat_id", length = 11, nullable = false)
    @NotNull
    private Integer seatId;
    
    @ManyToOne
    @JoinColumn(name="level_id", nullable = false)
    @NotNull
    private AgentLevel agentLevel;
    
    @ManyToOne
    @JoinColumn(name="skill_id", nullable = false)
    @NotNull
    private AgentSkill agentSkill;
    
    @Column(name = "status_id", length = 11, nullable = false)
    @NotNull
    private int statusId;
    
    @Column(name = "seat_name", length = 50, nullable = false)
    @NotNull
    private String seatName;
    
    @Column(name = "seat_description", length = 100)
    private String seatDescription;
    
    @Column(name = "seat_start_period", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date seatStartPeriod;
    
    @Column(name = "seat_end_period", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date seatEndPeriod;
    
    @Column(name = "seat_max_call", length = 11, nullable = false)
    @NotNull
    private int seatMaxCall;
    
    @Column(name = "seat_allow_outbound", length = 11, nullable = false)
    @NotNull
    private int seatAllowOutbound;
    
    @Column(name = "seat_create_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date seatCreateDate;
    
    @Column(name = "seat_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date seatUpdateDate;

    public AgentSeat() {
    }

    public AgentSeat(Integer seatId) {
        this.seatId = seatId;
    }

    public AgentSeat(Integer seatId, AgentLevel agentLevel, AgentSkill agentSkill, int statusId, String seatName, Date seatStartPeriod, Date seatEndPeriod, int seatMaxCall, int seatAllowOutbound, Date seatCreateDate, Date seatUpdateDate) {
        this.seatId = seatId;
        this.agentLevel = agentLevel;
        this.agentSkill = agentSkill;
        this.statusId = statusId;
        this.seatName = seatName;
        this.seatStartPeriod = seatStartPeriod;
        this.seatEndPeriod = seatEndPeriod;
        this.seatMaxCall = seatMaxCall;
        this.seatAllowOutbound = seatAllowOutbound;
        this.seatCreateDate = seatCreateDate;
        this.seatUpdateDate = seatUpdateDate;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public AgentLevel getAgentLevel() {
		return agentLevel;
	}

	public void setAgentLevel(AgentLevel agentLevel) {
		this.agentLevel = agentLevel;
	}

	public AgentSkill getAgentSkill() {
		return agentSkill;
	}

	public void setAgentSkill(AgentSkill agentSkill) {
		this.agentSkill = agentSkill;
	}

	public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getSeatName() {
        return seatName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }

    public String getSeatDescription() {
        return seatDescription;
    }

    public void setSeatDescription(String seatDescription) {
        this.seatDescription = seatDescription;
    }

    public Date getSeatStartPeriod() {
        return seatStartPeriod;
    }

    public void setSeatStartPeriod(Date seatStartPeriod) {
        this.seatStartPeriod = seatStartPeriod;
    }

    public Date getSeatEndPeriod() {
        return seatEndPeriod;
    }

    public void setSeatEndPeriod(Date seatEndPeriod) {
        this.seatEndPeriod = seatEndPeriod;
    }

    public int getSeatMaxCall() {
        return seatMaxCall;
    }

    public void setSeatMaxCall(int seatMaxCall) {
        this.seatMaxCall = seatMaxCall;
    }

    public int getSeatAllowOutbound() {
        return seatAllowOutbound;
    }

    public void setSeatAllowOutbound(int seatAllowOutbound) {
        this.seatAllowOutbound = seatAllowOutbound;
    }

    public Date getSeatCreateDate() {
        return seatCreateDate;
    }

    public void setSeatCreateDate(Date seatCreateDate) {
        this.seatCreateDate = seatCreateDate;
    }

    public Date getSeatUpdateDate() {
        return seatUpdateDate;
    }

    public void setSeatUpdateDate(Date seatUpdateDate) {
        this.seatUpdateDate = seatUpdateDate;
    }

    @Override
    public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("seatId", seatId)
				.append("seatName", seatName)
				.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) { return false; }
        if (o == this) { return true; }
        if (o.getClass() != getClass()) {
            return false;
        }
        AgentSeat other = (AgentSeat) o;
        return new EqualsBuilder()
                 .append(seatId, other.seatId)
                 .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
         .append(this.seatId)
         .toHashCode();
    }
    
}
