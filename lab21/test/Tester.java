import ua.com.juja.core.antkott.utils.lab.LaboratoryWorkInputDataCreator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ua.com.juja.core.antkott.LaboratoryWork;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*

 */


class Tester {

    private static LaboratoryWork laboratoryWorkEntity;
    private static int inputData = LaboratoryWorkInputDataCreator.getRandomInt(99);
    private static int outputData;

    static {
//        inputData = 14;
//        outputData = lookFor(inputData);

    }

//    private static Stream<Arguments> variablesProvider1() {
//        return Stream.of(Arguments.of(inputData, outputData));
//    }


    @BeforeAll
    public static void init() {
        laboratoryWorkEntity = new LaboratoryWork();

    }

    @ParameterizedTest(name = "\"{0}\" should be {1}")
    @MethodSource("variablesProvider1")
    void shouldReturn_CorrectOutput(int input, int expected) {
//        assertEquals(expected, laboratoryWorkEntity.lookFor(input), "check equals");
    }
/*
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