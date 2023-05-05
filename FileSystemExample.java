package filesystemexample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileSystemExample {

    public static void main(String[] args) {

        File file = new File("/temp/test.log");
        File directory = new File("/flash");

        String[] files = directory.list();
        
        System.out.println("Listing files in the Flash folder.\n");
        
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }

        System.out.println(String.format("\nPath for sample file is: %s", file.getAbsolutePath()));

        // Write content to the file
        try ( BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            String fileContent = "This is a sample text.";
            bufferedWriter.write(fileContent);
        } catch (IOException e) {
            // Exception handling
        }

        // Read content from the file
        try ( BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            // Exception handling
        } catch (IOException e) {
            // Exception handling
        }
    }
}
