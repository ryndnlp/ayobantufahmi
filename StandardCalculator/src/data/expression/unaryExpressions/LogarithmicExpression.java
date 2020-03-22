package data.expression.unaryExpressions;

import data.expression.Expression;
import data.exception.NotANumberException;

public class LogarithmicExpression extends UnaryExpression<Double> {

    public LogarithmicExpression(Expression<Double> x) {
        symbol = "log";
        this.x = x;
    }

    public Double solve() throws Exception {
    if(this.x.solve() <= 0){
        throw new NotANumberException();
    }
        return (double) Math.log10(x.solve());
    }
}
