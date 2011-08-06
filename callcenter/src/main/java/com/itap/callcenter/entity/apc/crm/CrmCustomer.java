/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itap.callcenter.entity.apc.crm;

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
@Table(name = "crm_customer")
@XmlRootElement
public class CrmCustomer implements Serializable, DomainObject {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "customer_id", length = 11, nullable = false)
    private Integer customerId;
    
    @Column(name = "business_id", length = 11, nullable = false)
    private int businessId;
    
    @Column(name = "status_id", length = 11, nullable = false)
    private int statusId;
    
    @Column(name = "customer_fullname", length = 100, nullable = false)
    private String customerFullname;
    
    @Column(name = "customer_gender", length = 11, nullable = false)
    private int customerGender;
    
    @Column(name = "customer_address", length = 500, nullable = false)
    private String customerAddress;
    
    @Column(name = "customer_birthday")
    @Temporal(TemporalType.TIMESTAMP)
    private Date customerBirthday;
    
    @Column(name = "customer_phone", length = 100, nullable = false)
    private String customerPhone;
    
    @Column(name = "customer_email", length = 100, nullable = false)
    private String customerEmail;
    
    @Column(name = "customer_create_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date customerCreateDate;
    
    @Column(name = "customer_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date customerUpdateDate;

    public CrmCustomer() {
    }

    public CrmCustomer(Integer customerId) {
        this.customerId = customerId;
    }

    public CrmCustomer(Integer customerId, int businessId, int statusId, String customerFullname, int customerGender, Date customerCreateDate, Date customerUpdateDate) {
        this.customerId = customerId;
        this.businessId = businessId;
        this.statusId = statusId;
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

    public int getBusinessId() {
        return businessId;
    }

    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getCustomerFullname() {
        return customerFullname;
    }

    public void setCustomerFullname(String customerFullname) {
        this.customerFullname = customerFullname;
    }

    public int getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(int customerGender) {
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
        return ToStringBuilder.reflectionToString(this);
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
