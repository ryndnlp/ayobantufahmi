package data.expression.binaryExpressions;

import data.expression.*;

public abstract class BinaryExpression extends NonTerminalExpression {
    protected Expression x;
    protected Expression y;

    //abstract public Boolean checkSymbol();
    abstract public double solve();

    public void setX(Expression expression) {
        this.x = expression;
    }

    public void setY(Expression expression) {
        this.y = expression;
    }

    public Expression getX() {
        return this.x;
    }

    public Expression getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return x + " " + symbol + " " + y;
    }
}
