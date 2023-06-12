package codeanalyzer.SourceFileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The LocalFileReader class is responsible for reading a local file and returning its contents.
 * It implements the SourceFileReader interface and provides methods to read the file into a list
 * of lines or as a single string.
 *
 * @see SourceFileReader
 *
 * @author  Marsid Mali
 * @version 1.0
 * @since   2023-06-10
 */
public class LocalFileReader implements SourceFileReader {

    /**
     * Reads a local file and returns its contents as a list of lines.
     *
     * @param filePath the path to the local file
     * @return a list of lines read from the file
     * @throws IOException if an I/O error occurs
     */
    @Override
    public List<String> readFileIntoList(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();
        File file = new File(filePath);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        return lines;
    }

    /**
     * Reads a local file and returns its contents as a single string.
     *
     * @param filePath the path to the local file
     * @return the content of the file as a string
     * @throws IOException if an I/O error occurs
     */
    @Override
    public String readFileIntoString(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        File file = new File(filePath);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        reader.close();
        return sb.toString();
    }
}

