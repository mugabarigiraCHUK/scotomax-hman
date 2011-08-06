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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
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
@Table(name = "ivr_pabx")
@XmlRootElement
public class IvrPabx implements Serializable, DomainObject {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "pabx_id", length = 11, nullable = false)
    @NotNull
    private Integer pabxId;
    
    @Column(name = "protocol_id", length = 11, nullable = false)
    @NotNull
    private int protocolId;
    
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

    public IvrPabx(Integer pabxId, int protocolId, String pabxName, Date pabxUpdateDate) {
        this.pabxId = pabxId;
        this.protocolId = protocolId;
        this.pabxName = pabxName;
        this.pabxUpdateDate = pabxUpdateDate;
    }

    public Integer getPabxId() {
        return pabxId;
    }

    public void setPabxId(Integer pabxId) {
        this.pabxId = pabxId;
    }

    public int getProtocolId() {
        return protocolId;
    }

    public void setProtocolId(int protocolId) {
        this.protocolId = protocolId;
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
        return ToStringBuilder.reflectionToString(this);
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
