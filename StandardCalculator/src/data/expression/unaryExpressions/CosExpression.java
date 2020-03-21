package data.expression.unaryExpressions;

import data.expression.Expression;

public class CosExpression extends UnaryExpression {
    //protected String symbol = "-";

    public CosExpression(Expression x) {
        symbol = "cos";
        this.x = x;
    }

    public double solve() {
        return (double) Math.cos(x.solve());
    }
}
