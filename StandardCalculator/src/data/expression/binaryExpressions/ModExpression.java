package data.expression.binaryExpressions;

import data.expression.Expression;

public class ModExpression extends BinaryExpression<Double> {

    public ModExpression(Expression<Double> x, Expression<Double> y) {
        symbol = "%";
        this.x = x;
        this.y = y;
    }

    public Double solve() {
        return this.x.solve() % this.y.solve();
    }
}
