<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
    
    
<%@page import="in.divya.service.StudentDetailService"%>
<%@page import="in.divya.model.StudentDetails"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>student Information</title>
<style>
h3 {
	color: blue;
	text-align: center;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<a href="DisplayStudentInformationListOperations.jsp">Previous page</a><br />
		<!-- Display All Student Information-->
		<figure>
			<figcaption>
				<h3>DIVVLEARN SCHOOL</h3>
				<br />
			</figcaption>
			<%
		String infoMessage = request.getParameter("infoMessage");
		if(infoMessage!=null){
			out.println("<p style=color:green>"+infoMessage+"</p>");
		}
		%>

			<%
			String staffName = (String) session.getAttribute("LOGGED_IN_USER");

			List<StudentDetails> allStudentInformationDisplay = StudentDetailService.displayAllStudentInformation(staffName);
			%>

			<table class="table" border="1">

				<thead class="thead-dark">
					<tr>
						<th scope="col">STUDENT NAME</th>
						<th scope="col">FATHER NAME</th>
						<th scope="col">MOTHER NAME</th>
						<th scope="col">EMAIL ID</th>
						<th scope="col">PASSWORD</th>
						<th scope="col">ROLL NUMBER</th>
						<th scope="col">GENDER</th>
						<th scope="col">ADDRESS</th>
						<th scope="col">CITY</th>
						<th scope="col">OCCUPATION</th>
						<th scope="col">BLOOD GROUP</th>
						<th scope="col">STANDARD</th>
						<th scope="col">STAFF NAME</th>
						<th scope="col">PARENT MOBILE NUMBER</th>
						<th scope="col">DATE OF BIRTH</th>
						<th scope="col">Delete</th>
						
						
												
					</tr>
				</thead>
				<tbody>
					<%
					if(allStudentInformationDisplay!=null){
					int i = 1;
					for (StudentDetails allInfo : allStudentInformationDisplay) {
						i++;
					%>
					<tr>
						<td><%=allInfo.getStudentName() %></td>
						<td><%=allInfo.getFatherName()  %></td>
						<td><%=allInfo.getMotherName()   %></td>
						<td><%=allInfo.getStudentEmailId()   %></td>
						<td><%=allInfo.getStudentPassword()   %></td>
						<td><%=allInfo.getStudentRollNumber()   %></td>
						<td><%=allInfo.getGender()   %></td>
						<td><%=allInfo.getStudentAddress()   %></td>
						<td><%=allInfo.getStudentCity()   %></td>
						<td><%=allInfo.getOccupation()   %></td>
						<td><%=allInfo.getStudentBloodGroup()  %></td>
						<td><%=allInfo.getStudentStandard()   %></td>
						<td><%=allInfo.getStaffName()   %></td>
						<td><%=allInfo.getParentMobileNumber()   %></td>
						<td><%=allInfo.getDateOfBirth()   %></td>
						<td><a
						href="StudentRemoveServlet?allInfo=<%=allInfo.getStudentRollNumber()%> " onclick="return deleteConfirmation('<%=allInfo.getStudentRollNumber()%>')">Delete
						</a></td>
					</tr>
					<%
					}}
					%>
				</tbody>



			</table>


		</figure>
	
	</main>
	<script>
	function deleteConfirmation(studentRollNumber){
		if(confirm("Are You sure want to delete "+studentRollNumber)){
		}else{
			event.preventDefault();
		}
	}
	</script>
	
</body>
</html>