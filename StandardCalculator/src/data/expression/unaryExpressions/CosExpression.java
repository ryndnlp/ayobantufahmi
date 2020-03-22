package data.expression.unaryExpressions;

import data.expression.Expression;

public class CosExpression extends UnaryExpression<Double> {

    public CosExpression(Expression<Double> x) {
        symbol = "cos";
        this.x = x;
    }

    public Double solve() {
        return (double) Math.cos(x.solve());
    }
}
