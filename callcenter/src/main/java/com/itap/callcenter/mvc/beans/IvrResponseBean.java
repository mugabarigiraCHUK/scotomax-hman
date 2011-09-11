package com.itap.callcenter.mvc.beans;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

public @Data class IvrResponseBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4632733481424627141L;
	private List<IvrParamBean> params;
	private String responseCode;
	private String responseDesc;
	
}
