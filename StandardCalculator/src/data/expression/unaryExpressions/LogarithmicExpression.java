package data.expression.unaryExpressions;

import data.expression.Expression;

public class LogarithmicExpression extends UnaryExpression<Double> {

    public LogarithmicExpression(Expression<Double> x) {
        symbol = "log";
        this.x = x;
    }

    public Double solve() {
        return (double) Math.log(x.solve());
    }
}
