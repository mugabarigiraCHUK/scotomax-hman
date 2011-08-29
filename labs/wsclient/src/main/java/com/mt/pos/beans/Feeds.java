package com.mt.pos.beans;

import java.io.Serializable;

public class Feeds implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3613208639407983415L;

	private String subject;
	private String content;
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
