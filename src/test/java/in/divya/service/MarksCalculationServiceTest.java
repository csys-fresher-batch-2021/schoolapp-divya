/**
 * 
 */
package in.divya.service;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * @author divy2624
 *
 */
public class MarksCalculationServiceTest 
{
	@Test
	public void firstTestMarkAverage()
	{
	float averageTest1=MarkCalculationService.averageMarks(490);
	assertEquals(98.0,averageTest1,0.001);
	}
	
	/**
	 * To check-passing second total mark and return average.
	 */
	
	@Test
	public void secondTestMarkAverage()
	{
	float averageTest2=MarkCalculationService.averageMarks(463);
	assertEquals(92.0,averageTest2,0.001);
	}
	
	/**
	 * To check-passing third total mark and return average.
	 */
	
	@Test
	public void thirdTestMarkAverage()
	{
	float averageTest3=MarkCalculationService.averageMarks(491);
	assertEquals(98.0,averageTest3,0.001);
	}
	
	/**
	 * To check-passing first average mark and return grade.
	 */
	
	@Test
	public void gradeMark() 
	{
		String gradeMark1=MarkCalculationService.gradeRank(92);
		assertEquals("A",gradeMark1);
		
	}
	
	/**
	 * To check-passing second average mark and return grade.
	 */
	
	@Test
	public void gradeMark2()
	{
		String gradeMark2=MarkCalculationService.gradeRank(70);
		assertEquals("B",gradeMark2);
		
	}
	
	/**
	 * To check-passing third average mark and return grade.
	 */
	
	@Test
	public void gradeMark3() {
		String gradeMark3=MarkCalculationService.gradeRank(50);
		assertEquals("C",gradeMark3);
		
		
	}
	
	/**
	 * To check-passing first test grade and return comment.
	 */
	
	@Test
	public void gradeReview1()
	{
		String comment1=MarkCalculationService.gradeComment("A");
		assertEquals("EXCELLENT",comment1);
	}
	
	/**
	 * To check-passing second test grade and return comment.
	 */
	
	@Test
	public void gradeReview2()
	{
		String comment2=MarkCalculationService.gradeComment("B");
		assertEquals("GOOD",comment2);
	}
	
	/**
	 * To check-passing third test grade and return comment.
	 */
	
	@Test
	public void gradeReview3()
	{
		String comment3=MarkCalculationService.gradeComment("C");
		assertEquals("BAD",comment3);
	}
	
	
	

	



}
