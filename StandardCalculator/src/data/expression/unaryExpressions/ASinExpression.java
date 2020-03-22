package data.expression.unaryExpressions;

import data.expression.Expression;

public class ASinExpression extends UnaryExpression<Double> {

    public ASinExpression(Expression<Double> x) {
        symbol = "arcsin";
        this.x = x;
    }

    public Double solve() throws Exception {
        return (double) Math.asin(x.solve());
    }
}
