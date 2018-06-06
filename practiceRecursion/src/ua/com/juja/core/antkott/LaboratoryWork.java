package ua.com.juja.core.antkott;

import static ua.com.juja.core.antkott.utils.Logging.logInfo;

public class LaboratoryWork {

    /*
     */


    public String solve(String condition) {
        logInfo("condition: " + condition);
        switch (condition) {
            case "MORE_ACTIONS_ARE_NEEDED": {
                return solve("SOME_NEW_CONDITIONS");
            }
            default: {
                return "THE_END_OF_RECURSION";
            }
        }
    }

    public int fibonachi(int n) {
        if (n > 2) {
            return fibonachi(n - 1) + fibonachi(n - 2);
        }
        return 1;
    }
}
