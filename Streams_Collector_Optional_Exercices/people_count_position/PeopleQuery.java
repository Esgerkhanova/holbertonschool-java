import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PeopleQuery {

    static Map<String, Long> getPeopleCountByPosition(List<Person> people) {
        return people.stream()
                .collect(Collectors.groupingBy(
                        Person::getPosition,
                        Collectors.counting()
                ));
    }
}
