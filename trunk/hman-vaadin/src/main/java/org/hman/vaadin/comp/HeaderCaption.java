package org.hman.vaadin.comp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

/**
 * Side navigation bar
 * 
 * @author scotomax
 *
 */
@SuppressWarnings("serial")
public class HeaderCaption extends VerticalLayout {

	// Logging
	private Logger slf4j = LoggerFactory.getLogger(HeaderCaption.class);
	
	// Components
	private final Label captionHeader;
	
	/*
	 * Constructor-method
	 */
	public HeaderCaption() {
		slf4j.debug(" -> Entering -> CssLayout -> Side Navigation Bar -> Constructor method.");
		this.setStyleName(Reindeer.LAYOUT_BLACK);
		this.setWidth(100, UNITS_PERCENTAGE);
		this.setMargin(true);
		
		captionHeader = new Label("Hman-Vaadin Application");
		captionHeader.setStyleName("h1");
    	this.addComponent(captionHeader);
	}
}
