package com.itap.callcenter.converter.crm;

import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itap.callcenter.dao.apc.crm.CrmBusinessDao;
import com.itap.callcenter.entity.apc.crm.CrmBusiness;

/**
 * 
 * @author scotomax
 *
 */
@FacesConverter("crmBusinessConverter")
public class CrmBusinessConverter implements Converter {

	// SLF4J logger
	Logger logger = LoggerFactory.getLogger(CrmBusinessConverter.class);
	// CRM business DAO
	@ManagedProperty(value="#{crmBusinessDaoImpl}")
	CrmBusinessDao crmBusinessDao;
	
	public void setCrmBusinessDao(CrmBusinessDao crmBusinessDao) {
		this.crmBusinessDao = crmBusinessDao;
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		try {
			logger.debug("The string value getting from faces context, " + value);
			if ( StringUtils.isNumeric(value) && Integer.parseInt(value) != -1 )  
				return crmBusinessDao.findById(Integer.parseInt(value));
			else throw new RuntimeException("The string value is empty or non-numberic.");
		} catch (Exception ex) {
			logger.warn("Failed to JSF convert string to CrmBusiness object, "+ex.getMessage());
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		try {
			logger.debug("The object value getting from faces context, " + value);
			if ( value != null && value instanceof CrmBusiness )  
				return String.valueOf( ( ( CrmBusiness ) value ).getBusinessId() );
			else throw new RuntimeException("The object value is null or non-CrmBusiness.class");
		} catch (Exception ex) {
			logger.warn("Failed to JSF convert CrmBusiness object to string, "+ex.getMessage());
			return null;
		}
	}

}
