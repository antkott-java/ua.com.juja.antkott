import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class Tester {

    private static LaboratoryWork laboratoryWorkEntity;
    private static int arraySize = ThreadLocalRandom.current().nextInt(5, 25 + 1);
    private static int[] inputArray = new int[arraySize];
    private static int[] outputArray = new int[arraySize];
    private static int[] inputArray2;


    static {
        for (int i = 0; i < arraySize; i++) {
            inputArray[i] = i;
            outputArray[arraySize - i - 1] = i;
        }
        inputArray2 = Arrays.copyOf(inputArray, arraySize);
    }


    private static Stream<Arguments> stringAndIntProvider() {
        return Stream.of(Arguments.of(inputArray, outputArray, inputArray2));
    }


    @BeforeAll
    public static void init() {
        laboratoryWorkEntity = new LaboratoryWork();

    }

    @ParameterizedTest(name = "\"{0}\" should be {1}")
    @MethodSource("stringAndIntProvider")
    void shouldReturn_RevertedArray(int[] input, int[] expected, int[] input2) {
        assertArrayEquals(expected, laboratoryWorkEntity.revertArray(input), "check array entity ");

    }

    @ParameterizedTest(name = "\"{0}\" should be {1}")
    @MethodSource("stringAndIntProvider")
    void shouldReturn_RevertedArray2(int[] input, int[] expected, int[] input2) {
        assertArrayEquals(expected, laboratoryWorkEntity.revertArray2(input2), "check array entity ");
    }


}