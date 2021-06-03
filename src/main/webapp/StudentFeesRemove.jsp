<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Remove Fees</title>
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
		<div class="head">ATTENDANCE FEES PAGE</div>
		<br>
		<div style="margin: 50px">
			<!-- ATTENDANCE FEES PAGE -->
			<form action="StudentFeesRemoveServlet" method="post">
				<br /> <br /> <label for="month">FEES FOR MONTH :</label> <select
					name="month" id="month">
					<option disabled>---SELECT MONTH---</option>
					<option value="JANUARY">JANUARY</option>
					<option value="FEBRUARY">FEBRUARY</option>
					<option value="MARCH">MARCH</option>
					<option value="APRIL">APRIL</option>
					<option value="MAY">MAY</option>
					<option value="JUNE">JUNE</option>
					<option value="JULY">JULY</option>
					<option value="AUGUST">AUGUST</option>
					<option value="SEPTEMBER">SEPTEMBER</option>
					<option value="OCTOBER">OCTOBER</option>
					<option value="NOVEMBER">NOVEMBER</option>
					<option value="DECEMBER">DECEMBER</option>
				</select> <br /> <br />
				<button class="btn btn-primary">DELETE</button>
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