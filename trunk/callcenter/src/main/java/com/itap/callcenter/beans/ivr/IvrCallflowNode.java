package com.itap.callcenter.beans.ivr;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itap.callcenter.dao.apc.ivr.IvrCallflowDao;
import com.itap.callcenter.entity.apc.ivr.IvrCallflow;

public class IvrCallflowNode extends IvrCallflowBean implements Serializable {

	private static final long serialVersionUID = 7886391344275357676L;
	private Logger logger = LoggerFactory.getLogger(IvrCallflowNode.class);
	

	private IvrCallflowDao ivrCallflowDao;
	public void setIvrCallflowDao(IvrCallflowDao ivrCallflowDao) {
		this.ivrCallflowDao = ivrCallflowDao;
	}
	
	
	public synchronized List<IvrCallflowNode> getRoot() {
		logger.debug("Getting root of callflow");
		try {
			List<IvrCallflow> listCallflow = ivrCallflowDao.findByCallflowBackId(null);
			if (listCallflow != null && !listCallflow.isEmpty()) {
				List<IvrCallflowNode> listCallflowNode = new ArrayList<IvrCallflowNode>();
				for (IvrCallflow ivrCallflow : listCallflow) {
					IvrCallflowNode ivrCallflowNode = convert(ivrCallflow);
					listCallflowNode.add(ivrCallflowNode);
				}
				return listCallflowNode;
			}
			
		} catch ( Exception ex ) {
			logger.error("Failed to load the data, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to load the data, Cause: "+ex.getMessage()));
		}
		return null;
	}
	
	public synchronized List<IvrCallflowNode> getChildCallflow() {
		logger.debug("Getting child of parent: " + callflowId);
		try {
			List<IvrCallflow> listCallflow = ivrCallflowDao.findByCallflowBackId(callflowId);
			if (listCallflow != null && !listCallflow.isEmpty()) {
				List<IvrCallflowNode> listCallflowNode = new ArrayList<IvrCallflowNode>();
				for (IvrCallflow ivrCallflow : listCallflow) {
					IvrCallflowNode ivrCallflowNode = convert(ivrCallflow);
					listCallflowNode.add(ivrCallflowNode);
				}
				return listCallflowNode;
			}
		} catch ( Exception ex ) {
			logger.error("Failed to load the data, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to load the data, Cause: "+ex.getMessage()));
		}
		return null;
	}
	
	private IvrCallflowNode convert(IvrCallflow ivrCallflow) {
		IvrCallflowNode ivrCallflowNode = new IvrCallflowNode();
		if (ivrCallflow != null) {
			ivrCallflowNode.setCallflowId(ivrCallflow.getCallflowId());
			ivrCallflowNode.setCallflowName(ivrCallflow.getCallflowName());
			ivrCallflowNode.setCallflowDescription(ivrCallflow.getCallflowDescription());
			ivrCallflowNode.setCallflowStep(ivrCallflow.getCallflowStep());
			ivrCallflowNode.setCallflowTimeout(ivrCallflow.getCallflowTimeout());
			ivrCallflowNode.setCallflowVoiceRepeatEnable(ivrCallflow.getCallflowVoiceRepeatEnable());
			ivrCallflowNode.setCallflowCreateDate(ivrCallflow.getCallflowCreateDate());
			ivrCallflowNode.setCallflowUpdateDate(ivrCallflow.getCallflowUpdateDate());
			ivrCallflowNode.setIvrCallflowDao(this.ivrCallflowDao);
		}
		return ivrCallflowNode;
	}


	
	
	
	
}
