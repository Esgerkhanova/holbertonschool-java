import java.util.Objects;

public class Post implements Comparable<Post> {
    private Author author;
    private String title;
    private String description;
    private Categories category;

    public Post(Author author, String title, String description, Categories category) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.category = category;
    }

    public Author getAuthor() { return author; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public Categories getCategory() { return category; }

    // MUST return <title>
    @Override
    public String toString() {
        return title;
    }

    // Sort by title (required), then tie-breakers to avoid losing items in TreeSet
    @Override
    public int compareTo(Post other) {
        int byTitle = this.title.compareToIgnoreCase(other.title);
        if (byTitle != 0) return byTitle;

        int byAuthor = this.author.compareTo(other.author);
        if (byAuthor != 0) return byAuthor;

        int byCategory = this.category.compareTo(other.category);
        if (byCategory != 0) return byCategory;

        return this.description.compareToIgnoreCase(other.description);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return Objects.equals(author, post.author) &&
               Objects.equals(title, post.title) &&
               Objects.equals(description, post.description) &&
               category == post.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title, description, category);
    }
}
