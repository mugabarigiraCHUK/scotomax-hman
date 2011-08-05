/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itap.callcenter.entity.apcontact;

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
@Table(name = "ivr_callroute")
@XmlRootElement
public class IvrCallroute implements Serializable, DomainObject {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "callroute_id")
    private Integer callrouteId;
    
    @Column(name = "callroute_name")
    private String callrouteName;
    
    @Column(name = "callroute_description")
    private String callrouteDescription;
    
    @Column(name = "callroute_caller")
    private String callrouteCaller;
    
    @Column(name = "callroute_called")
    private String callrouteCalled;
    
    @Column(name = "callroute_create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date callrouteCreateDate;
    
    @Column(name = "callroute_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date callrouteUpdateDate;

    public IvrCallroute() {
    }

    public IvrCallroute(Integer callrouteId) {
        this.callrouteId = callrouteId;
    }

    public IvrCallroute(Integer callrouteId, String callrouteName, Date callrouteCreateDate, Date callrouteUpdateDate) {
        this.callrouteId = callrouteId;
        this.callrouteName = callrouteName;
        this.callrouteCreateDate = callrouteCreateDate;
        this.callrouteUpdateDate = callrouteUpdateDate;
    }

    public Integer getCallrouteId() {
        return callrouteId;
    }

    public void setCallrouteId(Integer callrouteId) {
        this.callrouteId = callrouteId;
    }

    public String getCallrouteName() {
        return callrouteName;
    }

    public void setCallrouteName(String callrouteName) {
        this.callrouteName = callrouteName;
    }

    public String getCallrouteDescription() {
        return callrouteDescription;
    }

    public void setCallrouteDescription(String callrouteDescription) {
        this.callrouteDescription = callrouteDescription;
    }

    public String getCallrouteCaller() {
        return callrouteCaller;
    }

    public void setCallrouteCaller(String callrouteCaller) {
        this.callrouteCaller = callrouteCaller;
    }

    public String getCallrouteCalled() {
        return callrouteCalled;
    }

    public void setCallrouteCalled(String callrouteCalled) {
        this.callrouteCalled = callrouteCalled;
    }

    public Date getCallrouteCreateDate() {
        return callrouteCreateDate;
    }

    public void setCallrouteCreateDate(Date callrouteCreateDate) {
        this.callrouteCreateDate = callrouteCreateDate;
    }

    public Date getCallrouteUpdateDate() {
        return callrouteUpdateDate;
    }

    public void setCallrouteUpdateDate(Date callrouteUpdateDate) {
        this.callrouteUpdateDate = callrouteUpdateDate;
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
        IvrCallroute other = (IvrCallroute) o;
        return new EqualsBuilder()
                 .append(callrouteId, other.callrouteId)
                 .isEquals();
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
         .append(this.callrouteId)
         .toHashCode();
    }
    
}
