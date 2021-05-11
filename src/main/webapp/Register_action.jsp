<%@page import="java.time.LocalDate"%>
<%@page import="in.divya.service.AddStudentDetails"%>
<%@page import="in.divya.model.StudentDetails"%>
<%@page import="in.divya.validator.RegistrationValidation"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
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
		student.studentName = request.getParameter("studentName");
		student.fatherName = request.getParameter("fatherName");
		student.motherName= request.getParameter("motherName");
		student.studentEmailId= request.getParameter("emailId");
		student.studentPassword= request.getParameter("password");
		student.studentRollNumber= request.getParameter("rollNumber");
		student.gender= request.getParameter("gender");
		student.studentAddress= request.getParameter("address");
		student.studentCity= request.getParameter("city");
		student.occupation= request.getParameter("occupation");
		student.studentBloodGroup= request.getParameter("bloodGroup");
		student.studentStandard= request.getParameter("standard");
		student.parentMobileNumber= Long.parseLong(request.getParameter("mobileNumber"));
		student.dateOfBirth= LocalDate.parse(request.getParameter("dateOfBirth"));
		student.dateOfJoining= LocalDate.parse(request.getParameter("dateOfJoining"));
		
			boolean isAddedStudent = AddStudentDetails.addStudent(student);
			if(isAddedStudent)
			{
			
				response.sendRedirect("index.jsp");
			}
			
			else {
				String message="INVALID REGISTER CREDENTIALS";
				response.sendRedirect("Register.jsp?errormessage="+message);
			}
		
	
		
		%>
	</main>

</body>
</html>