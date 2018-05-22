import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class Tester {

    private static LaboratoryWork laboratoryWorkEntity;

    private static int arraySize = ThreadLocalRandom.current().nextInt(5, 7);
    private static int[] inputArray = new int[arraySize];
    private static ArrayList<Integer> tempList = new ArrayList<>();
    private static int[] outputArray;

    static {
        for (int i = 0; i < arraySize; i++) {
            inputArray[i] = ThreadLocalRandom.current().nextInt(1, 9999 + 1);
            if (inputArray[i] % 2 == 0) tempList.add(inputArray[i]);
        }
        outputArray = new int[tempList.size()];
        for (int i = 0; i < tempList.size(); i++) {
            outputArray[i] = tempList.get(i);
        }

    }

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
        assertArrayEquals(expected, laboratoryWorkEntity.filterArrayCuttingLength(input), "check array entity ");
    }



}