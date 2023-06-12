package codeanalyzer.Analyzer;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import org.junit.Test;
import codeanalyzer.SourceFileReader.SourceFileReader;
import org.junit.Before;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author  Marsid Mali
 * @version 1.0
 * @since   2023-06-10
 */
public class StringComparisonAnalyzerTest {
    private static String[] TEST_LIST;
    private StringComparisonAnalyzer stringComparisonAnalyzer;
    private static final String TEST_CLASS = "src/test/resources/TestClass.java";

    @Before
    public void setUp() throws IOException {
        List<String> sourceCodeLines;
        try (Stream<String> lines = Files.lines(Paths.get(TEST_CLASS))) {
            sourceCodeLines = lines.collect(Collectors.toList());
        }
        TEST_LIST =  sourceCodeLines.toArray(new String[0]);

        SourceFileReader fileReader = mock(SourceFileReader.class);
        when(fileReader.readFileIntoList(TEST_CLASS)).thenReturn(Arrays.asList(TEST_LIST));
        stringComparisonAnalyzer = new StringComparisonAnalyzer(fileReader);
    }

    @Test
    public void testCalculateLOC() throws IOException {
        assertEquals(7, stringComparisonAnalyzer.calculateLOC(TEST_CLASS));
    }

    @Test
    public void testCalculateNOM() throws IOException {
        assertEquals(3, stringComparisonAnalyzer.calculateNOM(TEST_CLASS));
    }

    @Test
    public void testCalculateNOC() throws IOException {
        assertEquals(3, stringComparisonAnalyzer.calculateNOC(TEST_CLASS));
    }
}