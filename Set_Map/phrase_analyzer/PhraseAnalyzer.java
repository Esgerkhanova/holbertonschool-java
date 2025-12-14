import java.util.TreeMap;

public class PhraseAnalyzer {

    public static TreeMap<String, Integer> wordCount(String sentence) {
        TreeMap<String, Integer> counts = new TreeMap<>();

        if (sentence == null || sentence.isEmpty()) {
            return counts;
        }

        // 1) Normalize: lowercase + remove ? . !
        String normalized = sentence
                .toLowerCase()
                .replace("?", "")
                .replace(".", "")
                .replace("!", "");

        // 2) Split by any whitespace and/or commas (matches your test phrases)
        String[] words = normalized.split("[\\s,]+");

        // 3) Count
        for (String w : words) {
            if (w.isEmpty()) continue;
            counts.put(w, counts.getOrDefault(w, 0) + 1);
        }

        return counts;
    }
}
