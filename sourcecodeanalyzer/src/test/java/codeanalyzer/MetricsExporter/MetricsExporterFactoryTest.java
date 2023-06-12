package codeanalyzer.MetricsExporter;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * @author  Marsid Mali
 * @version 1.0
 * @since   2023-06-10
 */
public class MetricsExporterFactoryTest {
    MetricsExporterFactory mef = new MetricsExporterFactory();

    @Test
    public void testCreateCSVExporter() {
        MetricsExporter csv = mef.createMetricsExporter("csv");
        assertTrue(csv instanceof CSVExporter);
    }

    @Test
    public void testCreateJSONExporter() {
        MetricsExporter json = mef.createMetricsExporter("json");
        assertTrue(json instanceof JSONExporter);
    }
}
