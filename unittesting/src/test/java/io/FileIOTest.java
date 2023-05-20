package io;
/**
 * @author  Marsid Mali
 * @version 1.0
 * @since   2023-05-20
 */
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FileIOTest {
    FileIO fileIO = new FileIO();
    public static String resourcesPath = "src/test/resources/";

    @Test
    public void testReadFile() {
        int[] expectedNumbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 50, 100};
        Assert.assertArrayEquals(expectedNumbers, fileIO.readFile(resourcesPath.concat("read.txt")));
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testFileEmpty() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Given file is empty");
        fileIO.readFile(resourcesPath.concat("empty.txt"));
    }

    @Test
    public void testFileNotExistent() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Input file does not exist");
        fileIO.readFile(resourcesPath.concat("a.txt"));
    }

    @Test
    public void testReadFileContainsInvalidEntries() {
        int[] expectedNumbers = {8, 1, 13, 4, 0};
        String validPath = resourcesPath.concat("test_read_file_contains_invalid_entries.txt");
        Assert.assertArrayEquals(expectedNumbers, fileIO.readFile(validPath));
    }
}




