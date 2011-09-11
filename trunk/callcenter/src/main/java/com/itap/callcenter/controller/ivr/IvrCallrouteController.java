package com.itap.callcenter.controller.ivr;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itap.callcenter.beans.ivr.IvrCallrountBean;
import com.itap.callcenter.dao.apc.ivr.IvrCallrouteDao;
import com.itap.callcenter.entity.apc.ivr.IvrCallroute;

/**
 * 
 * @author scotomax
 *
 */
@ViewScoped
@ManagedBean(name="ivrCallrouteController")
public class IvrCallrouteController extends IvrCallrountBean {

	private static final long serialVersionUID = -3101691233769780113L;
	// SLF4J logger
	Logger logger = LoggerFactory.getLogger(IvrCallrouteController.class);
	// IVR Call Route DAO
	@ManagedProperty(value="#{ivrCallrouteDaoImpl}")
	IvrCallrouteDao ivrCallrouteDao;
	
	public void setIvrCallrouteDao(IvrCallrouteDao ivrCallrouteDao) {
		this.ivrCallrouteDao = ivrCallrouteDao;
	}

	/**
	 * Create IVR Call Route entity data insert into database.
	 */
	public void create() {
		logger.debug("Entering IVR Call Route creation method...");
		
		try {
			IvrCallroute entry = new IvrCallroute();
			
			entry.setCallrouteId(callrouteId);
			entry.setCallrouteName(callrouteName);
			entry.setCallrouteDescription(callrouteDescription);
			entry.setCallrouteCaller(callrouteCaller);
			entry.setCallrouteCalled(callrouteCalled);
			entry.setCallrouteCreateDate(new Date());
			entry.setCallrouteUpdateDate(new Date());
			
			ivrCallrouteDao.save(entry);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The data been created successfully.", "Information"));
		} catch (Exception ex) {
			logger.error("Failed to insert the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to insert the data into db, Cause: "+ex.getMessage(), "Information"));
		}
	}
	
	/**
	 * Update IVR Call Route entity data update into database.
	 */
	public void update() {
		logger.debug("Entering IVR Call Route update method...");
		
		try {
			IvrCallroute entry = ivrCallrouteDao.findById(callrouteId);
			
			entry.setCallrouteId(callrouteId);
			entry.setCallrouteName(callrouteName);
			entry.setCallrouteDescription(callrouteDescription);
			entry.setCallrouteCaller(callrouteCaller);
			entry.setCallrouteCalled(callrouteCalled);
			entry.setCallrouteUpdateDate(new Date());
			
			ivrCallrouteDao.update(entry);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The data been updated successfully.", "Information"));
		} catch (Exception ex) {
			logger.error("Failed to update the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to update the data into db, Cause: "+ex.getMessage(), "Information"));
		}
	}
	
	/**
	 * Fetch IVR Call Route entity data from database.
	 */
	public void edit() {
		logger.debug("Entering IVR Call Route edit method...");
		if ( selectedCallrouteId == null || selectedCallrouteId.intValue() == -1 ) {
			callrouteId = null;
			callrouteName = null;
			callrouteDescription = null;
			callrouteCaller = null;
			callrouteCalled = null;
			callrouteCreateDate = null;
			callrouteUpdateDate = null;
		} else {
			try {
				IvrCallroute entry = ivrCallrouteDao.findById(selectedCallrouteId);

				callrouteName = entry.getCallrouteName();
				callrouteDescription = entry.getCallrouteDescription();
				callrouteCaller = entry.getCallrouteCaller();
				callrouteCalled = entry.getCallrouteCalled();
				callrouteCreateDate = entry.getCallrouteCreateDate();
				callrouteUpdateDate = entry.getCallrouteUpdateDate();
				
				selectedCallrouteId = -1;
			} catch (Exception ex) {
				logger.error("Failed to fetch the element data from db, Cause: "+ex.getMessage(), ex);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to fetch the element data from db, Cause: "+ex.getMessage(), "Information"));
			}
		}
	}
	
	/**
	 * Delete IVR Call Route entity data from database.
	 */
	public void delete() {
		logger.debug("Entering IVR Call Route delete method...");
		try {
			if ( selectedCallrouteId != null ) {
				ivrCallrouteDao.deleteById(selectedCallrouteId);
				selectedCallrouteId = -1;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The data been deleted successfully.", "Information"));
			}
		} catch (Exception ex) {
			logger.error("Failed to delete the data, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Failed to delete the data, Cause: "+ex.getMessage(), "Information"));
		}
	}
	
	/**
	 * Fetch list of all IVR Call Route entity data from database.
	 */
	public List<IvrCallroute> getIvrCallrouteList() {
		logger.debug("Entering IVR Call Route getting list of all entity method...");
		List<IvrCallroute> rsList = null;
		try {
			rsList = ivrCallrouteDao.findAll();
		} catch ( Exception ex ) {
			logger.error("Failed to load the data, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,  "Failed to load the data, Cause: "+ex.getMessage(), "Information"));
		}
		return rsList;
	}
	
}
