import lab.utils.LaboratoryWorkArraysCreator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class Tester {

    private static LaboratoryWork laboratoryWorkEntity;


    private static int[] inputArray1 = LaboratoryWorkArraysCreator.integerRandomArray(6);
    private static int[] inputArray2 = LaboratoryWorkArraysCreator.integerRandomArray(5);
    private static int arraySize1 = inputArray1.length;
    private static int arraySize2 = inputArray2.length;
    private static int[] sortedArray1;
    private static int[] sortedArray2;
    private static int[] mergedArray;

    static {
        for (int i = 0; i < arraySize1; i++) {
            int randomInt = ThreadLocalRandom.current().nextInt(1, 9999 + 1);
            inputArray1[i] = randomInt;
        }
        for (int i = 0; i < arraySize2; i++) {
            int randomInt = ThreadLocalRandom.current().nextInt(1, 9999 + 1);
            inputArray2[i] = randomInt;
        }

        sortedArray1 = getSortedArray(inputArray1);
        sortedArray2 = getSortedArray(inputArray2);
        mergedArray = mergeSortedArrays(sortedArray1, sortedArray2);
    }


    private static int[] getSortedArray(int[] input) {
        int[] clone = input.clone();
        int length = input.length;
        for (int item : clone
                ) {
            for (int i = 0; i < length - 1; i++) {
                int current = clone[i];
                int next = clone[i + 1];
                if (current > next) {
                    int tmp = current;
                    current = next;
                    next = tmp;
                    clone[i] = current;
                    clone[i + 1] = next;
                }
            }

        }
        for (int item : input
                ) {
//            Logging.LOG_INFO("input => " + item);
        }
//        Logging.LOG_INFO("====");
        for (int item : clone
                ) {
            // Logging.LOG_INFO("sorted => " + item);
        }
        return clone;
    }

    private static int[] mergeSortedArrays(int[] input1, int input2[]) {
        int[] clone1 = input1.clone();
        int[] clone2 = input2.clone();
        int lengthClone1 = clone1.length;
        int[] merged = new int[lengthClone1 + clone2.length];

        for (int i = 0; i < lengthClone1; i++) {
            merged[i] = clone1[i];
        }
        for (int i = 0; i < clone2.length; i++) {
            merged[i + lengthClone1] = clone2[i];
        }
        merged = getSortedArray(merged);
//        Logging.LOG_INFO("== merge ==");
        for (int item : merged
                ) {
//            Logging.LOG_INFO("merged => " + item);
        }
        return merged;
    }


    private static Stream<Arguments> variablesProvider1() {
        return Stream.of(Arguments.of(sortedArray1, sortedArray2, mergedArray));
    }

    @BeforeAll
    public static void init() {
        laboratoryWorkEntity = new LaboratoryWork();

    }

    @ParameterizedTest(name = "\"{2}\" should be {1}+{0}")
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
    }

}