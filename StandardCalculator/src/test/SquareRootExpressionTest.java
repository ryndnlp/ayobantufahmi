package test;

import java.util.Scanner;
import data.expression.*;
import data.expression.unaryExpressions.*;

public class SquareRootExpressionTest{
    public static void main(final String args[]) {
        Scanner in = new Scanner(System.in);

        System.out.print("x: ");
        Double x = in.nextDouble();
        TerminalExpression xt = new TerminalExpression(x);
        SquareRootExpression ae = new SquareRootExpression(xt);
        try{        
            System.out.println(ae + " = "+ae.solve());
        }catch (Exception err) {
            err.printStackTrace();
        }

        in.close();
    }
}