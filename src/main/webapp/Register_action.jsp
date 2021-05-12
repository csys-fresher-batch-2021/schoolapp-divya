<%@page import="java.time.LocalDate"%>
<%@page import="in.divya.service.AddStudentDetails"%>
<%@page import="in.divya.model.StudentDetails"%>
<%@page import="in.divya.validator.RegistrationValidation"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<!--  Step 1: Get Form Values -->
		<%
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
		
			boolean isAddedStudent = AddStudentDetails.addStudent(student);
			if(isAddedStudent){
				String message = "SUCCESSFULLY REGISTERED";
				response.sendRedirect("Register.jsp?infoMessage="+message);
				
			}
			else{
				String message = "Registration Failed";
				response.sendRedirect("Register.jsp?errorMessage="+message);
			}
			/*if(isAddedStudent)
			{
			
				response.sendRedirect("index.jsp");
			}
			
			else {
				String message="INVALID REGISTER CREDENTIALS";
				response.sendRedirect("Register.jsp?errormessage="+message);
			}
		
	*/
		
		%>
	</main>

</body>
</html>