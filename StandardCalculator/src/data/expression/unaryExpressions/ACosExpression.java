package data.expression.unaryExpressions;

import data.expression.Expression;

public class ACosExpression extends UnaryExpression {
    //protected String symbol = "-";

    public ACosExpression(Expression x) {
        symbol = "acos";
        this.x = x;
    }

    public double solve() {
        return (double) Math.acos(x.solve());
    }
}
