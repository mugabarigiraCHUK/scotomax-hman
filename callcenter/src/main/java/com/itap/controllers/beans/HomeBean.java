package com.itap.controllers.beans;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @author scotomax
 *
 */
public @Data abstract class HomeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8421487378461350183L;
	
	protected String username;
	protected String password;
	protected String message;
	
}
