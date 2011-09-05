package com.itap.callcenter.converter.crm;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.jsf.FacesContextUtils;

import com.itap.callcenter.dao.apc.crm.CrmCustomerDao;
import com.itap.callcenter.entity.apc.crm.CrmCustomer;

/**
 * 
 * @author scotomax
 *
 */
@FacesConverter("crmCustomerConverter")
public class CrmCustomerConverter implements Converter {

	// SLF4J logger
	Logger logger = LoggerFactory.getLogger(CrmCustomerConverter.class);
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		try {
			logger.debug("The string value getting from faces context, " + value);
			if ( StringUtils.isNumeric(value) && Integer.parseInt(value) != -1 )  {
				CrmCustomerDao crmCustomerDao = (CrmCustomerDao) FacesContextUtils.getWebApplicationContext(context).getBean("crmCustomerDaoImpl");
				return crmCustomerDao.findById(Integer.parseInt(value));
			} else throw new RuntimeException("The string value is empty or non-numberic.");
		} catch (Exception ex) {
			logger.warn("Failed to JSF convert string to CrmCustomer object, "+ex.getMessage());
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		try {
			if ( value != null && value instanceof CrmCustomer )  
				return String.valueOf( ( ( CrmCustomer ) value ).getCustomerId() );
			else throw new RuntimeException("The object value is null or non-CrmCustomer.class");
		} catch (Exception ex) {
			logger.warn("Failed to JSF convert CrmCustomer object to string, "+ex.getMessage());
			return null;
		}
	}
}
