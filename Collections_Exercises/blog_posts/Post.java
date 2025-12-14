import java.util.Objects;

public class Post implements Comparable<Post> {
    private Author author;
    private String title;
    private String body;
    private Categories category;

    public Post(Author author, String title, String body, Categories category) {
        this.author = author;
        this.title = title;
        this.body = body;
        this.category = category;
    }

    public Author getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public Categories getCategory() {
        return category;
    }

    // must print only the title
    @Override
    public String toString() {
        return title;
    }

    // sort posts by title
    @Override
    public int compareTo(Post other) {
        int byTitle = this.title.compareToIgnoreCase(other.title);
        if (byTitle != 0) return byTitle;

        // tie-breaker to keep TreeSet comparator consistent
        // (same title but different author)
        int byAuthor = this.author.compareTo(other.author);
        if (byAuthor != 0) return byAuthor;

        return String.valueOf(this.category).compareTo(String.valueOf(other.category));
    }

    // equality for "same author + same title" (required duplicate rule)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return Objects.equals(author, post.author) &&
               Objects.equals(title, post.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title);
    }
}
