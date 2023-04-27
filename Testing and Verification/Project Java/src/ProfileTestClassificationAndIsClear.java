
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ProfileTestClassificationAndIsClear {

    public ProfileTestClassificationAndIsClear() {
    }

    @Parameterized.Parameters
    public static Collection<Object[]> inputsAndExp() {
        return Arrays.asList(new Object[][]{
            {1, 2, 3, 4, Classification.First, true}, //0
            {5, 6, 7, 8, Classification.UpperSecond, true}, //1
            {9, 9, 8, 9, Classification.LowerSecond, true}, //2
            {1, 1, 15, 6, Classification.First, false}, //3
            {6, 5, 13, 13, Classification.UpperSecond, false}, //4        
            {13, 13, 13, 13, Classification.Third, true}, //5
        });
    }

    @Parameterized.Parameter(0)
    public int g0;

    @Parameterized.Parameter(1)
    public int g1;

    @Parameterized.Parameter(2)
    public int g2;

    @Parameterized.Parameter(3)
    public int g3;

    @Parameterized.Parameter(4)
    public Classification expClassification;

    @Parameterized.Parameter(5)
    public boolean expClear;

    @Test
    public void testClassificationAndIsClear() {
        // Grade grade = Grade.fromPercentage(input);
        List<Grade> grades = new ArrayList<>();
        grades.add(new Grade(g0));
        grades.add(new Grade(g1));
        grades.add(new Grade(g2));
        grades.add(new Grade(g3));
        Profile profile = new Profile(grades);

        assertEquals(expClassification, profile.classify());
        assertEquals(expClear, profile.isClear());
    }

}
