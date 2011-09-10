package com.itap.callcenter.mvc.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ivr:param")
@XmlRootElement(name="ivr:param")
public @Data class IvrParamBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1399205333293875965L;
	private String name;
	private String value;
	
}
