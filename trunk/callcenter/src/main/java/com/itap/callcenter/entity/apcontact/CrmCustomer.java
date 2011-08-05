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
@Table(name = "crm_customer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CrmCustomer.findAll", query = "SELECT c FROM CrmCustomer c"),
    @NamedQuery(name = "CrmCustomer.findByCustomerId", query = "SELECT c FROM CrmCustomer c WHERE c.customerId = :customerId"),
    @NamedQuery(name = "CrmCustomer.findByBusinessId", query = "SELECT c FROM CrmCustomer c WHERE c.businessId = :businessId"),
    @NamedQuery(name = "CrmCustomer.findByStatusId", query = "SELECT c FROM CrmCustomer c WHERE c.statusId = :statusId"),
    @NamedQuery(name = "CrmCustomer.findByCustomerFullname", query = "SELECT c FROM CrmCustomer c WHERE c.customerFullname = :customerFullname"),
    @NamedQuery(name = "CrmCustomer.findByCustomerGender", query = "SELECT c FROM CrmCustomer c WHERE c.customerGender = :customerGender"),
    @NamedQuery(name = "CrmCustomer.findByCustomerAddress", query = "SELECT c FROM CrmCustomer c WHERE c.customerAddress = :customerAddress"),
    @NamedQuery(name = "CrmCustomer.findByCustomerBirthday", query = "SELECT c FROM CrmCustomer c WHERE c.customerBirthday = :customerBirthday"),
    @NamedQuery(name = "CrmCustomer.findByCustomerPhone", query = "SELECT c FROM CrmCustomer c WHERE c.customerPhone = :customerPhone"),
    @NamedQuery(name = "CrmCustomer.findByCustomerEmail", query = "SELECT c FROM CrmCustomer c WHERE c.customerEmail = :customerEmail"),
    @NamedQuery(name = "CrmCustomer.findByCustomerCreateDate", query = "SELECT c FROM CrmCustomer c WHERE c.customerCreateDate = :customerCreateDate"),
    @NamedQuery(name = "CrmCustomer.findByCustomerUpdateDate", query = "SELECT c FROM CrmCustomer c WHERE c.customerUpdateDate = :customerUpdateDate")})
public class CrmCustomer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "customer_id")
    private Integer customerId;
    @Basic(optional = false)
    @Column(name = "business_id")
    private int businessId;
    @Basic(optional = false)
    @Column(name = "status_id")
    private int statusId;
    @Basic(optional = false)
    @Column(name = "customer_fullname")
    private String customerFullname;
    @Basic(optional = false)
    @Column(name = "customer_gender")
    private int customerGender;
    @Column(name = "customer_address")
    private String customerAddress;
    @Column(name = "customer_birthday")
    @Temporal(TemporalType.TIMESTAMP)
    private Date customerBirthday;
    @Column(name = "customer_phone")
    private String customerPhone;
    @Column(name = "customer_email")
    private String customerEmail;
    @Basic(optional = false)
    @Column(name = "customer_create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date customerCreateDate;
    @Basic(optional = false)
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
    public int hashCode() {
        int hash = 0;
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CrmCustomer)) {
            return false;
        }
        CrmCustomer other = (CrmCustomer) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itap.callcenter.entity.apcontact.CrmCustomer[ customerId=" + customerId + " ]";
    }
    
}
