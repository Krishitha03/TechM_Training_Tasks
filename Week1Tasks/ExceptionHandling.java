import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandling {
    //processInput method
    public static void processInput() {
        //putting the code in try block to catch the exception
        try {
            //getting input from user
            Scanner s = new Scanner(System.in);
            System.out.print("Enter number1: ");
            int number1 = s.nextInt();
            System.out.print("Enter number2: ");
            int number2 = s.nextInt();
            s.close();

            //to calculate reciprocal
            int reciprocal = number2 / number1;

            //printing value if no exception has occured and catched
            System.out.println("Reciprocal value is " + reciprocal);
        }
        //to catch arithematic exception 
        catch (ArithmeticException e) {
            System.out.println("Exception occured:" + e.getMessage());
        }
        //to catch input mismatch exception 
        catch (InputMismatchException e) {
            System.out.println("Exception occured: non-numerical input");
        }
    }

    public static void main(String[] args) {
        //to call method
        processInput();
    }
}
