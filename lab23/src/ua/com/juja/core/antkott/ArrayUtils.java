package ua.com.juja.core.antkott;

public class ArrayUtils {

/*
Реализуйте метод rotateClockwise класса ArrayUtils, который

1. Проверяет, что метод получил "кубическую" матрицу (допустимые размеры
1x1x1, 2x2x2, 3x3x3, ...) иначе возвращает null; (возможные ошибки:
аргумент равен null, "длина" / "ширина" / "высота" не равны,
есть строки разной длины, есть строки с null вместо одномерных/двумерных массивов ...)

2. "Проворачивает куб" относительно главной диагонали проходящей от элемента [0][0][0] до элемента [L-1][L-1][L-1] (L - длина "грани куба") массив по часовой стрелке на 120 градусов (по часовой стрелке - если смотреть вдоль оси от элемента [L-1][L-1][L-1] в сторону элемента [0][0][0]),
То есть
[[[1]]] -> [[[1]]]
[  [[1, 2], [3, 4]], [[5, 6], [7, 8]] ] -> [ [[1, 5], [2, 6]], [[3, 7], [4, 8]] ]

[ [[10, 11, 12], [20, 21, 22], [30, 31, 32]], [[40, 41, 42], [50, 51, 52], [60, 61, 62]], [[70, 71, 72], [80, 81, 82], [90, 91, 92]] ] ->
[ [[10, 40, 70], [11, 41, 71], [12, 42, 72]], [[20, 50, 80], [21, 51, 81], [22, 52, 82]], [[30, 60, 90], [31, 61, 91], [32, 62, 92]] ] ...
 */


    public int[][][] rotateClockwise(int[][][] arg) {
        if (null == arg) {
            return null;
        }
        if (arg[0] == null|| arg[0][0] == null) {
            return null;
        }
        int argXLength = arg.length;
        int argYLength = arg[0].length;
        int argZLength = arg[0][0].length;
        if (argXLength == 0||argYLength==0||argZLength==0) {
            return null;
        }
        if (argXLength != argYLength || argYLength!=argZLength) {
            return null;
        }
        if (argXLength == 1) return arg;
        for (int argX = 0; argX < argXLength; argX++) {
            for (int argY = 0; argY < argYLength; argY++) {
                int[][] internalArray = arg[argX];
                if (internalArray == null) {
                    return null;
                }
                if (internalArray.length != argXLength) {
                    return null;
                }
            }
        }
        int[][][] returnArray = new int[argXLength][argYLength][argZLength];
        for (int argX = 0; argX < argXLength; argX++) {
            for (int argY = 0; argY < argYLength; argY++) {
                int[] argItem = arg[argXLength - argY - 1][argX];
                returnArray[argX][argY] = argItem;
            }
        }
        return returnArray;
    }


}
