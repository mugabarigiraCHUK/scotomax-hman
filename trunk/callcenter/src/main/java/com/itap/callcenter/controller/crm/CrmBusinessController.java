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

import com.itap.callcenter.beans.crm.CrmBusinessBean;
import com.itap.callcenter.dao.apc.crm.CrmBusinessDao;
import com.itap.callcenter.entity.apc.crm.CrmBusiness;

/**
 * 
 * @author scotomax
 *
 */
@ViewScoped
@ManagedBean(name="crmBusinessController")
public class CrmBusinessController extends CrmBusinessBean {

	private static final long serialVersionUID = 7603184623449749284L;
	// SLF4J logger
	Logger logger = LoggerFactory.getLogger(CrmBusinessController.class);
	// CRM Business DAO
	@ManagedProperty(value="#{crmBusinessDaoImpl}")
	CrmBusinessDao crmBusinessDao;
	
	public void setCrmBusinessDao(CrmBusinessDao crmBusinessDao) {
		this.crmBusinessDao = crmBusinessDao;
	}
	
	/**
	 * Create CRM business entity data insert into database.
	 */
	public void create() {
		logger.debug("Entering CRM Business creation method...");
		try {
			CrmBusiness entry = new CrmBusiness();
			entry.setBusinessId(businessId);
			entry.setBusinessName(businessName);
			entry.setBusinessDescription(businessDescription);
			entry.setBusinessUpdateDate(new Date());
			crmBusinessDao.save(entry);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data been created successfully."));
		} catch (Exception ex) {
			logger.error("Failed to insert the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to insert the data into db, Cause: "+ex.getMessage()));
		}
	}
	
	/**
	 * Update CRM business entity data update into database.
	 */
	public void update() {
		logger.debug("Entering CRM Business update method...");
		try {
			CrmBusiness entry = new CrmBusiness();
			entry.setBusinessId(businessId);
			entry.setBusinessName(businessName);
			entry.setBusinessDescription(businessDescription);
			entry.setBusinessUpdateDate(new Date());
			crmBusinessDao.update(entry);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data been updated successfully."));
		} catch (Exception ex) {
			logger.error("Failed to update the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to update the data into db, Cause: "+ex.getMessage()));
		}
	}
	
	/**
	 * Fetch CRM business entity data from database.
	 */
	public void edit() {
		logger.debug("Entering CRM Business edit method...");
		if ( selectedBusinessId == null || selectedBusinessId.intValue() == -1 ) {
			businessId = null;
			businessName = null;
			businessDescription = null;
			businessUpdateDate = null;
		} else {
			try {
				CrmBusiness entry = crmBusinessDao.findById(selectedBusinessId);
				businessId = entry.getBusinessId();
				businessName = entry.getBusinessName();
				businessDescription = entry.getBusinessDescription();
				businessUpdateDate = entry.getBusinessUpdateDate();
				selectedBusinessId = -1;
			} catch (Exception ex) {
				logger.error("Failed to fetch the element data from db, Cause: "+ex.getMessage(), ex);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to fetch the element data from db, Cause: "+ex.getMessage()));
			}
		}
	}
	
	/**
	 * Delete CRM business entity data from database.
	 */
	public void delete() {
		logger.debug("Entering CRM Business delete method...");
		try {
			if ( selectedBusinessId != null ) {
				crmBusinessDao.deleteById(selectedBusinessId);
				selectedBusinessId = -1;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data been deleted successfully."));
			}
		} catch (Exception ex) {
			logger.error("Failed to delete the data, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to delete the data, Cause: "+ex.getMessage()));
		}
	}
	
	/**
	 * Fetch list of all CRM business entity data from database.
	 */
	public List<CrmBusiness> getCrmBusinessList() {
		logger.debug("Entering CRM Business getting list of all entity method...");
		List<CrmBusiness> rsList = null;
		try {
			rsList = crmBusinessDao.findAll();
		} catch ( Exception ex ) {
			logger.error("Failed to load the data, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to load the data, Cause: "+ex.getMessage()));
		}
		return rsList;
	}
}
