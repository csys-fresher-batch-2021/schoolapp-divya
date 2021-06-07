package in.divya.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import in.divya.model.StudentFeesDetails;
import in.divya.service.StudentFeesDetailService;
import in.divya.util.LocalDateAdaptorUtil;

/**
 * Servlet implementation class StudentFeesDisplayServlet
 */
@WebServlet("/StudentFeesDisplayServlet")
public class StudentFeesDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentFeesDisplayServlet() {
		super();
	}

	/**
	 * This method gets the student fees data from the service class to get display
	 * in the screen
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentFeesDetailService studentFeesDetailService = new StudentFeesDetailService();
		String studentRollNumber = request.getParameter("studentRollNumber");
		try {
			List<StudentFeesDetails> displayStudentFees = studentFeesDetailService
					.displayStudentFees(studentRollNumber);
			Gson gson = new GsonBuilder().setPrettyPrinting()
					.registerTypeAdapter(LocalDate.class, new LocalDateAdaptorUtil()).create();
			String object = gson.toJson(displayStudentFees);
			PrintWriter out = response.getWriter();
			out.println(object);
			out.flush();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
