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

import com.itap.callcenter.beans.ivr.IvrScheduleBean;
import com.itap.callcenter.dao.apc.ivr.IvrChannelDao;
import com.itap.callcenter.dao.apc.ivr.IvrScheduleDao;
import com.itap.callcenter.entity.apc.ivr.IvrChannel;
import com.itap.callcenter.entity.apc.ivr.IvrSchedule;

/**
 * 
 * @author phamon
 *
 */
@ViewScoped
@ManagedBean(name = "ivrScheduleController")
public class IvrScheduleController extends IvrScheduleBean {
	
	private Logger logger = LoggerFactory.getLogger(IvrScheduleController.class);
	
	@ManagedProperty(value="#{ivrScheduleDaoImpl}")
	private IvrScheduleDao ivrScheduleDao;
	
	@ManagedProperty(value="#{ivrChannelDaoImpl}")
	private IvrChannelDao ivrChannelDao;

	private List<SelectItem> ivrChannelList;
	
	@PostConstruct
	private void factoryListItem() {
		List<IvrChannel> queryResult = ivrChannelDao.findAll();
		ivrChannelList = new ArrayList<SelectItem>();
		for (IvrChannel ivrChannel : queryResult) {
			ivrChannelList.add(new SelectItem(ivrChannel, ivrChannel.getChannelName()));
		}
	}
	
	public void prepareCreate() {
		logger.debug("prepare input field before you insert");
		reset();
	}
	public void prepareUpdate() {
		logger.debug("prepare input field before you update");
		IvrSchedule ivrSchedule = ivrScheduleDao.findById(selectedScheduleId);
		scheduleId = ivrSchedule.getScheduleId();
		scheduleName = ivrSchedule.getScheduleName();
		scheduleDescription = ivrSchedule.getScheduleDescription();
		scheduleCaller = ivrSchedule.getScheduleCaller();
		scheduleCalled = ivrSchedule.getScheduleCalled();
		scheduleStartDate = ivrSchedule.getScheduleStartDate();
		scheduleRetryTime = ivrSchedule.getScheduleRetryTime();
		scheduleCreateDate = ivrSchedule.getScheduleCreateDate();
		scheduleUpdateDate = ivrSchedule.getScheduleUpdateDate();
		scheduleChannel = ivrSchedule.getScheduleChannel();
	}
	public void create() {
		logger.debug("create ivr schedule");
		logger.debug("scheduleName: " + scheduleName);
		try {
			IvrSchedule ivrSchedule = new IvrSchedule();
			ivrSchedule.setScheduleId(ivrScheduleDao.findAll().size()+1);
			ivrSchedule.setScheduleName(scheduleName);
			ivrSchedule.setScheduleDescription(scheduleDescription);
			ivrSchedule.setScheduleCaller(scheduleCaller);
			ivrSchedule.setScheduleCalled(scheduleCalled);
			ivrSchedule.setScheduleStartDate(scheduleStartDate);
			ivrSchedule.setScheduleRetryTime(scheduleRetryTime);
			ivrSchedule.setScheduleCreateDate(new Date());
			ivrSchedule.setScheduleChannel(scheduleChannel);
			ivrScheduleDao.save(ivrSchedule);
			logger.debug("create ivr shcedule already ");
		} catch (Exception ex) {
			logger.error("Failed to insert the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to insert the data into db, Cause: "+ex.getMessage()));
		}
	}
	public void update() {
		logger.debug("update ivr schedule");
		logger.debug("selectScheduleId: " + selectedScheduleId);
		try {
		IvrSchedule ivrSchedule = ivrScheduleDao.findById(selectedScheduleId);
		if (ivrSchedule != null) {
			ivrSchedule.setScheduleName(scheduleName);
			ivrSchedule.setScheduleDescription(scheduleDescription);
			ivrSchedule.setScheduleCaller(scheduleCaller);
			ivrSchedule.setScheduleCalled(scheduleCalled);
			ivrSchedule.setScheduleStartDate(scheduleStartDate);
			ivrSchedule.setScheduleRetryTime(scheduleRetryTime);
			ivrSchedule.setScheduleUpdateDate(new Date());
			ivrSchedule.setScheduleChannel(scheduleChannel);
			ivrScheduleDao.update(ivrSchedule);
			logger.debug("update ivr shcedule already ");
		}
		} catch (Exception ex) {
			logger.error("Failed to insert the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to insert the data into db, Cause: "+ex.getMessage()));
		}
	}
	public void delete() {
		logger.debug("delete ivr schedule");
		logger.debug("selectScheduleId: " + selectedScheduleId);
		try {
			ivrScheduleDao.deleteById(selectedScheduleId);
		} catch (Exception ex) {
			logger.error("Failed to delete the data, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to delete the data, Cause: "+ex.getMessage()));
		}
	}
	
	public List<IvrSchedule> getIvrScheduleList(){
		return ivrScheduleDao.findAll();
	}
	
	
	
	
	
	// Getter & Setter
	public void setIvrScheduleDao(IvrScheduleDao ivrScheduleDao) {
		this.ivrScheduleDao = ivrScheduleDao;
	}
	public void setIvrChannelDao(IvrChannelDao ivrChannelDao) {
		this.ivrChannelDao = ivrChannelDao;
	}
	public List<SelectItem> getIvrChannelList() {
		return ivrChannelList;
	}
	public void setIvrChannelList(List<SelectItem> ivrChannelList) {
		this.ivrChannelList = ivrChannelList;
	}
	
	
	
	
	
	
}
