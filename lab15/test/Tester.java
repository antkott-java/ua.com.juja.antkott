import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ua.com.juja.core.antkott.LaboratoryWork;
import ua.com.juja.core.antkott.utils.lab.LaboratoryWorkInputDataCreator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
https://visualgo.net/en/sorting
http://www.java2novice.com/java-sorting-algorithms/
https://www.geeksforgeeks.org/insertion-sort/
 */


class Tester {

    private static LaboratoryWork laboratoryWorkEntity;
    private static int[] inputData;
    private static int[] outputData;

    static {
        inputData = new int[]{10, 2, 4, 5, 9, 7, 1, 3, 6, 8};
        outputData = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      int[][] inputs = LaboratoryWorkInputDataCreator.generateIntUnsortedAndSortedArray(10000, 0, 999);
        inputData = inputs[0];
        outputData = inputs[1];
    }


    @BeforeAll
    public static void init() {
        laboratoryWorkEntity = new LaboratoryWork();

    }


    @Test
    void shouldReturn_SortedArray_SelectSortFromInet() {
        assertArrayEquals(outputData, laboratoryWorkEntity.selectSortFromInet(inputData), "check equals");
    }

    @Test
    void shouldReturn_SortedArray_SelectSortLab15Original() {
        assertArrayEquals(outputData, laboratoryWorkEntity.selectSortLab15Original(inputData), "check equals");
    }

    @Test
    void shouldReturn_SortedArray_SelectSortLab15() {
        assertArrayEquals(outputData, laboratoryWorkEntity.selectSortLab15(inputData), "check equals");
    }


}