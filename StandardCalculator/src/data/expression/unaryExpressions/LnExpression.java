package data.expression.unaryExpressions;

import data.expression.Expression;
import data.exception.NotANumberException;

public class LnExpression extends UnaryExpression<Double> {

    public LnExpression(Expression<Double> x) {
        symbol = "ln";
        this.x = x;
    }

    public Double solve() throws Exception {
    if(this.x.solve() <= 0){
        throw new NotANumberException();
    }
        return (double) Math.log(x.solve());
    }
}
