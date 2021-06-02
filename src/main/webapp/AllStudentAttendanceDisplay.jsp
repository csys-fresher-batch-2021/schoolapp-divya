<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="in.divya.service.StudentAttendanceService"%>
<%@page import="in.divya.model.StudentAttendanceDetails"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>ALL Student Attendance</title>
<style>
h2 {
	color: blue;
	text-align: center;
}

h3 {
	color: red;
	text-align: center;
}

h4 {
	color: brown;
	text-align: center;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<a href="AllStudentAttendanceCall.jsp">Previous page</a><br />
		<!-- Display Student Attendance -->
		<figure>
			<figcaption>
				<h2>DIVVLEARN ATTENDANCE PORTAL</h2>
				<br />
			</figcaption>
			<%
			StudentAttendanceService studentAttendanceService = new StudentAttendanceService();
			LocalDate date = LocalDate.parse(request.getParameter("attendanceDate"));
			int count = studentAttendanceService.displayAttendanceCount(date);
			if (count != 0) {
			%>
			<h3>
				<%
				out.println("TOTAL NUMBER STUDENTS : " + count);
				%>
			</h3>
			<%
			}
			Map<String, Integer> studentAttendanceCount = studentAttendanceService.displayAttendanceStatusCount(date);
			if (studentAttendanceCount != null && !studentAttendanceCount.isEmpty()) {
			for (String status : studentAttendanceCount.keySet()) {
				Integer value = studentAttendanceCount.get(status);
			%>
			<h4>
				<%
				out.println(status + " : ");
				out.println(value);
				}
				}
				%>
			</h4>
			<br />
			<table border="1" class="table">
				<thead class="thead-dark">

					<tr>
						<th scope="col">STUDENT ROLL NUMBER</th>
						<th scope="col">DATE</th>
						<th scope="col">ATTENDANCE STATUS</th>
						<th scope="col">IN TIME</th>
						<th scope="col">OUT TIME</th>
						<th scope="col">REASON(ABSENT OR ONDUTY)</th>
					</tr>
				<tbody>
					<%
					List<StudentAttendanceDetails> studentAttendanceData = studentAttendanceService.displayAllStudentAttendance(date);
					if (studentAttendanceData != null && !studentAttendanceData.isEmpty()) {
						int i = 1;
						for (StudentAttendanceDetails attendance : studentAttendanceData) {
							i++;
					%>
					<tr>
						<td><%=attendance.getStudentRollNumber()%></td>
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
						<td colspan="6"><h4>ATTENDANCE NOT FOUND</h4></td>
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