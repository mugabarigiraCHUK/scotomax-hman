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
@Table(name = "ivr_dtmf")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IvrDtmf.findAll", query = "SELECT i FROM IvrDtmf i"),
    @NamedQuery(name = "IvrDtmf.findByDtmfId", query = "SELECT i FROM IvrDtmf i WHERE i.dtmfId = :dtmfId"),
    @NamedQuery(name = "IvrDtmf.findByDtmfName", query = "SELECT i FROM IvrDtmf i WHERE i.dtmfName = :dtmfName"),
    @NamedQuery(name = "IvrDtmf.findByDtmfDescription", query = "SELECT i FROM IvrDtmf i WHERE i.dtmfDescription = :dtmfDescription"),
    @NamedQuery(name = "IvrDtmf.findByDtmfDigit", query = "SELECT i FROM IvrDtmf i WHERE i.dtmfDigit = :dtmfDigit"),
    @NamedQuery(name = "IvrDtmf.findByDtmfCorrectCallflowId", query = "SELECT i FROM IvrDtmf i WHERE i.dtmfCorrectCallflowId = :dtmfCorrectCallflowId"),
    @NamedQuery(name = "IvrDtmf.findByDtmfErrorCallflowId", query = "SELECT i FROM IvrDtmf i WHERE i.dtmfErrorCallflowId = :dtmfErrorCallflowId"),
    @NamedQuery(name = "IvrDtmf.findByDtmfCreateDate", query = "SELECT i FROM IvrDtmf i WHERE i.dtmfCreateDate = :dtmfCreateDate"),
    @NamedQuery(name = "IvrDtmf.findByDtmfUpdateDate", query = "SELECT i FROM IvrDtmf i WHERE i.dtmfUpdateDate = :dtmfUpdateDate")})
public class IvrDtmf implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dtmf_id")
    private Integer dtmfId;
    @Basic(optional = false)
    @Column(name = "dtmf_name")
    private String dtmfName;
    @Column(name = "dtmf_description")
    private String dtmfDescription;
    @Basic(optional = false)
    @Column(name = "dtmf_digit")
    private String dtmfDigit;
    @Basic(optional = false)
    @Column(name = "dtmf_correct_callflow_id")
    private int dtmfCorrectCallflowId;
    @Basic(optional = false)
    @Column(name = "dtmf_error_callflow_id")
    private int dtmfErrorCallflowId;
    @Basic(optional = false)
    @Column(name = "dtmf_create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtmfCreateDate;
    @Basic(optional = false)
    @Column(name = "dtmf_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtmfUpdateDate;

    public IvrDtmf() {
    }

    public IvrDtmf(Integer dtmfId) {
        this.dtmfId = dtmfId;
    }

    public IvrDtmf(Integer dtmfId, String dtmfName, String dtmfDigit, int dtmfCorrectCallflowId, int dtmfErrorCallflowId, Date dtmfCreateDate, Date dtmfUpdateDate) {
        this.dtmfId = dtmfId;
        this.dtmfName = dtmfName;
        this.dtmfDigit = dtmfDigit;
        this.dtmfCorrectCallflowId = dtmfCorrectCallflowId;
        this.dtmfErrorCallflowId = dtmfErrorCallflowId;
        this.dtmfCreateDate = dtmfCreateDate;
        this.dtmfUpdateDate = dtmfUpdateDate;
    }

    public Integer getDtmfId() {
        return dtmfId;
    }

    public void setDtmfId(Integer dtmfId) {
        this.dtmfId = dtmfId;
    }

    public String getDtmfName() {
        return dtmfName;
    }

    public void setDtmfName(String dtmfName) {
        this.dtmfName = dtmfName;
    }

    public String getDtmfDescription() {
        return dtmfDescription;
    }

    public void setDtmfDescription(String dtmfDescription) {
        this.dtmfDescription = dtmfDescription;
    }

    public String getDtmfDigit() {
        return dtmfDigit;
    }

    public void setDtmfDigit(String dtmfDigit) {
        this.dtmfDigit = dtmfDigit;
    }

    public int getDtmfCorrectCallflowId() {
        return dtmfCorrectCallflowId;
    }

    public void setDtmfCorrectCallflowId(int dtmfCorrectCallflowId) {
        this.dtmfCorrectCallflowId = dtmfCorrectCallflowId;
    }

    public int getDtmfErrorCallflowId() {
        return dtmfErrorCallflowId;
    }

    public void setDtmfErrorCallflowId(int dtmfErrorCallflowId) {
        this.dtmfErrorCallflowId = dtmfErrorCallflowId;
    }

    public Date getDtmfCreateDate() {
        return dtmfCreateDate;
    }

    public void setDtmfCreateDate(Date dtmfCreateDate) {
        this.dtmfCreateDate = dtmfCreateDate;
    }

    public Date getDtmfUpdateDate() {
        return dtmfUpdateDate;
    }

    public void setDtmfUpdateDate(Date dtmfUpdateDate) {
        this.dtmfUpdateDate = dtmfUpdateDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dtmfId != null ? dtmfId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IvrDtmf)) {
            return false;
        }
        IvrDtmf other = (IvrDtmf) object;
        if ((this.dtmfId == null && other.dtmfId != null) || (this.dtmfId != null && !this.dtmfId.equals(other.dtmfId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itap.callcenter.entity.apcontact.IvrDtmf[ dtmfId=" + dtmfId + " ]";
    }
    
}
