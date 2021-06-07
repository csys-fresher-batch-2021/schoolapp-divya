<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>DISPLAY STUDENT INFORMATION OPERATIONS</title>
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
		<!-- This page display the topics of Student information -->
		<figure>
			<figcaption>Student Information</figcaption>
			<br />
			<%
			String staffName = (String) session.getAttribute("LOGGED_IN_USER");
			out.println("<h3>WELCOME " + staffName + "</h3><br/>");
			%>
			<br />
			<table class="table table-bordered">
				<tr>
					<th scope="col">LIST</th>
					<th scope="col">ACTIONS</th>
				</tr>
				<tr>
					<th scope="col">STUDENT DETAILS</th>
					<th scope="col">
						<button type="button" class="btn btn-primary"
							onclick="window.location.href='http://localhost:8080/app/AllStudentInformationDisplay.jsp'">
							VIEW STUDENT INFORMATION</button>
					</th>

				</tr>
				<tr>
					<th scope="col">TEST MARKS</th>
					<th scope="col">
						<button type="button" class="btn btn-primary"
							onclick="window.location.href='http://localhost:8080/app/StudentMarkAdd.jsp'">ADD
							TEST MARKS</button>
						<button type="button" class="btn btn-primary"
							onclick="window.location.href='http://localhost:8080/app/StudentMarkModify.jsp'">UPDATE
							MARKS</button>
						<button type="button" class="btn btn-primary"
							onclick="window.location.href='http://localhost:8080/app/StudentMarkRemove.jsp'">DELETE
							MARKS</button>
						<button type="button" class="btn btn-primary"
							onclick="window.location.href='http://localhost:8080/app/AllStudentMarksDisplay.jsp'">VIEW
							MARKS</button>
					</th>
				</tr>
				<tr>
					<th scope="col">ATTENDANCE</th>
					<th scope="col">
						<button type="button" class="btn btn-primary"
							onclick="window.location.href='http://localhost:8080/app/StudentAttendanceAdd.jsp'">ADD
							ATTENDANCE</button>
						<button type="button" class="btn btn-primary"
							onclick="window.location.href='http://localhost:8080/app/StudentAttendanceModify.jsp'">UPDATE
							ATTENDANCE</button>
						<button type="button" class="btn btn-primary"
							onclick="window.location.href='http://localhost:8080/app/StudentAttendanceRemove.jsp'">DELETE
							ATTENDANCE</button>
						<button type="button" class="btn btn-primary"
							onclick="window.location.href='http://localhost:8080/app/AllStudentAttendanceCall.jsp'">VIEW
							ATTENDANCE</button>
					</th>
				</tr>
				<tr>
					<th scope="col">FEES</th>
					<th scope="col">
						<button type="button" class="btn btn-primary"
							onclick="window.location.href='http://localhost:8080/app/StudentFeesAdd.jsp'">ADD
							FEES</button>
						<button type="button" class="btn btn-primary"
							onclick="window.location.href='http://localhost:8080/app/StudentFeesModify.jsp'">UPDATE
							FEES</button>
						<button type="button" class="btn btn-primary"
							onclick="window.location.href='http://localhost:8080/app/StudentFeesRemove.jsp'">DELETE
							FEES</button>
						<button type="button" class="btn btn-primary"
							onclick="window.location.href='http://localhost:8080/app/AllStudentFeesDisplay.jsp'">VIEW
							FEES</button>
					</th>
				</tr>
			</table>
		</figure>
	</main>
</body>
</html>