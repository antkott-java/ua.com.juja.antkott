import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


class Tester {

    private static LaboratoryWork laboratoryWorkEntity;
    private static Map<Integer, String> monthValues;
    private static Set<Integer> months;

    @BeforeAll
    public static void init() {
        laboratoryWorkEntity = new LaboratoryWork();
        monthValues
                = new HashMap<>();
        months = monthValues.keySet();

        monthValues.put(1, "January");
        monthValues.put(2, "February");
        monthValues.put(3, "March");
        monthValues.put(4, "April");

    }

    @Test
    void shouldReturn_MonthName_When_PassNumberOfMonth() {
        for (int month : months
                ) {
            assertEquals(monthValues.get(month), laboratoryWorkEntity.getMonthOfYear(month), "check value 1-12");
        }

    }

    @ParameterizedTest
    @CsvSource({
            "1, January",
            "2, February",
            "3, March",
            "4, April",
            "5, May",
            "6, June",
            "7, July",
            "8, August",
            "9, September",
            "10, October",
            "11, November",
            "12, December"
    })
    void shouldReturn_MonthName_When_PassNumberOfMonth_ParameterizedTest(int passed, String expected) {
        assertEquals(expected, laboratoryWorkEntity.getMonthOfYear(passed), "check value " + passed);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 66, 100})
    void shouldReturn_EmptyString_When_PassIntegerOutOfMonthRange(int num) {
        assertEquals("", laboratoryWorkEntity.getMonthOfYear(num), "check value out of 1-12");
    }
}