package ua.com.juja.core.antkott.utils.lab;

import static ua.com.juja.core.antkott.utils.Logging.logInfo;

public class LaboratoryWorkUtils {

    public static void printArrayElements(int[] array){
        StringBuilder arrayItems = new StringBuilder("array ("+array.length+"): ");
        for (int item:array
             ) {
            arrayItems.append(item).append(", ");
        }
        logInfo(arrayItems.toString());
    }

}
