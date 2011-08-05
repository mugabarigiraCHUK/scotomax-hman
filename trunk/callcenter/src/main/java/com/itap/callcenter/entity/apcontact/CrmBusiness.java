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
@Table(name = "crm_business")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CrmBusiness.findAll", query = "SELECT c FROM CrmBusiness c"),
    @NamedQuery(name = "CrmBusiness.findByBusinessId", query = "SELECT c FROM CrmBusiness c WHERE c.businessId = :businessId"),
    @NamedQuery(name = "CrmBusiness.findByBusinessName", query = "SELECT c FROM CrmBusiness c WHERE c.businessName = :businessName"),
    @NamedQuery(name = "CrmBusiness.findByBusinessDescription", query = "SELECT c FROM CrmBusiness c WHERE c.businessDescription = :businessDescription"),
    @NamedQuery(name = "CrmBusiness.findByBusinessUpdateDate", query = "SELECT c FROM CrmBusiness c WHERE c.businessUpdateDate = :businessUpdateDate")})
public class CrmBusiness implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "business_id")
    private Integer businessId;
    @Basic(optional = false)
    @Column(name = "business_name")
    private String businessName;
    @Column(name = "business_description")
    private String businessDescription;
    @Basic(optional = false)
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
    public int hashCode() {
        int hash = 0;
        hash += (businessId != null ? businessId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CrmBusiness)) {
            return false;
        }
        CrmBusiness other = (CrmBusiness) object;
        if ((this.businessId == null && other.businessId != null) || (this.businessId != null && !this.businessId.equals(other.businessId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itap.callcenter.entity.apcontact.CrmBusiness[ businessId=" + businessId + " ]";
    }
    
}
