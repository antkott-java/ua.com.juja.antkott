import lab.utils.LaboratoryWorkInputDataCreator;
import lab.utils.Logging;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static lab.utils.Logging.LOG_INFO;
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
        inputData = 8;
        outputData = lookFor(inputData);

    }

        private static Stream<Arguments> variablesProvider1() {
        return Stream.of(Arguments.of(inputData, outputData));
    }

    private static int lookFor(int input){
            int result=0;
            int a=1;
            int b=1;
            while ((a*a+b*b) <=input) {
                result++;
                while ((a*a+b*b) <=input) {
                    int s=(a*a+b*b);
                    result++;
                    b++;
                    LOG_INFO("a= "+a+", b="+b+", (input = "+input+"), sum="+s);

                }
                b=1;
                a++;
                LOG_INFO("a= "+a+", b="+b+"");
            }

//                LOG_INFO("a= "+a+", b="+b);
                LOG_INFO("c= "+result);


            return result;

    }

    @BeforeAll
    public static void init() {
        laboratoryWorkEntity = new LaboratoryWork();

    }

    @ParameterizedTest(name = "\"{0}\" should be {1}")
    @MethodSource("variablesProvider1")
    void shouldReturn_CorrectOutput(int input, int expected) {
        //assertEquals (expected, laboratoryWorkEntity.lookFor(input), "check array entity ");
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