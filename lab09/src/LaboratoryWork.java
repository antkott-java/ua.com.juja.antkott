public class LaboratoryWork {

    public int[] filterArrayCuttingLength(int[] input) {
        int length = input.length;
        int counter = 0;
        for (int i = 0; i < length; i++) {
            int arrayItem = input[i];
            if (arrayItem % 2 == 0) {
                counter++;
            }
        }
        int[] output = new int[counter];
        int counter2 = 0;
        for (int i = 0; i < length; i++) {
            int arrayItem = input[i];

            if (arrayItem % 2 == 0) {
                output[counter2] = arrayItem;
                Logging.LOG_INFO("output " +counter2+ " ==>"+output[counter2]);
                counter2++;
            }
        }

        return output;
    }

    public int[] filterArray(int[] input)
    {
        return input;

    }


    // Logging.LOG_INFO("array size is - " + length);


   /* Отфильтровать массив так, чтобы оставить только четные элементы. Для проверки четности можно использовать операцию "остаток от деления" - %
            3 % 2 == 1;
6 % 2 == 0;
    Исходящий массив, для простоты, должен быть того же размера, что и входящий. Например, для {4, 3, 5, 6, 7, 9} -> {4, 6, 0, 0, 0, 0}
    */

}
