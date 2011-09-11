package com.itap.callcenter.controller.knw;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itap.callcenter.beans.knw.KnwCategoryBean;
import com.itap.callcenter.dao.apc.knw.KnwCategoryDao;
import com.itap.callcenter.entity.apc.knw.KnwCategory;

/**
 * 
 * @author sevenG.oo7
 *
 */
@ViewScoped
@ManagedBean(name="knwCategoryController")
public class KnwCategoryController extends KnwCategoryBean {

	private static final long serialVersionUID = 217173795400399343L;

	private static Logger logger = LoggerFactory.getLogger(KnwCategoryController.class);
	
	@ManagedProperty(value = "#{knwCategoryDaoImpl}")
	KnwCategoryDao knwCategoryDao;
	
	public void setKnwCategoryDao(KnwCategoryDao knwCategoryDao){
		this.knwCategoryDao = knwCategoryDao;
	}
	
	public void create() {
		logger.debug(">>>>> create()");
		try {
			KnwCategory parentCategory = knwCategoryDao.findById(parentCategoryId);
			
			KnwCategory knwCategory = new KnwCategory();
			knwCategory.setCategoryId(categoryId);
			knwCategory.setParentCategory(parentCategory == null ? null : parentCategory);
			knwCategory.setCategoryName(categoryName);
			knwCategory.setCategoryDescription(categoryDescription);
			knwCategory.setCategoryCreateDate(new Date());
			knwCategory.setCategoryUpdateDate(null);
			
			knwCategoryDao.save(knwCategory);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data been created successfully."));
		} catch (Exception e) {
			logger.error("Exception: "+e.getMessage(), e);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to insert the data into db, Cause: "+e.getMessage()));
		}
		logger.debug("<<<<< create()");
	}
	
	public void update() {
		logger.debug(">>>>> update()");
		try {
			KnwCategory parentCategory = knwCategoryDao.findById(parentCategoryId);
			
			KnwCategory knwCategory = new KnwCategory();
			knwCategory.setCategoryId(categoryId);
			knwCategory.setParentCategory(parentCategory == null ? null : parentCategory);
			knwCategory.setCategoryName(categoryName);
			knwCategory.setCategoryDescription(categoryDescription);
			knwCategory.setCategoryCreateDate(new Date());
			knwCategory.setCategoryUpdateDate(null);
			
			knwCategoryDao.update(knwCategory);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data been updated successfully."));
		} catch (Exception e) {
			logger.error("Exception: "+e.getMessage(), e);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to update the data into db, Cause: "+e.getMessage()));
		}
		logger.debug("<<<<< update()");
	}
	
	public void edit() {
		logger.debug(">>>>> edit()");
		if (selectedCategoryId == null || selectedCategoryId.intValue() == -1) {
			categoryId = null;
			categoryName = null;
			categoryDescription = null;
			categoryUpdateDate = null;
		} else {
			try {
				KnwCategory knwCategory = knwCategoryDao.findById(selectedCategoryId);
				categoryId = knwCategory.getCategoryId();
				categoryName = knwCategory.getCategoryName();
				categoryDescription = knwCategory.getCategoryDescription();
				categoryUpdateDate = knwCategory.getCategoryUpdateDate();
				selectedCategoryId = -1;
			} catch (Exception e) {
				logger.error("Failed to fetch the element data from db, Cause: "+e.getMessage(), e);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to fetch the element data from db, Cause: "+e.getMessage(), "Information"));
			}
		}
		logger.debug("<<<<< edit()");
	}
	
	public void delete() {
		logger.debug(">>>>> delete()");
		try {
			if (selectedCategoryId != null) {
				knwCategoryDao.deleteById(selectedCategoryId);
				selectedCategoryId = -1;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The data been deleted successfully.", "Information"));
			}
		} catch (Exception e) {
			logger.error("Exception: "+e.getMessage(), e);
		}
		logger.debug("<<<<< delete()");
	}
	
	public List<KnwCategory> getKnwCategoryList() {
		logger.debug(">>>>> getKnwCategoryList()");
		List<KnwCategory> knwCategoryList = new ArrayList<KnwCategory>();
		selectItemCategoryList = new ArrayList<SelectItem>();
		try {
			knwCategoryList = knwCategoryDao.findAll();
			if (knwCategoryList != null && knwCategoryList.size() > 0) {
				for (KnwCategory knwCategory : knwCategoryList) {
					SelectItem selectItem = new SelectItem(knwCategory.getCategoryId(), knwCategory.getCategoryName());
					selectItemCategoryList.add(selectItem);
				}
			}
		} catch (Exception e) {
			logger.error("Exception: "+e.getMessage(), e);
		}
		logger.debug("<<<<< getKnwCategoryList()");
		
		return knwCategoryList;
	}
	
}
