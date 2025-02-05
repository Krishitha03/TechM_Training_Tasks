public class Dog extends Animal{
    //ovveriding makeSound() method from Animal class
    @Override
    public void makeSound(){
        System.out.println(DisplayMessage.dogSound);
    }
    public static void main(String[] args) {
        //creating object and calling the method
        Dog obj=new Dog();
        obj.makeSound();
    }
}
