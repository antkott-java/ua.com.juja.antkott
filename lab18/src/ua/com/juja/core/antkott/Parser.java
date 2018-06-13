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
        return eval(expr, 0, expr.length()-1);
    }

    private static int eval(String expr, int from, int to) {

        int length = expr.length();
        //if (to == length) to--;
        logInfo("INPUT " +getExpr(expr, from, to));
        logInfo("(from:to)=(" +from+":"+ to+")");
        //from=length;

        logInfo(" if expr.charAt(to:"+to+")==) (" + expr.charAt(to)+"), "+(expr.charAt(to) == ')'));
        if (expr.charAt(to) == ')') {
            logInfo(" if ')': " + getExpr(expr, from + 1, to - 1));
            return eval(expr, from + 1, to - 1);
        } else {
//            logInfo(" else ')': " + getExpr(expr, from, to));
            int pos = to;
            logInfo(" (pos>from) " + pos + ">" + from + " = "+(pos > from));
            while (pos > from) {
                logInfo("  start while: expr.charAt("+pos+"):" + expr.charAt(pos));
                if (Character.isDigit(expr.charAt(pos))) {
                    logInfo("   character.isDigit("+pos+"):" + expr.charAt(pos)+" pos--");
                    pos--;
                } else {
                    logInfo("   pos:from:to "+pos+":"+from+":"+to);
                    logInfo("   Character.isNOTDigit("+pos+"):" + expr.charAt(pos));
//                    logInfo("leftOperand: " +  getExpr(expr, from, pos));
//                    int leftOperand = Integer.valueOf(expr.substring(from, pos));
                    logInfo("   rightOperand: Integer.valueOf: " +  getExpr(expr, pos+1, pos+2));
                    int rightOperand = Integer.valueOf(expr.substring(pos+1, pos+2));
                    logInfo("   operation: expr.charAt("+pos+"):" + expr.charAt(pos));
                    char operation = expr.charAt(pos);
                    logInfo("   leftOperand: run another eval" +  getExpr(expr, from, pos-1));
                    int leftOperand = eval(expr, from, pos-1);

//                    int rightOperand = eval(expr, pos + 1, to);

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
            logInfo("return Integer.valueOf " + getExpr(expr, from, to+1));
            return Integer.valueOf(expr.substring(from, to+1));
        }
    }

    private static String getExpr(String expr, int from, int to) {
        return "("+from+":"+to+"):" + expr.substring(from, to) + ":";
    }
}
