package org.hman.vaadin.tabs;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.ui.InlineDateField;
import com.vaadin.ui.VerticalLayout;

/**
 * 
 * @author scotomax
 *
 */
@SuppressWarnings("serial")
public class HomeTab extends VerticalLayout {
	
	// Logging
	private Logger slf4j = LoggerFactory.getLogger(HomeTab.class);

	private InlineDateField datetime;
	
	public HomeTab() {
		
		slf4j.debug("Entering Home tab initialize...");
		
		setSizeFull();
        setMargin(true);
		setSpacing(true);
		// Initial In line date field
        datetime = new InlineDateField("Please select the starting time:");
        // Set the value of the PopupDateField to current date
        datetime.setValue(new Date());
        // Set the correct resolution
        datetime.setResolution(InlineDateField.RESOLUTION_MIN);
        datetime.setImmediate(true);
        // Add component into view
        addComponent(datetime);
    }
	
}
