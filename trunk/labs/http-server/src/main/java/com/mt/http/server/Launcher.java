package com.mt.http.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mortbay.jetty.Handler;
import org.mortbay.jetty.Request;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.AbstractHandler;

public class Launcher {

	Handler handler;
	Server server;
	
	int HTTP_SERVER_PORT = 8080;
	
	/**
	 * Constructor method
	 */
	public Launcher() {
		
	}
	
	/**
	 * Launcher
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Launcher launcher = new Launcher();
		launcher.init();
	}
	
	/**
	 * Initial handling Servlet listener and
	 * startup HTTP listener
	 * 
	 * @throws Exception
	 */
	public void init() throws Exception {
		// Initial Servlet listener handle method.
		handler = new AbstractHandler() {
			@Override
			public void handle(String target, HttpServletRequest request,
					HttpServletResponse response, int dispatch) throws IOException,
					ServletException {
				// TODO Auto-generated method stub
				
				response.setContentType("text/html");
		        response.setStatus(HttpServletResponse.SC_OK);
		        response.getWriter().println("<h1>Hello</h1>");
		        
		        ((Request)request).setHandled(true);
			}
		};
		// Start HTTP listener
		server = new Server(HTTP_SERVER_PORT);
		server.setHandler(handler);
		server.start();

	}

}
