/**
 * 
 */
package in.divya.service;


import java.util.HashMap;

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
	
	private static final HashMap<String, StudentMarksDetails> studentMarksDetailsMap = new HashMap<>();

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
		int total=tamil+english+maths+science+social;
		return total;
	}

	/**
	 * Find average from total.
	 * @param total
	 * @return
	 */

	public static float averageMarks(int total) 
	{
		float average=total/5;
		return average;
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
		if(grade=="A") 
		{
			result="EXCELLENT";
			
		}
		else if(grade=="B")
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
	
}
