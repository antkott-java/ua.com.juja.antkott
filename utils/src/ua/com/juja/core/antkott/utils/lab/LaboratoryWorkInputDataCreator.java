package ua.com.juja.core.antkott.utils.lab;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class LaboratoryWorkInputDataCreator {

    final static private Random rand = new Random();


    public static int[] getRandomArrayWithIntValue(int max) {
        int arraySize = ThreadLocalRandom.current().nextInt(1, max);
        int[] array = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            int randomInt = ThreadLocalRandom.current().nextInt(-9999, 9999 + 1);
            array[i] = randomInt;
        }
        return array;
    }

    public static int getRandomInt(int max) {
        return ThreadLocalRandom.current().nextInt(1, max);
    }

    public static int[][] generateIntUnsortedAndSortedArray(final int length, final int minVal,
                                          final int maxVal) {
        List<Integer> unsortedList=getUnSortedList(length,minVal,maxVal);
        int size = unsortedList.size();
        int[] unsortedArray = new int[size];
        int[] sortedArray = new int[size];
        for (int i = 0; i <size ; i++) {
            unsortedArray[i] = unsortedList.get(i).intValue();
        }
        Collections.sort(unsortedList);
        for (int i = 0; i <size ; i++) {
            sortedArray[i] = unsortedList.get(i).intValue();
        }
        return new int[][]{unsortedArray, sortedArray};
    }

    private static List<Integer> getUnSortedList(final int length, final int minVal,
                                                 final int maxVal) {
        List<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<length;i++){
            //creates a random number from 0 ~ max value exclusive, then add the min value.
            list.add(rand.nextInt(maxVal)+minVal);
        }
        return list;

    }
}
