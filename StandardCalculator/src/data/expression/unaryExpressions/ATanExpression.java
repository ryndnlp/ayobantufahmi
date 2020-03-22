package data.expression.unaryExpressions;

import data.expression.Expression;

public class ATanExpression extends UnaryExpression<Double> {

    public ATanExpression(Expression<Double> x) {
        symbol = "atan";
        this.x = x;
    }

    public Double solve() throws Exception {
        return (double) Math.atan(x.solve());
    }
}
