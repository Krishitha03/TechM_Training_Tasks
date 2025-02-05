
public final class FinalKeywordChild extends FinalKeyword {
    public static void main(String[] args) {
        System.out.println("child class of FinalKeyword class");
    }
    //method declared with final keyword cannot be overriden
    @Override
    public void FinalMethod(){
        System.out.println("from inherited method");
    }
}
