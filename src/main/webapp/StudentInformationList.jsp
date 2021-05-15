<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>StudentInformationTopics</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<!-- This page display the topics of Student information -->
		<figure>
		<br/>
			<table class = "table table-bordered">
			<tr>
					<th scope = "col">
					   INFORMATION
					</th>
					<th scope = "col">
						DISPLAY
					</th>
			</tr>
			<tr>
				<th scope = "col">
					TEST MARKS
				</th>
				<th scope = "col">
					<button type="button" class="btn btn-primary">VIEW</button>
				</th>
			</tr>
			<tr>
				<th scope = "col">
					PAYMENT DETAILS
				</th>
				<th scope = "col">
					<button type="button" class="btn btn-primary">VIEW</button>
				</th>
			</tr>
			
			<tr>
				<th scope = "col">
					ATTENDANCE DETAILS
				</th>
				<th scope = "col">
					<button type="button" class="btn btn-primary">VIEW</button>
				</th>
			</tr>
			
			</table>
		</figure>
	</main>
</body>
</html>