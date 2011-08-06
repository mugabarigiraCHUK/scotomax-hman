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

import com.itap.callcenter.beans.job.JobStatusBean;
import com.itap.callcenter.dao.apc.job.JobStatusDao;
import com.itap.callcenter.entity.apc.job.JobStatus;
import com.itap.callcenter.utile.Utils;

/**
 * 
 * @author scotomax
 *
 */
@ViewScoped
@ManagedBean(name = "jobStatusController")
public class JobStatusContoller extends JobStatusBean {

	static final long serialVersionUID = 5677112565939288621L;
	
	Logger logger = LoggerFactory.getLogger(JobStatusContoller.class);
	
	@ManagedProperty(value = "#{jobStatusDaoImpl}")
	JobStatusDao jobStatusDao;
	
	public void setJobStatusDao(JobStatusDao jobStatusDao) {
		this.jobStatusDao = jobStatusDao;
	}

	final FacesContext facesMessage = FacesContext.getCurrentInstance();

	/**
	 * Create job status entity data insert into database.
	 */
	public void create() {
		logger.debug("Entering Job Status creation method...");
		try {
			if ( Utils.isEmpty(statusName) ) {
				logger.warn("Job status name could not empty");
				facesMessage.addMessage(null, new FacesMessage("Job status name could not empty"));
			} else {
				JobStatus entry = new JobStatus();
				entry.setStatusName(statusName);
				entry.setStatusDescription(statusDescription);
				entry.setStatusUpdateDate(new Date());
				jobStatusDao.save(entry);
				facesMessage.addMessage(null, new FacesMessage("The data been created successfully."));
			}
		} catch (Exception ex) {
			logger.error("Failed to insert the data into db, Cause: "+ex.getMessage(), ex);
			facesMessage.addMessage(null, new FacesMessage("Failed to insert the data into db, Cause: "+ex.getMessage()));
		}
	}
	
	/**
	 * Update job status entity data update into database.
	 */
	public void update() {
		logger.debug("Entering Job Status update method...");
		try {
			JobStatus entry = new JobStatus();
			entry.setStatusId(statusId);
			entry.setStatusName(statusName);
			entry.setStatusDescription(statusDescription);
			entry.setStatusUpdateDate(new Date());
			jobStatusDao.update(entry);
			facesMessage.addMessage(null, new FacesMessage("The data been updated successfully."));
		} catch (Exception ex) {
			logger.error("Failed to update the data into db, Cause: "+ex.getMessage(), ex);
			facesMessage.addMessage(null, new FacesMessage("Failed to update the data into db, Cause: "+ex.getMessage()));
		}
	}
	
	/**
	 * Fetch job status entity data from database.
	 */
	public void edit() {
		logger.debug("Entering Job Status edit method...");
		if ( selectedStatusId == null || selectedStatusId.intValue() == -1 ) {
			statusId = null;
			statusName = null;
			statusDescription = null;
			statusUpdateDate = null;
		} else {
			try {
				JobStatus entry = jobStatusDao.findById(selectedStatusId);
				statusId = entry.getStatusId();
				statusName = entry.getStatusName();
				statusDescription = entry.getStatusDescription();
				statusUpdateDate = entry.getStatusUpdateDate();
				selectedStatusId = -1;
			} catch (Exception ex) {
				logger.error("Failed to fetch the element data from db, Cause: "+ex.getMessage(), ex);
				facesMessage.addMessage(null, new FacesMessage("Failed to fetch the element data from db, Cause: "+ex.getMessage()));
			}
		}
		
	}
	
	/**
	 * Delete job status entity data from database.
	 */
	public void delete() {
		logger.debug("Entering Job Status delete method...");
		try {
			if ( selectedStatusId != null ) {
				jobStatusDao.deleteById(selectedStatusId);
				selectedStatusId = -1;
				facesMessage.addMessage(null, new FacesMessage("The data been deleted successfully."));
			}
		} catch (Exception ex) {
			logger.error("Failed to delete the data, Cause: "+ex.getMessage(), ex);
			facesMessage.addMessage(null, new FacesMessage("Failed to delete the data, Cause: "+ex.getMessage()));
		}
	}
	
	/**
	 * Fetch list of all job status entity data from database.
	 */
	public List<JobStatus> getJobStatusList() {
		logger.debug("Entering Job Status getting list of all entity method...");
		List<JobStatus> rsList = null;
		try {
			rsList = jobStatusDao.findAll();
		} catch ( Exception ex ) {
			logger.error("Failed to load the data, Cause: "+ex.getMessage(), ex);
			facesMessage.addMessage(null, new FacesMessage("Failed to load the data, Cause: "+ex.getMessage()));
		}
		return rsList;
	}
}
