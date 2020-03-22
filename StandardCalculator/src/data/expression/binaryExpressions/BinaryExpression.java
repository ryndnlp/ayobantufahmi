package data.expression.binaryExpressions;

import data.expression.*;

public abstract class BinaryExpression<T extends Number> extends NonTerminalExpression<T> {
    protected Expression<T> x;
    protected Expression<T> y;

    abstract public T solve();

    public void setX(Expression<T> expression) {
        this.x = expression;
    }

    public void setY(Expression<T> expression) {
        this.y = expression;
    }

    public Expression<T> getX() {
        return this.x;
    }

    public Expression<T> getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return x + " " + symbol + " " + y;
    }
}
