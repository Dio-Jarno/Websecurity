package de.fhb.websecurity.controller.web;

import de.fhb.websecurity.access.file.Logger;
import de.fhb.websecurity.commons.web.HttpRequestActionBase;
import de.fhb.websecurity.commons.web.HttpServletControllerBase;
import de.fhb.websecurity.controller.web.actions.DoLoginAction;
import de.fhb.websecurity.controller.web.actions.DoLogoutAction;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* This servlet is the main controller, which reacts with GET and POST requests.
* It takes the statement from the "do" parameter and pass on to an action.
* 
* @author Arvid Grunenberg
* @author Thomas Habiger
* @date 08.01.2012
* @version 0.1
*/

public class MainController extends HttpServletControllerBase {
	
	private static final long serialVersionUID = 1L;
	
    public MainController() {
        super();
    }
    
    /**
     * Creates and adds all actions to manage a request.
     * 
     * @param config - standard configuration for the servlet
     */
    public void init(ServletConfig config) {
		HttpRequestActionBase action = null;
		this.actions = new HashMap<String, HttpRequestActionBase>();
		
        action = new DoLoginAction();
        this.actions.put("login", action);
        
        action = new DoLogoutAction();
        this.actions.put("logout", action);
    }

    /**
     * Function to react with a GET request.
     * 
     * @param request - HttpServletRequest, which came from the browser
     * @param response - HttpServletResponse, which is sent back to the browser as answer
     */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Logger.getInstance().logInfo(new StringBuffer("GET-Request erhalten von IP: " + request.getHeader("Host")));
        super.doGet(request, response);
	}

	/**
	 * Function to react with a POST request.
	 * 
	 * @param request - HttpServletRequest, which came from the browser
	 * @param response - HttpServletResponse, which is sent back to the browser as answer
	 */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Logger.getInstance().logInfo(new StringBuffer("POST-Request erhalten von IP: " + request.getHeader("Host")));
		super.doPost(request, response);
	}
	
	/**
	 * Returns the statement, which action should be loaded.
	 * 
     * @param request - HttpServletRequest, which came from the browser
	 */
	protected String getOperation(HttpServletRequest request) {
		return request.getParameter("do");
	}

}