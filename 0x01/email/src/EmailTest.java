import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class EmailTest {

    @Test
    void test_email_with_at_symbol() {
        assertTrue(Person.isEmailValid("email_test@domain.com"));
    }

    @Test
    void testar_email_sem_arroba() {
        assertFalse(Person.isEmailValid("email_testdomain.com"));
    }

    @Test
    void test_email_over_50_characters() {
        assertEquals(
                false,
                Person.isEmailValid(
                        "email_test_very_long_should_not_be_valid@domain.com"
                )
        );
    }
}
