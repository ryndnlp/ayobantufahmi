abstract class BinaryExpression extends NonTerminalExpression {
    protected Expression x;
    protected Expression y;

    //abstract public Boolean checkSymbol();
    abstract public float solve();

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
        String s = "";
        System.out.println("Called binary to string");
        //if(x instanceof TerminalExpression) {
            s += x;
        //}
        s+= " " + symbol + " ";
        //String s = x.toString();
        //s += symbol;
        //s += y.toString();
        //if(y instanceof TerminalExpression) {
            s += y;
        //}
        return s;
    }
}