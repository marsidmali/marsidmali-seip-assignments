package codeanalyzer.Analyzer;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import codeanalyzer.SourceFileReader.SourceFileReader;
import org.junit.Before;
import static org.mockito.Mockito.mock;

/**
 * @author  Marsid Mali
 * @version 1.0
 * @since   2023-06-10
 */
public class SourceCodeAnalyzerFactoryTest {
    private SourceCodeAnalyzerFactory factory;
    private SourceFileReader fileReader;

    @Before
    public void setUp() {
        factory = new SourceCodeAnalyzerFactory();
        fileReader = mock(SourceFileReader.class);
    }

    @Test
    public void testCreateSourceCodeAnalyzerRegex() {
        SourceCodeAnalyzer regexAnalyzer = factory.createSourceCodeAnalyzer("regex", fileReader);
        assertTrue(regexAnalyzer instanceof RegexAnalyzer);
    }

    @Test
    public void testCreateSourceCodeAnalyzerStrComp() {
        SourceCodeAnalyzer strcompAnalyzer = factory.createSourceCodeAnalyzer("strcomp", fileReader);
        assertTrue(strcompAnalyzer instanceof StringComparisonAnalyzer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateSourceCodeAnalyzerInvalidType() {
        factory.createSourceCodeAnalyzer("invalid", fileReader);
    }
}
