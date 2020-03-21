package data.expression;

import data.expression.*;
import data.expression.binaryExpressions.*;
import data.expression.unaryExpressions.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class ExpressionDriver {
    static Expression emptyExp = new TerminalExpression(0);
    static Expression[] expressions = { new AddExpression(emptyExp, emptyExp),
            new SubtractExpression(emptyExp, emptyExp), new MultiplyExpression(emptyExp, emptyExp) };

    static String operatorSymbols = "[\\*|\\+|\\-|/]+";
    static String terminalSymbols = "[1234567890\\.]+";
    static String negaOp = "[^\\*|\\+|\\-|/]+";

    static public Expression parse(String inputString) throws Exception {
        //
        // It might be better to make an actual parser that's closer to a TBFO parser
        // than this...
        //
        // I'll try on thursday/friday
        //

        //
        //
        /*
         * Neo neo neo neo How this was meant to work: 1. Iterate over each index of the
         * input string and check whether it's an operator symbol or an terminal symbol,
         * 2. Get the substring that is "just" the operator symbol or terminal symbol.
         * 3. If it's a terminal symbol, try to parse it : throw error if the parser
         * failed (or... just checkSymbol, it should fail if it encounters any weird
         * symbols) 4. If it's not... make that expression and throw in the terminal
         * expressions in there... 4.5. Check whether it should be done first or not...
         * If it should be done first, then turn the new expression into the child of
         * the current expression, prefferably the right hand child If it shouldn't be
         * done first, then turn the new expression as the parent of the current
         * expression, the current expression should be the left hand child 5. Just...
         * keep going until all expressions are parsed into a single expression and
         * return it.
         */
        // None of the codes bellow reflect what I just wrote tho... I kinda gave up...
        //
        //

        TerminalExpression emptyTerminal = new TerminalExpression(0);

        Expression rootExpression = null;
        Expression lastExp = null;

        String stringLeft = inputString.trim().replaceAll(" ", "");
        String checkSub;
        int subStart = 0;
        int subEnd = 0;

        while (!stringLeft.equals("")) {
            //System.out.println("Stringleft is : " + stringLeft);
            int checkCharIdx = 0;
            // String checkChar = String.valueOf(stringLeft.charAt(checkCharIdx));
            String checkChar = stringLeft.substring(checkCharIdx, checkCharIdx + 1);

            // checks for terminals
            //System.out.println("Outer check char : " + checkChar);
            while ((emptyTerminal.checkSymbol(checkChar)) && checkCharIdx < stringLeft.length()) {
                checkCharIdx++;
                if (checkCharIdx < stringLeft.length()) {
                    checkChar = stringLeft.substring(checkCharIdx, checkCharIdx + 1);
                }
                //System.out.println("Outer check char : " + checkChar);
            }

            subEnd = checkCharIdx;

            checkSub = stringLeft.substring(subStart, subEnd);

            //System.out.println("CheckSub is : " + checkSub);

            if (subStart != subEnd) { // There's at least a terminal in the beginning
                //System.out.println("Opening substring is a terminal");
                if (!emptyTerminal.checkSymbol(checkSub)) {
                    //System.out.println(checkSub + " was supposed to be a terminal, but it failed.");
                    throw new Exception("Unknown terminal symbol");
                }

                if (rootExpression == null) { // This is the first expression
                    rootExpression = new TerminalExpression(checkSub);
                } else if (lastExp instanceof UnaryExpression
                        && (((UnaryExpression) lastExp).getX() == emptyTerminal)) {
                    ((UnaryExpression) lastExp).setX(new TerminalExpression(checkSub));
                    // UnaryExpression tempRoot = (UnaryExpression) rootExpression;
                    // if (tempRoot.getX() == emptyTerminal) {
                    // }
                } else if (lastExp instanceof BinaryExpression
                        && ((((BinaryExpression) lastExp).getX() == emptyTerminal)
                                || (((BinaryExpression) lastExp).getY() == emptyTerminal))) { // The Root be a binary
                                                                                              // operator expression
                    BinaryExpression tempLast = (BinaryExpression) lastExp;
                    if (tempLast.getX() == emptyTerminal) {
                        tempLast.setX(new TerminalExpression(checkSub));
                    } else {
                        tempLast.setY(new TerminalExpression(checkSub));
                    }
                } else if (rootExpression instanceof BinaryExpression) { // The Root be a binary operator expression
                    BinaryExpression tempRoot = (BinaryExpression) rootExpression;
                    if (tempRoot.getX() == emptyTerminal) {
                        tempRoot.setX(new TerminalExpression(checkSub));
                    } else {
                        tempRoot.setY(new TerminalExpression(checkSub));
                    }
                } else if (rootExpression instanceof UnaryExpression) { // The Root be a unary operator expression
                    UnaryExpression tempRoot = (UnaryExpression) rootExpression;
                    tempRoot.setX(new TerminalExpression(checkSub));
                } else {
                    System.out.println("Uncaught status");
                }
                // The substring is a valid terminal expression string

            } else { // There's a nonterminal in the beginning of the

                // Loop until a terminal is got
                checkChar = stringLeft.substring(checkCharIdx, checkCharIdx + 1);
                //System.out.println("NonTerm check char : " + checkChar);
                while ((!emptyTerminal.checkSymbol(checkChar)) && checkCharIdx < stringLeft.length()) {
                    if (emptyTerminal.checkSymbol(checkChar)) {
                        break;
                    }
                    checkCharIdx++;
                    if (checkCharIdx < stringLeft.length()) {
                        checkChar = stringLeft.substring(checkCharIdx, checkCharIdx + 1);
                    }
                    //System.out.println("NonTerm check char : " + checkChar);
                }
                subEnd = checkCharIdx;
                checkSub = stringLeft.substring(subStart, subEnd);

                // static String operatorSymbols = "[\\*|\\+|\\-|/]+";
                // static String terminalSymbols = "[1234567890\\.]+";
                // static String negaOp = "[^\\*|\\+|\\-|/]+";

                if (checkSub.substring(0, 1).matches("[\\*|\\+|\\-|/|\\^]*")
                        && !checkSub.replace("[\\*|\\+|\\-|/|\\^]+", "").equals("")) {
                    //System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                    subEnd -= (checkSub.length() - 1);
                    checkSub = checkSub.substring(0, 1);
                }

                //System.out.println("NonTerminal CheckSub is : " + checkSub);

                //System.out.println("Opening substring is a nonterminal");
                if (checkSub.replaceFirst("\\(", "").replaceFirst("\\)", "").equals("")) { // The first substring is
                    // parentheses
                    /*
                     * insert code to recursively handle substrings here
                     */
                    int innerBracketCounter = 0;
                    int innerSubStart = subStart;
                    checkCharIdx = innerSubStart;
                    while (!(checkChar.equals(")") && (innerBracketCounter == 0))
                            && checkCharIdx < stringLeft.length()) {
                        if (checkChar.equals("(")) {
                            innerBracketCounter++;
                        } else if (checkChar.equals(")")) {
                            innerBracketCounter--;
                        }
                        checkCharIdx++;
                        if (checkCharIdx < stringLeft.length()) {
                            checkChar = stringLeft.substring(checkCharIdx, checkCharIdx + 1);
                        }
                    }

                    if (checkCharIdx >= stringLeft.length()) {
                        throw new Exception("Unclosed bracket");
                    }

                    subEnd = checkCharIdx + 1;
                    checkSub = stringLeft.substring(subStart + 1, subEnd - 1);
                    
                    //System.out.println("MAKING SUB EXPRESSION");
                    Expression subExpression = new TerminalExpression(parse(checkSub).solve());

                    if (rootExpression == null) { // This is the first expression
                        rootExpression = subExpression;
                    } else if (lastExp instanceof UnaryExpression
                            && (((UnaryExpression) lastExp).getX() == emptyTerminal)) {
                        ((UnaryExpression) lastExp).setX(subExpression);
                        // UnaryExpression tempRoot = (UnaryExpression) rootExpression;
                        // if (tempRoot.getX() == emptyTerminal) {
                        // }
                    } else if (lastExp instanceof BinaryExpression
                            && ((((BinaryExpression) lastExp).getX() == emptyTerminal)
                                    || (((BinaryExpression) lastExp).getY() == emptyTerminal))) { // The Root be a
                                                                                                  // binary operator
                                                                                                  // expression
                        BinaryExpression tempLast = (BinaryExpression) lastExp;
                        if (tempLast.getX() == emptyTerminal) {
                            tempLast.setX(subExpression);
                        } else {
                            tempLast.setY(subExpression);
                        }
                    } else if (rootExpression instanceof BinaryExpression) { // The Root be a binary operator expression
                        BinaryExpression tempRoot = (BinaryExpression) rootExpression;
                        if (tempRoot.getX() == emptyTerminal) {
                            tempRoot.setX(subExpression);
                        } else {
                            tempRoot.setY(subExpression);
                        }
                    } else if (rootExpression instanceof UnaryExpression) { // The Root be a unary operator expression
                        UnaryExpression tempRoot = (UnaryExpression) rootExpression;
                        tempRoot.setX(subExpression);
                    } else {
                        System.out.println("Uncaught status");
                    }

                } else { // checks for other operators
                    checkSub = checkSub.replaceFirst("\\(", "").replaceFirst("\\)", "");
                    switch (checkSub.toLowerCase()) {
                        //
                        // Checks for unary expressions first
                        //
                        case "-": {
                            if (rootExpression == null) {
                                rootExpression = new NegativeExpression(emptyTerminal);
                            } else {
                                rootExpression = new SubtractExpression(rootExpression, emptyTerminal);
                            }
                            break;
                        }

                        case "asin": {
                            ASinExpression tempExp = new ASinExpression(emptyTerminal);
                            lastExp = tempExp;

                            if (rootExpression == null) {
                                rootExpression = tempExp;
                            } else if (rootExpression instanceof UnaryExpression) {
                                tempExp.setX(rootExpression);
                                rootExpression = tempExp;
                            } else if (rootExpression instanceof BinaryExpression) {
                                BinaryExpression tempRoot = (BinaryExpression) rootExpression;
                                if (tempRoot.getX() == emptyTerminal) {
                                    tempRoot.setX(tempExp);
                                } else {
                                    tempRoot.setY(tempExp);
                                }
                            }
                            break;
                        }

                        case "sin": {
                            SinExpression tempExp = new SinExpression(emptyTerminal);
                            lastExp = tempExp;

                            if (rootExpression == null) {
                                rootExpression = tempExp;
                            } else if (rootExpression instanceof UnaryExpression) {
                                tempExp.setX(rootExpression);
                                rootExpression = tempExp;
                            } else if (rootExpression instanceof BinaryExpression) {
                                BinaryExpression tempRoot = (BinaryExpression) rootExpression;
                                if (tempRoot.getX() == emptyTerminal) {
                                    tempRoot.setX(tempExp);
                                } else {
                                    tempRoot.setY(tempExp);
                                }
                            }
                            break;
                        }

                        case "acos": {
                            ACosExpression tempExp = new ACosExpression(emptyTerminal);
                            lastExp = tempExp;

                            if (rootExpression == null) {
                                rootExpression = tempExp;
                            } else if (rootExpression instanceof UnaryExpression) {
                                tempExp.setX(rootExpression);
                                rootExpression = tempExp;
                            } else if (rootExpression instanceof BinaryExpression) {
                                BinaryExpression tempRoot = (BinaryExpression) rootExpression;
                                if (tempRoot.getX() == emptyTerminal) {
                                    tempRoot.setX(tempExp);
                                } else {
                                    tempRoot.setY(tempExp);
                                }
                            }
                            break;
                        }

                        case "cos": {
                            CosExpression tempExp = new CosExpression(emptyTerminal);
                            lastExp = tempExp;

                            if (rootExpression == null) {
                                rootExpression = tempExp;
                            } else if (rootExpression instanceof UnaryExpression) {
                                tempExp.setX(rootExpression);
                                rootExpression = tempExp;
                            } else if (rootExpression instanceof BinaryExpression) {
                                BinaryExpression tempRoot = (BinaryExpression) rootExpression;
                                if (tempRoot.getX() == emptyTerminal) {
                                    tempRoot.setX(tempExp);
                                } else {
                                    tempRoot.setY(tempExp);
                                }
                            }
                            break;
                        }

                        case "atan": {
                            ATanExpression tempExp = new ATanExpression(emptyTerminal);
                            lastExp = tempExp;

                            if (rootExpression == null) {
                                rootExpression = tempExp;
                            } else if (rootExpression instanceof UnaryExpression) {
                                tempExp.setX(rootExpression);
                                rootExpression = tempExp;
                            } else if (rootExpression instanceof BinaryExpression) {
                                BinaryExpression tempRoot = (BinaryExpression) rootExpression;
                                if (tempRoot.getX() == emptyTerminal) {
                                    tempRoot.setX(tempExp);
                                } else {
                                    tempRoot.setY(tempExp);
                                }
                            }
                            break;
                        }

                        case "tan": {
                            TanExpression tempExp = new TanExpression(emptyTerminal);
                            lastExp = tempExp;

                            if (rootExpression == null) {
                                rootExpression = tempExp;
                            } else if (rootExpression instanceof UnaryExpression) {
                                tempExp.setX(rootExpression);
                                rootExpression = tempExp;
                            } else if (rootExpression instanceof BinaryExpression) {
                                BinaryExpression tempRoot = (BinaryExpression) rootExpression;
                                if (tempRoot.getX() == emptyTerminal) {
                                    tempRoot.setX(tempExp);
                                } else {
                                    tempRoot.setY(tempExp);
                                }
                            }
                            break;
                        }

                        case "sqrt": {
                            SquareRootExpression tempExp = new SquareRootExpression(emptyTerminal);
                            lastExp = tempExp;

                            if (rootExpression == null) {
                                rootExpression = tempExp;
                            } else if (rootExpression instanceof UnaryExpression) {
                                tempExp.setX(rootExpression);
                                rootExpression = tempExp;
                            } else if (rootExpression instanceof BinaryExpression) {
                                BinaryExpression tempRoot = (BinaryExpression) rootExpression;
                                if (tempRoot.getX() == emptyTerminal) {
                                    tempRoot.setX(tempExp);
                                } else {
                                    tempRoot.setY(tempExp);
                                }
                            }
                            break;
                        }

                        case "log": {
                            LogarithmicExpression tempExp = new LogarithmicExpression(emptyTerminal);
                            lastExp = tempExp;

                            if (rootExpression == null) {
                                rootExpression = tempExp;
                            } else if (rootExpression instanceof UnaryExpression) {
                                tempExp.setX(rootExpression);
                                rootExpression = tempExp;
                            } else if (rootExpression instanceof BinaryExpression) {
                                BinaryExpression tempRoot = (BinaryExpression) rootExpression;
                                if (tempRoot.getX() == emptyTerminal) {
                                    tempRoot.setX(tempExp);
                                } else {
                                    tempRoot.setY(tempExp);
                                }
                            }
                            break;
                        }

                        //
                        // Binary Operators
                        //

                        case "+": {
                            AddExpression tempExp = new AddExpression(emptyTerminal, emptyTerminal);
                            lastExp = tempExp;

                            if (rootExpression == null) {
                                throw new Exception("Binary expression has no expression on left hand side");
                                // rootExpression = tempExp;
                            } /*
                               * else if (rootExpression instanceof TerminalExpression) { rootExpression =
                               * tempExp; tempExp.setX(rootExpression); } else if (rootExpression instanceof
                               * UnaryExpression) { rootExpression = tempExp; tempExp.setX(rootExpression); }
                               */

                            tempExp.setX(rootExpression);
                            rootExpression = tempExp;
                            break;
                        }

                        case "*": {
                            MultiplyExpression tempExp = new MultiplyExpression(emptyTerminal, emptyTerminal);
                            lastExp = tempExp;

                            if (rootExpression == null) {
                                throw new Exception("Binary expression has no expression on left hand side");
                                // rootExpression = tempExp;
                            } else if (rootExpression instanceof TerminalExpression) {
                                tempExp.setX(rootExpression);
                                rootExpression = tempExp;
                            } else if (rootExpression instanceof UnaryExpression) {
                                tempExp.setX(rootExpression);
                                rootExpression = tempExp;
                            } else if (rootExpression instanceof BinaryExpression) {
                                if (rootExpression.checkSymbol("+") || rootExpression.checkSymbol("-")) {
                                    BinaryExpression tempRoot = (BinaryExpression) rootExpression;
                                    if (tempRoot.getY() != emptyTerminal) {
                                        tempExp.setX(tempRoot.getY());
                                        //System.out.println("Root Y : " + tempRoot.getY());
                                        //System.out.println("Neo X : " + tempExp.getX());
                                        //System.out.println("X of mult is Y");
                                    }
                                    //System.out.println("Making mult a child of...");
                                    tempRoot.setY(tempExp);
                                } else {
                                    // BinaryExpression tempRoot = (BinaryExpression) rootExpression;
                                    tempExp.setX(rootExpression);
                                    rootExpression = tempExp;

                                }
                            }
                            break;
                        }

                        case "^": {
                            PowerToExpression tempExp = new PowerToExpression(emptyTerminal, emptyTerminal);
                            lastExp = tempExp;

                            if (rootExpression == null) {
                                throw new Exception("Binary expression has no expression on left hand side");
                                // rootExpression = tempExp;
                            } else if (rootExpression instanceof TerminalExpression) {
                                tempExp.setX(rootExpression);
                                rootExpression = tempExp;
                            } else if (rootExpression instanceof UnaryExpression) {
                                tempExp.setX(rootExpression);
                                rootExpression = tempExp;
                            } else if (rootExpression instanceof BinaryExpression) {
                                BinaryExpression tempRoot = (BinaryExpression) rootExpression;
                                if (tempRoot.getY() != emptyTerminal) {
                                    tempExp.setX(tempRoot.getY());
                                    // System.out.println("Root Y : " + tempRoot.getY());
                                    // System.out.println("Neo X : " + tempExp.getX());
                                    // System.out.println("X of mult is Y");
                                }
                                //System.out.println("Making mult a child of...");
                                tempRoot.setY(tempExp);
                            }
                            break;
                        }

                        case "/": {
                            DivisionExpression tempExp = new DivisionExpression(emptyTerminal, emptyTerminal);
                            lastExp = tempExp;

                            if (rootExpression == null) {
                                throw new Exception("Binary expression has no expression on left hand side");
                                // rootExpression = tempExp;
                            } else if (rootExpression instanceof TerminalExpression) {
                                tempExp.setX(rootExpression);
                                rootExpression = tempExp;
                            } else if (rootExpression instanceof UnaryExpression) {
                                tempExp.setX(rootExpression);
                                rootExpression = tempExp;
                            } else if (rootExpression instanceof BinaryExpression) {
                                if (rootExpression.checkSymbol("+") || rootExpression.checkSymbol("-")) {
                                    BinaryExpression tempRoot = (BinaryExpression) rootExpression;
                                    if (tempRoot.getY() != emptyTerminal) {
                                        tempExp.setX(tempRoot.getY());
                                        // System.out.println("Root Y : " + tempRoot.getY());
                                        // System.out.println("Neo X : " + tempExp.getX());
                                        // System.out.println("X of mult is Y");
                                    }
                                    //System.out.println("Making mult a child of...");
                                    tempRoot.setY(tempExp);
                                } else {
                                    // BinaryExpression tempRoot = (BinaryExpression) rootExpression;
                                    tempExp.setX(rootExpression);
                                    rootExpression = tempExp;

                                }
                            }
                            break;
                        }

                        case "%": {
                            ModExpression tempExp = new ModExpression(emptyTerminal, emptyTerminal);
                            lastExp = tempExp;

                            if (rootExpression == null) {
                                throw new Exception("Binary expression has no expression on left hand side");
                                // rootExpression = tempExp;
                            } else if (rootExpression instanceof TerminalExpression) {
                                tempExp.setX(rootExpression);
                                rootExpression = tempExp;
                            } else if (rootExpression instanceof UnaryExpression) {
                                tempExp.setX(rootExpression);
                                rootExpression = tempExp;
                            } else if (rootExpression instanceof BinaryExpression) {
                                if (rootExpression.checkSymbol("+") || rootExpression.checkSymbol("-")) {
                                    BinaryExpression tempRoot = (BinaryExpression) rootExpression;
                                    if (tempRoot.getY() != emptyTerminal) {
                                        tempExp.setX(tempRoot.getY());
                                        // System.out.println("Root Y : " + tempRoot.getY());
                                        // System.out.println("Neo X : " + tempExp.getX());
                                        // System.out.println("X of mult is Y");
                                    }
                                    //System.out.println("Making mult a child of...");
                                    tempRoot.setY(tempExp);
                                } else {
                                    // BinaryExpression tempRoot = (BinaryExpression) rootExpression;
                                    tempExp.setX(rootExpression);
                                    rootExpression = tempExp;

                                }
                            }
                            break;
                        }

                        default:
                            throw new Exception("No matching expression found");
                        // break;
                    }
                }
            }

            stringLeft = stringLeft.substring(subEnd);
        }

        return rootExpression;

        /*
         * String[] terminals = inputString.split(operatorSymbols); String[] operators =
         * inputString.split(negaOp);
         * 
         * ArrayList<String> ops = new ArrayList<String>();
         * 
         * for (String string : operators) { if (!string.equals("")) { ops.add(string);
         * } }
         * 
         * Queue<Expression> queue = new LinkedList<Expression>();
         * 
         * ArrayList<Expression> parsedExpressions = new ArrayList<Expression>();
         * 
         * for (String sstring : terminals) { System.out.println(sstring + "||");
         * 
         * } System.out.println("===="); for (String sstring : ops) {
         * System.out.println(sstring + "||");
         * 
         * }
         * 
         * for (String op : ops) { Expression Ex = null;
         * 
         * int i = 0;
         * 
         * if (new AddExpression(emptyExp, emptyExp).checkSymbol(op)) { Ex = new
         * AddExpression(emptyExp, emptyExp); } else if (new
         * SubtractExpression(emptyExp, emptyExp).checkSymbol(op)) { Ex = new
         * SubtractExpression(emptyExp, emptyExp); }
         * 
         * }
         * 
         * /* switch (splitString[0]) { case :
         * 
         * break;
         * 
         * default: break; }
         */

        /*
         * return new AddExpression(emptyExp, emptyExp);
         */
    }

    public static void main(String[] args) {
        // just some drivers for the expression classes

        // These are all new because my Linux decided to break on Tuesday... Sorry
        // guys...

        // System.out.println(AddExpression.checkSymbol("+"));
        // System.out.println(AddExpression.checkSymbol("-"));

        /*
         * for (Expression exp : expressions) { for (String string : symbols) {
         * System.out.println(exp + " " + " to " + string + " is : " +
         * exp.checkSymbol(string)); } System.out.println("====="); }
         */
        String inString = "3 * 2 + (5 * (19 + 1)) * (11 % 2) + 1";

        TerminalExpression tExpression = new TerminalExpression(50);
        System.out.println("===");
        System.out.println("tExpression = " + tExpression);

        AddExpression aExpression = new AddExpression(new TerminalExpression(50), new TerminalExpression(20));
        System.out.println("===");
        System.out.println("aExpression = " + aExpression);

        NegativeExpression nExpression = new NegativeExpression(new TerminalExpression(30));
        System.out.println("===");
        System.out.println("nExpression = " + nExpression);

        System.out.println("===");
        System.out.println("===");
        System.out.println("===");
        Expression outExp = null;
        try {
            // outExp = parse("5+2*3/2-3.9");
            outExp = parse(inString);
            System.out.println("outEXP = " + outExp);
            System.out.println(inString + " => " + outExp.solve());

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("===");
        System.out.println("===");
        System.out
                .println(
                        "5 * 3 + 2 - 1 = "
                                + (new SubtractExpression(
                                        new AddExpression(new MultiplyExpression(new TerminalExpression(5),
                                                new TerminalExpression(3)), new TerminalExpression(2)),
                                        new TerminalExpression(1)).solve()));
        System.out.println("5 ^ 2 + sqrt(4) = "
                + (new AddExpression(new PowerToExpression(new TerminalExpression(5), new TerminalExpression(2)),
                        new SquareRootExpression(new TerminalExpression(4))).solve()));

        System.out.println("Sin(30) = " + new SinExpression(new TerminalExpression(30)) + "|| Asin (0.872) = "
                + new ASinExpression(new TerminalExpression((float) 0.872)).solve());
        System.out.println("Cos(30) = " + new CosExpression(new TerminalExpression(30)) + "|| Acos (0.872) = "
                + new ACosExpression(new TerminalExpression((float) 0.872)).solve());
        System.out.println("Tan(30) = " + new TanExpression(new TerminalExpression(30)) + "|| Atan (0.872) = "
                + new ATanExpression(new TerminalExpression((float) 0.872)).solve());

        System.out.println("Log(100) = " + new LogarithmicExpression(new TerminalExpression(100)).solve());
    }
}