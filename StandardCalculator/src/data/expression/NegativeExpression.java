class NegativeExpression extends UnaryExpression {
    //protected String symbol = "-";
    //protected Expression x;

    public NegativeExpression(Expression x) {
        symbol = "-";
        this.x = x;
    }

    public float solve() {
        return -1 * this.x.solve();
    }
}