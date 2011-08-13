package com.itap.callcenter.controller.ivr;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itap.callcenter.beans.ivr.IvrDtmfBean;
import com.itap.callcenter.dao.apc.ivr.IvrDtmfDao;
import com.itap.callcenter.entity.apc.ivr.IvrDtmf;

/**
 * 
 * @author phamon
 *
 */
@ViewScoped
@ManagedBean(name="ivrDtmfController")
public class IvrDtmfController extends IvrDtmfBean {
	
	private static final long serialVersionUID = 4178099993761647818L;

	Logger logger = LoggerFactory.getLogger(IvrDtmfController.class);

	@ManagedProperty(value="#{ivrDtmfDaoImpl}")
	IvrDtmfDao ivrDtmfDao;

	
	public List<IvrDtmf> getListIvrDtmf() {
		logger.debug("Entering IVR dtmf getting list of all entity method...");
		try {
			return ivrDtmfDao.findAll();
		} catch ( Exception ex ) {
			logger.error("Failed to load the data, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to load the data, Cause: "+ex.getMessage()));
		}
		return null;
	}
	
	public void create() {
		logger.debug("Entering IVR dtmf creation method...");
		try {
			IvrDtmf entry = new IvrDtmf();
			entry.setDtmfId(dtmfId);
			entry.setDtmfName(dtmfName);
			entry.setDtmfDescription(dtmfDescription);
			entry.setDtmfDigit(dtmfDigit);
			entry.setDtmfCreateDate(new Date());
			ivrDtmfDao.save(entry);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data been created successfully."));
		} catch (Exception ex) {
			logger.error("Failed to insert the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to insert the data into db, Cause: "+ex.getMessage()));
		}
	}
	
	// when use click edit button
	public void edit() {
		logger.debug("Entering IVR dtmf edit method...");
		if (selectedDtmfId != null && selectedDtmfId.intValue() != -1) {
			try {
				IvrDtmf entry = ivrDtmfDao.findById(selectedDtmfId);
				dtmfId = entry.getDtmfId();
				dtmfName = entry.getDtmfName();
				dtmfDigit = entry.getDtmfDigit();
				dtmfDescription = entry.getDtmfDescription();
				dtmfCreateDate = entry.getDtmfCreateDate();
				dtmfUpdateDate = entry.getDtmfUpdateDate();
				selectedDtmfId = -1;
			} catch (Exception ex) {
				logger.error("Failed to fetch the element data from db, Cause: "+ex.getMessage(), ex);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to fetch the element data from db, Cause: "+ex.getMessage()));
			}
		} else {
			reset();
		}
	}
	
	public void reset() {
		dtmfId = null;
		dtmfName = null;
		dtmfDigit = null;
		dtmfDescription = null;
		dtmfCreateDate = null;
		dtmfUpdateDate = null;
	}
	
	public void update() {
		logger.debug("Entering IVR dtmf update method...");
		try {
			IvrDtmf entry = ivrDtmfDao.findById(dtmfId);
			entry.setDtmfId(dtmfId);
			entry.setDtmfName(dtmfName);
			entry.setDtmfDescription(dtmfDescription);
			entry.setDtmfDigit(dtmfDigit);
			entry.setDtmfUpdateDate(dtmfUpdateDate);
			ivrDtmfDao.update(entry);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data been updated successfully."));
		} catch (Exception ex) {
			logger.error("Failed to update the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to update the data into db, Cause: "+ex.getMessage()));
		}
	}
	
	public void delete() {
		logger.debug("Entering IVR dtmf delete method...");
		try {
			if ( selectedDtmfId != null ) {
				ivrDtmfDao.deleteById(selectedDtmfId);
				selectedDtmfId = -1;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data been deleted successfully."));
			}
		} catch (Exception ex) {
			logger.error("Failed to delete the data, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to delete the data, Cause: "+ex.getMessage()));
		}
	}
	
	// getter & setter
	public void setIvrDtmfDao(IvrDtmfDao ivrDtmfDao) {
		this.ivrDtmfDao = ivrDtmfDao;
	}
	
}
