import ua.com.juja.core.antkott.ParserOrigin;

public class ParserTestOrigin {
    public static void main(String[] args) {
        // System.out.println(">> 123 = " + ParserOrigin.eval("123"));
        // System.out.println(">> 2*3 = " + ParserOrigin.eval("2*3"));
        // System.out.println(">> 2*(1+3) = " + ParserOrigin.eval("2*(1+3)"));
        System.out.println(">> 1+(5-2*(13/6)) = " + ParserOrigin.eval("1+(5-2*(13/6))"));
    }
}
