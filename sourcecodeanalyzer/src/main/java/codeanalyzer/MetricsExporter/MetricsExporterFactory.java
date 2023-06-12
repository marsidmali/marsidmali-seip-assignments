package codeanalyzer.MetricsExporter;

/**
 * The MetricsExporterFactory class is responsible for creating instances of MetricsExporter.
 * It provides the createMetricsExporter method to create a MetricsExporter based on the given type.
 * If an invalid type is requested, it throws an IllegalArgumentException.
 *
 * @author  Marsid Mali
 * @version 1.0
 * @since   2023-06-10
 */
public class MetricsExporterFactory {

    /**
     * Creates a MetricsExporter instance based on the given type.
     * Supported types are "csv" and "json"(json is not implemented yet). If an unsupported type is provided,
     * a NullExporter instance is returned.
     *
     * @param type the type of the MetricsExporter to create
     * @return a MetricsExporter instance
     */
    public MetricsExporter createMetricsExporter(String type) {
        if (type.equalsIgnoreCase("csv")) {
            return new CSVExporter();
        } else if (type.equalsIgnoreCase("json")) {
            return new JSONExporter();
        } else {
            throw new IllegalArgumentException("Invalid type of exporter: " + type);
        }
    }
}
