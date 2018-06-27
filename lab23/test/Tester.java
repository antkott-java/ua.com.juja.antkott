import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ua.com.juja.core.antkott.ArrayUtils;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*

 */


class Tester {

    private static ArrayUtils arrayUtilsEntity;

    private static int[][][] input1 = {{{1, 2}, {3, 4}},{{5, 6}, {7, 8}}};
    private static int[][][] expected1 = {{{1,5}, {2, 6}},{{3, 7}, {4, 8}}};
    private static int[][][] input2 = { {{10, 11, 12}, {20, 21, 22}, {30, 31, 32}}, {{40, 41, 42}, {50, 51, 52}, {60, 61, 62}}, {{70, 71, 72}, {80, 81, 82}, {90, 91, 92}} };
    private static int[][][] expected2 = { {{10, 40, 70}, {11, 41, 71}, {12, 42, 72}}, {{20, 50, 80}, {21, 51, 81}, {22, 52, 82}}, {{30, 60, 90}, {31, 61, 91}, {32, 62, 92}} } ;
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
//        assertEquals(null, arrayUtilsEntity.rotateClockwise(expectedNull1), "check null input1");
//        assertEquals(null, arrayUtilsEntity.rotateClockwise(expectedNull2), "check null input2");
        assertEquals(null, arrayUtilsEntity.rotateClockwise(new int [0][][]), "check null input2");
       // assertEquals(null, arrayUtilsEntity.rotateClockwise(new int [1][0][]), "check null input2");
    }


}