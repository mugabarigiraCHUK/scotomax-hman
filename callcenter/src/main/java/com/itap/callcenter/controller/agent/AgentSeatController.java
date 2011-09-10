package com.itap.callcenter.controller.agent;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itap.callcenter.beans.agent.AgentSeatBean;
import com.itap.callcenter.dao.apc.agent.AgentSeatDao;
import com.itap.callcenter.entity.apc.agent.AgentSeat;

/**
 * 
 * @author scotomax
 *
 */
@ViewScoped
@ManagedBean(name="agentSeatController")
public class AgentSeatController extends AgentSeatBean {

	private static final long serialVersionUID = 8086353324066845351L;

	// SLF4J logger
	Logger logger = LoggerFactory.getLogger(AgentSeatController.class);
	
	// Agent Seat DAO
	@ManagedProperty(value="#{agentSeatDaoImpl}")
	AgentSeatDao agentSeatDao;

	public void setAgentSeatDao(AgentSeatDao agentSeatDao) {
		this.agentSeatDao = agentSeatDao;
	}
	
	/**
	 * Searching Agent seat entity data by criteria from database.
	 */
	public List<AgentSeat> getAgentSeats() {
		logger.debug("Entering Agent seat searching method...");
		List<AgentSeat> agentSeats = new ArrayList<AgentSeat>();
		try {
			agentSeats = agentSeatDao.findAll();
			if (agentSeats != null && agentSeats.size() > 0) {
				numberOfRow = (( agentSeats.size() + ( numberOfColumn - 1 ) ) / numberOfColumn );
			}
		} catch ( Exception ex ) {
			logger.error("Failed to fetching the data from db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to fetching the data from db, Cause: "+ex.getMessage(), "Information"));
		}
		return agentSeats;
	}
	
	/**
	 * Create Agent seat entity data insert into database.
	 */
	public void create() {
		logger.debug("Entering Agent seat creation method...");
		
		logger.debug("Look -> AgentSkill -> " + agentSkill);
		logger.debug("Look -> AgentLevel -> " + agentLevel);
		logger.debug("Look -> AgentStatus -> " + agentStatus);
		
		try {
			
			AgentSeat entry = new AgentSeat();
			entry.setSeatId(seatId);
			entry.setSeatName(seatName);
			entry.setSeatDescription(seatDescription);
			entry.setSeatStartPeriod(seatStartPeriod);
			entry.setSeatEndPeriod(seatEndPeriod);
			entry.setSeatMaxCall(seatMaxCall);
			entry.setSeatAllowOutbound(seatAllowOutbound);
			entry.setSeatCreateDate(new Date());
			entry.setSeatUpdateDate(new Date());
			
			entry.setAgentSkill(agentSkill);
			entry.setAgentLevel(agentLevel);
			entry.setAgentStatus(agentStatus);
			
			agentSeatDao.save(entry);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The data been created successfully.", "Information"));
		
		} catch (Exception ex) {
			logger.error("Failed to insert the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to insert the data into db, Cause: "+ex.getMessage(), "Information"));
		}
	}
	
	/**
	 * Update Agent seat entity data update into database.
	 */
	public void update() {
		logger.debug("Entering Agent seat update method...");
		
		logger.debug("Look -> AgentSkill -> " + agentSkill);
		logger.debug("Look -> AgentLevel -> " + agentLevel);
		logger.debug("Look -> AgentStatus -> " + agentStatus);
		
		try {
			AgentSeat entry = agentSeatDao.findById(seatId);
			entry.setSeatName(seatName);
			entry.setSeatDescription(seatDescription);
			entry.setSeatStartPeriod(seatStartPeriod);
			entry.setSeatEndPeriod(seatEndPeriod);
			entry.setSeatMaxCall(seatMaxCall);
			entry.setSeatAllowOutbound(seatAllowOutbound);
			entry.setSeatUpdateDate(new Date());
			
			entry.setAgentSkill(agentSkill);
			entry.setAgentLevel(agentLevel);
			entry.setAgentStatus(agentStatus);
			
			agentSeatDao.update(entry);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The data been updated successfully.", "Information"));
		} catch (Exception ex) {
			logger.error("Failed to update the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to update the data into db, Cause: "+ex.getMessage(), "Information"));
		}
	}
	
	/**
	 * Fetch Agent seat entity data from database.
	 */
	public void edit() {
		logger.debug("Entering Agent seat edit method...");
			
		if ( selectedSeatId == null || selectedSeatId.intValue() == -1 ) {
			
			seatId = null;
			seatName = null;
			seatDescription = null;
			seatStartPeriod = null;
			seatEndPeriod = null;
			seatMaxCall = null;
			seatAllowOutbound = null;
			seatCreateDate = null;
			seatUpdateDate =null;
			
			agentLevel = null;
			agentSkill = null;
			agentStatus = null;
				
		} else {
			try {
				AgentSeat entry = agentSeatDao.findById(selectedSeatId);
				
				seatId = entry.getSeatId();
				seatName = entry.getSeatName();
				seatDescription = entry.getSeatDescription();
				seatStartPeriod = entry.getSeatStartPeriod();
				seatEndPeriod = entry.getSeatEndPeriod();
				seatMaxCall = entry.getSeatMaxCall();
				seatAllowOutbound = entry.getSeatAllowOutbound();
				seatCreateDate = entry.getSeatCreateDate();
				seatUpdateDate =entry.getSeatUpdateDate();
				
				agentLevel = entry.getAgentLevel();
				agentSkill = entry.getAgentSkill();
				agentStatus = entry.getAgentStatus();
				
				selectedSeatId = -1;
			} catch (Exception ex) {
				logger.error("Failed to fetch the element data from db, Cause: "+ex.getMessage(), ex);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to fetch the element data from db, Cause: "+ex.getMessage(), "Information"));
			}
		}
	}
	
	/**
	 * Delete Agent seat entity data from database.
	 */
	public void delete() {
		logger.debug("Entering Agent seat delete method...");
		try {
			if ( selectedSeatId != null ) {
				agentSeatDao.deleteById(selectedSeatId);
				selectedSeatId = -1;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The data been deleted successfully.", "Information"));
			}
		} catch (Exception ex) {
			logger.error("Failed to delete the data, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to delete the data, Cause: "+ex.getMessage(), "Information"));
		}
	}
}
