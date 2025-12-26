import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PeopleQuery {

    static Map<String, Map<Integer, Long>>
    getPeopleCountByPositionAndAge(List<Person> people) {

        return people.stream()
                .collect(Collectors.groupingBy(
                        Person::getPosition,
                        Collectors.groupingBy(
                                Person::getAge,
                                Collectors.counting()
                        )
                ));
    }
}
