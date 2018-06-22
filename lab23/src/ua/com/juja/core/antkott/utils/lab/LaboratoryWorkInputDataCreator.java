package ${IJ_BASE_PACKAGE};

import java.util.concurrent.ThreadLocalRandom;

public class LaboratoryWorkInputDataCreator {

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
}
