package ua.com.juja.core.antkott;

import static ua.com.juja.core.antkott.utils.Logging.logInfo;


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

    public int[] selectSort(int[] input) {
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
        logInfo("Select Sort duration = " + duration);
        return in;
    }

    private void swapElements(int[] array, int firstElement, int secondElement) {
        int temp = array[secondElement];
        array[secondElement] = array[firstElement];
        array[firstElement] = temp;
    }

    public int[] insertSort(int[] input) {
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

    public int[] insertSort2(int[] input) {
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
