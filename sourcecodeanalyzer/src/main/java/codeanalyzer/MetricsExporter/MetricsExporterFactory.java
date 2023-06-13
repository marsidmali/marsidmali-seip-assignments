package codeanalyzer.MetricsExporter;

/**
 * The MetricsExporterFactory class is responsible for creating instances of
 * different types of MetricsExporter based on the requested type.
 * It provides a method to create a specific type of MetricsExporter.
 * The available exporter types are "csv" and "json".
 * If an invalid type is requested, it throws an IllegalArgumentException.
 *
 * This class follows the Factory design pattern.
 * The createMetricsExporter method returns an instance of the requested exporter type.
 *
 * @see MetricsExporter
 * @see CSVExporter
 * @see JSONExporter
 *
 * @author  Marsid Mali
 * @version 1.0
 * @since   2023-06-10
 */
public class MetricsExporterFactory {

    /**
     * Creates a MetricsExporter object based on the specified exporter type.
     *
     * @param type the type of the metrics exporter
     * @return the created MetricsExporter object
     * @throws IllegalArgumentException if the exporter type is invalid
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