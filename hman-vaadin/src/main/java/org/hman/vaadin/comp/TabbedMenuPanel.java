package org.hman.vaadin.comp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;
import com.vaadin.ui.TabSheet.Tab;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
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
		
		// Tab 1 content
        VerticalLayout l1 = new VerticalLayout();
        l1.setSizeFull();
        l1.setMargin(true);
        l1.addComponent(new Label("Welcome to Hman-Vaadin application"));
        
        // Tab 2 content
        VerticalLayout l2 = new VerticalLayout();
        l2.setSizeFull();
        l2.setMargin(true);
        l2.addComponent(new Label("Page information for product"));
        
        // Tab 3 content
        VerticalLayout l3 = new VerticalLayout();
        l3.setSizeFull();
        l3.setMargin(true);
        l3.addComponent(new Label("Page information for Careers part"));
        
        // Tab 4 content
        VerticalLayout l4 = new VerticalLayout();
        l4.setSizeFull();
        l4.setMargin(true);
        l4.addComponent(new Label("Page information for About us"));
        

        tabSheet = new TabSheet();
        tabSheet.setSizeFull();

        home = tabSheet.addTab(l1, "Home", new ThemeResource("../runo/icons/16/arrow-right.png"));
        products = tabSheet.addTab(l2, "Product", new ThemeResource("../runo/icons/16/folder.png"));
        careers = tabSheet.addTab(l3, "Career", new ThemeResource("../runo/icons/16/users.png"));
        aboutus = tabSheet.addTab(l4, "About us", new ThemeResource("../runo/icons/16/email.png"));

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
