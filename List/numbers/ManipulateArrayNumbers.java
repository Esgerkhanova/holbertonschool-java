import java.util.*;

public class ManipulateArrayNumbers {

    public static int findNumberPosition(List<Integer> list, int number) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == number) {
                return i;
            }
        }
        return -1;
    }

    public static void addNumber(List<Integer> list, int number) {
        int position = findNumberPosition(list, number);
        if (position != -1) {
            throw new RuntimeException("Number already in the list");
        }
        list.add(number);
    }

    public static void removeNumber(List<Integer> list, int number) {
        int position = findNumberPosition(list, number);
        if (position == -1) {
            throw new RuntimeException("Number not found in the list");
        }
        list.remove(position);
    }

    public static void replaceNumber(List<Integer> list, int numberToReplace, int replacementNumber) {
        int position = findNumberPosition(list, numberToReplace);
        if (position != -1) {
            list.set(position, replacementNumber);
        } else {
            list.add(replacementNumber);
        }
    }
}
