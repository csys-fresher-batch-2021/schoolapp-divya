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
h4 {
	color: black;
	text-align: center;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<a href="DisplayStaffHomePage.jsp">Previous page</a><br />
		<!-- Display All Student Information-->
		<figure>
			<figcaption>
				<h3>DIVVLEARN SCHOOL</h3>
				<br />
			</figcaption>
			<%
			String infoMessage = request.getParameter("infoMessage");
			if (infoMessage != null) {
				out.println("<p style=color:green>" + infoMessage + "</p>");
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

						<th scope="col">ROLL NUMBER</th>
						<th scope="col">PERSONAL INFORMATION</th>
						<th scope="col">Mark</th>
						<th scope="col">DELETE</th>



					</tr>
				</thead>
				<tbody>
					<%
					if (allStudentInformationDisplay != null && !allStudentInformationDisplay.isEmpty()) {
						int i = 1;
						for (StudentDetails allInfo : allStudentInformationDisplay) {
							i++;
					%>
					<tr>
						<td><%=allInfo.getStudentName()%></td>

						<td><%=allInfo.getStudentRollNumber()%></td>
						<td><a
							href="StudentIndividualDetailDisplay.jsp?allInfo=<%=allInfo.getStudentRollNumber()%>">VIEW
						</a></td>
						<td><a
							href="StudentIndividualMarkDisplay.jsp?allInfo=<%=allInfo.getStudentRollNumber()%>">VIEW
						</a></td>
						<td><a
							href="StudentRemoveServlet?allInfo=<%=allInfo.getStudentRollNumber()%> "
							onclick="return deleteConfirmation('<%=allInfo.getStudentRollNumber()%>')">DELETE
						</a></td>
					</tr>
					<%
					}
					} else {
					%>
					<tr>
						<td colspan="11"><h4>RECORD NOT FOUND</h4></td>
					</tr>
					<%
					}
					%>

				</tbody>
			</table>
		</figure>
	</main>
	<script>
		function deleteConfirmation(studentRollNumber) {
			if (confirm("Are You sure want to delete " + studentRollNumber)) {
			} else {
				event.preventDefault();
			}
		}
	</script>

</body>
</html>