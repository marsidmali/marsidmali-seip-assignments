package math;
/**
 * @author  Marsid Mali
 * @version 1.0
 * @since   2023-05-20
 */
public class MyMath {
    /**
     * Calculates the factorial of a number.
     *
     * @param n The number to calculate the factorial of.
     * @return The factorial of n.
     * @throws IllegalArgumentException If n is less than 0 or greater than 12.
     */
    public int factorial(int n) {
        if (n < 0 || n > 12) {
            throw new IllegalArgumentException("n must be: n < 0 or n > 12");
        } else if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    /**
     * Checks if a number is prime.
     *
     * @param n The number to check.
     * @return True if the number is prime, false otherwise.
     * @throws IllegalArgumentException If n is less than 2.
     */
    public boolean isPrime(int n){
        if (n < 2){
            throw new IllegalArgumentException("Prime n number must be greater than 1");
        } else {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}