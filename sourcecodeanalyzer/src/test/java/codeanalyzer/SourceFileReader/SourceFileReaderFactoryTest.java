package codeanalyzer.SourceFileReader;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * @author  Marsid Mali
 * @version 1.0
 * @since   2023-06-10
 */
public class SourceFileReaderFactoryTest {
    SourceFileReaderFactory sff = new SourceFileReaderFactory();

    @Test
    public void testCreateLocalSourceFileReader() {
        SourceFileReader local = sff.createSourceFileReader("local");
        assertTrue(local instanceof LocalFileReader);
    }

    @Test
    public void testCreateWebSourceFileReader() {
        SourceFileReader web = sff.createSourceFileReader("web");
        assertTrue(web instanceof WebFileReader);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateSourceFileReaderInvalidType() {
        sff.createSourceFileReader("invalid");
    }
}