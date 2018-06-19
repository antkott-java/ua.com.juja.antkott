import ua.com.juja.core.antkott.Permutator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;

public class Test {

    public static void main(String[] args) {
        String actualOutput = executePermutationsAndReturnOutput();

        List<List<Integer>> actual = parseOutput(actualOutput);
        List<List<Integer>> expected = asList(
                asList(1, 2, 3), asList(1, 3, 2),
                asList(2, 1, 3), asList(2, 3, 1),
                asList(3, 1, 2), asList(3, 2, 1)
        );

        checkDuplicates(actual);
        checkNoElements(actual, expected);
        checkMoreElements(actual, expected);

        System.out.print("OK");
    }

    private static List<List<Integer>> parseOutput(String actualPermutations) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        String[] arrays = actualPermutations.split(";");
        for (String array : arrays) {
            array = array.replace("[", "").replace("]", "");
            String[] digits = array.split(",\\s*");
            result.add(parseDigits(digits));
        }

        return result;
    }

    private static List<Integer> parseDigits(String[] digits) {
        List<Integer> res = new ArrayList<>(digits.length);
        for (String digit : digits) {
            res.add(Integer.valueOf(digit));
        }
        return res;
    }

    private static String executePermutationsAndReturnOutput() {
        PrintStream systemOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream wrappedStream = new PrintStream(outputStream);
        System.setOut(wrappedStream);

        Permutator.permutation(new int[] {1, 2, 3}, 3);

        System.setOut(systemOut);

        return new String(outputStream.toByteArray()).trim().replaceAll("\r\n", "\n").replaceAll("\n", ";");
    }

    private static void checkDuplicates(List<List<Integer>> actual) {
        if (actual.size() != new HashSet<>(actual).size()) {
            List<List<Integer>> actualCopy = new ArrayList<>(actual);
            Set<List<Integer>> actualSet = new HashSet<>(actual);
            for (List<Integer> elem : actualSet) {
                actualCopy.remove(elem);
            }
            throw new AssertionError("You have duplicates: " + new HashSet<>(actualCopy) + " in " + actual);
        }
    }

    private static void checkNoElements(List<List<Integer>> actual, List<List<Integer>> expected) {
        ArrayList<List<Integer>> expectedCopy = new ArrayList<>(expected);
        expectedCopy.removeAll(actual);
        if (expectedCopy.size() > 0) {
            throw new AssertionError("You don't have elements: actual=" + actual + " expected=" + expected + " expected\\actual=" + expectedCopy);
        }
    }

    private static void checkMoreElements(List<List<Integer>> actual, List<List<Integer>> expected) {
        ArrayList<List<Integer>> actualCopy = new ArrayList<>(actual);
        actualCopy.removeAll(expected);
        if (actualCopy.size() > 0) {
            throw new AssertionError("You have more elements: actual=" + actual + " expected=" + expected + " actual\\expected=" + actualCopy);
        }
    }
}
