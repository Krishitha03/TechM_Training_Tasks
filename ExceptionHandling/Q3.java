package ExceptionHandling;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Q3 {
    public static void readFile() throws IOException{
        FileReader reader=new FileReader("D:\\TechMTasks\\Week3Tasks\\ExceptionHandling\\doc.txt");
        System.out.println((char)reader.read());
        reader.close();
    }
    public static void main(String[] args) {
        try{
            readFile();
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
