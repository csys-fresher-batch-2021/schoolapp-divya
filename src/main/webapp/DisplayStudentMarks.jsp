<%@page import="in.divya.service.MarkCalculationService"%>
<%@page import="in.divya.model.StudentMarksDetails"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
	<head>
	<meta charset="ISO-8859-1">
	<title>MarkDisplay</title>
		<style>
				table.center 
				{
				  margin-left: auto; 
				  margin-right: auto;
				  text-align:center;
				  width: 80%;
				}
			    h3
			    {
			     	color : blue;
			     	text-align:center;
			    }
		</style>
	</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<a href="DisplayStudentInformationList.jsp">Previous page</a>
		<!-- Display Student Marks -->
		<table border="1" class="center">
			<tbody>
			<%
				HashMap<String, StudentMarksDetails> studentMarksDetailsMap = MarkCalculationService.getMarks();
				String studentRollNumber = (String)session.getAttribute("LOGGED_IN_USER_NO");
				String studentName = (String)session.getAttribute("LOGGED_IN_USER");
				StudentMarksDetails testMarks =MarkCalculationService.viewStudentMarkDetails(studentRollNumber);
				out.println("<h3>WELCOME "+studentName+"</h3><br/>");
				out.println("<tr>");
				out.println("<th>"+"TEST NUMBER "+"</th>");
				out.println("<td>"+testMarks.getTestNumber()+"</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<th>"+"TAMIL MARK"+"</th>");
				out.println("<td>"+testMarks.getTamilMark()+"</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<th>"+"ENGLISH MARK"+"</th>");
				out.println("<td>"+testMarks.getEnglishMark()+"</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<th>"+"MATHAMATICS MARK"+"</th>");
				out.println("<td>"+testMarks.getMathamaticsMark()+"</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<th>"+"SCIENCE MARK"+"</th>");
				out.println("<td>"+testMarks.getScienceMark()+"</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<th>"+"SOCIAL MARK"+"</th>");
				out.println("<td>"+testMarks.getSocialMark()+"</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<th>"+"TOTAL"+"</th>");
				out.println("<td>"+testMarks.getTotalMark()+"</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<th>"+"AVERAGE"+"</th>");
				out.println("<td>"+testMarks.getAverageMark()+"</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<th>"+"GRADE"+"</th>");
				out.println("<td>"+testMarks.getGrade()+"</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<tr>");
				out.println("<th>"+"COMMENT"+"</th>");
				out.println("<td>"+testMarks.getGradeComment()+"</td>");
				out.println("</tr>");
			%>
			</tbody>
		</table>
	</main>
</body>
</html>