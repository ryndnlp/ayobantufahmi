package data.expression.unaryExpressions;

import data.expression.Expression;

public class SinExpression extends UnaryExpression<Double> {

    public SinExpression(Expression<Double> x) {
        symbol = "sin";
        this.x = x;
    }

    public Double solve() {
        return (double) Math.sin(x.solve());
    }
}
