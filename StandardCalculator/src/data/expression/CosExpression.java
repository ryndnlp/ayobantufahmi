class CosExpression extends UnaryExpression {
    //protected String symbol = "-";

    public CosExpression(Expression x) {
        symbol = "cos";
        this.x = x;
    }

    public float solve() {
        return (float) Math.cos(x.solve());
    }
}