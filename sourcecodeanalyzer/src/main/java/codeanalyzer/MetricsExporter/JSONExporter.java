package codeanalyzer.MetricsExporter;

import java.util.Map;

/**
 * The JSONExporter class is responsible for exporting metrics to a JSON file.
 * It implements the MetricsExporter interface but throws an exception
 * indicating that the functionality is not implemented yet.
 *
 * @see MetricsExporter
 *
 * @author  Marsid Mali
 * @version 1.0
 * @since   2023-06-10
 */
public class JSONExporter implements MetricsExporter {

    /**
     * Throws an IllegalArgumentException indicating that the functionality is not implemented yet.
     *
     * @param filePath the path to the output file (without the file extension)
     * @param metrics a map containing the metrics to export
     * @throws IllegalArgumentException always thrown indicating the functionality is not implemented
     */
    @Override
    public void writeFile(String filePath, Map<String, Integer> metrics) {
        throw new IllegalArgumentException("Functionality not implemented yet.");
    }
}
