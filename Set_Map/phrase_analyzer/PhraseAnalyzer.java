import java.util.TreeMap;

public class PhraseAnalyzer {

    public static TreeMap<String, Integer> wordCount(String sentence) {
        TreeMap<String, Integer> wordMap = new TreeMap<>();
        sentence = sentence.toLowerCase();
        sentence = sentence.replaceAll("[?.!,]", "");
        String[] words = sentence.split("\\s+");

    
        for (String word : words) {
            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
            } else {
                wordMap.put(word, 1);
            }
        }

        return wordMap;
    }
}
