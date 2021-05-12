<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">

<h1>REGISTRATION FORM</h1>

<form action="Register_action.jsp" method="post">
		<label>STUDENT NAME : </label>
		<input type="text" name="studentName" id="studentName" placeholder="Enter Your Name" required autofocus><br/><br/>
		<label>FATHER NAME : </label>
		<input type="text" name="fatherName" id="fatherName" placeholder="Enter Your Father Name" required><br/><br/>
		<label>MOTHER NAME : </label>
		<input type="text" name="motherName" id="matherName" placeholder="Enter Your Mother Name" required><br/><br/>
		<label>EMAIL-ID : </label>
		<input type="email" name="emailId" id="emailId" placeholder="Enter Your EmailId" required autofocus><br/><br/>
		<label>PASSWORD : </label>
		<input type="password" name="password" id="password" placeholder="Enter Your Password" required><br/><br/>
		<label>ROLL NUMBER : </label>
		<input type="text" name="rollNumber" id="rollNumber" placeholder="Enter Your Roll Number" required><br/><br/>
		<label>GENDER : </label><br/>
	    <input type="radio" id="male" name="gender" value="male">
	    <label for="male">Male</label>
	    <input type="radio" id="female" name="gender" value="female">
	    <label for="female">Female</label>
	    <input type="radio" id="other" name="gender" value="other">
	    <label for="other">Other</label><br/><br/>
		<label>ADDRESS : </label>
		<input type="text" name="address" id="address" placeholder="Enter Your Address" required><br/><br/>
		<label>CITY : </label>
		<input type="text" name="city" id="city" placeholder="Enter Your City" required><br/><br/>
		<label>OCCUPATION(PARENTS) : </label>
		<input type="text" name="occupation" id="occupation" placeholder="Enter Your Parents Occupation" required><br/><br/>
		<label>BLOOD GROUP : </label>
		<input type="text" name="bloodGroup" id="bloodGroup" placeholder="Enter Your Blood-Group" required><br/><br/>
		<label>STANDARD : </label>
		<input type="text" name="standard" id="standard" placeholder="Enter Your Standard" required><br/><br/>
		<label> MOBILE NUMBER:</label>
		<input type="number" name="mobileNumber" id="mobileNumber" placeholder="Enter your Mobile Number"><br/><br/>
		<label>DATE OF BIRTH: </label>
		<input type="date" name="dateOfBirth" id="dateOfBirth"  max="2016-01-01"placeholder="YYYY-MM-DD" required><br/><br/>
		<label>DATE OF JOINING : </label>
		<input type="date" name="dateOfJoining" id="dateOfJoining"   max="2021-01-01"placeholder="YYYY-MM-DD" required><br/><br/>
		<button class="btn btn-primary">SUBMIT</button>
		<button type="reset" class="btn btn-secondary">RESET</button><br/><br/>
		<%
		String errorMessage = request.getParameter("errorMessage");
		if(errorMessage!=null){
			out.println("<font color='blue'>"+errorMessage+"</font>");
		}
		String infoMessage = request.getParameter("infoMessage");
		if(infoMessage!=null){
			out.println("<font color='blue'>"+infoMessage+"</font>");
		}
		%>
</form>
</main>
</body>
</html>