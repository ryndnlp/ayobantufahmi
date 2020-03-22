package data.expression.binaryExpressions;

import data.expression.Expression;

public class SubtractExpression extends BinaryExpression<Double> {

    public SubtractExpression(Expression<Double> x, Expression<Double> y) {
        symbol = "-";
        this.x = x;
        this.y = y;
    }

    public Double solve() throws Exception {
        return this.x.solve() - this.y.solve();
    }
}
