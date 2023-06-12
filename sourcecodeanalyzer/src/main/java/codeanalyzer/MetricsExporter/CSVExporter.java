package codeanalyzer.MetricsExporter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * The CSVExporter class is responsible for exporting metrics to a CSV file.
 * It implements the MetricsExporter interface and provides the writeFile method
 * to write the metrics to a CSV file.

 * @see MetricsExporter
 *
 * @author  Marsid Mali
 * @version 1.0
 * @since   2023-06-10
 */
public class CSVExporter implements MetricsExporter {

    /**
     * Writes the metrics to a CSV file at the specified filePath.
     *
     * @param filePath the path to the output file (without the file extension)
     * @param metrics a map containing the metrics to export
     */
    @Override
    public void writeFile(String filePath, Map<String, Integer> metrics) {
        File outputFile = new File(filePath + ".csv");
        StringBuilder metricsNames = new StringBuilder();
        StringBuilder metricsValues = new StringBuilder();

        for (Map.Entry<String, Integer> entry : metrics.entrySet()) {
            metricsNames.append(entry.getKey()).append(",");
            metricsValues.append(entry.getValue()).append(",");
        }

        try {
            FileWriter writer = new FileWriter(outputFile);
            writer.append(metricsNames).append("\n");
            writer.append(metricsValues).append("\n");
            writer.close();
            System.out.println("Metrics saved in " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
