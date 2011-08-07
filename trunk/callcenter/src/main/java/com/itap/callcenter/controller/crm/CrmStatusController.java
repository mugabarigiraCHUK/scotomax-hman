package com.itap.callcenter.controller.crm;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itap.callcenter.beans.crm.CrmStatusBean;
import com.itap.callcenter.dao.apc.crm.CrmStatusDao;
import com.itap.callcenter.entity.apc.crm.CrmStatus;

/**
 * 
 * @author scotomax
 *
 */
@ViewScoped
@ManagedBean(name="crmStatusController")
public class CrmStatusController extends CrmStatusBean {

	private static final long serialVersionUID = -4256898712824250299L;

	// SLF4J Logger
	private static Logger logger = LoggerFactory.getLogger(CrmStatusController.class);
	
	// CRM status DAO
	@ManagedProperty(value = "#{crmStatusDaoImpl}")
	CrmStatusDao crmStatusDao;

	public void setCrmStatusDao(CrmStatusDao crmStatusDao) {
		this.crmStatusDao = crmStatusDao;
	}
	
	/**
	 * Create CRM status entity data insert into database.
	 */
	public void create() {
		logger.debug("Entering CRM Status creation method...");
		try {
			CrmStatus entry = new CrmStatus();
			entry.setStatusName(statusName);
			entry.setStatusDescription(statusDescription);
			entry.setStatusUpdateDate(new Date());
			crmStatusDao.save(entry);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data been created successfully."));
		} catch (Exception ex) {
			logger.error("Failed to insert the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to insert the data into db, Cause: "+ex.getMessage()));
		}
	}
	
	/**
	 * Update CRM status entity data update into database.
	 */
	public void update() {
		logger.debug("Entering CRM Status update method...");
		try {
			CrmStatus entry = new CrmStatus();
			entry.setStatusId(statusId);
			entry.setStatusName(statusName);
			entry.setStatusDescription(statusDescription);
			entry.setStatusUpdateDate(new Date());
			crmStatusDao.update(entry);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data been updated successfully."));
		} catch (Exception ex) {
			logger.error("Failed to update the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to update the data into db, Cause: "+ex.getMessage()));
		}
	}
	
	/**
	 * Fetch CRM status entity data from database.
	 */
	public void edit() {
		logger.debug("Entering CRM Status edit method...");
		if ( selectedStatusId == null || selectedStatusId.intValue() == -1 ) {
			statusId = null;
			statusName = null;
			statusDescription = null;
			statusUpdateDate = null;
		} else {
			try {
				CrmStatus entry = crmStatusDao.findById(selectedStatusId);
				statusId = entry.getStatusId();
				statusName = entry.getStatusName();
				statusDescription = entry.getStatusDescription();
				statusUpdateDate = entry.getStatusUpdateDate();
				selectedStatusId = -1;
			} catch (Exception ex) {
				logger.error("Failed to fetch the element data from db, Cause: "+ex.getMessage(), ex);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to fetch the element data from db, Cause: "+ex.getMessage()));
			}
		}
	}
	
	/**
	 * Delete CRM status entity data from database.
	 */
	public void delete() {
		logger.debug("Entering CRM Status delete method...");
		try {
			if ( selectedStatusId != null ) {
				crmStatusDao.deleteById(selectedStatusId);
				selectedStatusId = -1;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data been deleted successfully."));
			}
		} catch (Exception ex) {
			logger.error("Failed to delete the data, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to delete the data, Cause: "+ex.getMessage()));
		}
	}
	
	/**
	 * Fetch list of all CRM status entity data from database.
	 */
	public List<CrmStatus> getCrmStatusList() {
		logger.debug("Entering CRM Status getting list of all entity method...");
		List<CrmStatus> rsList = null;
		try {
			rsList = crmStatusDao.findAll();
		} catch ( Exception ex ) {
			logger.error("Failed to load the data, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to load the data, Cause: "+ex.getMessage()));
		}
		return rsList;
	}
}
