package TestCases;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class JUnit5TestSuiteExampleTest {

    //@Disabled("Disabled until CustomerService is up!")
    @Test
    void testCase()
    {
        //Test will pass
        assertNotEquals(3, 4);

        //Test will fail
        //assertNotEquals(4, 4, "Calculator.add(2, 2) test failed");

    }

    @Test
    @DisplayName("Simple multiplication should work")
    void testMultiply() {
        assertEquals(20, 4 * 5,
                "Regular multiplication should work");
    }
}
