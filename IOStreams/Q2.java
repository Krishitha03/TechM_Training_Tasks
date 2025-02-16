package IOStreams;

import java.io.File;
import java.util.ArrayList;

public class Q2 {
    public static boolean searchForSub(String text,String sub){
        boolean bool=false;
        for (int i = 0; i <= text.length() - sub.length(); i++) {
            for (int j = 0; j < sub.length();j++) {
                if (text.charAt(i + j) != sub.charAt(j)) {
                    break;
                }
                else{
                    bool=true;
                    break;
                }
            }
        }
        return bool;
    }
    public static void main(String[] args) {
        // Get the directory path
        String directoryPath = "D:/TechMTasks/Week3Tasks";
        String userSearch=".java";
        File directory = new File(directoryPath);
        // Check if the path is a directory and Get all files and directories in the specified directory
        if (directory.isDirectory()) {
            String[] filesAndDirs = directory.list();
            ArrayList<String> neededFiles=new ArrayList<>();
            for(int i=0;i<filesAndDirs.length;i++){
                if(searchForSub(filesAndDirs[i], userSearch))
                    neededFiles.add(filesAndDirs[i]);
            }
            if (neededFiles.size()>0)
                neededFiles.forEach(System.out::println); 
            else
                System.out.println("No matches found.");
        }
        else
            System.out.println("The specified path is not a valid directory.");
    }
}
