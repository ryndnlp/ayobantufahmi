package data.expression.unaryExpressions;

import data.expression.Expression;

public class LogarithmicExpression extends UnaryExpression {
    //protected String symbol = "-";
    //protected Expression x;

    public LogarithmicExpression(Expression x) {
        symbol = "log";
        this.x = x;
    }

    public double solve() {
        return (double) Math.log(x.solve());
    }
}
