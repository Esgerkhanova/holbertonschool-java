import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class PersonTest {

    static Person person;

    @BeforeAll
    static void setup() {
        person = new Person(
                "Paul",
                "McCartney",
                new Date(100, 0, 1), 
                true,
                true,
                true
        );
    }

    @Test
    void show_full_name() {
        assertEquals("Paul McCartney", person.fullName());
    }

    @Test
    void test_calculateYearlySalary() {
        person.setSalary(1200);
        assertEquals(14400, person.calculateYearlySalary());
    }

    @Test
    void person_is_MEI() {
        person.setSalary(1000);
        person.setAnotherCompanyOwner(false);
        person.setPensioner(false);
        person.setPublicServer(false);

        assertTrue(person.isMEI());
    }

    @Test
    void person_is_not_MEI() {
        person.setSalary(20000);
        person.setAnotherCompanyOwner(true);
        person.setPensioner(true);
        person.setPublicServer(true);

        assertFalse(person.isMEI());
    }
}
