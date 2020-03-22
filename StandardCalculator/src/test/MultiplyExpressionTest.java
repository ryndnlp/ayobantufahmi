package test;

import java.util.Scanner;
import data.expression.*;
import data.expression.unaryExpressions.*;
import data.expression.binaryExpressions.*;
import data.exception.*;

public class MultiplyExpressionTest{
    public static void main(final String args[]) {
        Scanner in = new Scanner(System.in);

        System.out.print("x: ");
        Double x = in.nextDouble();
        System.out.print("y: ");
        Double y = in.nextDouble();
        TerminalExpression xt = new TerminalExpression(x);
        TerminalExpression yt = new TerminalExpression(y);
        MultiplyExpression ae = new MultiplyExpression(xt,yt);
        try{        
            System.out.println("x*y = " + ae + " = "+ae.solve());
        }catch(InvalidOperandException err){
            String error = err.PrintMessage();
        }catch(NotANumberException err){
            String error = err.PrintMessage();
        }catch (Exception err) {
            // TODO Auto-generated catch block
            // err.printStackTrace();
        }
    }
}