package Task2;
import java.util.Scanner;

public class DivideWithoutUsingSlash {
    public static void main(String[] args) {
        //for getting input from user
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number1: ");
        int number1 = s.nextInt();
        System.out.print("Enter number2: ");
        int number2 = s.nextInt();

        //declaring and initialising variable to perform operations
        int remainder = number1;
        int quotient;

        //calculating remainder by subtracting number2 from number1 and increamenting quotient until remainder>=number2 
        for (quotient = 0; remainder >= number2; quotient++) {
            remainder -= number2;
        }
        System.out.println("Division=" + quotient);
        System.out.println("Remainder=" + remainder);
        s.close();
    }
}
