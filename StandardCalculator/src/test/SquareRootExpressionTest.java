package test;

import java.util.Scanner;
import data.expression.*;
import data.expression.unaryExpressions.*;
import data.expression.binaryExpressions.*;
import data.exception.*;

public class SquareRootExpressionTest{
    public static void main(final String args[]) {
        Scanner in = new Scanner(System.in);

        System.out.print("x: ");
        Double x = in.nextDouble();
        TerminalExpression xt = new TerminalExpression(x);
        SquareRootExpression ae = new SquareRootExpression(xt);
        try{        
            System.out.println(ae + " = "+ae.solve());
        }catch(InvalidOperandException err){
            String error = err.printMessage();
        }catch(NotANumberException err){
            String error = err.printMessage();
        }catch (Exception err) {
            // TODO Auto-generated catch block
            // err.printStackTrace();
        }
    }
}