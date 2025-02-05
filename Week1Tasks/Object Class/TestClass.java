public class TestClass {
    public static void main(String[] args) {
        User userobj=new User("User1", 21);
        SecondUser secondUserObj=new SecondUser("User2", 22);
        System.out.println("Overriden of toString() in User "+userobj);
        System.out.println("toString() in SecondUser "+secondUserObj);
        System.out.println("Overriden of hashCode() in User "+userobj.hashCode());
        System.out.println("hashCode() in SecondUser "+secondUserObj.hashCode());
        System.out.println("Overriden of equals() in User "+userobj.equals(userobj));
        System.out.println("equals() in SecondUser "+secondUserObj.equals(secondUserObj));
    }
}
