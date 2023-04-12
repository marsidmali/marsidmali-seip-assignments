package gr.aueb.dmst.marsid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * The HistogramGenerator class reads a file with grades and generates a histogram showing the frequency
 * distribution of the grades.
 * The class uses the JFreeChart library to generate the histogram.
 *
 * @author Marsid Mali
 * @version 1.0
 * @since 2023-04-12
 */

public class HistogramGenerator {

	private int[] grades;
	/**
	 * Constructor for the HistogramGenerator class. Reads the grades from the specified file.
	 *
	 * @param path The path of the file containing the grades.
	 * @throws IOException If there is an error reading the file.
	 */

	public HistogramGenerator(String path) throws IOException {
		grades = Files.lines(Paths.get(path))
				.mapToInt(Integer::parseInt)
				.toArray();
	}

	/**
	 * Sets the grades for the HistogramGenerator object.
	 *
	 * @param grades An array of integers representing the grades.
	 */

	public void setGrades(int[] grades) {
		this.grades = grades;
	}

	/**
	 * Gets the grades for the HistogramGenerator object.
	 *
	 * @return An array of integers representing the grades.
	 */
	public int[] getGrades() {
		return grades;
	}

	/**
	 * Generates a histogram of the grades.
	 *
	 * @param freqs An array of integers representing the frequency of each grade.
	 */
	public void generateHistogram(int[] freqs) {
		XYSeries data = new XYSeries("Grades");
		for (int i = 0; i < freqs.length; i++) {
			data.add(i, freqs[i]);
		}

		XYSeriesCollection dataset = new XYSeriesCollection(data);
		JFreeChart chart = ChartFactory.createXYLineChart("Grades Histogram", "Grades", "Frequency", dataset);
		ChartFrame frame = new ChartFrame("Grades Chart", chart);
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Main method for the HistogramGenerator class. Reads the grades from a file, generates the frequency
	 * distribution of the grades, and generates a histogram of the grades.
	 *
	 * @param args The command line arguments.
	 * @throws IOException If there is an error reading the file.
	 */
	public static void main(String[] args) throws IOException {
		HistogramGenerator hist = new HistogramGenerator(args[0]);
		int[] freqs = new int[11];
		for (int grade : hist.getGrades()) {
			freqs[grade]++;
		}
		hist.generateHistogram(freqs);
	}

}