<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="ISO-8859-1">
<title>MODIFY FEES</title>
<style type="text/css">
form {
	text-align: center;
}

.head {
	font-weight: bold;
	font-size: 40px;
	text-align: center;
}

label {
	font-weight: bold;
	width: 200px;
	font-size: 16px;
}

h1 {
	color: blank;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<br />
		<h2>
			<button class="btn btn-link"
				onclick="window.location.href='http://localhost:8080/app/DisplayStaffHomePage.jsp'">BACK</button>
		</h2>
		<div class="head">FEES PORTAL PAGE</div>
		<br>
		<div style="margin: 50px">
			<!-- Fees Portal Page -->
			<form action="StudentFeesModificationServlet" method="post">
				<label>STUDENT ROLL NUMBER : </label> <input type="text"
					name="studentRollNumber" id="studentRollNumber"
					placeholder="Enter Student Roll Number" required><br /> <br />
				<label for="month">FEES FOR MONTH :</label> <select name="month"
					id="month">
					<option disabled>---SELECT MONTH---</option>
					<option value="JANUARY">JANUARY</option>
					<option value="February">FEBRUARY</option>
					<option value="March">MARCH</option>
					<option value="April">APRIL</option>
					<option value="May">MAY</option>
					<option value="June">JUNE</option>
					<option value="July">JULY</option>
					<option value="August">AUGUST</option>
					<option value="September">SEPTEMBER</option>
					<option value="October">OCTOBER</option>
					<option value="November">NOVEMBER</option>
					<option value="December">DECEMBER</option>
				</select> <br /> <br /> <label>FEES AMOUNT : </label> <input type="number"
					name="amount" id="amount" placeholder="Enter Fees Amount" required><br />
				<br /> <label for="date">RECEIVE DATE : </label> <input type="date"
					name="receiveDate" id="receiveDate" min="2021-01-01"
					max="2021-12-31" placeholder="YYYY-MM-DD" required><br />
				<br />

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
		</div>
	</main>
</body>
</html>