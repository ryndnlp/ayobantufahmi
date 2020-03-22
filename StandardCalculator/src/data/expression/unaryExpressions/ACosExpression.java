package data.expression.unaryExpressions;

import data.expression.Expression;

public class ACosExpression extends UnaryExpression<Double> {

    public ACosExpression(Expression<Double> x) {
        symbol = "arccos";
        this.x = x;
    }

    public Double solve() throws Exception {
        return (double) Math.acos(x.solve());
    }
}
