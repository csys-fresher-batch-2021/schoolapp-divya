<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>MODIFY ATTENDANCE</title>
<style>
form {
	text-align: center;
}

label {
	font-weight: bold;
	width: 300px;
	font-size: 18px;
}

h2 {
	color: blank;
	text-align: center;
}
</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<br />

		<button class="btn btn-link"
			onclick="window.location.href='http://localhost:8080/app/DisplayStaffHomePage.jsp'">BACK</button>
		<h2>ATTENDANCE FORM</h2>
		<br /> <br />
		<!--  Get the StudentAttendanceDetails -->
		<form action="StudentAttendanceModificationServlet" method="post">
			<label for="rollNumber">ROLL NUMBER : </label> <input type="text"
				name="rollNumber" id="rollNumber"
				placeholder="Enter Student Roll Number" required><br /> <br />
			<label for="date">DATE</label> <input type="date"
				name="dateOfAttendance" id="dateOfAttendance" min="2021-01-01"
				max="2021-12-31" placeholder="YYYY-MM-DD" required><br /> <br />
			<label for="attendance">CHOOSE ATTENDANCE TYPE :</label> <select
				name="studentAttendance" id="studentAttendance">
				<option value="PRESENT">PRESENT</option>
				<option value="ABSENT">ABSENT</option>
				<option value="ONDUTY">ONDUTY</option>
			</select> <br /> <br /> <label for="time">IN TIME :</label> <input
				type="time" id="inTime" name="inTime"> <br /> <br /> <label
				for="time">OUT TIME :</label> <input type="time" id="outTime"
				name="outTime"> <br /> <br /> <label
				for="student Reason for leave">REASON  (IF STUDENT IS ABSENT
				OR ONDUTY PUT THE REASON IN THE BOX..OTHERWISE TYPE NIL IN BOX) :</label> <input
				type="text" name="reason" id="reason"
				placeholder="Enter Student Reason" required><br /> <br />
			<button class="btn btn-primary">UPDATE</button>
			<button type="reset" class="btn btn-secondary">RESET</button>
			<br /> <br />
			<%
			String errorMessage = request.getParameter("errorMessage");
			if (errorMessage != null) {
				out.println("<font color='blue'>" + errorMessage + "</font>");
			}
			String infoMessage = request.getParameter("infoMessage");
			if (infoMessage != null) {
				out.println("<font color='blue'>" + infoMessage + "</font>");
			}
			%>
		</form>
	</main>

</body>
</html>