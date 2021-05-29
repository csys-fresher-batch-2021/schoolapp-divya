<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="in.divya.service.StudentDetailService"%>
<%@page import="in.divya.model.StudentDetails"%>
<%@page import="java.util.Map"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>INDIVIDUAL STUDENT DATA</title>
<style>
	h3 {
		color: blue;
		text-align: center;
	}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<br />
	<main class="container-fluid">
	<a href="AllStudentInformationDisplay.jsp">Previous page</a><br />
		<!-- Display  Student Information-->
		<figure>
			<figcaption>
				<h3>DIVVLEARN SCHOOL STUDENT INFORMATION</h3>
				<br />
			</figcaption>
			<%
			String studentRollNumber = request.getParameter("allInfo");
			Map<String, StudentDetails> individualStudentData = StudentDetailService
					.displayIndividualStudentData(studentRollNumber);
			StudentDetails data = individualStudentData.get(studentRollNumber);
			%>
	
			<table class="table" border="1">
				<thead class="thead-dark">
					<tr>
						<th scope="col">STUDENT</th>
						<th scope="col">INFORMATION</th>
					</tr>
				<tbody>
	
					<tr>
						<th scope="row">STUDENT NAME</th>
						<th scope="col"><%=data.getStudentName()%></th>
					</tr>
					<tr>
						<th scope="row">FATHER NAME</th>
						<td><%=data.getFatherName()%></td>
					</tr>
					<tr>
						<th scope="row">MOTHER NAME</th>
						<td><%=data.getMotherName()%></td>
					</tr>
					<tr>
						<th scope="row">EMAIL-ID</th>
						<td><%=data.getStudentEmailId()%></td>
					</tr>
					<tr>
						<th scope="row">ROLL NUMBER</th>
						<td><%=data.getStudentRollNumber()%></td>
					</tr>
	
					<tr>
						<th scope="row">GENDER</th>
						<td><%=data.getGender()%></td>
					<tr>
						<th scope="row">ADDRESS</th>
						<td><%=data.getStudentAddress()%></td>
					</tr>
					<tr>
						<th scope="row">CITY</th>
						<td><%=data.getStudentCity()%></td>
					</tr>
					<tr>
						<th scope="row">PARENT OCCUPATION</th>
						<td><%=data.getOccupation()%></td>
					</tr>
					<tr>
						<th scope="row">BLOOD GROUP</th>
						<td><%=data.getStudentBloodGroup()%></td>
					</tr>
					<tr>
						<th scope="row">STANDARD</th>
						<td><%=data.getStudentStandard()%></td>
					</tr>
					<tr>
						<th scope="row">PARENT MOBILE NUMBER</th>
						<td><%=data.getParentMobileNumber()%></td>
					</tr>
					<tr>
						<th scope="row">DATE OF BIRTH</th>
						<td><%=data.getDateOfBirth()%></td>
					</tr>
				</tbody>
			</table>
		</figure>
	</main>
</body>
</html>