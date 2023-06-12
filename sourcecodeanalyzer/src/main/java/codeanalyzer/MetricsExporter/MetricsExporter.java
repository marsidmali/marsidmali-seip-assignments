package codeanalyzer.MetricsExporter;

import java.util.Map;

/**
 * The MetricsExporter interface defines the contract for exporting metrics to a file.
 * Implementing classes should provide the writeFile method to perform the actual exporting.
 *
 * @author  Marsid Mali
 * @version 1.0
 * @since   2023-06-10
 */
public interface MetricsExporter {
	/**
	 * Writes the metrics to a file at the specified filePath.
	 *
	 * @param filePath the path to the output file (without the file extension)
	 * @param metrics a map containing the metrics to export
	 */
	void writeFile(String filePath, Map<String, Integer> metrics);
}
