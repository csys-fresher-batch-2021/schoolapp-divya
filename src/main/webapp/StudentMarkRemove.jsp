<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>MARK DELETION</title>
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
		<div class="head">MARK PORTAL PAGE</div>
		<br>
		<div style="margin: 50px">
			<!-- TEST MARK REMOVE PAGE -->
			<form action="StudentMarkRemoveServlet" method="post">
				
				<br /> <label>TEST NUMBER : </label> <input type="number"
					name="testNumber" id="testNumber" placeholder="Enter Test Number"
					required><br />
					
				<br />
				<br />
				<button class="btn btn-primary">DELETE</button>
				<button type="reset" class="btn btn-secondary">RESET</button>
				<br />
				<br />
				<%
				String errorMessage = request.getParameter("errorMessage");
			    if(errorMessage!=null)
			    {
					out.println("<font color='blue'>"+errorMessage+"</font>");
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