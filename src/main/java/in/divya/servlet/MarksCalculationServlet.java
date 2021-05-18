package in.divya.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.divya.model.StudentMarksDetails;
import in.divya.service.MarkCalculationService;
import in.divya.util.NumberValidator;

/**
 * Servlet implementation class MarksCalculationServlet
 */

@WebServlet("/MarksCalculationServlet")
public class MarksCalculationServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
      

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			StudentMarksDetails mark=new StudentMarksDetails();
			
			/**
			 * To check number as mark using NumberValidator class.
			 */
			
			mark.setStudentRollNumber(request.getParameter("studentRollNumber"));
			
			String testNumber=request.getParameter("testNumber");
			int parsedTestNumber=NumberValidator.isValidNumberOnly(testNumber,"Invalid Test Number");
			mark.setTestNumber(parsedTestNumber);
			
			String tamilMark=request.getParameter("tamilMark");
			int parsedTamilMark=NumberValidator.isValidNumberOnly(tamilMark,"Invalid Tamil Mark");
			mark.setTamilMark(parsedTamilMark);

			String englishMark=request.getParameter("englishMark");
			int parsedEnglishMark=NumberValidator.isValidNumberOnly(englishMark,"Invalid English Mark");
			mark.setEnglishMark(parsedEnglishMark);

			String mathamaticsMark=request.getParameter("mathsMark");
			int parsedMathamaticsMark=NumberValidator.isValidNumberOnly(mathamaticsMark,"Invalid Mathamatics Mark");
			mark.setMathamaticsMark(parsedMathamaticsMark);

			String scienceMark=request.getParameter("scienceMark");
			int parsedScienceMark=NumberValidator.isValidNumberOnly(scienceMark,"Invalid Science Mark");
			mark.setScienceMark(parsedScienceMark);

			String socialMark=request.getParameter("socialMark");
			int parsedSocialMark=NumberValidator.isValidNumberOnly(socialMark,"Invalid Social Mark");
			mark.setSocialMark(parsedSocialMark);
			
			/**
			 * Find Total
			 * Find Average
			 * Find Grade
			 * Find Comment
			 */
			
			int total = MarkCalculationService.addMarks(mark);
			float average=MarkCalculationService.averageMarks(total);
            String grade = MarkCalculationService.gradeRank(average);
            String gradeComment=MarkCalculationService.gradeComment(grade);
            
            mark.setTotalMark(total);
            mark.setAverageMark(average);
            mark.setGrade(grade);
            mark.setGradeComment(gradeComment);
            
			boolean isAddedMark=MarkCalculationService.addMarksToMap(mark);
			
			/**
			 * To check student marks are sucessfully added into map or not.
			 */
			
			if(isAddedMark)
			{
				String message = "MARKS ADDED SUCCESSFULLY";
                response.sendRedirect("TestMarks.jsp?infoMessage="+message +"&total="+ total + "&average="+average+"&grade="+grade+"&gradeComment="+gradeComment);

			}
			else 
			{
				throw new RuntimeException("Cannot add into the map");
			}
 			
		}
    	catch (Exception e) 
		{
 			String message = e.getMessage();
 			response.sendRedirect("TestMarks.jsp?errorMessage=" + message);
 		}
			
	}
	

}
