package codeanalyzer.MetricsExporter;

import org.junit.Test;

/**
 * @author  Marsid Mali
 * @version 1.0
 * @since   2023-06-10
 */
public class JSONExporterTest {
    MetricsExporter exporter = new JSONExporter();

    @Test (expected = IllegalArgumentException.class)
    public void testWriteToFile() {
        exporter.writeFile("dummy/filepath", null);
    }

}