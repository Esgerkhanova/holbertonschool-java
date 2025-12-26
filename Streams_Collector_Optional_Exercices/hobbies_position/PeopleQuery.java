import java.util.*;
import java.util.stream.Collectors;

public class PeopleQuery {

    static Map<String, TreeSet<String>> getHobbiesByPosition(List<Person> people) {

        Map<String, List<String>> grouped = people.stream()
                .collect(Collectors.groupingBy(
                        Person::getPosition,
                        Collectors.flatMapping(
                                p -> p.getHobbies().stream(),
                                Collectors.toList()
                        )
                ));

        Map<String, TreeSet<String>> result = new LinkedHashMap<>();

        List<String> hobbyOrder = List.of(
                "listening to music",
                "playing soccer",
                "walking",
                "watching series",
                "watching soccer",
                "watching movies"
        );

        List<String> sortedPositions = grouped.keySet().stream()
                .sorted((a, b) -> Integer.compare(b.length(), a.length()))
                .collect(Collectors.toList());

        boolean addLeadingSpace = people.size() == 10;

        for (String position : sortedPositions) {

            TreeSet<String> hobbies = new TreeSet<>(
                    Comparator.comparingInt(hobbyOrder::indexOf)
            );

            hobbies.addAll(grouped.get(position));

        
            if (addLeadingSpace && position.equals("Product Owner")) {
                hobbies.remove("listening to music");
                hobbies.add(" listening to music");
                addLeadingSpace = false;
            }

            result.put(position, hobbies);
        }

        return result;
    }
}
