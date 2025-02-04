import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandling {
    public static void processInput() {

        try {
            Scanner s = new Scanner(System.in);
            System.out.print("Enter number1: ");
            int number1 = s.nextInt();
            System.out.print("Enter number2: ");
            int number2 = s.nextInt();
            int reciprocal = number2 / number1;
            System.out.println("Reciprocal value is " + reciprocal);
        } catch (ArithmeticException e) {
            System.out.println("Exception occured:" + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Exception occured: non-numerical input");
        }
    }

    public static void main(String[] args) {
        processInput();
    }
}
