/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itap.callcenter.entity.apc.acd;

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
@Table(name = "acd_condition")
@XmlRootElement
public class AcdCondition implements Serializable, DomainObject {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "condition_id", length = 11, nullable = false)
    @NotNull
    private Integer conditionId;
    
    @Column(name = "condition_name", length = 50, nullable = false)
    @NotNull
    private String conditionName;
    
    @Column(name = "condition_description", length = 100, nullable = false)
    @NotNull
    private String conditionDescription;
    
    @Column(name = "condition_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date conditionUpdateDate;

    public AcdCondition() {
    }

    public AcdCondition(Integer conditionId) {
        this.conditionId = conditionId;
    }

    public AcdCondition(Integer conditionId, String conditionName, String conditionDescription, Date conditionUpdateDate) {
        this.conditionId = conditionId;
        this.conditionName = conditionName;
        this.conditionDescription = conditionDescription;
        this.conditionUpdateDate = conditionUpdateDate;
    }

    public Integer getConditionId() {
        return conditionId;
    }

    public void setConditionId(Integer conditionId) {
        this.conditionId = conditionId;
    }

    public String getConditionName() {
        return conditionName;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    public String getConditionDescription() {
        return conditionDescription;
    }

    public void setConditionDescription(String conditionDescription) {
        this.conditionDescription = conditionDescription;
    }

    public Date getConditionUpdateDate() {
        return conditionUpdateDate;
    }

    public void setConditionUpdateDate(Date conditionUpdateDate) {
        this.conditionUpdateDate = conditionUpdateDate;
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
        AcdCondition other = (AcdCondition) o;
        return new EqualsBuilder()
                 .append(conditionId, other.conditionId)
                 .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
         .append(this.conditionId)
         .toHashCode();
    }
    
}
