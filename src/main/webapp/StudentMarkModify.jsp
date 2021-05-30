<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Mark Updation</title>
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
			<!-- Mark Portal Page -->
			<form action="StudentMarkModificationServlet" method="post">
				<label>STUDENT ROLL NUMBER : </label> <input type="text"
					name="studentRollNumber" id="studentRollNumber"
					placeholder="Enter Student Roll Number" required><br />
				<br /> <label>TEST NUMBER : </label> <input type="number"
					name="testNumber" id="testNumber" placeholder="Enter Test Number"
					required><br />
				<br /> <label>TAMIL MARK : </label> <input type="number"
					name="tamilMark" id="tamilMark" placeholder="Enter Tamil Mark"
					required><br />
				<br /> <label>ENGLISH MARK : </label> <input type="number"
					name="englishMark" id="englishMark"
					placeholder="Enter English Mark" required><br />
				<br /> <label>MATHAMATICS MARK : </label> <input type="number"
					name="mathsMark" id="mathsMark"
					placeholder="Enter Mathamatics Mark" required><br />
				<br /> <label>SCIENCE MARK : </label> <input type="number"
					name="scienceMark" id="scienceMark"
					placeholder="Enter Science Mark" required><br />
				<br /> <label>SOCIAL MARK : </label> <input type="number"
					name="socialMark" id="socialMark" placeholder="Enter Social Mark"
					required><br />
				<br />
				<br />
				<button class="btn btn-primary">UPDATE</button>
				<button type="reset" class="btn btn-secondary">RESET</button>
				<br />
				<br />
				<%
				String errorMessage = request.getParameter("errorMessage");
			    if(errorMessage!=null)
			    {
					out.println("<font color='blue'>"+errorMessage+"</font>");
				}
			    String infoMessage1 = request.getParameter("infoMessage");
				String total1 = request.getParameter("total");
				String average1 = request.getParameter("average");
				String grade1 = request.getParameter("grade");
				String gradeComment1 = request.getParameter("gradeComment");
				if(infoMessage1!=null && total1!=null && average1!=null && grade1!=null && gradeComment1!=null)
				{
					out.println("<font color='blue'><h3>"+infoMessage1+"</font></h3><br/>"+"<h4>TOTAL MARK = <font color='blue'> "+ total1 +"</font></h4>" +"<h4> AVERAGE MARK = <font color ='blue'> "+ average1 +"</font></h4>" + "<h4> GRADE = <font color='blue'> "+ grade1 +"</font></h4>"+"<h4>GRADE COMMENT = <font color='blue'> "+ gradeComment1+"</font></h4>");
				}
				%>
			</form>
		</div>
	</main>

</body>
</html>