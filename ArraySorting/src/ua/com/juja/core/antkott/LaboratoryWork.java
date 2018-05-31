package ua.com.juja.core.antkott;

import static ua.com.juja.core.antkott.utils.Logging.logInfo;


public class LaboratoryWork {

    /*
     */

    public int[] bubbleSort(int[] input) {
        long startTime = System.currentTimeMillis();
        int[] in = input.clone();


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
