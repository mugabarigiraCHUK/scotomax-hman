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
@Table(name = "ivr_dtmf")
@XmlRootElement
public class IvrDtmf implements Serializable, DomainObject {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "dtmf_id", length = 11, nullable = false)
    @NotNull
    private Integer dtmfId;
    
    @Column(name = "dtmf_name", length = 50, nullable = false)
    @NotNull
    private String dtmfName;
    
    @Column(name = "dtmf_description", length = 100)
    @NotNull
    private String dtmfDescription;
    
    @Column(name = "dtmf_digit", length = 50, nullable = false)
    @NotNull
    private String dtmfDigit;
    
    @ManyToOne
    @JoinColumn(name = "dtmf_correct_callflow_id", nullable = false)
    @NotNull
    private IvrCallflow dtmfCorrectCallflow;
    
    @ManyToOne
    @JoinColumn(name = "dtmf_error_callflow_id", nullable = false)
    @NotNull
    private IvrCallflow dtmfErrorCallflow;
    
    @Column(name = "dtmf_create_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date dtmfCreateDate;
    
    @Column(name = "dtmf_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtmfUpdateDate;

    public IvrDtmf() {
    }

    public IvrDtmf(Integer dtmfId) {
        this.dtmfId = dtmfId;
    }

    public IvrDtmf(Integer dtmfId, String dtmfName, String dtmfDigit, IvrCallflow dtmfCorrectCallflow, IvrCallflow dtmfErrorCallflow, Date dtmfCreateDate, Date dtmfUpdateDate) {
        this.dtmfId = dtmfId;
        this.dtmfName = dtmfName;
        this.dtmfDigit = dtmfDigit;
        this.dtmfCorrectCallflow = dtmfCorrectCallflow;
        this.dtmfErrorCallflow = dtmfErrorCallflow;
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

    public IvrCallflow getDtmfCorrectCallflow() {
		return dtmfCorrectCallflow;
	}

	public void setDtmfCorrectCallflow(IvrCallflow dtmfCorrectCallflow) {
		this.dtmfCorrectCallflow = dtmfCorrectCallflow;
	}

	public IvrCallflow getDtmfErrorCallflow() {
		return dtmfErrorCallflow;
	}

	public void setDtmfErrorCallflow(IvrCallflow dtmfErrorCallflow) {
		this.dtmfErrorCallflow = dtmfErrorCallflow;
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
    	return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
		.append("dtmfId", dtmfId)
		.append("dtmfName", dtmfName)
		.toString();
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
