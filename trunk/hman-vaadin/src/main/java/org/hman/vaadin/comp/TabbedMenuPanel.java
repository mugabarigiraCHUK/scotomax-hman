package org.hman.vaadin.comp;

import org.hman.vaadin.tabs.AboutusTab;
import org.hman.vaadin.tabs.CareerTab;
import org.hman.vaadin.tabs.HomeTab;
import org.hman.vaadin.tabs.ProductTab;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;
import com.vaadin.ui.TabSheet.Tab;
import com.vaadin.ui.VerticalLayout;

/**
 * 
 * @author scotomax
 *
 */
@SuppressWarnings({"serial", "unused"})
public class TabbedMenuPanel extends VerticalLayout 
								implements TabSheet.SelectedTabChangeListener, 
										   TabSheet.CloseHandler {

	// Logging
	private Logger slf4j = LoggerFactory.getLogger(TabbedMenuPanel.class);

	private final TabSheet tabSheet;
	private final Tab home;
	private final Tab products;
	private final Tab careers;
	private final Tab aboutus;
	
	public TabbedMenuPanel() {
		slf4j.debug(" -> Entering -> Panel -> Constructor method.");
		this.setSizeFull();

        tabSheet = new TabSheet();
        tabSheet.setSizeFull();

        home = tabSheet.addTab(new HomeTab(), "Home", new ThemeResource("../runo/icons/16/arrow-right.png"));
        products = tabSheet.addTab(new ProductTab(), "Product", new ThemeResource("../runo/icons/16/folder.png"));
        careers = tabSheet.addTab(new CareerTab(), "Career", new ThemeResource("../runo/icons/16/users.png"));
        aboutus = tabSheet.addTab(new AboutusTab(), "About us", new ThemeResource("../runo/icons/16/email.png"));

        tabSheet.addListener(this);
        tabSheet.setCloseHandler(this);

        addComponent(tabSheet);

	}

	@Override
	public void onTabClose(TabSheet tabsheet, Component tabContent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectedTabChange(SelectedTabChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
}
