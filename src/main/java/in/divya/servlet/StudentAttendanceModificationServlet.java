package in.divya.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.divya.exceptions.CannotRegisterStudentException;
import in.divya.model.StudentAttendanceDetails;
import in.divya.service.StudentAttendanceService;
import in.divya.util.DateValidatorUtil;
import in.divya.util.StringValidatorUtil;
import in.divya.util.TimeValidatorUtil;
import in.divya.validator.RollNumberValidator;

/**
 * Servlet implementation class StudentAttendanceModificationServlet
 */
@WebServlet("/StudentAttendanceModificationServlet")
public class StudentAttendanceModificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentAttendanceModificationServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentAttendanceService studentAttendanceService = new StudentAttendanceService();

		try {

			/**
			 * step 1: Get Values
			 */

			StudentAttendanceDetails attendance = new StudentAttendanceDetails();
			String studentRollNumber = request.getParameter("rollNumber");
			String date = request.getParameter("dateOfAttendance");
			String studentAttendance = request.getParameter("studentAttendance");
			String inTime = request.getParameter("inTime");
			String outTime = request.getParameter("outTime");
			String studentReason = request.getParameter("reason");

			RollNumberValidator.isValidRollNumberFormat(studentRollNumber, "InValid RollNumber Format");
			LocalDate attendanceDate = DateValidatorUtil.isDateFormatOrNot(date, "InValid Date Format");
			DateValidatorUtil.isNotAFutureDate(attendanceDate, "Date cannot be a future date");

			LocalTime studentInTime = TimeValidatorUtil.isTimeFormatOrNot(inTime, "InVValid Time Format");
			LocalTime studentOutTime = TimeValidatorUtil.isTimeFormatOrNot(outTime, "InVValid Time Format");

			StringValidatorUtil.isStringNotNullOrEmpty(studentReason,
					"Cannot Accept Empty and Null Value...Please Enter Nil");

			/**
			 * Step 2: Call Service => Update student attendance details
			 */

			attendance.setStudentRollNumber(studentRollNumber);
			attendance.setDate(attendanceDate);
			attendance.setStudentAttendance(studentAttendance);
			attendance.setInTime(studentInTime);
			attendance.setOutTime(studentOutTime);
			attendance.setReason(studentReason);

			boolean isAddedAttendance = studentAttendanceService.updateAttendance(attendance);

			/**
			 * Step 3: Decide to which page we should redirect ?
			 */
			if (isAddedAttendance) {
				String message = "SUCCESSFULLY ATTENDANCE UPDATED";
				response.sendRedirect("StudentAttendanceModify.jsp?infoMessage=" + message);

			} else {
				throw new CannotRegisterStudentException("Cannot Update Student Attendance");

			}

		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("StudentAttendanceModify.jsp?errorMessage=" + e.getMessage());
			rd.forward(request, response);

		}

	}

}
