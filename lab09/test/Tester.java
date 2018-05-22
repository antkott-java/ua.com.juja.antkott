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
    private static int[] inputArrayCuttingLength = new int[arraySize];
    private static ArrayList<Integer> tempList = new ArrayList<>();
    private static int[] outputArrayCuttingLength;
    private static int[] outputArray = new int[arraySize];
    private static int[] inputArray;


    static {
        int counterAdded=0;
        for (int i = 0; i < arraySize; i++) {
            int randomInt = ThreadLocalRandom.current().nextInt(1, 9999 + 1);
            inputArrayCuttingLength[i] = randomInt;
            if (randomInt % 2 == 0) {
                tempList.add(randomInt);
                outputArray[counterAdded] = randomInt;
                counterAdded++;
            }
        }
        for (int i = counterAdded; i <arraySize ; i++) {
            outputArray[i] = 0;

        }
        outputArrayCuttingLength = new int[tempList.size()];
        for (int i = 0; i < tempList.size(); i++) {
            outputArrayCuttingLength[i] = tempList.get(i);
        }
        inputArray = inputArrayCuttingLength.clone();
    }

    private static Stream<Arguments> stringAndIntProviderCuttingLength() {
        return Stream.of(Arguments.of(inputArrayCuttingLength, outputArrayCuttingLength));
    }

    private static Stream<Arguments> stringAndIntProvider() {
        return Stream.of(Arguments.of(inputArray, outputArray));
    }

    @BeforeAll
    public static void init() {
        laboratoryWorkEntity = new LaboratoryWork();
    }

    @ParameterizedTest(name = "\"{0}\" should be {1}")
    @MethodSource("stringAndIntProviderCuttingLength")
    void shouldReturn_FilteredArrayWithCuttingLength(int[] input, int[] expected) {
        assertArrayEquals(expected, laboratoryWorkEntity.filterArrayCuttingLength(input), "check array entity ");
    }

    @ParameterizedTest(name = "\"{0}\" should be {1}")
    @MethodSource("stringAndIntProvider")
    void shouldReturn_FilteredArray(int[] input, int[] expected) {
        assertArrayEquals(expected, laboratoryWorkEntity.filterArray(input), "check array entity ");
    }
}