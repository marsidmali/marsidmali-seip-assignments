package codeanalyzer.SourceFileReader;

/**
 * The SourceFileReaderFactory class is responsible for creating instances of SourceFileReader.
 * It provides the createSourceFileReader method to create a SourceFileReader based on the given type.
 *
 * @author  Marsid Mali
 * @version 1.0
 * @since   2023-06-10
 */
public class SourceFileReaderFactory {

    /**
     * Creates a SourceFileReader instance based on the given type.
     * Supported types are "local" and "web". If an unsupported type is provided,
     * a NullFileReader instance is returned.
     *
     * @param type the type of the SourceFileReader to create
     * @return a SourceFileReader instance
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
