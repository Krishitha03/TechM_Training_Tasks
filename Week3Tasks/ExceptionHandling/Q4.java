package ExceptionHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Q4 {
    public static void readFile() throws IOException,PositiveException {
        List<Integer> numbers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(
                new FileReader("D:\\TechMTasks\\Week3Tasks\\ExceptionHandling\\doc.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            // Split by commas instead of whitespace
            String[] tokens = line.split(",");

            // Convert each token to an integer and add it to the list
            for (String token : tokens) {
                numbers.add(Integer.parseInt(token.trim())); // Trim spaces and parse
            }
        }
        reader.close();
        for (Integer i : numbers) {
            if(i>0){
                throw new PositiveException("Positive number is present in the list.");
            }
        }
    }
    public static void main(String[] args) {
        try{
            readFile();
            System.out.println("no exception occured");
        }
        catch(PositiveException | IOException e){
            System.out.println("Exception occured: "+e.getMessage());
        }
    }
}
