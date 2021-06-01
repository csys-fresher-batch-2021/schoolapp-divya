<%@page import="in.divya.service.StudentMarkService"%>
<%@page import="in.divya.model.StudentMarksDetails"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>MarkDisplay</title>
<style>
h3 {
	color: blue;
	text-align: center;
}

h4 {
	color: blank;
	text-align: center;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<a href="DisplayStudentHomePage.jsp">Previous page</a><br />
		<!-- Display Student Marks -->
		<figure>
			<figcaption>
				<h3>DIVVLEARN MARK PORTAL</h3>
				<br />
			</figcaption>
			<table border="1" class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">SUBJECTS</th>
						<th scope="col">MARKS</th>
					</tr>
				<tbody>
					<%
					String studentRollNumber = (String) session.getAttribute("LOGGED_IN_USER_NO");
								String studentName = (String) session.getAttribute("LOGGED_IN_USER");
								Map<String, StudentMarksDetails> studentMarksData = StudentMarkService.displayStudentMarks(studentRollNumber);
								if (studentMarksData != null && !studentMarksData.isEmpty()) {
									StudentMarksDetails markDB = studentMarksData.get(studentRollNumber);
									System.out.println(markDB);
									out.println("<h3>WELCOME " + studentName + "</h3><br/>");
									out.println("<h4>TEST NUMBER    :  " + markDB.getTestNumber() + "</th></h4><br/>");
					%>

					<tr>
						<td>TAMIL MARK</td>
						<td><%=markDB.getTamilMark()%></td>
					</tr>
					<tr>
						<td>ENGLISH MARK</td>
						<td><%=markDB.getEnglishMark()%></td>
					</tr>
					<tr>
						<td>MATHAMATICS MARK</td>
						<td><%=markDB.getMathamaticsMark()%></td>
					</tr>
					<tr>
						<td>SCIENCE MARK</td>
						<td><%=markDB.getScienceMark()%></td>
					</tr>
					<tr>
						<td>SOCIAL MARK</td>
						<td><%=markDB.getSocialMark()%></td>
					</tr>
					<tr>
						<td>TOTAL</td>
						<td><%=markDB.getTotalMark()%></td>
					</tr>
					<tr>
						<td>AVERAGE</td>
						<td><%=markDB.getAverageMark()%></td>
					</tr>
					<tr>
						<td>GRADE</td>
						<td><%=markDB.getGrade()%></td>
					</tr>
					<tr>
						<td>COMMENT</td>
						<td><%=markDB.getGradeComment()%></td>
					</tr>
					<%
					} else {
					%>

					<tr>
						<td colspan="2">
							<h4>MARKS NOT FOUND</h4>
						</td>
					</tr>
					<%
					}
					%>
				</tbody>
				<thead>
			</table>
		</figure>
	</main>
</body>
</html>