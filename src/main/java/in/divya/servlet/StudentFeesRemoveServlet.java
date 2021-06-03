package in.divya.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.divya.exceptions.InValidCredentialsException;
import in.divya.service.StudentFeesDetailService;
import in.divya.util.StringValidatorUtil;

/**
 * Servlet implementation class StudentFeesRemoveServlet
 */
@WebServlet("/StudentFeesRemoveServlet")
public class StudentFeesRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentFeesRemoveServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentFeesDetailService studentFeesDetailService = new StudentFeesDetailService();
		try {

			/**
			 * step 1: Get Values
			 */

			String month = request.getParameter("month");
			StringValidatorUtil.isStringNotNullOrEmpty(month, "Cannot Accept Empty and Null Value...Please Enter Nil");
			boolean isFeesDeleted = studentFeesDetailService.deleteFees(month);

			/**
			 * To check student fees are sucessfully delete or not.
			 */
			if (isFeesDeleted) {
				RequestDispatcher rd = request
						.getRequestDispatcher("StudentFeesRemove.jsp?infoMessage=SUCCESSFULLY DELETED");
				rd.forward(request, response);

			} else {
				throw new InValidCredentialsException("FEES NOT FOUND");

			}

		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("StudentFeesRemove.jsp?errorMessage=" + e.getMessage());
			rd.forward(request, response);

		}

	}

}
