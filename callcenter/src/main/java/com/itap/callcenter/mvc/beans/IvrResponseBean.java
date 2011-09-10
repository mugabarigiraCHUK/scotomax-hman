package com.itap.callcenter.mvc.beans;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Data;

@XStreamAlias("ivr:response")
@XmlRootElement(name="ivr:response")
public @Data class IvrResponseBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4632733481424627141L;
	private List<IvrParamBean> params;
	private String responseCode;
	private String responseDesc;
	
}
