package com.itap.callcenter.controller.job;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itap.callcenter.beans.job.JobTicketBean;
import com.itap.callcenter.dao.apc.job.JobTicketDao;
import com.itap.callcenter.entity.apc.job.JobTicket;

/**
 * 
 * @author scotomax
 *
 */
@ViewScoped
@ManagedBean(name="jobTicketController")
public class JobTicketController extends JobTicketBean {

	private static final long serialVersionUID = -8491274520694340928L;

	// SLF4J logger
	Logger logger = LoggerFactory.getLogger(JobTicketController.class);
	
	// Job DAO
	@ManagedProperty(value="#{jobTicketDaoImpl}")
	JobTicketDao jobTicketDao;
	
	public void setJobTicketDao(JobTicketDao jobTicketDao) {
		this.jobTicketDao = jobTicketDao;
	}
	
	/**
	 * Search list of job ticket entity with criteria
	 */
	public void search() {
		logger.debug("Entering Job ticket searching method...");
		
		logger.debug("Look -> AgentProfile -> " + agentProfile);
		logger.debug("Look -> AgentLevel -> " + agentLevel);
		logger.debug("Look -> AgentSeat -> " + agentSeat);
		logger.debug("Look -> CrmCustomer -> " + customer);
		logger.debug("Look -> JobStatus -> " + status);
		logger.debug("Look -> JobName -> " + jobName);
		
		try {
			jobTicketList = jobTicketDao.findByCriteria(agentProfile, agentLevel, agentSeat, customer, status, jobName);
		} catch (Exception ex) {
			logger.error("Failed to search the data from database, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to search data from database, Cause: "+ex.getMessage()));
		}
	}
	
	/**
	 * Create job ticket entity data insert into database.
	 */
	public void create() {
		logger.debug("Entering Job ticket creation method...");
		
		logger.debug("Look -> AgentProfile -> " + agentProfile);
		logger.debug("Look -> AgentLevel -> " + agentLevel);
		logger.debug("Look -> AgentSeat -> " + agentSeat);
		logger.debug("Look -> CrmCustomer -> " + customer);
		logger.debug("Look -> JobStatus -> " + status);
		
		try {
			JobTicket entry = new JobTicket();
			
			entry.setJobId(jobId);
			entry.setJobName(jobName);
			entry.setJobDescription(jobDescription);
			entry.setJobVoiceRecordFile(jobVoiceRecordFile);
			entry.setJobAlertEnable(jobAlertEnable);
			
			entry.setJobCreateDate(new Date());
			entry.setJobUpdateDate(new Date());
			
			entry.setCustomer(customer);
			entry.setAgentProfile(agentProfile);
			entry.setAgentLevel(agentLevel);
			entry.setAgentSeat(agentSeat);
			entry.setSolution(solution);
			entry.setStatus(status);
			
			jobTicketDao.save(entry);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data been created successfully."));
		} catch (Exception ex) {
			logger.error("Failed to insert the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to insert the data into db, Cause: "+ex.getMessage()));
		}
	}
	
	/**
	 * Update job ticket entity data update into database.
	 */
	public void update() {
		logger.debug("Entering Job ticket update method...");
		
		logger.debug("Look -> AgentProfile -> " + agentProfile);
		logger.debug("Look -> AgentLevel -> " + agentLevel);
		logger.debug("Look -> AgentSeat -> " + agentSeat);
		logger.debug("Look -> CrmCustomer -> " + customer);
		logger.debug("Look -> JobStatus -> " + status);
		
		try {
			JobTicket entry = jobTicketDao.findById(jobId);
			
			entry.setJobName(jobName);
			entry.setJobDescription(jobDescription);
			entry.setJobVoiceRecordFile(jobVoiceRecordFile);
			entry.setJobAlertEnable(jobAlertEnable);
			
			entry.setJobUpdateDate(new Date());
			entry.setJobCloseDate(new Date());
			
			entry.setCustomer(customer);
			entry.setAgentProfile(agentProfile);
			entry.setAgentLevel(agentLevel);
			entry.setAgentSeat(agentSeat);
			entry.setSolution(solution);
			entry.setStatus(status);
			
			jobTicketDao.update(entry);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data been updated successfully."));
		} catch (Exception ex) {
			logger.error("Failed to update the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to update the data into db, Cause: "+ex.getMessage()));
		}
	}
	
	/**
	 * Fetch job ticket entity data from database.
	 */
	public void edit() {
		logger.debug("Entering Job ticket edit method...");
		if ( selectedJobId == null || selectedJobId.intValue() == -1 ) {
			
			jobId = null;
			jobName = null;
			jobDescription = null;
			jobVoiceRecordFile = null;
			jobAlertEnable = null;

			jobCreateDate = null;
			jobUpdateDate = null;
			jobCloseDate = null;
			
			customer = null;
			agentProfile = null;
			agentSeat = null;
			agentLevel = null;
			solution = null;
			status = null;
			
		} else {
			try {
				JobTicket entry = jobTicketDao.findById(selectedJobId);
				
				jobId = entry.getJobId();
				jobName = entry.getJobName();
				jobDescription = entry.getJobDescription();
				jobVoiceRecordFile = entry.getJobVoiceRecordFile();
				jobAlertEnable = entry.getJobAlertEnable();
			
				jobCreateDate = entry.getJobCreateDate();
				jobUpdateDate = entry.getJobUpdateDate();
				jobCloseDate = entry.getJobCloseDate();
				
				customer = entry.getCustomer();
				agentProfile = entry.getAgentProfile();
				agentSeat = entry.getAgentSeat();
				agentLevel = entry.getAgentLevel();
				solution = entry.getSolution();
				status = entry.getStatus();
				
				selectedJobId = -1;
			} catch (Exception ex) {
				logger.error("Failed to fetch the element data from db, Cause: "+ex.getMessage(), ex);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to fetch the element data from db, Cause: "+ex.getMessage()));
			}
		}
	}
	
	/**
	 * Delete job ticket entity data from database.
	 */
	public void delete() {
		logger.debug("Entering Job ticket delete method...");
		try {
			if ( selectedJobId != null ) {
				jobTicketDao.deleteById(selectedJobId);
				selectedJobId = -1;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data been deleted successfully."));
			}
		} catch (Exception ex) {
			logger.error("Failed to delete the data, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to delete the data, Cause: "+ex.getMessage()));
		}
	}
	
}
