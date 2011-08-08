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

import com.itap.callcenter.beans.ivr.IvrProtocolBean;
import com.itap.callcenter.dao.apc.ivr.IvrProtocolDao;
import com.itap.callcenter.entity.apc.ivr.IvrProtocol;

/**
 * 
 * @author scotomax
 *
 */
@ViewScoped
@ManagedBean(name = "ivrProtocolController")
public class IvrProtocolController extends IvrProtocolBean {

	private static final long serialVersionUID = -710441699695950605L;

	// SLF4J logger
	Logger logger = LoggerFactory.getLogger(IvrProtocolController.class);
	
	// IVR protocol DAO
	@ManagedProperty(value="#{ivrProtocolDaoImpl}")
	IvrProtocolDao ivrProtocolDao;

	public void setIvrProtocolDao(IvrProtocolDao ivrProtocolDao) {
		this.ivrProtocolDao = ivrProtocolDao;
	}
	
	/**
	 * Create IVR protocol entity data insert into database.
	 */
	public void create() {
		logger.debug("Entering IVR protocol creation method...");
		try {
			IvrProtocol entry = new IvrProtocol();
			entry.setProtocolId(protocolId);
			entry.setProtocolName(protocolName);
			entry.setProtocolDescription(protocolDescription);
			entry.setProtocolUpdateDate(new Date());
			ivrProtocolDao.save(entry);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data been created successfully."));
		} catch (Exception ex) {
			logger.error("Failed to insert the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to insert the data into db, Cause: "+ex.getMessage()));
		}
	}
	
	/**
	 * Update IVR protocol entity data update into database.
	 */
	public void update() {
		logger.debug("Entering IVR protocol update method...");
		try {
			IvrProtocol entry = new IvrProtocol();
			entry.setProtocolId(protocolId);
			entry.setProtocolName(protocolName);
			entry.setProtocolDescription(protocolDescription);
			entry.setProtocolUpdateDate(new Date());
			ivrProtocolDao.update(entry);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data been updated successfully."));
		} catch (Exception ex) {
			logger.error("Failed to update the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to update the data into db, Cause: "+ex.getMessage()));
		}
	}
	
	/**
	 * Fetch IVR protocol entity data from database.
	 */
	public void edit() {
		logger.debug("Entering IVR protocol edit method...");
		if ( selectedProtocolId == null || selectedProtocolId.intValue() == -1 ) {
			protocolId = null;
			protocolName = null;
			protocolDescription = null;
			protocolUpdateDate = null;
		} else {
			try {
				IvrProtocol entry = ivrProtocolDao.findById(selectedProtocolId);
				protocolId = entry.getProtocolId();
				protocolName = entry.getProtocolName();
				protocolDescription = entry.getProtocolDescription();
				protocolUpdateDate = entry.getProtocolUpdateDate();
				selectedProtocolId = -1;
			} catch (Exception ex) {
				logger.error("Failed to fetch the element data from db, Cause: "+ex.getMessage(), ex);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to fetch the element data from db, Cause: "+ex.getMessage()));
			}
		}
	}
	
	/**
	 * Delete IVR protocol entity data from database.
	 */
	public void delete() {
		logger.debug("Entering IVR protocol delete method...");
		try {
			if ( selectedProtocolId != null ) {
				ivrProtocolDao.deleteById(selectedProtocolId);
				selectedProtocolId = -1;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data been deleted successfully."));
			}
		} catch (Exception ex) {
			logger.error("Failed to delete the data, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to delete the data, Cause: "+ex.getMessage()));
		}
	}
	
	/**
	 * Fetch list of all IVR protocol entity data from database.
	 */
	public List<IvrProtocol> getIvrProtocolList() {
		logger.debug("Entering IVR protocol getting list of all entity method...");
		List<IvrProtocol> rsList = null;
		try {
			rsList = ivrProtocolDao.findAll();
		} catch ( Exception ex ) {
			logger.error("Failed to load the data, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to load the data, Cause: "+ex.getMessage()));
		}
		return rsList;
	}
}
