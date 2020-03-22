package data.expression.unaryExpressions;

import data.exception.NotANumberException;
import data.expression.Expression;

public class SquareRootExpression extends UnaryExpression<Double> {

    public SquareRootExpression(Expression<Double> x) {
        symbol = "sqrt";
        this.x = x;
    }

    public Double solve() throws Exception {
        if(this.x.solve() < 0){
            throw new NotANumberException();
        }
        return (double) Math.sqrt(x.solve());
    }
}
