import lab.utils.LaboratoryWorkInputDataCreator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ua.com.juja.core.antkott.LaboratoryWork;

import java.util.stream.Stream;

import static lab.utils.Logging.LOG_IN_TEST;
import static org.junit.jupiter.api.Assertions.assertEquals;


class Tester {

    private static LaboratoryWork laboratoryWorkEntity;
    private static int[] arrayInput = {1,2,3,4,5,4,3,2,1};


    @BeforeAll
    public static void init() {
        laboratoryWorkEntity = new LaboratoryWork();

    }

    @Test
    void shouldReturn_correctOutput() {
        assertEquals (4, laboratoryWorkEntity.findUnpairedNumber(arrayInput), "check equals");
    }

    @Test
    void shouldReturn_minusOne_ifNonPairedWaNotFoundOrEmptyInput() {
        assertEquals (-1, laboratoryWorkEntity.findUnpairedNumber(new int[]{1,1,2,2,3,3}), "check equals");
        assertEquals (-1, laboratoryWorkEntity.findUnpairedNumber(new int[]{}), "check equals");
    }

    @Test
    void shouldReturn_lastFoundUnpairedIndex() {
        assertEquals (2, laboratoryWorkEntity.findUnpairedNumber(new int[]{1,2,3}), "check equals");
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