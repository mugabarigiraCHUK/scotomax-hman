package com.itap.callcenter.controller.crm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itap.callcenter.dao.apc.crm.CrmBusinessDao;
import com.itap.callcenter.dao.apc.crm.CrmCustomerDao;
import com.itap.callcenter.dao.apc.crm.CrmStatusDao;
import com.itap.callcenter.entity.apc.crm.CrmBusiness;
import com.itap.callcenter.entity.apc.crm.CrmCustomer;
import com.itap.callcenter.entity.apc.crm.CrmStatus;

/**
 * 
 * @author phamon
 *
 */
@ViewScoped
@ManagedBean(name = "crmCustomerController")
public class CrmCustomerController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Logger logger = LoggerFactory.getLogger(CrmCustomerController.class);
	
	@ManagedProperty(value="#{crmStatusDaoImpl}")
	private CrmStatusDao crmStatusDao;
	
	@ManagedProperty(value="#{crmBusinessDaoImpl}")
	private CrmBusinessDao crmBusinessDao;

	@ManagedProperty(value="#{crmCustomerDaoImpl}")
	private CrmCustomerDao crmCustomerDao;
	
	private List<SelectItem> listCrmStatus = new ArrayList<SelectItem>();
	private List<SelectItem> listCrmBusiness = new ArrayList<SelectItem>();
	
	private CrmCustomer inputCrmCustomer = new CrmCustomer();
	
	
	
	@PostConstruct
	private void factoryListItem() { 
		List<CrmStatus> resultCrmStatus = crmStatusDao.findAll();
		List<CrmBusiness> resultCrmBusinesses = crmBusinessDao.findAll();
		for (CrmStatus crmStatus : resultCrmStatus) {
			listCrmStatus.add(new SelectItem(crmStatus, crmStatus.getStatusName()));
		}
		for (CrmBusiness crmBusiness : resultCrmBusinesses) {
			listCrmBusiness.add(new SelectItem(crmBusiness, crmBusiness.getBusinessName()));
		}
	}
	
	
	public void prepareCreate() {
		logger.debug("prepare input field before you insert");
		inputCrmCustomer = new CrmCustomer();
		
	}
	public void prepareUpdate() {
		logger.debug("prepare input field before you update");
		logger.debug("customerId; " + inputCrmCustomer.getCustomerId());
		CrmCustomer crmCustomer = crmCustomerDao.findById(inputCrmCustomer.getCustomerId());
		inputCrmCustomer.setBusiness(crmCustomer.getBusiness());
		inputCrmCustomer.setStatus(crmCustomer.getStatus());
		inputCrmCustomer.setCustomerFullname(crmCustomer.getCustomerFullname());
		inputCrmCustomer.setCustomerGender(crmCustomer.getCustomerGender());
		inputCrmCustomer.setCustomerAddress(crmCustomer.getCustomerAddress());
		inputCrmCustomer.setCustomerBirthday(crmCustomer.getCustomerBirthday());
		inputCrmCustomer.setCustomerPhone(crmCustomer.getCustomerPhone());
		inputCrmCustomer.setCustomerEmail(crmCustomer.getCustomerEmail());
		inputCrmCustomer.setCustomerCreateDate(crmCustomer.getCustomerUpdateDate());
	}
	
	public void create() {
		logger.debug("process create");
		logger.debug("customerFullname: " + inputCrmCustomer.getCustomerFullname());
		try {
			CrmCustomer crmCustomer = new CrmCustomer();
			crmCustomer.setCustomerFullname(inputCrmCustomer.getCustomerFullname());
			crmCustomer.setBusiness(inputCrmCustomer.getBusiness());
			crmCustomer.setStatus(inputCrmCustomer.getStatus());
			crmCustomer.setCustomerGender(inputCrmCustomer.getCustomerGender());
			crmCustomer.setCustomerAddress(inputCrmCustomer.getCustomerAddress());
			crmCustomer.setCustomerBirthday(inputCrmCustomer.getCustomerBirthday());
			crmCustomer.setCustomerPhone(inputCrmCustomer.getCustomerPhone());
			crmCustomer.setCustomerEmail(inputCrmCustomer.getCustomerEmail());
			crmCustomer.setCustomerCreateDate(new Date());
			crmCustomerDao.save(crmCustomer);
			inputCrmCustomer = new CrmCustomer();
			logger.debug("The data have been created successfully.");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data have been created successfully."));
		} catch (Exception ex) {
			logger.error("Failed to insert the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "The data cannot create", "Failed to insert the data into db, Cause: "+ex.getMessage()));
		}
	}
	public void update() {
		logger.debug("process update");
		logger.debug("customerId: " + inputCrmCustomer.getCustomerId());
		try {
			crmCustomerDao.update(inputCrmCustomer);
			inputCrmCustomer = new CrmCustomer();
			logger.debug("The data have been updated successfully.");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data have been updated successfully."));
		} catch (Exception ex) {
			logger.error("Failed to insert the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "The data cannot update", "Failed to insert the data into db, Cause: "+ex.getMessage()));
		}
	}
	public void delete() {
		logger.debug("delete ivr schedule");
		logger.debug("customerId: " + inputCrmCustomer.getCustomerId());
		try {
			crmCustomerDao.deleteById(inputCrmCustomer.getCustomerId());
			inputCrmCustomer = new CrmCustomer();
			logger.debug("The data have been deleted successfully.");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data have been deleted successfully."));
		} catch (Exception ex) {
			logger.error("Failed to delete the data, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "The data cannot delete", "Failed to delete the data, Cause: "+ex.getMessage()));
		}
	}
	
	public List<CrmCustomer> getListCrmCustomer() {
		return crmCustomerDao.findAll();
	}

	
	
	// Getter & Setter
	public CrmStatusDao getCrmStatusDao() {
		return crmStatusDao;
	}
	public void setCrmStatusDao(CrmStatusDao crmStatusDao) {
		this.crmStatusDao = crmStatusDao;
	}
	public CrmBusinessDao getCrmBusinessDao() {
		return crmBusinessDao;
	}
	public void setCrmBusinessDao(CrmBusinessDao crmBusinessDao) {
		this.crmBusinessDao = crmBusinessDao;
	}
	public CrmCustomerDao getCrmCustomerDao() {
		return crmCustomerDao;
	}
	public void setCrmCustomerDao(CrmCustomerDao crmCustomerDao) {
		this.crmCustomerDao = crmCustomerDao;
	}
	public List<SelectItem> getListCrmStatus() {
		return listCrmStatus;
	}
	public void setListCrmStatus(List<SelectItem> listCrmStatus) {
		this.listCrmStatus = listCrmStatus;
	}
	public List<SelectItem> getListCrmBusiness() {
		return listCrmBusiness;
	}
	public void setListCrmBusiness(List<SelectItem> listCrmBusiness) {
		this.listCrmBusiness = listCrmBusiness;
	}
	public CrmCustomer getInputCrmCustomer() {
		return inputCrmCustomer;
	}
	public void setInputCrmCustomer(CrmCustomer inputCrmCustomer) {
		this.inputCrmCustomer = inputCrmCustomer;
	}
	
}
