package com.itap.callcenter.controller.acd;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itap.callcenter.beans.acd.AcdRouteBean;
import com.itap.callcenter.dao.apc.acd.AcdRouteDao;
import com.itap.callcenter.entity.apc.acd.AcdRoute;

/**
 * 
 * @author scotomax
 *
 */
@ViewScoped
@ManagedBean(name="acdRouteController")
public class AcdRouteController extends AcdRouteBean {

	private static final long serialVersionUID = -672191222254333859L;
	// SLF4J logger
	Logger logger = LoggerFactory.getLogger(AcdRouteController.class);
	// Acd Route DAO
	@ManagedProperty(value="#{acdRouteDaoImpl}")
	AcdRouteDao acdRouteDao;
	
	public void setAcdRouteDao(AcdRouteDao acdRouteDao) {
		this.acdRouteDao = acdRouteDao;
	}
	
	/**
	 * Create Acd Route entity data insert into database.
	 */
	public void create() {
		logger.debug("Entering Acd Route creation method...");
		
		logger.debug("Look -> RouteCondition -> " + routeCondition);
		
		try {
			AcdRoute entry = new AcdRoute();
			
			entry.setRouteId(routeId);
			entry.setRouteName(routeName);
			entry.setRouteDescription(routeDescription);
			entry.setRouteCaller(routeCaller);
			entry.setRouteCalled(routeCalled);
			entry.setRouteCreateDate(new Date());
			entry.setRouteUpdateDate(new Date());
			
			entry.setRouteCondition(routeCondition);
			
			acdRouteDao.save(entry);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The data been created successfully.", "Information"));
		} catch (Exception ex) {
			logger.error("Failed to insert the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to insert the data into db, Cause: "+ex.getMessage(), "Information"));
		}
	}
	
	/**
	 * Update Acd Route entity data update into database.
	 */
	public void update() {
		logger.debug("Entering Acd Route update method...");
		
		logger.debug("Look -> RouteCondition -> " + routeCondition);
		
		try {
			AcdRoute entry = acdRouteDao.findById(routeId);
			
			entry.setRouteId(routeId);
			entry.setRouteName(routeName);
			entry.setRouteDescription(routeDescription);
			entry.setRouteCaller(routeCaller);
			entry.setRouteCalled(routeCalled);
			entry.setRouteUpdateDate(new Date());
			
			entry.setRouteCondition(routeCondition);
			
			acdRouteDao.update(entry);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The data been updated successfully.", "Information"));
		} catch (Exception ex) {
			logger.error("Failed to update the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to update the data into db, Cause: "+ex.getMessage(), "Information"));
		}
	}
	
	/**
	 * Fetch Acd Route entity data from database.
	 */
	public void edit() {
		logger.debug("Entering Acd Route edit method...");
		if ( selectedRouteId == null || selectedRouteId.intValue() == -1 ) {
			routeId = null;
			routeName = null;
			routeDescription = null;
			routeCondition = null;
			routeCaller = null;
			routeCalled = null;
			routeCreateDate = null;
			routeUpdateDate = null;
		} else {
			try {
				AcdRoute entry = acdRouteDao.findById(selectedRouteId);

				routeName = entry.getRouteName();
				routeDescription = entry.getRouteDescription();
				routeCondition = entry.getRouteCondition();
				routeCaller = entry.getRouteCaller();
				routeCalled = entry.getRouteCalled();
				routeCreateDate = entry.getRouteCreateDate();
				routeUpdateDate = entry.getRouteUpdateDate();
				
				selectedRouteId = -1;
			} catch (Exception ex) {
				logger.error("Failed to fetch the element data from db, Cause: "+ex.getMessage(), ex);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to fetch the element data from db, Cause: "+ex.getMessage(), "Information"));
			}
		}
	}
	
	/**
	 * Delete Acd Route entity data from database.
	 */
	public void delete() {
		logger.debug("Entering Acd Route delete method...");
		try {
			if ( selectedRouteId != null ) {
				acdRouteDao.deleteById(selectedRouteId);
				selectedRouteId = -1;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The data been deleted successfully.", "Information"));
			}
		} catch (Exception ex) {
			logger.error("Failed to delete the data, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Failed to delete the data, Cause: "+ex.getMessage(), "Information"));
		}
	}
	
	/**
	 * Fetch list of all Acd Route entity data from database.
	 */
	public List<AcdRoute> getAcdRouteList() {
		logger.debug("Entering Acd Route getting list of all entity method...");
		List<AcdRoute> rsList = null;
		try {
			rsList = acdRouteDao.findAll();
		} catch ( Exception ex ) {
			logger.error("Failed to load the data, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,  "Failed to load the data, Cause: "+ex.getMessage(), "Information"));
		}
		return rsList;
	}
}
