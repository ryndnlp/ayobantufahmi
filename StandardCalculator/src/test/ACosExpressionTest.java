package test;

import java.util.Scanner;
import data.expression.*;
import data.expression.unaryExpressions.*;
import data.expression.binaryExpressions.*;
import data.exception.*;

public class ACosExpressionTest{
    public static void main(final String args[]) {
        Scanner in = new Scanner(System.in);

        System.out.print("x: ");
        Double x = in.nextDouble();
        TerminalExpression xt = new TerminalExpression(x);
        ACosExpression ae = new ACosExpression(xt);
        try{        
            System.out.println(ae + " = "+ae.solve());
        }catch (Exception err) {
            // TODO Auto-generated catch block
            err.printStackTrace();
        }
    }
}