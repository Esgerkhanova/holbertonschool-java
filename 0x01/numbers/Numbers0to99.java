public class Numbers0to99 {
    public static void main(String[] args) {
        String result = "";
        for (int i = 0; i < 100; i++) {
            result += i;
            if (i < 99) {
                result += ", ";
            }
        }
        System.out.println(result);
    }
}

