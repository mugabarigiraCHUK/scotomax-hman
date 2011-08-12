/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itap.callcenter.entity.apc.crm;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "crm_status")
@XmlRootElement
public class CrmStatus implements Serializable, DomainObject {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "status_id", length = 11, nullable = false)
    @NotNull
    private Integer statusId;
    
    @Column(name = "status_name", length = 50, nullable = false)
    @NotNull
    private String statusName;
    
    @Column(name = "status_description", length = 100)
    private String statusDescription;
    
    @Column(name = "status_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date statusUpdateDate;

    public CrmStatus() {
    }

    public CrmStatus(Integer statusId) {
        this.statusId = statusId;
    }

    public CrmStatus(Integer statusId, String statusName, Date statusUpdateDate) {
        this.statusId = statusId;
        this.statusName = statusName;
        this.statusUpdateDate = statusUpdateDate;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public Date getStatusUpdateDate() {
        return statusUpdateDate;
    }

    public void setStatusUpdateDate(Date statusUpdateDate) {
        this.statusUpdateDate = statusUpdateDate;
    }

    @Override
    public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("statusId", statusId)
				.append("statusName", statusName)
				.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) { return false; }
        if (o == this) { return true; }
        if (o.getClass() != getClass()) {
            return false;
        }
         CrmStatus other = (CrmStatus) o;
        return new EqualsBuilder()
                 .append(statusId, other.statusId)
                 .isEquals();
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
         .append(this.statusId)
         .toHashCode();
    }
    
}
