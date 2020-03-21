package data.expression.unaryExpressions;

import data.expression.Expression;

public class ASinExpression extends UnaryExpression {
    //protected String symbol = "-";

    public ASinExpression(Expression x) {
        symbol = "asin";
        this.x = x;
    }

    public float solve() {
        return (float) Math.asin(x.solve());
    }
}