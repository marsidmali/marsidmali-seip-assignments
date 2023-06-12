package math;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;

/**
 * @author  Marsid Mali
 * @version 1.0
 * @since   2023-05-20
 */
public class ArithmeticOperationsTest {

    ArithmeticOperations arithmeticOperations = new ArithmeticOperations();

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        arithmeticOperations.divide(4, 0);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideBothZero() {
        arithmeticOperations.divide(0, 0);
    }

    @Test
    public void testDivideByPositive() {
        assertEquals(4.0, arithmeticOperations.divide(8, 2), 0);
    }

    @Test
    public void testDivideByNegative() {
        assertEquals(-4.0, arithmeticOperations.divide(8, -2), 0);
    }

    @Test
    public void testMultiply() {
        assertEquals(6, arithmeticOperations.multiply(2, 3));
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testMultiplyWithZero() {
        assertEquals(0, arithmeticOperations.multiply(2, 0));
    }

    @Test
    public void testMultiplyWithXNegative() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("x & y should be >= 0");
        arithmeticOperations.multiply(-1, 3);
    }

    @Test
    public void testMultiplyWithYNegative() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("x & y should be >= 0");
        arithmeticOperations.multiply(1, -3);
    }
    @Test
    public void testMultiplyOverflow() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("The product does not fit in an Integer variable");
        arithmeticOperations.multiply(Integer.MAX_VALUE, 2);
    }
}
