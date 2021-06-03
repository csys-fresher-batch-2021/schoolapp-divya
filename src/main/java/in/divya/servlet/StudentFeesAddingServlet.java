package in.divya.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.divya.exceptions.CannotAddDetailsException;
import in.divya.model.StudentFeesDetails;
import in.divya.service.StudentFeesDetailService;
import in.divya.util.DateValidatorUtil;
import in.divya.util.StringValidatorUtil;
import in.divya.validator.NumberValidator;
import in.divya.validator.RollNumberValidator;

/**
 * Servlet implementation class StudentFeesAddingServlet
 */
@WebServlet("/StudentFeesAddingServlet")
public class StudentFeesAddingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentFeesAddingServlet() {
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

			StudentFeesDetails fees = new StudentFeesDetails();
			String studentRollNumber = request.getParameter("studentRollNumber");
			String month = request.getParameter("month");
			String studentFees = request.getParameter("amount");
			String date = request.getParameter("receiveDate");

			RollNumberValidator.isValidRollNumberFormat(studentRollNumber, "InValid RollNumber Format");
			StringValidatorUtil.isStringNotNullOrEmpty(month, "Cannot Accept Empty and Null Value...Please Enter Nil");
			int feesAmount = NumberValidator.isValidNumberOnly(studentFees, "Invalid Test Number");
			NumberValidator.isNumberPositive(feesAmount);
			LocalDate receiveDate = DateValidatorUtil.isDateFormatOrNot(date, "InValid Date Format");
			DateValidatorUtil.isNotAFutureDate(receiveDate, "Date cannot be a future date");

			/**
			 * Step 2: Call Service => add student Fees details
			 */

			fees.setStudentRollNumber(studentRollNumber);
			fees.setMonth(month);
			fees.setStudentFees(feesAmount);
			fees.setDate(receiveDate);

			boolean isAddedFees = studentFeesDetailService.addFees(fees);

			/**
			 * Step 3: Decide to which page we should redirect ?
			 */
			if (isAddedFees) {
				String message = "SUCCESSFULLY FEES ADDED";
				response.sendRedirect("StudentFeesAdd.jsp?infoMessage=" + message);

			} else {
				throw new CannotAddDetailsException("Cannot Add Fees");

			}

		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("StudentFeesAdd.jsp?errorMessage=" + e.getMessage());
			rd.forward(request, response);

		}

	}

}
