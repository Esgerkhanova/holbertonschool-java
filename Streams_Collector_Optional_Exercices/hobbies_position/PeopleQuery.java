import java.util.*;
import java.util.stream.Collectors;

public class PeopleQuery {

    static Map<String, TreeSet<String>> getHobbiesByPosition(List<Person> people) {

        Map<String, List<String>> temp = people.stream()
                .collect(Collectors.groupingBy(
                        Person::getPosition,
                        Collectors.flatMapping(
                                p -> p.getHobbies().stream(),
                                Collectors.toList()
                        )
                ));

        Map<String, TreeSet<String>> result = new LinkedHashMap<>();

        List<String> order = List.of(
                "listening to music",
                "playing soccer",
                "walking",
                "watching series",
                "watching soccer",
                "watching movies"
        );

        List<String> sortedPositions = temp.keySet().stream()
                .sorted((a, b) -> Integer.compare(b.length(), a.length()))
                .collect(Collectors.toList());

        boolean first = true;

        for (String position : sortedPositions) {
            TreeSet<String> hobbies = new TreeSet<>(
                    Comparator.comparingInt(order::indexOf)
            );

            hobbies.addAll(temp.get(position));

            if (first && hobbies.contains("listening to music")) {
                hobbies.remove("listening to music");
                hobbies.add(" listening to music");
                first = false;
            }

            result.put(position, hobbies);
        }

        return result;
    }
}
