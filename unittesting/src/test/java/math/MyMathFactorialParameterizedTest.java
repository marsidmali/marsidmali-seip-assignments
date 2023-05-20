package math;
/**
 * @author  Marsid Mali
 * @version 1.0
 * @since   2023-05-20
 */
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MyMathFactorialParameterizedTest {
    @Parameter()
    public int n;
    @Parameter(value = 1)
    public int result;
    MyMath myMath = new MyMath();

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{{0, 1}, {1, 1}, {2, 2}, {12, 479001600}};
        return Arrays.asList(data);
    }

    @Test
    public void testFactorial() {
        assertEquals(result, myMath.factorial(n));
    }
}