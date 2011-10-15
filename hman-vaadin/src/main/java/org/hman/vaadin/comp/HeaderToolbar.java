package org.hman.vaadin.comp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.themes.Reindeer;
import com.vaadin.ui.VerticalLayout;

/**
 * Header Toolbar
 * 
 * @author scotomax
 *
 */
@SuppressWarnings("serial")
public class HeaderToolbar extends VerticalLayout {

	// Logging
	private Logger slf4j = LoggerFactory.getLogger(HeaderToolbar.class);
	// Components
	private final MenuBar menubar = new MenuBar();
	private final MenuBar.MenuItem account;
	private final MenuBar.MenuItem profile;
	private final MenuBar.MenuItem settings;

	public HeaderToolbar() {
		slf4j.debug(" -> Entering -> CssLayout -> Main Menu Bar -> Constructor method.");
		
		setWidth(100, UNITS_PERCENTAGE);
		setStyleName(Reindeer.LAYOUT_BLACK);
		addStyleName("header-menu-bar");
		
		// Individual items so we can add sub-menu items to
		// User name
		account = menubar.addItem("developmax@gmail.com", null);
		// Profile
		profile = menubar.addItem("Profile", new ThemeResource("../runo/icons/16/user.png"), null);
		profile.addItem("Edit", menuCommand);
		profile.addSeparator();
		profile.addItem("Sign-out", menuCommand);
		profile.addItem("In-activation", menuCommand);
		// Setting
		settings = menubar.addItem("Setting", new ThemeResource("../runo/icons/16/settings.png"), null);
		settings.addItem("Language", menuCommand);
		settings.addItem("Picture", menuCommand);

		menubar.setStyleName("header-menu-bar");
        addComponent(menubar);

	}
	
	private Command menuCommand = new Command() {
        public void menuSelected(MenuItem selectedItem) {
            getWindow().showNotification("Action " + selectedItem.getText());
        }
    };

}
