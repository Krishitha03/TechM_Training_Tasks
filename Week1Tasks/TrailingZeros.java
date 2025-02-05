
import java.util.Scanner;

public class TrailingZeros {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        //the number for which factorial's trailing zeros are to be found
        System.out.print("Enter the number:");
        int n = s.nextInt();
        //initailising variable which can be updated for each iteration
        int count=0;
        if(n<5){
            count=0;
        }
        for (int i = 5; i <= n; i*=5) {
            //starting from i value of 5 each time the count is updated by the quotient and add to the previous count value 
            count += n / i;
        }
        System.out.println("for " + n + " is " + count);
    }
}
