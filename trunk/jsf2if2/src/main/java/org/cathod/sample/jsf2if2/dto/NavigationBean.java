package org.cathod.sample.jsf2if2.dto;

public abstract class NavigationBean {

	protected Boolean extendedRender = true;
	protected Boolean customRender = true;
	protected Boolean tableRender = true;
	protected Boolean layoutRender = true;
	
	public Boolean getExtendedRender() {
		return extendedRender;
	}
	public void setExtendedRender(Boolean extendedRender) {
		this.extendedRender = extendedRender;
	}
	public Boolean getCustomRender() {
		return customRender;
	}
	public void setCustomRender(Boolean customRender) {
		this.customRender = customRender;
	}
	public Boolean getTableRender() {
		return tableRender;
	}
	public void setTableRender(Boolean tableRender) {
		this.tableRender = tableRender;
	}
	public Boolean getLayoutRender() {
		return layoutRender;
	}
	public void setLayoutRender(Boolean layoutRender) {
		this.layoutRender = layoutRender;
	}
	
}
