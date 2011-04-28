package com.mt.sample.jsf2if2.dto;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import lombok.Data;

public @Data abstract class LocaleBean {

	protected String currentLanguage;
	protected List<SelectItem> availableLocales = new ArrayList<SelectItem>();
}
