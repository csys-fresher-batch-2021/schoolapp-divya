<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>DISPLAY STUDENT INFORMATION OPERATIONS</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<!-- This page display the topics of Student information -->
		<figure>
		<figcaption><h2>List Of Information Topics Operations</h2></figcaption>
		<br/>
			<table class = "table table-bordered">
			<tr>
					<th scope = "col">
					   INFORMATION
					</th>
					<th scope = "col">
						OPERATIONS
					</th>
			</tr>
			<tr>
				<th scope = "col">
					TEST MARKS
				</th>
				<th scope = "col">
					<button type="button" class="btn btn-primary" onclick="window.location.href='http://localhost:8080/app/TestMarks.jsp'">ADD TEST MARKS</button>
					<button type="button" class="btn btn-primary">UPDATE TEST MARKS</button>
					<button type="button" class="btn btn-primary">DELETE TEST MARKS</button>
				</th>
			</tr>
			<tr>
				<th scope = "col">
					PAYMENT DETAILS
				</th>
				<th scope = "col">
					<button type="button" class="btn btn-primary">ADD PAYMENT DETAILS</button>
					<button type="button" class="btn btn-primary">UPDATE PAYMENT DETAILS</button>
					<button type="button" class="btn btn-primary">DELETE PAYMENT DETAILS</button>
				</th>
			</tr>
			
			</table>
		</figure>
	</main>
</body>
</html>