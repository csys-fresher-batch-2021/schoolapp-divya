package in.divya.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutActionServlet
 */
@WebServlet("/LogoutActionServlet")

public class LogoutActionServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	/**
    	 * Gets the HTTPSession object.
    	 * And removes the object bound with the specified name(LOGGED_IN_USER) from the session.
    	 * And response passing to the StudentLoginPage.
    	 */
    	
		HttpSession session = request.getSession();
		session.removeAttribute("LOGGED_IN_USER");
		response.sendRedirect("StudentLoginPage.jsp");
	}
}
