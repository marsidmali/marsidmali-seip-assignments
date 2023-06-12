package codeanalyzer.SourceFileReader;

import java.io.IOException;
import java.util.List;

/**
 * The SourceFileReader interface defines the contract for classes that can read source files.
 * It provides methods to read a file into a list of lines or as a single string.
 *
 * @author  Marsid Mali
 * @version 1.0
 * @since   2023-06-10
 */
public interface SourceFileReader {

	/**
	 * Reads a source file and returns its contents as a list of lines.
	 *
	 * @param filePath the path to the source file
	 * @return a list of lines read from the file
	 * @throws IOException if an I/O error occurs
	 */
	List<String> readFileIntoList(String filePath) throws IOException;

	/**
	 * Reads a source file and returns its contents as a single string.
	 *
	 * @param filePath the path to the source file
	 * @return the content of the file as a string
	 * @throws IOException if an I/O error occurs
	 */
	String readFileIntoString(String filePath) throws IOException;

}
