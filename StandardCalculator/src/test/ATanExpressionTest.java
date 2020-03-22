package test;

import java.util.Scanner;
import data.expression.*;
import data.expression.unaryExpressions.*;

public class ATanExpressionTest{
    public static void main(final String args[]) {
        Scanner in = new Scanner(System.in);

        System.out.print("x: ");
        Double x = in.nextDouble();
        TerminalExpression xt = new TerminalExpression(x);
        ATanExpression ae = new ATanExpression(xt);
        try{        
            System.out.println(ae + " = "+ae.solve());
        }catch (Exception err) {
            err.printStackTrace();
        }

        in.close();
    }
}