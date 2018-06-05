package ua.com.juja.core.antkott;

import static ua.com.juja.core.antkott.utils.Logging.logInfo;
import static ua.com.juja.core.antkott.utils.lab.LaboratoryWorkUtils.printArrayElements;


public class LaboratoryWork {

    /*
    https://visualgo.net/en/sorting
    http://www.java2novice.com/java-sorting-algorithms/
     */


    public int[] selectSortFromInet(int[] input) {
        long startTime = System.currentTimeMillis();
        int[] in = input.clone();
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < in.length - 1; i++) {
            int index = i;
            // Find the minimum element in unsorted array
            for (int j = i + 1; j < in.length; j++) {
                if (in[j] < in[index]) {
                    index = j;
                }
            }
            // Swap the found minimum element with the first element
            swapElements(in, i, index);
        }
        long duration = System.currentTimeMillis() - startTime;
        logInfo("Select Sort-from-inet duration = " + duration);
        return in;
    }

    private void swapElements(int[] array, int firstElement, int secondElement) {
        int temp = array[secondElement];
        array[secondElement] = array[firstElement];
        array[firstElement] = temp;
    }

    public int[] selectSortLab15Original(int[] input) {
        long startTime = System.currentTimeMillis();
        int[] arr = input.clone();
        for (int barrier = 0; barrier < arr.length - 1; barrier++) {
            for (int index = barrier + 1; index < arr.length; index++) {
                if (arr[barrier] > arr[index]) {
                    int tmp = arr[index];
                    arr[index] = arr[barrier];
                    arr[barrier] = tmp;
                }
            }
        }
        long duration = System.currentTimeMillis() - startTime;
        logInfo("Select Sort Lab15 original duration = " + duration);
        return arr;
    }

    public int[] selectSortLab15(int[] input) {
        long startTime = System.currentTimeMillis();
        int[] arr = input.clone();
        //printArrayElements(arr);
        for (int barrier = 0; barrier < arr.length - 1; barrier++) {
            int itemBarrier = arr[barrier];
            int smallestElement = itemBarrier;
            int smallestElementIndex = barrier;
            for (int index = barrier + 1; index < arr.length; index++) {
                if (smallestElement > arr[index]) {
                    smallestElement = arr[index];
                    smallestElementIndex = index;
                }
            }
            arr[barrier] = smallestElement;
            arr[smallestElementIndex] = itemBarrier;
        }

        long duration = System.currentTimeMillis() - startTime;
        logInfo("Select Sort Lab15 duration = " + duration);
        printArrayElements(arr);
        return arr;
    }


}
