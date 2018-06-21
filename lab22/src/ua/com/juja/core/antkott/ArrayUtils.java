package ua.com.juja.core.antkott;

import java.util.Arrays;

import static ua.com.juja.core.antkott.utils.Logging.logInfo;

public class ArrayUtils {

/*
Реализуйте метод rotateClockwise(int[][])
класса ArrayUtils, который
1) проверяет, что метод получил "квадратную" матрицу (допустимые размеры 1x1, 2x2, 3x3, ...)
иначе возвращать null; (возможные ошибки: null вместо массива, одна из размерностей = 0,
длина не равна ширине, есть строки разной длины,
 есть строки с null вместо одномерных массивов)
 2) "проворачивает" массив по часовой стрелке на 90 градусов,
 т.е [1] -> [1] [[1, 2], [3, 4]] -> [[3, 1], [4, 2]] [[1, 2, 3], [4, 5, 6], [7, 8, 9]] -> [[7, 4, 1], [8, 5, 2], [9, 6, 3]] ...
*/


    public int[][] rotateClockwise(int[][] arg) {
        if (null == arg) {
            return null;
        }
        if (arg[0] == null) {
            return null;
        }
        int argXLength = arg.length;
        int argYLength = arg[0].length;
        if (argXLength == 0) {
            return null;
        }
        if (argXLength != argYLength) {
            return null;
        }
        if (argXLength == 1) return arg;
        for (int argX = 0; argX < argXLength; argX++) {
            for (int argY = 0; argY < argYLength; argY++) {
                int[] internalArray = arg[argX];
                if (internalArray == null) {
                    return null;
                }
                if (internalArray.length != argXLength) {
                    return null;
                }
            }
        }
        int[][] returnArray = new int[argXLength][argYLength];
        for (int argX = 0; argX < argXLength; argX++) {
            for (int argY = 0; argY < argYLength; argY++) {
                int argItem = arg[argXLength - argY - 1][argX];
                returnArray[argX][argY] = argItem;
            }
        }
        return returnArray;
    }


}
