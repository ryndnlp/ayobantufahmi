package data.expression.unaryExpressions;

import data.expression.Expression;

public class NegativeExpression extends UnaryExpression<Double> {

    public NegativeExpression(Expression<Double> x) {
        symbol = "-";
        this.x = x;
    }

    public Double solve() throws Exception {
        if (this.x.solve() == 0) {
            return (double) 0;
        }

        return -1 * this.x.solve();
    }
}
