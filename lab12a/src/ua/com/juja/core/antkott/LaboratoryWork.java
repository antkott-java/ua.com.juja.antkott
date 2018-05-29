package ua.com.juja.core.antkott;

import static lab.utils.Logging.LOG_INFO;

public class LaboratoryWork {

    /*

     */


    public int findUnpairedNumber(int[] array) {
        int result = -1;
        for (int i = 0; i < array.length; i++) {
            int currentItem = array[i];
            boolean pairedNumberFound = false;

            for (int j = 0; j < array.length; j++) {
                if (j == i) {
                    continue;
                } else if (currentItem == array[j]) {
                    pairedNumberFound = true;
                    LOG_INFO("found paired for " + currentItem + " this is " + array[j]);

                }
            }
            if (!pairedNumberFound) {
                result = i;
            }
        }
        LOG_INFO("found Unpaired number index = " + result);
        return result;
    }

}
