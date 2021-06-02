package in.divya.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.divya.util.DateValidatorUtil;

/**
 * Servlet implementation class StudentAttendanceViewServlet
 */
@WebServlet("/StudentAttendanceViewServlet")
public class StudentAttendanceViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentAttendanceViewServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			/**
			 * To get value
			 */
			boolean isValid = true;
			String date = request.getParameter("dateOfAttendance");
			LocalDate attendanceDate = DateValidatorUtil.isDateFormatOrNot(date, "InValid Date Format");
			isValid = DateValidatorUtil.isNotAFutureDate(attendanceDate, "Date cannot be a future date");
			if (isValid) {
				RequestDispatcher rd = request
						.getRequestDispatcher("AllStudentAttendanceDisplay.jsp?attendanceDate=" + attendanceDate);
				rd.forward(request, response);

			}

		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = request
					.getRequestDispatcher("AllStudentAttendanceCall.jsp?errorMessage=" + e.getMessage());
			rd.forward(request, response);

		}

	}
};