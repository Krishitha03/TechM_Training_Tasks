package ExceptionHandling;

public class Q1 {
    public static void main(String[] args) {
        int result=0;
        try{
        int input1=10;
        int input2=0;
        result=input1/input2;
        }
        catch(Exception e){
            System.out.println("Exception occured:"+e.getMessage());
        }
        finally{
            System.out.println(result);
        }
    }
}
