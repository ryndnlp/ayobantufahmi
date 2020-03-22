package data.expression.binaryExpressions;
import data.exception.*;
import data.expression.Expression;

public class DivisionExpression extends BinaryExpression<Double> {

    public DivisionExpression(Expression<Double> x, Expression<Double> y) {
        symbol = "/";
        this.x = x;
        this.y = y;
    }

    public Double solve() throws Exception{
        if(this.y.solve() == 0){
            throw new NotANumberException();
        }
        return this.x.solve() / this.y.solve();
        
        
    }
}
