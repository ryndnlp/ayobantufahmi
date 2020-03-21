package data.expression.unaryExpressions;

import data.expression.Expression;

public class SquareRootExpression extends UnaryExpression {
    //protected String symbol = "-";
    //protected Expression x;

    public SquareRootExpression(Expression x) {
        symbol = "sqrt";
        this.x = x;
    }

    public double solve() {
        return (double) Math.sqrt(x.solve());
    }
}
