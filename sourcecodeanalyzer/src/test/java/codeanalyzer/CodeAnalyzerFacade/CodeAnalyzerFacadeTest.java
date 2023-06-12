package codeanalyzer.CodeAnalyzerFacade;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;

/**
 * @author  Marsid Mali
 * @version 1.0
 * @since   2023-06-10
 */
public class CodeAnalyzerFacadeTest {

    private String testFilepath;
    private String testSourceCodeAnalyzerType;
    private String testSourceFileLocation;
    private String testOutputFilePath;
    private String testOutputFileType;

    @Before
    public void setUp() {
        testFilepath = "src/main/resources/TestClass.java";
        testSourceCodeAnalyzerType = "regex";
        testSourceFileLocation = "local";
        testOutputFilePath = "output_metrics";
        testOutputFileType = "csv";
    }

    @Test
    public void testCalculateMetrics() throws IOException {
        CodeAnalyzerFacade.calculateMetrics(testFilepath, testSourceCodeAnalyzerType, testSourceFileLocation,
                testOutputFilePath, testOutputFileType );

        File file = new File(String.format("%s.%s", testOutputFilePath, testOutputFileType));
        assertTrue(file.exists());
        file.delete();
    }
}

