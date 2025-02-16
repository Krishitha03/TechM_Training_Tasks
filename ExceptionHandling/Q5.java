package ExceptionHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Q5 {
    public static void readFile() throws IOException,EmptyFileException{
        BufferedReader reader=new BufferedReader(new FileReader("D:\\TechMTasks\\Week3Tasks\\ExceptionHandling\\doc2.txt"));
        String content=reader.readLine();
        reader.close();
        if(content==null){
            throw new EmptyFileException("The file is empty.");
        }
        else
            System.out.println(content);
    }
    public static void main(String[] args) {
        try{
            readFile();
        }
        catch(IOException|EmptyFileException e){
            System.out.println(e.getMessage());
        }
    }
}
