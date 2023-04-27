
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class GradeTestFromPercentage {

    public GradeTestFromPercentage() {
    }

    @Parameters
    public static Collection<Object[]> inputsAndExp() {
        return Arrays.asList(new Object[][]{{79, 1}, {76, 2}, {73, 3}, {70, 4},
        {67, 5}, {66, 6}, {62, 7}, {60, 8}, {57, 9}, {55, 10}, {52, 11},
        {50, 12}, {47, 13}, {45, 14}, {42, 15}, {40, 16}, {35, 17}, {30, 18},
        {0, 19}, {-1, 20}});
    }

    @Parameter(0)
    public int input;

    @Parameter(1)
    public int expected;

    @Test
    public void test() {   
        assertEquals(expected, Grade.fromPercentage(input).getPoints());
    }
}
