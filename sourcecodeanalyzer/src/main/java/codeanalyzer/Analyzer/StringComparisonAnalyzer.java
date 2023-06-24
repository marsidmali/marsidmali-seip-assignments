package codeanalyzer.Analyzer;

import codeanalyzer.SourceFileReader.SourceFileReader;
import java.io.IOException;
import java.util.List;

/**
 * The StringComparisonAnalyzer class is responsible for analyzing source code files
 * using string comparison techniques.
 * It extends the SourceCodeAnalyzer abstract class.
 *
 * @author  Marsid Mali
 * @version 1.0
 * @since   2023-06-10
 */
public class StringComparisonAnalyzer extends SourceCodeAnalyzer {
    /**
     * Constructs a StringComparisonAnalyzer object with the given SourceFileReader.
     *
     * @param fileReader the SourceFileReader object to read the source code file
     */
    public StringComparisonAnalyzer(SourceFileReader fileReader) {
        super(fileReader);
    }

    /**
     * Calculates the number of lines of code (LOC) in the specified source code file.
     *
     * @param filepath the path to the source code file
     * @return the number of lines of code in the file
     * @throws IOException if an I/O error occurs while reading the file
     */
    @Override
    public int calculateLOC(String filepath) throws IOException {
        List<String> sourceCodeList = fileReader.readFileIntoList(filepath);
        int nonCodeLinesCounter = 0;
        for (String line : sourceCodeList) {
            line = line.trim(); // clear all leading and trailing white spaces
            if (line.startsWith("//") || line.startsWith("/*") || line.startsWith("*") || line.equals("{")
                    || line.equals("}") || line.equals(""))
                nonCodeLinesCounter++;
        }
        int loc = sourceCodeList.size() - nonCodeLinesCounter;
        return loc;
    }

    /**
     * Calculates the number of methods (NOM) in the specified source code file.
     *
     * @param filepath the path to the source code file
     * @return the number of methods in the file
     * @throws IOException if an I/O error occurs while reading the file
     */
    @Override
    public int calculateNOM(String filepath) throws IOException {
        List<String> sourceCodeList = fileReader.readFileIntoList(filepath);
        int methodCounter = 0;
        for (String line : sourceCodeList) {
            line = line.trim(); // clear all leading and trailing white spaces
            if (((line.contains("public") || line.contains("private") || line.contains("protected"))
                    || line.contains("void") || line.contains("int") || line.contains("String")) && line.contains("(")
                    && line.contains(")") && line.contains("{"))
                methodCounter++;
        }
        return methodCounter;
    }

    /**
     * Calculates the number of classes (NOC) in the specified source code file.
     *
     * @param filepath the path to the source code file
     * @return the number of classes in the file
     * @throws IOException if an I/O error occurs while reading the file
     */
    @Override
    public int calculateNOC(String filepath) throws IOException {
        List<String> sourceCodeList = fileReader.readFileIntoList(filepath);
        int classCounter = 0;
        for (String line : sourceCodeList) {
            line = line.trim(); // remove leading and trailing white spaces
            if ((line.startsWith("class ") || line.contains(" class ")) && line.contains("{")) {
                classCounter++;
            }
        }
        return classCounter;
    }
}
