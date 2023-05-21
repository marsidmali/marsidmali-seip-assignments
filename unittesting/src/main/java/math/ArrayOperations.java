package math;

import io.FileIO;
import java.util.ArrayList;

/**
 * @author  Marsid Mali
 * @version 1.0
 * @since   2023-05-20
 */
public class ArrayOperations {
    /**
     * Finds the prime numbers in a file and returns them in an array.
     *
     * @param fileIo The file IO utility.
     * @param filepath The path of the file.
     * @param myMath The math utility.
     * @return The prime numbers in the file.
     */
    public int[] findPrimesInFile(FileIO fileIo, String filepath, MyMath myMath) {
        int[] numbers = fileIo.readFile(filepath);
        ArrayList<Integer> primes = new ArrayList<>();

        for (int number : numbers) {
            if (myMath.isPrime(number)) {
                primes.add(number);
            }
        }

        return primes.stream().mapToInt(i -> i).toArray();
    }
}

