package in.divya.servlet;

import java.io.IOException;

import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.divya.model.StudentDetails;
import in.divya.service.StudentDetailService;

/**
 * Servlet implementation class RegisterActionServlet
 */
@WebServlet("/RegisterActionServlet")
public class RegisterActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**
		 * Step 1: Get Form Values
		 */
    	try
    	{
			StudentDetails student=new StudentDetails();
			student.setStudentName(request.getParameter("studentName"));
			student.setFatherName(request.getParameter("fatherName"));
			student.setMotherName(request.getParameter("motherName"));
			student.setStudentEmailId(request.getParameter("emailId"));
			student.setStudentPassword(request.getParameter("password"));
			student.setStudentRollNumber(request.getParameter("rollNumber"));
			student.setGender(request.getParameter("gender"));
			student.setStudentAddress(request.getParameter("address"));
			student.setStudentCity(request.getParameter("city"));
			student.setOccupation(request.getParameter("occupation"));
			student.setStudentBloodGroup(request.getParameter("bloodGroup"));
			student.setStudentStandard(request.getParameter("standard"));
			student.setParentMobileNumber(Long.parseLong(request.getParameter("mobileNumber")));
			student.setDateOfBirth(LocalDate.parse(request.getParameter("dateOfBirth")));
			student.setDateOfJoining(LocalDate.parse(request.getParameter("dateOfJoining")));
			/**
			 * Step 2: Call Service => add student details
			 */
			boolean isAddedStudent = StudentDetailService.addStudent(student);
			/**
			 * Step 3: Decide to which page we should redirect ?
			 */
			if(isAddedStudent){
				String message = "SUCCESSFULLY REGISTERED";
				response.sendRedirect("Register.jsp?infoMessage="+message);
				
			}
			else{
				String message = "Registration Failed";
				response.sendRedirect("Register.jsp?errorMessage="+message);
			}
    	}
    	catch (Exception e) {
 			String message = e.getMessage();
 			response.sendRedirect("Register.jsp?errorMessage=" + message);
 		}
		
	
	}

	
	

}
