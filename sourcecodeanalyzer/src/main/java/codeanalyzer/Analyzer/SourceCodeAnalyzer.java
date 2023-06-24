package codeanalyzer.Analyzer;

import codeanalyzer.SourceFileReader.SourceFileReader;
import java.io.IOException;

/**
 * The SourceCodeAnalyzer class is an abstract class that defines the common interface for
 * different types of source code analyzers.
 * Subclasses of SourceCodeAnalyzer implement specific analysis methods for calculating
 * metrics such as lines of code (LOC), number of methods (NOM), and number of classes (NOC).
 * The subclasses should override the abstract methods to provide the implementation specific to
 * the type of source code analyzer.

 *
 * @see StringComparisonAnalyzer
 * @see RegexAnalyzer
 * @see SourceFileReader
 *
 * @author  Marsid Mali
 * @version 1.0
 * @since   2023-06-10
 */
public abstract class SourceCodeAnalyzer {
	protected SourceFileReader fileReader;

	/**
	 * Constructs a SourceCodeAnalyzer object with the given SourceFileReader.
	 *
	 * @param fileReader the SourceFileReader object to read the source code file
	 */
	public SourceCodeAnalyzer(SourceFileReader fileReader) {
		this.fileReader = fileReader;
	}

	/**
	 * Calculates the number of lines of code (LOC) in the specified source code file.
	 *
	 * @param filepath the path to the source code file
	 * @return the number of lines of code in the file
	 * @throws IOException if an I/O error occurs while reading the file
	 */
	public abstract int calculateLOC(String filepath) throws IOException;

	/**
	 * Calculates the number of methods (NOM) in the specified source code file.
	 *
	 * @param filepath the path to the source code file
	 * @return the number of methods in the file
	 * @throws IOException if an I/O error occurs while reading the file
	 */
	public abstract int calculateNOM(String filepath) throws IOException;

	/**
	 * Calculates the number of classes (NOC) in the specified source code file.
	 *
	 * @param filepath the path to the source code file
	 * @return the number of classes in the file
	 * @throws IOException if an I/O error occurs while reading the file
	 */
	public abstract int calculateNOC(String filepath) throws IOException;
}
