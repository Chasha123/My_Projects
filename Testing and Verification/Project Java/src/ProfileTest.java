
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class ProfileTest {

    public ProfileTest() {
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorException1() {
        List<Grade> list = null;
        new Profile(list);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorException2() {
        List<Grade> list = new ArrayList<>();
        new Profile(list);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorException3() {
        List<Grade> list = new ArrayList<>();
        list.add(new Grade(17));
        list.add(new Grade(11));
        list.add(new Grade(3));
        list.add(new Grade(12));
        new Profile(list);
    }

}
