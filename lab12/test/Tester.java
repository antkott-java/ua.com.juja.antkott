import lab.utils.LaboratoryWorkInputDataCreator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


class Tester {

    private static LaboratoryWork laboratoryWorkEntity;
    private static int[] inputData = LaboratoryWorkInputDataCreator.integerRandomArray(21);
    private static int outputData;

    static {
//        inputData = 14;
        //outputData = lookFor(inputData);

    }

    private static Stream<Arguments> variablesProvider1() {
        return Stream.of(Arguments.of(inputData, outputData));
    }

    /*
На вход подается одномерный массив. Необходимо найти диапазон максимальной ширины, элементы которого положительные (больше 0).
В качестве ответа должен быть массив из 2х элементов, где:
- элемент №0 - индекс элемента левой границы отрезка;
- элемент №1 - индекс элемента правой границы отрезка.
Если таких отрезков несколько - вернуть самый левый. Если в массиве отсутствует такой отрезок (все числа отрицательны) - вернуть пустой массив.
Например:
lookFor([1, 1, 1]) = [0, 2]
lookFor([0, 1, 1]) = [1, 2]
lookFor([1, 1, 0]) = [0, 1]
lookFor([0, -100, 1, 1, 0, -1]) = [2, 3]
lookFor([1, 1, 0, 1, 1]) = [0, 1] // возвращаем левый
lookFor([0, -1, 0, -1]) = [] // отсутствуют положительные числа!
*/

    @BeforeAll
    public static void init() {
        laboratoryWorkEntity = new LaboratoryWork();

    }

    public int[] lookFor(int[] array) {
        return array;
    }

    @ParameterizedTest(name = "\"{0}\" should be {1}")
    @MethodSource("variablesProvider1")
    void shouldReturn_CorrectOutput(int input, int expected) {
        //assertEquals (expected, laboratoryWorkEntity.lookFor(input), "check equals");
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