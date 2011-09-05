/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itap.callcenter.entity.apc.crm;

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
@Table(name = "crm_customer")
@XmlRootElement
public class CrmCustomer implements Serializable, DomainObject {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "customer_id", length = 11, nullable = false)
    @GeneratedValue
    @NotNull
    private Integer customerId;
    
    @ManyToOne
    @JoinColumn(name = "business_id", nullable = false)
    @NotNull
    private CrmBusiness business;
    
    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    @NotNull
    private CrmStatus status;
    
    @Column(name = "customer_fullname", length = 100, nullable = false)
    @NotNull
    private String customerFullname;
    
    @Column(name = "customer_gender", length = 11, nullable = false)
    @NotNull
    private Integer customerGender;
    
    @Column(name = "customer_address", length = 500, nullable = false)
    @NotNull
    private String customerAddress;
    
    @Column(name = "customer_birthday")
    @Temporal(TemporalType.TIMESTAMP)
    private Date customerBirthday;
    
    @Column(name = "customer_phone", length = 100, nullable = false)
    @NotNull
    private String customerPhone;
    
    @Column(name = "customer_email", length = 100, nullable = false)
    @NotNull
    private String customerEmail;
    
    @Column(name = "customer_create_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date customerCreateDate;
    
    @Column(name = "customer_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date customerUpdateDate;

    public CrmCustomer() {
    }

    public CrmCustomer(Integer customerId) {
        this.customerId = customerId;
    }

    public CrmCustomer(Integer customerId, CrmBusiness business, CrmStatus status, String customerFullname, Integer customerGender, Date customerCreateDate, Date customerUpdateDate) {
        this.customerId = customerId;
        this.business = business;
        this.status = status;
        this.customerFullname = customerFullname;
        this.customerGender = customerGender;
        this.customerCreateDate = customerCreateDate;
        this.customerUpdateDate = customerUpdateDate;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public CrmBusiness getBusiness() {
		return business;
	}

	public void setBusiness(CrmBusiness business) {
		this.business = business;
	}

	public CrmStatus getStatus() {
		return status;
	}

	public void setStatus(CrmStatus status) {
		this.status = status;
	}

	public String getCustomerFullname() {
        return customerFullname;
    }

    public void setCustomerFullname(String customerFullname) {
        this.customerFullname = customerFullname;
    }

    public Integer getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(Integer customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Date getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(Date customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Date getCustomerCreateDate() {
        return customerCreateDate;
    }

    public void setCustomerCreateDate(Date customerCreateDate) {
        this.customerCreateDate = customerCreateDate;
    }

    public Date getCustomerUpdateDate() {
        return customerUpdateDate;
    }

    public void setCustomerUpdateDate(Date customerUpdateDate) {
        this.customerUpdateDate = customerUpdateDate;
    }

    @Override
    public String toString() {
    	return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
		.append("customerId", customerId)
		.append("customerFullname", customerFullname)
		.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) { return false; }
        if (o == this) { return true; }
        if (o.getClass() != getClass()) {
            return false;
        }
         CrmCustomer other = (CrmCustomer) o;
        return new EqualsBuilder()
                 .append(customerId, other.customerId)
                 .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
         .append(this.customerId)
         .toHashCode();
    }
    
}
