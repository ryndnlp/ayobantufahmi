package data.expression.unaryExpressions;

import data.expression.Expression;

public class ASinExpression extends UnaryExpression<Double> {

    public ASinExpression(Expression<Double> x) {
        symbol = "asin";
        this.x = x;
    }

    public Double solve() {
        return (double) Math.asin(x.solve());
    }
}
