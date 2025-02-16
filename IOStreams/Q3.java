package IOStreams;

import java.io.File;

public class Q3 {
    public static void main(String[] args) {
        // Get the directory path
        String directoryPath = "D:/TechMTasks/Week3Tasks";
        File directory = new File(directoryPath);
        
        // Check if the path is a directory and Get all files and directories in the specified directory
        if (directory.isDirectory()) 
            System.out.println(directory+" exists");
        else
            System.out.println(directory+" does not exist");
    }
}
