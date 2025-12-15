import java.util.*;

public class Blog {
    private final Set<Post> posts = new HashSet<>();

    public void addPost(Post post) throws Exception {
        // Duplicate rule: same author + same title
        for (Post p : posts) {
            if (p.getAuthor().equals(post.getAuthor()) &&
                p.getTitle().equals(post.getTitle())) {
                throw new Exception("Post already exists");
            }
        }
        posts.add(post);
    }

    public Set<Author> getAllAuthors() {
        Set<Author> authors = new TreeSet<>();
        for (Post p : posts) {
            authors.add(p.getAuthor());
        }
        return authors;
    }

    public Map<Categories, Integer> getCountByCategory() {
        Map<Categories, Integer> count = new EnumMap<>(Categories.class);
        for (Post p : posts) {
            Categories c = p.getCategory();
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        return count;
    }

    public Set<Post> getPostsByAuthor(Author author) {
        Set<Post> result = new TreeSet<>();
        for (Post p : posts) {
            if (p.getAuthor().equals(author)) {
                result.add(p);
            }
        }
        return result;
    }

    public Set<Post> getPostsByCategory(Categories category) {
        Set<Post> result = new TreeSet<>();
        for (Post p : posts) {
            if (p.getCategory() == category) {
                result.add(p);
            }
        }
        return result;
    }

    public Map<Categories, Set<Post>> getAllPostsByCategories() {
        Map<Categories, Set<Post>> map = new EnumMap<>(Categories.class);
        for (Post p : posts) {
            map.computeIfAbsent(p.getCategory(), k -> new TreeSet<>()).add(p);
        }
        return map;
    }

    public Map<Author, Set<Post>> getAllPostsByAuthor() {
        Map<Author, Set<Post>> map = new TreeMap<>();
        for (Post p : posts) {
            map.computeIfAbsent(p.getAuthor(), k -> new TreeSet<>()).add(p);
        }
        return map;
    }
}
