package codeanalyzer.SourceFileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * The WebFileReader class is responsible for reading a file from a URL and returning its contents.
 * It implements the SourceFileReader interface and provides methods to read the file into a list
 * of lines or as a single string.
 *
 * @see SourceFileReader
 *
 * @author  Marsid Mali
 * @version 1.0
 * @since   2023-06-10
 */
public class WebFileReader implements SourceFileReader {

    /**
     * Reads a file from a URL and returns its contents as a list of lines.
     *
     * @param filePath the URL of the file
     * @return a list of lines read from the file
     * @throws IOException if an I/O error occurs
     */
    @Override
    public List<String> readFileIntoList(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();
        URL url = new URL(filePath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        return lines;
    }

    /**
     * Reads a file from a URL and returns its contents as a single string.
     *
     * @param filePath the URL of the file
     * @return the content of the file as a string
     * @throws IOException if an I/O error occurs
     */
    @Override
    public String readFileIntoString(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        URL url = new URL(filePath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        reader.close();
        return sb.toString();
    }
}
