package data.expression.unaryExpressions;

import data.expression.Expression;

public class NegativeExpression extends UnaryExpression {
    //protected String symbol = "-";
    //protected Expression x;

    public NegativeExpression(Expression x) {
        symbol = "-";
        this.x = x;
    }

    public double solve() {
        return -1 * this.x.solve();
    }
}
