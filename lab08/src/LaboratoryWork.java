public class LaboratoryWork {


    public int[] revertArray(int[] array) {

        int length = array.length;
        Logging.LOG_INFO("array size is - " + length);

        for (int i = 0; i < length / 2; i++) {
            int indexFromTheEnd = length - i - 1;
            int tmp = array[i];
            array[i] = array[indexFromTheEnd];
            array[indexFromTheEnd] = tmp;
        }
        return array;

    }

    public int[] revertArray2(int[] array) {

        int length = array.length;
        Logging.LOG_INFO("array size is - " + length);

        for (int i =  length / 2-1; i>=0 ;i--) {
            int indexFromTheEnd = length - i - 1;
            int tmp = array[i];
            array[i] = array[indexFromTheEnd];
            array[indexFromTheEnd] = tmp;
            System.out.println(array[i] + " " + array[indexFromTheEnd]);
        }

        for (int i = 0; i < length; i++) {
            System.out.println("[" + i + "] input - " + array[i]);
            //System.out.println(array[i]);
        }
        return array;

    }

}
