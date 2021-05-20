/**
 * 
 */
package in.divya.service;


import java.util.HashMap;
import java.util.Map;

import in.divya.model.StudentMarksDetails;

/**
 * @author divy2624
 *
 */
public class MarkCalculationService 
{
	private MarkCalculationService()
	{
		/**
		 * Default constructor
		 */
	}
	
	private static final Map<String, StudentMarksDetails> studentMarksDetailsMap = new HashMap<>();

    /**
     * To add the student marks.       
     * @param mark
     * @return
     */
	
	public static int addMarks(StudentMarksDetails mark)
	{
		

		int tamil=mark.getTamilMark();
		int english=mark.getEnglishMark();
		int maths=mark.getMathamaticsMark();
		int science=mark.getScienceMark();
		int social=mark.getSocialMark();
		return tamil+english+maths+science+social;
	}

	/**
	 * Find average from total.
	 * @param total
	 * @return
	 */

	public static float averageMarks(int total) 
	{
		return ((float)total/5);
	}

	/**
	 * Find grade from average
	 * @param average
	 * @return
	 */

	public static String gradeRank(float average) 
	{
		String grade=null;
        if(average>90)
        {
       	 grade="A";
        }
        else if( average<=90 && average>=70) 
        {
       	 grade="B";
        }
        else
        {
       	 grade="C";
        }
        return grade;
		
	}
	
	/**
	 * Find comments from grade.
	 * @param grade
	 * @return
	 */
	
	public static String gradeComment(String grade)
	{
		String result;
		if(grade.equals("A")) 
		{
			result="EXCELLENT";
			
		}
		else if(grade.equals("B"))
		{
			result="GOOD";
		}
		else
		{
			result="BAD";
		}
	    
		return result;
	}
	
	/**
	 * To add all student mark details into map.
	 * @param mark
	 * @return
	 */
	public static boolean addMarksToMap(StudentMarksDetails mark)
	{
		studentMarksDetailsMap.put(mark.getStudentRollNumber(),mark);
		return true;
		
	}
	
	/**
	 * This Method displays the hashMap that stores the student marks data
	 * 
	 * @return
	 */
	
	public static Map <String,StudentMarksDetails > getMarks() 
	{
		return studentMarksDetailsMap;
	}

	/**
	 * This method passing student marks from studentMarksDetailsMap.
	 * It also checks details are found or not in map.
	 * @param studentRollNumber
	 * @return
	 */
	
	public static StudentMarksDetails viewStudentMarkDetails( String studentRollNumber) 
	{
		StudentMarksDetails viewStudentMarkDetails =studentMarksDetailsMap.get(studentRollNumber);
		if(viewStudentMarkDetails == null) 
		{
			return null;
		}
		return viewStudentMarkDetails;
	}
	
}
