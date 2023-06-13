package codeanalyzer.SourceFileReader;

/**
 * The SourceFileReaderFactory class is responsible for creating instances of
 * different types of SourceFileReader based on the requested type.
 * It provides a method to create a specific type of SourceFileReader.
 * The available reader types are "local" and "web".
 * If an invalid type is requested, it throws an IllegalArgumentException.
 *
 * This class follows the Factory design pattern.
 * The createSourceFileReader method returns an instance of the requested reader type.
 *
 * @see SourceFileReader
 * @see LocalFileReader
 * @see WebFileReader
 *
 * @author  Marsid Mali
 * @version 1.0
 * @since   2023-06-10
 */
public class SourceFileReaderFactory {

    /**
     * Creates a SourceFileReader object based on the specified reader type.
     *
     * @param type the type of the source file reader
     * @return the created SourceFileReader object
     * @throws IllegalArgumentException if the reader type is invalid
     */
    public SourceFileReader createSourceFileReader(String type) {
        if (type.equalsIgnoreCase("local")) {
            return new LocalFileReader();
        } else if (type.equalsIgnoreCase("web")) {
            return new WebFileReader();
        } else {
            throw new IllegalArgumentException("Invalid type of SourceFileReader: " + type);
        }
    }
}