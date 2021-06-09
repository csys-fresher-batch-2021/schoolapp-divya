package in.divya.servlet;

import java.io.IOException;

import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.divya.exceptions.CannotRegisterStudentException;
import in.divya.model.StudentDetails;
import in.divya.service.StudentDetailService;
import in.divya.util.BloodGroupValidatorUtil;
import in.divya.util.DateValidatorUtil;
import in.divya.util.EmailIDValidatorUtil;
import in.divya.util.MobileNumberValidatorUtil;
import in.divya.util.PasswordValidatorUtil;
import in.divya.util.StringValidatorUtil;

import in.divya.validator.RollNumberValidator;
import in.divya.validator.StandardValidator;

/**
 * Servlet implementation class RegistrationActionServlet
 */
@WebServlet("/RegistrationActionServlet")
public class RegistrationActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentDetailService studentDetailService = new StudentDetailService();
		try {
			StudentDetails student = new StudentDetails();
			String studentName = request.getParameter("studentName");
			String studentFatherName = request.getParameter("fatherName");
			String studentMotherName = request.getParameter("motherName");
			String studentEmailID = request.getParameter("emailId");
			String studentPassword = request.getParameter("password");
			String studentRollNumber = request.getParameter("rollNumber");
			String gender = request.getParameter("gender");
			String studentAddress = request.getParameter("address");
			String studentCity = request.getParameter("city");
			String parentOccupation = request.getParameter("occupation");
			String studentBloodGroup = request.getParameter("bloodGroup");
			String studentStandard = request.getParameter("standard");
			String staffEmailId = request.getParameter("staffEmailId");
			String parentMobileNumber = request.getParameter("mobileNumber");
			String studentDateOfBirth = request.getParameter("dateOfBirth");

			StringValidatorUtil.isStringNotNullOrEmpty(studentName, "Student name cannot Accept Empty and Null Value");
			StringValidatorUtil.isStringNotNullOrEmpty(studentFatherName,
					"Father name cannot Accept Empty and Null Value");
			StringValidatorUtil.isStringNotNullOrEmpty(studentMotherName,
					"Mother name cannot Accept Empty and Null Value");
			EmailIDValidatorUtil.isValidEmailId(studentEmailID, "InValid EmailId Format");
			PasswordValidatorUtil.isValidPasswordFormat(studentPassword, "InValid Password Format");
			RollNumberValidator.isValidRollNumberFormat(studentRollNumber, "Invalid RollNumber Format");
			StringValidatorUtil.isStringNotNullOrEmpty(gender, "Gender cannot accept empty and null value");
			StringValidatorUtil.isStringNotNullOrEmpty(studentAddress, "Address cannot Accept Empty and Null Value");
			StringValidatorUtil.isStringNotNullOrEmpty(studentCity, "City cannot Accept Empty and Null Value");
			StringValidatorUtil.isStringNotNullOrEmpty(parentOccupation,
					"Occupation cannot Accept Empty and Null Value");
			BloodGroupValidatorUtil.isValidBloodGroupFormat(studentBloodGroup, "InValid BloodGroup Format");
			StandardValidator.isValidStandardValidation(studentStandard, "InValid Standard Format");
			EmailIDValidatorUtil.isValidEmailId(staffEmailId, "InValid EmailId Format");

			Long studentValidMobileNumber = MobileNumberValidatorUtil.isValidNumberOnly(parentMobileNumber,
					"Mobile Number cannot contain alphabets");
			MobileNumberValidatorUtil.isValidMobileNumber(studentValidMobileNumber);
			LocalDate studentParsedDate = DateValidatorUtil.isDateFormatOrNot(studentDateOfBirth,
					"Invalid Date Format");
			DateValidatorUtil.isNotAFutureDate(studentParsedDate, "Date cannot be a future date");
			student.setStudentName(studentName);
			student.setFatherName(studentFatherName);
			student.setMotherName(studentMotherName);
			student.setStudentEmailId(studentEmailID);
			student.setStudentPassword(studentPassword);
			student.setStudentRollNumber(studentRollNumber);
			student.setGender(gender);
			student.setStudentAddress(studentAddress);
			student.setStudentCity(studentCity);
			student.setOccupation(parentOccupation);
			student.setStudentBloodGroup(studentBloodGroup);
			student.setStudentStandard(studentStandard);
			student.setStaffEmailId(staffEmailId);
			student.setParentMobileNumber(studentValidMobileNumber);
			student.setDateOfBirth(studentParsedDate);
			/**
			 * Step 2: Call Service => add student details
			 */
			boolean isAddedStudent = studentDetailService.addStudent(student);

			/**
			 * Step 3: Decide to which page we should redirect ?
			 */
			if (isAddedStudent) {
				String message = "SUCCESSFULLY REGISTERED";
				response.sendRedirect("Register.jsp?infoMessage=" + message);

			} else {
				throw new CannotRegisterStudentException("Cannot Register student");

			}

		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("Register.jsp?errorMessage=" + e.getMessage());
			rd.forward(request, response);

		}

	}

}
