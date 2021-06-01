package in.divya.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.divya.exceptions.InValidCredentialsException;
import in.divya.service.StudentAttendanceService;
import in.divya.util.DateValidatorUtil;

/**
 * Servlet implementation class StudentAttendanceRemoveServlet
 */
@WebServlet("/StudentAttendanceRemoveServlet")
public class StudentAttendanceRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentAttendanceRemoveServlet() {
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
			String date = request.getParameter("dateOfAttendance");

			LocalDate attendanceDate = DateValidatorUtil.isDateFormatOrNot(date, "InValid Date Format");
			DateValidatorUtil.isNotAFutureDate(attendanceDate, "Date cannot be a future date");

			boolean isAttendanceDeleted = StudentAttendanceService.deleteStudentAttendance(attendanceDate);

			/**
			 * To check student Attendance are sucessfully delete or not.
			 */
			if (isAttendanceDeleted) {
				RequestDispatcher rd = request
						.getRequestDispatcher("StudentAttendanceRemove.jsp?infoMessage=SUCCESSFULLY DELETED");
				rd.forward(request, response);

			} else {
				throw new InValidCredentialsException("DATE OF ATTENDANCE NOT FOUND");

			}

		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = request
					.getRequestDispatcher("StudentAttendanceRemove.jsp?errorMessage=DATE OF ATTENDANCE NOT FOUND");
			rd.forward(request, response);

		}

	}

}
