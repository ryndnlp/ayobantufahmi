package data.expression.unaryExpressions;

import data.exception.NotANumberException;
import data.expression.Expression;

public class ACosExpression extends UnaryExpression<Double> {

    public ACosExpression(Expression<Double> x) {
        symbol = "arccos";
        this.x = x;
    }

    public Double solve() throws Exception {
        if(this.x.solve() > 1 || this.x.solve() < -1){
            throw new NotANumberException();
        }
        return (double) Math.acos(x.solve());

    }
}
