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

import com.itap.callcenter.beans.ivr.IvrChannelBean;
import com.itap.callcenter.dao.apc.ivr.IvrChannelDao;
import com.itap.callcenter.entity.apc.ivr.IvrChannel;

/**
 * 
 * @author scotomax
 *
 */
@ViewScoped
@ManagedBean(name="ivrChannelController")
public class IvrChannelController extends IvrChannelBean {

	private static final long serialVersionUID = 1586166895357802053L;
	// SLF4J logger
	Logger logger = LoggerFactory.getLogger(IvrChannelController.class);
	// IVR channel DAO
	@ManagedProperty(value="#{ivrChannelDaoImpl}")
	IvrChannelDao ivrChannelDao;
	
	public void setIvrChannelDao(IvrChannelDao ivrChannelDao) {
		this.ivrChannelDao = ivrChannelDao;
	}
	
	/**
	 * Create IVR channel entity data insert into database.
	 */
	public void create() {
		logger.debug("Entering IVR channel creation method...");
		try {
			IvrChannel entry = new IvrChannel();
			entry.setChannelId(channelId);
			entry.setChannelName(channelName);
			entry.setChannelDescription(channelDescription);
			entry.setChannelUpdateDate(new Date());
			ivrChannelDao.save(entry);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data been created successfully."));
		} catch (Exception ex) {
			logger.error("Failed to insert the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to insert the data into db, Cause: "+ex.getMessage()));
		}
	}
	
	/**
	 * Update IVR channel entity data update into database.
	 */
	public void update() {
		logger.debug("Entering IVR channel update method...");
		try {
			IvrChannel entry = new IvrChannel();
			entry.setChannelId(channelId);
			entry.setChannelName(channelName);
			entry.setChannelDescription(channelDescription);
			entry.setChannelUpdateDate(new Date());
			ivrChannelDao.update(entry);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data been updated successfully."));
		} catch (Exception ex) {
			logger.error("Failed to update the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to update the data into db, Cause: "+ex.getMessage()));
		}
	}
	
	/**
	 * Fetch IVR channel entity data from database.
	 */
	public void edit() {
		logger.debug("Entering IVR channel edit method...");
		if ( selectedChannelId == null || selectedChannelId.intValue() == -1 ) {
			channelId = null;
			channelName = null;
			channelDescription = null;
			channelUpdateDate = null;
		} else {
			try {
				IvrChannel entry = ivrChannelDao.findById(selectedChannelId);
				channelId = entry.getChannelId();
				channelName = entry.getChannelName();
				channelDescription = entry.getChannelDescription();
				channelUpdateDate = entry.getChannelUpdateDate();
				selectedChannelId = -1;
			} catch (Exception ex) {
				logger.error("Failed to fetch the element data from db, Cause: "+ex.getMessage(), ex);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to fetch the element data from db, Cause: "+ex.getMessage()));
			}
		}
	}
	
	/**
	 * Delete IVR channel entity data from database.
	 */
	public void delete() {
		logger.debug("Entering IVR channel delete method...");
		try {
			if ( selectedChannelId != null ) {
				ivrChannelDao.deleteById(selectedChannelId);
				selectedChannelId = -1;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data been deleted successfully."));
			}
		} catch (Exception ex) {
			logger.error("Failed to delete the data, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to delete the data, Cause: "+ex.getMessage()));
		}
	}
	
	/**
	 * Fetch list of all IVR channel entity data from database.
	 */
	public List<IvrChannel> getIvrChannelList() {
		logger.debug("Entering IVR channel getting list of all entity method...");
		List<IvrChannel> rsList = null;
		try {
			rsList = ivrChannelDao.findAll();
		} catch ( Exception ex ) {
			logger.error("Failed to load the data, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to load the data, Cause: "+ex.getMessage()));
		}
		return rsList;
	}
}
