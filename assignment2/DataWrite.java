//Anthony Nguyen, CSD-420 Assignment 2.2, 09/21/2025
//The purpose of the program is to demonstrate file writing capabilities

//import packages for writing and file creation
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//only need random package
import java.util.Random;

public class DataWrite {

    public static void main(String[] args) {
        String file = "random_numbers.dat";
        
        //create array of 5 random ints and 5 random doubles
        int[] randint = new int[5];
        double[] randdoub = new double[5];
        Random random = new Random();
        
        for (int i = 0; i < 5; i++) {
            randint[i] = random.nextInt(101);
            randdoub[i] = random.nextDouble()*10;
        }
        
        /*
        for (int i : randint){
            System.out.println(i + " ");
        }
        //this block of code is to make sure what what stored in the arrays is what goes into the dat file
        for (double i : randdoub){
            System.out.println(i + " ");
        }
        */

        try (FileWriter fw = new FileWriter(file, true); PrintWriter pw = new PrintWriter(fw)) {
            //true for append, FieWriter for text; number will be written as text

            // Write the integer array
            for (int i : randint) {
                pw.println(i);//numbers will be written and read as text
            }

            // then write the double array
            for (double i : randdoub) {
                pw.println(i);
            }

            System.out.println("Successfully written to " + file);

        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}