package data.expression.unaryExpressions;

import data.exception.NotANumberException;
import data.expression.Expression;

public class ASinExpression extends UnaryExpression<Double> {

    public ASinExpression(Expression<Double> x) {
        symbol = "arcsin";
        this.x = x;
    }

    public Double solve() throws Exception {
        if(this.x.solve() > 1 || this.x.solve() < -1){
            throw new NotANumberException();
        }
        return (double) Math.asin(x.solve());
    }
}
