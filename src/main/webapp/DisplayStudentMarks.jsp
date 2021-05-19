<%@page import="in.divya.service.MarkCalculationService"%>
<%@page import="in.divya.model.StudentMarksDetails"%>
<%@page import="java.util.Map"%>
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
			    h4
			    {
			     	color : red;
			     	text-align:center;
			    }
		</style>
	</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<a href="DisplayStudentInformationList.jsp">Previous page</a><br/>
		<!-- Display Student Marks -->
		<figure>
		<figcaption><h3>DIVVLEARN MARK PORTAL</h3><br/></figcaption>
			<table border="1" class="center">
			<tr>
			<th scope="col">SUBJECTS</th>
    		<th scope="col">MARKS</th>
            </tr>
				<tbody>
				<%
					Map<String, StudentMarksDetails> studentMarksDetailsMap = MarkCalculationService.getMarks();
					String studentRollNumber = (String)session.getAttribute("LOGGED_IN_USER_NO");
					String studentName = (String)session.getAttribute("LOGGED_IN_USER");
					StudentMarksDetails testMarks =MarkCalculationService.viewStudentMarkDetails(studentRollNumber);
					out.println("<h3>WELCOME "+studentName+"</h3><br/>");
					out.println("<h4>TEST NUMBER    :  "+testMarks.getTestNumber()+"</th></h4><br/>");
					out.println("<td>"+"TAMIL MARK"+"</td>");
					out.println("<td>"+testMarks.getTamilMark()+"</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td>"+"ENGLISH MARK"+"</td>");
					out.println("<td>"+testMarks.getEnglishMark()+"</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td>"+"MATHAMATICS MARK"+"</td>");
					out.println("<td>"+testMarks.getMathamaticsMark()+"</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td>"+"SCIENCE MARK"+"</td>");
					out.println("<td>"+testMarks.getScienceMark()+"</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td>"+"SOCIAL MARK"+"</td>");
					out.println("<td>"+testMarks.getSocialMark()+"</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td>"+"TOTAL"+"</td>");
					out.println("<td>"+testMarks.getTotalMark()+"</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td>"+"AVERAGE"+"</td>");
					out.println("<td>"+testMarks.getAverageMark()+"</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td>"+"GRADE"+"</td>");
					out.println("<td>"+testMarks.getGrade()+"</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td>"+"COMMENT"+"</td>");
					out.println("<td>"+testMarks.getGradeComment()+"</td>");
					out.println("</tr>");
				%>
				</tbody>
			</table>
		</figure>
	</main>
</body>
</html>