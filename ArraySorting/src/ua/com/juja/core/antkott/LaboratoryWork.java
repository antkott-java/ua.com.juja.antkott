package ua.com.juja.core.antkott;

import static ua.com.juja.core.antkott.utils.Logging.logInfo;


public class LaboratoryWork {

    /*
    https://visualgo.net/en/sorting
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
                    int tmp = in[i];
                    in[i] = in[i + 1];
                    in[i + 1] = tmp;
                }
            }
        }
        long duration = System.currentTimeMillis() - startTime;
        logInfo("bubbleSort duration = " + duration);
        return in;
    }

    public int[] selectSort(int[] input) {
        long startTime = System.currentTimeMillis();
        int[] in = input.clone();


        long duration = System.currentTimeMillis() - startTime;
        logInfo("bubbleSort duration = " + duration);
        return in;
    }

    public int[] insertSort(int[] input) {
        long startTime = System.currentTimeMillis();
        int[] in = input.clone();


        long duration = System.currentTimeMillis() - startTime;
        logInfo("bubbleSort duration = " + duration);
        return in;
    }


}
