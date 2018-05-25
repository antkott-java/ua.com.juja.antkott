import lab.utils.LaboratoryWorkInputDataCreator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static lab.utils.Logging.LOG_IN_TEST;


class Tester {

    private static LaboratoryWork laboratoryWorkEntity;
    private static int[] inputData = LaboratoryWorkInputDataCreator.integerRandomArray(21);
    private static int outputData;

    static {
//        inputData = 14;
        lookFor(inputData);

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

    public static int[] lookFor(int[] array) {
        int[] resultArray = new int[2];
        List<Integer> positiveNumbersIndexes = new ArrayList<>();
        List<Integer> positiveNumbersDiapason = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder("input: ");
        StringBuilder stringBuilderPositiveIndexes = new StringBuilder("positive indexes: ");
        for (int i = 0; i < array.length; i++) {
            stringBuilder.append(array[i]).append(", ");
            if (array[i] > 0) {
//                LOG_IN_TEST("i="+i+" "+array[i]);
                positiveNumbersIndexes.add(Integer.valueOf(i));
                stringBuilderPositiveIndexes.append(i).append(", ");
            }
        }
        if (!positiveNumbersIndexes.isEmpty()) {
            int currentDiapasonSize = 0;
            int tempDiapasonSize = 0;
            boolean currentDiapasonIsOver = false;
            for (int i = 0; i < positiveNumbersIndexes.size() - 1; i++) {
                if (positiveNumbersIndexes.get(i + 1) - positiveNumbersIndexes.get(i) == 1) {
                    tempDiapasonSize++;
                    LOG_IN_TEST("tempDiapasonSize="+tempDiapasonSize);
                    resultArray[1] = positiveNumbersIndexes.get(i + 1);
                } else {
                    currentDiapasonIsOver = true;
//                    if (tempDiapasonSize > currentDiapasonSize) currentDiapasonSize = tempDiapasonSize;
                    resultArray[0] = positiveNumbersIndexes.get(i - tempDiapasonSize);
                    tempDiapasonSize=0;
                }


            }
            LOG_IN_TEST(stringBuilder.toString());
            LOG_IN_TEST(stringBuilderPositiveIndexes.toString());
            LOG_IN_TEST("result = " + resultArray[0] + " " + resultArray[1]);
        }
        return array;
    }

    //@ParameterizedTest(name = "\"{0}\" should be {1}")
    //@MethodSource("variablesProvider1")
    @Test
    void shouldReturn_CorrectOutput() {
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