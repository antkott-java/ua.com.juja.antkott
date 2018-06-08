package ua.com.juja.core.antkott;

import static ua.com.juja.core.antkott.utils.Logging.logInfo;

public class ParserOrigin {
    public static void main(String[] args) {
        System.out.println(eval("123"));
        System.out.println(eval("2*3"));
        System.out.println(eval("2*(1+3)"));
        System.out.println(eval("1+(5-2*(13/6))"));
    }

    public static int eval(String expr) {
        return eval(expr, 0, expr.length());
    }

    private static int eval(String expr, int from, int to) {
        logInfo("input expr: " + expr + " from:" + from + " to:" + to + getExpr(expr, from, to));
        if (expr.charAt(from) == '(') {
            logInfo("if '(': " +  getExpr(expr, from+1, to-1));
            return eval(expr, from + 1, to-1);
        } else {
            logInfo("else '(': " +   getExpr(expr, from, to));
            int pos = from;
            while (pos < to) {
                if (Character.isDigit(expr.charAt(pos))) {
                    pos++;
                    logInfo("pos++: " + pos);
                } else {
                    logInfo("leftOperand: " + (expr.substring(from, pos)));
                    int leftOperand = Integer.valueOf(expr.substring(from, pos));
                    char operation = expr.charAt(pos);
                    int rightOperand = eval(expr, pos + 1, to);
                    logInfo("operation:" + operation + " expr:" + expr + " chartAt(" + pos + ") is:" + operation);
                    switch (operation) {
                        case '+':
                            return leftOperand + rightOperand;
                        case '-':
                            return leftOperand - rightOperand;
                        case '*':
                            return leftOperand * rightOperand;
                        case '/':
                            return leftOperand / rightOperand;
                    }
                }
            }
            return Integer.valueOf(expr.substring(from, to));
        }
    }

    private static String getExpr(String expr, int from, int to) {
        return " ["+expr.substring(from, to)+"] ";
    }
}
