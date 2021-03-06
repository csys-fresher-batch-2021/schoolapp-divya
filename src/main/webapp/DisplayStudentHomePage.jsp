<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>StudentInformationTopics</title>
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
			String studentRollNumber = (String) session.getAttribute("LOGGED_IN_USER_NO");
			String studentName = (String) session.getAttribute("LOGGED_IN_USER");
			out.println("<h3>WELCOME " + studentName + "</h3><br/>");
			%>
			<br />
			<table class="table table-bordered">
				<tr>
					<th scope="col">INFORMATION</th>
					<th scope="col">DISPLAY</th>
				</tr>
				<tr>
					<th scope="col">TEST MARKS</th>
					<th scope="col">
						<button type="button" class="btn btn-primary"
							onclick="window.location.href='http://localhost:8080/app/StudentMarkDisplay.jsp'">VIEW</button>
					</th>
				</tr>
				<tr>
					<th scope="col">ATTENDANCE</th>
					<th scope="col">
						<button type="button" class="btn btn-primary"
							onclick="window.location.href='http://localhost:8080/app/StudentAttendanceDisplay.jsp'">VIEW</button>
					</th>
				</tr>
				<tr>
					<th scope="col">FEES</th>
					<th scope="col">
						<button type="button" class="btn btn-primary"
							onclick="window.location.href='http://localhost:8080/app/StudentFeesDisplay.jsp?studentRollNumber=<%=studentRollNumber%>'">VIEW</button>
					</th>
				</tr>
			</table>
		</figure>
	</main>
</body>
</html>