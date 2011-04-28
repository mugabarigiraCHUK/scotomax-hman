package com.mt.sample.jsf2if2.dto;

import lombok.Data;

public @Data abstract class NavigationBean {

	protected Boolean extendedRender = true;
	protected Boolean customRender = true;
	protected Boolean tableRender = true;
	protected Boolean layoutRender = true;
}
