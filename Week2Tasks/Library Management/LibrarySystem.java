import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class LibrarySystem implements ILibrary {
    protected List<Book> books = new CopyOnWriteArrayList<>();
    protected List<User> users = new CopyOnWriteArrayList<>();

    public abstract void addBook(Book book);
    public abstract void addUser(User user);
}
