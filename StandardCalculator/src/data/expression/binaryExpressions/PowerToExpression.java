package data.expression.binaryExpressions;

import data.expression.Expression;

public class PowerToExpression extends BinaryExpression {
    //protected String symbol = "-";

    public PowerToExpression(Expression x, Expression y) {
        symbol = "^";
        this.x = x;
        this.y = y;
    }

    public double solve() {
        return (double) Math.pow(x.solve(), y.solve());
    }
}
