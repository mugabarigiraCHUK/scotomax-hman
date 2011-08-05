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
@Table(name = "knw_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KnwCategory.findAll", query = "SELECT k FROM KnwCategory k"),
    @NamedQuery(name = "KnwCategory.findByCategoryId", query = "SELECT k FROM KnwCategory k WHERE k.categoryId = :categoryId"),
    @NamedQuery(name = "KnwCategory.findByParentCategoryId", query = "SELECT k FROM KnwCategory k WHERE k.parentCategoryId = :parentCategoryId"),
    @NamedQuery(name = "KnwCategory.findByCategoryName", query = "SELECT k FROM KnwCategory k WHERE k.categoryName = :categoryName"),
    @NamedQuery(name = "KnwCategory.findByCategoryDescription", query = "SELECT k FROM KnwCategory k WHERE k.categoryDescription = :categoryDescription"),
    @NamedQuery(name = "KnwCategory.findByCategoryCreateDate", query = "SELECT k FROM KnwCategory k WHERE k.categoryCreateDate = :categoryCreateDate"),
    @NamedQuery(name = "KnwCategory.findByCategoryUpdateDate", query = "SELECT k FROM KnwCategory k WHERE k.categoryUpdateDate = :categoryUpdateDate")})
public class KnwCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "category_id")
    private Integer categoryId;
    @Basic(optional = false)
    @Column(name = "parent_category_id")
    private int parentCategoryId;
    @Basic(optional = false)
    @Column(name = "category_name")
    private String categoryName;
    @Column(name = "category_description")
    private String categoryDescription;
    @Basic(optional = false)
    @Column(name = "category_create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date categoryCreateDate;
    @Basic(optional = false)
    @Column(name = "category_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date categoryUpdateDate;

    public KnwCategory() {
    }

    public KnwCategory(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public KnwCategory(Integer categoryId, int parentCategoryId, String categoryName, Date categoryCreateDate, Date categoryUpdateDate) {
        this.categoryId = categoryId;
        this.parentCategoryId = parentCategoryId;
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

    public int getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(int parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
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
    public int hashCode() {
        int hash = 0;
        hash += (categoryId != null ? categoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KnwCategory)) {
            return false;
        }
        KnwCategory other = (KnwCategory) object;
        if ((this.categoryId == null && other.categoryId != null) || (this.categoryId != null && !this.categoryId.equals(other.categoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itap.callcenter.entity.apcontact.KnwCategory[ categoryId=" + categoryId + " ]";
    }
    
}
