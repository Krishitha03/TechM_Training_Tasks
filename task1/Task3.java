package task1;

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        int array1[]={22,32,45,10,87};
        int array2[]={54,78,65,11,43};
        int array3[]={22,32,45,10,87};
        int array4[][]={{2,1,3},{4,2,1}};
        int array5[][]={{2,1,3},{4,2,1}};
        int array6[][]={{2,1,3},{6,8,3}};
        String arr1[]={"he","ll","o"};
        String arr2[]={"he","ll","o"}; 

        //equals method
        //equals method is efficient for 1D arrays only
        System.out.println("output of Arrays.equals(array1,array3)="+Arrays.equals(array1,array3));
        System.out.println("output of Arrays.equals(array2,array3)="+Arrays.equals(array2,array3));
        System.out.println("output of Arrays.equals(array1,array3)="+Arrays.equals(array4,array5));

        //deepEquals method
        //deepEquals method is only efficient for 2D array and when used for 1D array ,only non-primitive datatypes can be passed as arguments
        System.out.println("output of Arrays.deepEquals(array1, array3)="+Arrays.deepEquals(arr1, arr2));
        System.out.println("ouput of Arrays.deepEquals(array4, array5)="+Arrays.deepEquals(array4, array5));
        System.out.println("output of Arrays.deepEquals(array5, array6)="+Arrays.deepEquals(array5, array6));
    }
}
