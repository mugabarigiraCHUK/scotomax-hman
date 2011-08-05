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
@Table(name = "job_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JobStatus.findAll", query = "SELECT j FROM JobStatus j"),
    @NamedQuery(name = "JobStatus.findByStatusId", query = "SELECT j FROM JobStatus j WHERE j.statusId = :statusId"),
    @NamedQuery(name = "JobStatus.findByStatusName", query = "SELECT j FROM JobStatus j WHERE j.statusName = :statusName"),
    @NamedQuery(name = "JobStatus.findByStatusDescription", query = "SELECT j FROM JobStatus j WHERE j.statusDescription = :statusDescription"),
    @NamedQuery(name = "JobStatus.findByStatusUpdateDate", query = "SELECT j FROM JobStatus j WHERE j.statusUpdateDate = :statusUpdateDate")})
public class JobStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "status_id")
    private Integer statusId;
    @Basic(optional = false)
    @Column(name = "status_name")
    private String statusName;
    @Column(name = "status_description")
    private String statusDescription;
    @Basic(optional = false)
    @Column(name = "status_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date statusUpdateDate;

    public JobStatus() {
    }

    public JobStatus(Integer statusId) {
        this.statusId = statusId;
    }

    public JobStatus(Integer statusId, String statusName, Date statusUpdateDate) {
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
    public int hashCode() {
        int hash = 0;
        hash += (statusId != null ? statusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JobStatus)) {
            return false;
        }
        JobStatus other = (JobStatus) object;
        if ((this.statusId == null && other.statusId != null) || (this.statusId != null && !this.statusId.equals(other.statusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itap.callcenter.entity.apcontact.JobStatus[ statusId=" + statusId + " ]";
    }
    
}
