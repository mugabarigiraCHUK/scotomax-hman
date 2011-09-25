package com.itap.callcenter.beans.knw;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

/**
 * 
 * @author sevenG.oo7
 *
 */
public class KnwCategoryBean implements Serializable {

	private static final long serialVersionUID = 1002200075598844615L;
	
	private Integer categoryId;
	private Integer parentCategoryId;
	private String categoryName;
	private String categoryDescription;
	private Date categoryCreateDate;
	private Date categoryUpdateDate;
    
	private Integer selectedCategoryId;
	private List<SelectItem> selectItemCategoryList;
	
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getParentCategoryId() {
		return parentCategoryId;
	}
	public void setParentCategoryId(Integer parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	public Date getCategoryCreateDate() {
		return categoryCreateDate;
	}
	public void setCategoryCreateDate(Date categoryCreateDate) {
		this.categoryCreateDate = categoryCreateDate;
	}
	public Date getCategoryUpdateDate() {
		return categoryUpdateDate;
	}
	public void setCategoryUpdateDate(Date categoryUpdateDate) {
		this.categoryUpdateDate = categoryUpdateDate;
	}
	public Integer getSelectedCategoryId() {
		return selectedCategoryId;
	}
	public void setSelectedCategoryId(Integer selectedCategoryId) {
		this.selectedCategoryId = selectedCategoryId;
	}
	public List<SelectItem> getSelectItemCategoryList() {
		return selectItemCategoryList;
	}
	public void setSelectItemCategoryList(List<SelectItem> selectItemCategoryList) {
		this.selectItemCategoryList = selectItemCategoryList;
	}

}
