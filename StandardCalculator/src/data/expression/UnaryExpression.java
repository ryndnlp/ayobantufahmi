abstract class UnaryExpression extends NonTerminalExpression {
    protected Expression x;

    //abstract public Boolean checkSymbol();
    abstract public float solve();

    public void setX(Expression expression) {
        this.x = expression;
    }

    public Expression getX() {
        return this.x;
    }

    @Override
    public String toString() {
        System.out.println("Called unary to string");
        return new String(symbol + x);
    }
}