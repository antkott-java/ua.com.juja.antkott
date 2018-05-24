import lab.utils.LaboratoryWorkInputDataCreator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static lab.utils.Logging.LOG_INFO;
import static lab.utils.Logging.LOG_IN_TEST;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Реализовать функцию, которая по целочисленому аргументу c возвращает количество целочисленных решений неравенства

a*a + b*b <= c
a > 0
b > 0
Например:

lookFor(14) == 8
поскольку для решения подходят следующие пары значений

(a=1, b=1)
(a=1, b=2)
(a=1, b=3)
(a=2, b=1)
(a=2, b=2)
(a=2, b=3)
(a=3, b=1)
(a=3, b=2)

*/


class Tester {

    private static LaboratoryWork laboratoryWorkEntity;
    private static int inputData = LaboratoryWorkInputDataCreator.getRandomInt(99);
    private static int outputData;

    static {
//        inputData = 14;
        outputData = lookFor(inputData);

    }

    private static Stream<Arguments> variablesProvider1() {
        return Stream.of(Arguments.of(inputData, outputData));
    }

    private static int lookFor(int max) {
        int result = 0;
        int a = 1, b = 1;
        LOG_IN_TEST("(result = " + getSResultLookFor(a, b) + ") <= " + max);
        while ((a * a + b * b) <= max) {
            LOG_IN_TEST("(change A) a= " + a + ", b=" + b + ", (result = " + getSResultLookFor(a, b) + ") <= " + max);
            while ((a * a + b * b) <= max) {
                b++;
                if ((a != 1) && (b != 1)) result++;
                LOG_IN_TEST("(change B) a= " + a + ", b=" + b + ", (result = " + getSResultLookFor(a, b) + ") <= " + max);
            }
            b = 1;
            result++;
            a++;
        }
        LOG_IN_TEST("result = " + result);
        return result;
    }

    private static int getSResultLookFor(int a, int b) {
        return (a * a + b * b);
    }

    @BeforeAll
    public static void init() {
        laboratoryWorkEntity = new LaboratoryWork();

    }

    @ParameterizedTest(name = "\"{0}\" should be {1}")
    @MethodSource("variablesProvider1")
    void shouldReturn_CorrectOutput(int input, int expected) {
        assertEquals (expected, laboratoryWorkEntity.lookFor(input), "check equals");
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