package com.itap.callcenter.mvc.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;

/**
 * 
 * @author scotomax
 *
 */
@XmlRootElement(name="status")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public @Data class XmlIvrStatus implements Serializable {

	private static final long serialVersionUID = -9130172926414801271L;

	@XmlAttribute(name="code")
	private String responseCode;
	
	@XmlAttribute(name="desc")
	private String responseDesc;
	
}
