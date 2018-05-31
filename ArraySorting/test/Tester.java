import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import ua.com.juja.core.antkott.LaboratoryWork;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*

 */


class Tester {

    private static LaboratoryWork laboratoryWorkEntity;
    private static int[] inputData = {10,2,4,5,9,7,1,3,6,8};
    private static int[] outputData= {1,2,3,4,5,6,7,8,9,10};

    static {}


    @BeforeAll
    public static void init() {
        laboratoryWorkEntity = new LaboratoryWork();

    }

    @Test
    void shouldReturn_SortedArray_BubbleSort() {
        assertArrayEquals(outputData, laboratoryWorkEntity.bubbleSort(inputData), "check equals");
    }



}