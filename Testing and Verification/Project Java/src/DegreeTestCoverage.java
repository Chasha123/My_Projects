import java.util.*;

import org.junit.Test;

import static org.junit.Assert.*;


public class DegreeTestCoverage {
	
	@Test
	public void testclassifye() {
		List<Grade> year2 = new ArrayList<>();
        year2.add(new Grade(6));
        year2.add(new Grade(6));
        year2.add(new Grade(6));
        year2.add(new Grade(6));

        List<Grade> year3 = new ArrayList<>();
        year3.add(new Grade(6));
        year3.add(new Grade(1));
        year3.add(new Grade(1));
        year3.add(new Grade(1));

        Degree degree = new Degree(year2, year3);
        assertEquals(Classification.First, degree.classify());
		
	}
	
	
	@Test
	  public void DtestClassify5() {
	        List<Grade> year2 = new ArrayList<>();
	        List<Grade> year3 = new ArrayList<>();

	        year2.add(new Grade(1));
	        year2.add(new Grade(1));
	        year2.add(new Grade(1));
	        year2.add(new Grade(1));

	        year3.add(new Grade(8));
	        year3.add(new Grade(13));
	        year3.add(new Grade(13));
	        year3.add(new Grade(13));

	        assertEquals(Classification.Discretion, new Degree(year2, year3).classify());
	    }

	 @Test(expected = IllegalArgumentException.class)
	    public void testConstructorException1() {
		 List<Grade> year2 = new ArrayList<>();
	        year2.add(new Grade(3));
	        year2.add(new Grade(1));
	        year2.add(new Grade(1));
	        year2.add(new Grade(2));
	        
	        List<Grade> year3 = null;

	        Degree degree = new Degree(year2, year3);
	    }
	 
	 @Test(expected = IllegalArgumentException.class)
	    public void testConstructorException2() {
		 List<Grade> year2 = new ArrayList<>();
	        year2.add(new Grade(3));
	        year2.add(new Grade(1));
	        year2.add(new Grade(1));
	        year2.add(new Grade(1));   
		 
		 List<Grade> year3 = new ArrayList<>();
	        year3.add(new Grade(3));
	        year3.add(new Grade(1));
	        
	        Degree degree = new Degree(year2, year3);
	       
	 }
	 
	 
	    @Test(expected = IllegalArgumentException.class)
	    public void testConstructorException3() {
	        List<Grade> year2 = new ArrayList<>();
	        year2.add(new Grade(3));
	        year2.add(new Grade(1));
	        year2.add(new Grade(18));
	        year2.add(new Grade(1));

	        List<Grade> year3 = new ArrayList<>();
	        year3.add(new Grade(3));
	        year3.add(new Grade(1));
	        year3.add(new Grade(1));
	        year3.add(new Grade(1));

	        Degree degree = new Degree(year2, year3);
	    }
	    
	  
}
