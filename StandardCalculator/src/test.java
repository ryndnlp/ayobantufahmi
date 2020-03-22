import java.util.Scanner;

import data.expression.*;
import data.expression.binaryExpressions.AddExpression;

class test {
    public static void main(String[] args) {
        String inString = "-3 * 2 + (5 * (19 + 1)) * (11 % 2) + 1 - 10";
        //inString = "-10";
        //inString = "1+-5";
        //inString = "atan60";
        //inString = "";

        /*
        Scanner inScanner = new Scanner(System.in);
        System.out.printf("X : ");
        Double x = inScanner.nextDouble();
        System.out.printf("Y : ");
        Double y = inScanner.nextDouble();

        TerminalExpression xt = new TerminalExpression(x);
        TerminalExpression yt = new TerminalExpression(y);

        AddExpression ae = new AddExpression(xt, yt);
        */
        
        Expression<Double> outExp = null;
        try {
            //System.out.println(("X + Y = " + ae + " = " + ae.solve()));
            
            ExpressionParser exParser = new ExpressionParser();
            outExp = exParser.parse(inString);
            System.out.println("outEXP = " + outExp);
            System.out.println(inString + " => " + outExp.solve());



        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}