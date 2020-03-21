package data.expression.unaryExpressions;

import data.expression.Expression;

public class TanExpression extends UnaryExpression {
    //protected String symbol = "-";


    public TanExpression(Expression x) {
        symbol = "tan";
        this.x = x;
    }

    public double solve() {
        return (double) Math.tan(x.solve());
    }
}
