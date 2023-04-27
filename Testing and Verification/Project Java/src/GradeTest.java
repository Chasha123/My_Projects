  
import org.junit.Test;
import static org.junit.Assert.*;

public class GradeTest {

    public GradeTest() {
    }
 
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidInput1() {
        Grade g = new Grade(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidInput2() {
    	 Grade g = new Grade(22);
    }

    @Test
    public void testGetPoints() {
        Grade g = new Grade(3);
        assertEquals(3, g.getPoints());
    }

    @Test
    public void testClassify1() {
        Grade g = new Grade(4);
        assertEquals(Classification.First, g.classify());
    }

    @Test
    public void testClassify2() {
        Grade g = new Grade(8);
        assertEquals(Classification.UpperSecond,g.classify() );
    }

    @Test
    public void testClassify3() {
        Grade g = new Grade(12);
         assertEquals(Classification.LowerSecond,g.classify() );
    }

    @Test
    public void testClassify4() {
        Grade g = new Grade(16);
        assertEquals(Classification.Third, g.classify());
    }

    @Test
    public void testClassify5() {
        Grade g = new Grade(20);
        assertEquals(Classification.Fail, g.classify());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFromPercentageIllegalArgument1() {
        Grade.fromPercentage(-2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFromPercentageIllegalArgument2() {
        Grade.fromPercentage(101);
    }
   
}
