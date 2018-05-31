import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ua.com.juja.core.antkott.LaboratoryWork;
import ua.com.juja.core.antkott.utils.lab.LaboratoryWorkInputDataCreator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
https://visualgo.net/en/sorting
 */


class Tester {

    private static LaboratoryWork laboratoryWorkEntity;
    private static int[] inputData;
    private static int[] outputData;

    static {
//        inputData = {10,2,4,5,9,7,1,3,6,8};
//        outputData= {1,2,3,4,5,6,7,8,9,10};
        int[][] inputs = LaboratoryWorkInputDataCreator.generateIntUnsortedAndSortedArray(10000, 0, 999);
        inputData = inputs[0];
        outputData = inputs[1];
    }


    @BeforeAll
    public static void init() {
        laboratoryWorkEntity = new LaboratoryWork();

    }

    @Test
    void shouldReturn_SortedArray_BubbleSort() {
        assertArrayEquals(outputData, laboratoryWorkEntity.bubbleSort(inputData), "check equals");
    }


}