/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itap.callcenter.entity.apc.knw;

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
@Table(name = "knw_category")
@XmlRootElement
public class KnwCategory implements Serializable, DomainObject {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "category_id", length = 11, nullable = false)
    @NotNull
    private Integer categoryId;
    
    @ManyToOne
    @JoinColumn(name = "parent_category_id")
    private KnwCategory parentCategory;
    
    @Column(name = "category_name", length = 50, nullable = false)
    @NotNull
    private String categoryName;
    
    @Column(name = "category_description", length = 100)
    private String categoryDescription;
    
    @Column(name = "category_create_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date categoryCreateDate;
    
    @Column(name = "category_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date categoryUpdateDate;

    public KnwCategory() {
    }

    public KnwCategory(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public KnwCategory(Integer categoryId, KnwCategory parentCategory, String categoryName, Date categoryCreateDate, Date categoryUpdateDate) {
        this.categoryId = categoryId;
        this.parentCategory = parentCategory;
        this.categoryName = categoryName;
        this.categoryCreateDate = categoryCreateDate;
        this.categoryUpdateDate = categoryUpdateDate;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public KnwCategory getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(KnwCategory parentCategory) {
		this.parentCategory = parentCategory;
	}

	public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public Date getCategoryCreateDate() {
        return categoryCreateDate;
    }

    public void setCategoryCreateDate(Date categoryCreateDate) {
        this.categoryCreateDate = categoryCreateDate;
    }

    public Date getCategoryUpdateDate() {
        return categoryUpdateDate;
    }

    public void setCategoryUpdateDate(Date categoryUpdateDate) {
        this.categoryUpdateDate = categoryUpdateDate;
    }

    @Override
    public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("categoryId", categoryId)
				.append("categoryId", categoryId)
				.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) { return false; }
        if (o == this) { return true; }
        if (o.getClass() != getClass()) {
            return false;
        }
        KnwCategory other = (KnwCategory) o;
        return new EqualsBuilder()
                 .append(categoryId, other.categoryId)
                 .isEquals();
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
         .append(this.categoryId)
         .toHashCode();
    }
    
}
