/*
 * Copyright 2009 IT Mill Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.hman.vaadin;

import org.hman.vaadin.comp.HeaderCaption;
import org.hman.vaadin.comp.HeaderToolbar;
import org.hman.vaadin.comp.TabbedMenuPanel;

import com.vaadin.Application;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class VaadinApplication extends Application {
	
    // Main window
	private Window window;
	
    @Override
    public void init() {
    	// Set Theme
    	setTheme("reindeer");
    	
    	// Initial Window component
    	window = new Window("H-man Vaadin Application");
    	setMainWindow(window);
        
    	// Set the root layout (VerticalLayout is actually the default).
    	VerticalLayout root = new VerticalLayout();
    	window.setContent(root);
    	
    	// Set root panel full size.
    	window.setSizeFull();
 
    	// Add menu tool bar
    	root.addComponent(new HeaderToolbar());
    	
    	// Add a caption header.
    	root.addComponent(new HeaderCaption());
    	
    	// Add side of tab body
    	root.addComponent(new TabbedMenuPanel());

    }
    
}
