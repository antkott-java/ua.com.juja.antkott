import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ua.com.juja.core.antkott.ArrayUtils;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*

 */


class Tester {

    private static ArrayUtils arrayUtilsEntity;

    private static int[][] input1 = {{1, 2}, {3, 4}};
    private static int[][] expected1 = {{3, 1}, {4, 2}};
    private static int[][] input2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    private static int[][] expected2 = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
    private static int[][] expectedNull1 = {{7, 4, 1}, null, {9, 6, 3}};
    private static int[][] expectedNull2 = {{7, 4, 1, 4}, {1, 2}, {9, 6, 3}};

    @BeforeAll
    public static void init() {
        arrayUtilsEntity = new ArrayUtils();
    }

    @Test
    void shouldReturn_CorrectOutput1() {
        assertArrayEquals(expected1, arrayUtilsEntity.rotateClockwise(input1), "check equals");
    }

    @Test
    void shouldReturn_CorrectOutput2() {
        assertArrayEquals(expected2, arrayUtilsEntity.rotateClockwise(input2), "check equals");
    }

    @Test
    void shouldReturn_Null() {
        assertEquals(null, arrayUtilsEntity.rotateClockwise(null), "check null input");
    }

    @Test
    void shouldReturn_SameArrayIfOneElement() {
        assertArrayEquals(new int[][][]{{{1}}}, arrayUtilsEntity.rotateClockwise(new int[][][]{{{1}}}), "check null input");
    }

    @Test
    void shouldReturn_NullAsRow() {
        assertEquals(null, arrayUtilsEntity.rotateClockwise(expectedNull1), "check null input1");
        assertEquals(null, arrayUtilsEntity.rotateClockwise(expectedNull2), "check null input2");
    }


}