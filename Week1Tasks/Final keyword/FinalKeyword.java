
public class FinalKeyword {
    
    public static void main(String[] args) {
        String name="Krishitha";
        final int age;
      //variable age value cannot be changed because it is declared with final keyword
        // age++;
        age=25;
        // age=26;
        System.out.println(name+"is"+age+"years old");
    }
  //FinalMethod cannot be overriden
    public static final void FinalMethod(){
        System.out.println("from inherited method");
    }
}
