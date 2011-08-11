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

import com.itap.callcenter.beans.ivr.IvrVoicepromptBean;
import com.itap.callcenter.dao.apc.ivr.IvrVoicepromptDao;
import com.itap.callcenter.entity.apc.ivr.IvrVoiceprompt;

/**
 * 
 * @author scotomax
 *
 */
@ViewScoped
@ManagedBean(name="ivrVoicepromptController")
public class IvrVoicepromptController extends IvrVoicepromptBean {

	private static final long serialVersionUID = -8215172211617546982L;
	// SLF4J Logger
	Logger logger = LoggerFactory.getLogger(IvrVoicepromptController.class);
	// IVR voice prompt
	@ManagedProperty(value="#{ivrVoicepromptDaoImpl}")
	IvrVoicepromptDao ivrVoicepromptDao;
	
	public void setIvrVoicepromptDao(IvrVoicepromptDao ivrVoicepromptDao) {
		this.ivrVoicepromptDao = ivrVoicepromptDao;
	}
	
	/**
	 * Create IVR voice prompt entity data insert into database.
	 */
	public void create() {
		logger.debug("Entering IVR voice prompt creation method...");
		try {
			IvrVoiceprompt entry = new IvrVoiceprompt();
			entry.setVoiceId(voiceId);
			entry.setVoiceName(voiceName);
			entry.setVoiceDescription(voiceDescription);
			entry.setVoiceFilename(voiceFilename);
			entry.setVoiceCreateDate(new Date());
			entry.setVoiceUpdateDate(new Date());
			ivrVoicepromptDao.save(entry);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data been created successfully."));
		} catch (Exception ex) {
			logger.error("Failed to insert the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to insert the data into db, Cause: "+ex.getMessage()));
		}
	}
	
	/**
	 * Update IVR voice prompt entity data update into database.
	 */
	public void update() {
		logger.debug("Entering IVR voice prompt update method...");
		try {
			IvrVoiceprompt entry = ivrVoicepromptDao.findById(voiceId);
			entry.setVoiceName(voiceName);
			entry.setVoiceDescription(voiceDescription);
			entry.setVoiceFilename(voiceFilename);
			entry.setVoiceUpdateDate(new Date());
			ivrVoicepromptDao.update(entry);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data been updated successfully."));
		} catch (Exception ex) {
			logger.error("Failed to update the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to update the data into db, Cause: "+ex.getMessage()));
		}
	}
	
	/**
	 * Fetch IVR voice prompt entity data from database.
	 */
	public void edit() {
		logger.debug("Entering IVR voice prompt edit method...");
		if ( selectedVoiceId == null || selectedVoiceId.intValue() == -1 ) {
			voiceId = null;
			voiceName = null;
			voiceDescription = null;
			voiceFilename = null;
			voiceCreateDate = null;
			voiceUpdateDate = null;
		} else {
			try {
				IvrVoiceprompt entry = ivrVoicepromptDao.findById(selectedVoiceId);
				voiceId = entry.getVoiceId();
				voiceName = entry.getVoiceName();
				voiceDescription = entry.getVoiceDescription();
				voiceFilename = entry.getVoiceFilename();
				voiceCreateDate = entry.getVoiceCreateDate();
				voiceUpdateDate = entry.getVoiceUpdateDate();
				selectedVoiceId = -1;
			} catch (Exception ex) {
				logger.error("Failed to fetch the element data from db, Cause: "+ex.getMessage(), ex);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to fetch the element data from db, Cause: "+ex.getMessage()));
			}
		}
	}
	
	/**
	 * Delete IVR voice prompt entity data from database.
	 */
	public void delete() {
		logger.debug("Entering IVR voice prompt delete method...");
		try {
			if ( selectedVoiceId != null ) {
				ivrVoicepromptDao.deleteById(selectedVoiceId);
				selectedVoiceId = -1;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data been deleted successfully."));
			}
		} catch (Exception ex) {
			logger.error("Failed to delete the data, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to delete the data, Cause: "+ex.getMessage()));
		}
	}
	
	/**
	 * Fetch list of all IVR voice prompt entity data from database.
	 */
	public List<IvrVoiceprompt> getIvrVoicepromptList() {
		logger.debug("Entering IVR voice prompt getting list of all entity method...");
		List<IvrVoiceprompt> rsList = null;
		try {
			rsList = ivrVoicepromptDao.findAll();
		} catch ( Exception ex ) {
			logger.error("Failed to load the data, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to load the data, Cause: "+ex.getMessage()));
		}
		return rsList;
	}
}
