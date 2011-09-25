package com.itap.callcenter.controller.knw;

import java.io.Serializable;
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

import com.itap.callcenter.beans.knw.KnwCategoryBean;
import com.itap.callcenter.beans.knw.KnwTopicBean;
import com.itap.callcenter.dao.apc.knw.KnwCategoryDao;
import com.itap.callcenter.dao.apc.knw.KnwTopicDao;
import com.itap.callcenter.entity.apc.knw.KnwCategory;

/**
 * 
 * @author sevenG.oo7
 *
 */
@ViewScoped
@ManagedBean(name="knwKnowledgeController")
public class KnwKnowledgeController implements Serializable {

	private static final long serialVersionUID = -1977322647881570637L;
	
	private static final Logger logger = LoggerFactory.getLogger(KnwKnowledgeController.class);
	
	private String page;

	private KnwCategoryBean knwCategoryBean;
	
	private List<KnwCategory> knwCategoryList;
	
	@ManagedProperty(value = "#{knwCategoryDaoImpl}")
	KnwCategoryDao knwCategoryDao;
	
	private KnwTopicBean knwTopicBean;
	
	private List<KnwTopicBean> knwTopicBeans;
	
	@ManagedProperty(value = "#{KnwTopicDaoImpl}")
	KnwTopicDao knwTopicDao;
	
	@PostConstruct
	public void init() {
		page = "category";
		knwCategoryBean = new KnwCategoryBean();
		knwCategoryList = new ArrayList<KnwCategory>();
	}
	
	public void createCategory() {
		logger.debug(">>>>> createCategory()");
		try {
			KnwCategory parentCategory = knwCategoryDao.findById(knwCategoryBean.getParentCategoryId());
			
			KnwCategory knwCategory = new KnwCategory();
			knwCategory.setCategoryId(knwCategoryBean.getCategoryId());
			knwCategory.setParentCategory(parentCategory == null ? null : parentCategory);
			knwCategory.setCategoryName(knwCategoryBean.getCategoryName());
			knwCategory.setCategoryDescription(knwCategoryBean.getCategoryDescription());
			knwCategory.setCategoryCreateDate(new Date());
			knwCategory.setCategoryUpdateDate(null);
			
			knwCategoryDao.save(knwCategory);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data been created successfully."));
		} catch (Exception e) {
			logger.error("Exception: "+e.getMessage(), e);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to insert the data into db, Cause: "+e.getMessage()));
		}
		logger.debug("<<<<< createCategory()");
	}
	
	public void updateCategory() {
		logger.debug(">>>>> updateCategory()");
		try {
			KnwCategory parentCategory = knwCategoryDao.findById(knwCategoryBean.getParentCategoryId());
			
			KnwCategory knwCategory = new KnwCategory();
			knwCategory.setCategoryId(knwCategoryBean.getCategoryId());
			knwCategory.setParentCategory(parentCategory == null ? null : parentCategory);
			knwCategory.setCategoryName(knwCategoryBean.getCategoryName());
			knwCategory.setCategoryDescription(knwCategoryBean.getCategoryDescription());
			knwCategory.setCategoryCreateDate(knwCategoryBean.getCategoryCreateDate());
			knwCategory.setCategoryUpdateDate(new Date());
			
			knwCategoryDao.update(knwCategory);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data been updated successfully."));
		} catch (Exception e) {
			logger.error("Exception: "+e.getMessage(), e);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to update the data into db, Cause: "+e.getMessage()));
		}
		logger.debug("<<<<< updateCategory()");
	}
	
	public void editCategory() {
		logger.debug(">>>>> editCategory()");
		if (knwCategoryBean.getSelectedCategoryId() == null || knwCategoryBean.getSelectedCategoryId().intValue() == -1) {
			knwCategoryBean.setCategoryId(null);
			knwCategoryBean.setCategoryName(null);
			knwCategoryBean.setCategoryDescription(null);
			knwCategoryBean.setCategoryUpdateDate(null);
		} else {
			try {
				KnwCategory knwCategory = knwCategoryDao.findById(knwCategoryBean.getSelectedCategoryId());
				knwCategoryBean.setCategoryId(knwCategory.getCategoryId());
				knwCategoryBean.setCategoryName(knwCategory.getCategoryName());
				knwCategoryBean.setCategoryDescription(knwCategory.getCategoryDescription());
				knwCategoryBean.setCategoryCreateDate(knwCategory.getCategoryCreateDate());
				knwCategoryBean.setCategoryUpdateDate(knwCategory.getCategoryUpdateDate());
				knwCategoryBean.setSelectedCategoryId(-1);
			} catch (Exception e) {
				logger.error("Failed to fetch the element data from db, Cause: "+e.getMessage(), e);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to fetch the element data from db, Cause: "+e.getMessage(), "Information"));
			}
		}
		logger.debug("<<<<< editCategory()");
	}
	
	public void deleteCategory() {
		logger.debug(">>>>> deleteCategory()");
		try {
			if (knwCategoryBean.getSelectedCategoryId() != null) {
				knwCategoryDao.deleteById(knwCategoryBean.getSelectedCategoryId());
				knwCategoryBean.setSelectedCategoryId(-1);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The data been deleted successfully.", "Information"));
			}
		} catch (Exception e) {
			logger.error("Exception: "+e.getMessage(), e);
		}
		logger.debug("<<<<< deleteCategory()");
	}
	
	public void goToTopic() {
		logger.debug(">>>>> deleteCategory()");
		page = "topic";
		try {
			if (knwCategoryBean.getSelectedCategoryId() != null) {
				//TODO: find topic by selectedCategoryId
			}
		} catch (Exception e) {
			logger.error("Exception: "+e.getMessage(), e);
		}
		logger.debug("<<<<< deleteCategory()");
	}
	
	public void createTopic() {
		logger.debug(">>>>> createTopic()");
//		try {
//			KnwCategory parentCategory = knwCategoryDao.findById(knwCategoryBean.getParentCategoryId());
//			
//			KnwCategory knwCategory = new KnwCategory();
//			knwCategory.setCategoryId(knwCategoryBean.getCategoryId());
//			knwCategory.setParentCategory(parentCategory == null ? null : parentCategory);
//			knwCategory.setCategoryName(knwCategoryBean.getCategoryName());
//			knwCategory.setCategoryDescription(knwCategoryBean.getCategoryDescription());
//			knwCategory.setCategoryCreateDate(new Date());
//			knwCategory.setCategoryUpdateDate(null);
//			
//			knwCategoryDao.save(knwCategory);
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data been created successfully."));
//		} catch (Exception e) {
//			logger.error("Exception: "+e.getMessage(), e);
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to insert the data into db, Cause: "+e.getMessage()));
//		}
		logger.debug("<<<<< createTopic()");
	}
	
	public void updateTopic() {
		logger.debug(">>>>> updateTopic()");
//		try {
//			KnwCategory parentCategory = knwCategoryDao.findById(knwCategoryBean.getParentCategoryId());
//			
//			KnwCategory knwCategory = new KnwCategory();
//			knwCategory.setCategoryId(knwCategoryBean.getCategoryId());
//			knwCategory.setParentCategory(parentCategory == null ? null : parentCategory);
//			knwCategory.setCategoryName(knwCategoryBean.getCategoryName());
//			knwCategory.setCategoryDescription(knwCategoryBean.getCategoryDescription());
//			knwCategory.setCategoryCreateDate(knwCategoryBean.getCategoryCreateDate());
//			knwCategory.setCategoryUpdateDate(new Date());
//			
//			knwCategoryDao.update(knwCategory);
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data been updated successfully."));
//		} catch (Exception e) {
//			logger.error("Exception: "+e.getMessage(), e);
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to update the data into db, Cause: "+e.getMessage()));
//		}
		logger.debug("<<<<< updateTopic()");
	}
	
	public void editTopic() {
		logger.debug(">>>>> editTopic()");
//		if (knwCategoryBean.getSelectedCategoryId() == null || knwCategoryBean.getSelectedCategoryId().intValue() == -1) {
//			knwCategoryBean.setCategoryId(null);
//			knwCategoryBean.setCategoryName(null);
//			knwCategoryBean.setCategoryDescription(null);
//			knwCategoryBean.setCategoryUpdateDate(null);
//		} else {
//			try {
//				KnwCategory knwCategory = knwCategoryDao.findById(knwCategoryBean.getSelectedCategoryId());
//				knwCategoryBean.setCategoryId(knwCategory.getCategoryId());
//				knwCategoryBean.setCategoryName(knwCategory.getCategoryName());
//				knwCategoryBean.setCategoryDescription(knwCategory.getCategoryDescription());
//				knwCategoryBean.setCategoryCreateDate(knwCategory.getCategoryCreateDate());
//				knwCategoryBean.setCategoryUpdateDate(knwCategory.getCategoryUpdateDate());
//				knwCategoryBean.setSelectedCategoryId(-1);
//			} catch (Exception e) {
//				logger.error("Failed to fetch the element data from db, Cause: "+e.getMessage(), e);
//				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to fetch the element data from db, Cause: "+e.getMessage(), "Information"));
//			}
//		}
		logger.debug("<<<<< editTopic()");
	}
	
	public void deleteTopic() {
		logger.debug(">>>>> deleteTopic()");
//		try {
//			if (knwCategoryBean.getSelectedCategoryId() != null) {
//				knwCategoryDao.deleteById(knwCategoryBean.getSelectedCategoryId());
//				knwCategoryBean.setSelectedCategoryId(-1);
//				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The data been deleted successfully.", "Information"));
//			}
//		} catch (Exception e) {
//			logger.error("Exception: "+e.getMessage(), e);
//		}
		logger.debug("<<<<< deleteTopic()");
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public KnwCategoryBean getKnwCategoryBean() {
		return knwCategoryBean;
	}

	public void setKnwCategoryBean(KnwCategoryBean knwCategoryBean) {
		this.knwCategoryBean = knwCategoryBean;
	}

	public List<KnwCategory> getKnwCategoryList() {
		List<SelectItem> selectItemCategoryList = new ArrayList<SelectItem>();
		try {
			knwCategoryList = knwCategoryDao.findAll();
			if (knwCategoryList != null && knwCategoryList.size() > 0) {
				for (KnwCategory knwCategory : knwCategoryList) {
					SelectItem selectItem = new SelectItem(knwCategory.getCategoryId(), knwCategory.getCategoryName());
					selectItemCategoryList.add(selectItem);
				}
			}
			knwCategoryBean.setSelectItemCategoryList(selectItemCategoryList);
		} catch (Exception e) {
			logger.error("Exception: "+e.getMessage(), e);
		}
		
		return knwCategoryList;
	}

	public void setKnwCategoryList(List<KnwCategory> knwCategoryList) {
		this.knwCategoryList = knwCategoryList;
	}
	
	public void setKnwCategoryDao(KnwCategoryDao knwCategoryDao){
		this.knwCategoryDao = knwCategoryDao;
	}

	public KnwTopicBean getKnwTopicBean() {
		return knwTopicBean;
	}

	public void setKnwTopicBean(KnwTopicBean knwTopicBean) {
		this.knwTopicBean = knwTopicBean;
	}

	public List<KnwTopicBean> getKnwTopicBeans() {
		return knwTopicBeans;
	}

	public void setKnwTopicBeans(List<KnwTopicBean> knwTopicBeans) {
		this.knwTopicBeans = knwTopicBeans;
	}

	public void setKnwTopicDao(KnwTopicDao knwTopicDao) {
		this.knwTopicDao = knwTopicDao;
	}
	
}
