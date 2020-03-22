package test;

import java.util.Scanner;
import data.expression.*;
import data.expression.unaryExpressions.*;
import data.expression.binaryExpressions.*;
import data.exception.*;

public class AddExpressionTest{
    public static void main(final String args[]) {
        Scanner in = new Scanner(System.in);

        System.out.print("x: ");
        Double x = in.nextDouble();
        System.out.print("y: ");
        Double y = in.nextDouble();
        TerminalExpression xt = new TerminalExpression(x);
        TerminalExpression yt = new TerminalExpression(y);
        AddExpression ae = new AddExpression(xt,yt);
        try{        
            System.out.println("x+y = " + ae + " = "+ae.solve());
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