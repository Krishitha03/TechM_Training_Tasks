package task1;
import java.util.Scanner;

public class task5 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the string to be modified:");
        String input=s.nextLine();
        s.close();
        StringBuilder modifiedString=new StringBuilder();
        modifiedString.append(input.toLowerCase());
        for(int i=0;i<modifiedString.length();i++){
            if(i%2==0)
            modifiedString.setCharAt(i,Character.toUpperCase(modifiedString.charAt(i)));
        }
        System.out.println(modifiedString);
    }
}
