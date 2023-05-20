package math;
/**
 * @author  Marsid Mali
 * @version 1.0
 * @since   2023-05-20
 */
import io.FileIO;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ArrayOperationsTest {

    ArrayOperations arrayOperations = new ArrayOperations();

    @Test
    public void testFindPrimesInFile() {
        FileIO fileIO = mock(FileIO.class);
        MyMath myMath = mock(MyMath.class);

        when(fileIO.readFile("filepath")).thenReturn(new int[] {2, 3, 10, 15, 20, 5});

        when(myMath.isPrime(2)).thenReturn(false);
        when(myMath.isPrime(3)).thenReturn(true);
        when(myMath.isPrime(10)).thenReturn(false);
        when(myMath.isPrime(15)).thenReturn(true);
        when(myMath.isPrime(20)).thenReturn(false);
        when(myMath.isPrime(5)).thenReturn(true);

        when(fileIO.readFile("path")).thenReturn(new int[]{2, 3, 10, 15, 20, 5});
        Assert.assertArrayEquals(new int[]{3, 15, 5}, arrayOperations.findPrimesInFile(fileIO, "filepath", myMath));
    }}




