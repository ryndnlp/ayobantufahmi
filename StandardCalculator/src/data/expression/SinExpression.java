class SinExpression extends UnaryExpression {
    //protected String symbol = "-";

    public SinExpression(Expression x) {
        symbol = "sin";
        this.x = x;
    }

    public float solve() {
        return (float) Math.sin(x.solve());
    }
}