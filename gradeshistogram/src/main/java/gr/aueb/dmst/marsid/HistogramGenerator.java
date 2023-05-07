package gr.aueb.dmst.marsid;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.statistics.HistogramDataset;

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
	/**
	 * Reads the grades from a file and returns them as an array of doubles.
	 *
	 * @param fileName the name of the file to read the grades from
	 * @return an array of doubles representing the grades
	 * @throws IOException if an I/O error occurs while reading the file
	 */

	public double[] readGradesFile(String fileName) throws IOException {
		ArrayList<Double> grades = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line;
		while ((line = reader.readLine()) != null) {
			grades.add(Double.parseDouble(line));
		}
		reader.close();
		return grades.stream().mapToDouble(Double::doubleValue).toArray();
	}

	/**
	 * Creates a histogram dataset from an array of grades.
	 *
	 * @param gradesArray an array of doubles representing the grades
	 * @return a histogram dataset containing the grades data
	 */
	public HistogramDataset createHistogramDataset(double[] gradesArray) {
		HistogramDataset dataset = new HistogramDataset();
		dataset.addSeries("Grades", gradesArray, 10);
		return dataset;
	}

	/**
	 * Creates a histogram chart from a histogram dataset.
	 *
	 * @param dataset the histogram dataset to create the chart from
	 * @return a JFreeChart object representing the histogram chart
	 */
	public JFreeChart createHistogramChart(HistogramDataset dataset) {
		return ChartFactory.createHistogram("Grades Histogram", "Grades", "Frequency", dataset);
	}

	/**
	 * Displays a histogram chart in a frame.
	 *
	 * @param chart the histogram chart to display
	 */
	public void displayChart(JFreeChart chart) {
		ChartFrame frame = new ChartFrame("Histogram", chart);
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Main method that generates a histogram chart for a set of grades read from a file.
	 *
	 * @param args the command-line arguments (the name of the file to read the grades from)
	 * @throws IOException if an I/O error occurs while reading the file
	 */
	public static void main(String[] args) throws IOException {
		HistogramGenerator generator = new HistogramGenerator();
		double[] gradesArray = generator.readGradesFile(args[0]);
		HistogramDataset dataset = generator.createHistogramDataset(gradesArray);
		JFreeChart chart = generator.createHistogramChart(dataset);
		generator.displayChart(chart);
	}
}

