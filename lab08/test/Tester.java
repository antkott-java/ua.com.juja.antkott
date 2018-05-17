import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class Tester {

    private static LaboratoryWork laboratoryWorkEntity;
    private static int[] inputArray={1,2,3,4,5};
    private static int[] outputArray={5,4,3,2,1};

    private static Stream<Arguments> stringAndIntProvider() {
        return Stream.of(Arguments.of(inputArray, outputArray));
    }


    @BeforeAll
    public static void init() {
        laboratoryWorkEntity = new LaboratoryWork();

    }

    @ParameterizedTest(name = "\"{0}\" should be {1}")
    @MethodSource("stringAndIntProvider")
    void shouldReturn_RevertedArray(int[] input, int[] expected) {
        assertArrayEquals(expected, laboratoryWorkEntity.revertArray(input), "check value ");

    }

    //@ParameterizedTest
    //@ValueSource(ints = {0, 66, 100})
    //void shouldReturn_EmptyString_When_PassIntegerOutOfMonthRange(int num) {
        //assertEquals("", laboratoryWorkEntity.getMonthOfYear(num), "check value out of 1-12");
    //}
}