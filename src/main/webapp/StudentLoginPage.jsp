<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
<h2>LOGIN PAGE</h2>
<form action="LoginActionServlet" method="get">
		<label>NAME : </label><br/>
		<input type="text" name="studentName" id="studentName" placeholder="Enter Your Name" required><br/><br/>
		<label>ROLL NUMBER : </label><br/>
		<input type="text" name="studentRollNumber" id="studentRollNumber" placeholder="Enter Your Roll Number" required><br/><br/>
		<label>PASSWORD : </label><br/>
		<input type="password" name="studentPassword" id="studentPassword" placeholder="Enter Your Password" required><br/><br/>
		<button class="btn btn-primary">SUBMIT</button>
</form>
<%
		String errorMessage = request.getParameter("errorMessage");
		if(errorMessage!=null)
		{
			out.println("<font color='blue'>"+errorMessage+"</font>");
		}
%>
</main>
</body>
</html>