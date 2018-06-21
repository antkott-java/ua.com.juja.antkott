package ua.com.juja.core.antkott;

import java.util.Arrays;

import static ua.com.juja.core.antkott.utils.Logging.logInfo;

public class MatrixUtils {

    /*

        Реализовать метод, умножающий две 2-мерные матрицы (не обязательно квадратные).

        Произведение двух двумерных матриц матриц A и B размером NxM и MxK- это матрица С размером NxK,
        где каждый элемент C[i][j] высчитывается по формуле: C[i][j] = A[i][0]*B[0][j] + A[i][1]*B[1][j] + ... + A[i][N-1]*B[N-1][j]

        Пример:
        |1 2|   |3 4 5 6|   |21 4  7  10|
        |7 8| * |9 0 1 2| = |93 28 43 58|
        |3 4|               |45 12 19 26|
        так как:
        1*3 + 2*9 = 21,
        1*4 + 2*0 = 4,
        1*5 + 2*1 = 7,
        1*6 + 2*2 = 10
        7*3 + 8*9 = 93,
        7*4 + 8*0 = 28,
        7*5 + 8*1 = 43,
        7*6 + 8*2 = 58
        3*3 + 4*9 = 45,
        3*4 + 4*0 = 12,
        3*5 + 4*1 = 19,
        3*6 + 4*2 = 26

        Дополнительные условия:
        1. Если один из аргументов равен null - throw new IllegalArgumentException().
        2. Если один из аргументов НЕ прямоугольная/квадратная матрица - throw new IllegalArgumentException().
        3. Если одна из матриц содержит null в качестве строки - throw new IllegalArgumentException().
        4. Если ширина первой матрицы не равна высоте второй матрицы - throw new IllegalArgumentException().

        Подсказка: вам необходим тройной вложенный цикл.

    */


    public static int[][] mul(int[][] fst, int[][] snd) {
        if (fst == null || snd == null) {
            throw new IllegalArgumentException();
        }
        int fstYLength = fst.length;
        int fstXLength = fst[0].length;
        int sndYLength = snd.length;
        int sndXLength = snd[0].length;
//        logInfo("len fst(Y:X)(" + fstYLength + ":" + fstXLength + ")");
//        logInfo("len snd(Y:X) (" + sndYLength + ":" + sndXLength + ")");
        if (fstXLength != sndYLength) {
            throw new IllegalArgumentException();
        }
//        logInfo(Arrays.deepToString(fst));
//        logInfo(Arrays.deepToString(snd));
        int[][] mul = new int[fstYLength][sndXLength];
        if (fstYLength == 1 && sndYLength == 1) {
            mul[0][0] = fst[0][0] * snd[0][0];
            return mul;
        } else {
            for (int fX = 0; fX < fstXLength; fX++) {
                for (int fY = 0; fY < fstYLength; fY++) {
                    int itemFirst = fst[fY][fX];
                    for (int sY = 0; sY < sndXLength; sY++) {
                        int itemSecond = snd[fX][sY];
                        mul[fY][sY] += itemFirst * itemSecond;
                    }
                }
            }
            return mul;
        }
    }
}
