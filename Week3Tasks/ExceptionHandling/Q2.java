package ExceptionHandling;

public class Q2 {
    public static void oddCheck(int number) throws OddException{
        if(number%2!=0)
            throw new OddException("This is a odd number.");
    }
    public static void main(String[] args) {
        int number=25;
        try{
            oddCheck(number);
        }
        catch(Exception e){
            System.out.println("Exception occured: "+e.getMessage());
        }
        finally{
            System.out.println("Given number: "+number);
        }
    }
}
