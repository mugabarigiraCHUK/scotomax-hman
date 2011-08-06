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
@Table(name = "crm_business")
@XmlRootElement
public class CrmBusiness implements Serializable, DomainObject {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "business_id")
    private Integer businessId;
    
    @Column(name = "business_name")
    private String businessName;
    
    @Column(name = "business_description")
    private String businessDescription;
    
    @Column(name = "business_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date businessUpdateDate;

    public CrmBusiness() {
    }

    public CrmBusiness(Integer businessId) {
        this.businessId = businessId;
    }

    public CrmBusiness(Integer businessId, String businessName, Date businessUpdateDate) {
        this.businessId = businessId;
        this.businessName = businessName;
        this.businessUpdateDate = businessUpdateDate;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessDescription() {
        return businessDescription;
    }

    public void setBusinessDescription(String businessDescription) {
        this.businessDescription = businessDescription;
    }

    public Date getBusinessUpdateDate() {
        return businessUpdateDate;
    }

    public void setBusinessUpdateDate(Date businessUpdateDate) {
        this.businessUpdateDate = businessUpdateDate;
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
        CrmBusiness other = (CrmBusiness) o;
        return new EqualsBuilder()
                 .append(businessId, other.businessId)
                 .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
         .append(this.businessId)
         .toHashCode();
    }
    
}