//Anthony Nguyen, 10-10-2015, Assignment 5
//The purpose of the program is to demonstrate
//Java regular expressions and word sorting capabilities.

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UniqueWordsReader {

    public static void main(String[] args) {
        String filePath = "collection_of_words.txt";

        try {
            //Read the file
            String content = new String(Files.readAllBytes(Paths.get(filePath)));

            //process and gather ncessary text into array
            String cleanedContent = content.toLowerCase().replaceAll("[^a-zA-Z\\s]", "");
            String[] words = cleanedContent.split("\\s+"); // Split by one or more spaces

            //TreeSet = autosort, duplicate elements are ignored
            Set<String> uniqueSortedWords = new TreeSet<>();
            for (String word : words) {
                if (!word.trim().isEmpty()) { // Avoid adding empty strings
                    uniqueSortedWords.add(word.trim());
                }
            }

            //print the set in ascending order
            System.out.println("Unique and sorted words:\n");
            for (String word : uniqueSortedWords) {
                System.out.print(word + " ");
            }
            
            //create and new list to print in reverse order
            List<String> reversedWords = new ArrayList<>(uniqueSortedWords);
            Collections.sort(reversedWords, Collections.reverseOrder());
            System.out.println("\n\nUnique and sorted words in reverse:\n");
            for (String word : reversedWords) {
                System.out.print(word + " ");
            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}