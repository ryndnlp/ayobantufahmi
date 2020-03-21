package data.expression.unaryExpressions;

import data.expression.Expression;

public class SinExpression extends UnaryExpression {
    //protected String symbol = "-";

    public SinExpression(Expression x) {
        symbol = "sin";
        this.x = x;
    }

    public double solve() {
        return (double) Math.sin(x.solve());
    }
}
