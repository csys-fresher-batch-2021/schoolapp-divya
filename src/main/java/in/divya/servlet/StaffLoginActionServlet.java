package in.divya.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import in.divya.service.StaffDetailService;

/**
 * Servlet implementation class StaffLoginActionServlet
 */
@WebServlet("/StaffLoginActionServlet")
public class StaffLoginActionServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		/**
		 * Step 1: Get form values
		 */
		
		String staffName = request.getParameter("staffName");
		String staffpassword = request.getParameter("staffPassword");
		
		/**
		 * Step 2: call Service
		 */

		boolean isValid = StaffDetailService.staffValidation(staffName,staffpassword);
		if(isValid)
		{
			HttpSession session = request.getSession();
			session.setAttribute("LOGGED_IN_USER",staffName);
			response.sendRedirect("DisplayStudentInformationListOperations.jsp");
		}
		else 
		{
			response.sendRedirect("StaffLoginPage.jsp?errorMessage=Invalid Login Credentials");
		}
	
	}

}
