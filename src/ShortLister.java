import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardOpenOption.CREATE;

import static java.nio.file.StandardOpenOption.CREATE;

public class ShortLister implements Filter {

    public boolean accept(Object x) {
        // Check if the word is short (less than 5 characters)
        String word = (String) x;
        return word.length() < 5;
    }

    public static void main(String[] args) {
        // Ask the user to choose a text file
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select a text file");
        int result = fileChooser.showOpenDialog(null);

        // If the user selects a file, read and process it
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                java.io.File file = fileChooser.getSelectedFile();
                BufferedReader reader = new BufferedReader(new FileReader(file));


                ShortLister filter = new ShortLister();

                // Read each line from the file and display short words
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] words = line.split("\\s+");
                    for (String word : words) {
                        if (filter.accept(word)) {
                            System.out.println(word);
                        }
                    }
                }
                reader.close(); // Close the file reader
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No file selected.");
        }
    }
}
