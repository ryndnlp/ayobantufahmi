package test;

import java.util.Scanner;
import data.expression.*;
import data.expression.binaryExpressions.*;

public class SubtractExpressionTest{
    public static void main(final String args[]) {
        Scanner in = new Scanner(System.in);

        System.out.print("x: ");
        Double x = in.nextDouble();
        System.out.print("y: ");
        Double y = in.nextDouble();
        TerminalExpression xt = new TerminalExpression(x);
        TerminalExpression yt = new TerminalExpression(y);
        SubtractExpression ae = new SubtractExpression(xt,yt);
        try{        
            System.out.println("x-y = " + ae + " = "+ae.solve());
        }catch (Exception err) {
            err.printStackTrace();
        }

        in.close();
    }
}