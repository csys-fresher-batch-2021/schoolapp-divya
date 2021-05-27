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
	float averageTest1=MarksActivityService.averageMarks(490);
	assertEquals(98.0,averageTest1,0.001);
	}
	
	/**
	 * To check-passing second total mark and return average.
	 */
	
	@Test
	public void secondTestMarkAverage()
	{
	float averageTest2=MarksActivityService.averageMarks(463);
	assertEquals(92.6,averageTest2,0.001);
	}
	
	/**
	 * To check-passing third total mark and return average.
	 */
	
	@Test
	public void thirdTestMarkAverage()
	{
	float averageTest3=MarksActivityService.averageMarks(491);
	assertEquals(98.2,averageTest3,0.001);
	}
	
	/**
	 * To check-passing first average mark and return grade.
	 */
	
	@Test
	public void gradeMark() 
	{
		String gradeMark1=MarksActivityService.gradeRank(92);
		assertEquals("A",gradeMark1);
		
	}
	
	/**
	 * To check-passing second average mark and return grade.
	 */
	
	@Test
	public void gradeMark2()
	{
		String gradeMark2=MarksActivityService.gradeRank(70);
		assertEquals("B",gradeMark2);
		
	}
	
	/**
	 * To check-passing third average mark and return grade.
	 */
	
	@Test
	public void gradeMark3() {
		String gradeMark3=MarksActivityService.gradeRank(50);
		assertEquals("C",gradeMark3);
		
		
	}
	
	/**
	 * To check-passing first test grade and return comment.
	 */
	
	@Test
	public void gradeReview1()
	{
		String comment1=MarksActivityService.gradeComment("A");
		assertEquals("EXCELLENT",comment1);
	}
	
	/**
	 * To check-passing second test grade and return comment.
	 */
	
	@Test
	public void gradeReview2()
	{
		String comment2=MarksActivityService.gradeComment("B");
		assertEquals("GOOD",comment2);
	}
	
	/**
	 * To check-passing third test grade and return comment.
	 */
	
	@Test
	public void gradeReview3()
	{
		String comment3=MarksActivityService.gradeComment("C");
		assertEquals("BAD",comment3);
	}
	
	
	

	



}
