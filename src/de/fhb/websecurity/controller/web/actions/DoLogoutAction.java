package de.fhb.websecurity.controller.web.actions;

import de.fhb.websecurity.access.file.Logger;
import de.fhb.websecurity.commons.web.HttpRequestActionBase;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Action to manage a logout HttpServletRequest.
 * 
 * @author Arvid Grunenberg, Thomas Habiger
 * @date 30.12.2011
 * @version 0.1
 */
public class DoLogoutAction extends HttpRequestActionBase {
	
    
	public DoLogoutAction() {
		super();
	}

	/**
     * This function forwards a user to the main site.
     * 
     * @param request - HttpServletRequest, which came from the browser. It needs to have the parameter "username".
     * @param response - HttpServletResponse, which is sent back to the browser as answer.
	 * @throws ServletException When the action cannot forward to the main page, i.e. the site is not availably.
     */
    public void perform(HttpServletRequest request, HttpServletResponse response) throws ServletException {
    	String user = request.getParameter("username");
        try {
        	Logger.getInstance().logInfo(new StringBuffer("Der Benutzer '"+user+"' hat sich erfolgreich abgemeldet."));
        	forward(request, response, "index.html");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Foward file was not found.");
        } catch (NullPointerException e) {
        	e.printStackTrace();
        }
	}
	
}