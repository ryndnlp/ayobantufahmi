package data.expression.unaryExpressions;

import data.expression.Expression;

public class TanExpression extends UnaryExpression<Double> {


    public TanExpression(Expression<Double> x) {
        symbol = "tan";
        this.x = x;
    }

    public Double solve() {
        return (double) Math.tan(x.solve());
    }
}
