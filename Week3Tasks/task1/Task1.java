package task1;
import java.util.ArrayList;

public class Task1{
    public static void main(String[] args) {
        //original array
        int array[]={2,6,1,4,9,7};
        //arraylists to store alternative array elements
        ArrayList<Integer> eveIndArr=new ArrayList<>();
        ArrayList<Integer> oddIndArr=new ArrayList<>();
        //adding alternate elements to the list
        for (int i=0;i<array.length;i++) {
            if(i%2==0)
                eveIndArr.add(array[i]);
            else
                oddIndArr.add(array[i]);
        }
        //print the output lists
        System.out.println("Even Indexed Elements: "+eveIndArr);
        System.out.println("Odd Indexed Elements: "+oddIndArr);
    }
}
