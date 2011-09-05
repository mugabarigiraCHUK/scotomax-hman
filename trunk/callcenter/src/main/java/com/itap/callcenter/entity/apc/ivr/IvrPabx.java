/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itap.callcenter.entity.apc.ivr;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
@Table(name = "ivr_pabx")
@XmlRootElement
public class IvrPabx implements Serializable, DomainObject {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "pabx_id", length = 11, nullable = false)
    @GeneratedValue
    @NotNull
    private Integer pabxId;
    
    @ManyToOne
    @JoinColumn(name = "protocol_id", nullable = false)
    @NotNull
    private IvrProtocol protocol;
    
    @Column(name = "pabx_name", length = 50, nullable = false)
    @NotNull
    private String pabxName;
    
    @Column(name = "pabx_description", length = 100)
    private String pabxDescription;
    
    @Column(name = "pabx_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pabxUpdateDate;

    public IvrPabx() {
    }

    public IvrPabx(Integer pabxId) {
        this.pabxId = pabxId;
    }

    public IvrPabx(Integer pabxId, IvrProtocol protocol, String pabxName, Date pabxUpdateDate) {
        this.pabxId = pabxId;
        this.protocol = protocol;
        this.pabxName = pabxName;
        this.pabxUpdateDate = pabxUpdateDate;
    }

    public Integer getPabxId() {
        return pabxId;
    }

    public void setPabxId(Integer pabxId) {
        this.pabxId = pabxId;
    }

    public IvrProtocol getProtocol() {
		return protocol;
	}

	public void setProtocol(IvrProtocol protocol) {
		this.protocol = protocol;
	}

	public String getPabxName() {
        return pabxName;
    }

    public void setPabxName(String pabxName) {
        this.pabxName = pabxName;
    }

    public String getPabxDescription() {
        return pabxDescription;
    }

    public void setPabxDescription(String pabxDescription) {
        this.pabxDescription = pabxDescription;
    }

    public Date getPabxUpdateDate() {
        return pabxUpdateDate;
    }

    public void setPabxUpdateDate(Date pabxUpdateDate) {
        this.pabxUpdateDate = pabxUpdateDate;
    }

    @Override
    public String toString() {
    	return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
		.append("pabxId", pabxId)
		.append("pabxName", pabxName)
		.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) { return false; }
        if (o == this) { return true; }
        if (o.getClass() != getClass()) {
            return false;
        }
        IvrPabx other = (IvrPabx) o;
        return new EqualsBuilder()
                 .append(pabxId, other.pabxId)
                 .isEquals();
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
         .append(this.pabxId)
         .toHashCode();
    }
    
}
