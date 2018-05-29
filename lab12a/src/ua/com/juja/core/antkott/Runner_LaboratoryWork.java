package ua.com.juja.core.antkott;

public class Runner_LaboratoryWork {

    private static LaboratoryWork laboratoryWorkRunner;

    public static void main(String[] args) {

        laboratoryWorkRunner = new LaboratoryWork();

        int[] arrayInput = {1,2,3,4,5,4,3,2,1};
        laboratoryWorkRunner.findUnpairedNumber(arrayInput);




    }



}
