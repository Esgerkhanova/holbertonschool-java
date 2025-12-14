import java.util.TreeMap;

public class PhraseAnalyzer {

    public static TreeMap<String, Integer> wordCount(String sentence) {
        TreeMap<String, Integer> map = new TreeMap<>();

        if (sentence == null || sentence.isEmpty()) {
            return map;
        }

        // Convert to lowercase
        sentence = sentence.toLowerCase();

        // Split using space and punctuation as delimiters
        String[] words = sentence.split("[\\s?!.,]+");

        for (String word : words) {
            if (!word.isEmpty()) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        return map;
    }
}
