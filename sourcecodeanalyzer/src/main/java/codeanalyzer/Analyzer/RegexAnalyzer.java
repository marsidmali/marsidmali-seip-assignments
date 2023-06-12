package codeanalyzer.Analyzer;

import codeanalyzer.SourceFileReader.SourceFileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The RegexAnalyzer class is responsible for analyzing source code files
 * using regular expressions.
 * It extends the SourceCodeAnalyzer abstract class.
 *
 * @author  Marsid Mali
 * @version 1.0
 * @since   2023-06-10
 */
public class RegexAnalyzer extends SourceCodeAnalyzer {

    /**
     * Constructs a RegexAnalyzer object with the given SourceFileReader.
     *
     * @param fileReader the SourceFileReader object to read the source code file
     */
    public RegexAnalyzer(SourceFileReader fileReader) {
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
        String sourceCode = fileReader.readFileIntoString(filepath);
        Pattern pattern = Pattern.compile("((//.*)|(/\\*.*)|(\\*+.*))");
        Matcher nonCodeLinesMatcher = pattern.matcher(sourceCode);

        int nonCodeLinesCounter = 0;
        while (nonCodeLinesMatcher.find()) {
            nonCodeLinesCounter++;
        }

        int sourceFileLength = sourceCode.split("\n").length;
        int loc = sourceFileLength - nonCodeLinesCounter;

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
        String sourceCode = fileReader.readFileIntoString(filepath);
        Pattern pattern = Pattern.compile(
                ".*(public |protected |private |static )?[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;]).*");
        Matcher methodSignatures = pattern.matcher(sourceCode);

        int methodCounter = 0;
        while (methodSignatures.find()) {
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
        String sourceCode = fileReader.readFileIntoString(filepath);
        Pattern pattern = Pattern.compile(".*\\s*class\\s+.*");
        Matcher classSignatures = pattern.matcher(sourceCode);

        int classCounter = 0;
        while (classSignatures.find()) {
            classCounter++;
        }
        return classCounter;
    }
}
