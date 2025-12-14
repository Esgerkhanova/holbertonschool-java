import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Blog {

    private List<Post> posts;

    public Blog() {
        this.posts = new ArrayList<>();
    }

    // Do NOT declare "throws Exception" (Program.java doesn't catch for normal adds)
    public void addPost(Post post) {
        for (Post p : posts) {
            if (p.getAuthor().equals(post.getAuthor()) &&
                p.getTitle().equals(post.getTitle())) {
                throw new RuntimeException("Post already exists");
            }
        }
        posts.add(post);
    }

    public Set<Author> getAllAuthors() {
        Set<Author> authors = new TreeSet<>();
        for (Post post : posts) {
            authors.add(post.getAuthor());
        }
        return authors;
    }

    public Map<Categories, Integer> getCountByCategory() {
        Map<Categories, Integer> count = new EnumMap<>(Categories.class);
        for (Post post : posts) {
            Categories cat = post.getCategory();
            count.put(cat, count.getOrDefault(cat, 0) + 1);
        }
        return count;
    }

    // sorted by title because Post is Comparable
    public Set<Post> getPostsByAuthor(Author author) {
        Set<Post> result = new TreeSet<>();
        for (Post post : posts) {
            if (post.getAuthor().equals(author)) {
                result.add(post);
            }
        }
        return result;
    }

    public Set<Post> getPostsByCategory(Categories category) {
        Set<Post> result = new TreeSet<>();
        for (Post post : posts) {
            if (post.getCategory() == category) {
                result.add(post);
            }
        }
        return result;
    }

    public Map<Categories, Set<Post>> getAllPostsByCategories() {
        Map<Categories, Set<Post>> map = new EnumMap<>(Categories.class);

        for (Post post : posts) {
            Categories cat = post.getCategory();
            map.putIfAbsent(cat, new TreeSet<>());
            map.get(cat).add(post);
        }
        return map;
    }

    public Map<Author, Set<Post>> getAllPostsByAuthor() {
        Map<Author, Set<Post>> map = new TreeMap<>();

        for (Post post : posts) {
            Author a = post.getAuthor();
            map.putIfAbsent(a, new TreeSet<>());
            map.get(a).add(post);
        }
        return map;
    }
}
