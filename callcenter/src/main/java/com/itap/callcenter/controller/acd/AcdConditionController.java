package com.itap.callcenter.controller.acd;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itap.callcenter.beans.acd.AcdConditionBean;
import com.itap.callcenter.dao.apc.acd.AcdConditionDao;
import com.itap.callcenter.entity.apc.acd.AcdCondition;

/**
 * 
 * @author scotomax
 *
 */
@ViewScoped
@ManagedBean(name = "acdConditionController")
public class AcdConditionController extends AcdConditionBean {

	private static final long serialVersionUID = -5747243975153007636L;
	
	// SLF4J logger
	Logger logger = LoggerFactory.getLogger(AcdConditionController.class);
	
	// AcdCondition DAO
	@ManagedProperty(value="#{acdConditionDaoImpl}")
	AcdConditionDao acdConditionDao;

	public void setAcdConditionDao(AcdConditionDao acdConditionDao) {
		this.acdConditionDao = acdConditionDao;
	}
	
	/**
	 * Create Acd condition entity data insert into database.
	 */
	public void create() {
		logger.debug("Entering Acd condition creation method...");
		try {
			AcdCondition entry = new AcdCondition();
			entry.setConditionId(conditionId);
			entry.setConditionName(conditionName);
			entry.setConditionDescription(conditionDescription);
			entry.setConditionUpdateDate(new Date());
			acdConditionDao.save(entry);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The data been created successfully.", "Information"));
		} catch (Exception ex) {
			logger.error("Failed to insert the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to insert the data into db, Cause: "+ex.getMessage(), "Information"));
		}
	}
	
	/**
	 * Update Acd condition entity data update into database.
	 */
	public void update() {
		logger.debug("Entering Acd condition update method...");
		try {
			AcdCondition entry = new AcdCondition();
			entry.setConditionId(conditionId);
			entry.setConditionName(conditionName);
			entry.setConditionDescription(conditionDescription);
			entry.setConditionUpdateDate(new Date());
			acdConditionDao.update(entry);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The data been updated successfully.", "Information"));
		} catch (Exception ex) {
			logger.error("Failed to update the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to update the data into db, Cause: "+ex.getMessage(), "Information"));
		}
	}
	
	/**
	 * Fetch Acd condition entity data from database.
	 */
	public void edit() {
		logger.debug("Entering Acd condition edit method...");
		if ( selectedConditionId == null || selectedConditionId.intValue() == -1 ) {
			conditionId = null;
			conditionName = null;
			conditionDescription = null;
			conditionUpdateDate = null;
		} else {
			try {
				AcdCondition entry = acdConditionDao.findById(selectedConditionId);
				conditionId = entry.getConditionId();
				conditionName = entry.getConditionName();
				conditionDescription = entry.getConditionDescription();
				conditionUpdateDate = entry.getConditionUpdateDate();
				selectedConditionId = -1;
			} catch (Exception ex) {
				logger.error("Failed to fetch the element data from db, Cause: "+ex.getMessage(), ex);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to fetch the element data from db, Cause: "+ex.getMessage(), "Information"));
			}
		}
	}
	
	/**
	 * Delete Acd condition entity data from database.
	 */
	public void delete() {
		logger.debug("Entering Acd condition delete method...");
		try {
			if ( selectedConditionId != null ) {
				acdConditionDao.deleteById(selectedConditionId);
				selectedConditionId = -1;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,  "The data been deleted successfully.", "Information"));
			}
		} catch (Exception ex) {
			logger.error("Failed to delete the data, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to delete the data, Cause: "+ex.getMessage(), "Information"));
		}
	}
	
	/**
	 * Fetch list of all Acd condition entity data from database.
	 */
	public List<AcdCondition> getAcdConditionList() {
		logger.debug("Entering Acd condition getting list of all entity method...");
		List<AcdCondition> rsList = null;
		try {
			rsList = acdConditionDao.findAll();
		} catch ( Exception ex ) {
			logger.error("Failed to load the data, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alert", "Failed to load the data, Cause: "+ex.getMessage()));
		}
		return rsList;
	}
}
