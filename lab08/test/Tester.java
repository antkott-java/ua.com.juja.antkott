import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class Tester {

    private static LaboratoryWork laboratoryWorkEntity;
    private static int arraySize = ThreadLocalRandom.current().nextInt(5, 6 + 1);
    private static Integer[] inputArray=new Integer [arraySize];
    static {
        for (int i = 0; i < arraySize - 1;i++) {
            inputArray[i]=i;
        }
    }
    private static Integer[] outputArray = Tester_ArrayReverser.reverse(inputArray);



    private static Stream<Arguments> stringAndIntProvider() {
        return Stream.of(Arguments.of(inputArray, outputArray));
    }


    @BeforeAll
    public static void init() {
        laboratoryWorkEntity = new LaboratoryWork();

    }

    @ParameterizedTest(name = "\"{0}\" should be {1}")
    @MethodSource("stringAndIntProvider")
    void shouldReturn_RevertedArray(Integer[] input, Integer[] expected) {
        //assertArrayEquals(expected, laboratoryWorkEntity.revertArray(input), "check value ");
       // assertArrayEquals(expected, input, "check value ");

    }

    //@ParameterizedTest
    //@ValueSource(ints = {0, 66, 100})
    //void shouldReturn_EmptyString_When_PassIntegerOutOfMonthRange(int num) {
        //assertEquals("", laboratoryWorkEntity.getMonthOfYear(num), "check value out of 1-12");
    //}
}