package math;
/**
 * @author  Marsid Mali
 * @version 1.0
 * @since   2023-05-20
 */
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MyMathTest {
    MyMath myMath = new MyMath();

    @Test(expected = IllegalArgumentException.class)
    public void testFactorialNegative() {
        myMath.factorial(-5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFactorialAboveTwelve() {
        myMath.factorial(13);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test(expected = IllegalArgumentException.class)
    public void testIsPrimeLessThanTwo() {
        myMath.isPrime(1);
    }

    @Test
    public void testIsPrimeTwo() {
        Assert.assertTrue(myMath.isPrime(2));
    }

    @Test
    public void testIsPrime() {
        Assert.assertTrue(myMath.isPrime(3));
    }

    @Test
    public void testIsPrimeNonPrime() {
        Assert.assertFalse(myMath.isPrime(4));
    }

    @Test
    public void testIsPrimeLargePrime() {
        Assert.assertTrue(myMath.isPrime(89));
    }

    @Test
    public void testIsPrimeLargeNonPrime() {
        Assert.assertFalse(myMath.isPrime(91));
    }

    @Test
    public void testIsPrimeExceptionNegative() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Prime n number must be greater than 1");
        myMath.isPrime(-1);
    }

    @Test
    public void testIsPrimeExceptionZero() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Prime n number must be greater than 1");
        myMath.isPrime(0);
    }
}




