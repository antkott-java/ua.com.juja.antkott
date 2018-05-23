import lab.utils.Logging;

public class LaboratoryWork {

/*
    Необходимо корректно реализовать слияние отсортированных по возрастанию массивов
    В данной заготовке метод merge реализован с ошибкой - он корректно сливает, но некорректно обрабатывает ситуацию, когда один из массивов полностью выбран.
            Задача: Исправить ошибку.
    Дополнительные улучшения: Попробуй минимизировать количество операций (сравнение, сумма, присвоение, ...) на один "сливаемый" элемент. Помни,
     "сравнение" намного дороже арифметических операций.
*/

    public int[] mergeSortedArrays(int[] input1, int[] input2) {
        Logging.LOG_INFO("======== ||||||mergeSortedArrays||||||| ==");
        StringBuilder stringBuilder1 = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        for (int item : input1
                ) {
            stringBuilder1.append(item).append(", ");
        }
        Logging.LOG_INFO("main-input1 ==> [" + stringBuilder1 + "]");
        for (int item : input2
                ) {
            stringBuilder2.append(item).append(", ");
        }
        Logging.LOG_INFO("main-input2 ==> [" + stringBuilder2 + "]");
        int[] merged = new int[input1.length + input2.length];
        int counterInputsArray1 = 0;
        int counterInputsArray2 = 0;
        int length1 = input1.length;
        int length2 = input2.length;
        for (int i = 0; i < merged.length; i++) {
            if (counterInputsArray1 < length1 && counterInputsArray2 < length2) {
                if (input1[counterInputsArray1] < input2[counterInputsArray2]) {
                    merged[i] = input1[counterInputsArray1];
                    counterInputsArray1++;
                } else {
                    merged[i] = input2[counterInputsArray2];
                    counterInputsArray2++;
                }
            } else if (counterInputsArray2 >= length2) {
                merged[i] = input1[counterInputsArray1];
                counterInputsArray1++;
            } else if (counterInputsArray1 >= length1) {
                merged[i] = input2[counterInputsArray2];
                counterInputsArray2++;
            }
        }
        Logging.LOG_INFO("======== main-merged ==");
        for (int item : merged
                ) {
            Logging.LOG_INFO("main-merged ==> " + item);
        }
        return merged;
    }

    public int[] mergeSortedArraysExampleFromJuja(int[] fst, int[] snd) {

        int[] result = new int[fst.length + snd.length];
        int fstIndex = 0;
        int sndIndex = 0;
        int counter = 0;
        while (counter != result.length) {
            if (fstIndex < fst.length && sndIndex < snd.length) {
                if (fst[fstIndex] < snd[sndIndex]) {
                    result[counter] = fst[fstIndex++];
                } else {
                    result[counter] = snd[sndIndex++];
                }
            } else if (fstIndex >= fst.length) {
                result[counter] = snd[sndIndex++];
            } else if (sndIndex >= snd.length) {
                result[counter] = fst[fstIndex++];
            }
            counter = fstIndex + sndIndex;
        }
        return result;
    }


}
