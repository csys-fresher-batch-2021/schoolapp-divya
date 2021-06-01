<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="in.divya.service.StudentAttendanceService"%>
<%@page import="in.divya.model.StudentAttendanceDetails"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>ATTENDANCE Display</title>
<style>
h3 {
	color: blue;
	text-align: center;
}

h4 {
	color: blank;
	text-align: center;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<a href="DisplayStudentHomePage.jsp">Previous page</a><br />
		<!-- Display Student Attendance -->
		<figure>
			<figcaption>
				<h3>DIVVLEARN ATTENDANCE PORTAL</h3>
				<br />
			</figcaption>
			<table border="1" class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">DATE</th>
						<th scope="col">ATTENDANCE STATUS</th>
						<th scope="col">IN TIME</th>
						<th scope="col">OUT TIME</th>
						<th scope="col">REASON(ABSENT OR ONDUTY)</th>
					</tr>
				<tbody>
					<%
					String studentRollNumber = (String) session.getAttribute("LOGGED_IN_USER_NO");
					String studentName = (String) session.getAttribute("LOGGED_IN_USER");
					List<StudentAttendanceDetails> studentAttendanceData = StudentAttendanceService
							.displayStudentAttendance(studentRollNumber);
					if (studentAttendanceData != null && !studentAttendanceData.isEmpty()) {
						int i = 1;
						for (StudentAttendanceDetails attendance : studentAttendanceData) {
							i++;
					%>

					<tr>
						<td><%=attendance.getDate()%></td>
						<td><%=attendance.getStudentAttendance()%></td>
						<td><%=attendance.getInTime()%></td>
						<td><%=attendance.getOutTime()%></td>
						<td><%=attendance.getReason()%></td>

					</tr>
					<%
					}
					} else {
					%>

					<tr>
						<td colspan="5"><h4>ATTENDANCE NOT FOUND</h4></td>
					</tr>
					<%
					}
					%>
				</tbody>
				<thead>
			</table>
		</figure>
	</main>

</body>
</html>