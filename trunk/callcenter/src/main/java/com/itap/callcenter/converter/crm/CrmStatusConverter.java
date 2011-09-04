package com.itap.callcenter.converter.crm;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.jsf.FacesContextUtils;

import com.itap.callcenter.dao.apc.crm.CrmStatusDao;
import com.itap.callcenter.entity.apc.crm.CrmStatus;

/**
 * 
 * @author phamon
 *
 */
@FacesConverter("crmStatusConverter")
public class CrmStatusConverter implements Converter {
	
	private static Logger logger = LoggerFactory.getLogger(CrmStatusConverter.class.getPackage().getName());

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		logger.debug("value: " + value + " to " + CrmStatus.class.getSimpleName());
		try {
			CrmStatusDao crmStatusDao = (CrmStatusDao) FacesContextUtils.getWebApplicationContext(context).getBean("crmStatusDaoImpl");
			return crmStatusDao.findById(Integer.parseInt(value));
		} catch (Exception e) {
			logger.error("The string value is empty or non-numberic.");
			return null;
		}
	}
	
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if ( value != null && value instanceof CrmStatus )  
			return String.valueOf( ( ( CrmStatus ) value ).getStatusId() );
		else {
			logger.error("The object value is null or non " + CrmStatus.class.getSimpleName());
			return null;
		}
		
	}

}
