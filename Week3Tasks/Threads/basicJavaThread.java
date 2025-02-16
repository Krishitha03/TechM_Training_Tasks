package Threads;

public class basicJavaThread extends Thread {
    public static void main(String[] args) {
        basicJavaThread thread=new basicJavaThread();
        thread.start();
    }

    @Override
    public void run(){
        System.out.println("Hello, Java!");
    }
}
