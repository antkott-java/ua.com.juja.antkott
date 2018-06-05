package ua.com.juja.core.antkott;

import java.lang.reflect.Array;
import java.util.Arrays;

import static ua.com.juja.core.antkott.utils.Logging.logInfo;
import static ua.com.juja.core.antkott.utils.lab.LaboratoryWorkUtils.printArrayElements;


public class LaboratoryWork {

    /*
    https://visualgo.net/en/sorting
    http://www.java2novice.com/java-sorting-algorithms/
     */

    /*
            Такая версия алгоритм сортировки вставками

            public class InsertionSorter {
                public static void sort(int[] arr) {
                    for (int k = 1; k < arr.length; k++) {
                        int newElement = arr[k];
                        int location = k - 1;
                        while (location >= 0 && arr[location] > newElement) {
                            arr[location + 1] = arr[location];
                            location--;
                        }
                        arr[location + 1] = newElement;
                    }
                }
            }
            реализована не оптимально, так как внутренний цикл while
            - ищет позицию для вставки, перебирая последовательно элементы, при этом он
            - поэлементно "смещает" массив.

            В целях оптимизации перепишите алгоритм:
            1. Ищите позицию для вставки элемента бинарным поиском (Arrays.binarySearch(...)).
            2. Найдя позицию - смещайте всю часть массива за один вызов (System.arraycopy(...)).
            В моих экспериментах эти две оптимизации ускорили сортировку в 2.2-2.6 раза. Скорость сортировки измерял данным кодом

            import java.util.Random;

            public class App {
                public static void main(String[] args) {
                    int[] array = new int[256 * 1024];
                    Random rnd = new Random(0);
                    for (int k = 0; k < array.length; k++) {
                        array[k] = rnd.nextInt();
                    }
                    long t1 = System.nanoTime();
                    InsertionSorter.sort(array);
                    System.out.println("A:" + (System.nanoTime() - t1) / 1_000_000);
                }
            }
 */


    private void swapElements(int[] array, int firstElement, int secondElement) {
        int temp = array[secondElement];
        array[secondElement] = array[firstElement];
        array[firstElement] = temp;
    }


    public int[] insertionSortLab16Origin(int[] input) {
        long startTime = System.currentTimeMillis();
        int[] arr = input.clone();
        for (int k = 1; k < arr.length; k++) {
            int newElement = arr[k];
            int location = k - 1;
            while (location >= 0 && arr[location] > newElement) {
                arr[location + 1] = arr[location];
                location--;
            }
            arr[location + 1] = newElement;
        }

        long duration = System.currentTimeMillis() - startTime;
        logInfo("Insertion Sort Lab16 Origin duration = " + duration);
        return arr;
    }

    public int[] insertionSortLab16(int[] input) {
        long startTime = System.currentTimeMillis();
        int[] arr = input.clone();
        for (int k = 1; k < arr.length; k++) {
            int newElement = arr[k];
            int indexBinarySearch = Arrays.binarySearch(arr, 0, k, newElement);
            if (indexBinarySearch < 0) {
                indexBinarySearch = -(indexBinarySearch) - 1;
            }
            System.arraycopy(arr, indexBinarySearch, arr, indexBinarySearch + 1, k - indexBinarySearch);
            arr[indexBinarySearch] = newElement;
        }

        long duration = System.currentTimeMillis() - startTime;
        logInfo("Insertion Sort Lab16 duration = " + duration);
        printArrayElements(arr);
        return arr;
    }

    public int[] insertionSortLab16FromSite(int[] input) {
        long startTime = System.currentTimeMillis();
        int[] arr = input.clone();
        for (int k = 1; k < arr.length; k++) {
            int newElement = arr[k];
            int index = Arrays.binarySearch(arr, 0, k, newElement);
            if (index < 0) {
                index = -(index) - 1;
            }
            System.arraycopy(arr, index, arr, index + 1, k - index);
            arr[index] = newElement;
        }
        long duration = System.currentTimeMillis() - startTime;
        logInfo("Insertion Sort Lab16 form site duration = " + duration);
        //printArrayElements(arr);
        return arr;
    }

    public int[] insertionSort(int[] input) {
        long startTime = System.currentTimeMillis();
        int[] in = input.clone();
        for (int i = 1; i < in.length; i++) {
            int key = in[i];
            int j = i - 1;
            while (j >= 0 && in[j] > key) {
                in[j + 1] = in[j];
                j--;
            }
            in[j + 1] = key;
        }

        long duration = System.currentTimeMillis() - startTime;
        logInfo("Insertion Sort duration = " + duration);
        return in;
    }

    public int[] insertionSort2(int[] input) {
        long startTime = System.currentTimeMillis();
        int[] in = input.clone();
        for (int i = 1; i < in.length; i++) {
            for (int j = i; j > 0; j--) {
                if (in[j] < in[j - 1]) {
                    swapElements(in, j, j - 1);
                }
            }
        }
        long duration = System.currentTimeMillis() - startTime;
        logInfo("Insertion Sort 2 duration = " + duration);
        return in;
    }


}
