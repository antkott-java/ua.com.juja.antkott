import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Tester_ArrayReverser {


    public static Integer[] reverse(Integer[] arr) {
        List<Integer> list = Arrays.asList(arr);
        Collections.reverse(list);
        Integer[] ts = new Integer[list.size()-1];
        return list.toArray(ts);
    }

}
