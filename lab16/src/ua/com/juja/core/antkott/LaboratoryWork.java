package ua.com.juja.core.antkott;

import static ua.com.juja.core.antkott.utils.Logging.logInfo;


public class LaboratoryWork {

    /*
    https://visualgo.net/en/sorting
    http://www.java2novice.com/java-sorting-algorithms/
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
            int location = k - 1;
            while (location >= 0 && arr[location] > newElement) {
                arr[location + 1] = arr[location];
                location--;
            }
            arr[location + 1] = newElement;
        }

        long duration = System.currentTimeMillis() - startTime;
        logInfo("Insertion Sort Lab16 duration = " + duration);
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
