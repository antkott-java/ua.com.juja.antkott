package ua.com.juja.core.antkott;

import static ua.com.juja.core.antkott.utils.Logging.logInfo;

public class Runner_LaboratoryWork {

    private static LaboratoryWork laboratoryWorkRunner;

    public static void main(String[] args) {
        laboratoryWorkRunner = new LaboratoryWork();
        String more_actions_are_needed = laboratoryWorkRunner.solve("MORE_ACTIONS_ARE_NEEDED");
        logInfo("result: " +more_actions_are_needed);
        logInfo("fibonachi (n=6): " +laboratoryWorkRunner.fibonachi(6));


    }





}
