package in.divya.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import in.divya.service.StudentDetailService;

/**
 * Servlet implementation class LoginActionServlet
 */

@WebServlet("/LoginActionServlet")

public class StudentLoginActionServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		/**
		 * Step 1: Get form values
		 */
		
		String studentName = request.getParameter("studentName");
		String studentRollNumber = request.getParameter("studentRollNumber");
		String studentpassword = request.getParameter("studentPassword");
		
		/**
		 * Step 2: call Service
		 */
		
		boolean isValid = StudentDetailService.studentValidation(studentName,studentRollNumber,studentpassword);
		if(isValid)
		{
			HttpSession session = request.getSession();
			session.setAttribute("LOGGED_IN_USER",studentName);
			session.setAttribute("LOGGED_IN_USER_NO",studentRollNumber);

			response.sendRedirect("DisplayStudentInformationList.jsp");
		}
		else 
		{
			response.sendRedirect("StudentLoginPage.jsp?errorMessage=Invalid Login Credentials");
		}
	}
	
	
		
}

	

