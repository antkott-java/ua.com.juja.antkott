package ua.com.juja.core.antkott;

import static lab.utils.Logging.LOG_INFO;

public class LaboratoryWork {
    public static final int ERROR_CODE = -1;

    public int findUnpairedNumber(int array[]) {
        int result = ERROR_CODE;
        for (int i = 0; i < array.length; i++) {
            if (!isPairedNumberFound(array, i)) {
                result = i;
            }
        }
        LOG_INFO("found Unpaired number index = " + result);
        return result;
    }

    private boolean isPairedNumberFound(int[] array, int currentIndex) {
        int currentItem = array[currentIndex];

        for (int j = 0; j < array.length; j++) {
            if (j == currentIndex) {
                continue;
            }
            if (currentItem == array[j]) {
                LOG_INFO("found paired for " + currentItem + " this is " + array[j]);
                return true;
            }
        }
        return false;
    }

}
