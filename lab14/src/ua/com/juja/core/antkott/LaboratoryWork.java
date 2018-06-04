package ua.com.juja.core.antkott;

import static ua.com.juja.core.antkott.utils.Logging.logInfo;
import static ua.com.juja.core.antkott.utils.lab.LaboratoryWorkUtils.printArrayElements;


public class LaboratoryWork {

    /*
    https://visualgo.net/en/sorting
    http://www.java2novice.com/java-sorting-algorithms/
     */

    public int[] bubbleSort(int[] input) {
        long startTime = System.currentTimeMillis();
        int[] in = input.clone();

        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < in.length - 1; i++) {
                if (in[i] > in[i + 1]) {
                    swapped = true;
                    swapElements(in, i + 1, i);
                }
            }
        }
        long duration = System.currentTimeMillis() - startTime;
        logInfo("Bubble Sort duration = " + duration);
        return in;
    }

    private void swapElements(int[] array, int firstElement, int secondElement) {
        int temp = array[secondElement];
        array[secondElement] = array[firstElement];
        array[firstElement] = temp;
    }

    public int[] bubbleSortMy(int[] input) {
        long startTime = System.currentTimeMillis();
        int[] in = input.clone();

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length - 1; j++) {
                if (in[j] > in[j + 1]) {
                    swapElements(in, j, j + 1);
                }
            }
        }


        long duration = System.currentTimeMillis() - startTime;
        logInfo("Bubble Sort My duration = " + duration);
        return in;
    }

    public int[] bubbleSortLab14(int[] input) {
        long startTime = System.currentTimeMillis();
        int[] in = input.clone();

        for (int barrier = in.length - 1; barrier >= 0; barrier--) {
            for (int index = 0; index < barrier; index++) {
                if (in[index] > in[index + 1]) {
                    swapElements(in, index, index + 1);
                }
            }
        }


        long duration = System.currentTimeMillis() - startTime;
        logInfo("Bubble Sort Lab14 duration = " + duration);
        return in;
    }

    public int[] bubbleSortLab14My(int[] input) {
        long startTime = System.currentTimeMillis();
        int[] arr = input.clone();
//        printArrayElements(in);

        for (int barrier = 0; barrier <= arr.length - 1; barrier++) {
            for (int index = arr.length - 1; index > barrier; index--) {
                if (arr[index] < arr[index - 1]) {
                    swapElements(arr, index, index - 1);
                }
            }
        }

//        printArrayElements(in);
        long duration = System.currentTimeMillis() - startTime;
        logInfo("Bubble Sort Lab14 my duration = " + duration);
        return arr;
    }


}
