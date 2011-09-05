package com.itap.callcenter.controller.ivr;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itap.callcenter.dao.apc.ivr.IvrPabxDao;
import com.itap.callcenter.dao.apc.ivr.IvrProtocolDao;
import com.itap.callcenter.entity.apc.ivr.IvrPabx;
import com.itap.callcenter.entity.apc.ivr.IvrProtocol;

/**
 * 
 * @author phamon
 *
 */
@ViewScoped
@ManagedBean(name = "ivrPabxController")
public class IvrPabxController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Logger logger = LoggerFactory.getLogger(IvrPabxController.class);
	
	@ManagedProperty(value="#{ivrProtocolDaoImpl}")
	private IvrProtocolDao ivrProtocolDao;
	
	@ManagedProperty(value="#{ivrPabxDaoImpl}")
	private IvrPabxDao ivrPabxDao;
	
	private List<SelectItem> listIvrProtocol = new ArrayList<SelectItem>();
	
	private IvrPabx inputIvrPabx = new IvrPabx();
	
	
	
	@PostConstruct
	private void factoryListItem() { 
		List<IvrProtocol> resultIvrProtocol = ivrProtocolDao.findAll();
		for (IvrProtocol ivrProtocol : resultIvrProtocol) {
			listIvrProtocol.add(new SelectItem(ivrProtocol, ivrProtocol.getProtocolName()));
		}
	}
	
	public void prepareCreate() {
		logger.debug("prepare input field before you insert");
		inputIvrPabx = new IvrPabx();
	}
	public void prepareUpdate() {
		logger.debug("prepare input field before you update");
		logger.debug("pabxId: " + inputIvrPabx.getPabxId());
		IvrPabx ivrPabx = ivrPabxDao.findById(inputIvrPabx.getPabxId());
		inputIvrPabx.setPabxId(ivrPabx.getPabxId());
		inputIvrPabx.setPabxName(ivrPabx.getPabxName());
		inputIvrPabx.setPabxDescription(ivrPabx.getPabxDescription());
		inputIvrPabx.setPabxUpdateDate(ivrPabx.getPabxUpdateDate());
		inputIvrPabx.setProtocol(ivrPabx.getProtocol());
	}
	
	public void create() {
		logger.debug("process create");
		logger.debug("pabxName: " + inputIvrPabx.getPabxName());
		try {
			IvrPabx ivrPabx = new IvrPabx();
			ivrPabx.setPabxName(inputIvrPabx.getPabxName());
			ivrPabx.setPabxDescription(inputIvrPabx.getPabxDescription());
			ivrPabx.setProtocol(inputIvrPabx.getProtocol());
			ivrPabxDao.save(ivrPabx);
			inputIvrPabx = new IvrPabx();
			logger.debug("The data have been created successfully.");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data have been created successfully."));
		} catch (Exception ex) {
			logger.error("Failed to insert the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "The data cannot create", "Failed to insert the data into db, Cause: "+ex.getMessage()));
		}
	}
	public void update() {
		logger.debug("process update");
		logger.debug("pabxName: " + inputIvrPabx.getPabxName());
		try {
			inputIvrPabx.setPabxUpdateDate(new Date());
			ivrPabxDao.update(inputIvrPabx);
			inputIvrPabx = new IvrPabx();
			logger.debug("The data have been updated successfully.");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data have been updated successfully."));
		} catch (Exception ex) {
			logger.error("Failed to insert the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "The data cannot update", "Failed to insert the data into db, Cause: "+ex.getMessage()));
		}
	}
	public void delete() {
		logger.debug("delete ivr schedule");
		logger.debug("pabxName: " + inputIvrPabx.getPabxName());
		try {
			ivrPabxDao.deleteById(inputIvrPabx.getPabxId());
			inputIvrPabx = new IvrPabx();
			logger.debug("The data have been deleted successfully.");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data have been deleted successfully."));
		} catch (Exception ex) {
			logger.error("Failed to delete the data, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "The data cannot delete", "Failed to delete the data, Cause: "+ex.getMessage()));
		}
	}
	
	public List<IvrPabx> getListIvrPabx() {
		return ivrPabxDao.findAll();
	}
	
	
	// Getter & Setter
	public IvrProtocolDao getIvrProtocolDao() {
		return ivrProtocolDao;
	}
	public void setIvrProtocolDao(IvrProtocolDao ivrProtocolDao) {
		this.ivrProtocolDao = ivrProtocolDao;
	}
	public IvrPabxDao getIvrPabxDao() {
		return ivrPabxDao;
	}
	public void setIvrPabxDao(IvrPabxDao ivrPabxDao) {
		this.ivrPabxDao = ivrPabxDao;
	}
	public List<SelectItem> getListIvrProtocol() {
		return listIvrProtocol;
	}
	public void setListIvrProtocol(List<SelectItem> listIvrProtocol) {
		this.listIvrProtocol = listIvrProtocol;
	}
	public IvrPabx getInputIvrPabx() {
		return inputIvrPabx;
	}
	public void setInputIvrPabx(IvrPabx inputIvrPabx) {
		this.inputIvrPabx = inputIvrPabx;
	}
	
}
