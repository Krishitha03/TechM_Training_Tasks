
import java.util.Objects;

public class User {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // override toString()
    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }

    // override hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    // override
    @Override
    public boolean equals(Object obj) {
        // compared with same object
        if (obj == this)
            return true;
        // check object is not null or not instance User class
        if (!(obj instanceof User)) {
            return false;
        }
        // to compare data members
        User obj2 = (User) obj;
        return name == obj2.name && age == obj2.age;
    }

}
