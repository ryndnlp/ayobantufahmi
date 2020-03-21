package data.expression.unaryExpressions;

import data.expression.Expression;

public class SquareRootExpression extends UnaryExpression {
    //protected String symbol = "-";
    //protected Expression x;

    public SquareRootExpression(Expression x) {
        symbol = "sqrt";
        this.x = x;
    }

    public float solve() {
        return (float) Math.sqrt(x.solve());
    }
}