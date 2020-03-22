package data.expression;

import data.exception.BracketException;
import data.exception.ChainedOpsException;
import data.exception.InvalidOperandException;
import data.exception.LackOperandException;

//import java.util.function.Predicate;

//import javax.swing.CellEditor;

import data.expression.binaryExpressions.*;
import data.expression.unaryExpressions.*;

public class ExpressionParser {
    static Expression<Double> emptyExp = new TerminalExpression(0);

    Expression<Double> rootExpression = null; // The value that will be returned
    Expression<Double> lastExp = null; // The last operator Expression<Double> that was created

    int subStart = 0; // the substring begins here
    int subEnd = 0; // The substring for checking ends here, will be used to determine the strings
                    // left that need to be processed

    public Expression<Double> parse(final String inputString) throws Exception {

        String stringLeft = inputString.trim().replaceAll(" ", ""); // Removes whitespaces and such
        String checkSub = ""; // Temporary substring holder, used to determine the current expression

        while (!stringLeft.equals("")) { // Will loop until all of the input string has been processed
            findSubstring(stringLeft, subStart, emptyExp, true);

            if (subStart != subEnd) { // there's at least a terminal at the beginning
                checkSub = stringLeft.substring(subStart, subEnd);
                if (!emptyExp.checkSymbol(checkSub)) { // checks if there are double "."
                    throw new InvalidOperandException();
                }

                putTerminalInTree(new TerminalExpression(checkSub)); // Puts the terminal where appropriate

            } else if (stringLeft.substring(0, 1).equals("(") || stringLeft.substring(0, 1).equals(")")) { 
                // The next substring is a sub
                // Expression<Double> (in parentheses)
                checkSub = findSubExpressionString(stringLeft.substring(1), subStart); 
                // Gets the sub Expression<Double> in parentheses WITHOUT the outer parentheses (allows for recursive sub expression)

                final ExpressionParser subParser = new ExpressionParser();
                final Expression<Double> parsedSub = subParser.parse(checkSub);

                if (parsedSub == null) {
                    throw new LackOperandException();
                }

                final Expression<Double> subExpression = new TerminalExpression(parsedSub.solve()); // Gets
                // the expression of the sub expression, to prevent order change, the sub expression is turned into a terminal

                putTerminalInTree(subExpression); // Puts the subexpression in the tree
                lastExp = subExpression;

                subEnd = checkSub.length() + 2; // Will skip through the whole sub Expression<Double> as it was
                                                // processed
                                                // separately, added 2 for the opening and closing brackets

            } else { // It's one of the operator symbols

                /*
                 * Checks the negative and substraction operators
                 */

                if (checkFirstSubSymbol(stringLeft, new NegativeExpression(emptyExp))) { // The negative
                                                                                         // Expression<Double> is a
                                                                                         // special case, as it can
                                                                                         // become a subtraction
                                                                                         // expression
                    if (rootExpression == null) {
                        rootExpression = new NegativeExpression(emptyExp);
                        lastExp = rootExpression;
                    } else if (lastExp instanceof BinaryExpression) {
                        putUnaryInTree(new NegativeExpression(emptyExp));

                    } else {
                        putSimpleBinaryInTree(new SubtractExpression(emptyExp, emptyExp));
                    }
                }

                /*
                 * the other unary operators pretty much work the same way
                 */
                else if (checkFirstSubSymbol(stringLeft, new ASinExpression(emptyExp))) {
                    putUnaryInTree(new ASinExpression(emptyExp));
                } else if (checkFirstSubSymbol(stringLeft, new SinExpression(emptyExp))) {
                    putUnaryInTree(new SinExpression(emptyExp));
                } else if (checkFirstSubSymbol(stringLeft, new ACosExpression(emptyExp))) {
                    putUnaryInTree(new ACosExpression(emptyExp));
                } else if (checkFirstSubSymbol(stringLeft, new CosExpression(emptyExp))) {
                    putUnaryInTree(new CosExpression(emptyExp));
                } else if (checkFirstSubSymbol(stringLeft, new ATanExpression(emptyExp))) {
                    putUnaryInTree(new ATanExpression(emptyExp));
                } else if (checkFirstSubSymbol(stringLeft, new TanExpression(emptyExp))) {
                    putUnaryInTree(new TanExpression(emptyExp));
                } else if (checkFirstSubSymbol(stringLeft, new SquareRootExpression(emptyExp))) {
                    putUnaryInTree(new SquareRootExpression(emptyExp));
                } else if (checkFirstSubSymbol(stringLeft, new LogarithmicExpression(emptyExp))) {
                    putUnaryInTree(new LogarithmicExpression(emptyExp));
                } else if (checkFirstSubSymbol(stringLeft, new LnExpression(emptyExp))) {
                    putUnaryInTree(new LnExpression(emptyExp));
                }
                /*
                 * 
                 * Starts checking the binary operations
                 * 
                 */

                else if (checkFirstSubSymbol(stringLeft, new AddExpression(emptyExp, emptyExp))) {
                    putSimpleBinaryInTree(new AddExpression(emptyExp, emptyExp));
                } else if (checkFirstSubSymbol(stringLeft, new MultiplyExpression(emptyExp, emptyExp))) {
                    putStrongBinaryInTree(new MultiplyExpression(emptyExp, emptyExp));
                } else if (checkFirstSubSymbol(stringLeft, new DivisionExpression(emptyExp, emptyExp))) {
                    putStrongBinaryInTree(new DivisionExpression(emptyExp, emptyExp));
                } else if (checkFirstSubSymbol(stringLeft, new PowerToExpression(emptyExp, emptyExp))) {
                    putStrongBinaryInTree(new PowerToExpression(emptyExp, emptyExp));
                } else if (checkFirstSubSymbol(stringLeft, new ModExpression(emptyExp, emptyExp))) {
                    putStrongBinaryInTree(new ModExpression(emptyExp, emptyExp));
                }

                subEnd = lastExp.getSymbol().length(); // Gets the length of the last operator symbol that needs to be
                                                       // skipped
            }
            stringLeft = stringLeft.substring(subEnd); // Continue on with checking the rest of the string
        }

        // Checks if the expression ended prematurely
        if ((lastExp instanceof UnaryExpression && ((UnaryExpression<Double>) lastExp).getX() == emptyExp)
                || (lastExp instanceof BinaryExpression && ((BinaryExpression<Double>) lastExp).getY() == emptyExp)) {
            throw new LackOperandException();
        }

        return rootExpression;
    }

    private void findSubstring(final String inString, final Integer idxStart, final Expression<Double> testExpression,
            final Boolean match) { // Finds the substring that matches the testExpression's symbol, or one that
                                   // doesn't
        subStart = idxStart;
        subEnd = subStart;

        String checkChar = inString.substring(subEnd, subEnd + 1);

        while ((match && testExpression.checkSymbol(checkChar)) && subEnd < inString.length()) {
            subEnd++;
            if (subEnd < inString.length()) {
                checkChar = inString.substring(subEnd, subEnd + 1);
            }
        }
    }

    private void putTerminalInTree(final Expression<Double> termExp) throws Exception {
        if (rootExpression == null) { // This is the first expression
            rootExpression = termExp;
        } else if (lastExp instanceof UnaryExpression && (((UnaryExpression<Double>) lastExp).getX() == emptyExp)) { 
            // The last expression is empty, might not be the root
            ((UnaryExpression<Double>) lastExp).setX(termExp);
        } else if (lastExp instanceof BinaryExpression && ((((BinaryExpression<Double>) lastExp).getX() == emptyExp)
                || (((BinaryExpression<Double>) lastExp).getY() == emptyExp))) { // The last Expression<Double> has an
                                                                                 // empty "arm",
            // might not be the root
            final BinaryExpression<Double> tempLast = (BinaryExpression<Double>) lastExp;
            if (tempLast.getX() == emptyExp) {
                tempLast.setX(termExp);
            } else {
                tempLast.setY(termExp);
            }
        } else if (rootExpression instanceof BinaryExpression) { // The Root is a binary operator expression, one of
                                                                 // them must be empty otherwise...
            final BinaryExpression<Double> tempRoot = (BinaryExpression<Double>) rootExpression;
            if (tempRoot.getX() == emptyExp) {
                tempRoot.setX(termExp);
            } else {
                tempRoot.setY(termExp);
            }
        } else if (rootExpression instanceof UnaryExpression) { // The Root be a unary operator expression, it must be
                                                                // empty... otherwise...
            final UnaryExpression<Double> tempRoot = (UnaryExpression<Double>) rootExpression;
            tempRoot.setX(termExp);
        }
        lastExp = termExp;
    }

    private String findSubExpressionString(final String inString, final Integer idxStart) throws Exception { 
        // Finds the outermost sub expresion string inside the inString (one within parentheses)

        int innerBracketCounter = 0; // counts how many subexpression the subexpression has
        final int innerSubStart = subStart;
        int checkCharIdx = innerSubStart;

        String checkChar = inString.substring(checkCharIdx, checkCharIdx + 1);
        while (!(checkChar.equals(")") && (innerBracketCounter == 0)) && checkCharIdx < inString.length()) { 
            // will only recognize as done ifthe closing bracket is on the same level as the opening bracking that started this function

            if (checkChar.equals("(")) {
                innerBracketCounter++;
            } else if (checkChar.equals(")")) {
                innerBracketCounter--;
            }
            checkCharIdx++;
            if (checkCharIdx < inString.length()) {
                checkChar = inString.substring(checkCharIdx, checkCharIdx + 1);
            }
        }

        if (checkCharIdx >= inString.length()) { // The substring is unclosed
            throw new BracketException();
        }

        subEnd = checkCharIdx + 1;
        return inString.substring(subStart, subEnd - 1);
    }

    private boolean checkFirstSubSymbol(final String inString, final Expression<Double> expression) { // gets the first
        // substring that matches
        // the expression's symbol
        int expSymbolLen = expression.getSymbol().length();
        if (expSymbolLen > inString.length()) {
            expSymbolLen = inString.length();
        }
        return expression.checkSymbol(inString.substring(0, expSymbolLen));
    }

    private void putUnaryInTree(final UnaryExpression<Double> unaryExp) { // puts the unary in the tree

        if (rootExpression == null) { // This is the first expression
            rootExpression = unaryExp;
        } else if (rootExpression instanceof UnaryExpression) { // if root is a unary, this MUST be its child
            unaryExp.setX(rootExpression);
            rootExpression = unaryExp;
        } else if (rootExpression instanceof BinaryExpression) { // if root is a binary, find a corresponding place
            final BinaryExpression<Double> tempRoot = (BinaryExpression<Double>) rootExpression;
            if (tempRoot.getX() == emptyExp) {
                tempRoot.setX(unaryExp);
            } else {
                tempRoot.setY(unaryExp);
            }
        }
        lastExp = unaryExp;
    }

    private void putSimpleBinaryInTree(final BinaryExpression<Double> binaryExp) throws Exception { // Puts a simple
                                                                                                    // binary
        // Expression<Double> in the tree
        // (simpe as in... it
        // doesn't need to be done
        // first, just need to see
        // when it occurs to
        // determine its priority)
        if (rootExpression == null) { // Binary expressions must be in the middle, since we use infix notations
            throw new LackOperandException();
        }

        if (lastExp instanceof BinaryExpression) {
            throw new ChainedOpsException();
        }

        if (lastExp instanceof UnaryExpression && ((UnaryExpression<Double>) lastExp).getX() == emptyExp) {
            throw new LackOperandException();
        }

        binaryExp.setX(rootExpression);
        rootExpression = binaryExp;
        lastExp = binaryExp;
    }

    private void putStrongBinaryInTree(final BinaryExpression<Double> binaryExp) throws Exception { // Puts a strong
                                                                                                    // binary
        // Expression<Double> in the tree
        // (strong as in... it needs
        // to be done first before
        // the "simple" ones)
        if (rootExpression == null) { // Binary expressions must be in the middle, since we use infix notations
            throw new LackOperandException();
        }

        if (lastExp instanceof BinaryExpression) {
            throw new ChainedOpsException();
        }

        if (lastExp instanceof UnaryExpression && ((UnaryExpression<Double>) lastExp).getX() == emptyExp) {
            throw new LackOperandException();
        }

        if (rootExpression instanceof TerminalExpression || rootExpression instanceof UnaryExpression) {
            // If root is terminal or unary, make this the "father" of it
            binaryExp.setX(rootExpression);
            rootExpression = binaryExp;
        } else if (rootExpression instanceof BinaryExpression) { // if root is binary, check priority and position
            if (rootExpression instanceof AddExpression || rootExpression instanceof SubtractExpression) {
                final BinaryExpression<Double> tempRoot = (BinaryExpression<Double>) rootExpression;
                if (tempRoot.getY() != emptyExp) {
                    binaryExp.setX(tempRoot.getY());

                    tempRoot.setY(binaryExp);
                } else {
                    binaryExp.setX(rootExpression);
                    rootExpression = binaryExp;

                }
            } else {
                binaryExp.setX(rootExpression);
                rootExpression = binaryExp;
            }
        }
        lastExp = binaryExp;
    }
}