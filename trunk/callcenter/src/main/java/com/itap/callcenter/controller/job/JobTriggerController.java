package com.itap.callcenter.controller.job;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itap.callcenter.beans.job.JobTriggerBean;
import com.itap.callcenter.dao.apc.job.JobTriggerDao;
import com.itap.callcenter.entity.apc.job.JobTrigger;

/**
 * 
 * @author scotomax
 *
 */
@ViewScoped
@ManagedBean(name="jobTriggerController")
public class JobTriggerController extends JobTriggerBean {

	private static final long serialVersionUID = -4135935510986080714L;
	// SLF4J Logger
	Logger logger = LoggerFactory.getLogger(JobTriggerController.class);
	// Job trigger DAO
	@ManagedProperty(value="#{jobTriggerDaoImpl}")
	JobTriggerDao jobTriggerDao;
	
	public void setJobTriggerDao(JobTriggerDao jobTriggerDao) {
		this.jobTriggerDao = jobTriggerDao;
	}
	
	/**
	 * Create job trigger entity data insert into database.
	 */
	public void create() {
		logger.debug("Entering Job trigger creation method...");
		try {
			JobTrigger entry = new JobTrigger();
			entry.setTriggerId(triggerId);
			entry.setTriggerName(triggerName);
			entry.setTriggerDescription(triggerDescription);
			entry.setTriggerCommand(triggerCommand);
			entry.setTriggerCreateDate(new Date());
			entry.setTriggerUpdateDate(new Date());
			jobTriggerDao.save(entry);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data been created successfully."));
		} catch (Exception ex) {
			logger.error("Failed to insert the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to insert the data into db, Cause: "+ex.getMessage()));
		}
	}
	
	/**
	 * Update job trigger entity data update into database.
	 */
	public void update() {
		logger.debug("Entering Job trigger update method...");
		try {
			JobTrigger entry = jobTriggerDao.findById(triggerId);
			entry.setTriggerName(triggerName);
			entry.setTriggerDescription(triggerDescription);
			entry.setTriggerCommand(triggerCommand);
			entry.setTriggerUpdateDate(new Date());
			jobTriggerDao.update(entry);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data been updated successfully."));
		} catch (Exception ex) {
			logger.error("Failed to update the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to update the data into db, Cause: "+ex.getMessage()));
		}
	}
	
	/**
	 * Fetch job trigger entity data from database.
	 */
	public void edit() {
		logger.debug("Entering Job trigger edit method...");
		if ( selectedTriggerId == null || selectedTriggerId.intValue() == -1 ) {
			triggerId = null;
			triggerName = null;
			triggerDescription = null;
			triggerCommand = null;
			triggerCreateDate = null;
			triggerUpdateDate = null;
		} else {
			try {
				JobTrigger entry = jobTriggerDao.findById(selectedTriggerId);
				triggerId = entry.getTriggerId();
				triggerName = entry.getTriggerName();
				triggerDescription = entry.getTriggerDescription();
				triggerCommand = entry.getTriggerCommand();
				triggerCreateDate = entry.getTriggerCreateDate();
				triggerUpdateDate = entry.getTriggerUpdateDate();
				selectedTriggerId = -1;
			} catch (Exception ex) {
				logger.error("Failed to fetch the element data from db, Cause: "+ex.getMessage(), ex);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to fetch the element data from db, Cause: "+ex.getMessage()));
			}
		}
	}
	
	/**
	 * Delete job trigger entity data from database.
	 */
	public void delete() {
		logger.debug("Entering Job trigger delete method...");
		try {
			if ( selectedTriggerId != null ) {
				jobTriggerDao.deleteById(selectedTriggerId);
				selectedTriggerId = -1;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data been deleted successfully."));
			}
		} catch (Exception ex) {
			logger.error("Failed to delete the data, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to delete the data, Cause: "+ex.getMessage()));
		}
	}
	
	/**
	 * Fetch list of all job trigger entity data from database.
	 */
	public List<JobTrigger> getJobTriggerList() {
		logger.debug("Entering Job trigger getting list of all entity method...");
		List<JobTrigger> rsList = null;
		try {
			rsList = jobTriggerDao.findAll();
		} catch ( Exception ex ) {
			logger.error("Failed to load the data, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to load the data, Cause: "+ex.getMessage()));
		}
		return rsList;
	}
}
