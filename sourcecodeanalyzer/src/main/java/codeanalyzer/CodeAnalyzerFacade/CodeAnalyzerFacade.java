package codeanalyzer.CodeAnalyzerFacade;

import codeanalyzer.Analyzer.SourceCodeAnalyzer;
import codeanalyzer.Analyzer.SourceCodeAnalyzerFactory;
import codeanalyzer.MetricsExporter.MetricsExporter;
import codeanalyzer.MetricsExporter.MetricsExporterFactory;
import codeanalyzer.SourceFileReader.SourceFileReader;
import codeanalyzer.SourceFileReader.SourceFileReaderFactory;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * The CodeAnalyzerFacade class provides a simplified interface for calculating code metrics
 * using a specific source code analyzer, source file reader, and metrics exporter.
 * It encapsulates the complexity of instantiating the necessary objects and performing the calculations.
 *
 * @author  Marsid Mali
 * @version 1.0
 * @since   2023-06-10
 */
public class CodeAnalyzerFacade {

    /**
     * Calculates code metrics for a given source code file and exports the metrics to a file.
     *
     * @param filepath               the path to the source code file
     * @param sourceCodeAnalyzerType the type of source code analyzer to use
     * @param sourceFileLocation     the location of the source file (local or web)
     * @param outputFilePath         the path for the output file
     * @param outputFileType         the type of the output file (csv, json, etc.)
     * @throws IOException if an I/O error occurs
     */
    public static void calculateMetrics(String filepath, String sourceCodeAnalyzerType, String sourceFileLocation,
                                        String outputFilePath, String outputFileType) throws IOException {

        // Create the source file reader
        SourceFileReaderFactory readerFactory = new SourceFileReaderFactory();
        SourceFileReader reader = readerFactory.createSourceFileReader(sourceFileLocation);

        // Create the source code analyzer using the selected analyzer type and source file reader
        // following the bridge pattern between SourceCodeAnalyzer and SourceFileReader
        SourceCodeAnalyzerFactory analyzerFactory = new SourceCodeAnalyzerFactory();
        SourceCodeAnalyzer analyzer = analyzerFactory.createSourceCodeAnalyzer(sourceCodeAnalyzerType, reader);

        // Calculate the metrics using the analyzer
        int loc = analyzer.calculateLOC(filepath);
        int nom = analyzer.calculateNOM(filepath);
        int noc = analyzer.calculateNOC(filepath);

        // Create a map to store the calculated metrics
        Map<String, Integer> metrics = new HashMap<>();
        metrics.put("loc", loc);
        metrics.put("nom", nom);
        metrics.put("noc", noc);

        // Create the metrics exporter
        MetricsExporterFactory exporterFactory = new MetricsExporterFactory();
        MetricsExporter exporter = exporterFactory.createMetricsExporter(outputFileType);

        // Export the metrics to the output file
        exporter.writeFile(outputFilePath, metrics);
    }
}

