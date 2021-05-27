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
import in.divya.service.MarkCalculationService;
import in.divya.validator.MarkValidator;
import in.divya.validator.RollNumberValidator;

/**
 * Servlet implementation class MarkModificationServlet
 */
@WebServlet("/MarkModificationServlet")
public class MarkModificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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

			int testNumber1 = MarkValidator.isValidNumberOnly(testNumber, "Invalid Test Number");
			MarkValidator.isNumberPositive(testNumber1);

			int tamilMark1 = MarkValidator.isValidNumberOnly(tamilMark, "Invalid Tamil Mark");
			MarkValidator.isNumberPositive(tamilMark1);

			int englishMark1 = MarkValidator.isValidNumberOnly(englishMark, "Invalid English Mark");
			MarkValidator.isNumberPositive(englishMark1);

			int mathamaticsMark1 = MarkValidator.isValidNumberOnly(mathamaticsMark, "Invalid Mathamatics Mark");
			MarkValidator.isNumberPositive(mathamaticsMark1);

			int scienceMark1 = MarkValidator.isValidNumberOnly(scienceMark, "Invalid Science mark");
			MarkValidator.isNumberPositive(scienceMark1);

			int socialMark1 = MarkValidator.isValidNumberOnly(socialMark, "Invalid Social Mark");
			MarkValidator.isNumberPositive(socialMark1);

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
			int total = MarkCalculationService.addMarks(mark);
			float average = MarkCalculationService.averageMarks(total);
			String grade = MarkCalculationService.gradeRank(average);
			String gradeComment = MarkCalculationService.gradeComment(grade);

			mark.setTotalMark(total);
			mark.setAverageMark(average);
			mark.setGrade(grade);
			mark.setGradeComment(gradeComment);

			boolean isUpdatedMark = MarkCalculationService.updateStudentMarks(mark);

			/**
			 * To check student marks are sucessfully update into map or not.
			 */

			if (isUpdatedMark) {
				String message = "MARKS UPDATED SUCCESSFULLY";
				response.sendRedirect("MarkModification.jsp?infoMessage=" + message + "&total=" + total + "&average="
						+ average + "&grade=" + grade + "&gradeComment=" + gradeComment);

			} else {
				throw new InValidCredentialsException("Cannot Register user");
			}

		} catch (Exception e) {

			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("TestMarks.jsp?errorMessage=" + e.getMessage());
			rd.forward(request, response);
		}

	}

}
