package test;

import java.util.Scanner;
import data.expression.*;
import data.expression.unaryExpressions.*;
import data.expression.binaryExpressions.*;
import data.exception.*;

public class CosExpressionTest{
    public static void main(final String args[]) {
        Scanner in = new Scanner(System.in);

        System.out.print("x: ");
        Double x = in.nextDouble();
        TerminalExpression xt = new TerminalExpression(x);
        CosExpression ae = new CosExpression(xt);
        try{        
            System.out.println(ae + " = "+ae.solve());
        }catch (Exception err) {
            err.printStackTrace();
        }
    }
}