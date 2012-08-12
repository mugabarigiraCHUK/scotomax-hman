package com.mt.sample.jsf2if2.dto;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

public abstract class LocaleBean {

	protected String currentLanguage;
	protected List<SelectItem> availableLocales = new ArrayList<SelectItem>();
	
	public String getCurrentLanguage() {
		return currentLanguage;
	}
	public void setCurrentLanguage(String currentLanguage) {
		this.currentLanguage = currentLanguage;
	}
	public List<SelectItem> getAvailableLocales() {
		return availableLocales;
	}
	public void setAvailableLocales(List<SelectItem> availableLocales) {
		this.availableLocales = availableLocales;
	}
	
	
}
