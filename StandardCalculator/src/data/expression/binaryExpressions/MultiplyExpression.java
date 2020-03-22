package data.expression.binaryExpressions;

import data.expression.Expression;

public class MultiplyExpression extends BinaryExpression<Double> {

    public MultiplyExpression(Expression<Double> x, Expression<Double> y) {
        symbol = "*";
        this.x = x;
        this.y = y;
    }

    public Double solve() {
        return this.x.solve() * this.y.solve();
    }
}
