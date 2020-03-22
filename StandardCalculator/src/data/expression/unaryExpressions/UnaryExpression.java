package data.expression.unaryExpressions;

import data.expression.*;

public abstract class UnaryExpression<T extends Number> extends NonTerminalExpression<T> {
    protected Expression<T> x;

    abstract public T solve();

    public void setX(Expression<T> expression) {
        this.x = expression;
    }

    public Expression<T> getX() {
        return this.x;
    }

    @Override
    public String toString() {
        return symbol + " " + x;
    }
}
