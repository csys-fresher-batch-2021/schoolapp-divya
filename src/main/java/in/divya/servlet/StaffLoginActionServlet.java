package in.divya.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.divya.exceptions.InValidCredentialsException;
import in.divya.service.StaffDetailService;
import in.divya.util.PasswordValidatorUtil;
import in.divya.util.StringValidatorUtil;

/**
 * Servlet implementation class StaffLoginActionServlet
 */
@WebServlet("/StaffLoginActionServlet")
public class StaffLoginActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StaffDetailService staffDetailService = new StaffDetailService();
		/**
		 * Step 1: Get form values
		 */
		try {
			String staffName = request.getParameter("staffName");
			String staffPassword = request.getParameter("staffPassword");
			StringValidatorUtil.isStringNotNullOrEmpty(staffName, "Invalid RollNumber Format");
			PasswordValidatorUtil.isValidPasswordFormat(staffPassword, "Invalid Password Format");
			/**
			 * Step 2: call Service
			 */
			boolean isValidStudent = staffDetailService.staffValidation(staffName, staffPassword);
			if (isValidStudent) {
				HttpSession session = request.getSession();
				session.setAttribute("LOGGED_IN_USER", staffName);
				RequestDispatcher rd = request.getRequestDispatcher("DisplayStaffHomePage.jsp");
				rd.forward(request, response);
			} else {
				throw new InValidCredentialsException("Invalid Staff Credentials");
			}
		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("StaffLoginPage.jsp?errorMessage=" + e.getMessage());
			rd.forward(request, response);

		}
	}

}
