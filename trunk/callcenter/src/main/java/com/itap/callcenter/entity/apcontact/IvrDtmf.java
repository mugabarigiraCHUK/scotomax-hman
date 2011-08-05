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
@Table(name = "ivr_dtmf")
@XmlRootElement
public class IvrDtmf implements Serializable, DomainObject {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "dtmf_id")
    
    private Integer dtmfId;
    
    @Column(name = "dtmf_name")
    private String dtmfName;
    
    @Column(name = "dtmf_description")
    private String dtmfDescription;
    
    @Column(name = "dtmf_digit")
    private String dtmfDigit;
    
    @Column(name = "dtmf_correct_callflow_id")
    private int dtmfCorrectCallflowId;
    
    @Column(name = "dtmf_error_callflow_id")
    private int dtmfErrorCallflowId;
    
    @Column(name = "dtmf_create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtmfCreateDate;
    
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
        IvrDtmf other = (IvrDtmf) o;
        return new EqualsBuilder()
                 .append(dtmfId, other.dtmfId)
                 .isEquals();
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
         .append(this.dtmfId)
         .toHashCode();
    }
    
}
