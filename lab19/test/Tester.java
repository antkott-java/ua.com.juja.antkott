import org.junit.jupiter.params.provider.Arguments;
import ua.com.juja.core.antkott.utils.lab.LaboratoryWorkInputDataCreator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ua.com.juja.core.antkott.LaboratoryWork;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*

 */


class Tester {

    private static LaboratoryWork laboratoryWorkEntity;
    private static int[] inputData ;
    private static int[] outputData;

    static {
        inputData = new int[]{5, 10, 100, 278, 333};
        outputData =  new int[]{4, 11, 3_953,233_639, 514_766};
    }

    private static Stream<Arguments> variablesProvider() {
        return Stream.of(Arguments.of(inputData, outputData));
    }

    @BeforeAll
    public static void init() {
        laboratoryWorkEntity = new LaboratoryWork();
    }

    @ParameterizedTest(name = "\"{0}\" should be {1}")
    @MethodSource("variablesProvider")
    void shouldReturn_CorrectOutput(int[] input, int[] expected) {
        for (int i = 0; i <inputData.length-1 ; i++) {
            assertEquals(expected[i], laboratoryWorkEntity.exchangeAmountOfCoinsBrutForce(input[i]), "check equals");
        }

    }

}