package ua.com.juja.core.antkott;

import static ua.com.juja.core.antkott.utils.Logging.logInfo;

public class Parser {
    public static void main(String[] args) {
        System.out.println(eval("123"));
        System.out.println(eval("2*3"));
        System.out.println(eval("2*(1+3)"));
        System.out.println(eval("1+(5-2*(13/6))"));
    }


    public static int eval(String expr) {
        rightOperandStr = null;
        return eval(expr, 0, expr.length() - 1);
    }

    private static String rightOperandStr;

    private static int eval(String expr, int from, int to) {
        logInfo("INPUT " + getExpr(expr, from, to));
        logInfo("(from:to)=(" + from + ":" + to + ")");
        logInfo(" if expr.charAt(to:" + to + ")==) (" + expr.charAt(to) + "), " + (expr.charAt(to) == ')'));
        if (expr.charAt(to) == ')') {
            logInfo(" if ')': " + getExpr(expr, from + 1, to - 1));
            return eval(expr, from + 1, to - 1);
        } else {
            int pos = to;
            logInfo(" (pos>from) " + pos + ">" + from + " = " + (pos > from));
            while (pos > from) {
                logInfo("  start while: expr.charAt(" + pos + "):" + expr.charAt(pos));
                if (Character.isDigit(expr.charAt(pos))) {
                    logInfo("   character.isDigit(" + pos + "):" + expr.charAt(pos) + " pos--");
                    if (rightOperandStr != null) {
                        rightOperandStr = expr.charAt(pos) + rightOperandStr;
                        logInfo("   rightOperandStr: " + rightOperandStr);
                    } else {
                        rightOperandStr = expr.substring(pos, pos + 1);
                        logInfo("   rightOperandStr (null): " + rightOperandStr);
                    }
                    pos--;
                } else {
                    logInfo("   pos:from:to " + pos + ":" + from + ":" + to);
                    logInfo("   Character.isNOTDigit(" + pos + "):" + expr.charAt(pos));
                    logInfo("   rightOperand: Integer.valueOf: " + rightOperandStr);
                    int rightOperand = Integer.valueOf(rightOperandStr);
                    rightOperandStr = null;
                    logInfo("   operation: expr.charAt(" + pos + "):" + expr.charAt(pos));
                    char operation = expr.charAt(pos);
                    logInfo("   leftOperand: run another eval" + getExpr(expr, from, pos - 1));
                    int leftOperand = eval(expr, from, pos - 1);
                    logInfo("    operation: " + operation + " expr:" + expr + " chartAt(" + pos + ") is:" + operation);
                    logInfo("     operation: " + leftOperand + " " + operation + " " + rightOperand);
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
            logInfo("return Integer.valueOf " + getExpr(expr, from, to + 1));
            return Integer.valueOf(expr.substring(from, to + 1));
        }
    }

    private static String getExpr(String expr, int from, int to) {
        return "(" + from + ":" + to + "):" + expr.substring(from, to) + ":";
    }
}
