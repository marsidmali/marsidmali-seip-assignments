package codeanalyzer.SourceFileReader;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author  Marsid Mali
 * @version 1.0
 * @since   2023-06-10
 */
public class LocalFileReaderTest {
    private static List<String> expectedList;
    private static String expectedString;
    private final static String TEST_CLASS_LOCAL = "src/test/resources/TestClass.java";

    @BeforeClass
    public static void setUp() throws IOException {
        expectedList = Files.readAllLines(new File(TEST_CLASS_LOCAL).toPath(), Charset.defaultCharset());
        expectedString = String.join("\n", expectedList) + "\n";
    }

    SourceFileReader sfr = new LocalFileReader();

    @Test
    public void testReadFileIntoString() throws IOException {
        String actuals = sfr.readFileIntoString(TEST_CLASS_LOCAL);
        assertEquals(expectedString, actuals);
    }

    @Test
    public void testReadFileIntoList() throws IOException {
        List<String> actualList = sfr.readFileIntoList(TEST_CLASS_LOCAL);

        String[] expecteds = expectedList.toArray(new String[0]);
        String[] actuals = actualList.toArray(new String[0]);

        assertArrayEquals(expecteds, actuals);
    }

}