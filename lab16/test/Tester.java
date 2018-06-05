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
        inputData = new int[]{4,1,11,3};
        outputData = new int[] {1,3,4,11};
      int[][] inputs = LaboratoryWorkInputDataCreator.generateIntUnsortedAndSortedArray(10000, 0, 999);
        inputData = inputs[0];
        outputData = inputs[1];
    }


    @BeforeAll
    public static void init() {
        laboratoryWorkEntity = new LaboratoryWork();

    }


    @Test
    void shouldReturn_SortedArray_InsertionSort() {
        assertArrayEquals(outputData, laboratoryWorkEntity.insertionSort(inputData), "check equals");
    }

    @Test
    void shouldReturn_SortedArray_InsertionSort2() {
        assertArrayEquals(outputData, laboratoryWorkEntity.insertionSort2(inputData), "check equals");
    }

    @Test
    void shouldReturn_SortedArray_InsertionSortLab16Origin() {
        assertArrayEquals(outputData, laboratoryWorkEntity.insertionSortLab16Origin(inputData), "check equals");
    }

    @Test
    void shouldReturn_SortedArray_InsertionSortLab16() {
        assertArrayEquals(outputData, laboratoryWorkEntity.insertionSortLab16(inputData), "check equals");
    }

    @Test
    void shouldReturn_SortedArray_InsertionSortLab16FromSite() {
        assertArrayEquals(outputData, laboratoryWorkEntity.insertionSortLab16FromSite(inputData), "check equals");
    }


}