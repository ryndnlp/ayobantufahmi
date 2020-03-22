package data.expression.unaryExpressions;

import data.expression.Expression;

public class NegativeExpression extends UnaryExpression<Double> {

    public NegativeExpression(Expression<Double> x) {
        symbol = "-";
        this.x = x;
    }

    public Double solve() throws Exception {
        return -1 * this.x.solve();
    }
}
