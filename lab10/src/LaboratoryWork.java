import lab.utils.Logging;

public class LaboratoryWork {

/*
    Необходимо корректно реализовать слияние отсортированных по возрастанию массивов
    В данной заготовке метод merge реализован с ошибкой - он корректно сливает, но некорректно обрабатывает ситуацию, когда один из массивов полностью выбран.
            Задача: Исправить ошибку.
    Дополнительные улучшения: Попробуй минимизировать количество операций (сравнение, сумма, присвоение, ...) на один "сливаемый" элемент. Помни, "сравнение" намного дороже арифметических операций.
*/

    public int[] mergeSortedArrays(int[] input1, int[] input2) {

        int[] merged = new int[input1.length + input2.length];
        int counterInputsArray1 = 0;
        int counterInputsArray2 = 0;
        for (int i = 0; i < merged.length - 1; i++) {
            int length1 = input1.length;
            int length2 = input2.length;
            int itemFromArray1 = 0;
            int itemFromArray2 = 0;
            if (counterInputsArray1 < length1) {
                itemFromArray1 = input1[counterInputsArray1];
                counterInputsArray1++;
            }
            if (counterInputsArray2 < length2) {
                itemFromArray2 = input2[counterInputsArray2];
                counterInputsArray2++;
            }
            if (itemFromArray1 < itemFromArray2) {
                merged[i] = itemFromArray1;
                merged[i + 1] = itemFromArray2;
            } else {
                merged[i] = itemFromArray2;
                merged[i + 1] = itemFromArray1;
            }

        }
        Logging.LOG_INFO("======== ||||||||||||| ==");
        for (int item : input1
                ) {
            Logging.LOG_INFO("main-input1 ==> " + item);
        }
        for (int item : input2
                ) {
            Logging.LOG_INFO("main-input2 ==> " + item);
        }
        Logging.LOG_INFO("======== main-merged ==");
        for (int item : merged
                ) {
            Logging.LOG_INFO("main-merged ==> " + item);
        }
        return merged;
    }


}
