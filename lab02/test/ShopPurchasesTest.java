
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ShopPurchasesTest {


    @DisplayName("Should return purchases result")
    //@ParameterizedTest
    //@ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
    @Test
    void doPurchases() {
        ShopPurchases tester = new ShopPurchases();
        assertEquals("bread, eggs", tester.doPurchases(true,true), "true, true must be (bread, eggs)");
        assertEquals("bread", tester.doPurchases(false,true), "false, true must be (bread)");
        assertEquals("eggs", tester.doPurchases(true,false), "true, false must be (eggs)");
        assertEquals("", tester.doPurchases(false,false), "false, false must be ()");
        //System.out.print("sss");
    }
}