<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="in.divya.service.StudentMarkService"%>
<%@page import="in.divya.model.StudentMarksDetails"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>All Student Mark Display</title>
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
		<!-- Display All Student Marks -->
		<figure>
			<figcaption>
				<h3>DIVVLEARN MARK PORTAL</h3>
				<br />
			</figcaption>
			

			<%
			List<StudentMarksDetails> allStudentMarksToDisplay = StudentMarkService.displayAllStudentMarks();
			%>

			<table class="table" border="1">

				<thead class="thead-dark">
					<tr>
						<th scope="col">STUDENT ROLL NUMBER</th>
						<th scope="col">TEST NUMBER</th>
						<th scope="col">TAMIL MARK</th>
						<th scope="col">ENGLISH MARK</th>
						<th scope="col">MATHAMATICS MARK</th>
						<th scope="col">SCIENCE MARK</th>
						<th scope="col">SOCIAL MARK</th>
						<th scope="col">TOTAL MARK</th>
						<th scope="col">AVERAGE MARK</th>
						<th scope="col">GRADE</th>
						<th scope="col">PERFORMANCE</th>
					</tr>
				</thead>
				<tbody>
					<%
					if (allStudentMarksToDisplay != null && !allStudentMarksToDisplay.isEmpty()) {
						int i = 1;
						for (StudentMarksDetails allMark : allStudentMarksToDisplay) {

							i++;
					%>
					<tr>
						<td><%=allMark.getStudentRollNumber()%></td>
						<td><%=allMark.getTestNumber()%></td>
						<td><%=allMark.getTamilMark()%></td>
						<td><%=allMark.getEnglishMark()%></td>
						<td><%=allMark.getMathamaticsMark()%></td>
						<td><%=allMark.getScienceMark()%></td>
						<td><%=allMark.getSocialMark()%></td>
						<td><%=allMark.getTotalMark()%></td>
						<td><%=allMark.getAverageMark()%></td>
						<td><%=allMark.getGrade()%></td>
						<td><%=allMark.getGradeComment()%></td>

					</tr>
					<%
					}
					}
					else{
					%>
					<tr>
						<td colspan="11"><h4>MARKS NOT FOUND</h4></td>
					</tr>
					<%
					}
					%>
				</tbody>



			</table>


		</figure>
	</main>
	
</body>
</html>