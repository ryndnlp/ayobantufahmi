package data.expression.unaryExpressions;

import data.expression.*;

public abstract class UnaryExpression extends NonTerminalExpression {
    protected Expression x;

    //abstract public Boolean checksSymbol();
    abstract public float solve();

    public void setX(Expression expression) {
        this.x = expression;
    }

    public Expression getX() {
        return this.x;
    }

    @Override
    public String toString() {
        return symbol + " " + x;
    }
}