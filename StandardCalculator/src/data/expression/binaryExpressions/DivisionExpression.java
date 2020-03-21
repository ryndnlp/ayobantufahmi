package data.expression.binaryExpressions;

import data.expression.Expression;

public class DivisionExpression extends BinaryExpression {
    //static private String symbol = "*";
    //String symbol = "-";

    public DivisionExpression(Expression x, Expression y) {
        symbol = "/";
        this.x = x;
        this.y = y;
    }

    /*static public boolean checkSymbol(String inputString) {
        inputString.replaceAll(" ", "");
        return inputString.equals(symbol) ? true : false;
    }*/

    public float solve() {
        return this.x.solve() / this.y.solve();
    }
}