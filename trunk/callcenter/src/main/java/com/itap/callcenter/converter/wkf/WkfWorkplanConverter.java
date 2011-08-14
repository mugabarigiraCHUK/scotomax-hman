package com.itap.callcenter.converter.wkf;

import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itap.callcenter.dao.apc.wkf.WkfWorkplanDao;
import com.itap.callcenter.entity.apc.wkf.WkfWorkplan;

@FacesConverter("wkfWorkplanConverter")
public class WkfWorkplanConverter implements Converter {

	// SLF4J logger
	Logger logger = LoggerFactory.getLogger(WkfWorkplanConverter.class);
	// CRM business DAO
	@ManagedProperty(value="#{wkfWorkplanDaoImpl}")
	WkfWorkplanDao wkfWorkplanDao;
	
	public void setWkfWorkplanDao(WkfWorkplanDao wkfWorkplanDao) {
		this.wkfWorkplanDao = wkfWorkplanDao;;
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		try {
			logger.debug("The string value getting from faces context, " + value);
			if ( StringUtils.isNumeric(value) && Integer.parseInt(value) != -1 )  
				return wkfWorkplanDao.findById(Integer.parseInt(value));
			else throw new RuntimeException("The string value is empty or non-numberic.");
		} catch (Exception ex) {
			logger.warn("Failed to JSF convert string to Work plan object, "+ex.getMessage());
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		try {
			logger.debug("The object value getting from faces context, " + value);
			if ( value != null && value instanceof WkfWorkplan )  
				return String.valueOf( ( ( WkfWorkplan ) value ).getWorkplanId() );
			else throw new RuntimeException("The object value is null or non-WkfWorkplan.class");
		} catch (Exception ex) {
			logger.warn("Failed to JSF convert WkfWorkplan object to string, "+ex.getMessage());
			return null;
		}
	}
}
