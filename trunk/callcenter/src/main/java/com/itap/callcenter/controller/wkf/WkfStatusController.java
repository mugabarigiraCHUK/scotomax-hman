package com.itap.callcenter.controller.wkf;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itap.callcenter.beans.wkf.WkfStatusBean;
import com.itap.callcenter.dao.apc.wkf.WkfStatusDao;
import com.itap.callcenter.entity.apc.wkf.WkfStatus;

/**
 * 
 * @author scotomax
 *
 */
@ViewScoped
@ManagedBean(name="wkfStatusController")
public class WkfStatusController extends WkfStatusBean {

	private static final long serialVersionUID = -3189185452114066113L;
	
	// SLF4J looger
	private static Logger logger = LoggerFactory.getLogger(WkfStatusController.class);

	// WKF status DAO
	@ManagedProperty(value = "#{wkfStatusDaoImpl}")
	WkfStatusDao wkfStatusDao;

	public void setWkfStatusDao(WkfStatusDao wkfStatusDao) {
		this.wkfStatusDao = wkfStatusDao;
	}
	
	/**
	 * Create WKF status entity data insert into database.
	 */
	public void create() {
		logger.debug("Entering WKF Status creation method...");
		try {
			WkfStatus entry = new WkfStatus();
			entry.setStatusId(statusId);
			entry.setStatusName(statusName);
			entry.setStatusDescription(statusDescription);
			entry.setStatusUpdateDate(new Date());
			wkfStatusDao.save(entry);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The data been created successfully.", "Information"));
		} catch (Exception ex) {
			logger.error("Failed to insert the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to insert the data into db, Cause: "+ex.getMessage(), "Information"));
		}
	}
	
	/**
	 * Update WKF status entity data update into database.
	 */
	public void update() {
		logger.debug("Entering WKF Status update method...");
		try {
			WkfStatus entry = new WkfStatus();
			entry.setStatusId(statusId);
			entry.setStatusName(statusName);
			entry.setStatusDescription(statusDescription);
			entry.setStatusUpdateDate(new Date());
			wkfStatusDao.update(entry);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The data been updated successfully.", "Information"));
		} catch (Exception ex) {
			logger.error("Failed to update the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to update the data into db, Cause: "+ex.getMessage(), "Information"));
		}
	}
	
	/**
	 * Fetch WKF status entity data from database.
	 */
	public void edit() {
		logger.debug("Entering WKF Status edit method...");
		if ( selectedStatusId == null || selectedStatusId.intValue() == -1 ) {
			statusId = null;
			statusName = null;
			statusDescription = null;
			statusUpdateDate = null;
		} else {
			try {
				WkfStatus entry = wkfStatusDao.findById(selectedStatusId);
				statusId = entry.getStatusId();
				statusName = entry.getStatusName();
				statusDescription = entry.getStatusDescription();
				statusUpdateDate = entry.getStatusUpdateDate();
				selectedStatusId = -1;
			} catch (Exception ex) {
				logger.error("Failed to fetch the element data from db, Cause: "+ex.getMessage(), ex);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to fetch the element data from db, Cause: "+ex.getMessage(), "Information"));
			}
		}
	}
	
	/**
	 * Delete WKF status entity data from database.
	 */
	public void delete() {
		logger.debug("Entering WKF Status delete method...");
		try {
			if ( selectedStatusId != null ) {
				wkfStatusDao.deleteById(selectedStatusId);
				selectedStatusId = -1;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The data been deleted successfully.", "Information"));
			}
		} catch (Exception ex) {
			logger.error("Failed to delete the data, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to delete the data, Cause: "+ex.getMessage(), "Information"));
		}
	}
	
	/**
	 * Fetch list of all WKF status entity data from database.
	 */
	public List<WkfStatus> getWkfStatusList() {
		logger.debug("Entering WKF Status getting list of all entity method...");
		List<WkfStatus> rsList = null;
		try {
			rsList = wkfStatusDao.findAll();
		} catch ( Exception ex ) {
			logger.error("Failed to load the data, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to load the data, Cause: "+ex.getMessage(), "Information"));
		}
		return rsList;
	}
}
