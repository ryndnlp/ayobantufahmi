package data.expression.binaryExpressions;

import data.expression.Expression;

public class PowerToExpression extends BinaryExpression<Double> {

    public PowerToExpression(Expression<Double> x, Expression<Double> y) {
        symbol = "^";
        this.x = x;
        this.y = y;
    }

    public Double solve() throws Exception {
        return (double) Math.pow(x.solve(), y.solve());
    }
}
