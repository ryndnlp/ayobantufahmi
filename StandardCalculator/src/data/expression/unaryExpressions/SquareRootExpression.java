package data.expression.unaryExpressions;

import data.expression.Expression;

public class SquareRootExpression extends UnaryExpression<Double> {

    public SquareRootExpression(Expression<Double> x) {
        symbol = "sqrt";
        this.x = x;
    }

    public Double solve() {
        return (double) Math.sqrt(x.solve());
    }
}
