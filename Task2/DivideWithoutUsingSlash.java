import java.util.Scanner;

public class DivideWithoutUsingSlash {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number1: ");
        int number1 = s.nextInt();
        System.out.print("Enter number2: ");
        int number2 = s.nextInt();
        int remainder = number1;
        int quotient;
        for (quotient = 0; remainder >= number2; quotient++) {
            remainder -= number2;
        }
        System.out.println("Division=" + quotient);
        System.out.println("Remainder=" + remainder);
        s.close();
    }
}
