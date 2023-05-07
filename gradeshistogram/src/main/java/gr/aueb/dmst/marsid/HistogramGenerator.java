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
 * @version 3.0
 * @since 2023-04-12
 */
public class HistogramGenerator {
	/**
	 * Reads grades from a file and returns an array of grades.
	 *
	 * @param fileName the path to the grades file.
	 * @return an array of grades read from the file.
	 * @throws IOException if an I/O error occurs while reading the file.
	 */

	private static int[] readGradesFile(String fileName) throws IOException {
		return Files.lines(Paths.get(fileName))
				.mapToInt(Integer::parseInt)
				.toArray();
	}

	/**
	 * Creates a histogram dataset from an array of grades.
	 *
	 * @param grades the array of grades.
	 * @return the created XYSeriesCollection representing the histogram dataset.
	 */
	private static XYSeriesCollection createHistogramDataset(int[] grades) {
		int[] frequencies = new int[11];
		for (int grade : grades) {
			frequencies[grade]++;
		}
		XYSeries data = new XYSeries("Grades");
		for (int i = 0; i < frequencies.length; i++) {
			data.add(i, frequencies[i]);
		}
		return new XYSeriesCollection(data);
	}

	/**
	 * Creates a histogram chart using the given dataset.
	 *
	 * @param dataset the dataset containing the histogram data.
	 * @return the created JFreeChart representing the histogram chart.
	 */
	private static JFreeChart createHistogramChart(XYSeriesCollection dataset) {
		return ChartFactory.createHistogram("Grades Histogram", "Grade", "Frequency", dataset);
	}

	/**
	 * Displays the given chart in a chart frame.
	 *
	 * @param chart the chart to be displayed.
	 */
	private static void displayChart(JFreeChart chart) {
		ChartFrame frame = new ChartFrame("Grades Histogram", chart);
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * The main method that reads a file containing grades, creates a histogram dataset from the grades,
	 * creates a histogram chart from the dataset, and displays the chart.
	 * @param args an array of command-line arguments, where the first argument should be the path to the grades file
	 * @throws IOException if an I/O error occurs while reading the grades file
	 */
	public static void main(String[] args) throws IOException {
		int[] grades = readGradesFile(args[0]);
		XYSeriesCollection dataset = createHistogramDataset(grades);
		JFreeChart chart = createHistogramChart(dataset);
		displayChart(chart);
	}
}
