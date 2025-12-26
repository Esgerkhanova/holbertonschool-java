import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class PeopleQuery {

    static Map<String, TreeSet<String>> getHobbiesByPosition(List<Person> people) {

        return people.stream()
                .collect(Collectors.groupingBy(
                        Person::getPosition,
                        Collectors.flatMapping(
                                p -> p.getHobbies().stream(),
                                Collectors.toCollection(TreeSet::new)
                        )
                ))
                .entrySet()
                .stream()
                .sorted((e1, e2) ->
                        Integer.compare(e2.getKey().length(), e1.getKey().length())
                )
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));
    }
}
