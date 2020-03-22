package test;

import data.expression.binaryExpressions.*;
import java.util.Scanner;
import data.expression.*;

public class AddExpressionTest{
    public static void main(final String args[]) {
        Scanner in = new Scanner(System.in);
        // try{
            System.out.print("x: ");
            Double a = in.nextDouble();
            System.out.print("y: ");
            Double b = in.nextDouble();
            TerminalExpression x = new TerminalExpression(a);
            TerminalExpression y = new TerminalExpression(b);
            AddExpression tempExp = new AddExpression(x,y);
        
            System.out.println("x+y = " + tempExp.solve());
        // }catch(InvalidOperandException err){
        //     String error = err.PrintMessage();
        // }catch(NotANumberException err){
        //     String error = err.PrintMessage();
        // }catch (Exception err) {
        //     // TODO Auto-generated catch block
        //     // err.printStackTrace();
        // }
    }
}