package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

    /**
     * The FileIO provides simple file input/output operations
     * that serve as hands-on practice on Unit Testing.
     /**
     * @author  Marsid Mali
     * @version 2.0
     * @since   2023-05-20
     */
public class FileIO {

    /**
     * Reads a file that contains numbers line by line
     * and returns an array of the integers found in the file.
     * @param filepath the file that contains the numbers
     * @return an array of numbers
     * @exception IllegalArgumentException when the given file does not exist
     * @exception IllegalArgumentException when the given file is empty
     * @exception IOException when an IO interruption occurs (not required to be tested)
     */
    public int[] readFile(String filepath) {
        File file = new File(filepath);
        if (!file.exists())
            throw new IllegalArgumentException("Input file does not exist");

        List<Integer> numbersList = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    int number = Integer.parseInt(line);
                    numbersList.add(number);
                } catch (NumberFormatException e) {
                    // Ignore non-integer entries
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (numbersList.size() == 0)
            throw new IllegalArgumentException("Given file is empty");

        // Convert a List to an array using
        return numbersList.stream().mapToInt(i -> i).toArray();
    }
}