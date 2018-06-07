import ua.com.juja.core.antkott.Parser;

public class ParserTestOrigin {
    public static void main(String[] args) {
        System.out.println(">> 123 = " + Parser.eval("123"));
        System.out.println(">> 2*3 = " + Parser.eval("2*3"));
        System.out.println(">> 2*(1+3) = " + Parser.eval("2*(1+3)"));
        System.out.println(">> 1+(5-2*(13/6)) = " + Parser.eval("1+(5-2*(13/6))"));
    }
}
