package com.itap.callcenter.beans.knw;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import lombok.Data;

/**
 * 
 * @author sevenG.oo7
 *
 */
public @Data abstract class KnwCategoryBean implements Serializable {

	private static final long serialVersionUID = 1002200075598844615L;
	
	protected Integer categoryId;
	protected Integer parentCategoryId;
	protected String categoryName;
	protected String categoryDescription;
	protected Date categoryUpdateDate;
    
	protected Integer selectedCategoryId;
	protected List<SelectItem> selectItemCategoryList;

}
