
import java.util.Arrays;

public class PrimitiveAndReferenceVariables{
    //call by reference example
    public static void CallByReference(int[] arr){
        arr[0]=7;
    }
    public static void CallByValue(int n){
        n++;
    }
    public static void main(String[] args) {
        int n=5;
        int[] UserIds={1,2,3,4};
        /*for non-primitive datatype the reference address is passed while calling the function.
        So when array is changed inside function ,it is changed in the original array itself. */
        CallByReference(UserIds);
        /*for primitive datatype value is passed and it takes other memory when passing it calling method.
         So it will not change the original value.*/
        CallByValue(n);
        System.out.println(Arrays.toString(UserIds));
        System.out.println(n);
    }
}
