import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


class Tester {

    private static LaboratoryWork laboratoryWorkEntity;



    private static Stream<Arguments> stringAndIntProvider() {
        return Stream.of(Arguments.of());
    }


    @BeforeAll
    public static void init() {
        laboratoryWorkEntity = new LaboratoryWork();

    }

    @ParameterizedTest(name = "\"{0}\" should be {1}")
    @MethodSource("stringAndIntProvider")
    void shouldReturn_RevertedArray(int[] input, int[] expected, int[] input2) {
        //assertArrayEquals(expected, laboratoryWorkEntity.revertArray(input), "check array entity ");

    }

    @ParameterizedTest(name = "run #{index} with [{arguments}]")
    @ValueSource(ints = {0, 66, 9999999})
    void shouldReturn_EmptyString_When_PassIntegerOutOfMonthRange(int num) {
        //assertEquals("", laboratoryWorkEntity.getMonthOfYear(num), "check value out of 1-12");
    }



}