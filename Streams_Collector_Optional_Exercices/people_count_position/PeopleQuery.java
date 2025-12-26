import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PeopleQuery {

    static Map<String, Long> getPeopleCountByPosition(List<Person> people) {

        return people.stream()
                .collect(Collectors.groupingBy(
                        Person::getPosition,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> Integer.compare(
                        e2.getKey().length(),
                        e1.getKey().length()
                ))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));
    }
}
