import java.util.HashSet;
import java.util.TreeSet;

public class DuplicatedNumbers {

    public static TreeSet<Integer> isFind(int[] numbers) {
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> duplicated = new HashSet<>();

        for (int number : numbers) {
            if (!seen.add(number)) {
                duplicated.add(number);
            }
        }

        return new TreeSet<>(duplicated);
    }
}
