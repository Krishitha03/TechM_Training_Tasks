import java.io.*;
import java.util.List;

public class LibraryManager extends LibrarySystem {
    private static final int MAX_BORROWED_BOOKS = 3;

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public synchronized void borrowBook(String ISBN, String userID) throws BookNotFoundException, UserNotFoundException, MaxBooksAllowedException {
        User user = findUser(userID);
        Book book = findBook(ISBN);

        if (user.getBorrowedBooks().size() >= MAX_BORROWED_BOOKS) {
            throw new MaxBooksAllowedException("User has already borrowed maximum books!");
        }

        if (book.isBorrowed()) {
            throw new BookNotFoundException("Book is already borrowed.");
        }

        book.setBorrowed(true);
        user.borrowBook(book);
        System.out.println(user.getName() + " borrowed " + book.getTitle());
    }

    @Override
    public synchronized void returnBook(String ISBN, String userID) throws BookNotFoundException, UserNotFoundException {
        User user = findUser(userID);
        Book book = findBook(ISBN);

        if (!user.getBorrowedBooks().contains(book)) {
            throw new BookNotFoundException("User did not borrow this book.");
        }

        book.setBorrowed(false);
        user.returnBook(book);
        System.out.println(user.getName() + " returned " + book.getTitle());
    }

    @Override
    public void reserveBook(String ISBN, String userID) throws BookNotFoundException, UserNotFoundException {
        System.out.println("Reservation feature is under development.");
    }

    @Override
    public Book searchBook(String title) {
        return books.stream().filter(b -> b.getTitle().equalsIgnoreCase(title)).findFirst().orElse(null);
    }

    private User findUser(String userID) throws UserNotFoundException {
        return users.stream().filter(u -> u.getUserID().equals(userID)).findFirst()
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    private Book findBook(String ISBN) throws BookNotFoundException {
        return books.stream().filter(b -> b.getISBN().equals(ISBN)).findFirst()
                .orElseThrow(() -> new BookNotFoundException("Book not found"));
    }

    public void saveLibraryData() throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("library_data.dat"))) {
            out.writeObject(books);
            out.writeObject(users);
        }
    }

    public void loadLibraryData() throws IOException, ClassNotFoundException {
        File file = new File("library_data.dat");
        if (!file.exists()) return;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            books = (List<Book>) in.readObject();
            users = (List<User>) in.readObject();
        }
    }
}
