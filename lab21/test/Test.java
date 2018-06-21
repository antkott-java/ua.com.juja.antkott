import org.junit.jupiter.api.Assertions;
import ua.com.juja.core.antkott.MatrixUtils;

public class Test {

    int[][] a1 = {{1,2}, {7,8}, {3,4}};
    int[][] b1 = {{3,4,5,6},{9,0,1,2}};
    int[][] cExpected = {{21,4,7,10},{93,28,43,58},{45,12,19,26}};

//    @org.junit.jupiter.api.Test
    public static void main(String[] args) {
        int[][] a = {{10}};
        int[][] b = {{100}};
        int[][] c = MatrixUtils.mul(a, b);




        if (c.length != 1) {
            throw new AssertionError();
        }
        if (c[0].length != 1) {
            throw new AssertionError();
        }
        if (c[0][0] != a[0][0] * b[0][0]) {
            throw new AssertionError();
        }



        System.out.print("OK");
    }

    @org.junit.jupiter.api.Test
    public void checkArrays(){
        Assertions.assertArrayEquals(cExpected,MatrixUtils.mul(a1,b1));
    }
}
