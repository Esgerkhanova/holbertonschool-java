import java.util.ArrayList;
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

    public void addPost(Post post) {
        posts.add(post);
    }

    // Sorted by author name
    public Set<String> getAllAuthors() {
        Set<String> authors = new TreeSet<>();
        for (Post post : posts) {
            authors.add(post.getAuthor());
        }
        return authors;
    }

    // Sorted by category name
    public Map<String, Integer> getCountByCategory() {
        Map<String, Integer> count = new TreeMap<>();
        for (Post post : posts) {
            String category = post.getCategory();
            count.put(category, count.getOrDefault(category, 0) + 1);
        }
        return count;
    }
}
