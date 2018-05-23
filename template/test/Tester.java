import $.LaboratoryWorkArraysCreator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static $.Logging.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class Tester {

    private static LaboratoryWork laboratoryWorkEntity;


        private static Stream<Arguments> variablesProvider1() {
        return Stream.of(Arguments.of(/*sortedArray1, sortedArray2, mergedArray*/));
    }

    @BeforeAll
    public static void init() {
        laboratoryWorkEntity = new LaboratoryWork();

    }

    /*@ParameterizedTest(name = "\"{2}\" should be {1}+{0}")
    @MethodSource("variablesProvider1")
    void shouldReturn_MergedArray(int[] input1, int[] input2, int[] expected) {
        assertArrayEquals(expected, laboratoryWorkEntity.mergeSortedArrays(input1, input2), "check array entity ");
    }

    @ParameterizedTest(name = "\"{2}\" should be {1}+{0}")
    @MethodSource("variablesProvider1")
    void shouldReturn_MergedArray_ExampleJuja(int[] input1, int[] input2, int[] expected) {
        assertArrayEquals(expected, laboratoryWorkEntity.mergeSortedArraysExampleFromJuja(input1, input2), "check array entity ");

    }

    @Test
    void shouldReturn_WhenNull() {
        assertArrayEquals(new int[]{1}, laboratoryWorkEntity.mergeSortedArraysExampleFromJuja(new int[]{1}, new int[0]), "check array entity ");
    }*/

}