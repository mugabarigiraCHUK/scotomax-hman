package com.itap.callcenter.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itap.callcenter.controller.crm.CrmCustomerController;
import com.itap.callcenter.dao.apc.crm.CrmCustomerDao;
import com.itap.callcenter.entity.apc.crm.CrmCustomer;


/**
 * 
 * @author phamon
 *
 */
@ViewScoped
@ManagedBean(name = "mockupCrmCustomerController")
public class MockupCrmCustomerController extends PagingController implements Serializable {
	
	private Logger logger = LoggerFactory.getLogger(MockupCrmCustomerController.class);

	private List<CrmCustomer> listCrmCustomer;
	
	@ManagedProperty(value="#{crmCustomerDaoImpl}")
	private CrmCustomerDao crmCustomerDao;
	
	
	@PostConstruct
	public void init() {
		logger.debug("postConstruct, initial page");
		rowsPerPage = 5;
		search();
	}


	@Override
	public void search() {
		listCrmCustomer = crmCustomerDao.findAll(firstRow, rowsPerPage);
		totalRows = crmCustomerDao.countFindAll();
		logger.debug("currentPage: " + currentPage);
		logger.debug("totalRows: " + totalRows);
		logger.debug("range: " + getFirstRow() + " - " + getLastRow());
	}

	
	// Getter & Setter
	public List<CrmCustomer> getListCrmCustomer() {
		return listCrmCustomer;
	}

	public void setListCrmCustomer(List<CrmCustomer> listCrmCustomer) {
		this.listCrmCustomer = listCrmCustomer;
	}

	public CrmCustomerDao getCrmCustomerDao() {
		return crmCustomerDao;
	}

	public void setCrmCustomerDao(CrmCustomerDao crmCustomerDao) {
		this.crmCustomerDao = crmCustomerDao;
	}
	
	
	
	
}
