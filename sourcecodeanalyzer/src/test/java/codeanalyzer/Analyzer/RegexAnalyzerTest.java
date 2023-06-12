package codeanalyzer.Analyzer;

import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import codeanalyzer.SourceFileReader.SourceFileReader;
import org.junit.Before;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author  Marsid Mali
 * @version 1.0
 * @since   2023-06-10
 */
public class RegexAnalyzerTest {
    private RegexAnalyzer regexAnalyzer;
    private static final String TEST_CLASS = "src/test/resources/TestClass.java";
    private static String SAMPLE_CODE= "public class Class1 {\n" + "\t\t// simple comment\n" + "// simple comment 2\n" +
                                       "\n" + " /* long comment 1 */\n" + " \n" + " /* \n" + " * \n" + " * long comment 2 \n" +
                                       " */\n" + "\n" + "\tpublic void foo() {}\n" + "\n" + "\tString foo2() {\n" +
                                       "\t\tint x = Math.pow(2,2);\n" + "\t}\n" + "}\n" + "\n" + "class Class2{\n" + "\n" +
                                       "\tstatic void foo3(){\n" + "\n" + "} \n" + "\n" + "}\n" + "\n" + "class Class3 {\n" +
                                       "\t/***\n" + "\t*\n" + "\t* Javadoc comment\n" + "\t*/\n" + "}";


    @Before
    public void setUp() throws IOException {
        SourceFileReader fileReader = mock(SourceFileReader.class);
        when(fileReader.readFileIntoString(TEST_CLASS)).thenReturn(SAMPLE_CODE);
        regexAnalyzer = new RegexAnalyzer(fileReader);
    }

    @Test
    public void testCalculateLOC() throws IOException {
        assertEquals(21, regexAnalyzer.calculateLOC(TEST_CLASS));
    }

    @Test
    public void testCalculateNOM() throws IOException {
        assertEquals(3, regexAnalyzer.calculateNOM(TEST_CLASS));
    }

    @Test
    public void testCalculateNOC() throws IOException {
        assertEquals(3, regexAnalyzer.calculateNOC(TEST_CLASS));
    }
}