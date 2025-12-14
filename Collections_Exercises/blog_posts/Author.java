import java.util.Objects;

public class Author implements Comparable<Author> {
    private String name;
    private String surname;

    // MUST be exactly this signature for the checker:
    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

    @Override
    public int compareTo(Author other) {
        int byName = this.name.compareToIgnoreCase(other.name);
        if (byName != 0) return byName;
        return this.surname.compareToIgnoreCase(other.surname);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return Objects.equals(name, author.name) &&
               Objects.equals(surname, author.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }
}
