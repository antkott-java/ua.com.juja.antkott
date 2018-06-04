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

    public int[] quickSort(int[] input) {
        long startTime = System.currentTimeMillis();
        int[] in = input.clone();

        quickSortInternal(in, 0, in.length - 1);

        long duration = System.currentTimeMillis() - startTime;
        logInfo("Quick Sort duration = " + duration);
        return in;
    }

    private void quickSortInternal(int[] arr, int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            quickSortInternal(arr, low, pi - 1);
            quickSortInternal(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }


}
