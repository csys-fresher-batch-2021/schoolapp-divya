package in.divya.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.divya.exceptions.InValidCredentialsException;
import in.divya.model.StudentMarksDetails;
import in.divya.service.StudentMarkService;
import in.divya.validator.NumberValidator;
import in.divya.validator.RollNumberValidator;

/**
 * Servlet implementation class MarkModificationServlet
 */
@WebServlet("/StudentMarkModificationServlet")
public class StudentMarkModificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentMarkService studentMarkService = new StudentMarkService();

		try {
			StudentMarksDetails mark = new StudentMarksDetails();

			/**
			 * To check number as mark using NumberValidator class.
			 */

			String studentRollNumber = request.getParameter("studentRollNumber");
			String testNumber = request.getParameter("testNumber");
			String tamilMark = request.getParameter("tamilMark");
			String englishMark = request.getParameter("englishMark");
			String mathamaticsMark = request.getParameter("mathsMark");
			String scienceMark = request.getParameter("scienceMark");
			String socialMark = request.getParameter("socialMark");

			RollNumberValidator.isValidRollNumberFormat(studentRollNumber, "Invalid RollNumber Format");

			int testNumber1 = NumberValidator.isValidNumberOnly(testNumber, "Invalid Test Number");
			NumberValidator.isNumberPositive(testNumber1);

			int tamilMark1 = NumberValidator.isValidNumberOnly(tamilMark, "Invalid Tamil Mark");
			NumberValidator.isNumberPositive(tamilMark1);

			int englishMark1 = NumberValidator.isValidNumberOnly(englishMark, "Invalid English Mark");
			NumberValidator.isNumberPositive(englishMark1);

			int mathamaticsMark1 = NumberValidator.isValidNumberOnly(mathamaticsMark, "Invalid Mathamatics Mark");
			NumberValidator.isNumberPositive(mathamaticsMark1);

			int scienceMark1 = NumberValidator.isValidNumberOnly(scienceMark, "Invalid Science mark");
			NumberValidator.isNumberPositive(scienceMark1);

			int socialMark1 = NumberValidator.isValidNumberOnly(socialMark, "Invalid Social Mark");
			NumberValidator.isNumberPositive(socialMark1);

			mark.setStudentRollNumber(studentRollNumber);
			mark.setTestNumber(testNumber1);
			mark.setTamilMark(tamilMark1);
			mark.setEnglishMark(englishMark1);
			mark.setMathamaticsMark(mathamaticsMark1);
			mark.setScienceMark(scienceMark1);
			mark.setSocialMark(socialMark1);

			/**
			 * Find Total Find Average Find Grade Find Comment
			 */
			int total = studentMarkService.addMarks(mark);
			float average = studentMarkService.averageMarks(total);
			String grade = studentMarkService.gradeRank(average);
			String gradeComment = studentMarkService.gradeComment(grade);

			mark.setTotalMark(total);
			mark.setAverageMark(average);
			mark.setGrade(grade);
			mark.setGradeComment(gradeComment);

			boolean isUpdatedMark = studentMarkService.updateStudentMarks(mark);

			/**
			 * To check student marks are sucessfully update into map or not.
			 */

			if (isUpdatedMark) {
				String message = "MARKS UPDATED SUCCESSFULLY";
				response.sendRedirect("StudentMarkModify.jsp?infoMessage=" + message + "&total=" + total + "&average="
						+ average + "&grade=" + grade + "&gradeComment=" + gradeComment);

			} else {
				throw new InValidCredentialsException("Cannot update student mark");
			}

		} catch (Exception e) {

			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("StudentMarkModify.jsp?errorMessage=" + e.getMessage());
			rd.forward(request, response);
		}

	}

}
