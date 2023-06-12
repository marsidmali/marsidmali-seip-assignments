package codeanalyzer.Analyzer;

import codeanalyzer.SourceFileReader.SourceFileReader;

/**
 * The SourceCodeAnalyzerFactory class is responsible for creating instances of
 * different types of SourceCodeAnalyzer based on the requested type.
 * It provides a method to create a specific type of SourceCodeAnalyzer.
 * The available analyzer types are "regex" and "strcomp".
 * If an invalid type is requested, it throws an IllegalArgumentException.
 *
 * This class follows the Factory design pattern.
 * The createSourceCodeAnalyzer method returns an instance of the requested analyzer type.
 *
 * @see SourceCodeAnalyzer
 * @see RegexAnalyzer
 * @see StringComparisonAnalyzer
 * @see SourceFileReader
 *
 * @author  Marsid Mali
 * @version 1.0
 * @since   2023-06-10
 */
public class SourceCodeAnalyzerFactory {

    /**
     * Creates a SourceCodeAnalyzer object based on the specified analyzer type and source file reader.
     *
     * @param sourceCodeAnalyzerType the type of the source code analyzer
     * @param fileReader the source file reader to be used by the analyzer
     * @return the created SourceCodeAnalyzer object
     * @throws IllegalArgumentException if the analyzer type is invalid
     */
    public SourceCodeAnalyzer createSourceCodeAnalyzer(String sourceCodeAnalyzerType, SourceFileReader fileReader) {
        if (sourceCodeAnalyzerType.equalsIgnoreCase("regex")) {
            return new RegexAnalyzer(fileReader);
        } else if (sourceCodeAnalyzerType.equalsIgnoreCase("strcomp")) {
            return new StringComparisonAnalyzer(fileReader);
        } else {
            throw new IllegalArgumentException("Invalid type of analyzer: " + sourceCodeAnalyzerType);
        }
    }
}

