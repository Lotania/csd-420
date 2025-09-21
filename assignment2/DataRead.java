//Anthony Nguyen, CSD-420 Assignment 2.2, 09/21/2025
//The purpose of the program is to demonstrate file reading capabilities

//import libraries for file reading
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataRead {
    public static void main(String[] args) {
        String file = "random_numbers.dat"; // target file name

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {//buffered reader for text based data
            
            String data;//this will carry the data out of the dat file and into readable print
            
            while ((data = reader.readLine()) != null) {
                System.out.println(data); // read each line until there's no more
            }
            
            System.out.println("Successfully read from " + file);
            
        } catch (IOException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }
}