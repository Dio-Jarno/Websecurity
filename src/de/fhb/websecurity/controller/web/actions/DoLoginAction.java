package de.fhb.websecurity.controller.web.actions;

import de.fhb.websecurity.access.database.DatabaseAccess;
import de.fhb.websecurity.access.file.Logger;
import de.fhb.websecurity.commons.web.HttpRequestActionBase;
import de.fhb.websecurity.data.UserVO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Action to manage a login HttpServletRequest.
 * 
 * @author Arvid Grunenberg, Thomas Habiger
 * @date 30.12.2010
 * @version 0.1
 */

public class DoLoginAction extends HttpRequestActionBase {
	
    private DatabaseAccess databaseAccess;

    
	public DoLoginAction() {
		super();
	}

	/**
     * This function authenticates a user and forwards to a new site.
     * 
     * @param request - HttpServletRequest, which came from the browser. It needs to have the parameters "username" and "password".
     * @param response - HttpServletResponse, which is sent back to the browser as answer.
	 * @throws ServletException When the action cannot forward to the next page, i.e. this page is not availably.
     */
    public void perform(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String jsp = null;
    	UserVO user;
        String username = request.getParameter("username");
        request.setAttribute("username", username);
        String password = request.getParameter("password");
        request.setAttribute("password", password);
    	databaseAccess = new DatabaseAccess();
        user = databaseAccess.login(username, password);
        try {
        	if (user == null) {
        		request.setAttribute("message", "Der Benutzername und das Passwort sind falsch.");
        		Logger.getInstance().logWarning(new StringBuffer("Unbekannter Benutzer '"+username+"' hat sich mit Password '"+password+"' versucht anzumelden."));
        		jsp = "res/jsp/error/errorLogin.jsp";
        	} else if (user.getRole() == null) {
        		request.setAttribute("message", "Das Passwort ist falsch.");
	        	Logger.getInstance().logWarning(new StringBuffer("Der Benutzer '"+username+"' konnte sich mit dem Password '"+password+"' nicht anmelden."));
	        	jsp = "res/jsp/error/errorLogin.jsp";
        	} else {
        		request.setAttribute("user", user);
        		request.setAttribute("path", Logger.getInstance().getPath());
        		Logger.getInstance().logInfo(new StringBuffer("Der Benutzer '"+username+"' hat sich erfolgreich angemeldet mit dem Password: "+password));
	        	jsp = "res/jsp/secret.jsp";
        	}
        	forward(request, response, jsp);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Foward file '"+jsp+"' was not found.");
        } catch (NullPointerException e) {
        	e.printStackTrace();
        }
	}
	
}