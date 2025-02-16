package task1;
import java.util.Arrays;

public class task4 {
    //user-defined method
    public int[] arrayCopyRange(int arr[],int a,int b){
        int j=0;
        int arrCopy[]=new int[(b-a)+1];
        for(int i=0;i<arr.length;i++){
            if(i>=a&&i<=b){
                arrCopy[j]=arr[i];
                j++;
            }
        }
        return arrCopy;
    }

    public static void main(String[] args) {
        task4 obj=new task4();
        int arrCopy[]=obj.arrayCopyRange(new int[]{4,6,2,1,2,7,8},2,4);
        System.out.println(Arrays.toString(arrCopy));
    }
}