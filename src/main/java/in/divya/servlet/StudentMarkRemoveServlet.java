package in.divya.servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.divya.service.MarkCalculationService;
import in.divya.validator.MarkValidator;

/**
 * Servlet implementation class StudentMarkRemoveServlet
 */
@WebServlet("/StudentMarkRemoveServlet")
public class StudentMarkRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			

			/**
			 * To check number as mark using NumberValidator class.
			 */

			String testNumber = request.getParameter("testNumber");
		
			int testNo = MarkValidator.isValidNumberOnly(testNumber, "Invalid Test Number");
			MarkValidator.isNumberPositive(testNo);
		

			boolean isMarkDeleted = MarkCalculationService.deleteStudentMarks(testNo);

			/**
			 * To check student marks are sucessfully delete  or not.
			 */
			if (isMarkDeleted) {
				RequestDispatcher rd=request.getRequestDispatcher("StudentMarkRemove.jsp?infoMessage=SUCCESSFULLY DELETED TEST "+testNo+" MARKS");  
				rd.forward(request, response);

			} else {
				RequestDispatcher rd=request.getRequestDispatcher("StudentMarkRemove.jsp?errorMessage=CANNOT DELETE TEST "+testNo+" MARKS");  
				rd.forward(request, response);
				}

		} catch (Exception e) {
			e.printStackTrace();

		}
		
	}

}
