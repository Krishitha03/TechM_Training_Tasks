import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        LibraryManager library = new LibraryManager();

        // Initialize library
        library.addBook(new Book("Java Programming", "John Doe", "123"));
        library.addBook(new Book("Python Basics", "Jane Doe", "456"));
        library.addUser(new User("Alice", "U001"));
        library.addUser(new User("Bob", "U002"));

        // Demonstrate multithreading
        Thread user1 = new Thread(() -> {
            try {
                library.borrowBook("123", "U004");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        Thread user2 = new Thread(() -> {
            try {
                library.borrowBook("123", "U002");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        user1.start();
        user2.start();

        try {
            user1.join();
            user2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Save and load data
        try {
            library.saveLibraryData();
            library.loadLibraryData();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
