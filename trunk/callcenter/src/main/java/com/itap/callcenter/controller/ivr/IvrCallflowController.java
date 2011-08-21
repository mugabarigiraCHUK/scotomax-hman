package com.itap.callcenter.controller.ivr;

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

import com.itap.callcenter.beans.ivr.IvrCallflowBean;
import com.itap.callcenter.beans.ivr.IvrCallflowNode;
import com.itap.callcenter.dao.apc.ivr.IvrCallflowDao;
import com.itap.callcenter.dao.apc.ivr.IvrDtmfDao;
import com.itap.callcenter.dao.apc.ivr.IvrVoicepromptDao;
import com.itap.callcenter.entity.apc.ivr.IvrCallflow;
import com.itap.callcenter.entity.apc.ivr.IvrVoiceprompt;

@ViewScoped
@ManagedBean(name="ivrCallflowController")
public class IvrCallflowController extends IvrCallflowBean {

	private static final long serialVersionUID = 1497712985960315713L;

	private Logger logger = LoggerFactory.getLogger(IvrCallflowController.class);

	@ManagedProperty(value="#{ivrCallflowDaoImpl}")
	private IvrCallflowDao ivrCallflowDao;
	
	@ManagedProperty(value="#{ivrVoicepromptDaoImpl}")
	private IvrVoicepromptDao ivrVoicepromptDao;
	
	@ManagedProperty(value="#{ivrDtmfDaoImpl}")
	private IvrDtmfDao ivrDtmfDao;

	private Integer selectedCallflowId;
	private boolean editable;
	private boolean createable;
	
	private List<SelectItem> listIvrVoiceprompt = new ArrayList<SelectItem>();
	private List<SelectItem> listIvrCallflow = new ArrayList<SelectItem>();
	
	@PostConstruct
	private void factoryListItem() {
		listIvrVoiceprompt = new ArrayList<SelectItem>();
		listIvrCallflow = new ArrayList<SelectItem>();
		List<IvrVoiceprompt> queryListIvrVoiceprompt = ivrVoicepromptDao.findAll();
		for (IvrVoiceprompt ivrVoiceprompt : queryListIvrVoiceprompt) {
			listIvrVoiceprompt.add(new SelectItem(ivrVoiceprompt, ivrVoiceprompt.getVoiceName()));
		}
		List<IvrCallflow> queryListIvrCallflow = ivrCallflowDao.findAll();
		for (IvrCallflow ivrCallflow : queryListIvrCallflow) {
			listIvrCallflow.add(new SelectItem(ivrCallflow, ivrCallflow.getCallflowName()));
		}
	}

	public List<IvrCallflowNode> getRoot() {
		logger.debug("Getting callflow node");
		try {
			IvrCallflowNode ivrCallflowNode = new IvrCallflowNode();
			ivrCallflowNode.setIvrCallflowDao(ivrCallflowDao);
			return ivrCallflowNode.getRoot();
		} catch ( Exception ex ) {
			logger.error("Failed to load the data, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to load the data, Cause: "+ex.getMessage()));
		}
		return null;
	}

	public void submit() {
		if (createable) {
			create();
		} 
		else if (editable) {
			update();
		} 
	}
	
	public void create() {
		logger.debug("call create action");
		logger.debug("callflowName: " + callflowName);
		IvrCallflow ivrCallflow = new IvrCallflow();
		ivrCallflow.setCallflowId(ivrCallflowDao.findAll().size()+1);
		ivrCallflow.setCallflowName(callflowName);
		ivrCallflow.setCallflowDescription(callflowDescription);
		ivrCallflow.setCallflowStep(callflowStep);
		ivrCallflow.setCallflowVoiceRepeatEnable(callflowVoiceRepeatEnable);
		ivrCallflow.setCallflowTimeout(callflowTimeout);
		ivrCallflow.setCallflowBack(callflowBack == null ? null : ivrCallflowDao.findById(callflowBack.getCallflowId()));
		ivrCallflow.setVoicePrompt(ivrVoicepromptDao.findById(ivrVoiceprompt.getVoiceId()));
		// TODO add dtmf
		ivrCallflow.setCallflowCreateDate(new Date());
		ivrCallflowDao.save(ivrCallflow);
		createable = false;
		reset();
		logger.debug("callflow have created");
	}
	
	public void update() {
		logger.debug("call update action");
		logger.debug("callflowName: " + callflowName);
		IvrCallflow ivrCallflow = ivrCallflowDao.findById(selectedCallflowId);
		ivrCallflow.setCallflowName(callflowName);
		ivrCallflow.setCallflowDescription(callflowDescription);
		ivrCallflow.setCallflowStep(callflowStep);
		ivrCallflow.setCallflowTimeout(callflowTimeout);
		ivrCallflow.setCallflowVoiceRepeatEnable(callflowVoiceRepeatEnable);
		ivrCallflow.setCallflowBack(callflowBack);
		ivrCallflow.setVoicePrompt(ivrVoiceprompt);
		// TODO add dtmf		
		ivrCallflow.setCallflowUpdateDate(new Date());
		ivrCallflowDao.update(ivrCallflow);
		editable = false;
		reset();
		logger.debug("callflow have updated");
	}
	
	public void delete() {
		logger.debug("call delete action");
		ivrCallflowDao.deleteById(selectedCallflowId); 
		reset();
		logger.debug("callflow have deleted");
	}
	
	
	public void createNew() {
		logger.debug("field can create new");
		reset();
		createable = true;
		
	}
	
	public void edit() {
		logger.debug("field can edit");
		editable = true;
	}
	
	public void cancel() {
		logger.debug("field cannot edit");
		editable = false;
		createable = false;
		if (selectedCallflowId != null) {
			setSelectedCallflowId(selectedCallflowId);
		}
	}
	
	public boolean isEditable() {
		return editable;
	}
	
	public boolean isCreateable() {
		return createable;
	}
	
	

	// Getter & Setter
	public void setIvrCallflowDao(IvrCallflowDao ivrCallflowDao) {
		this.ivrCallflowDao = ivrCallflowDao;
	}
	public void setIvrVoicepromptDao(IvrVoicepromptDao ivrVoicepromptDao) {
		this.ivrVoicepromptDao = ivrVoicepromptDao;
	}
	public void setIvrDtmfDao(IvrDtmfDao ivrDtmfDao) {
		this.ivrDtmfDao = ivrDtmfDao;
	}
	public List<SelectItem> getListIvrVoiceprompt() {
		return listIvrVoiceprompt;
	}
	public void setListIvrVoiceprompt(List<SelectItem> listIvrVoiceprompt) {
		this.listIvrVoiceprompt = listIvrVoiceprompt;
	}
	public List<SelectItem> getListIvrCallflow() {
		return listIvrCallflow;
	}
	public void setListIvrCallflow(List<SelectItem> listIvrCallflow) {
		this.listIvrCallflow = listIvrCallflow;
	}

	public void setSelectedCallflowId(Integer selectedCallflowId) {
		logger.debug("selected callflow id: " + selectedCallflowId);
		reset();
		this.selectedCallflowId = selectedCallflowId;
		IvrCallflow ivrCallflow = ivrCallflowDao.findById(selectedCallflowId);
		this.callflowId = ivrCallflow.getCallflowId();
		this.callflowName = ivrCallflow.getCallflowName();
		this.callflowDescription = ivrCallflow.getCallflowDescription();
		this.callflowStep = ivrCallflow.getCallflowStep();
		this.callflowTimeout = ivrCallflow.getCallflowTimeout();
		this.callflowVoiceRepeatEnable = ivrCallflow.getCallflowVoiceRepeatEnable();
		this.callflowCreateDate = ivrCallflow.getCallflowCreateDate();
		this.callflowUpdateDate = ivrCallflow.getCallflowUpdateDate();
		if (ivrCallflow.getCallflowBack() != null) {
			this.parentCallflowId = ivrCallflow.getCallflowBack().getCallflowId();
			this.parentCallflowName = ivrCallflow.getCallflowBack().getCallflowName();
		}
		this.ivrVoiceprompt = ivrCallflow.getVoicePrompt();
		this.callflowBack = ivrCallflow.getCallflowBack();
		editable = false;
		createable = false;
	}
	
	public Integer getSelectedCallflowId() {
		return selectedCallflowId;
	}

	
	
	
}
