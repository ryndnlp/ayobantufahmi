import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class ExpressionDriver {
    static Expression emptyExp = new TerminalExpression(0);
    static Expression[] expressions = {new AddExpression(emptyExp, emptyExp), new SubtractExpression(emptyExp, emptyExp), new MultiplyExpression(emptyExp, emptyExp)};
    
    static String operatorSymbols = "[\\*|\\+|\\-|/]+";
    static String terminalSymbols = "[1234567890\\.]+";
    static String negaOp = "[^\\*|\\+|\\-|/]+";

    static public Expression parse(String inputString) {
        //
        // It might be better to make an actual parser that's closer to a TBFO parser than this...
        // 
        // I'll try on thursday/friday
        //

        //
        //
        /*
            Neo neo neo neo
            How this was meant to work:
                1. Iterate over each index of the input string and check whether it's an operator symbol or an terminal symbol,
                2. Get the substring that is "just" the operator symbol or terminal symbol.
                3. If it's a terminal symbol, try to parse it : throw error if the parser failed (or... just checkSymbol, it should fail if it encounters any weird symbols)
                4. If it's not... make that expression and throw in the terminal expressions in there...
                4.5. Check whether it should be done first or not... If it should be done first, then turn the new expression into the child of the current expression, prefferably the right hand child
                    If it shouldn't be done first, then turn the new expression as the parent of the current expression, the current expression should be the left hand child
                5. Just... keep going until all expressions are parsed into a single expression and return it.
        */
        // None of the codes bellow reflect what I just wrote tho... I kinda gave up...
        //
        //

        String[] terminals = inputString.split(operatorSymbols);
        String[] operators = inputString.split(negaOp);
        
        ArrayList<String> ops = new ArrayList<String>();

        for (String string : operators) {
            if (!string.equals("")) {
                ops.add(string);
            }
        }

        Queue<Expression> queue = new LinkedList<Expression>();

        ArrayList<Expression> parsedExpressions = new ArrayList<Expression>();

        for (String sstring : terminals) {
            System.out.println(sstring + "||");
            
        }
        System.out.println("====");
        for (String sstring : ops) {
            System.out.println(sstring + "||");
            
        }

        for (String op : ops) {
            Expression Ex = null;

            int i = 0;

            if (new AddExpression(emptyExp, emptyExp).checkSymbol(op)) {
                Ex = new AddExpression(emptyExp, emptyExp);
            } else if (new SubtractExpression(emptyExp, emptyExp).checkSymbol(op)) {
                Ex = new SubtractExpression(emptyExp, emptyExp);
            } 

        }

        /*switch (splitString[0]) {
            case :
                
                break;
        
            default:
                break;
        }*/

        return new AddExpression(emptyExp, emptyExp);
    }

    public static void main(String[] args) {
        // just some drivers for the expression classes

        // These are all new because my Linux decided to break on Tuesday... Sorry guys...


        //System.out.println(AddExpression.checkSymbol("+"));
        //System.out.println(AddExpression.checkSymbol("-"));

        /*for (Expression exp : expressions) {
            for (String string : symbols) {
                System.out.println(exp + " " + " to " + string + " is : " + exp.checkSymbol(string));
            }
            System.out.println("=====");
        } */

        parse("5+2*3/2-3.9");

        System.out.println("===");
        System.out.println("===");
        System.out.println("5 * 3 + 2 - 1 = " + (new SubtractExpression(new AddExpression(new MultiplyExpression(new TerminalExpression(5), new TerminalExpression(3)), new TerminalExpression(2)), new TerminalExpression(1)).solve()));
        System.out.println("5 ^ 2 + sqrt(4) = " + (new AddExpression(new PowerToExpression(new TerminalExpression(5), new TerminalExpression(2)), new SquareRootExpression(new TerminalExpression(4))).solve()));

        System.out.println("Sin(30) = " + new SinExpression(new TerminalExpression(30)) + "|| Asin (0.872) = " + new ASinExpression(new TerminalExpression((float)0.872)).solve() );
        System.out.println("Cos(30) = " + new CosExpression(new TerminalExpression(30)) + "|| Acos (0.872) = " + new ACosExpression(new TerminalExpression((float)0.872)).solve() );
        System.out.println("Tan(30) = " + new TanExpression(new TerminalExpression(30)) + "|| Atan (0.872) = " + new ATanExpression(new TerminalExpression((float)0.872)).solve() );

        System.out.println("Log(100) = " + new LogarithmicExpression(new TerminalExpression(100)).solve());
    }
}