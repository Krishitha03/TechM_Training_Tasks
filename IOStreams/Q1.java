package IOStreams;

import java.io.File;
public class Q1 {
    public static void main(String[] args) {
        // Get the directory path
        String directoryPath = "D:/TechMTasks/Week3Tasks";
        File directory = new File(directoryPath);
        
        // Check if the path is a directory and Get all files and directories in the specified directory
        if (directory.isDirectory()) {
            String[] filesAndDirs = directory.list();
            
            // Check if the directory is not empty
            if (filesAndDirs != null && filesAndDirs.length > 0) {
                System.out.println("Files and directories in " + directoryPath + ":");
                for (String fileName : filesAndDirs) {
                    System.out.println(fileName);
                }
            } else {
                System.out.println("The directory is empty.");
            }
        } else {
            System.out.println("The specified path is not a valid directory.");
        }
    }
}