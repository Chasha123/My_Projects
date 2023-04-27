
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class DegreeTest {

    public DegreeTest() {
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorException1() {
        List<Grade> year2 = null;

        List<Grade> year3 = new ArrayList<>();
        year3.add(new Grade(3));
        year3.add(new Grade(1));
        year3.add(new Grade(1));
        year3.add(new Grade(2));

        Degree degree = new Degree(year2, year3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorException2() {
        List<Grade> year2 = new ArrayList<>();
        year2.add(new Grade(3));
        year2.add(new Grade(1));

        List<Grade> year3 = new ArrayList<>();
        year3.add(new Grade(3));
        year3.add(new Grade(1));
        year3.add(new Grade(1));
        year3.add(new Grade(1));

        Degree degree = new Degree(year2, year3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorException3() {
        List<Grade> year2 = new ArrayList<>();
        year2.add(new Grade(3));
        year2.add(new Grade(1));
        year2.add(new Grade(1));
        year2.add(new Grade(1));

        List<Grade> year3 = new ArrayList<>();
        year3.add(new Grade(3));
        year3.add(new Grade(1));
        year3.add(new Grade(1));
        year3.add(new Grade(18));

        Degree degree = new Degree(year2, year3);
    }

    @Test
    public void testClassify1() {
        List<Grade> year2 = new ArrayList<>();
        List<Grade> year3 = new ArrayList<>();

        year2.add(new Grade(1));
        year2.add(new Grade(1));
        year2.add(new Grade(1));
        year2.add(new Grade(1));

        year3.add(new Grade(1));
        year3.add(new Grade(1));
        year3.add(new Grade(1));
        year3.add(new Grade(1));

        assertEquals(Classification.First, new Degree(year2, year3).classify());
    }

    @Test
    public void testClassify2() {
        List<Grade> year2 = new ArrayList<>();
        List<Grade> year3 = new ArrayList<>();

        year2.add(new Grade(7));
        year2.add(new Grade(7));
        year2.add(new Grade(7));
        year2.add(new Grade(7));

        year3.add(new Grade(9));
        year3.add(new Grade(9));
        year3.add(new Grade(9));
        year3.add(new Grade(9));

        assertEquals(Classification.UpperSecond, new Degree(year2, year3).classify());
    }

    @Test
    public void testClassify3() {
        List<Grade> year2 = new ArrayList<>();
        List<Grade> year3 = new ArrayList<>();

        year2.add(new Grade(13));
        year2.add(new Grade(13));
        year2.add(new Grade(13));
        year2.add(new Grade(13));

        year3.add(new Grade(9));
        year3.add(new Grade(9));
        year3.add(new Grade(9));
        year3.add(new Grade(9));

        assertEquals(Classification.LowerSecond, new Degree(year2, year3).classify());
    }
     @Test
    public void testClassify4() {
        List<Grade> year2 = new ArrayList<>();
        List<Grade> year3 = new ArrayList<>();

        year2.add(new Grade(16));
        year2.add(new Grade(16));
        year2.add(new Grade(14));
        year2.add(new Grade(14));

        year3.add(new Grade(15));
        year3.add(new Grade(15));
        year3.add(new Grade(13));
        year3.add(new Grade(13));

        assertEquals(Classification.Third, new Degree(year2, year3).classify());
    }

    @Test
    public void testClassify5() {
        List<Grade> year2 = new ArrayList<>();
        List<Grade> year3 = new ArrayList<>();

        year2.add(new Grade(1));
        year2.add(new Grade(1));
        year2.add(new Grade(1));
        year2.add(new Grade(1));

        year3.add(new Grade(12));
        year3.add(new Grade(13));
        year3.add(new Grade(15));
        year3.add(new Grade(16));

        assertEquals(Classification.Discretion, new Degree(year2, year3).classify());
    }

}
